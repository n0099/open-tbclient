package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.o.p;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public NavigationBar mNavigationBar;
    private String dPl = null;
    private TextView mTextView = null;
    private TextView dPz = null;
    LinearLayout awD = null;

    public static void ae(Context context, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarSuccessActivity.class);
            intent.putExtra("barname", str);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.create_bar_success_activity);
        initData();
        aCu();
    }

    private void initData() {
        this.dPl = getIntent().getStringExtra("barname");
        if (this.dPl == null) {
            this.dPl = "";
        }
    }

    private void aCu() {
        this.awD = (LinearLayout) findViewById(d.g.container);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.title);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() + layoutParams.height;
            relativeLayout.setLayoutParams(layoutParams);
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.k.create_bar));
        this.mTextView = (TextView) findViewById(d.g.text);
        this.dPz = (TextView) findViewById(d.g.text_more);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.awD);
        boolean ip = new p().ip();
        String string = ip ? getPageContext().getString(d.k.create_bar_new_tip) : getPageContext().getString(d.k.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(ip ? string + this.dPl + getPageContext().getString(d.k.create_bar_new_tip2) : string + this.dPl + getPageContext().getString(d.k.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(d.C0142d.common_color_10252)), length, this.dPl.length() + length, 33);
        this.mTextView.setText(spannableString);
        this.dPz.setVisibility(ip ? 0 : 8);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

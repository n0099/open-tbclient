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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.o.n;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public NavigationBar mNavigationBar;
    private String dzG = null;
    private TextView mTextView = null;
    private TextView dzV = null;
    LinearLayout anM = null;

    public static void ac(Context context, String str) {
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
        awX();
    }

    private void initData() {
        this.dzG = getIntent().getStringExtra("barname");
        if (this.dzG == null) {
            this.dzG = "";
        }
    }

    private void awX() {
        this.anM = (LinearLayout) findViewById(d.g.container);
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
        this.dzV = (TextView) findViewById(d.g.text_more);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.anM);
        boolean fz = new n().fz();
        String string = fz ? getPageContext().getString(d.k.create_bar_new_tip) : getPageContext().getString(d.k.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(fz ? string + this.dzG + getPageContext().getString(d.k.create_bar_new_tip2) : string + this.dzG + getPageContext().getString(d.k.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.common_color_10252)), length, this.dzG.length() + length, 33);
        this.mTextView.setText(spannableString);
        this.dzV.setVisibility(fz ? 0 : 8);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

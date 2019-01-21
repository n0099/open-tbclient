package com.baidu.tieba.home;

import android.app.Activity;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.p.p;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public NavigationBar mNavigationBar;
    private String esQ = null;
    private TextView mTextView = null;
    private TextView etf = null;
    LinearLayout aIT = null;

    public static void aw(Context context, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarSuccessActivity.class);
            intent.putExtra("barname", str);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.create_bar_success_activity);
        initData();
        aLh();
    }

    private void initData() {
        this.esQ = getIntent().getStringExtra("barname");
        if (this.esQ == null) {
            this.esQ = "";
        }
    }

    private void aLh() {
        this.aIT = (LinearLayout) findViewById(e.g.container);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.title);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() + layoutParams.height;
            relativeLayout.setLayoutParams(layoutParams);
        }
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(e.j.create_bar));
        this.mTextView = (TextView) findViewById(e.g.text);
        this.etf = (TextView) findViewById(e.g.text_more);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.aIT);
        boolean jJ = new p().jJ();
        String string = jJ ? getPageContext().getString(e.j.create_bar_new_tip) : getPageContext().getString(e.j.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(jJ ? string + this.esQ + getPageContext().getString(e.j.create_bar_new_tip2) : string + this.esQ + getPageContext().getString(e.j.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(e.d.common_color_10252)), length, this.esQ.length() + length, 33);
        this.mTextView.setText(spannableString);
        this.etf.setVisibility(jJ ? 0 : 8);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

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
import com.baidu.tbadk.s.q;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public NavigationBar mNavigationBar;
    private String fFb = null;
    private TextView mTextView = null;
    private TextView fFp = null;
    LinearLayout bRq = null;

    public static void aJ(Context context, String str) {
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
        setContentView(d.h.create_bar_success_activity);
        initData();
        bll();
    }

    private void initData() {
        this.fFb = getIntent().getStringExtra("barname");
        if (this.fFb == null) {
            this.fFb = "";
        }
    }

    private void bll() {
        this.bRq = (LinearLayout) findViewById(d.g.container);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.title);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() + layoutParams.height;
            relativeLayout.setLayoutParams(layoutParams);
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.create_bar));
        this.mTextView = (TextView) findViewById(d.g.text);
        this.fFp = (TextView) findViewById(d.g.text_more);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.bRq);
        boolean jK = new q().jK();
        String string = jK ? getPageContext().getString(d.j.create_bar_new_tip) : getPageContext().getString(d.j.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(jK ? string + this.fFb + getPageContext().getString(d.j.create_bar_new_tip2) : string + this.fFb + getPageContext().getString(d.j.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.common_color_10252)), length, this.fFb.length() + length, 33);
        this.mTextView.setText(spannableString);
        this.fFp.setVisibility(jK ? 0 : 8);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.o.n;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public NavigationBar mNavigationBar;
    private String efa = null;
    private TextView ry = null;
    private TextView efp = null;
    LinearLayout bct = null;

    public static void ah(Context context, String str) {
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
        setContentView(d.h.create_bar_success_activity);
        initData();
        aCb();
    }

    private void initData() {
        this.efa = getIntent().getStringExtra("barname");
        if (this.efa == null) {
            this.efa = "";
        }
    }

    private void aCb() {
        this.bct = (LinearLayout) findViewById(d.g.container);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.title);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() + layoutParams.height;
            relativeLayout.setLayoutParams(layoutParams);
        }
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.create_bar));
        this.ry = (TextView) findViewById(d.g.text);
        this.efp = (TextView) findViewById(d.g.text_more);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.bct);
        boolean nv = new n().nv();
        String string = nv ? getPageContext().getString(d.j.create_bar_new_tip) : getPageContext().getString(d.j.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(nv ? string + this.efa + getPageContext().getString(d.j.create_bar_new_tip2) : string + this.efa + getPageContext().getString(d.j.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.common_color_10252)), length, this.efa.length() + length, 33);
        this.ry.setText(spannableString);
        this.efp.setVisibility(nv ? 0 : 8);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

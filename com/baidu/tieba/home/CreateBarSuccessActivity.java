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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.switchs.CreateBarTipSwitch;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public NavigationBar mNavigationBar;
    private String jVu = null;
    private TextView mTextView = null;
    private TextView jVJ = null;
    LinearLayout mContainer = null;

    public static void aV(Context context, String str) {
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
        setContentView(R.layout.create_bar_success_activity);
        initData();
        cQv();
    }

    private void initData() {
        this.jVu = getIntent().getStringExtra("barname");
        if (this.jVu == null) {
            this.jVu = "";
        }
    }

    private void cQv() {
        this.mContainer = (LinearLayout) findViewById(R.id.container);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.title);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() + layoutParams.height;
            relativeLayout.setLayoutParams(layoutParams);
        }
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.create_bar));
        this.mTextView = (TextView) findViewById(R.id.text);
        this.jVJ = (TextView) findViewById(R.id.text_more);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mContainer);
        boolean isOn = new CreateBarTipSwitch().isOn();
        String string = isOn ? getPageContext().getString(R.string.create_bar_new_tip) : getPageContext().getString(R.string.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(isOn ? string + this.jVu + getPageContext().getString(R.string.create_bar_new_tip2) : string + this.jVu + getPageContext().getString(R.string.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.common_color_10252)), length, this.jVu.length() + length, 33);
        this.mTextView.setText(spannableString);
        this.jVJ.setVisibility(isOn ? 0 : 8);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

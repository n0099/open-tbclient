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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.t.r;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public NavigationBar mNavigationBar;
    private String gbO = null;
    private TextView mTextView = null;
    private TextView gcc = null;
    LinearLayout car = null;

    public static void ay(Context context, String str) {
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
        buY();
    }

    private void initData() {
        this.gbO = getIntent().getStringExtra("barname");
        if (this.gbO == null) {
            this.gbO = "";
        }
    }

    private void buY() {
        this.car = (LinearLayout) findViewById(R.id.container);
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
        this.gcc = (TextView) findViewById(R.id.text_more);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.car);
        boolean iN = new r().iN();
        String string = iN ? getPageContext().getString(R.string.create_bar_new_tip) : getPageContext().getString(R.string.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(iN ? string + this.gbO + getPageContext().getString(R.string.create_bar_new_tip2) : string + this.gbO + getPageContext().getString(R.string.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.common_color_10252)), length, this.gbO.length() + length, 33);
        this.mTextView.setText(spannableString);
        this.gcc.setVisibility(iN ? 0 : 8);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

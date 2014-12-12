package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public NavigationBar mNavigationBar;
    private String aOm = null;
    private TextView mTextView = null;
    LinearLayout Mg = null;

    public static void L(Context context, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarSuccessActivity.class);
            intent.putExtra(CreateBarActivityConfig.BAR_NAME_STRING, str);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.create_bar_success_activity);
        initData();
        Jc();
    }

    private void initData() {
        this.aOm = getIntent().getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING);
        if (this.aOm == null) {
            this.aOm = "";
        }
    }

    private void Jc() {
        this.Mg = (LinearLayout) findViewById(com.baidu.tieba.w.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(z.create_bar));
        this.mTextView = (TextView) findViewById(com.baidu.tieba.w.text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.Mg);
        String string = getPageContext().getString(z.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(String.valueOf(string) + this.aOm + getPageContext().getString(z.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(ax.getColor(com.baidu.tieba.t.noexit_create_bar_name_text)), length, this.aOm.length() + length, 33);
        this.mTextView.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

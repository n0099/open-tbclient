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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class CreateBarSuccessActivity extends BaseActivity<CreateBarSuccessActivity> {
    public NavigationBar mNavigationBar;
    private String aVP = null;
    private TextView mTextView = null;
    LinearLayout XG = null;

    public static void J(Context context, String str) {
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
        setContentView(w.create_bar_success_activity);
        initData();
        Nl();
    }

    private void initData() {
        this.aVP = getIntent().getStringExtra(CreateBarActivityConfig.BAR_NAME_STRING);
        if (this.aVP == null) {
            this.aVP = "";
        }
    }

    private void Nl() {
        this.XG = (LinearLayout) findViewById(v.container);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(y.create_bar));
        this.mTextView = (TextView) findViewById(v.text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.XG);
        String string = getPageContext().getString(y.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(String.valueOf(string) + this.aVP + getPageContext().getString(y.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(ba.getColor(s.noexit_create_bar_name_text)), length, this.aVP.length() + length, 33);
        this.mTextView.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}

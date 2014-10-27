package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class CreateBarSuccessActivity extends BaseActivity {
    public NavigationBar mNavigationBar;
    private String aLY = null;
    private TextView mTextView = null;
    LinearLayout Hk = null;

    public static void startActivity(Context context, String str) {
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
        setContentView(com.baidu.tieba.w.create_bar_success_activity);
        initData();
        IF();
    }

    private void initData() {
        this.aLY = getIntent().getStringExtra("barname");
        if (this.aLY == null) {
            this.aLY = "";
        }
    }

    private void IF() {
        this.Hk = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getString(y.create_bar));
        this.mTextView = (TextView) findViewById(com.baidu.tieba.v.text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.Hk);
        String string = getString(y.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(String.valueOf(string) + this.aLY + getString(y.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(com.baidu.tieba.s.noexit_create_bar_name_text)), length, this.aLY.length() + length, 33);
        this.mTextView.setText(spannableString);
        this.mNavigationBar.onChangeSkinType(i);
    }
}

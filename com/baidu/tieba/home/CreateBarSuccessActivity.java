package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class CreateBarSuccessActivity extends com.baidu.tbadk.a {
    public NavigationBar b;
    private String c = null;
    private TextView d = null;
    LinearLayout a = null;

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarSuccessActivity.class);
            intent.putExtra("barname", str);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.create_bar_success_activity);
        this.c = getIntent().getStringExtra("barname");
        if (this.c == null) {
            this.c = "";
        }
        this.a = (LinearLayout) findViewById(com.baidu.tieba.a.h.container);
        this.b = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b.a(getString(com.baidu.tieba.a.k.create_bar));
        this.d = (TextView) findViewById(com.baidu.tieba.a.h.text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.a);
        String string = getString(com.baidu.tieba.a.k.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(String.valueOf(string) + this.c + getString(com.baidu.tieba.a.k.create_bar_info2));
        if (i == 1) {
            this.d.setTextColor(getResources().getColor(com.baidu.tieba.a.e.skin_1_common_color));
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.a.e.noexit_create_bar_name_text_1)), length, this.c.length() + length, 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.a.e.noexit_create_bar_name_text)), length, this.c.length() + length, 33);
        }
        this.d.setText(spannableString);
        this.b.b(i);
    }
}

package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class CreateBarSuccessActivity extends com.baidu.tbadk.a {
    public NavigationBar c;
    private String d = null;
    private TextView e = null;
    LinearLayout a = null;
    View b = null;

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
        this.d = getIntent().getStringExtra("barname");
        if (this.d == null) {
            this.d = "";
        }
        this.a = (LinearLayout) findViewById(com.baidu.tieba.a.h.container);
        this.c = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(getString(com.baidu.tieba.a.k.create_bar));
        this.b = findViewById(com.baidu.tieba.a.h.title);
        this.e = (TextView) findViewById(com.baidu.tieba.a.h.text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        String string;
        super.onChangeSkinType(i);
        ba.a(this.a, i);
        ba.d(this.b, i);
        int length = getString(com.baidu.tieba.a.k.create_bar_info1).length();
        String str = String.valueOf(string) + this.d + getString(com.baidu.tieba.a.k.create_bar_info2);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.a.e.skin_1_common_color)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.a.e.skin_1_common_color)), this.d.length() + length, str.length(), 33);
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), length, this.d.length() + length, 33);
        this.e.setText(spannableString);
        this.c.b(i);
    }
}

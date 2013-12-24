package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class CreateBarSuccessActivity extends com.baidu.tieba.j {
    private String d = null;
    private ImageView e = null;
    private TextView f = null;
    LinearLayout a = null;
    View b = null;
    TextView c = null;

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarSuccessActivity.class);
            intent.putExtra("barname", str);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_success_activity);
        a();
        b();
    }

    private void a() {
        this.d = getIntent().getStringExtra("barname");
        if (this.d == null) {
            this.d = "";
        }
    }

    private void b() {
        this.a = (LinearLayout) findViewById(R.id.container);
        this.b = findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.e = (ImageView) findViewById(R.id.back);
        this.e.setOnClickListener(new e(this));
        this.f = (TextView) findViewById(R.id.text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tieba.util.bb.a(this.e, i);
        com.baidu.tieba.util.bb.a(this.a, i);
        com.baidu.tieba.util.bb.d(this.b, i);
        String string = getString(R.string.create_bar_info1);
        int length = string.length();
        String str = string + this.d + getString(R.string.create_bar_info2);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), this.d.length() + length, str.length(), 33);
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), length, this.d.length() + length, 33);
        this.f.setText(spannableString);
    }
}

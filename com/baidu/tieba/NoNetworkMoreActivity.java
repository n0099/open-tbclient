package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NoNetworkMoreActivity extends f {
    private View a;
    private ImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.no_network_more_view);
        this.a = findViewById(R.id.title);
        this.b = (ImageView) findViewById(R.id.back);
        this.b.setOnClickListener(this);
        this.c = (ImageView) findViewById(R.id.home);
        this.d = (TextView) findViewById(R.id.title_text);
        this.e = (TextView) findViewById(R.id.more_item1);
        SpannableString spannableString = new SpannableString(getString(R.string.no_network_guide_content1));
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 4, 15, 33);
        this.e.setText(spannableString);
        this.f = (TextView) findViewById(R.id.more_item2);
        SpannableString spannableString2 = new SpannableString(getString(R.string.no_network_guide_content2));
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 4, 15, 33);
        this.f.setText(spannableString2);
        ((Button) findViewById(R.id.network_setting_btn)).setOnClickListener(this);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.network_setting_btn) {
            startActivity(new Intent("android.settings.SETTINGS"));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        bq.a(this.b, i);
        bq.a(this.c, i);
        bq.d(this.a, i);
        bq.e(this.d, i);
    }
}

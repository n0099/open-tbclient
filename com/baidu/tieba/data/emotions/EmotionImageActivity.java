package com.baidu.tieba.data.emotions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EmotionImageActivity extends com.baidu.tieba.j {
    private NavigationBar a;
    private GifView b;
    private BDImageView c;
    private TextView d;
    private TextView e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;
    private int m;
    private int n;
    private int o;
    private com.baidu.tieba.util.i p;
    private boolean q;
    private int r = 0;

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3) {
        Intent intent = new Intent(context, EmotionImageActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("pid", str);
        intent.putExtra("panme", str2);
        intent.putExtra("iconUrl", str3);
        intent.putExtra("gifUrl", str5);
        intent.putExtra("staticUrl", str4);
        intent.putExtra("sharpText", str6);
        intent.putExtra("from", i);
        intent.putExtra("width", i2);
        intent.putExtra("height", i3);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.emotion_activity);
        a(bundle);
        a();
    }

    private void a(Bundle bundle) {
        float f = getResources().getDisplayMetrics().density;
        this.n = ((double) f) < 1.5d ? 134 : 200;
        this.o = ((double) f) >= 1.5d ? 200 : 134;
        if (bundle != null) {
            this.f = bundle.getString("pid");
            this.g = bundle.getString("panme");
            this.h = bundle.getString("iconUrl");
            this.i = bundle.getString("gifUrl");
            this.j = bundle.getString("staticUrl");
            this.k = bundle.getString("sharpText");
            this.l = bundle.getInt("width");
            this.m = bundle.getInt("height");
        } else {
            Intent intent = getIntent();
            this.f = intent.getStringExtra("pid");
            this.g = intent.getStringExtra("panme");
            this.h = intent.getStringExtra("iconUrl");
            this.i = intent.getStringExtra("gifUrl");
            this.j = intent.getStringExtra("staticUrl");
            this.k = intent.getStringExtra("sharpText");
            this.l = intent.getIntExtra("width", this.n);
            this.m = intent.getIntExtra("height", this.o);
        }
        this.r = getIntent().getIntExtra("from", 0);
        this.p = new com.baidu.tieba.util.i(this);
    }

    private void a() {
        FrameLayout.LayoutParams layoutParams;
        com.baidu.adp.widget.ImageView.d g;
        this.a = (NavigationBar) findViewById(R.id.navigation_bar);
        this.a.a(getString(R.string.emotion_image_title));
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        this.b = (GifView) findViewById(R.id.gifview);
        if (this.l == 0 || this.m == 0) {
            layoutParams = new FrameLayout.LayoutParams(this.n, this.o, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.l, this.m, 17);
        }
        this.b.setLayoutParams(layoutParams);
        boolean c = com.baidu.tieba.util.i.c();
        com.baidu.adp.widget.ImageView.d a = this.p.a(this.f, this.k, c ? this.i : this.j, c, new g(this));
        if (a != null) {
            this.b.setGif(a);
        }
        this.c = (BDImageView) findViewById(R.id.emotion_icon);
        if (!TextUtils.isEmpty(this.h)) {
            com.baidu.adp.widget.ImageView.d a2 = this.p.a(this.h, new h(this));
            if (a2 != null) {
                a2.a(this.c);
            }
        } else {
            WritableEmotionGroup c2 = l.a().c(this.f);
            if (c2 != null && (g = c2.g()) != null) {
                g.a(this.c);
            }
        }
        this.d = (TextView) findViewById(R.id.emotion_pname);
        this.d.setText(this.g);
        this.e = (TextView) findViewById(R.id.emotion_detail);
        this.e.setOnClickListener(new i(this));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("pid", this.f);
        bundle.putString("panme", this.g);
        bundle.putString("iconUrl", this.h);
        bundle.putString("gifUrl", this.i);
        bundle.putString("staticUrl", this.j);
        bundle.putString("sharpText", this.k);
        bundle.putInt("width", this.l);
        bundle.putInt("height", this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(findViewById(R.id.emotion_image_root));
        this.a.c(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q = true;
    }
}

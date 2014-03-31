package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
public class EmotionImageActivity extends com.baidu.tbadk.a {
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
    private com.baidu.tbadk.editortool.aa p;
    private boolean q;
    private int r = 0;

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.h.class, EmotionImageActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.adp.widget.ImageView.b i;
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.emotion_activity);
        float f = getResources().getDisplayMetrics().density;
        this.n = ((double) f) < 1.5d ? 160 : 240;
        this.o = ((double) f) >= 1.5d ? 240 : 160;
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
        this.p = new com.baidu.tbadk.editortool.aa(this);
        this.a = (NavigationBar) findViewById(com.baidu.tieba.a.h.navigation_bar);
        this.a.a(getString(com.baidu.tieba.a.k.emotion_image_title));
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new j(this));
        this.b = (GifView) findViewById(com.baidu.tieba.a.h.gifview);
        this.b.setLayoutParams((this.l == 0 || this.m == 0) ? new FrameLayout.LayoutParams(this.n, this.o, 17) : new FrameLayout.LayoutParams(this.l, this.m, 17));
        boolean b = com.baidu.tbadk.editortool.aa.b();
        com.baidu.adp.widget.ImageView.b a = this.p.a(this.f, this.k, b ? this.i : this.j, b, new k(this), false);
        if (a != null) {
            this.b.setGif(a);
        }
        this.c = (BDImageView) findViewById(com.baidu.tieba.a.h.emotion_icon);
        if (TextUtils.isEmpty(this.h)) {
            com.baidu.tbadk.editortool.af c = com.baidu.tbadk.editortool.ab.a().c(this.f);
            if (c != null && (i = c.i()) != null) {
                i.a(this.c);
            }
        } else {
            this.p.b(this.h, new l(this));
        }
        this.d = (TextView) findViewById(com.baidu.tieba.a.h.emotion_pname);
        this.d.setText(this.g);
        this.e = (TextView) findViewById(com.baidu.tieba.a.h.emotion_detail);
        this.e.setOnClickListener(new m(this));
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
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(findViewById(com.baidu.tieba.a.h.emotion_image_root));
        this.a.b(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q = true;
    }
}

package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class EmotionImageActivity extends BaseActivity {
    private NavigationBar a;
    private GifView b;
    private TbImageView c;
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
    private com.baidu.tbadk.editortool.ab p;
    private boolean q;
    private int r = 0;

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.i.class, EmotionImageActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.s.emotion_activity);
        a(bundle);
        a();
    }

    private void a(Bundle bundle) {
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
        this.p = new com.baidu.tbadk.editortool.ab(this);
    }

    private void a() {
        FrameLayout.LayoutParams layoutParams;
        com.baidu.adp.widget.a.a i;
        this.a = (NavigationBar) findViewById(com.baidu.tieba.r.navigation_bar);
        this.a.a(getString(com.baidu.tieba.u.emotion_image_title));
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.b = (GifView) findViewById(com.baidu.tieba.r.gifview);
        if (this.l == 0 || this.m == 0) {
            layoutParams = new FrameLayout.LayoutParams(this.n, this.o, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.l, this.m, 17);
        }
        this.b.setLayoutParams(layoutParams);
        boolean c = com.baidu.tbadk.editortool.ab.c();
        com.baidu.adp.widget.a.a a = this.p.a(this.f, this.k, c ? this.i : this.j, c, new l(this), false);
        if (a != null) {
            this.b.setGif(a);
        }
        this.c = (TbImageView) findViewById(com.baidu.tieba.r.emotion_icon);
        if (!TextUtils.isEmpty(this.h)) {
            this.p.b(this.h, new m(this));
        } else {
            com.baidu.tbadk.editortool.ag d = com.baidu.tbadk.editortool.ac.a().d(this.f);
            if (d != null && (i = d.i()) != null) {
                i.a(this.c);
            }
        }
        this.d = (TextView) findViewById(com.baidu.tieba.r.emotion_pname);
        this.d.setText(this.g);
        this.e = (TextView) findViewById(com.baidu.tieba.r.emotion_detail);
        this.e.setOnClickListener(new n(this));
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
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(findViewById(com.baidu.tieba.r.emotion_image_root));
        this.a.c(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q = true;
    }
}

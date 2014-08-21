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
    private int p = 0;

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.m.class, EmotionImageActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.emotion_activity);
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
        this.p = getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.FROM, 0);
    }

    private void a() {
        FrameLayout.LayoutParams layoutParams;
        com.baidu.adp.widget.a.a j;
        this.a = (NavigationBar) findViewById(com.baidu.tieba.u.navigation_bar);
        this.a.a(getString(com.baidu.tieba.x.emotion_image_title));
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.b = (GifView) findViewById(com.baidu.tieba.u.gifview);
        if (this.l == 0 || this.m == 0) {
            layoutParams = new FrameLayout.LayoutParams(this.n, this.o, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.l, this.m, 17);
        }
        this.b.setLayoutParams(layoutParams);
        boolean b = com.baidu.tbadk.b.c.b();
        com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
        aVar.b = this.k;
        aVar.e = this.f;
        aVar.g = this.m;
        aVar.f = this.l;
        if (b) {
            aVar.d = this.i;
        } else {
            aVar.c = this.j;
        }
        this.b.a(aVar);
        this.c = (TbImageView) findViewById(com.baidu.tieba.u.emotion_icon);
        if (!TextUtils.isEmpty(this.h)) {
            this.c.a(this.h, 10, false);
        } else {
            com.baidu.tbadk.editortool.ad c = com.baidu.tbadk.editortool.aa.a().c(this.f);
            if (c != null && (j = c.j()) != null) {
                j.a(this.c);
            }
        }
        this.d = (TextView) findViewById(com.baidu.tieba.u.emotion_pname);
        this.d.setText(this.g);
        this.e = (TextView) findViewById(com.baidu.tieba.u.emotion_detail);
        this.e.setOnClickListener(new l(this));
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
        getLayoutMode().a(findViewById(com.baidu.tieba.u.emotion_image_root));
        this.a.c(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}

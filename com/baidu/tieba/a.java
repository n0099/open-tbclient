package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    protected ViewGroup f829a = null;
    protected View b = null;
    protected ImageView c = null;
    protected TextView d = null;
    protected ListView e = null;
    protected Button f = null;
    protected ViewGroup g;

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        b();
    }

    protected void b() {
        if (this.f829a == null) {
            this.f829a = (ViewGroup) findViewById(R.id.container);
            if (this.f829a == null) {
                this.f829a = (ViewGroup) findViewById(R.id.parent);
            }
            this.b = findViewById(R.id.title);
            this.c = (ImageView) findViewById(R.id.back);
            if (this.c != null) {
                this.c.setOnClickListener(new b(this));
            }
            this.d = (TextView) findViewById(R.id.title_text);
            if (this.f829a != null) {
                this.f = (Button) this.f829a.findViewWithTag("skin_top_more_button");
            }
        }
        if (this.e == null) {
            this.e = (ListView) findViewById(R.id.list);
        }
        this.g = (ViewGroup) findViewById(R.id.body_container);
        com.baidu.tieba.util.ap.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ah.a(this.c, i);
        com.baidu.tieba.util.ah.d(this.b, i);
        com.baidu.tieba.util.ah.f(this.d, i);
        com.baidu.tieba.util.ah.b(this.f829a, i);
        com.baidu.tieba.util.ah.g((TextView) this.f, i);
        if (this.e != null) {
            this.e.invalidateViews();
        }
        if (this.g != null) {
            com.baidu.tieba.util.ap.a(this.g, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        finish();
    }
}

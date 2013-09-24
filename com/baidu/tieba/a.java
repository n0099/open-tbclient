package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.util.ba;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends j {

    /* renamed from: a  reason: collision with root package name */
    protected ViewGroup f862a = null;
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
        if (this.f862a == null) {
            this.f862a = (ViewGroup) findViewById(R.id.container);
            if (this.f862a == null) {
                this.f862a = (ViewGroup) findViewById(R.id.parent);
            }
            this.b = findViewById(R.id.title);
            this.c = (ImageView) findViewById(R.id.back);
            if (this.c != null) {
                this.c.setOnClickListener(new b(this));
            }
            this.d = (TextView) findViewById(R.id.title_text);
            if (this.f862a != null) {
                this.f = (Button) this.f862a.findViewWithTag("skin_top_more_button");
            }
        }
        if (this.e == null) {
            this.e = (ListView) findViewById(R.id.list);
        }
        this.g = (ViewGroup) findViewById(R.id.body_container);
        ba.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.as.a(this.c, i);
        com.baidu.tieba.util.as.d(this.b, i);
        com.baidu.tieba.util.as.f(this.d, i);
        com.baidu.tieba.util.as.b(this.f862a, i);
        com.baidu.tieba.util.as.g(this.f, i);
        if (this.e != null) {
            this.e.invalidateViews();
        }
        if (this.g != null) {
            ba.a(this.g, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        finish();
    }
}

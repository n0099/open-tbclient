package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends j {

    /* renamed from: a  reason: collision with root package name */
    protected ViewGroup f1017a = null;
    protected View b = null;
    protected ImageView c = null;
    protected TextView d = null;
    protected ListView e = null;
    protected Button f = null;
    protected ViewGroup g;

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        a();
    }

    protected void a() {
        if (this.f1017a == null) {
            this.f1017a = (ViewGroup) findViewById(R.id.container);
            if (this.f1017a == null) {
                this.f1017a = (ViewGroup) findViewById(R.id.parent);
            }
            this.b = findViewById(R.id.title);
            this.c = (ImageView) findViewById(R.id.back);
            if (this.c != null) {
                this.c.setOnClickListener(new b(this));
            }
            this.d = (TextView) findViewById(R.id.title_text);
            if (this.f1017a != null) {
                this.f = (Button) this.f1017a.findViewWithTag("skin_top_more_button");
            }
        }
        if (this.e == null) {
            this.e = (ListView) findViewById(R.id.list);
        }
        this.g = (ViewGroup) findViewById(R.id.body_container);
        com.baidu.tieba.util.bj.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tieba.util.ba.a(this.c, i);
        com.baidu.tieba.util.ba.d(this.b, i);
        com.baidu.tieba.util.ba.e(this.d, i);
        com.baidu.tieba.util.ba.b(this.f1017a, i);
        com.baidu.tieba.util.ba.f(this.f, i);
        if (this.e != null) {
            this.e.invalidateViews();
            if (i == 1) {
            }
        }
        if (this.g != null) {
            com.baidu.tieba.util.bj.a(this.g, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        finish();
    }
}

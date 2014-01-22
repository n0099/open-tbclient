package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.util.ce;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends j {
    protected ViewGroup a = null;
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
        if (this.a == null) {
            this.a = (ViewGroup) findViewById(R.id.container);
            if (this.a == null) {
                this.a = (ViewGroup) findViewById(R.id.parent);
            }
            this.b = findViewById(R.id.title);
            this.c = (ImageView) findViewById(R.id.back);
            if (this.c != null) {
                this.c.setOnClickListener(new b(this));
            }
            this.d = (TextView) findViewById(R.id.title_text);
            if (this.a != null) {
                this.f = (Button) this.a.findViewWithTag("skin_top_more_button");
            }
        }
        if (this.e == null) {
            this.e = (ListView) findViewById(R.id.list);
        }
        this.g = (ViewGroup) findViewById(R.id.body_container);
        ce.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bs.a(this.c, i);
        bs.d(this.b, i);
        bs.e(this.d, i);
        bs.b(this.a, i);
        bs.f((TextView) this.f, i);
        if (this.e != null) {
            this.e.invalidateViews();
            if (i == 1) {
            }
        }
        if (this.g != null) {
            ce.a(this.g, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        finish();
    }
}

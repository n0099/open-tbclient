package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.bl;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends j {

    /* renamed from: a  reason: collision with root package name */
    protected ViewGroup f1005a = null;
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
        if (this.f1005a == null) {
            this.f1005a = (ViewGroup) findViewById(R.id.container);
            if (this.f1005a == null) {
                this.f1005a = (ViewGroup) findViewById(R.id.parent);
            }
            this.b = findViewById(R.id.title);
            this.c = (ImageView) findViewById(R.id.back);
            if (this.c != null) {
                this.c.setOnClickListener(new b(this));
            }
            this.d = (TextView) findViewById(R.id.title_text);
            if (this.f1005a != null) {
                this.f = (Button) this.f1005a.findViewWithTag("skin_top_more_button");
            }
        }
        if (this.e == null) {
            this.e = (ListView) findViewById(R.id.list);
        }
        this.g = (ViewGroup) findViewById(R.id.body_container);
        bl.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bd.a(this.c, i);
        bd.d(this.b, i);
        bd.e(this.d, i);
        bd.b(this.f1005a, i);
        bd.f((TextView) this.f, i);
        if (this.e != null) {
            this.e.invalidateViews();
            if (i == 1) {
            }
        }
        if (this.g != null) {
            bl.a(this.g, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        finish();
    }
}

package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.a {
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
        if (this.a == null) {
            this.a = (ViewGroup) findViewById(com.baidu.tieba.a.h.container);
            if (this.a == null) {
                this.a = (ViewGroup) findViewById(com.baidu.tieba.a.h.parent);
            }
            this.b = findViewById(com.baidu.tieba.a.h.title);
            this.c = (ImageView) findViewById(com.baidu.tieba.a.h.back);
            if (this.c != null) {
                this.c.setOnClickListener(new b(this));
            }
            this.d = (TextView) findViewById(com.baidu.tieba.a.h.title_text);
            if (this.a != null) {
                this.f = (Button) this.a.findViewWithTag("skin_top_more_button");
            }
        }
        if (this.e == null) {
            this.e = (ListView) findViewById(com.baidu.tieba.a.h.list);
        }
        this.g = (ViewGroup) findViewById(com.baidu.tieba.a.h.body_container);
        bn.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.a(this.c, i);
        ba.d(this.b, i);
        ba.d(this.d, i);
        ba.b(this.a, i);
        ba.e((TextView) this.f, i);
        if (this.e != null) {
            this.e.invalidateViews();
        }
        if (this.g != null) {
            bn.a(this.g, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        finish();
    }
}

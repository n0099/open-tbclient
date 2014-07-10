package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bx;
/* loaded from: classes.dex */
public class AutoSkinActivity extends BaseActivity {
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
            this.a = (ViewGroup) findViewById(v.container);
            if (this.a == null) {
                this.a = (ViewGroup) findViewById(v.parent);
            }
            this.b = findViewById(v.title);
            this.c = (ImageView) findViewById(v.back);
            if (this.c != null) {
                this.c.setOnClickListener(new e(this));
            }
            this.d = (TextView) findViewById(v.title_text);
            if (this.a != null) {
                this.f = (Button) this.a.findViewWithTag("skin_top_more_button");
            }
        }
        if (this.e == null) {
            this.e = (ListView) findViewById(v.list);
        }
        this.g = (ViewGroup) findViewById(v.body_container);
        bx.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bk.a(this.c, i);
        bk.d(this.b, i);
        bk.d(this.d, i);
        bk.b(this.a, i);
        bk.e((TextView) this.f, i);
        if (this.e != null) {
            this.e.invalidateViews();
        }
        if (this.g != null) {
            bx.a(this.g, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        finish();
    }
}

package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bp;
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
        bp.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.bc.a(this.c, i);
        com.baidu.tbadk.core.util.bc.d(this.b, i);
        com.baidu.tbadk.core.util.bc.d(this.d, i);
        com.baidu.tbadk.core.util.bc.b(this.a, i);
        com.baidu.tbadk.core.util.bc.e((TextView) this.f, i);
        if (this.e != null) {
            this.e.invalidateViews();
        }
        if (this.g != null) {
            bp.a(this.g, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        finish();
    }
}

package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bo;
/* loaded from: classes.dex */
public class AutoSkinActivity extends BaseActivity {
    protected ViewGroup a = null;
    protected View b = null;
    protected ImageView c = null;
    protected TextView d = null;
    protected ListView e = null;
    protected Button f = null;
    protected ViewGroup g;

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        a();
    }

    protected void a() {
        if (this.a == null) {
            this.a = (ViewGroup) findViewById(u.container);
            if (this.a == null) {
                this.a = (ViewGroup) findViewById(u.parent);
            }
            this.b = findViewById(u.title);
            this.c = (ImageView) findViewById(u.back);
            if (this.c != null) {
                this.c.setOnClickListener(new e(this));
            }
            this.d = (TextView) findViewById(u.title_text);
            if (this.a != null) {
                this.f = (Button) this.a.findViewWithTag("skin_top_more_button");
            }
        }
        if (this.e == null) {
            this.e = (ListView) findViewById(u.list);
        }
        this.g = (ViewGroup) findViewById(u.body_container);
        bo.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ay.a(this.c, i);
        com.baidu.tbadk.core.util.ay.d(this.b, i);
        com.baidu.tbadk.core.util.ay.d(this.d, i);
        com.baidu.tbadk.core.util.ay.b(this.a, i);
        com.baidu.tbadk.core.util.ay.e((TextView) this.f, i);
        if (this.e != null) {
            this.e.invalidateViews();
        }
        if (this.g != null) {
            bo.a(this.g, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        finish();
    }
}

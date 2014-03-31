package com.baidu.tieba.bubble;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.data.n;
import com.baidu.tieba.a.k;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.model.f;
import com.baidu.tieba.model.i;
import com.baidu.tieba.model.j;
/* loaded from: classes.dex */
public class BubbleChooseActivity extends com.baidu.tbadk.a {
    private e b;
    private f c;
    private final int d = 0;
    private final int e = 50;
    private i f = new a(this);
    private j g = new b(this);
    public com.baidu.adp.framework.c.a a = new c(this, 2010040);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.d.class, BubbleChooseActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = new f();
        this.c.a(this.f);
        this.c.a(this.g);
        f fVar = this.c;
        com.baidu.adp.framework.c.a().a(this.a);
        this.c.c();
        this.c.d();
        this.b = new e(this);
        this.b.e().setOnItemClickListener(this);
        this.b.f();
        a();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        f fVar = this.c;
        f.a(0, 50, com.baidu.adp.lib.util.i.b(this), com.baidu.adp.lib.util.i.c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.e();
        }
        f fVar = this.c;
        com.baidu.adp.framework.c.a().b(this.a);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.b.d()) {
            TbWebViewActivity.b(this, getString(k.web_title_bubble_explain), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeanrights?type=1&_client_version=" + n.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.b(i);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData a;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView == this.b.e() && view != null && (view instanceof com.baidu.tieba.view.a) && (a = this.b.a(i)) != null) {
            if (a.getBcode() == 0 || a.canUse() || a.isFree()) {
                if (!a.isDef()) {
                    this.c.a(a.getBcode());
                    f fVar = this.c;
                    f.a(a.getBcode(), com.baidu.adp.lib.util.i.b(this), com.baidu.adp.lib.util.i.c(this));
                    this.b.f();
                    return;
                }
                return;
            }
            this.c.b(a.getBcode());
            TbWebViewActivity.b(this, getString(k.web_title_bubble_purchase), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeantshow?_client_version=" + n.c());
        }
    }
}

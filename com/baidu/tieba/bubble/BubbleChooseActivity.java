package com.baidu.tieba.bubble;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.model.f;
import com.baidu.tieba.model.i;
import com.baidu.tieba.model.j;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class BubbleChooseActivity extends BaseActivity {
    private e b;
    private f c;
    private final int d = 0;
    private final int e = 50;
    private i f = new a(this);
    private j g = new b(this);
    public CustomMessageListener a = new c(this, CmdConfig.BUBBLE_LIST_REFRESH);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.e.class, BubbleChooseActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        b();
        d();
    }

    private void a() {
        this.c = new f();
        this.c.a(this.f);
        this.c.a(this.g);
        this.c.a(this.a);
        c();
    }

    private void b() {
        this.b = new e(this);
        this.b.c().setOnItemClickListener(this);
        this.b.d();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void c() {
        this.c.c();
        this.c.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.c.a(0, 50, k.b(this), k.c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.e();
        }
        this.c.b(this.a);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.b.b()) {
            TbWebViewActivity.b(this, getString(y.web_title_bubble_explain), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeanrights?type=1&_client_version=" + TbConfig.getVersion());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.b(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData a;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView == this.b.c() && view != null && (view instanceof com.baidu.tieba.view.a) && (a = this.b.a(i)) != null) {
            if (a.getBcode() == 0 || a.canUse() || a.isFree()) {
                if (!a.isDef()) {
                    this.c.a(a.getBcode());
                    this.c.a(a.getBcode(), k.b(this), k.c(this));
                    this.b.d();
                    return;
                }
                return;
            }
            this.c.b(a.getBcode());
            TbWebViewActivity.b(this, getString(y.web_title_bubble_purchase), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeantshow?_client_version=" + TbConfig.getVersion());
        }
    }
}

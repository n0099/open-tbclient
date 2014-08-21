package com.baidu.tieba.game;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
public class GameCenterHomeActivity extends BaseActivity implements com.baidu.adp.widget.ListView.x {
    private n a;
    private m b;
    private final CustomMessageListener c = new f(this, 2001121);
    private final CustomMessageListener d = new g(this, 2001122);
    private final com.baidu.adp.framework.listener.d e = new h(this, 303008);
    private final CustomMessageListener f = new j(this, 2001224);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.v.class, GameCenterHomeActivity.class);
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.game_center_view);
        this.a = new n(this, null);
        this.b = new m(this);
        this.b.registerListener(this.d);
        this.b.registerListener(this.e);
        this.b.registerListener(this.f);
        this.b.registerListener(this.c);
        this.a.b().setVisibility(8);
        showLoadingDialog(getResources().getString(com.baidu.tieba.x.game_center_loading), null);
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.g();
        this.a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.h();
    }

    private static void b() {
        bg.a().a(new l());
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        c();
    }

    private void c() {
        if (this.b.b()) {
            this.a.a().setVisibility(0);
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.b.b(this.b.a());
        } else {
            this.b.c(this.b.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.a.a(i);
    }
}

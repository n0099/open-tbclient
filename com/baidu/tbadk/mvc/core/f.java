package com.baidu.tbadk.mvc.core;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.a;
import com.baidu.tbadk.mvc.core.c;
/* loaded from: classes.dex */
public abstract class f<V extends c, M extends a, T> extends ProxyAdkBaseActivity<T> implements com.baidu.tbadk.mvc.c.a, e<V, M, T> {
    private M Lv;
    private ViewEventCenter any;
    private V anz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bc();
        this.Lv = oy();
        if (this.Lv != null) {
            this.Lv.setUniqueId(getUniqueId());
            this.Lv.a(this);
        }
        this.anz = oA();
        if (this.anz != null) {
            this.anz.setUniqueId(getUniqueId());
            this.anz.a(this);
        }
        this.any = AL();
        Bd();
        Be();
        if (getIntent() != null) {
            this.Lv.f(getIntent().getExtras());
            this.anz.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.Lv.f(bundle);
            this.anz.h(bundle);
        } else {
            this.Lv.f(null);
            this.anz.h(null);
        }
        Bf();
        Bg();
        setContentView(this.anz.Bb());
        this.anz.oL();
        this.anz.a(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.anz.AY();
        Bh();
    }

    protected void Bc() {
    }

    protected void Bd() {
    }

    protected void Be() {
    }

    protected void Bf() {
    }

    protected void Bg() {
    }

    protected void Bh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onStart() {
        super.onStart();
        Bi();
        oA().AO();
    }

    protected void Bi() {
    }

    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onRestart() {
        super.onRestart();
        Bj();
        oA().AP();
    }

    protected void Bj() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onResume() {
        super.onResume();
        Bk();
        oA().AR();
    }

    protected void Bk() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onPause() {
        super.onPause();
        Bl();
        oA().AT();
    }

    protected void Bl() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onStop() {
        super.onStop();
        Bm();
        oA().AV();
    }

    protected void Bm() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onDestroy() {
        super.onDestroy();
        Bn();
        oA().AW();
    }

    protected void Bn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.Lv.onSaveInstanceState(bundle);
        this.anz.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        oA().onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onChangeSkinType(int i) {
        this.anz.a(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.mvc.core.e
    public ViewEventCenter AL() {
        if (this.any == null) {
            this.any = new ViewEventCenter();
        }
        return this.any;
    }

    protected void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean AM() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar instanceof com.baidu.tbadk.mvc.c.b.a) {
            a(((com.baidu.tbadk.mvc.c.b.a) bVar).getExtra());
            return true;
        }
        return false;
    }
}

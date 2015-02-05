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
    private ViewEventCenter adT;
    private V adU;
    private M yZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        wY();
        this.yZ = kp();
        if (this.yZ != null) {
            this.yZ.setUniqueId(getUniqueId());
            this.yZ.a(this);
        }
        this.adU = kr();
        if (this.adU != null) {
            this.adU.setUniqueId(getUniqueId());
            this.adU.a(this);
        }
        this.adT = wH();
        wZ();
        xa();
        if (getIntent() != null) {
            this.yZ.f(getIntent().getExtras());
            this.adU.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.yZ.f(bundle);
            this.adU.i(bundle);
        } else {
            this.yZ.f(null);
            this.adU.i(null);
        }
        xb();
        xc();
        setContentView(this.adU.wX());
        this.adU.kC();
        this.adU.a(getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        this.adU.wU();
        xd();
    }

    protected void wY() {
    }

    protected void wZ() {
    }

    protected void xa() {
    }

    protected void xb() {
    }

    protected void xc() {
    }

    protected void xd() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onStart() {
        super.onStart();
        xe();
        kr().wK();
    }

    protected void xe() {
    }

    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onRestart() {
        super.onRestart();
        xf();
        kr().wL();
    }

    protected void xf() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onResume() {
        super.onResume();
        xg();
        kr().wN();
    }

    protected void xg() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onPause() {
        super.onPause();
        xh();
        kr().wP();
    }

    protected void xh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onStop() {
        super.onStop();
        xi();
        kr().wR();
    }

    protected void xi() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onDestroy() {
        super.onDestroy();
        xj();
        kr().wS();
    }

    protected void xj() {
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
        this.yZ.onSaveInstanceState(bundle);
        this.adU.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        kr().onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onChangeSkinType(int i) {
        this.adU.a(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.mvc.core.e
    public ViewEventCenter wH() {
        if (this.adT == null) {
            this.adT = new ViewEventCenter();
        }
        return this.adT;
    }

    protected void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean wI() {
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

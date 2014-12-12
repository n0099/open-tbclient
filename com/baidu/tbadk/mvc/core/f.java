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
    private V adA;
    private ViewEventCenter adz;
    private M zc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        wO();
        this.zc = kw();
        if (this.zc != null) {
            this.zc.setUniqueId(getUniqueId());
            this.zc.a(this);
        }
        this.adA = ky();
        if (this.adA != null) {
            this.adA.setUniqueId(getUniqueId());
            this.adA.a(this);
        }
        this.adz = wx();
        wP();
        wQ();
        if (getIntent() != null) {
            this.zc.f(getIntent().getExtras());
            this.adA.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.zc.f(bundle);
            this.adA.i(bundle);
        } else {
            this.zc.f(null);
            this.adA.i(null);
        }
        wR();
        wS();
        setContentView(this.adA.wN());
        this.adA.kJ();
        this.adA.a(getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        this.adA.wK();
        wT();
    }

    protected void wO() {
    }

    protected void wP() {
    }

    protected void wQ() {
    }

    protected void wR() {
    }

    protected void wS() {
    }

    protected void wT() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onStart() {
        super.onStart();
        wU();
        ky().wA();
    }

    protected void wU() {
    }

    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onRestart() {
        super.onRestart();
        wV();
        ky().wB();
    }

    protected void wV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onResume() {
        super.onResume();
        wW();
        ky().wD();
    }

    protected void wW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onPause() {
        super.onPause();
        wX();
        ky().wF();
    }

    protected void wX() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onStop() {
        super.onStop();
        wY();
        ky().wH();
    }

    protected void wY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.a, com.baidu.adp.plugin.pluginBase.c
    public void onDestroy() {
        super.onDestroy();
        wZ();
        ky().wI();
    }

    protected void wZ() {
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
        this.zc.onSaveInstanceState(bundle);
        this.adA.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ky().onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    protected void onChangeSkinType(int i) {
        this.adA.a(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.mvc.core.e
    public ViewEventCenter wx() {
        if (this.adz == null) {
            this.adz = new ViewEventCenter();
        }
        return this.adz;
    }

    protected void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean wy() {
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

package com.baidu.tbadk.mvc.core;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.tbadkCore.y;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c extends g implements com.baidu.tbadk.mvc.c.a, y {
    private com.baidu.tbadk.mvc.c.c adJ;
    protected e<?, ?, ?> adK;
    d adM;
    protected List<com.baidu.tbadk.mvc.j.d<?, ?>> adN;
    private boolean adO;
    boolean adP;
    boolean adQ;
    boolean adR;
    boolean adS;
    boolean adT;
    boolean adU;
    boolean adV;
    protected View rootView;
    protected BdUniqueId unique_id;

    protected abstract int kI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void kJ();

    public c(e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.unique_id = null;
        this.unique_id = eVar.getUniqueId();
        this.adK = eVar;
    }

    public c() {
        super(null);
        this.unique_id = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Bundle bundle) {
        this.adP = true;
        g(bundle);
        if (this.adP && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityCreate must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Bundle bundle) {
        this.adP = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wQ() {
        this.adQ = true;
        kF();
        if (this.adQ && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStart must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kF() {
        this.adQ = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wR() {
        this.adR = true;
        wS();
        if (this.adR && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityRestart must call");
        }
    }

    protected void wS() {
        this.adR = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wT() {
        this.adS = true;
        wU();
        if (this.adS && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityResume must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wU() {
        this.adS = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wV() {
        this.adT = true;
        wW();
        if (this.adT && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityPause must call");
        }
    }

    protected void wW() {
        this.adT = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wX() {
        this.adU = true;
        onActivityStop();
        if (this.adU && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStop must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityStop() {
        this.adU = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wY() {
        this.adV = true;
        onActivityDestroy();
        if (this.adV && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityDestroy must call");
        }
    }

    protected void onActivityDestroy() {
        this.adV = false;
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().removeMessage(this.unique_id);
        com.baidu.adp.lib.f.d.ec().d(this.unique_id);
    }

    public boolean wZ() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xa() {
        this.adO = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xb() {
        this.adO = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean xc() {
        return this.adO;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View xd() {
        if (this.rootView == null) {
            this.rootView = getLayoutInflater().inflate(kI(), (ViewGroup) null);
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e<?, ?, ?> eVar) {
        this.adK = eVar;
        this.mContext = eVar.getPageContext();
    }

    public final e<?, ?, ?> wM() {
        return this.adK;
    }

    public final ViewEventCenter wN() {
        return this.adK.wN();
    }

    public final View getView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.adN != null) {
            int size = this.adN.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.mvc.j.d<?, ?> dVar = this.adN.get(i2);
                if (dVar != null) {
                    dVar.a(tbPageContext, i);
                }
            }
            return true;
        }
        return true;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.g
    public TbPageContext<?> getPageContext() {
        return this.adK.getPageContext();
    }

    public Activity getActivity() {
        return getPageContext().getPageActivity();
    }

    public Resources getResources() {
        return getPageContext().getResources();
    }

    public LayoutInflater getLayoutInflater() {
        return this.adK.getLayoutInflater();
    }

    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean wO() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar instanceof com.baidu.tbadk.mvc.c.b.a) {
            com.baidu.tbadk.mvc.c.b.a aVar = (com.baidu.tbadk.mvc.c.b.a) bVar;
            if (aVar.getUniqueId() == this.unique_id) {
                a(aVar.getExtra());
                return true;
            }
            return true;
        }
        return false;
    }

    public com.baidu.tbadk.mvc.c.c wP() {
        if (this.adJ == null) {
            this.adJ = new com.baidu.tbadk.mvc.c.c(this.unique_id);
        }
        return this.adJ;
    }

    public boolean dF(int i) {
        return dispatchMvcEvent(wP().dJ(i));
    }

    public boolean g(int i, boolean z) {
        return dispatchMvcEvent(wP().i(i, z));
    }

    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar != null) {
            bVar.setUniqueId(this.unique_id);
        }
        return wN().dispatchMvcEvent(bVar);
    }
}

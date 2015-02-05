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
    private com.baidu.tbadk.mvc.c.c adG;
    protected e<?, ?, ?> adH;
    d adJ;
    protected List<com.baidu.tbadk.mvc.j.d<?, ?>> adK;
    private boolean adL;
    boolean adM;
    boolean adN;
    boolean adO;
    boolean adP;
    boolean adQ;
    boolean adR;
    boolean adS;
    protected View rootView;
    protected BdUniqueId unique_id;

    protected abstract int kB();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void kC();

    public c(e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.unique_id = null;
        this.unique_id = eVar.getUniqueId();
        this.adH = eVar;
    }

    public c() {
        super(null);
        this.unique_id = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Bundle bundle) {
        this.adM = true;
        g(bundle);
        if (this.adM && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityCreate must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Bundle bundle) {
        this.adM = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wK() {
        this.adN = true;
        ky();
        if (this.adN && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStart must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ky() {
        this.adN = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wL() {
        this.adO = true;
        wM();
        if (this.adO && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityRestart must call");
        }
    }

    protected void wM() {
        this.adO = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wN() {
        this.adP = true;
        wO();
        if (this.adP && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityResume must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wO() {
        this.adP = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wP() {
        this.adQ = true;
        wQ();
        if (this.adQ && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityPause must call");
        }
    }

    protected void wQ() {
        this.adQ = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wR() {
        this.adR = true;
        onActivityStop();
        if (this.adR && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStop must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityStop() {
        this.adR = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wS() {
        this.adS = true;
        onActivityDestroy();
        if (this.adS && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityDestroy must call");
        }
    }

    protected void onActivityDestroy() {
        this.adS = false;
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().removeMessage(this.unique_id);
        com.baidu.adp.lib.f.d.ec().d(this.unique_id);
    }

    public boolean wT() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wU() {
        this.adL = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wV() {
        this.adL = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wW() {
        return this.adL;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View wX() {
        if (this.rootView == null) {
            this.rootView = getLayoutInflater().inflate(kB(), (ViewGroup) null);
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e<?, ?, ?> eVar) {
        this.adH = eVar;
        this.mContext = eVar.getPageContext();
    }

    public final e<?, ?, ?> wG() {
        return this.adH;
    }

    public final ViewEventCenter wH() {
        return this.adH.wH();
    }

    public final View getView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.adK != null) {
            int size = this.adK.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.mvc.j.d<?, ?> dVar = this.adK.get(i2);
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
        return this.adH.getPageContext();
    }

    public Activity getActivity() {
        return getPageContext().getPageActivity();
    }

    public Resources getResources() {
        return getPageContext().getResources();
    }

    public LayoutInflater getLayoutInflater() {
        return this.adH.getLayoutInflater();
    }

    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean wI() {
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

    public com.baidu.tbadk.mvc.c.c wJ() {
        if (this.adG == null) {
            this.adG = new com.baidu.tbadk.mvc.c.c(this.unique_id);
        }
        return this.adG;
    }

    public boolean dF(int i) {
        return dispatchMvcEvent(wJ().dJ(i));
    }

    public boolean g(int i, boolean z) {
        return dispatchMvcEvent(wJ().i(i, z));
    }

    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar != null) {
            bVar.setUniqueId(this.unique_id);
        }
        return wH().dispatchMvcEvent(bVar);
    }
}

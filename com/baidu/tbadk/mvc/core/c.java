package com.baidu.tbadk.mvc.core;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.tieba.tbadkCore.ab;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c extends g implements com.baidu.tbadk.mvc.c.a, ab {
    private com.baidu.tbadk.mvc.c.c anl;
    protected e<?, ?, ?> anm;
    d ano;
    protected List<com.baidu.tbadk.mvc.j.e<?, ?>> anp;
    private boolean anq;
    boolean anr;
    boolean ans;
    boolean ant;
    boolean anu;
    boolean anv;
    boolean anw;
    boolean anx;
    protected View rootView;
    protected BdUniqueId unique_id;

    protected abstract int oK();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void oL();

    public c(e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.unique_id = null;
        this.unique_id = eVar.getUniqueId();
        this.anm = eVar;
    }

    public c() {
        super(null);
        this.unique_id = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Bundle bundle) {
        this.anr = true;
        g(bundle);
        if (this.anr && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityCreate must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Bundle bundle) {
        this.anr = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void AP() {
        this.ans = true;
        oH();
        if (this.ans && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStart must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oH() {
        this.ans = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void AQ() {
        this.ant = true;
        AR();
        if (this.ant && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityRestart must call");
        }
    }

    protected void AR() {
        this.ant = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void AS() {
        this.anu = true;
        AT();
        if (this.anu && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityResume must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AT() {
        this.anu = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void AU() {
        this.anv = true;
        AV();
        if (this.anv && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityPause must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AV() {
        this.anv = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void AW() {
        this.anw = true;
        onActivityStop();
        if (this.anw && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStop must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityStop() {
        this.anw = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void AX() {
        this.anx = true;
        onActivityDestroy();
        if (this.anx && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityDestroy must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.anx = false;
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().removeMessage(this.unique_id);
        com.baidu.adp.lib.f.d.hl().d(this.unique_id);
    }

    public boolean AY() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AZ() {
        this.anq = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ba() {
        this.anq = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Bb() {
        return this.anq;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Bc() {
        if (this.rootView == null) {
            this.rootView = getLayoutInflater().inflate(oK(), (ViewGroup) null);
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e<?, ?, ?> eVar) {
        this.anm = eVar;
        this.mContext = eVar.getPageContext();
    }

    public final e<?, ?, ?> AL() {
        return this.anm;
    }

    public final ViewEventCenter AM() {
        return this.anm.AM();
    }

    public final View getView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.anp != null) {
            int size = this.anp.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.mvc.j.e<?, ?> eVar = this.anp.get(i2);
                if (eVar != null) {
                    eVar.a(tbPageContext, i);
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
        return this.anm.getPageContext();
    }

    public Context getContext() {
        return getPageContext().getContext();
    }

    public Activity getActivity() {
        return getPageContext().getPageActivity();
    }

    public Resources getResources() {
        return getPageContext().getResources();
    }

    public LayoutInflater getLayoutInflater() {
        return this.anm.getLayoutInflater();
    }

    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean AN() {
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

    public com.baidu.tbadk.mvc.c.c AO() {
        if (this.anl == null) {
            this.anl = new com.baidu.tbadk.mvc.c.c(this.unique_id);
        }
        return this.anl;
    }

    public boolean dS(int i) {
        return dispatchMvcEvent(AO().dW(i));
    }

    public boolean g(int i, boolean z) {
        return dispatchMvcEvent(AO().i(i, z));
    }

    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar != null) {
            bVar.setUniqueId(this.unique_id);
        }
        return AM().dispatchMvcEvent(bVar);
    }
}

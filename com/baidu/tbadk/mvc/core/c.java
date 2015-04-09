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
    private com.baidu.tbadk.mvc.c.c ami;
    protected e<?, ?, ?> amj;
    d aml;
    protected List<com.baidu.tbadk.mvc.j.e<?, ?>> amm;
    private boolean amn;
    boolean amo;
    boolean amp;
    boolean amq;
    boolean amr;
    boolean ams;
    boolean amt;
    boolean amu;
    protected View rootView;
    protected BdUniqueId unique_id;

    protected abstract int ou();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ov();

    public c(e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.unique_id = null;
        this.unique_id = eVar.getUniqueId();
        this.amj = eVar;
    }

    public c() {
        super(null);
        this.unique_id = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Bundle bundle) {
        this.amo = true;
        g(bundle);
        if (this.amo && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityCreate must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Bundle bundle) {
        this.amo = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ac() {
        this.amp = true;
        or();
        if (this.amp && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStart must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void or() {
        this.amp = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ad() {
        this.amq = true;
        Ae();
        if (this.amq && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityRestart must call");
        }
    }

    protected void Ae() {
        this.amq = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Af() {
        this.amr = true;
        Ag();
        if (this.amr && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityResume must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ag() {
        this.amr = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ah() {
        this.ams = true;
        Ai();
        if (this.ams && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityPause must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ai() {
        this.ams = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Aj() {
        this.amt = true;
        onActivityStop();
        if (this.amt && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStop must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityStop() {
        this.amt = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ak() {
        this.amu = true;
        onActivityDestroy();
        if (this.amu && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityDestroy must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.amu = false;
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().removeMessage(this.unique_id);
        com.baidu.adp.lib.f.d.hB().d(this.unique_id);
    }

    public boolean Al() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Am() {
        this.amn = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void An() {
        this.amn = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ao() {
        return this.amn;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Ap() {
        if (this.rootView == null) {
            this.rootView = getLayoutInflater().inflate(ou(), (ViewGroup) null);
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e<?, ?, ?> eVar) {
        this.amj = eVar;
        this.mContext = eVar.getPageContext();
    }

    public final e<?, ?, ?> zY() {
        return this.amj;
    }

    public final ViewEventCenter zZ() {
        return this.amj.zZ();
    }

    public final View getView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.amm != null) {
            int size = this.amm.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.mvc.j.e<?, ?> eVar = this.amm.get(i2);
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
        return this.amj.getPageContext();
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
        return this.amj.getLayoutInflater();
    }

    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Aa() {
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

    public com.baidu.tbadk.mvc.c.c Ab() {
        if (this.ami == null) {
            this.ami = new com.baidu.tbadk.mvc.c.c(this.unique_id);
        }
        return this.ami;
    }

    public boolean dI(int i) {
        return dispatchMvcEvent(Ab().dM(i));
    }

    public boolean g(int i, boolean z) {
        return dispatchMvcEvent(Ab().i(i, z));
    }

    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar != null) {
            bVar.setUniqueId(this.unique_id);
        }
        return zZ().dispatchMvcEvent(bVar);
    }
}

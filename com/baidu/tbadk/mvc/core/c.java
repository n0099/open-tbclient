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
    private com.baidu.tbadk.mvc.c.c ama;
    protected e<?, ?, ?> amb;
    d amd;
    protected List<com.baidu.tbadk.mvc.j.e<?, ?>> ame;
    private boolean amf;
    boolean amg;
    boolean amh;
    boolean ami;
    boolean amj;
    boolean amk;
    boolean aml;
    boolean amm;
    protected View rootView;
    protected BdUniqueId unique_id;

    protected abstract int ou();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void ov();

    public c(e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.unique_id = null;
        this.unique_id = eVar.getUniqueId();
        this.amb = eVar;
    }

    public c() {
        super(null);
        this.unique_id = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Bundle bundle) {
        this.amg = true;
        g(bundle);
        if (this.amg && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityCreate must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Bundle bundle) {
        this.amg = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zW() {
        this.amh = true;
        or();
        if (this.amh && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStart must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void or() {
        this.amh = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zX() {
        this.ami = true;
        zY();
        if (this.ami && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityRestart must call");
        }
    }

    protected void zY() {
        this.ami = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zZ() {
        this.amj = true;
        Aa();
        if (this.amj && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityResume must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Aa() {
        this.amj = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ab() {
        this.amk = true;
        Ac();
        if (this.amk && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityPause must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ac() {
        this.amk = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ad() {
        this.aml = true;
        onActivityStop();
        if (this.aml && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStop must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityStop() {
        this.aml = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ae() {
        this.amm = true;
        onActivityDestroy();
        if (this.amm && TbadkCoreApplication.m411getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityDestroy must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.amm = false;
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().removeMessage(this.unique_id);
        com.baidu.adp.lib.f.d.hB().d(this.unique_id);
    }

    public boolean Af() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ag() {
        this.amf = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ah() {
        this.amf = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ai() {
        return this.amf;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Aj() {
        if (this.rootView == null) {
            this.rootView = getLayoutInflater().inflate(ou(), (ViewGroup) null);
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e<?, ?, ?> eVar) {
        this.amb = eVar;
        this.mContext = eVar.getPageContext();
    }

    public final e<?, ?, ?> zS() {
        return this.amb;
    }

    public final ViewEventCenter zT() {
        return this.amb.zT();
    }

    public final View getView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.ame != null) {
            int size = this.ame.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.mvc.j.e<?, ?> eVar = this.ame.get(i2);
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
        return this.amb.getPageContext();
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
        return this.amb.getLayoutInflater();
    }

    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean zU() {
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

    public com.baidu.tbadk.mvc.c.c zV() {
        if (this.ama == null) {
            this.ama = new com.baidu.tbadk.mvc.c.c(this.unique_id);
        }
        return this.ama;
    }

    public boolean dI(int i) {
        return dispatchMvcEvent(zV().dM(i));
    }

    public boolean g(int i, boolean z) {
        return dispatchMvcEvent(zV().i(i, z));
    }

    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar != null) {
            bVar.setUniqueId(this.unique_id);
        }
        return zT().dispatchMvcEvent(bVar);
    }
}

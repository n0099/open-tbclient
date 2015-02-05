package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import com.baidu.tbadk.core.data.ErrorData;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.adp.base.f implements com.baidu.tbadk.mvc.c.a {
    b adF;
    private com.baidu.tbadk.mvc.c.c adG;
    protected e<?, ?, ?> adH;

    public a(e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.adH = eVar;
    }

    public void f(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    protected void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e<?, ?, ?> eVar) {
        this.adH = eVar;
    }

    public final e<?, ?, ?> wG() {
        return this.adH;
    }

    public final ViewEventCenter wH() {
        return this.adH.wH();
    }

    @Override // com.baidu.adp.base.f
    @Deprecated
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    @Deprecated
    public boolean cancelLoadData() {
        return false;
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

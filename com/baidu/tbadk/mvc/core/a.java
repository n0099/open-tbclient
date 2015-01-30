package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import com.baidu.tbadk.core.data.ErrorData;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.adp.base.f implements com.baidu.tbadk.mvc.c.a {
    b adI;
    private com.baidu.tbadk.mvc.c.c adJ;
    protected e<?, ?, ?> adK;

    public a(e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.adK = eVar;
    }

    public void f(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    protected void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e<?, ?, ?> eVar) {
        this.adK = eVar;
    }

    public final e<?, ?, ?> wM() {
        return this.adK;
    }

    public final ViewEventCenter wN() {
        return this.adK.wN();
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

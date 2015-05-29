package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import com.baidu.tbadk.core.data.ErrorData;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.adp.base.f implements com.baidu.tbadk.mvc.c.a {
    b ank;
    private com.baidu.tbadk.mvc.c.c anl;
    protected e<?, ?, ?> anm;

    public a(e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.anm = eVar;
    }

    public void f(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    protected void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e<?, ?, ?> eVar) {
        this.anm = eVar;
    }

    public final e<?, ?, ?> AK() {
        return this.anm;
    }

    public final ViewEventCenter AL() {
        return this.anm.AL();
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
    public boolean AM() {
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

    public com.baidu.tbadk.mvc.c.c AN() {
        if (this.anl == null) {
            this.anl = new com.baidu.tbadk.mvc.c.c(this.unique_id);
        }
        return this.anl;
    }

    public boolean dS(int i) {
        return dispatchMvcEvent(AN().dW(i));
    }

    public boolean g(int i, boolean z) {
        return dispatchMvcEvent(AN().i(i, z));
    }

    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar != null) {
            bVar.setUniqueId(this.unique_id);
        }
        return AL().dispatchMvcEvent(bVar);
    }
}

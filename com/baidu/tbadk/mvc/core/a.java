package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import com.baidu.tbadk.core.data.ErrorData;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.adp.base.f implements com.baidu.tbadk.mvc.c.a {
    b adl;
    private com.baidu.tbadk.mvc.c.c adm;
    protected e<?, ?, ?> adn;

    public a(e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.adn = eVar;
    }

    public void f(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    protected void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e<?, ?, ?> eVar) {
        this.adn = eVar;
    }

    public final e<?, ?, ?> ww() {
        return this.adn;
    }

    public final ViewEventCenter wx() {
        return this.adn.wx();
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
    public boolean wy() {
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

    public com.baidu.tbadk.mvc.c.c wz() {
        if (this.adm == null) {
            this.adm = new com.baidu.tbadk.mvc.c.c(this.unique_id);
        }
        return this.adm;
    }

    public boolean dz(int i) {
        return dispatchMvcEvent(wz().dD(i));
    }

    public boolean g(int i, boolean z) {
        return dispatchMvcEvent(wz().i(i, z));
    }

    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar != null) {
            bVar.setUniqueId(this.unique_id);
        }
        return wx().dispatchMvcEvent(bVar);
    }
}

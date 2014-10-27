package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import com.baidu.adp.base.e;
/* loaded from: classes.dex */
public abstract class a extends e {
    b Xd;
    private com.baidu.tbadk.mvc.c.c Xe;
    protected MvcActivity<?, ?> Xf;

    public a(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
        this.Xf = mvcActivity;
    }

    public void b(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MvcActivity<?, ?> mvcActivity) {
        this.Xf = mvcActivity;
    }

    public final MvcActivity<?, ?> sX() {
        return this.Xf;
    }

    public final ViewEventCenter sY() {
        return this.Xf.sY();
    }

    @Override // com.baidu.adp.base.e
    @Deprecated
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    @Deprecated
    public boolean cancelLoadData() {
        return false;
    }

    public com.baidu.tbadk.mvc.c.c sZ() {
        if (this.Xe == null) {
            this.Xe = new com.baidu.tbadk.mvc.c.c(this.unique_id);
        }
        return this.Xe;
    }

    public boolean de(int i) {
        return dispatchMvcEvent(sZ().dj(i));
    }

    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar != null) {
            bVar.setUniqueId(this.unique_id);
        }
        return sY().dispatchMvcEvent(bVar);
    }
}

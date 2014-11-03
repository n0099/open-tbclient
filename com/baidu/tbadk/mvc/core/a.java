package com.baidu.tbadk.mvc.core;

import android.os.Bundle;
import com.baidu.adp.base.e;
/* loaded from: classes.dex */
public abstract class a extends e {
    b Xh;
    private com.baidu.tbadk.mvc.c.c Xi;
    protected MvcActivity<?, ?> Xj;

    public a(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
        this.Xj = mvcActivity;
    }

    public void b(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MvcActivity<?, ?> mvcActivity) {
        this.Xj = mvcActivity;
    }

    public final MvcActivity<?, ?> sZ() {
        return this.Xj;
    }

    public final ViewEventCenter ta() {
        return this.Xj.ta();
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

    public com.baidu.tbadk.mvc.c.c tb() {
        if (this.Xi == null) {
            this.Xi = new com.baidu.tbadk.mvc.c.c(this.unique_id);
        }
        return this.Xi;
    }

    public boolean de(int i) {
        return dispatchMvcEvent(tb().dj(i));
    }

    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar != null) {
            bVar.setUniqueId(this.unique_id);
        }
        return ta().dispatchMvcEvent(bVar);
    }
}

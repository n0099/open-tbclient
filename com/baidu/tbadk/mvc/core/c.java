package com.baidu.tbadk.mvc.core;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.data.ErrorData;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c extends f implements com.baidu.tbadk.e.a, com.baidu.tbadk.mvc.c.a {
    private com.baidu.tbadk.mvc.c.c Xe;
    protected MvcActivity<?, ?> Xf;
    d Xh;
    protected View Xi;
    protected List<com.baidu.tbadk.mvc.i.d<?, ?>> Xj;
    protected BdUniqueId unique_id;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void tg();

    protected abstract int th();

    public c(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
        this.unique_id = null;
        this.Xf = mvcActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ta() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tb() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityStop() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().removeMessage(this.unique_id);
        com.baidu.adp.lib.f.d.ef().d(this.unique_id);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void td() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void te() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View tf() {
        if (this.Xi == null) {
            this.Xi = getLayoutInflater().inflate(th(), (ViewGroup) null);
        }
        return this.Xi;
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

    public final View getView() {
        return this.Xi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    @Override // com.baidu.tbadk.e.a
    public boolean dg(int i) {
        if (this.Xj != null) {
            int size = this.Xj.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.mvc.i.d<?, ?> dVar = this.Xj.get(i2);
                if (dVar != null) {
                    dVar.dg(i);
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

    public Resources getResources() {
        return this.Xf.getResources();
    }

    public LayoutInflater getLayoutInflater() {
        return this.Xf.getLayoutInflater();
    }

    public String getString(int i) {
        return this.Xf.getString(i);
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean ti() {
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

    public com.baidu.tbadk.mvc.c.c sZ() {
        if (this.Xe == null) {
            this.Xe = new com.baidu.tbadk.mvc.c.c(this.unique_id);
        }
        return this.Xe;
    }

    public boolean de(int i) {
        return dispatchMvcEvent(sZ().dj(i));
    }

    public boolean g(int i, boolean z) {
        return dispatchMvcEvent(sZ().i(i, z));
    }

    public boolean dispatchMvcEvent(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar != null) {
            bVar.setUniqueId(this.unique_id);
        }
        return sY().dispatchMvcEvent(bVar);
    }
}

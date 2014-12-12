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
import com.baidu.tieba.tbadkCore.y;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c extends g implements com.baidu.tbadk.mvc.c.a, y {
    private com.baidu.tbadk.mvc.c.c adm;
    protected e<?, ?, ?> adn;
    d adp;
    protected List<com.baidu.tbadk.mvc.j.d<?, ?>> adq;
    private boolean adr;
    boolean ads;
    boolean adt;
    boolean adu;
    boolean adv;
    boolean adw;
    boolean adx;
    boolean ady;
    protected View rootView;
    protected BdUniqueId unique_id;

    protected abstract int kI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void kJ();

    public c(e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.unique_id = null;
        this.unique_id = eVar.getUniqueId();
        this.adn = eVar;
    }

    public c() {
        super(null);
        this.unique_id = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Bundle bundle) {
        this.ads = true;
        g(bundle);
        if (this.ads && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityCreate must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Bundle bundle) {
        this.ads = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wA() {
        this.adt = true;
        kF();
        if (this.adt && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStart must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kF() {
        this.adt = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wB() {
        this.adu = true;
        wC();
        if (this.adu && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityRestart must call");
        }
    }

    protected void wC() {
        this.adu = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wD() {
        this.adv = true;
        wE();
        if (this.adv && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityResume must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wE() {
        this.adv = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wF() {
        this.adw = true;
        wG();
        if (this.adw && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityPause must call");
        }
    }

    protected void wG() {
        this.adw = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wH() {
        this.adx = true;
        onActivityStop();
        if (this.adx && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityStop must call");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityStop() {
        this.adx = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wI() {
        this.ady = true;
        onActivityDestroy();
        if (this.ady && TbadkCoreApplication.m255getInst().isDebugMode()) {
            throw new RuntimeException("super.onActivityDestroy must call");
        }
    }

    protected void onActivityDestroy() {
        this.ady = false;
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().removeMessage(this.unique_id);
        com.baidu.adp.lib.f.d.ee().d(this.unique_id);
    }

    public boolean wJ() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wK() {
        this.adr = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wL() {
        this.adr = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wM() {
        return this.adr;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View wN() {
        if (this.rootView == null) {
            this.rootView = getLayoutInflater().inflate(kI(), (ViewGroup) null);
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(e<?, ?, ?> eVar) {
        this.adn = eVar;
        this.mContext = eVar.getPageContext();
    }

    public final e<?, ?, ?> ww() {
        return this.adn;
    }

    public final ViewEventCenter wx() {
        return this.adn.wx();
    }

    public final View getView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.adq != null) {
            int size = this.adq.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tbadk.mvc.j.d<?, ?> dVar = this.adq.get(i2);
                if (dVar != null) {
                    dVar.a(tbPageContext, i);
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
        return this.adn.getPageContext();
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
        return this.adn.getLayoutInflater();
    }

    public String getString(int i) {
        return getResources().getString(i);
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

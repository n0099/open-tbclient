package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aFq;
    private boolean aFr = true;
    private com.baidu.tbadk.mvc.b.a aFs;
    private com.baidu.tbadk.mvc.d.b aFt;
    private com.baidu.tbadk.mvc.a.a aFu;
    private int aFv;
    private Object aFw;
    private WeakReference<View> aFx;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aFq = i;
        this.aFs = aVar;
        this.aFt = bVar;
        this.aFu = aVar2;
    }

    public int EG() {
        return this.aFq;
    }

    public com.baidu.tbadk.mvc.b.a EH() {
        return this.aFs;
    }

    public Object getExtra() {
        return this.aFw;
    }

    public void setExtra(Object obj) {
        this.aFw = obj;
    }

    public View getView() {
        if (this.aFx != null) {
            return this.aFx.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aFx = new WeakReference<>(view);
    }

    public void eV(int i) {
        this.aFv = i;
    }

    public boolean EI() {
        return this.aFr;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

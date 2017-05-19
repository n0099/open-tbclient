package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aEp;
    private boolean aEq = true;
    private com.baidu.tbadk.mvc.b.a aEr;
    private com.baidu.tbadk.mvc.d.b aEs;
    private com.baidu.tbadk.mvc.a.a aEt;
    private int aEu;
    private Object aEv;
    private WeakReference<View> aEw;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aEp = i;
        this.aEr = aVar;
        this.aEs = bVar;
        this.aEt = aVar2;
    }

    public int Ep() {
        return this.aEp;
    }

    public com.baidu.tbadk.mvc.b.a Eq() {
        return this.aEr;
    }

    public Object getExtra() {
        return this.aEv;
    }

    public void setExtra(Object obj) {
        this.aEv = obj;
    }

    public View getView() {
        if (this.aEw != null) {
            return this.aEw.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aEw = new WeakReference<>(view);
    }

    public void eS(int i) {
        this.aEu = i;
    }

    public boolean Er() {
        return this.aEq;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

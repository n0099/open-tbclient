package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aEk;
    private boolean aEl = true;
    private com.baidu.tbadk.mvc.b.a aEm;
    private com.baidu.tbadk.mvc.d.b aEn;
    private com.baidu.tbadk.mvc.a.a aEo;
    private int aEp;
    private Object aEq;
    private WeakReference<View> aEr;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aEk = i;
        this.aEm = aVar;
        this.aEn = bVar;
        this.aEo = aVar2;
    }

    public int Fl() {
        return this.aEk;
    }

    public com.baidu.tbadk.mvc.b.a Fm() {
        return this.aEm;
    }

    public Object getExtra() {
        return this.aEq;
    }

    public void setExtra(Object obj) {
        this.aEq = obj;
    }

    public View getView() {
        if (this.aEr != null) {
            return this.aEr.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aEr = new WeakReference<>(view);
    }

    public void eW(int i) {
        this.aEp = i;
    }

    public boolean Fn() {
        return this.aEl;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

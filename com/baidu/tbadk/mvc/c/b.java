package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aEi;
    private boolean aEj = true;
    private com.baidu.tbadk.mvc.b.a aEk;
    private com.baidu.tbadk.mvc.d.b aEl;
    private com.baidu.tbadk.mvc.a.a aEm;
    private int aEn;
    private Object aEo;
    private WeakReference<View> aEp;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aEi = i;
        this.aEk = aVar;
        this.aEl = bVar;
        this.aEm = aVar2;
    }

    public int Fl() {
        return this.aEi;
    }

    public com.baidu.tbadk.mvc.b.a Fm() {
        return this.aEk;
    }

    public Object getExtra() {
        return this.aEo;
    }

    public void setExtra(Object obj) {
        this.aEo = obj;
    }

    public View getView() {
        if (this.aEp != null) {
            return this.aEp.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aEp = new WeakReference<>(view);
    }

    public void eW(int i) {
        this.aEn = i;
    }

    public boolean Fn() {
        return this.aEj;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aHq;
    private boolean aHr = true;
    private com.baidu.tbadk.mvc.b.a aHs;
    private com.baidu.tbadk.mvc.d.b aHt;
    private com.baidu.tbadk.mvc.a.a aHu;
    private int aHv;
    private Object aHw;
    private WeakReference<View> aHx;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aHq = i;
        this.aHs = aVar;
        this.aHt = bVar;
        this.aHu = aVar2;
    }

    public int Fd() {
        return this.aHq;
    }

    public com.baidu.tbadk.mvc.b.a Fe() {
        return this.aHs;
    }

    public Object getExtra() {
        return this.aHw;
    }

    public void setExtra(Object obj) {
        this.aHw = obj;
    }

    public View getView() {
        if (this.aHx != null) {
            return this.aHx.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aHx = new WeakReference<>(view);
    }

    public void fa(int i) {
        this.aHv = i;
    }

    public boolean Ff() {
        return this.aHr;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private WeakReference<View> aHA;
    private int aHt;
    private boolean aHu = true;
    private com.baidu.tbadk.mvc.b.a aHv;
    private com.baidu.tbadk.mvc.d.b aHw;
    private com.baidu.tbadk.mvc.a.a aHx;
    private int aHy;
    private Object aHz;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aHt = i;
        this.aHv = aVar;
        this.aHw = bVar;
        this.aHx = aVar2;
    }

    public int Fd() {
        return this.aHt;
    }

    public com.baidu.tbadk.mvc.b.a Fe() {
        return this.aHv;
    }

    public Object getExtra() {
        return this.aHz;
    }

    public void setExtra(Object obj) {
        this.aHz = obj;
    }

    public View getView() {
        if (this.aHA != null) {
            return this.aHA.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aHA = new WeakReference<>(view);
    }

    public void fa(int i) {
        this.aHy = i;
    }

    public boolean Ff() {
        return this.aHu;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

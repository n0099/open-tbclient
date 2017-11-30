package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aHY;
    private boolean aHZ = true;
    private com.baidu.tbadk.mvc.b.a aIa;
    private com.baidu.tbadk.mvc.d.b aIb;
    private com.baidu.tbadk.mvc.a.a aIc;
    private int aId;
    private WeakReference<View> aIe;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aHY = i;
        this.aIa = aVar;
        this.aIb = bVar;
        this.aIc = aVar2;
    }

    public int Fh() {
        return this.aHY;
    }

    public com.baidu.tbadk.mvc.b.a Fi() {
        return this.aIa;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public View getView() {
        if (this.aIe != null) {
            return this.aIe.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aIe = new WeakReference<>(view);
    }

    public void fj(int i) {
        this.aId = i;
    }

    public boolean Fj() {
        return this.aHZ;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

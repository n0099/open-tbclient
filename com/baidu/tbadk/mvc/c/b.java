package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tbadk.mvc.b.a axA;
    private com.baidu.tbadk.mvc.d.b axB;
    private com.baidu.tbadk.mvc.a.a axC;
    private int axD;
    private Object axE;
    private WeakReference<View> axF;
    private int axy;
    private boolean axz = true;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.axy = i;
        this.axA = aVar;
        this.axB = bVar;
        this.axC = aVar2;
    }

    public int Dj() {
        return this.axy;
    }

    public com.baidu.tbadk.mvc.b.a Dk() {
        return this.axA;
    }

    public Object getExtra() {
        return this.axE;
    }

    public void setExtra(Object obj) {
        this.axE = obj;
    }

    public View getView() {
        if (this.axF != null) {
            return this.axF.get();
        }
        return null;
    }

    public void setView(View view) {
        this.axF = new WeakReference<>(view);
    }

    public int Dl() {
        return this.axD;
    }

    public void ew(int i) {
        this.axD = i;
    }

    public boolean Dm() {
        return this.axz;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

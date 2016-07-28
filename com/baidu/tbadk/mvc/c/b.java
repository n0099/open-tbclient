package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int awF;
    private boolean awG = true;
    private com.baidu.tbadk.mvc.b.a awH;
    private com.baidu.tbadk.mvc.d.b awI;
    private com.baidu.tbadk.mvc.a.a awJ;
    private int awK;
    private Object awL;
    private WeakReference<View> awM;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.awF = i;
        this.awH = aVar;
        this.awI = bVar;
        this.awJ = aVar2;
    }

    public int Dr() {
        return this.awF;
    }

    public com.baidu.tbadk.mvc.b.a Ds() {
        return this.awH;
    }

    public Object getExtra() {
        return this.awL;
    }

    public void setExtra(Object obj) {
        this.awL = obj;
    }

    public View getView() {
        if (this.awM != null) {
            return this.awM.get();
        }
        return null;
    }

    public void setView(View view) {
        this.awM = new WeakReference<>(view);
    }

    public int Dt() {
        return this.awK;
    }

    public void eG(int i) {
        this.awK = i;
    }

    public boolean Du() {
        return this.awG;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

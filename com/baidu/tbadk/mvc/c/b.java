package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int awC;
    private boolean awD = true;
    private com.baidu.tbadk.mvc.b.a awE;
    private com.baidu.tbadk.mvc.d.b awF;
    private com.baidu.tbadk.mvc.a.a awG;
    private int awH;
    private Object awI;
    private WeakReference<View> awJ;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.awC = i;
        this.awE = aVar;
        this.awF = bVar;
        this.awG = aVar2;
    }

    public int CQ() {
        return this.awC;
    }

    public com.baidu.tbadk.mvc.b.a CR() {
        return this.awE;
    }

    public Object getExtra() {
        return this.awI;
    }

    public void setExtra(Object obj) {
        this.awI = obj;
    }

    public View getView() {
        if (this.awJ != null) {
            return this.awJ.get();
        }
        return null;
    }

    public void setView(View view) {
        this.awJ = new WeakReference<>(view);
    }

    public int CS() {
        return this.awH;
    }

    public void ep(int i) {
        this.awH = i;
    }

    public boolean CT() {
        return this.awD;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

package com.baidu.tbadk.mvc.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int anA;
    private boolean anB = true;
    private com.baidu.tbadk.mvc.b.a anC;
    private com.baidu.tbadk.mvc.e.c anD;
    private com.baidu.tbadk.mvc.a.a anE;
    private boolean anF;
    private int anG;
    private Object anH;
    private WeakReference<View> anI;
    private WeakReference<ViewGroup> anJ;
    private BdUniqueId uniqueId;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i) {
        this.anA = i;
    }

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.e.c cVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.anA = i;
        this.anC = aVar;
        this.anD = cVar;
        this.anE = aVar2;
    }

    public int Br() {
        return this.anA;
    }

    public com.baidu.tbadk.mvc.b.a Bs() {
        return this.anC;
    }

    public com.baidu.tbadk.mvc.e.c Bt() {
        return this.anD;
    }

    public com.baidu.tbadk.mvc.a.a Bu() {
        return this.anE;
    }

    public Object getExtra() {
        return this.anH;
    }

    public void setExtra(Object obj) {
        this.anH = obj;
    }

    public View getView() {
        if (this.anI != null) {
            return this.anI.get();
        }
        return null;
    }

    public void setView(View view) {
        this.anI = new WeakReference<>(view);
    }

    public void d(ViewGroup viewGroup) {
        this.anJ = new WeakReference<>(viewGroup);
    }

    public boolean Bv() {
        return this.anF;
    }

    public void aZ(boolean z) {
        this.anF = z;
    }

    public int Bw() {
        return this.anG;
    }

    public void dV(int i) {
        this.anG = i;
    }

    public boolean Bx() {
        return this.anB;
    }

    public void ba(boolean z) {
        this.anB = z;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

package com.baidu.tbadk.mvc.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tbadk.mvc.e.c amA;
    private com.baidu.tbadk.mvc.a.a amB;
    private boolean amC;
    private int amD;
    private Object amE;
    private WeakReference<View> amF;
    private WeakReference<ViewGroup> amG;
    private int amx;
    private boolean amy = true;
    private com.baidu.tbadk.mvc.b.a amz;
    private BdUniqueId uniqueId;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i) {
        this.amx = i;
    }

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.e.c cVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.amx = i;
        this.amz = aVar;
        this.amA = cVar;
        this.amB = aVar2;
    }

    public int AF() {
        return this.amx;
    }

    public com.baidu.tbadk.mvc.b.a AG() {
        return this.amz;
    }

    public com.baidu.tbadk.mvc.e.c AH() {
        return this.amA;
    }

    public com.baidu.tbadk.mvc.a.a AI() {
        return this.amB;
    }

    public Object getExtra() {
        return this.amE;
    }

    public void setExtra(Object obj) {
        this.amE = obj;
    }

    public View getView() {
        if (this.amF != null) {
            return this.amF.get();
        }
        return null;
    }

    public void setView(View view) {
        this.amF = new WeakReference<>(view);
    }

    public void d(ViewGroup viewGroup) {
        this.amG = new WeakReference<>(viewGroup);
    }

    public boolean AJ() {
        return this.amC;
    }

    public void aS(boolean z) {
        this.amC = z;
    }

    public int AK() {
        return this.amD;
    }

    public void dL(int i) {
        this.amD = i;
    }

    public boolean AL() {
        return this.amy;
    }

    public void aT(boolean z) {
        this.amy = z;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

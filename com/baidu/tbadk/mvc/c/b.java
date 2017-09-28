package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aGR;
    private boolean aGS = true;
    private com.baidu.tbadk.mvc.b.a aGT;
    private com.baidu.tbadk.mvc.d.b aGU;
    private com.baidu.tbadk.mvc.a.a aGV;
    private int aGW;
    private Object aGX;
    private WeakReference<View> aGY;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aGR = i;
        this.aGT = aVar;
        this.aGU = bVar;
        this.aGV = aVar2;
    }

    public int EI() {
        return this.aGR;
    }

    public com.baidu.tbadk.mvc.b.a EJ() {
        return this.aGT;
    }

    public Object getExtra() {
        return this.aGX;
    }

    public void setExtra(Object obj) {
        this.aGX = obj;
    }

    public View getView() {
        if (this.aGY != null) {
            return this.aGY.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aGY = new WeakReference<>(view);
    }

    public void fl(int i) {
        this.aGW = i;
    }

    public boolean EK() {
        return this.aGS;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

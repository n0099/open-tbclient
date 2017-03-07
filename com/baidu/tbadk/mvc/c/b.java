package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aDS;
    private boolean aDT = true;
    private com.baidu.tbadk.mvc.b.a aDU;
    private com.baidu.tbadk.mvc.d.b aDV;
    private com.baidu.tbadk.mvc.a.a aDW;
    private int aDX;
    private Object aDY;
    private WeakReference<View> aDZ;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aDS = i;
        this.aDU = aVar;
        this.aDV = bVar;
        this.aDW = aVar2;
    }

    public int EN() {
        return this.aDS;
    }

    public com.baidu.tbadk.mvc.b.a EO() {
        return this.aDU;
    }

    public Object getExtra() {
        return this.aDY;
    }

    public void setExtra(Object obj) {
        this.aDY = obj;
    }

    public View getView() {
        if (this.aDZ != null) {
            return this.aDZ.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aDZ = new WeakReference<>(view);
    }

    public void eT(int i) {
        this.aDX = i;
    }

    public boolean EP() {
        return this.aDT;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

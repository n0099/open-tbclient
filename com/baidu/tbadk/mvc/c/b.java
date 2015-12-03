package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int avU;
    private boolean avV = true;
    private com.baidu.tbadk.mvc.b.a avW;
    private com.baidu.tbadk.mvc.d.b avX;
    private com.baidu.tbadk.mvc.a.a avY;
    private int avZ;
    private Object awa;
    private WeakReference<View> awb;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.avU = i;
        this.avW = aVar;
        this.avX = bVar;
        this.avY = aVar2;
    }

    public int Du() {
        return this.avU;
    }

    public com.baidu.tbadk.mvc.b.a Dv() {
        return this.avW;
    }

    public Object getExtra() {
        return this.awa;
    }

    public void setExtra(Object obj) {
        this.awa = obj;
    }

    public View getView() {
        if (this.awb != null) {
            return this.awb.get();
        }
        return null;
    }

    public void setView(View view) {
        this.awb = new WeakReference<>(view);
    }

    public int Dw() {
        return this.avZ;
    }

    public void eC(int i) {
        this.avZ = i;
    }

    public boolean Dx() {
        return this.avV;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

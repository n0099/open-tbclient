package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int avQ;
    private boolean avR = true;
    private com.baidu.tbadk.mvc.b.a avS;
    private com.baidu.tbadk.mvc.d.b avT;
    private com.baidu.tbadk.mvc.a.a avU;
    private int avV;
    private Object avW;
    private WeakReference<View> avX;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.avQ = i;
        this.avS = aVar;
        this.avT = bVar;
        this.avU = aVar2;
    }

    public int Ds() {
        return this.avQ;
    }

    public com.baidu.tbadk.mvc.b.a Dt() {
        return this.avS;
    }

    public Object getExtra() {
        return this.avW;
    }

    public void setExtra(Object obj) {
        this.avW = obj;
    }

    public View getView() {
        if (this.avX != null) {
            return this.avX.get();
        }
        return null;
    }

    public void setView(View view) {
        this.avX = new WeakReference<>(view);
    }

    public int Du() {
        return this.avV;
    }

    public void eG(int i) {
        this.avV = i;
    }

    public boolean Dv() {
        return this.avR;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

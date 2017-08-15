package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aHO;
    private boolean aHP = true;
    private com.baidu.tbadk.mvc.b.a aHQ;
    private com.baidu.tbadk.mvc.d.b aHR;
    private com.baidu.tbadk.mvc.a.a aHS;
    private int aHT;
    private Object aHU;
    private WeakReference<View> aHV;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aHO = i;
        this.aHQ = aVar;
        this.aHR = bVar;
        this.aHS = aVar2;
    }

    public int Ff() {
        return this.aHO;
    }

    public com.baidu.tbadk.mvc.b.a Fg() {
        return this.aHQ;
    }

    public Object getExtra() {
        return this.aHU;
    }

    public void setExtra(Object obj) {
        this.aHU = obj;
    }

    public View getView() {
        if (this.aHV != null) {
            return this.aHV.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aHV = new WeakReference<>(view);
    }

    public void fa(int i) {
        this.aHT = i;
    }

    public boolean Fh() {
        return this.aHP;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

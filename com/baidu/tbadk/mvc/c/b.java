package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aHN;
    private boolean aHO = true;
    private com.baidu.tbadk.mvc.b.a aHP;
    private com.baidu.tbadk.mvc.d.b aHQ;
    private com.baidu.tbadk.mvc.a.a aHR;
    private int aHS;
    private Object aHT;
    private WeakReference<View> aHU;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aHN = i;
        this.aHP = aVar;
        this.aHQ = bVar;
        this.aHR = aVar2;
    }

    public int Ff() {
        return this.aHN;
    }

    public com.baidu.tbadk.mvc.b.a Fg() {
        return this.aHP;
    }

    public Object getExtra() {
        return this.aHT;
    }

    public void setExtra(Object obj) {
        this.aHT = obj;
    }

    public View getView() {
        if (this.aHU != null) {
            return this.aHU.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aHU = new WeakReference<>(view);
    }

    public void fa(int i) {
        this.aHS = i;
    }

    public boolean Fh() {
        return this.aHO;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

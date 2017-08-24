package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aHP;
    private boolean aHQ = true;
    private com.baidu.tbadk.mvc.b.a aHR;
    private com.baidu.tbadk.mvc.d.b aHS;
    private com.baidu.tbadk.mvc.a.a aHT;
    private int aHU;
    private Object aHV;
    private WeakReference<View> aHW;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aHP = i;
        this.aHR = aVar;
        this.aHS = bVar;
        this.aHT = aVar2;
    }

    public int Ff() {
        return this.aHP;
    }

    public com.baidu.tbadk.mvc.b.a Fg() {
        return this.aHR;
    }

    public Object getExtra() {
        return this.aHV;
    }

    public void setExtra(Object obj) {
        this.aHV = obj;
    }

    public View getView() {
        if (this.aHW != null) {
            return this.aHW.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aHW = new WeakReference<>(view);
    }

    public void fa(int i) {
        this.aHU = i;
    }

    public boolean Fh() {
        return this.aHQ;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

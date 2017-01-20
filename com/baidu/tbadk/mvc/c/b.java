package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private boolean ayA = true;
    private com.baidu.tbadk.mvc.b.a ayB;
    private com.baidu.tbadk.mvc.d.b ayC;
    private com.baidu.tbadk.mvc.a.a ayD;
    private int ayE;
    private Object ayF;
    private WeakReference<View> ayG;
    private int ayz;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.ayz = i;
        this.ayB = aVar;
        this.ayC = bVar;
        this.ayD = aVar2;
    }

    public int Es() {
        return this.ayz;
    }

    public com.baidu.tbadk.mvc.b.a Et() {
        return this.ayB;
    }

    public Object getExtra() {
        return this.ayF;
    }

    public void setExtra(Object obj) {
        this.ayF = obj;
    }

    public View getView() {
        if (this.ayG != null) {
            return this.ayG.get();
        }
        return null;
    }

    public void setView(View view) {
        this.ayG = new WeakReference<>(view);
    }

    public int Eu() {
        return this.ayE;
    }

    public void eY(int i) {
        this.ayE = i;
    }

    public boolean Ev() {
        return this.ayA;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

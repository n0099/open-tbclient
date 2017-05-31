package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aEc;
    private boolean aEd = true;
    private com.baidu.tbadk.mvc.b.a aEe;
    private com.baidu.tbadk.mvc.d.b aEf;
    private com.baidu.tbadk.mvc.a.a aEg;
    private int aEh;
    private Object aEi;
    private WeakReference<View> aEj;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aEc = i;
        this.aEe = aVar;
        this.aEf = bVar;
        this.aEg = aVar2;
    }

    public int Ej() {
        return this.aEc;
    }

    public com.baidu.tbadk.mvc.b.a Ek() {
        return this.aEe;
    }

    public Object getExtra() {
        return this.aEi;
    }

    public void setExtra(Object obj) {
        this.aEi = obj;
    }

    public View getView() {
        if (this.aEj != null) {
            return this.aEj.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aEj = new WeakReference<>(view);
    }

    public void eT(int i) {
        this.aEh = i;
    }

    public boolean El() {
        return this.aEd;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

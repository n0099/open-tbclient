package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aHo;
    private boolean aHp = true;
    private com.baidu.tbadk.mvc.b.a aHq;
    private com.baidu.tbadk.mvc.d.b aHr;
    private com.baidu.tbadk.mvc.a.a aHs;
    private int aHt;
    private Object aHu;
    private WeakReference<View> aHv;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aHo = i;
        this.aHq = aVar;
        this.aHr = bVar;
        this.aHs = aVar2;
    }

    public int EO() {
        return this.aHo;
    }

    public com.baidu.tbadk.mvc.b.a EP() {
        return this.aHq;
    }

    public Object getExtra() {
        return this.aHu;
    }

    public void setExtra(Object obj) {
        this.aHu = obj;
    }

    public View getView() {
        if (this.aHv != null) {
            return this.aHv.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aHv = new WeakReference<>(view);
    }

    public void fl(int i) {
        this.aHt = i;
    }

    public boolean EQ() {
        return this.aHp;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

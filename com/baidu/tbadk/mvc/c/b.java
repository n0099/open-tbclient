package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aAh;
    private boolean aAi = true;
    private com.baidu.tbadk.mvc.b.a aAj;
    private com.baidu.tbadk.mvc.d.b aAk;
    private com.baidu.tbadk.mvc.a.a aAl;
    private int aAm;
    private Object aAn;
    private WeakReference<View> aAo;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aAh = i;
        this.aAj = aVar;
        this.aAk = bVar;
        this.aAl = aVar2;
    }

    public int EQ() {
        return this.aAh;
    }

    public com.baidu.tbadk.mvc.b.a ER() {
        return this.aAj;
    }

    public Object getExtra() {
        return this.aAn;
    }

    public void setExtra(Object obj) {
        this.aAn = obj;
    }

    public View getView() {
        if (this.aAo != null) {
            return this.aAo.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aAo = new WeakReference<>(view);
    }

    public int ES() {
        return this.aAm;
    }

    public void eW(int i) {
        this.aAm = i;
    }

    public boolean ET() {
        return this.aAi;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

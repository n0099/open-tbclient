package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aIc;
    private boolean aId = true;
    private com.baidu.tbadk.mvc.b.a aIe;
    private com.baidu.tbadk.mvc.d.b aIf;
    private com.baidu.tbadk.mvc.a.a aIg;
    private int aIh;
    private WeakReference<View> aIi;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aIc = i;
        this.aIe = aVar;
        this.aIf = bVar;
        this.aIg = aVar2;
    }

    public int Fi() {
        return this.aIc;
    }

    public com.baidu.tbadk.mvc.b.a Fj() {
        return this.aIe;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public View getView() {
        if (this.aIi != null) {
            return this.aIi.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aIi = new WeakReference<>(view);
    }

    public void fj(int i) {
        this.aIh = i;
    }

    public boolean Fk() {
        return this.aId;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

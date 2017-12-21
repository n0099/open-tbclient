package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aIf;
    private boolean aIg = true;
    private com.baidu.tbadk.mvc.b.a aIh;
    private com.baidu.tbadk.mvc.d.b aIi;
    private com.baidu.tbadk.mvc.a.a aIj;
    private int aIk;
    private WeakReference<View> aIl;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aIf = i;
        this.aIh = aVar;
        this.aIi = bVar;
        this.aIj = aVar2;
    }

    public int Fi() {
        return this.aIf;
    }

    public com.baidu.tbadk.mvc.b.a Fj() {
        return this.aIh;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public View getView() {
        if (this.aIl != null) {
            return this.aIl.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aIl = new WeakReference<>(view);
    }

    public void fj(int i) {
        this.aIk = i;
    }

    public boolean Fk() {
        return this.aIg;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int bwl;
    private boolean bwm = true;
    private com.baidu.tbadk.mvc.b.a bwn;
    private com.baidu.tbadk.mvc.d.b bwo;
    private com.baidu.tbadk.mvc.a.a bwp;
    private int bwq;
    private WeakReference<View> bwr;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.bwl = i;
        this.bwn = aVar;
        this.bwo = bVar;
        this.bwp = aVar2;
    }

    public int Mx() {
        return this.bwl;
    }

    public com.baidu.tbadk.mvc.b.a My() {
        return this.bwn;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public View getView() {
        if (this.bwr != null) {
            return this.bwr.get();
        }
        return null;
    }

    public void setView(View view) {
        this.bwr = new WeakReference<>(view);
    }

    public void ie(int i) {
        this.bwq = i;
    }

    public boolean Mz() {
        return this.bwm;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

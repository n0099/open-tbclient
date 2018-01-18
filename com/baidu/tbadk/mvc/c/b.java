package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int bwc;
    private boolean bwd = true;
    private com.baidu.tbadk.mvc.b.a bwe;
    private com.baidu.tbadk.mvc.d.b bwf;
    private com.baidu.tbadk.mvc.a.a bwg;
    private int bwh;
    private WeakReference<View> bwi;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.bwc = i;
        this.bwe = aVar;
        this.bwf = bVar;
        this.bwg = aVar2;
    }

    public int Mv() {
        return this.bwc;
    }

    public com.baidu.tbadk.mvc.b.a Mw() {
        return this.bwe;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public View getView() {
        if (this.bwi != null) {
            return this.bwi.get();
        }
        return null;
    }

    public void setView(View view) {
        this.bwi = new WeakReference<>(view);
    }

    public void ie(int i) {
        this.bwh = i;
    }

    public boolean Mx() {
        return this.bwd;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

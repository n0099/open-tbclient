package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int bvT;
    private boolean bvU = true;
    private com.baidu.tbadk.mvc.b.a bvV;
    private com.baidu.tbadk.mvc.d.b bvW;
    private com.baidu.tbadk.mvc.a.a bvX;
    private int bvY;
    private WeakReference<View> bvZ;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.bvT = i;
        this.bvV = aVar;
        this.bvW = bVar;
        this.bvX = aVar2;
    }

    public int MH() {
        return this.bvT;
    }

    public com.baidu.tbadk.mvc.b.a MI() {
        return this.bvV;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public View getView() {
        if (this.bvZ != null) {
            return this.bvZ.get();
        }
        return null;
    }

    public void setView(View view) {
        this.bvZ = new WeakReference<>(view);
    }

    public void ii(int i) {
        this.bvY = i;
    }

    public boolean MJ() {
        return this.bvU;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

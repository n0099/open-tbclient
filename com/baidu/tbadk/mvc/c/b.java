package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int auU;
    private boolean auV = true;
    private com.baidu.tbadk.mvc.b.a auW;
    private com.baidu.tbadk.mvc.d.b auX;
    private com.baidu.tbadk.mvc.a.a auY;
    private int auZ;
    private Object ava;
    private WeakReference<View> avb;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.auU = i;
        this.auW = aVar;
        this.auX = bVar;
        this.auY = aVar2;
    }

    public int CG() {
        return this.auU;
    }

    public com.baidu.tbadk.mvc.b.a CH() {
        return this.auW;
    }

    public Object getExtra() {
        return this.ava;
    }

    public void setExtra(Object obj) {
        this.ava = obj;
    }

    public View getView() {
        if (this.avb != null) {
            return this.avb.get();
        }
        return null;
    }

    public void setView(View view) {
        this.avb = new WeakReference<>(view);
    }

    public int CI() {
        return this.auZ;
    }

    public void eh(int i) {
        this.auZ = i;
    }

    public boolean CJ() {
        return this.auV;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

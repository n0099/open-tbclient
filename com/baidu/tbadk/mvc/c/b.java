package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int atQ;
    private boolean atR = true;
    private com.baidu.tbadk.mvc.b.a atS;
    private com.baidu.tbadk.mvc.d.b atT;
    private com.baidu.tbadk.mvc.a.a atU;
    private int atV;
    private Object atW;
    private WeakReference<View> atX;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.atQ = i;
        this.atS = aVar;
        this.atT = bVar;
        this.atU = aVar2;
    }

    public int Ct() {
        return this.atQ;
    }

    public com.baidu.tbadk.mvc.b.a Cu() {
        return this.atS;
    }

    public Object getExtra() {
        return this.atW;
    }

    public void setExtra(Object obj) {
        this.atW = obj;
    }

    public View getView() {
        if (this.atX != null) {
            return this.atX.get();
        }
        return null;
    }

    public void setView(View view) {
        this.atX = new WeakReference<>(view);
    }

    public int Cv() {
        return this.atV;
    }

    public void eo(int i) {
        this.atV = i;
    }

    public boolean Cw() {
        return this.atR;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

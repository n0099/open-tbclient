package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int azE;
    private boolean azF = true;
    private com.baidu.tbadk.mvc.b.a azG;
    private com.baidu.tbadk.mvc.d.b azH;
    private com.baidu.tbadk.mvc.a.a azI;
    private int azJ;
    private Object azK;
    private WeakReference<View> azL;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.azE = i;
        this.azG = aVar;
        this.azH = bVar;
        this.azI = aVar2;
    }

    public int Ey() {
        return this.azE;
    }

    public com.baidu.tbadk.mvc.b.a Ez() {
        return this.azG;
    }

    public Object getExtra() {
        return this.azK;
    }

    public void setExtra(Object obj) {
        this.azK = obj;
    }

    public View getView() {
        if (this.azL != null) {
            return this.azL.get();
        }
        return null;
    }

    public void setView(View view) {
        this.azL = new WeakReference<>(view);
    }

    public int EA() {
        return this.azJ;
    }

    public void eX(int i) {
        this.azJ = i;
    }

    public boolean EB() {
        return this.azF;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

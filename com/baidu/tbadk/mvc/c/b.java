package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tbadk.mvc.b.a aGA;
    private com.baidu.tbadk.mvc.d.b aGB;
    private com.baidu.tbadk.mvc.a.a aGC;
    private int aGD;
    private Object aGE;
    private WeakReference<View> aGF;
    private int aGy;
    private boolean aGz = true;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aGy = i;
        this.aGA = aVar;
        this.aGB = bVar;
        this.aGC = aVar2;
    }

    public int EX() {
        return this.aGy;
    }

    public com.baidu.tbadk.mvc.b.a EY() {
        return this.aGA;
    }

    public Object getExtra() {
        return this.aGE;
    }

    public void setExtra(Object obj) {
        this.aGE = obj;
    }

    public View getView() {
        if (this.aGF != null) {
            return this.aGF.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aGF = new WeakReference<>(view);
    }

    public void eY(int i) {
        this.aGD = i;
    }

    public boolean EZ() {
        return this.aGz;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int aGE;
    private boolean aGF = true;
    private com.baidu.tbadk.mvc.b.a aGG;
    private com.baidu.tbadk.mvc.d.b aGH;
    private com.baidu.tbadk.mvc.a.a aGI;
    private int aGJ;
    private Object aGK;
    private WeakReference<View> aGL;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aGE = i;
        this.aGG = aVar;
        this.aGH = bVar;
        this.aGI = aVar2;
    }

    public int EC() {
        return this.aGE;
    }

    public com.baidu.tbadk.mvc.b.a ED() {
        return this.aGG;
    }

    public Object getExtra() {
        return this.aGK;
    }

    public void setExtra(Object obj) {
        this.aGK = obj;
    }

    public View getView() {
        if (this.aGL != null) {
            return this.aGL.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aGL = new WeakReference<>(view);
    }

    public void fk(int i) {
        this.aGJ = i;
    }

    public boolean EE() {
        return this.aGF;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

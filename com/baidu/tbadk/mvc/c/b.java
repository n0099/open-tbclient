package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tbadk.mvc.a.a aHA;
    private int aHB;
    private Object aHC;
    private WeakReference<View> aHD;
    private int aHw;
    private boolean aHx = true;
    private com.baidu.tbadk.mvc.b.a aHy;
    private com.baidu.tbadk.mvc.d.b aHz;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aHw = i;
        this.aHy = aVar;
        this.aHz = bVar;
        this.aHA = aVar2;
    }

    public int Fa() {
        return this.aHw;
    }

    public com.baidu.tbadk.mvc.b.a Fb() {
        return this.aHy;
    }

    public Object getExtra() {
        return this.aHC;
    }

    public void setExtra(Object obj) {
        this.aHC = obj;
    }

    public View getView() {
        if (this.aHD != null) {
            return this.aHD.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aHD = new WeakReference<>(view);
    }

    public void fk(int i) {
        this.aHB = i;
    }

    public boolean Fc() {
        return this.aHx;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

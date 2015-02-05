package com.baidu.tbadk.mvc.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int adV;
    private boolean adW = true;
    private com.baidu.tbadk.mvc.b.a adX;
    private com.baidu.tbadk.mvc.e.c adY;
    private com.baidu.tbadk.mvc.a.a adZ;
    private boolean aea;
    private int aeb;
    private Object aec;
    private WeakReference<View> aed;
    private WeakReference<ViewGroup> aee;
    private BdUniqueId uniqueId;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i) {
        this.adV = i;
    }

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.e.c cVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.adV = i;
        this.adX = aVar;
        this.adY = cVar;
        this.adZ = aVar2;
    }

    public int xm() {
        return this.adV;
    }

    public com.baidu.tbadk.mvc.b.a xn() {
        return this.adX;
    }

    public com.baidu.tbadk.mvc.e.c xo() {
        return this.adY;
    }

    public com.baidu.tbadk.mvc.a.a xp() {
        return this.adZ;
    }

    public Object getExtra() {
        return this.aec;
    }

    public void setExtra(Object obj) {
        this.aec = obj;
    }

    public View getView() {
        if (this.aed != null) {
            return this.aed.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aed = new WeakReference<>(view);
    }

    public void c(ViewGroup viewGroup) {
        this.aee = new WeakReference<>(viewGroup);
    }

    public boolean xq() {
        return this.aea;
    }

    public void aO(boolean z) {
        this.aea = z;
    }

    public int xr() {
        return this.aeb;
    }

    public void dI(int i) {
        this.aeb = i;
    }

    public boolean xs() {
        return this.adW;
    }

    public void aP(boolean z) {
        this.adW = z;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

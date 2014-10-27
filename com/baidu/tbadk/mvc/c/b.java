package com.baidu.tbadk.mvc.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int Xn;
    private boolean Xo = true;
    private BdUniqueId Xp;
    private com.baidu.tbadk.mvc.b.a Xq;
    private com.baidu.tbadk.mvc.e.c Xr;
    private com.baidu.tbadk.mvc.a.a Xs;
    private boolean Xt;
    private int Xu;
    private Object Xv;
    private WeakReference<View> Xw;
    private WeakReference<ViewGroup> Xx;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i) {
        this.Xn = i;
    }

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.e.c cVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.Xn = i;
        this.Xq = aVar;
        this.Xr = cVar;
        this.Xs = aVar2;
    }

    public int tp() {
        return this.Xn;
    }

    public com.baidu.tbadk.mvc.b.a tq() {
        return this.Xq;
    }

    public com.baidu.tbadk.mvc.e.c tr() {
        return this.Xr;
    }

    public com.baidu.tbadk.mvc.a.a ts() {
        return this.Xs;
    }

    public Object getExtra() {
        return this.Xv;
    }

    public void setExtra(Object obj) {
        this.Xv = obj;
    }

    public void setView(View view) {
        this.Xw = new WeakReference<>(view);
    }

    public void c(ViewGroup viewGroup) {
        this.Xx = new WeakReference<>(viewGroup);
    }

    public boolean tt() {
        return this.Xt;
    }

    public void az(boolean z) {
        this.Xt = z;
    }

    public int tu() {
        return this.Xu;
    }

    public void di(int i) {
        this.Xu = i;
    }

    public boolean tv() {
        return this.Xo;
    }

    public void aA(boolean z) {
        this.Xo = z;
    }

    public BdUniqueId getUniqueId() {
        return this.Xp;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Xp = bdUniqueId;
    }
}

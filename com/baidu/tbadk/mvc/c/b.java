package com.baidu.tbadk.mvc.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private WeakReference<View> XA;
    private WeakReference<ViewGroup> XB;
    private int Xr;
    private boolean Xs = true;
    private BdUniqueId Xt;
    private com.baidu.tbadk.mvc.b.a Xu;
    private com.baidu.tbadk.mvc.e.c Xv;
    private com.baidu.tbadk.mvc.a.a Xw;
    private boolean Xx;
    private int Xy;
    private Object Xz;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i) {
        this.Xr = i;
    }

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.e.c cVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.Xr = i;
        this.Xu = aVar;
        this.Xv = cVar;
        this.Xw = aVar2;
    }

    public int tr() {
        return this.Xr;
    }

    public com.baidu.tbadk.mvc.b.a ts() {
        return this.Xu;
    }

    public com.baidu.tbadk.mvc.e.c tt() {
        return this.Xv;
    }

    public com.baidu.tbadk.mvc.a.a tu() {
        return this.Xw;
    }

    public Object getExtra() {
        return this.Xz;
    }

    public void setExtra(Object obj) {
        this.Xz = obj;
    }

    public void setView(View view) {
        this.XA = new WeakReference<>(view);
    }

    public void c(ViewGroup viewGroup) {
        this.XB = new WeakReference<>(viewGroup);
    }

    public boolean tv() {
        return this.Xx;
    }

    public void az(boolean z) {
        this.Xx = z;
    }

    public int tw() {
        return this.Xy;
    }

    public void di(int i) {
        this.Xy = i;
    }

    public boolean tx() {
        return this.Xs;
    }

    public void aA(boolean z) {
        this.Xs = z;
    }

    public BdUniqueId getUniqueId() {
        return this.Xt;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Xt = bdUniqueId;
    }
}

package com.baidu.tbadk.mvc.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int adY;
    private boolean adZ = true;
    private com.baidu.tbadk.mvc.b.a aea;
    private com.baidu.tbadk.mvc.e.c aeb;
    private com.baidu.tbadk.mvc.a.a aec;
    private boolean aed;
    private int aee;
    private Object aef;
    private WeakReference<View> aeg;
    private WeakReference<ViewGroup> aeh;
    private BdUniqueId uniqueId;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i) {
        this.adY = i;
    }

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.e.c cVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.adY = i;
        this.aea = aVar;
        this.aeb = cVar;
        this.aec = aVar2;
    }

    public int xs() {
        return this.adY;
    }

    public com.baidu.tbadk.mvc.b.a xt() {
        return this.aea;
    }

    public com.baidu.tbadk.mvc.e.c xu() {
        return this.aeb;
    }

    public com.baidu.tbadk.mvc.a.a xv() {
        return this.aec;
    }

    public Object getExtra() {
        return this.aef;
    }

    public void setExtra(Object obj) {
        this.aef = obj;
    }

    public View getView() {
        if (this.aeg != null) {
            return this.aeg.get();
        }
        return null;
    }

    public void setView(View view) {
        this.aeg = new WeakReference<>(view);
    }

    public void c(ViewGroup viewGroup) {
        this.aeh = new WeakReference<>(viewGroup);
    }

    public boolean xw() {
        return this.aed;
    }

    public void aO(boolean z) {
        this.aed = z;
    }

    public int xx() {
        return this.aee;
    }

    public void dI(int i) {
        this.aee = i;
    }

    public boolean xy() {
        return this.adZ;
    }

    public void aP(boolean z) {
        this.adZ = z;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

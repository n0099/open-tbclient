package com.baidu.tbadk.mvc.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int amp;
    private boolean amq = true;
    private com.baidu.tbadk.mvc.b.a amr;
    private com.baidu.tbadk.mvc.e.c ams;
    private com.baidu.tbadk.mvc.a.a amt;
    private boolean amu;
    private int amv;
    private Object amw;
    private WeakReference<View> amx;
    private WeakReference<ViewGroup> amy;
    private BdUniqueId uniqueId;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i) {
        this.amp = i;
    }

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.e.c cVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.amp = i;
        this.amr = aVar;
        this.ams = cVar;
        this.amt = aVar2;
    }

    public int Az() {
        return this.amp;
    }

    public com.baidu.tbadk.mvc.b.a AA() {
        return this.amr;
    }

    public com.baidu.tbadk.mvc.e.c AB() {
        return this.ams;
    }

    public com.baidu.tbadk.mvc.a.a AC() {
        return this.amt;
    }

    public Object getExtra() {
        return this.amw;
    }

    public void setExtra(Object obj) {
        this.amw = obj;
    }

    public View getView() {
        if (this.amx != null) {
            return this.amx.get();
        }
        return null;
    }

    public void setView(View view) {
        this.amx = new WeakReference<>(view);
    }

    public void d(ViewGroup viewGroup) {
        this.amy = new WeakReference<>(viewGroup);
    }

    public boolean AD() {
        return this.amu;
    }

    public void aS(boolean z) {
        this.amu = z;
    }

    public int AE() {
        return this.amv;
    }

    public void dL(int i) {
        this.amv = i;
    }

    public boolean AF() {
        return this.amq;
    }

    public void aT(boolean z) {
        this.amq = z;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

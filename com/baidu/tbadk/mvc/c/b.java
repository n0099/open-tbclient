package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int ava;
    private boolean avb = true;
    private com.baidu.tbadk.mvc.b.a avc;
    private com.baidu.tbadk.mvc.d.b avd;
    private com.baidu.tbadk.mvc.a.a ave;
    private int avf;
    private Object avg;
    private WeakReference<View> avh;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.ava = i;
        this.avc = aVar;
        this.avd = bVar;
        this.ave = aVar2;
    }

    public int Dk() {
        return this.ava;
    }

    public com.baidu.tbadk.mvc.b.a Dl() {
        return this.avc;
    }

    public Object getExtra() {
        return this.avg;
    }

    public void setExtra(Object obj) {
        this.avg = obj;
    }

    public View getView() {
        if (this.avh != null) {
            return this.avh.get();
        }
        return null;
    }

    public void setView(View view) {
        this.avh = new WeakReference<>(view);
    }

    public int Dm() {
        return this.avf;
    }

    public void eB(int i) {
        this.avf = i;
    }

    public boolean Dn() {
        return this.avb;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

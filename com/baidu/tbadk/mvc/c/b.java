package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int avb;
    private boolean avc = true;
    private com.baidu.tbadk.mvc.b.a avd;
    private com.baidu.tbadk.mvc.d.b ave;
    private com.baidu.tbadk.mvc.a.a avf;
    private int avg;
    private Object avh;
    private WeakReference<View> avi;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.avb = i;
        this.avd = aVar;
        this.ave = bVar;
        this.avf = aVar2;
    }

    public int CD() {
        return this.avb;
    }

    public com.baidu.tbadk.mvc.b.a CE() {
        return this.avd;
    }

    public Object getExtra() {
        return this.avh;
    }

    public void setExtra(Object obj) {
        this.avh = obj;
    }

    public View getView() {
        if (this.avi != null) {
            return this.avi.get();
        }
        return null;
    }

    public void setView(View view) {
        this.avi = new WeakReference<>(view);
    }

    public int CF() {
        return this.avg;
    }

    public void eq(int i) {
        this.avg = i;
    }

    public boolean CG() {
        return this.avc;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

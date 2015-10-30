package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int avc;
    private boolean avd = true;
    private com.baidu.tbadk.mvc.b.a ave;
    private com.baidu.tbadk.mvc.d.b avf;
    private com.baidu.tbadk.mvc.a.a avg;
    private int avh;
    private Object avi;
    private WeakReference<View> avj;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.avc = i;
        this.ave = aVar;
        this.avf = bVar;
        this.avg = aVar2;
    }

    public int CA() {
        return this.avc;
    }

    public com.baidu.tbadk.mvc.b.a CB() {
        return this.ave;
    }

    public Object getExtra() {
        return this.avi;
    }

    public void setExtra(Object obj) {
        this.avi = obj;
    }

    public View getView() {
        if (this.avj != null) {
            return this.avj.get();
        }
        return null;
    }

    public void setView(View view) {
        this.avj = new WeakReference<>(view);
    }

    public int CC() {
        return this.avh;
    }

    public void eq(int i) {
        this.avh = i;
    }

    public boolean CD() {
        return this.avd;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

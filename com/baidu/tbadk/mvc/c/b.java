package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int azp;
    private boolean azq = true;
    private com.baidu.tbadk.mvc.b.a azr;
    private com.baidu.tbadk.mvc.d.b azs;
    private com.baidu.tbadk.mvc.a.a azt;
    private int azu;
    private Object azv;
    private WeakReference<View> azw;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.azp = i;
        this.azr = aVar;
        this.azs = bVar;
        this.azt = aVar2;
    }

    public int EL() {
        return this.azp;
    }

    public com.baidu.tbadk.mvc.b.a EM() {
        return this.azr;
    }

    public Object getExtra() {
        return this.azv;
    }

    public void setExtra(Object obj) {
        this.azv = obj;
    }

    public View getView() {
        if (this.azw != null) {
            return this.azw.get();
        }
        return null;
    }

    public void setView(View view) {
        this.azw = new WeakReference<>(view);
    }

    public int EN() {
        return this.azu;
    }

    public void eT(int i) {
        this.azu = i;
    }

    public boolean EO() {
        return this.azq;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

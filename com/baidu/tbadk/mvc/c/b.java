package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int ayY;
    private boolean ayZ = true;
    private com.baidu.tbadk.mvc.b.a aza;
    private com.baidu.tbadk.mvc.d.b azb;
    private com.baidu.tbadk.mvc.a.a azc;
    private int azd;
    private Object aze;
    private WeakReference<View> azf;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.ayY = i;
        this.aza = aVar;
        this.azb = bVar;
        this.azc = aVar2;
    }

    public int Fr() {
        return this.ayY;
    }

    public com.baidu.tbadk.mvc.b.a Fs() {
        return this.aza;
    }

    public Object getExtra() {
        return this.aze;
    }

    public void setExtra(Object obj) {
        this.aze = obj;
    }

    public View getView() {
        if (this.azf != null) {
            return this.azf.get();
        }
        return null;
    }

    public void setView(View view) {
        this.azf = new WeakReference<>(view);
    }

    public int Ft() {
        return this.azd;
    }

    public void eW(int i) {
        this.azd = i;
    }

    public boolean Fu() {
        return this.ayZ;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

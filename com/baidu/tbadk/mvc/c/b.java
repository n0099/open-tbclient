package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int ayr;
    private boolean ays = true;
    private com.baidu.tbadk.mvc.b.a ayt;
    private com.baidu.tbadk.mvc.d.b ayu;
    private com.baidu.tbadk.mvc.a.a ayv;
    private int ayw;
    private Object ayx;
    private WeakReference<View> ayy;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.ayr = i;
        this.ayt = aVar;
        this.ayu = bVar;
        this.ayv = aVar2;
    }

    public int EE() {
        return this.ayr;
    }

    public com.baidu.tbadk.mvc.b.a EF() {
        return this.ayt;
    }

    public Object getExtra() {
        return this.ayx;
    }

    public void setExtra(Object obj) {
        this.ayx = obj;
    }

    public View getView() {
        if (this.ayy != null) {
            return this.ayy.get();
        }
        return null;
    }

    public void setView(View view) {
        this.ayy = new WeakReference<>(view);
    }

    public int EG() {
        return this.ayw;
    }

    public void eQ(int i) {
        this.ayw = i;
    }

    public boolean EH() {
        return this.ays;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

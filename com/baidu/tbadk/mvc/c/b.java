package com.baidu.tbadk.mvc.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int adB;
    private boolean adC = true;
    private com.baidu.tbadk.mvc.b.a adD;
    private com.baidu.tbadk.mvc.e.c adE;
    private com.baidu.tbadk.mvc.a.a adF;
    private boolean adG;
    private int adH;
    private Object adI;
    private WeakReference<View> adJ;
    private WeakReference<ViewGroup> adK;
    private BdUniqueId uniqueId;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i) {
        this.adB = i;
    }

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.e.c cVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.adB = i;
        this.adD = aVar;
        this.adE = cVar;
        this.adF = aVar2;
    }

    public int xc() {
        return this.adB;
    }

    public com.baidu.tbadk.mvc.b.a xd() {
        return this.adD;
    }

    public com.baidu.tbadk.mvc.e.c xe() {
        return this.adE;
    }

    public com.baidu.tbadk.mvc.a.a xf() {
        return this.adF;
    }

    public Object getExtra() {
        return this.adI;
    }

    public void setExtra(Object obj) {
        this.adI = obj;
    }

    public View getView() {
        if (this.adJ != null) {
            return this.adJ.get();
        }
        return null;
    }

    public void setView(View view) {
        this.adJ = new WeakReference<>(view);
    }

    public void c(ViewGroup viewGroup) {
        this.adK = new WeakReference<>(viewGroup);
    }

    public boolean xg() {
        return this.adG;
    }

    public void aM(boolean z) {
        this.adG = z;
    }

    public int xh() {
        return this.adH;
    }

    public void dC(int i) {
        this.adH = i;
    }

    public boolean xi() {
        return this.adC;
    }

    public void aN(boolean z) {
        this.adC = z;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

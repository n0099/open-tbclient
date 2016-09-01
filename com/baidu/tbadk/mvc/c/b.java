package com.baidu.tbadk.mvc.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private int azM;
    private boolean azN = true;
    private com.baidu.tbadk.mvc.b.a azO;
    private com.baidu.tbadk.mvc.d.b azP;
    private com.baidu.tbadk.mvc.a.a azQ;
    private int azR;
    private Object azS;
    private WeakReference<View> azT;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.azM = i;
        this.azO = aVar;
        this.azP = bVar;
        this.azQ = aVar2;
    }

    public int EL() {
        return this.azM;
    }

    public com.baidu.tbadk.mvc.b.a EM() {
        return this.azO;
    }

    public Object getExtra() {
        return this.azS;
    }

    public void setExtra(Object obj) {
        this.azS = obj;
    }

    public View getView() {
        if (this.azT != null) {
            return this.azT.get();
        }
        return null;
    }

    public void setView(View view) {
        this.azT = new WeakReference<>(view);
    }

    public int EN() {
        return this.azR;
    }

    public void eU(int i) {
        this.azR = i;
    }

    public boolean EO() {
        return this.azN;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}

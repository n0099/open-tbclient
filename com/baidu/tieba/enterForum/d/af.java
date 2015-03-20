package com.baidu.tieba.enterForum.d;

import android.content.Context;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class af {
    private ViewEventCenter aCK;
    private List<com.baidu.tieba.enterForum.b.d> aEB = new ArrayList();
    private SoftReference<ac> aED;
    private int aEE;

    public af(ViewEventCenter viewEventCenter) {
        this.aCK = viewEventCenter;
    }

    public void b(Context context, List<com.baidu.tieba.enterForum.b.d> list) {
        ac acVar;
        this.aEB.clear();
        if (list != null) {
            this.aEB.addAll(list);
        }
        if (this.aED != null && this.aED.get() != null) {
            acVar = this.aED.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.aED = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aCK);
        } else {
            return;
        }
        this.aEE -= acVar.getItemViewCount();
        acVar.setDataAndRefreshView(HD());
    }

    public void HC() {
        if (this.aED != null && this.aED.get() != null) {
            this.aED.get().setDataAndRefreshView(HD());
        }
    }

    private List<com.baidu.tieba.enterForum.b.d> HD() {
        ArrayList arrayList = new ArrayList();
        if (this.aEE < 0 || this.aEE >= this.aEB.size()) {
            this.aEE = 0;
        }
        int i = this.aEE;
        int size = this.aEB.size();
        for (int i2 = i; i2 < size; i2++) {
            if (this.aEB.get(i2) != null && arrayList.size() < 3) {
                arrayList.add(this.aEB.get(i2));
                this.aEE++;
            }
        }
        for (int size2 = arrayList.size(); size2 < 3; size2++) {
            com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
            dVar.setType(1);
            arrayList.add(dVar);
        }
        return arrayList;
    }

    public ac HE() {
        if (this.aED == null) {
            return null;
        }
        return this.aED.get();
    }
}

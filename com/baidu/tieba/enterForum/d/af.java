package com.baidu.tieba.enterForum.d;

import android.content.Context;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class af {
    private ViewEventCenter aCS;
    private List<com.baidu.tieba.enterForum.b.d> aEJ = new ArrayList();
    private SoftReference<ac> aEL;
    private int aEM;

    public af(ViewEventCenter viewEventCenter) {
        this.aCS = viewEventCenter;
    }

    public void b(Context context, List<com.baidu.tieba.enterForum.b.d> list) {
        ac acVar;
        this.aEJ.clear();
        if (list != null) {
            this.aEJ.addAll(list);
        }
        if (this.aEL != null && this.aEL.get() != null) {
            acVar = this.aEL.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.aEL = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aCS);
        } else {
            return;
        }
        this.aEM -= acVar.getItemViewCount();
        acVar.setDataAndRefreshView(HJ());
    }

    public void HI() {
        if (this.aEL != null && this.aEL.get() != null) {
            this.aEL.get().setDataAndRefreshView(HJ());
        }
    }

    private List<com.baidu.tieba.enterForum.b.d> HJ() {
        ArrayList arrayList = new ArrayList();
        if (this.aEM < 0 || this.aEM >= this.aEJ.size()) {
            this.aEM = 0;
        }
        int i = this.aEM;
        int size = this.aEJ.size();
        for (int i2 = i; i2 < size; i2++) {
            if (this.aEJ.get(i2) != null && arrayList.size() < 3) {
                arrayList.add(this.aEJ.get(i2));
                this.aEM++;
            }
        }
        for (int size2 = arrayList.size(); size2 < 3; size2++) {
            com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
            dVar.setType(1);
            arrayList.add(dVar);
        }
        return arrayList;
    }

    public ac HK() {
        if (this.aEL == null) {
            return null;
        }
        return this.aEL.get();
    }
}

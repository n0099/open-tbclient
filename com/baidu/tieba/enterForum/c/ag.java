package com.baidu.tieba.enterForum.c;

import android.content.Context;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag {
    private List<com.baidu.tieba.enterForum.b.g> aSB = new ArrayList();
    private ViewEventCenter bEJ;
    private SoftReference<ac> bGR;
    private int bGS;

    public ag(ViewEventCenter viewEventCenter) {
        this.bEJ = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aSB.clear();
        if (list != null) {
            this.aSB.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aSB.size() > i) {
            z = true;
        }
        if (this.bGR != null && this.bGR.get() != null) {
            acVar = this.bGR.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.bGR = new SoftReference<>(acVar);
            acVar.setEventCenter(this.bEJ);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.bGS -= acVar.getItemViewCount();
            acVar.c(WX(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void p(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.bGR != null && this.bGR.get() != null && tbPageContext != null) {
            this.bGR.get().c(WX(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.g> WX() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.bGS < 0 || this.bGS >= this.aSB.size()) {
            this.bGS = 0;
        }
        int i2 = this.bGS;
        int size = this.aSB.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aSB.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aSB.get(i3));
                this.bGS++;
            }
        }
        return arrayList;
    }

    public ac WY() {
        if (this.bGR == null) {
            return null;
        }
        return this.bGR.get();
    }
}

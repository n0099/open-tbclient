package com.baidu.tieba.enterForum.view;

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
    private List<com.baidu.tieba.enterForum.b.g> aKa = new ArrayList();
    private ViewEventCenter bgJ;
    private SoftReference<ac> bxU;
    private int bxV;

    public ag(ViewEventCenter viewEventCenter) {
        this.bgJ = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aKa.clear();
        if (list != null) {
            this.aKa.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aKa.size() > i) {
            z = true;
        }
        if (this.bxU != null && this.bxU.get() != null) {
            acVar = this.bxU.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.bxU = new SoftReference<>(acVar);
            acVar.setEventCenter(this.bgJ);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.bxV -= acVar.getItemViewCount();
            acVar.c(TS(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void p(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.bxU != null && this.bxU.get() != null && tbPageContext != null) {
            this.bxU.get().c(TS(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.g> TS() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.bxV < 0 || this.bxV >= this.aKa.size()) {
            this.bxV = 0;
        }
        int i2 = this.bxV;
        int size = this.aKa.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aKa.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aKa.get(i3));
                this.bxV++;
            }
        }
        return arrayList;
    }

    public ac TT() {
        if (this.bxU == null) {
            return null;
        }
        return this.bxU.get();
    }

    public void TU() {
        ac TT = TT();
        if (TT != null) {
            TT.TQ();
            TT.TR();
        }
    }
}

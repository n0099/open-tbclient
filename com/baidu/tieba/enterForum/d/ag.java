package com.baidu.tieba.enterForum.d;

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
    private List<com.baidu.tieba.enterForum.b.g> aMf = new ArrayList();
    private ViewEventCenter aPL;
    private SoftReference<ac> bJk;
    private int bJl;

    public ag(ViewEventCenter viewEventCenter) {
        this.aPL = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aMf.clear();
        if (list != null) {
            this.aMf.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aMf.size() > i) {
            z = true;
        }
        if (this.bJk != null && this.bJk.get() != null) {
            acVar = this.bJk.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.bJk = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aPL);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.bJl -= acVar.getItemViewCount();
            acVar.c(YR(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void s(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.bJk != null && this.bJk.get() != null && tbPageContext != null) {
            this.bJk.get().c(YR(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.g> YR() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.bJl < 0 || this.bJl >= this.aMf.size()) {
            this.bJl = 0;
        }
        int i2 = this.bJl;
        int size = this.aMf.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aMf.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aMf.get(i3));
                this.bJl++;
            }
        }
        return arrayList;
    }

    public ac YS() {
        if (this.bJk == null) {
            return null;
        }
        return this.bJk.get();
    }
}

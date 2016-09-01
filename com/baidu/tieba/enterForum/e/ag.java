package com.baidu.tieba.enterForum.e;

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
    private List<com.baidu.tieba.enterForum.b.g> aOE = new ArrayList();
    private ViewEventCenter aOw;
    private SoftReference<ac> bJj;
    private int bJk;

    public ag(ViewEventCenter viewEventCenter) {
        this.aOw = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aOE.clear();
        if (list != null) {
            this.aOE.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aOE.size() > i) {
            z = true;
        }
        if (this.bJj != null && this.bJj.get() != null) {
            acVar = this.bJj.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.bJj = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aOw);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.bJk -= acVar.getItemViewCount();
            acVar.c(YC(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void p(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.bJj != null && this.bJj.get() != null && tbPageContext != null) {
            this.bJj.get().c(YC(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.g> YC() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.bJk < 0 || this.bJk >= this.aOE.size()) {
            this.bJk = 0;
        }
        int i2 = this.bJk;
        int size = this.aOE.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aOE.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aOE.get(i3));
                this.bJk++;
            }
        }
        return arrayList;
    }

    public ac YD() {
        if (this.bJj == null) {
            return null;
        }
        return this.bJj.get();
    }

    public void YE() {
        ac YD = YD();
        if (YD != null) {
            YD.YA();
            YD.YB();
        }
    }
}

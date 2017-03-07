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
    private List<com.baidu.tieba.enterForum.b.g> aSl = new ArrayList();
    private ViewEventCenter bEQ;
    private SoftReference<ac> bGY;
    private int bGZ;

    public ag(ViewEventCenter viewEventCenter) {
        this.bEQ = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aSl.clear();
        if (list != null) {
            this.aSl.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aSl.size() > i) {
            z = true;
        }
        if (this.bGY != null && this.bGY.get() != null) {
            acVar = this.bGY.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.bGY = new SoftReference<>(acVar);
            acVar.setEventCenter(this.bEQ);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.bGZ -= acVar.getItemViewCount();
            acVar.c(Wz(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void p(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.bGY != null && this.bGY.get() != null && tbPageContext != null) {
            this.bGY.get().c(Wz(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.g> Wz() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.bGZ < 0 || this.bGZ >= this.aSl.size()) {
            this.bGZ = 0;
        }
        int i2 = this.bGZ;
        int size = this.aSl.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aSl.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aSl.get(i3));
                this.bGZ++;
            }
        }
        return arrayList;
    }

    public ac WA() {
        if (this.bGY == null) {
            return null;
        }
        return this.bGY.get();
    }
}

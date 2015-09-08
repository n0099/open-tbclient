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
    private ViewEventCenter aMG;
    private List<com.baidu.tieba.enterForum.b.e> aOB = new ArrayList();
    private SoftReference<ac> aOG;
    private int aOH;

    public ag(ViewEventCenter viewEventCenter) {
        this.aMG = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.e> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aOB.clear();
        if (list != null) {
            this.aOB.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aOB.size() > i) {
            z = true;
        }
        if (this.aOG != null && this.aOG.get() != null) {
            acVar = this.aOG.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.aOG = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aMG);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.aOH -= acVar.getItemViewCount();
            acVar.a(Jm(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void g(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aOG != null && this.aOG.get() != null && tbPageContext != null) {
            this.aOG.get().a(Jm(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.e> Jm() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aOH < 0 || this.aOH >= this.aOB.size()) {
            this.aOH = 0;
        }
        int i2 = this.aOH;
        int size = this.aOB.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aOB.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aOB.get(i3));
                this.aOH++;
            }
        }
        return arrayList;
    }

    public ac Jn() {
        if (this.aOG == null) {
            return null;
        }
        return this.aOG.get();
    }
}

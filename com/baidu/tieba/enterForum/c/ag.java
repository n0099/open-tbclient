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
    private List<com.baidu.tieba.enterForum.b.g> aMy = new ArrayList();
    private ViewEventCenter bxK;
    private SoftReference<ac> bzS;
    private int bzT;

    public ag(ViewEventCenter viewEventCenter) {
        this.bxK = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aMy.clear();
        if (list != null) {
            this.aMy.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aMy.size() > i) {
            z = true;
        }
        if (this.bzS != null && this.bzS.get() != null) {
            acVar = this.bzS.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.bzS = new SoftReference<>(acVar);
            acVar.setEventCenter(this.bxK);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.bzT -= acVar.getItemViewCount();
            acVar.c(VB(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void p(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.bzS != null && this.bzS.get() != null && tbPageContext != null) {
            this.bzS.get().c(VB(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.g> VB() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.bzT < 0 || this.bzT >= this.aMy.size()) {
            this.bzT = 0;
        }
        int i2 = this.bzT;
        int size = this.aMy.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aMy.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aMy.get(i3));
                this.bzT++;
            }
        }
        return arrayList;
    }

    public ac VC() {
        if (this.bzS == null) {
            return null;
        }
        return this.bzS.get();
    }
}

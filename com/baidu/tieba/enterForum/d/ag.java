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
    private List<com.baidu.tieba.enterForum.b.g> aOf = new ArrayList();
    private ViewEventCenter aRS;
    private SoftReference<ac> bMd;
    private int bMe;

    public ag(ViewEventCenter viewEventCenter) {
        this.aRS = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aOf.clear();
        if (list != null) {
            this.aOf.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aOf.size() > i) {
            z = true;
        }
        if (this.bMd != null && this.bMd.get() != null) {
            acVar = this.bMd.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.bMd = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aRS);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.bMe -= acVar.getItemViewCount();
            acVar.c(ZT(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void t(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.bMd != null && this.bMd.get() != null && tbPageContext != null) {
            this.bMd.get().c(ZT(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.g> ZT() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.bMe < 0 || this.bMe >= this.aOf.size()) {
            this.bMe = 0;
        }
        int i2 = this.bMe;
        int size = this.aOf.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aOf.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aOf.get(i3));
                this.bMe++;
            }
        }
        return arrayList;
    }

    public ac ZU() {
        if (this.bMd == null) {
            return null;
        }
        return this.bMd.get();
    }
}

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
    private List<com.baidu.tieba.enterForum.b.g> aJj = new ArrayList();
    private ViewEventCenter bfx;
    private SoftReference<ac> bvG;
    private int bvH;

    public ag(ViewEventCenter viewEventCenter) {
        this.bfx = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aJj.clear();
        if (list != null) {
            this.aJj.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aJj.size() > i) {
            z = true;
        }
        if (this.bvG != null && this.bvG.get() != null) {
            acVar = this.bvG.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.bvG = new SoftReference<>(acVar);
            acVar.setEventCenter(this.bfx);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.bvH -= acVar.getItemViewCount();
            acVar.c(Tk(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void p(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.bvG != null && this.bvG.get() != null && tbPageContext != null) {
            this.bvG.get().c(Tk(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.g> Tk() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.bvH < 0 || this.bvH >= this.aJj.size()) {
            this.bvH = 0;
        }
        int i2 = this.bvH;
        int size = this.aJj.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aJj.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aJj.get(i3));
                this.bvH++;
            }
        }
        return arrayList;
    }

    public ac Tl() {
        if (this.bvG == null) {
            return null;
        }
        return this.bvG.get();
    }

    public void Tm() {
        ac Tl = Tl();
        if (Tl != null) {
            Tl.Ti();
            Tl.Tj();
        }
    }
}

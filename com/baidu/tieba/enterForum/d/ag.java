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
    private List<com.baidu.tieba.enterForum.b.g> aNw = new ArrayList();
    private ViewEventCenter aRj;
    private SoftReference<ac> bsh;
    private int bsi;

    public ag(ViewEventCenter viewEventCenter) {
        this.aRj = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aNw.clear();
        if (list != null) {
            this.aNw.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aNw.size() > i) {
            z = true;
        }
        if (this.bsh != null && this.bsh.get() != null) {
            acVar = this.bsh.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.bsh = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aRj);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.bsi -= acVar.getItemViewCount();
            acVar.c(Ug(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void u(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.bsh != null && this.bsh.get() != null && tbPageContext != null) {
            this.bsh.get().c(Ug(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.g> Ug() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.bsi < 0 || this.bsi >= this.aNw.size()) {
            this.bsi = 0;
        }
        int i2 = this.bsi;
        int size = this.aNw.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aNw.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aNw.get(i3));
                this.bsi++;
            }
        }
        return arrayList;
    }

    public ac Uh() {
        if (this.bsh == null) {
            return null;
        }
        return this.bsh.get();
    }
}

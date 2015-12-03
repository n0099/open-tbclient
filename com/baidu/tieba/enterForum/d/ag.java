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
    private List<com.baidu.tieba.enterForum.b.f> aMt = new ArrayList();
    private int aMu;
    private ViewEventCenter aQB;
    private SoftReference<ac> aSY;

    public ag(ViewEventCenter viewEventCenter) {
        this.aQB = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aMt.clear();
        if (list != null) {
            this.aMt.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aMt.size() > i) {
            z = true;
        }
        if (this.aSY != null && this.aSY.get() != null) {
            acVar = this.aSY.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.aSY = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aQB);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.aMu -= acVar.getItemViewCount();
            acVar.b(KN(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void h(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aSY != null && this.aSY.get() != null && tbPageContext != null) {
            this.aSY.get().b(KN(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.f> KN() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aMu < 0 || this.aMu >= this.aMt.size()) {
            this.aMu = 0;
        }
        int i2 = this.aMu;
        int size = this.aMt.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aMt.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aMt.get(i3));
                this.aMu++;
            }
        }
        return arrayList;
    }

    public ac KO() {
        if (this.aSY == null) {
            return null;
        }
        return this.aSY.get();
    }
}

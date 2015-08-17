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
    private ViewEventCenter aMt;
    private List<com.baidu.tieba.enterForum.b.e> aOo = new ArrayList();
    private SoftReference<ac> aOt;
    private int aOu;

    public ag(ViewEventCenter viewEventCenter) {
        this.aMt = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.e> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aOo.clear();
        if (list != null) {
            this.aOo.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aOo.size() > i) {
            z = true;
        }
        if (this.aOt != null && this.aOt.get() != null) {
            acVar = this.aOt.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.aOt = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aMt);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.aOu -= acVar.getItemViewCount();
            acVar.a(Jy(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void g(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aOt != null && this.aOt.get() != null && tbPageContext != null) {
            this.aOt.get().a(Jy(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.e> Jy() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aOu < 0 || this.aOu >= this.aOo.size()) {
            this.aOu = 0;
        }
        int i2 = this.aOu;
        int size = this.aOo.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aOo.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aOo.get(i3));
                this.aOu++;
            }
        }
        return arrayList;
    }

    public ac Jz() {
        if (this.aOt == null) {
            return null;
        }
        return this.aOt.get();
    }
}

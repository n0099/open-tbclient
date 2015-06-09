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
    private ViewEventCenter aEU;
    private List<com.baidu.tieba.enterForum.b.e> aGO = new ArrayList();
    private SoftReference<ac> aGT;
    private int aGU;

    public ag(ViewEventCenter viewEventCenter) {
        this.aEU = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.e> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aGO.clear();
        if (list != null) {
            this.aGO.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aGO.size() > i) {
            z = true;
        }
        if (this.aGT != null && this.aGT.get() != null) {
            acVar = this.aGT.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.aGT = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aEU);
        } else {
            return;
        }
        this.aGU -= acVar.getItemViewCount();
        acVar.a(IK(), tbPageContext);
        acVar.setChangeViewVisibility(z);
    }

    public void f(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aGT != null && this.aGT.get() != null) {
            this.aGT.get().a(IK(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.e> IK() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aGU < 0 || this.aGU >= this.aGO.size()) {
            this.aGU = 0;
        }
        int i2 = this.aGU;
        int size = this.aGO.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aGO.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aGO.get(i3));
                this.aGU++;
            }
        }
        return arrayList;
    }

    public ac IL() {
        if (this.aGT == null) {
            return null;
        }
        return this.aGT.get();
    }
}

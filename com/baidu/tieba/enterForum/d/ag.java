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
    private ViewEventCenter aET;
    private List<com.baidu.tieba.enterForum.b.e> aGN = new ArrayList();
    private SoftReference<ac> aGS;
    private int aGT;

    public ag(ViewEventCenter viewEventCenter) {
        this.aET = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.e> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aGN.clear();
        if (list != null) {
            this.aGN.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aGN.size() > i) {
            z = true;
        }
        if (this.aGS != null && this.aGS.get() != null) {
            acVar = this.aGS.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.aGS = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aET);
        } else {
            return;
        }
        this.aGT -= acVar.getItemViewCount();
        acVar.a(IJ(), tbPageContext);
        acVar.setChangeViewVisibility(z);
    }

    public void f(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aGS != null && this.aGS.get() != null) {
            this.aGS.get().a(IJ(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.e> IJ() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aGT < 0 || this.aGT >= this.aGN.size()) {
            this.aGT = 0;
        }
        int i2 = this.aGT;
        int size = this.aGN.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aGN.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aGN.get(i3));
                this.aGT++;
            }
        }
        return arrayList;
    }

    public ac IK() {
        if (this.aGS == null) {
            return null;
        }
        return this.aGS.get();
    }
}

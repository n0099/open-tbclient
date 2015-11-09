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
public class ah {
    private ViewEventCenter aLU;
    private List<com.baidu.tieba.enterForum.b.f> aNQ = new ArrayList();
    private SoftReference<ad> aNV;
    private int aNW;

    public ah(ViewEventCenter viewEventCenter) {
        this.aLU = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ad adVar;
        this.aNQ.clear();
        if (list != null) {
            this.aNQ.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aNQ.size() > i) {
            z = true;
        }
        if (this.aNV != null && this.aNV.get() != null) {
            adVar = this.aNV.get();
        } else if (context != null) {
            adVar = new ad(context);
            this.aNV = new SoftReference<>(adVar);
            adVar.setEventCenter(this.aLU);
        } else {
            return;
        }
        if (adVar != null && tbPageContext != null) {
            this.aNW -= adVar.getItemViewCount();
            adVar.a(Jt(), tbPageContext);
            adVar.setChangeViewVisibility(z);
        }
    }

    public void g(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aNV != null && this.aNV.get() != null && tbPageContext != null) {
            this.aNV.get().a(Jt(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.f> Jt() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aNW < 0 || this.aNW >= this.aNQ.size()) {
            this.aNW = 0;
        }
        int i2 = this.aNW;
        int size = this.aNQ.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aNQ.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aNQ.get(i3));
                this.aNW++;
            }
        }
        return arrayList;
    }

    public ad Ju() {
        if (this.aNV == null) {
            return null;
        }
        return this.aNV.get();
    }
}

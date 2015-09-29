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
    private ViewEventCenter aLB;
    private SoftReference<ad> aNC;
    private int aND;
    private List<com.baidu.tieba.enterForum.b.f> aNx = new ArrayList();

    public ah(ViewEventCenter viewEventCenter) {
        this.aLB = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ad adVar;
        this.aNx.clear();
        if (list != null) {
            this.aNx.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aNx.size() > i) {
            z = true;
        }
        if (this.aNC != null && this.aNC.get() != null) {
            adVar = this.aNC.get();
        } else if (context != null) {
            adVar = new ad(context);
            this.aNC = new SoftReference<>(adVar);
            adVar.setEventCenter(this.aLB);
        } else {
            return;
        }
        if (adVar != null && tbPageContext != null) {
            this.aND -= adVar.getItemViewCount();
            adVar.a(Jh(), tbPageContext);
            adVar.setChangeViewVisibility(z);
        }
    }

    public void g(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aNC != null && this.aNC.get() != null && tbPageContext != null) {
            this.aNC.get().a(Jh(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.f> Jh() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aND < 0 || this.aND >= this.aNx.size()) {
            this.aND = 0;
        }
        int i2 = this.aND;
        int size = this.aNx.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aNx.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aNx.get(i3));
                this.aND++;
            }
        }
        return arrayList;
    }

    public ad Ji() {
        if (this.aNC == null) {
            return null;
        }
        return this.aNC.get();
    }
}

package com.baidu.tieba.enterForum.e;

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
    private ViewEventCenter aXs;
    private List<com.baidu.tieba.enterForum.b.f> aZH = new ArrayList();
    private SoftReference<ac> aZM;
    private int aZN;

    public ag(ViewEventCenter viewEventCenter) {
        this.aXs = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aZH.clear();
        if (list != null) {
            this.aZH.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aZH.size() > i) {
            z = true;
        }
        if (this.aZM != null && this.aZM.get() != null) {
            acVar = this.aZM.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.aZM = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aXs);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.aZN -= acVar.getItemViewCount();
            acVar.a(NI(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void i(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aZM != null && this.aZM.get() != null && tbPageContext != null) {
            this.aZM.get().a(NI(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.f> NI() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aZN < 0 || this.aZN >= this.aZH.size()) {
            this.aZN = 0;
        }
        int i2 = this.aZN;
        int size = this.aZH.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aZH.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aZH.get(i3));
                this.aZN++;
            }
        }
        return arrayList;
    }

    public ac NJ() {
        if (this.aZM == null) {
            return null;
        }
        return this.aZM.get();
    }

    public void NK() {
        ac NJ = NJ();
        if (NJ != null) {
            NJ.NG();
            NJ.NH();
        }
    }
}

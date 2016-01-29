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
    private List<com.baidu.tieba.enterForum.b.f> aQh = new ArrayList();
    private int aQi;
    private ViewEventCenter aWA;
    private SoftReference<ac> aZo;

    public ag(ViewEventCenter viewEventCenter) {
        this.aWA = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aQh.clear();
        if (list != null) {
            this.aQh.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aQh.size() > i) {
            z = true;
        }
        if (this.aZo != null && this.aZo.get() != null) {
            acVar = this.aZo.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.aZo = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aWA);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.aQi -= acVar.getItemViewCount();
            acVar.b(MZ(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void h(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aZo != null && this.aZo.get() != null && tbPageContext != null) {
            this.aZo.get().b(MZ(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.f> MZ() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aQi < 0 || this.aQi >= this.aQh.size()) {
            this.aQi = 0;
        }
        int i2 = this.aQi;
        int size = this.aQh.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aQh.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aQh.get(i3));
                this.aQi++;
            }
        }
        return arrayList;
    }

    public ac Na() {
        if (this.aZo == null) {
            return null;
        }
        return this.aZo.get();
    }
}

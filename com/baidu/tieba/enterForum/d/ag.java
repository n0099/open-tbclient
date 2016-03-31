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
    private List<com.baidu.tieba.enterForum.b.f> aTc = new ArrayList();
    private int aTd;
    private ViewEventCenter bbj;
    private SoftReference<ac> bdY;

    public ag(ViewEventCenter viewEventCenter) {
        this.bbj = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aTc.clear();
        if (list != null) {
            this.aTc.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aTc.size() > i) {
            z = true;
        }
        if (this.bdY != null && this.bdY.get() != null) {
            acVar = this.bdY.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.bdY = new SoftReference<>(acVar);
            acVar.setEventCenter(this.bbj);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.aTd -= acVar.getItemViewCount();
            acVar.b(ON(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void h(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.bdY != null && this.bdY.get() != null && tbPageContext != null) {
            this.bdY.get().b(ON(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.f> ON() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aTd < 0 || this.aTd >= this.aTc.size()) {
            this.aTd = 0;
        }
        int i2 = this.aTd;
        int size = this.aTc.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aTc.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aTc.get(i3));
                this.aTd++;
            }
        }
        return arrayList;
    }

    public ac OO() {
        if (this.bdY == null) {
            return null;
        }
        return this.bdY.get();
    }
}

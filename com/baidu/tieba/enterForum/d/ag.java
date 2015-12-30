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
    private List<com.baidu.tieba.enterForum.b.f> aOe = new ArrayList();
    private int aOf;
    private ViewEventCenter aUs;
    private SoftReference<ac> aXa;

    public ag(ViewEventCenter viewEventCenter) {
        this.aUs = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ac acVar;
        this.aOe.clear();
        if (list != null) {
            this.aOe.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aOe.size() > i) {
            z = true;
        }
        if (this.aXa != null && this.aXa.get() != null) {
            acVar = this.aXa.get();
        } else if (context != null) {
            acVar = new ac(context);
            this.aXa = new SoftReference<>(acVar);
            acVar.setEventCenter(this.aUs);
        } else {
            return;
        }
        if (acVar != null && tbPageContext != null) {
            this.aOf -= acVar.getItemViewCount();
            acVar.b(Lg(), tbPageContext);
            acVar.setChangeViewVisibility(z);
        }
    }

    public void h(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aXa != null && this.aXa.get() != null && tbPageContext != null) {
            this.aXa.get().b(Lg(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.f> Lg() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aOf < 0 || this.aOf >= this.aOe.size()) {
            this.aOf = 0;
        }
        int i2 = this.aOf;
        int size = this.aOe.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aOe.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aOe.get(i3));
                this.aOf++;
            }
        }
        return arrayList;
    }

    public ac Lh() {
        if (this.aXa == null) {
            return null;
        }
        return this.aXa.get();
    }
}

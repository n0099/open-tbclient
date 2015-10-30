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
    private ViewEventCenter aLM;
    private List<com.baidu.tieba.enterForum.b.f> aNI = new ArrayList();
    private SoftReference<ad> aNN;
    private int aNO;

    public ah(ViewEventCenter viewEventCenter) {
        this.aLM = viewEventCenter;
    }

    public void a(Context context, List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        int i;
        ad adVar;
        this.aNI.clear();
        if (list != null) {
            this.aNI.addAll(list);
        }
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        boolean z = false;
        if (this.aNI.size() > i) {
            z = true;
        }
        if (this.aNN != null && this.aNN.get() != null) {
            adVar = this.aNN.get();
        } else if (context != null) {
            adVar = new ad(context);
            this.aNN = new SoftReference<>(adVar);
            adVar.setEventCenter(this.aLM);
        } else {
            return;
        }
        if (adVar != null && tbPageContext != null) {
            this.aNO -= adVar.getItemViewCount();
            adVar.a(Jd(), tbPageContext);
            adVar.setChangeViewVisibility(z);
        }
    }

    public void g(TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (this.aNN != null && this.aNN.get() != null && tbPageContext != null) {
            this.aNN.get().a(Jd(), tbPageContext);
        }
    }

    private List<com.baidu.tieba.enterForum.b.f> Jd() {
        int i;
        if (TbadkCoreApplication.isLogin()) {
            i = 3;
        } else {
            i = 4;
        }
        ArrayList arrayList = new ArrayList();
        if (this.aNO < 0 || this.aNO >= this.aNI.size()) {
            this.aNO = 0;
        }
        int i2 = this.aNO;
        int size = this.aNI.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aNI.get(i3) != null && arrayList.size() < i) {
                arrayList.add(this.aNI.get(i3));
                this.aNO++;
            }
        }
        return arrayList;
    }

    public ad Je() {
        if (this.aNN == null) {
            return null;
        }
        return this.aNN.get();
    }
}

package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private ab cdt;
    private CustomMessageListener cmX = new r(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);
    private CustomMessageListener cmY = new s(this, CmdConfigCustom.DELETE_AD_FROM_FEED);

    public q(ab abVar, BdUniqueId bdUniqueId) {
        this.cdt = abVar;
        this.cmX.setTag(bdUniqueId);
        this.cmY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cmX);
        MessageManager.getInstance().registerListener(this.cmY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.z.s(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof bm) {
                    bm bmVar = (bm) vVar;
                    if (bmVar.getTid() != null && bmVar.getTid().equals(str)) {
                        arrayList.add(bmVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.z.c(list, 0);
            if (vVar2 instanceof bh) {
                list.remove(vVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, BdTypeListView bdTypeListView) {
        int headerViewsCount = bdTypeListView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeListView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeListView.getAdapter().getCount(); i2++) {
            com.baidu.adp.widget.ListView.v item = bdTypeListView.getItem(i2);
            if (item instanceof bm) {
                bm bmVar = (bm) item;
                if (bmVar.getTid() != null && bmVar.getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(View view) {
        t tVar = new t(this, view.getMeasuredHeight(), view);
        tVar.setAnimationListener(new u(this, view));
        tVar.setDuration(300L);
        view.startAnimation(tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.ST)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<com.baidu.adp.widget.ListView.v> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.v> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object IX = ((com.baidu.tieba.InjectPlugin.a) next).IX();
                    if ((IX instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) IX).ST)) {
                        it.remove();
                    }
                }
            }
        }
    }
}

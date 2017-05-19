package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private y bPu;
    private CustomMessageListener bYx = new q(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);
    private CustomMessageListener bYy = new r(this, CmdConfigCustom.DELETE_AD_FROM_FEED);

    public p(y yVar, BdUniqueId bdUniqueId) {
        this.bPu = yVar;
        this.bYx.setTag(bdUniqueId);
        this.bYy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.bYx);
        MessageManager.getInstance().registerListener(this.bYy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.q(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof bk) {
                    bk bkVar = (bk) vVar;
                    if (bkVar.getTid() != null && bkVar.getTid().equals(str)) {
                        arrayList.add(bkVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.Tl)) {
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
                    Object IE = ((com.baidu.tieba.InjectPlugin.a) next).IE();
                    if ((IE instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) IE).Tl)) {
                        it.remove();
                    }
                }
            }
        }
    }
}

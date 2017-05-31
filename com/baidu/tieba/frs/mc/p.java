package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private y bVk;
    private CustomMessageListener ceJ = new q(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);
    private CustomMessageListener ceK = new r(this, CmdConfigCustom.DELETE_AD_FROM_FEED);

    public p(y yVar, BdUniqueId bdUniqueId) {
        this.bVk = yVar;
        this.ceJ.setTag(bdUniqueId);
        this.ceK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ceJ);
        MessageManager.getInstance().registerListener(this.ceK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.q(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof bl) {
                    bl blVar = (bl) vVar;
                    if (blVar.getTid() != null && blVar.getTid().equals(str)) {
                        arrayList.add(blVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(list, 0);
            if (vVar2 instanceof bg) {
                list.remove(vVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.SY)) {
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
                    Object Iz = ((com.baidu.tieba.InjectPlugin.a) next).Iz();
                    if ((Iz instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) Iz).SY)) {
                        it.remove();
                    }
                }
            }
        }
    }
}

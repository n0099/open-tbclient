package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private y bOd;
    private CustomMessageListener bYo = new q(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);
    private CustomMessageListener bYp = new r(this, CmdConfigCustom.DELETE_AD_FROM_FEED);

    public p(TbPageContext tbPageContext, y yVar) {
        this.bOd = yVar;
        tbPageContext.registerListener(this.bYo);
        tbPageContext.registerListener(this.bYp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.p(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof bi) {
                    bi biVar = (bi) vVar;
                    if (biVar.getTid() != null && biVar.getTid().equals(str)) {
                        arrayList.add(biVar);
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
                if (next != null && str.equals(next.TR)) {
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
                    Object Jq = ((com.baidu.tieba.InjectPlugin.a) next).Jq();
                    if ((Jq instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) Jq).TR)) {
                        it.remove();
                    }
                }
            }
        }
    }
}

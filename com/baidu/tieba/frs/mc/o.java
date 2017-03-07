package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private w bOo;
    private CustomMessageListener bZO = new p(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public o(TbPageContext tbPageContext, w wVar) {
        this.bOo = wVar;
        tbPageContext.registerListener(this.bZO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, List<com.baidu.adp.widget.ListView.v> list) {
        if (x.p(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof bj) {
                    bj bjVar = (bj) vVar;
                    if (bjVar.getTid() != null && bjVar.getTid().equals(str)) {
                        arrayList.add(bjVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }
}

package com.baidu.tieba.hottopic.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        j jVar = (j) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_FRS_NO_LIST_ITEM_ADAPTER, j.class, tbPageContext).getData();
        if (jVar != null) {
            this.aUP.add(jVar);
        }
        this.aUP.add(new c(tbPageContext, bu.dLQ));
        this.aUP.add(new a(tbPageContext, bu.dLR));
        bdTypeRecyclerView.addAdapters(this.aUP);
    }

    public void b(TbPageTag tbPageTag) {
        if (!w.isEmpty(this.aUP)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof j) {
                    ((j) aVar).a(tbPageTag);
                }
            }
        }
    }
}

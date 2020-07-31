package com.baidu.tieba.hottopic.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        j jVar = (j) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_FRS_NO_LIST_ITEM_ADAPTER, j.class, tbPageContext).getData();
        if (jVar != null) {
            this.aWf.add(jVar);
        }
        this.aWf.add(new c(tbPageContext, bv.dSb));
        this.aWf.add(new a(tbPageContext, bv.dSc));
        bdTypeRecyclerView.addAdapters(this.aWf);
    }

    public void b(TbPageTag tbPageTag) {
        if (!x.isEmpty(this.aWf)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof j) {
                    ((j) aVar).a(tbPageTag);
                }
            }
        }
    }
}

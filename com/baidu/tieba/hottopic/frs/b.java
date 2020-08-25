package com.baidu.tieba.hottopic.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        k kVar = (k) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_FRS_NO_LIST_ITEM_ADAPTER, k.class, tbPageContext).getData();
        if (kVar != null) {
            this.bbu.add(kVar);
        }
        this.bbu.add(new c(tbPageContext, bw.ebx));
        this.bbu.add(new a(tbPageContext, bw.eby));
        bdTypeRecyclerView.addAdapters(this.bbu);
    }

    public void b(TbPageTag tbPageTag) {
        if (!y.isEmpty(this.bbu)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof k) {
                    ((k) aVar).a(tbPageTag);
                }
            }
        }
    }
}

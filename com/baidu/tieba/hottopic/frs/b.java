package com.baidu.tieba.hottopic.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        k kVar = (k) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_FRS_NO_LIST_ITEM_ADAPTER, k.class, tbPageContext).getData();
        if (kVar != null) {
            this.boS.add(kVar);
        }
        this.boS.add(new c(tbPageContext, cb.eSv));
        this.boS.add(new a(tbPageContext, cb.eSw));
        bdTypeRecyclerView.addAdapters(this.boS);
    }

    public void b(TbPageTag tbPageTag) {
        if (!y.isEmpty(this.boS)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof k) {
                    ((k) aVar).a(tbPageTag);
                }
            }
        }
    }
}

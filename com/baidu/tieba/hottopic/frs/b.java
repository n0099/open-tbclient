package com.baidu.tieba.hottopic.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        k kVar = (k) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_FRS_NO_LIST_ITEM_ADAPTER, k.class, tbPageContext).getData();
        if (kVar != null) {
            this.boM.add(kVar);
        }
        this.boM.add(new c(tbPageContext, bz.eTt));
        this.boM.add(new a(tbPageContext, bz.eTu));
        bdTypeRecyclerView.addAdapters(this.boM);
    }

    public void b(TbPageTag tbPageTag) {
        if (!x.isEmpty(this.boM)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof k) {
                    ((k) aVar).a(tbPageTag);
                }
            }
        }
    }
}

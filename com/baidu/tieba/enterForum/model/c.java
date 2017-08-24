package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.c.e;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private TbPageContext<?> acr;
    private ViewEventCenter bYx;
    private SoftReference<com.baidu.tieba.enterForum.c.d> bZT;
    private com.baidu.tieba.enterForum.a.b bZU;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.acr = tbPageContext;
        this.bYx = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.c.d acn() {
        if (this.bZT == null) {
            return null;
        }
        return this.bZT.get();
    }

    public void aco() {
        com.baidu.tieba.enterForum.c.d dVar = new com.baidu.tieba.enterForum.c.d(this.acr.getPageActivity());
        dVar.setEventCenter(this.bYx);
        this.bZT = new SoftReference<>(dVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? e(this.bZU.getDataList(), false) : this.bZU.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.bZU.D(e(dataList, true));
            } else {
                this.bZU.D(dataList);
            }
        }
    }

    public void as(List<g> list) {
        com.baidu.tieba.enterForum.c.d dVar;
        if (this.bZT != null && list != null && (dVar = this.bZT.get()) != null) {
            dVar.acE();
            at(list);
        }
    }

    private List<g> e(List<g> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        if (list.size() > 0) {
            int size = list.size();
            if (!z) {
                size -= 2;
            }
            for (int i = 0; i < size; i++) {
                arrayList.add(list.get(i));
            }
            if (z) {
                arrayList.add(null);
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public void at(List<g> list) {
        com.baidu.tieba.enterForum.c.d dVar = this.bZT.get();
        if (dVar != null) {
            if (this.bZU == null) {
                acp();
            }
            dVar.setGridAdapterIfNeeded(this.bZU);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.bZU.D(e(list, true));
            } else {
                this.bZU.D(list);
            }
            this.bZU.b(this.acr, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void acp() {
        this.bZU = new com.baidu.tieba.enterForum.a.b(this.acr, e.class, d.j.home_like_item_in_edit_grid, this.bYx);
        this.bZU.bX(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bZT.get() != null) {
                this.bZT.get().n(tbPageContext);
            }
            if (this.bZU != null) {
                this.bZU.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

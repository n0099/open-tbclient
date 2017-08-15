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
    private ViewEventCenter bYw;
    private SoftReference<com.baidu.tieba.enterForum.c.d> bZS;
    private com.baidu.tieba.enterForum.a.b bZT;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.acr = tbPageContext;
        this.bYw = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.c.d acr() {
        if (this.bZS == null) {
            return null;
        }
        return this.bZS.get();
    }

    public void acs() {
        com.baidu.tieba.enterForum.c.d dVar = new com.baidu.tieba.enterForum.c.d(this.acr.getPageActivity());
        dVar.setEventCenter(this.bYw);
        this.bZS = new SoftReference<>(dVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? e(this.bZT.getDataList(), false) : this.bZT.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.bZT.D(e(dataList, true));
            } else {
                this.bZT.D(dataList);
            }
        }
    }

    public void as(List<g> list) {
        com.baidu.tieba.enterForum.c.d dVar;
        if (this.bZS != null && list != null && (dVar = this.bZS.get()) != null) {
            dVar.acI();
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
        com.baidu.tieba.enterForum.c.d dVar = this.bZS.get();
        if (dVar != null) {
            if (this.bZT == null) {
                act();
            }
            dVar.setGridAdapterIfNeeded(this.bZT);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.bZT.D(e(list, true));
            } else {
                this.bZT.D(list);
            }
            this.bZT.b(this.acr, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void act() {
        this.bZT = new com.baidu.tieba.enterForum.a.b(this.acr, e.class, d.j.home_like_item_in_edit_grid, this.bYw);
        this.bZT.bX(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bZS.get() != null) {
                this.bZS.get().n(tbPageContext);
            }
            if (this.bZT != null) {
                this.bZT.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

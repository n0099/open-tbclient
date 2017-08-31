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
    private TbPageContext<?> aby;
    private ViewEventCenter cbt;
    private SoftReference<com.baidu.tieba.enterForum.c.d> ccO;
    private com.baidu.tieba.enterForum.a.b ccP;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aby = tbPageContext;
        this.cbt = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.c.d adn() {
        if (this.ccO == null) {
            return null;
        }
        return this.ccO.get();
    }

    public void ado() {
        com.baidu.tieba.enterForum.c.d dVar = new com.baidu.tieba.enterForum.c.d(this.aby.getPageActivity());
        dVar.setEventCenter(this.cbt);
        this.ccO = new SoftReference<>(dVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? e(this.ccP.getDataList(), false) : this.ccP.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.ccP.D(e(dataList, true));
            } else {
                this.ccP.D(dataList);
            }
        }
    }

    public void at(List<g> list) {
        com.baidu.tieba.enterForum.c.d dVar;
        if (this.ccO != null && list != null && (dVar = this.ccO.get()) != null) {
            dVar.adC();
            au(list);
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

    public void au(List<g> list) {
        com.baidu.tieba.enterForum.c.d dVar = this.ccO.get();
        if (dVar != null) {
            if (this.ccP == null) {
                adp();
            }
            dVar.setGridAdapterIfNeeded(this.ccP);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.ccP.D(e(list, true));
            } else {
                this.ccP.D(list);
            }
            this.ccP.b(this.aby, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void adp() {
        this.ccP = new com.baidu.tieba.enterForum.a.b(this.aby, e.class, d.j.home_like_item_in_edit_grid, this.cbt);
        this.ccP.bX(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.ccO.get() != null) {
                this.ccO.get().n(tbPageContext);
            }
            if (this.ccP != null) {
                this.ccP.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

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
    private ViewEventCenter ccl;
    private SoftReference<com.baidu.tieba.enterForum.c.d> cdG;
    private com.baidu.tieba.enterForum.a.b cdH;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aby = tbPageContext;
        this.ccl = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.c.d ady() {
        if (this.cdG == null) {
            return null;
        }
        return this.cdG.get();
    }

    public void adz() {
        com.baidu.tieba.enterForum.c.d dVar = new com.baidu.tieba.enterForum.c.d(this.aby.getPageActivity());
        dVar.setEventCenter(this.ccl);
        this.cdG = new SoftReference<>(dVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? e(this.cdH.getDataList(), false) : this.cdH.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cdH.D(e(dataList, true));
            } else {
                this.cdH.D(dataList);
            }
        }
    }

    public void at(List<g> list) {
        com.baidu.tieba.enterForum.c.d dVar;
        if (this.cdG != null && list != null && (dVar = this.cdG.get()) != null) {
            dVar.adN();
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
        com.baidu.tieba.enterForum.c.d dVar = this.cdG.get();
        if (dVar != null) {
            if (this.cdH == null) {
                adA();
            }
            dVar.setGridAdapterIfNeeded(this.cdH);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cdH.D(e(list, true));
            } else {
                this.cdH.D(list);
            }
            this.cdH.b(this.aby, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void adA() {
        this.cdH = new com.baidu.tieba.enterForum.a.b(this.aby, e.class, d.j.home_like_item_in_edit_grid, this.ccl);
        this.cdH.bX(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cdG.get() != null) {
                this.cdG.get().n(tbPageContext);
            }
            if (this.cdH != null) {
                this.cdH.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

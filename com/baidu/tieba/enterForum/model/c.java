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
    private TbPageContext<?> aaS;
    private ViewEventCenter bWE;
    private SoftReference<com.baidu.tieba.enterForum.c.d> bYa;
    private com.baidu.tieba.enterForum.a.b bYb;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aaS = tbPageContext;
        this.bWE = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.c.d abR() {
        if (this.bYa == null) {
            return null;
        }
        return this.bYa.get();
    }

    public void abS() {
        com.baidu.tieba.enterForum.c.d dVar = new com.baidu.tieba.enterForum.c.d(this.aaS.getPageActivity());
        dVar.setEventCenter(this.bWE);
        this.bYa = new SoftReference<>(dVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? e(this.bYb.getDataList(), false) : this.bYb.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.bYb.D(e(dataList, true));
            } else {
                this.bYb.D(dataList);
            }
        }
    }

    public void as(List<g> list) {
        com.baidu.tieba.enterForum.c.d dVar;
        if (this.bYa != null && list != null && (dVar = this.bYa.get()) != null) {
            dVar.aci();
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
        com.baidu.tieba.enterForum.c.d dVar = this.bYa.get();
        if (dVar != null) {
            if (this.bYb == null) {
                abT();
            }
            dVar.setGridAdapterIfNeeded(this.bYb);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.bYb.D(e(list, true));
            } else {
                this.bYb.D(list);
            }
            this.bYb.b(this.aaS, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void abT() {
        this.bYb = new com.baidu.tieba.enterForum.a.b(this.aaS, e.class, d.j.home_like_item_in_edit_grid, this.bWE);
        this.bYb.bX(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bYa.get() != null) {
                this.bYa.get().n(tbPageContext);
            }
            if (this.bYb != null) {
                this.bYb.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

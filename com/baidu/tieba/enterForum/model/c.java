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
    private TbPageContext<?> abz;
    private ViewEventCenter ccl;
    private SoftReference<com.baidu.tieba.enterForum.c.d> cdH;
    private com.baidu.tieba.enterForum.a.b cdI;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.abz = tbPageContext;
        this.ccl = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.c.d adl() {
        if (this.cdH == null) {
            return null;
        }
        return this.cdH.get();
    }

    public void adm() {
        com.baidu.tieba.enterForum.c.d dVar = new com.baidu.tieba.enterForum.c.d(this.abz.getPageActivity());
        dVar.setEventCenter(this.ccl);
        this.cdH = new SoftReference<>(dVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? e(this.cdI.getDataList(), false) : this.cdI.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cdI.C(e(dataList, true));
            } else {
                this.cdI.C(dataList);
            }
        }
    }

    public void as(List<g> list) {
        com.baidu.tieba.enterForum.c.d dVar;
        if (this.cdH != null && list != null && (dVar = this.cdH.get()) != null) {
            dVar.adA();
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
        com.baidu.tieba.enterForum.c.d dVar = this.cdH.get();
        if (dVar != null) {
            if (this.cdI == null) {
                adn();
            }
            dVar.setGridAdapterIfNeeded(this.cdI);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cdI.C(e(list, true));
            } else {
                this.cdI.C(list);
            }
            this.cdI.b(this.abz, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void adn() {
        this.cdI = new com.baidu.tieba.enterForum.a.b(this.abz, e.class, d.j.home_like_item_in_edit_grid, this.ccl);
        this.cdI.bW(false);
    }

    public void k(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cdH.get() != null) {
                this.cdH.get().k(tbPageContext);
            }
            if (this.cdI != null) {
                this.cdI.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

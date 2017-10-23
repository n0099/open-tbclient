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
    private TbPageContext<?> abm;
    private ViewEventCenter cbZ;
    private SoftReference<com.baidu.tieba.enterForum.c.d> cdv;
    private com.baidu.tieba.enterForum.a.b cdw;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.abm = tbPageContext;
        this.cbZ = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.c.d adh() {
        if (this.cdv == null) {
            return null;
        }
        return this.cdv.get();
    }

    public void adi() {
        com.baidu.tieba.enterForum.c.d dVar = new com.baidu.tieba.enterForum.c.d(this.abm.getPageActivity());
        dVar.setEventCenter(this.cbZ);
        this.cdv = new SoftReference<>(dVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? e(this.cdw.getDataList(), false) : this.cdw.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cdw.C(e(dataList, true));
            } else {
                this.cdw.C(dataList);
            }
        }
    }

    public void as(List<g> list) {
        com.baidu.tieba.enterForum.c.d dVar;
        if (this.cdv != null && list != null && (dVar = this.cdv.get()) != null) {
            dVar.adw();
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
        com.baidu.tieba.enterForum.c.d dVar = this.cdv.get();
        if (dVar != null) {
            if (this.cdw == null) {
                adj();
            }
            dVar.setGridAdapterIfNeeded(this.cdw);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cdw.C(e(list, true));
            } else {
                this.cdw.C(list);
            }
            this.cdw.b(this.abm, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void adj() {
        this.cdw = new com.baidu.tieba.enterForum.a.b(this.abm, e.class, d.j.home_like_item_in_edit_grid, this.cbZ);
        this.cdw.bV(false);
    }

    public void k(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cdv.get() != null) {
                this.cdv.get().k(tbPageContext);
            }
            if (this.cdw != null) {
                this.cdw.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

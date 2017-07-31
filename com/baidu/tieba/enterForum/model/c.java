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
    private TbPageContext<?> acp;
    private ViewEventCenter bXK;
    private SoftReference<com.baidu.tieba.enterForum.c.d> bZg;
    private com.baidu.tieba.enterForum.a.b bZh;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.acp = tbPageContext;
        this.bXK = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.c.d abW() {
        if (this.bZg == null) {
            return null;
        }
        return this.bZg.get();
    }

    public void abX() {
        com.baidu.tieba.enterForum.c.d dVar = new com.baidu.tieba.enterForum.c.d(this.acp.getPageActivity());
        dVar.setEventCenter(this.bXK);
        this.bZg = new SoftReference<>(dVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? e(this.bZh.getDataList(), false) : this.bZh.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.bZh.D(e(dataList, true));
            } else {
                this.bZh.D(dataList);
            }
        }
    }

    public void as(List<g> list) {
        com.baidu.tieba.enterForum.c.d dVar;
        if (this.bZg != null && list != null && (dVar = this.bZg.get()) != null) {
            dVar.acn();
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
        com.baidu.tieba.enterForum.c.d dVar = this.bZg.get();
        if (dVar != null) {
            if (this.bZh == null) {
                abY();
            }
            dVar.setGridAdapterIfNeeded(this.bZh);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.bZh.D(e(list, true));
            } else {
                this.bZh.D(list);
            }
            this.bZh.b(this.acp, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void abY() {
        this.bZh = new com.baidu.tieba.enterForum.a.b(this.acp, e.class, d.j.home_like_item_in_edit_grid, this.bXK);
        this.bZh.bX(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bZg.get() != null) {
                this.bZg.get().n(tbPageContext);
            }
            if (this.bZh != null) {
                this.bZh.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.c.m;
import com.baidu.tieba.enterForum.c.o;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private TbPageContext<?> aat;
    private ViewEventCenter bGb;
    private SoftReference<m> bHv;
    private com.baidu.tieba.enterForum.a.d bHw;

    public d(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aat = tbPageContext;
        this.bGb = viewEventCenter;
    }

    public m WE() {
        if (this.bHv == null) {
            return null;
        }
        return this.bHv.get();
    }

    public void WF() {
        m mVar = new m(this.aat.getPageActivity());
        mVar.setEventCenter(this.bGb);
        this.bHv = new SoftReference<>(mVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.m9getInst().getSkinType() != 2 ? d(this.bHw.getDataList(), false) : this.bHw.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bHw.x(d(dataList, true));
            } else {
                this.bHw.x(dataList);
            }
        }
    }

    public void ag(List<g> list) {
        m mVar;
        if (this.bHv != null && list != null && (mVar = this.bHv.get()) != null) {
            mVar.WS();
            ah(list);
        }
    }

    private List<g> d(List<g> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        if (list.size() > 0) {
            int size = list.size();
            int i = !z ? size - 2 : size;
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(list.get(i2));
            }
            if (z) {
                arrayList.add(null);
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public void ah(List<g> list) {
        m mVar = this.bHv.get();
        if (mVar != null) {
            if (this.bHw == null) {
                WG();
            }
            mVar.setGridAdapterIfNeeded(this.bHw);
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bHw.x(d(list, true));
            } else {
                this.bHw.x(list);
            }
            this.bHw.b(this.aat, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void WG() {
        this.bHw = new com.baidu.tieba.enterForum.a.d(this.aat, o.class, w.j.home_like_item_in_edit_grid, this.bGb);
        this.bHw.bV(false);
    }

    public void o(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bHv.get() != null) {
                this.bHv.get().o(tbPageContext);
            }
            if (this.bHw != null) {
                this.bHw.b(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}

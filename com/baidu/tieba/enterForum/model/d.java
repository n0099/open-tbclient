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
    private TbPageContext<?> aas;
    private ViewEventCenter bLQ;
    private SoftReference<m> bNj;
    private com.baidu.tieba.enterForum.a.d bNk;

    public d(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aas = tbPageContext;
        this.bLQ = viewEventCenter;
    }

    public m XH() {
        if (this.bNj == null) {
            return null;
        }
        return this.bNj.get();
    }

    public void XI() {
        m mVar = new m(this.aas.getPageActivity());
        mVar.setEventCenter(this.bLQ);
        this.bNj = new SoftReference<>(mVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.m9getInst().getSkinType() != 2 ? d(this.bNk.getDataList(), false) : this.bNk.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bNk.x(d(dataList, true));
            } else {
                this.bNk.x(dataList);
            }
        }
    }

    public void ag(List<g> list) {
        m mVar;
        if (this.bNj != null && list != null && (mVar = this.bNj.get()) != null) {
            mVar.XV();
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
        m mVar = this.bNj.get();
        if (mVar != null) {
            if (this.bNk == null) {
                XJ();
            }
            mVar.setGridAdapterIfNeeded(this.bNk);
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bNk.x(d(list, true));
            } else {
                this.bNk.x(list);
            }
            this.bNk.b(this.aas, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void XJ() {
        this.bNk = new com.baidu.tieba.enterForum.a.d(this.aas, o.class, w.j.home_like_item_in_edit_grid, this.bLQ);
        this.bNk.bS(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bNj.get() != null) {
                this.bNj.get().n(tbPageContext);
            }
            if (this.bNk != null) {
                this.bNk.b(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}

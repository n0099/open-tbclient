package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.c.l;
import com.baidu.tieba.enterForum.c.n;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private TbPageContext<?> aat;
    private ViewEventCenter bSq;
    private SoftReference<l> bTM;
    private com.baidu.tieba.enterForum.a.d bTN;

    public d(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aat = tbPageContext;
        this.bSq = viewEventCenter;
    }

    public l abf() {
        if (this.bTM == null) {
            return null;
        }
        return this.bTM.get();
    }

    public void abg() {
        l lVar = new l(this.aat.getPageActivity());
        lVar.setEventCenter(this.bSq);
        this.bTM = new SoftReference<>(lVar);
    }

    public List<g> getDataList() {
        return TbadkCoreApplication.m9getInst().getSkinType() != 2 ? e(this.bTN.getDataList(), false) : this.bTN.getDataList();
    }

    public void b(g gVar) {
        List<g> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(gVar);
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bTN.z(e(dataList, true));
            } else {
                this.bTN.z(dataList);
            }
        }
    }

    public void am(List<g> list) {
        l lVar;
        if (this.bTM != null && list != null && (lVar = this.bTM.get()) != null) {
            lVar.abw();
            an(list);
        }
    }

    private List<g> e(List<g> list, boolean z) {
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

    public void an(List<g> list) {
        l lVar = this.bTM.get();
        if (lVar != null) {
            if (this.bTN == null) {
                abh();
            }
            lVar.setGridAdapterIfNeeded(this.bTN);
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bTN.z(e(list, true));
            } else {
                this.bTN.z(list);
            }
            this.bTN.b(this.aat, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void abh() {
        this.bTN = new com.baidu.tieba.enterForum.a.d(this.aat, n.class, w.j.home_like_item_in_edit_grid, this.bSq);
        this.bTN.bU(false);
    }

    public void n(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.bTM.get() != null) {
                this.bTM.get().n(tbPageContext);
            }
            if (this.bTN != null) {
                this.bTN.b(tbPageContext, TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }
}

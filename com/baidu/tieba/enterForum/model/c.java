package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.e;
import com.baidu.tieba.enterForum.data.f;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private TbPageContext<?> aQp;
    private ViewEventCenter dlJ;
    private SoftReference<com.baidu.tieba.enterForum.b.d> dna;
    private com.baidu.tieba.enterForum.a.b dnb;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aQp = tbPageContext;
        this.dlJ = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d aqa() {
        if (this.dna == null) {
            return null;
        }
        return this.dna.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.aQp.getPageActivity());
        dVar.setEventCenter(this.dlJ);
        this.dna = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.dnb.getDataList(), false) : this.dnb.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dnb.L(f(dataList, true));
            } else {
                this.dnb.L(dataList);
            }
        }
    }

    public void aP(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.dna != null && list != null && (dVar = this.dna.get()) != null) {
            dVar.aqm();
            aQ(list);
        }
    }

    private List<f> f(List<f> list, boolean z) {
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

    public void aQ(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar = this.dna.get();
        if (dVar != null) {
            if (this.dnb == null) {
                aqb();
            }
            dVar.setGridAdapterIfNeeded(this.dnb);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dnb.L(f(list, true));
            } else {
                this.dnb.L(list);
            }
            this.dnb.b(this.aQp, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aqb() {
        this.dnb = new com.baidu.tieba.enterForum.a.b(this.aQp, e.class, d.h.home_like_item_in_edit_grid, this.dlJ);
        this.dnb.cs(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.dna.get() != null) {
                this.dna.get().onChangeSkinType(tbPageContext);
            }
            if (this.dnb != null) {
                this.dnb.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

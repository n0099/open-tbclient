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
/* loaded from: classes.dex */
public class c {
    private TbPageContext<?> abI;
    private ViewEventCenter cjP;
    private SoftReference<com.baidu.tieba.enterForum.b.d> clj;
    private com.baidu.tieba.enterForum.a.b clk;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.abI = tbPageContext;
        this.cjP = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d afD() {
        if (this.clj == null) {
            return null;
        }
        return this.clj.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.abI.getPageActivity());
        dVar.setEventCenter(this.cjP);
        this.clj = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? e(this.clk.getDataList(), false) : this.clk.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.clk.D(e(dataList, true));
            } else {
                this.clk.D(dataList);
            }
        }
    }

    public void au(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.clj != null && list != null && (dVar = this.clj.get()) != null) {
            dVar.afR();
            av(list);
        }
    }

    private List<f> e(List<f> list, boolean z) {
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

    public void av(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar = this.clj.get();
        if (dVar != null) {
            if (this.clk == null) {
                afE();
            }
            dVar.setGridAdapterIfNeeded(this.clk);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.clk.D(e(list, true));
            } else {
                this.clk.D(list);
            }
            this.clk.b(this.abI, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void afE() {
        this.clk = new com.baidu.tieba.enterForum.a.b(this.abI, e.class, d.h.home_like_item_in_edit_grid, this.cjP);
        this.clk.bR(false);
    }

    public void k(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.clj.get() != null) {
                this.clj.get().k(tbPageContext);
            }
            if (this.clk != null) {
                this.clk.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

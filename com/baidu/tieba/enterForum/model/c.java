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
    private ViewEventCenter cjC;
    private SoftReference<com.baidu.tieba.enterForum.b.d> ckQ;
    private com.baidu.tieba.enterForum.a.b ckR;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.abI = tbPageContext;
        this.cjC = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d afp() {
        if (this.ckQ == null) {
            return null;
        }
        return this.ckQ.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.abI.getPageActivity());
        dVar.setEventCenter(this.cjC);
        this.ckQ = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? e(this.ckR.getDataList(), false) : this.ckR.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.ckR.D(e(dataList, true));
            } else {
                this.ckR.D(dataList);
            }
        }
    }

    public void au(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.ckQ != null && list != null && (dVar = this.ckQ.get()) != null) {
            dVar.afD();
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
        com.baidu.tieba.enterForum.b.d dVar = this.ckQ.get();
        if (dVar != null) {
            if (this.ckR == null) {
                afq();
            }
            dVar.setGridAdapterIfNeeded(this.ckR);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.ckR.D(e(list, true));
            } else {
                this.ckR.D(list);
            }
            this.ckR.b(this.abI, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void afq() {
        this.ckR = new com.baidu.tieba.enterForum.a.b(this.abI, e.class, d.h.home_like_item_in_edit_grid, this.cjC);
        this.ckR.bQ(false);
    }

    public void k(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.ckQ.get() != null) {
                this.ckQ.get().k(tbPageContext);
            }
            if (this.ckR != null) {
                this.ckR.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

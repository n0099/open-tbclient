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
    private TbPageContext<?> aRG;
    private ViewEventCenter doJ;
    private SoftReference<com.baidu.tieba.enterForum.b.d> dqd;
    private com.baidu.tieba.enterForum.a.b dqe;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aRG = tbPageContext;
        this.doJ = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d aqU() {
        if (this.dqd == null) {
            return null;
        }
        return this.dqd.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.aRG.getPageActivity());
        dVar.setEventCenter(this.doJ);
        this.dqd = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? g(this.dqe.getDataList(), false) : this.dqe.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dqe.N(g(dataList, true));
            } else {
                this.dqe.N(dataList);
            }
        }
    }

    public void aR(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.dqd != null && list != null && (dVar = this.dqd.get()) != null) {
            dVar.arg();
            aS(list);
        }
    }

    private List<f> g(List<f> list, boolean z) {
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

    public void aS(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar = this.dqd.get();
        if (dVar != null) {
            if (this.dqe == null) {
                aqV();
            }
            dVar.setGridAdapterIfNeeded(this.dqe);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dqe.N(g(list, true));
            } else {
                this.dqe.N(list);
            }
            this.dqe.b(this.aRG, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aqV() {
        this.dqe = new com.baidu.tieba.enterForum.a.b(this.aRG, e.class, d.h.home_like_item_in_edit_grid, this.doJ);
        this.dqe.cx(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.dqd.get() != null) {
                this.dqd.get().onChangeSkinType(tbPageContext);
            }
            if (this.dqe != null) {
                this.dqe.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

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
    private TbPageContext<?> acd;
    private ViewEventCenter csw;
    private SoftReference<com.baidu.tieba.enterForum.b.d> ctP;
    private com.baidu.tieba.enterForum.a.b ctQ;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.acd = tbPageContext;
        this.csw = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d ahp() {
        if (this.ctP == null) {
            return null;
        }
        return this.ctP.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.acd.getPageActivity());
        dVar.setEventCenter(this.csw);
        this.ctP = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.ctQ.getDataList(), false) : this.ctQ.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.ctQ.E(f(dataList, true));
            } else {
                this.ctQ.E(dataList);
            }
        }
    }

    public void aG(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.ctP != null && list != null && (dVar = this.ctP.get()) != null) {
            dVar.ahC();
            aH(list);
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

    public void aH(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar = this.ctP.get();
        if (dVar != null) {
            if (this.ctQ == null) {
                ahq();
            }
            dVar.setGridAdapterIfNeeded(this.ctQ);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.ctQ.E(f(list, true));
            } else {
                this.ctQ.E(list);
            }
            this.ctQ.b(this.acd, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ahq() {
        this.ctQ = new com.baidu.tieba.enterForum.a.b(this.acd, e.class, d.h.home_like_item_in_edit_grid, this.csw);
        this.ctQ.bQ(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.ctP.get() != null) {
                this.ctP.get().onChangeSkinType(tbPageContext);
            }
            if (this.ctQ != null) {
                this.ctQ.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

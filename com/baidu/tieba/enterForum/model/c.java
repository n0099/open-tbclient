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
    private TbPageContext<?> abX;
    private ViewEventCenter csF;
    private SoftReference<com.baidu.tieba.enterForum.b.d> ctY;
    private com.baidu.tieba.enterForum.a.b ctZ;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.abX = tbPageContext;
        this.csF = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d ahw() {
        if (this.ctY == null) {
            return null;
        }
        return this.ctY.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.abX.getPageActivity());
        dVar.setEventCenter(this.csF);
        this.ctY = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.ctZ.getDataList(), false) : this.ctZ.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.ctZ.E(f(dataList, true));
            } else {
                this.ctZ.E(dataList);
            }
        }
    }

    public void aG(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.ctY != null && list != null && (dVar = this.ctY.get()) != null) {
            dVar.ahJ();
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
        com.baidu.tieba.enterForum.b.d dVar = this.ctY.get();
        if (dVar != null) {
            if (this.ctZ == null) {
                ahx();
            }
            dVar.setGridAdapterIfNeeded(this.ctZ);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.ctZ.E(f(list, true));
            } else {
                this.ctZ.E(list);
            }
            this.ctZ.b(this.abX, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ahx() {
        this.ctZ = new com.baidu.tieba.enterForum.a.b(this.abX, e.class, d.h.home_like_item_in_edit_grid, this.csF);
        this.ctZ.bR(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.ctY.get() != null) {
                this.ctY.get().onChangeSkinType(tbPageContext);
            }
            if (this.ctZ != null) {
                this.ctZ.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

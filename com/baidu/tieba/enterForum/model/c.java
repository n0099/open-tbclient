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
    private TbPageContext<?> aca;
    private ViewEventCenter csJ;
    private SoftReference<com.baidu.tieba.enterForum.b.d> cuc;
    private com.baidu.tieba.enterForum.a.b cud;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aca = tbPageContext;
        this.csJ = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d ahw() {
        if (this.cuc == null) {
            return null;
        }
        return this.cuc.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.aca.getPageActivity());
        dVar.setEventCenter(this.csJ);
        this.cuc = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.cud.getDataList(), false) : this.cud.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cud.E(f(dataList, true));
            } else {
                this.cud.E(dataList);
            }
        }
    }

    public void aG(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.cuc != null && list != null && (dVar = this.cuc.get()) != null) {
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
        com.baidu.tieba.enterForum.b.d dVar = this.cuc.get();
        if (dVar != null) {
            if (this.cud == null) {
                ahx();
            }
            dVar.setGridAdapterIfNeeded(this.cud);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cud.E(f(list, true));
            } else {
                this.cud.E(list);
            }
            this.cud.b(this.aca, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ahx() {
        this.cud = new com.baidu.tieba.enterForum.a.b(this.aca, e.class, d.h.home_like_item_in_edit_grid, this.csJ);
        this.cud.bR(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cuc.get() != null) {
                this.cuc.get().onChangeSkinType(tbPageContext);
            }
            if (this.cud != null) {
                this.cud.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

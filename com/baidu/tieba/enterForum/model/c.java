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
    private TbPageContext<?> aQq;
    private ViewEventCenter dhh;
    private com.baidu.tieba.enterForum.a.b diA;
    private SoftReference<com.baidu.tieba.enterForum.b.d> diz;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aQq = tbPageContext;
        this.dhh = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d aoX() {
        if (this.diz == null) {
            return null;
        }
        return this.diz.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.aQq.getPageActivity());
        dVar.setEventCenter(this.dhh);
        this.diz = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.diA.getDataList(), false) : this.diA.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.diA.N(f(dataList, true));
            } else {
                this.diA.N(dataList);
            }
        }
    }

    public void aR(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.diz != null && list != null && (dVar = this.diz.get()) != null) {
            dVar.apj();
            aS(list);
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

    public void aS(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar = this.diz.get();
        if (dVar != null) {
            if (this.diA == null) {
                aoY();
            }
            dVar.setGridAdapterIfNeeded(this.diA);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.diA.N(f(list, true));
            } else {
                this.diA.N(list);
            }
            this.diA.b(this.aQq, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aoY() {
        this.diA = new com.baidu.tieba.enterForum.a.b(this.aQq, e.class, d.h.home_like_item_in_edit_grid, this.dhh);
        this.diA.cu(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.diz.get() != null) {
                this.diz.get().onChangeSkinType(tbPageContext);
            }
            if (this.diA != null) {
                this.diA.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

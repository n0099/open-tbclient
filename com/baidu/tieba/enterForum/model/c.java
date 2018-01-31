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
    private TbPageContext<?> aQs;
    private ViewEventCenter dme;
    private SoftReference<com.baidu.tieba.enterForum.b.d> dnv;
    private com.baidu.tieba.enterForum.a.b dnw;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aQs = tbPageContext;
        this.dme = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d aqf() {
        if (this.dnv == null) {
            return null;
        }
        return this.dnv.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.aQs.getPageActivity());
        dVar.setEventCenter(this.dme);
        this.dnv = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.dnw.getDataList(), false) : this.dnw.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dnw.L(f(dataList, true));
            } else {
                this.dnw.L(dataList);
            }
        }
    }

    public void aP(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.dnv != null && list != null && (dVar = this.dnv.get()) != null) {
            dVar.aqr();
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
        com.baidu.tieba.enterForum.b.d dVar = this.dnv.get();
        if (dVar != null) {
            if (this.dnw == null) {
                aqg();
            }
            dVar.setGridAdapterIfNeeded(this.dnw);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dnw.L(f(list, true));
            } else {
                this.dnw.L(list);
            }
            this.dnw.b(this.aQs, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aqg() {
        this.dnw = new com.baidu.tieba.enterForum.a.b(this.aQs, e.class, d.h.home_like_item_in_edit_grid, this.dme);
        this.dnw.ct(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.dnv.get() != null) {
                this.dnv.get().onChangeSkinType(tbPageContext);
            }
            if (this.dnw != null) {
                this.dnw.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

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
    private TbPageContext<?> aRI;
    private ViewEventCenter doM;
    private SoftReference<com.baidu.tieba.enterForum.b.d> dqg;
    private com.baidu.tieba.enterForum.a.b dqh;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aRI = tbPageContext;
        this.doM = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d aqV() {
        if (this.dqg == null) {
            return null;
        }
        return this.dqg.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.aRI.getPageActivity());
        dVar.setEventCenter(this.doM);
        this.dqg = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? g(this.dqh.getDataList(), false) : this.dqh.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dqh.N(g(dataList, true));
            } else {
                this.dqh.N(dataList);
            }
        }
    }

    public void aR(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.dqg != null && list != null && (dVar = this.dqg.get()) != null) {
            dVar.arh();
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
        com.baidu.tieba.enterForum.b.d dVar = this.dqg.get();
        if (dVar != null) {
            if (this.dqh == null) {
                aqW();
            }
            dVar.setGridAdapterIfNeeded(this.dqh);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dqh.N(g(list, true));
            } else {
                this.dqh.N(list);
            }
            this.dqh.b(this.aRI, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aqW() {
        this.dqh = new com.baidu.tieba.enterForum.a.b(this.aRI, e.class, d.h.home_like_item_in_edit_grid, this.doM);
        this.dqh.cx(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.dqg.get() != null) {
                this.dqg.get().onChangeSkinType(tbPageContext);
            }
            if (this.dqh != null) {
                this.dqh.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

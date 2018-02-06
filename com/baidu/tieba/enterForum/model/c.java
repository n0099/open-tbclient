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
    private TbPageContext<?> aRR;
    private ViewEventCenter doV;
    private SoftReference<com.baidu.tieba.enterForum.b.d> dqp;
    private com.baidu.tieba.enterForum.a.b dqq;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.aRR = tbPageContext;
        this.doV = viewEventCenter;
    }

    public com.baidu.tieba.enterForum.b.d aqV() {
        if (this.dqp == null) {
            return null;
        }
        return this.dqp.get();
    }

    public void createView() {
        com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.aRR.getPageActivity());
        dVar.setEventCenter(this.doV);
        this.dqp = new SoftReference<>(dVar);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? g(this.dqq.getDataList(), false) : this.dqq.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dqq.N(g(dataList, true));
            } else {
                this.dqq.N(dataList);
            }
        }
    }

    public void aR(List<f> list) {
        com.baidu.tieba.enterForum.b.d dVar;
        if (this.dqp != null && list != null && (dVar = this.dqp.get()) != null) {
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
        com.baidu.tieba.enterForum.b.d dVar = this.dqp.get();
        if (dVar != null) {
            if (this.dqq == null) {
                aqW();
            }
            dVar.setGridAdapterIfNeeded(this.dqq);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dqq.N(g(list, true));
            } else {
                this.dqq.N(list);
            }
            this.dqq.b(this.aRR, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aqW() {
        this.dqq = new com.baidu.tieba.enterForum.a.b(this.aRR, e.class, d.h.home_like_item_in_edit_grid, this.doV);
        this.dqq.cx(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.dqp.get() != null) {
                this.dqp.get().onChangeSkinType(tbPageContext);
            }
            if (this.dqq != null) {
                this.dqq.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

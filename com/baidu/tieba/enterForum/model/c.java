package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.view.ForumEditView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private ViewEventCenter drf;
    private SoftReference<ForumEditView> dsP;
    private com.baidu.tieba.enterForum.a.b dsQ;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.drf = viewEventCenter;
    }

    public ForumEditView awQ() {
        if (this.dsP == null) {
            return null;
        }
        return this.dsP.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.drf);
        this.dsP = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? h(this.dsQ.getDataList(), false) : this.dsQ.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dsQ.S(h(dataList, true));
            } else {
                this.dsQ.S(dataList);
            }
        }
    }

    public void bl(List<f> list) {
        ForumEditView forumEditView;
        if (this.dsP != null && list != null && (forumEditView = this.dsP.get()) != null) {
            forumEditView.setColumnTypeAndRefeshView();
            bm(list);
        }
    }

    private List<f> h(List<f> list, boolean z) {
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

    public void bm(List<f> list) {
        ForumEditView forumEditView = this.dsP.get();
        if (forumEditView != null) {
            if (this.dsQ == null) {
                awR();
            }
            forumEditView.setGridAdapterIfNeeded(this.dsQ);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dsQ.S(h(list, true));
            } else {
                this.dsQ.S(list);
            }
            this.dsQ.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void awR() {
        this.dsQ = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, e.h.home_like_item_in_edit_grid, this.drf);
        this.dsQ.cL(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.dsP.get() != null) {
                this.dsP.get().onChangeSkinType(tbPageContext);
            }
            if (this.dsQ != null) {
                this.dsQ.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

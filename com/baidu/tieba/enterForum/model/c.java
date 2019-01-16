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
    private ViewEventCenter dre;
    private SoftReference<ForumEditView> dsO;
    private com.baidu.tieba.enterForum.a.b dsP;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.dre = viewEventCenter;
    }

    public ForumEditView awQ() {
        if (this.dsO == null) {
            return null;
        }
        return this.dsO.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.dre);
        this.dsO = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? h(this.dsP.getDataList(), false) : this.dsP.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dsP.S(h(dataList, true));
            } else {
                this.dsP.S(dataList);
            }
        }
    }

    public void bl(List<f> list) {
        ForumEditView forumEditView;
        if (this.dsO != null && list != null && (forumEditView = this.dsO.get()) != null) {
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
        ForumEditView forumEditView = this.dsO.get();
        if (forumEditView != null) {
            if (this.dsP == null) {
                awR();
            }
            forumEditView.setGridAdapterIfNeeded(this.dsP);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dsP.S(h(list, true));
            } else {
                this.dsP.S(list);
            }
            this.dsP.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void awR() {
        this.dsP = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, e.h.home_like_item_in_edit_grid, this.dre);
        this.dsP.cL(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.dsO.get() != null) {
                this.dsO.get().onChangeSkinType(tbPageContext);
            }
            if (this.dsP != null) {
                this.dsP.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

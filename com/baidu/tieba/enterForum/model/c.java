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
    private ViewEventCenter dgT;
    private SoftReference<ForumEditView> diM;
    private com.baidu.tieba.enterForum.a.b diN;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.dgT = viewEventCenter;
    }

    public ForumEditView atT() {
        if (this.diM == null) {
            return null;
        }
        return this.diM.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.dgT);
        this.diM = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? h(this.diN.getDataList(), false) : this.diN.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.diN.R(h(dataList, true));
            } else {
                this.diN.R(dataList);
            }
        }
    }

    public void bh(List<f> list) {
        ForumEditView forumEditView;
        if (this.diM != null && list != null && (forumEditView = this.diM.get()) != null) {
            forumEditView.setColumnTypeAndRefeshView();
            bi(list);
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

    public void bi(List<f> list) {
        ForumEditView forumEditView = this.diM.get();
        if (forumEditView != null) {
            if (this.diN == null) {
                atU();
            }
            forumEditView.setGridAdapterIfNeeded(this.diN);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.diN.R(h(list, true));
            } else {
                this.diN.R(list);
            }
            this.diN.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void atU() {
        this.diN = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, e.h.home_like_item_in_edit_grid, this.dgT);
        this.diN.cH(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.diM.get() != null) {
                this.diM.get().onChangeSkinType(tbPageContext);
            }
            if (this.diN != null) {
                this.diN.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

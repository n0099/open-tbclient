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
    private ViewEventCenter dfO;
    private SoftReference<ForumEditView> dhH;
    private com.baidu.tieba.enterForum.a.b dhI;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.dfO = viewEventCenter;
    }

    public ForumEditView auu() {
        if (this.dhH == null) {
            return null;
        }
        return this.dhH.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.dfO);
        this.dhH = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? h(this.dhI.getDataList(), false) : this.dhI.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dhI.S(h(dataList, true));
            } else {
                this.dhI.S(dataList);
            }
        }
    }

    public void bj(List<f> list) {
        ForumEditView forumEditView;
        if (this.dhH != null && list != null && (forumEditView = this.dhH.get()) != null) {
            forumEditView.setColumnTypeAndRefeshView();
            bk(list);
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

    public void bk(List<f> list) {
        ForumEditView forumEditView = this.dhH.get();
        if (forumEditView != null) {
            if (this.dhI == null) {
                auv();
            }
            forumEditView.setGridAdapterIfNeeded(this.dhI);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dhI.S(h(list, true));
            } else {
                this.dhI.S(list);
            }
            this.dhI.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void auv() {
        this.dhI = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, e.h.home_like_item_in_edit_grid, this.dfO);
        this.dhI.cq(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.dhH.get() != null) {
                this.dhH.get().onChangeSkinType(tbPageContext);
            }
            if (this.dhI != null) {
                this.dhI.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

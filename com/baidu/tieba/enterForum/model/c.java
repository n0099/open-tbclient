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
/* loaded from: classes2.dex */
public class c {
    private ViewEventCenter cXw;
    private SoftReference<ForumEditView> cZs;
    private com.baidu.tieba.enterForum.a.b cZt;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.cXw = viewEventCenter;
    }

    public ForumEditView aqY() {
        if (this.cZs == null) {
            return null;
        }
        return this.cZs.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.cXw);
        this.cZs = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? g(this.cZt.getDataList(), false) : this.cZt.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cZt.J(g(dataList, true));
            } else {
                this.cZt.J(dataList);
            }
        }
    }

    public void aT(List<f> list) {
        ForumEditView forumEditView;
        if (this.cZs != null && list != null && (forumEditView = this.cZs.get()) != null) {
            forumEditView.setColumnTypeAndRefeshView();
            aU(list);
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

    public void aU(List<f> list) {
        ForumEditView forumEditView = this.cZs.get();
        if (forumEditView != null) {
            if (this.cZt == null) {
                aqZ();
            }
            forumEditView.setGridAdapterIfNeeded(this.cZt);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cZt.J(g(list, true));
            } else {
                this.cZt.J(list);
            }
            this.cZt.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aqZ() {
        this.cZt = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, e.h.home_like_item_in_edit_grid, this.cXw);
        this.cZt.ch(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cZs.get() != null) {
                this.cZs.get().onChangeSkinType(tbPageContext);
            }
            if (this.cZt != null) {
                this.cZt.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

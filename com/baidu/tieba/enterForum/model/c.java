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
    private ViewEventCenter dnB;
    private SoftReference<ForumEditView> dpp;
    private com.baidu.tieba.enterForum.a.b dpq;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.dnB = viewEventCenter;
    }

    public ForumEditView avE() {
        if (this.dpp == null) {
            return null;
        }
        return this.dpp.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.dnB);
        this.dpp = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? h(this.dpq.getDataList(), false) : this.dpq.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dpq.R(h(dataList, true));
            } else {
                this.dpq.R(dataList);
            }
        }
    }

    public void bj(List<f> list) {
        ForumEditView forumEditView;
        if (this.dpp != null && list != null && (forumEditView = this.dpp.get()) != null) {
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
        ForumEditView forumEditView = this.dpp.get();
        if (forumEditView != null) {
            if (this.dpq == null) {
                avF();
            }
            forumEditView.setGridAdapterIfNeeded(this.dpq);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dpq.R(h(list, true));
            } else {
                this.dpq.R(list);
            }
            this.dpq.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void avF() {
        this.dpq = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, e.h.home_like_item_in_edit_grid, this.dnB);
        this.dpq.cI(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.dpp.get() != null) {
                this.dpp.get().onChangeSkinType(tbPageContext);
            }
            if (this.dpq != null) {
                this.dpq.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

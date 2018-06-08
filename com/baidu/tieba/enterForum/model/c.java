package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.view.ForumEditView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private ViewEventCenter cRe;
    private SoftReference<ForumEditView> cSU;
    private com.baidu.tieba.enterForum.a.b cSV;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.cRe = viewEventCenter;
    }

    public ForumEditView app() {
        if (this.cSU == null) {
            return null;
        }
        return this.cSU.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.cRe);
        this.cSU = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.cSV.getDataList(), false) : this.cSV.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cSV.I(f(dataList, true));
            } else {
                this.cSV.I(dataList);
            }
        }
    }

    public void aS(List<f> list) {
        ForumEditView forumEditView;
        if (this.cSU != null && list != null && (forumEditView = this.cSU.get()) != null) {
            forumEditView.setColumnTypeAndRefeshView();
            aT(list);
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

    public void aT(List<f> list) {
        ForumEditView forumEditView = this.cSU.get();
        if (forumEditView != null) {
            if (this.cSV == null) {
                apq();
            }
            forumEditView.setGridAdapterIfNeeded(this.cSV);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cSV.I(f(list, true));
            } else {
                this.cSV.I(list);
            }
            this.cSV.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void apq() {
        this.cSV = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, d.i.home_like_item_in_edit_grid, this.cRe);
        this.cSV.bT(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cSU.get() != null) {
                this.cSU.get().onChangeSkinType(tbPageContext);
            }
            if (this.cSV != null) {
                this.cSV.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.view.ForumEditView;
import com.baidu.tieba.f;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private ViewEventCenter cRF;
    private SoftReference<ForumEditView> cTB;
    private com.baidu.tieba.enterForum.a.b cTC;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.cRF = viewEventCenter;
    }

    public ForumEditView apk() {
        if (this.cTB == null) {
            return null;
        }
        return this.cTB.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.cRF);
        this.cTB = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.cTC.getDataList(), false) : this.cTC.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cTC.I(f(dataList, true));
            } else {
                this.cTC.I(dataList);
            }
        }
    }

    public void aS(List<f> list) {
        ForumEditView forumEditView;
        if (this.cTB != null && list != null && (forumEditView = this.cTB.get()) != null) {
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
        ForumEditView forumEditView = this.cTB.get();
        if (forumEditView != null) {
            if (this.cTC == null) {
                apl();
            }
            forumEditView.setGridAdapterIfNeeded(this.cTC);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cTC.I(f(list, true));
            } else {
                this.cTC.I(list);
            }
            this.cTC.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void apl() {
        this.cTC = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, f.h.home_like_item_in_edit_grid, this.cRF);
        this.cTC.bV(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cTB.get() != null) {
                this.cTB.get().onChangeSkinType(tbPageContext);
            }
            if (this.cTC != null) {
                this.cTC.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

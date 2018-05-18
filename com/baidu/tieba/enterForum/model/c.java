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
    private ViewEventCenter cHX;
    private SoftReference<ForumEditView> cJO;
    private com.baidu.tieba.enterForum.a.b cJP;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.cHX = viewEventCenter;
    }

    public ForumEditView alj() {
        if (this.cJO == null) {
            return null;
        }
        return this.cJO.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.cHX);
        this.cJO = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.cJP.getDataList(), false) : this.cJP.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cJP.F(f(dataList, true));
            } else {
                this.cJP.F(dataList);
            }
        }
    }

    public void aP(List<f> list) {
        ForumEditView forumEditView;
        if (this.cJO != null && list != null && (forumEditView = this.cJO.get()) != null) {
            forumEditView.setColumnTypeAndRefeshView();
            aQ(list);
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

    public void aQ(List<f> list) {
        ForumEditView forumEditView = this.cJO.get();
        if (forumEditView != null) {
            if (this.cJP == null) {
                alk();
            }
            forumEditView.setGridAdapterIfNeeded(this.cJP);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cJP.F(f(list, true));
            } else {
                this.cJP.F(list);
            }
            this.cJP.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void alk() {
        this.cJP = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, d.i.home_like_item_in_edit_grid, this.cHX);
        this.cJP.bP(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cJO.get() != null) {
                this.cJO.get().onChangeSkinType(tbPageContext);
            }
            if (this.cJP != null) {
                this.cJP.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

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
    private ViewEventCenter cOZ;
    private SoftReference<ForumEditView> cQS;
    private com.baidu.tieba.enterForum.a.b cQT;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.cOZ = viewEventCenter;
    }

    public ForumEditView aoJ() {
        if (this.cQS == null) {
            return null;
        }
        return this.cQS.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.cOZ);
        this.cQS = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.cQT.getDataList(), false) : this.cQT.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cQT.J(f(dataList, true));
            } else {
                this.cQT.J(dataList);
            }
        }
    }

    public void aT(List<f> list) {
        ForumEditView forumEditView;
        if (this.cQS != null && list != null && (forumEditView = this.cQS.get()) != null) {
            forumEditView.setColumnTypeAndRefeshView();
            aU(list);
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

    public void aU(List<f> list) {
        ForumEditView forumEditView = this.cQS.get();
        if (forumEditView != null) {
            if (this.cQT == null) {
                aoK();
            }
            forumEditView.setGridAdapterIfNeeded(this.cQT);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cQT.J(f(list, true));
            } else {
                this.cQT.J(list);
            }
            this.cQT.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aoK() {
        this.cQT = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, d.i.home_like_item_in_edit_grid, this.cOZ);
        this.cQT.bW(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cQS.get() != null) {
                this.cQS.get().onChangeSkinType(tbPageContext);
            }
            if (this.cQT != null) {
                this.cQT.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

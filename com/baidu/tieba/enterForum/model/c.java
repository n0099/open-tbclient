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
    private ViewEventCenter dqs;
    private SoftReference<ForumEditView> dsf;
    private com.baidu.tieba.enterForum.a.b dsg;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.dqs = viewEventCenter;
    }

    public ForumEditView awt() {
        if (this.dsf == null) {
            return null;
        }
        return this.dsf.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.dqs);
        this.dsf = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? h(this.dsg.getDataList(), false) : this.dsg.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dsg.R(h(dataList, true));
            } else {
                this.dsg.R(dataList);
            }
        }
    }

    public void bk(List<f> list) {
        ForumEditView forumEditView;
        if (this.dsf != null && list != null && (forumEditView = this.dsf.get()) != null) {
            forumEditView.setColumnTypeAndRefeshView();
            bl(list);
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

    public void bl(List<f> list) {
        ForumEditView forumEditView = this.dsf.get();
        if (forumEditView != null) {
            if (this.dsg == null) {
                awu();
            }
            forumEditView.setGridAdapterIfNeeded(this.dsg);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.dsg.R(h(list, true));
            } else {
                this.dsg.R(list);
            }
            this.dsg.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void awu() {
        this.dsg = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, e.h.home_like_item_in_edit_grid, this.dqs);
        this.dsg.cI(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.dsf.get() != null) {
                this.dsf.get().onChangeSkinType(tbPageContext);
            }
            if (this.dsg != null) {
                this.dsg.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

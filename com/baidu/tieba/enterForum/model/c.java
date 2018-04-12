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
    private TbPageContext<?> adf;
    private ViewEventCenter cGR;
    private SoftReference<ForumEditView> cII;
    private com.baidu.tieba.enterForum.a.b cIJ;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.adf = tbPageContext;
        this.cGR = viewEventCenter;
    }

    public ForumEditView alj() {
        if (this.cII == null) {
            return null;
        }
        return this.cII.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.adf.getPageActivity());
        forumEditView.setEventCenter(this.cGR);
        this.cII = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.cIJ.getDataList(), false) : this.cIJ.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cIJ.F(f(dataList, true));
            } else {
                this.cIJ.F(dataList);
            }
        }
    }

    public void aM(List<f> list) {
        ForumEditView forumEditView;
        if (this.cII != null && list != null && (forumEditView = this.cII.get()) != null) {
            forumEditView.setColumnTypeAndRefeshView();
            aN(list);
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

    public void aN(List<f> list) {
        ForumEditView forumEditView = this.cII.get();
        if (forumEditView != null) {
            if (this.cIJ == null) {
                alk();
            }
            forumEditView.setGridAdapterIfNeeded(this.cIJ);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cIJ.F(f(list, true));
            } else {
                this.cIJ.F(list);
            }
            this.cIJ.b(this.adf, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void alk() {
        this.cIJ = new com.baidu.tieba.enterForum.a.b(this.adf, com.baidu.tieba.enterForum.view.c.class, d.i.home_like_item_in_edit_grid, this.cGR);
        this.cIJ.bP(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cII.get() != null) {
                this.cII.get().onChangeSkinType(tbPageContext);
            }
            if (this.cIJ != null) {
                this.cIJ.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

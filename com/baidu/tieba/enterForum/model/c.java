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
    private ViewEventCenter cGO;
    private SoftReference<ForumEditView> cIF;
    private com.baidu.tieba.enterForum.a.b cIG;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.adf = tbPageContext;
        this.cGO = viewEventCenter;
    }

    public ForumEditView alj() {
        if (this.cIF == null) {
            return null;
        }
        return this.cIF.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.adf.getPageActivity());
        forumEditView.setEventCenter(this.cGO);
        this.cIF = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.cIG.getDataList(), false) : this.cIG.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cIG.F(f(dataList, true));
            } else {
                this.cIG.F(dataList);
            }
        }
    }

    public void aM(List<f> list) {
        ForumEditView forumEditView;
        if (this.cIF != null && list != null && (forumEditView = this.cIF.get()) != null) {
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
        ForumEditView forumEditView = this.cIF.get();
        if (forumEditView != null) {
            if (this.cIG == null) {
                alk();
            }
            forumEditView.setGridAdapterIfNeeded(this.cIG);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cIG.F(f(list, true));
            } else {
                this.cIG.F(list);
            }
            this.cIG.b(this.adf, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void alk() {
        this.cIG = new com.baidu.tieba.enterForum.a.b(this.adf, com.baidu.tieba.enterForum.view.c.class, d.i.home_like_item_in_edit_grid, this.cGO);
        this.cIG.bP(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cIF.get() != null) {
                this.cIF.get().onChangeSkinType(tbPageContext);
            }
            if (this.cIG != null) {
                this.cIG.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

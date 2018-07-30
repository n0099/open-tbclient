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
    private ViewEventCenter cRI;
    private SoftReference<ForumEditView> cTF;
    private com.baidu.tieba.enterForum.a.b cTG;
    private TbPageContext<?> mContext;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.mContext = tbPageContext;
        this.cRI = viewEventCenter;
    }

    public ForumEditView apk() {
        if (this.cTF == null) {
            return null;
        }
        return this.cTF.get();
    }

    public void createView() {
        ForumEditView forumEditView = new ForumEditView(this.mContext.getPageActivity());
        forumEditView.setEventCenter(this.cRI);
        this.cTF = new SoftReference<>(forumEditView);
    }

    public List<f> getDataList() {
        return TbadkCoreApplication.getInst().getSkinType() != 2 ? f(this.cTG.getDataList(), false) : this.cTG.getDataList();
    }

    public void b(f fVar) {
        List<f> dataList = getDataList();
        if (dataList != null) {
            dataList.remove(fVar);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cTG.I(f(dataList, true));
            } else {
                this.cTG.I(dataList);
            }
        }
    }

    public void aS(List<f> list) {
        ForumEditView forumEditView;
        if (this.cTF != null && list != null && (forumEditView = this.cTF.get()) != null) {
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
        ForumEditView forumEditView = this.cTF.get();
        if (forumEditView != null) {
            if (this.cTG == null) {
                apl();
            }
            forumEditView.setGridAdapterIfNeeded(this.cTG);
            if (TbadkCoreApplication.getInst().getSkinType() != 2) {
                this.cTG.I(f(list, true));
            } else {
                this.cTG.I(list);
            }
            this.cTG.b(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void apl() {
        this.cTG = new com.baidu.tieba.enterForum.a.b(this.mContext, com.baidu.tieba.enterForum.view.c.class, d.h.home_like_item_in_edit_grid, this.cRI);
        this.cTG.bU(false);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (this.cTF.get() != null) {
                this.cTF.get().onChangeSkinType(tbPageContext);
            }
            if (this.cTG != null) {
                this.cTG.b(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

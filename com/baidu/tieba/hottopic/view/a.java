package com.baidu.tieba.hottopic.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.baidu.tieba.card.c<n> {
    private List<com.baidu.adp.widget.ListView.n> dataList;
    private RelateForumHorizonalListView kwB;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.kwB = new RelateForumHorizonalListView(getContext());
        this.dataList = new ArrayList();
        this.kwB.setTag(getTag());
        this.kwB.setLoadMoreClickListener(this);
        this.iuQ.addView(this.kwB);
        this.iuI.setOnClickListener(this);
        wW(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
        pt(false);
    }

    @Override // com.baidu.tieba.card.b
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
        if (this.kwB != null) {
            this.kwB.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
        this.kwB.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.kwB != null) {
            this.kwB.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(n nVar) {
        super.a((a) nVar);
        if (nVar == null) {
            getView().setVisibility(8);
            return;
        }
        this.dataList.clear();
        if (nVar.kvt != null) {
            this.dataList.addAll(nVar.kvt);
        }
        List<com.baidu.tbadk.widget.horizonalScrollListView.a> el = el(this.dataList);
        int count = y.getCount(el);
        if (count <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        if (count > 10) {
            this.kwB.setData(el.subList(0, 10), getTbPageContext(), true);
        } else {
            this.kwB.setData(el, getTbPageContext(), false);
        }
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private List<com.baidu.tbadk.widget.horizonalScrollListView.a> el(List<com.baidu.adp.widget.ListView.n> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.baidu.adp.widget.ListView.n nVar : list) {
            if (nVar instanceof RelateForumItemData) {
                long j = ((RelateForumItemData) nVar).forumId;
                String str = ((RelateForumItemData) nVar).forumName;
                String str2 = ((RelateForumItemData) nVar).forumAvatar;
                boolean z = ((RelateForumItemData) nVar).isLiked;
                if (j >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.baidu.tbadk.widget.horizonalScrollListView.a aVar = new com.baidu.tbadk.widget.horizonalScrollListView.a();
                    aVar.forumAvatar = str2;
                    aVar.forumId = j;
                    aVar.forumName = str;
                    aVar.isLiked = z;
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.card.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.kwB != null && this.kwB.getLastItemView() == view && this.dataList != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelateTopicForumActivityConfig(this.mPageContext.getPageActivity(), this.dataList, ((HotTopicActivity) this.mPageContext.getOrignalPage()).cSZ())));
        }
    }
}

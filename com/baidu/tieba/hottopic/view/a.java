package com.baidu.tieba.hottopic.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.c<n> {
    private List<q> dataList;
    private RelateForumHorizonalListView jRj;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.jRj = new RelateForumHorizonalListView(getContext());
        this.dataList = new ArrayList();
        this.jRj.setTag(getTag());
        this.jRj.setLoadMoreClickListener(this);
        this.hVL.addView(this.jRj);
        this.hVD.setOnClickListener(this);
        xb(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
        oq(false);
    }

    @Override // com.baidu.tieba.card.b
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
        if (this.jRj != null) {
            this.jRj.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
        this.jRj.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.jRj != null) {
            this.jRj.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(n nVar) {
        super.a((a) nVar);
        if (nVar == null) {
            getView().setVisibility(8);
            return;
        }
        this.dataList.clear();
        if (nVar.jQb != null) {
            this.dataList.addAll(nVar.jQb);
        }
        List<com.baidu.tbadk.widget.horizonalScrollListView.a> dV = dV(this.dataList);
        int count = y.getCount(dV);
        if (count <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        if (count > 10) {
            this.jRj.setData(dV.subList(0, 10), getTbPageContext(), true);
        } else {
            this.jRj.setData(dV, getTbPageContext(), false);
        }
        onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private List<com.baidu.tbadk.widget.horizonalScrollListView.a> dV(List<q> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (q qVar : list) {
            if (qVar instanceof RelateForumItemData) {
                long j = ((RelateForumItemData) qVar).forumId;
                String str = ((RelateForumItemData) qVar).forumName;
                String str2 = ((RelateForumItemData) qVar).forumAvatar;
                boolean z = ((RelateForumItemData) qVar).isLiked;
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
        if (this.jRj != null && this.jRj.getLastItemView() == view && this.dataList != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelateTopicForumActivityConfig(this.mPageContext.getPageActivity(), this.dataList, ((HotTopicActivity) this.mPageContext.getOrignalPage()).cMI())));
        }
    }
}

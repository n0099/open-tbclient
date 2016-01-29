package com.baidu.tieba.hottopic.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.hottopic.data.m> {
    private TbPageContext<?> Nw;
    private List<u> azm;
    private j bMB;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Nw = tbPageContext;
        this.bMB = new j(getContext());
        this.azm = new ArrayList();
        this.bMB.setTag(getTag());
        this.bMB.setLoadMoreClickListener(this);
        this.aOI.addView(this.bMB);
        this.aOA.setOnClickListener(this);
        fw(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1));
        bP(false);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
        if (this.bMB != null) {
            this.bMB.setTag(getTag());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
        this.bMB.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bMB != null) {
            this.bMB.db(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.hottopic.data.m mVar) {
        super.a((a) mVar);
        if (mVar == null) {
            getView().setVisibility(8);
            return;
        }
        this.azm.clear();
        if (mVar.bLE != null) {
            this.azm.addAll(mVar.bLE);
        }
        List<com.baidu.tbadk.widget.a.g> aN = aN(this.azm);
        int o = x.o(aN);
        if (o <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        if (o > 10) {
            this.bMB.a(aN.subList(0, 10), JK(), true);
        } else {
            this.bMB.a(aN, JK(), false);
        }
        d(JK(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private List<com.baidu.tbadk.widget.a.g> aN(List<u> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (u uVar : list) {
            if (uVar instanceof RelateForumItemData) {
                long j = ((RelateForumItemData) uVar).forumId;
                String str = ((RelateForumItemData) uVar).forumName;
                String str2 = ((RelateForumItemData) uVar).forumAvatar;
                boolean z = ((RelateForumItemData) uVar).isLiked;
                if (j >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    com.baidu.tbadk.widget.a.g gVar = new com.baidu.tbadk.widget.a.g();
                    gVar.forumAvatar = str2;
                    gVar.forumId = j;
                    gVar.forumName = str;
                    gVar.isLiked = z;
                    arrayList.add(gVar);
                }
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.bMB != null && this.bMB.getLastItemView() == view && this.azm != null) {
            this.Nw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelateTopicForumActivityConfig(this.Nw.getPageActivity(), this.azm)));
        }
    }
}

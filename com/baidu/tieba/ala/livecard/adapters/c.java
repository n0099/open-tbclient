package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaEmptyLiveViewHolder;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.k;
/* loaded from: classes9.dex */
public class c extends k<bz, FrsPageAlaEmptyLiveViewHolder> implements y {
    private com.baidu.tieba.ala.livecard.a.b hiB;
    private aa<bz> hiC;
    private String mForumName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hiC = new aa<bz>() { // from class: com.baidu.tieba.ala.livecard.adapters.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_LIVE_START, Integer.valueOf(bzVar.getThreadType())));
                }
            }
        };
    }

    @Override // com.baidu.tieba.frs.k
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.a(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public FrsPageAlaEmptyLiveViewHolder e(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hiB = new com.baidu.tieba.ala.livecard.a.b(this.mPageContext);
        this.hiB.o(this.mPageId);
        this.hiB.setForumName(this.mForumName);
        return new FrsPageAlaEmptyLiveViewHolder(this.hiB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bz bzVar, FrsPageAlaEmptyLiveViewHolder frsPageAlaEmptyLiveViewHolder) {
        frsPageAlaEmptyLiveViewHolder.hiO.a(bzVar);
        frsPageAlaEmptyLiveViewHolder.hiO.setForumName(this.mForumName);
        frsPageAlaEmptyLiveViewHolder.hiO.c(this.hiC);
        if (bzVar != null) {
            bzVar.boL();
        }
        return frsPageAlaEmptyLiveViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
    }
}

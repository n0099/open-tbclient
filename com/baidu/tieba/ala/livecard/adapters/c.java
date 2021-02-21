package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaEmptyLiveViewHolder;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
/* loaded from: classes10.dex */
public class c extends k<cb, FrsPageAlaEmptyLiveViewHolder> implements z {
    private com.baidu.tieba.ala.livecard.a.b hnc;
    private ab<cb> hnd;
    private String mForumName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hnd = new ab<cb>() { // from class: com.baidu.tieba.ala.livecard.adapters.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_LIVE_START, Integer.valueOf(cbVar.getThreadType())));
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
        this.hnc = new com.baidu.tieba.ala.livecard.a.b(this.mPageContext);
        this.hnc.o(this.mPageId);
        this.hnc.setForumName(this.mForumName);
        return new FrsPageAlaEmptyLiveViewHolder(this.hnc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, FrsPageAlaEmptyLiveViewHolder frsPageAlaEmptyLiveViewHolder) {
        frsPageAlaEmptyLiveViewHolder.hnp.a(cbVar);
        frsPageAlaEmptyLiveViewHolder.hnp.setForumName(this.mForumName);
        frsPageAlaEmptyLiveViewHolder.hnp.c(this.hnd);
        if (cbVar != null) {
            cbVar.bpd();
        }
        return frsPageAlaEmptyLiveViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
    }
}

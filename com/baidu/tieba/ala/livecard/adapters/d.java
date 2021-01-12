package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaStageViewHolder;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes9.dex */
public class d extends k<h, FrsPageAlaStageViewHolder> implements y {
    private com.baidu.tieba.ala.livecard.a.d hiI;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public FrsPageAlaStageViewHolder e(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hiI = new com.baidu.tieba.ala.livecard.a.d(this.mPageContext);
        this.hiI.setForumName(this.mForumName);
        return new FrsPageAlaStageViewHolder(this.hiI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, FrsPageAlaStageViewHolder frsPageAlaStageViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (h) frsPageAlaStageViewHolder);
        if (hVar != null) {
            int i2 = 0;
            if (this.jaa != null) {
                i2 = this.jaa.getTopThreadSize();
            }
            frsPageAlaStageViewHolder.hiQ.eMg = (i + 1) - i2;
            frsPageAlaStageViewHolder.hiQ.setForumName(this.mForumName);
            frsPageAlaStageViewHolder.hiQ.a(hVar);
        }
        return view;
    }
}

package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaStageViewHolder;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes10.dex */
public class d extends k<h, FrsPageAlaStageViewHolder> implements z {
    private com.baidu.tieba.ala.livecard.a.d hnj;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public FrsPageAlaStageViewHolder e(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hnj = new com.baidu.tieba.ala.livecard.a.d(this.mPageContext);
        this.hnj.setForumName(this.mForumName);
        return new FrsPageAlaStageViewHolder(this.hnj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, FrsPageAlaStageViewHolder frsPageAlaStageViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (h) frsPageAlaStageViewHolder);
        if (hVar != null) {
            int i2 = 0;
            if (this.jfU != null) {
                i2 = this.jfU.getTopThreadSize();
            }
            frsPageAlaStageViewHolder.hnr.eOs = (i + 1) - i2;
            frsPageAlaStageViewHolder.hnr.setForumName(this.mForumName);
            frsPageAlaStageViewHolder.hnr.a(hVar);
        }
        return view;
    }
}

package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaInsertRecLiveHolder;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.g;
/* loaded from: classes10.dex */
public class a extends k<g, FrsPageAlaInsertRecLiveHolder> implements z {
    private com.baidu.tieba.ala.livecard.a.a hmX;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.mForumName = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: az */
    public FrsPageAlaInsertRecLiveHolder e(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hmX = new com.baidu.tieba.ala.livecard.a.a(this.mPageContext);
        this.hmX.setForumName(this.mForumName);
        return new FrsPageAlaInsertRecLiveHolder(this.hmX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, FrsPageAlaInsertRecLiveHolder frsPageAlaInsertRecLiveHolder) {
        super.a(i, view, viewGroup, (ViewGroup) gVar, (g) frsPageAlaInsertRecLiveHolder);
        if (gVar != null) {
            int topThreadSize = this.jfU != null ? this.jfU.getTopThreadSize() : 0;
            if (gVar.nuI != null && gVar.nuI.get(0) != null) {
                gVar.nuI.get(0).eOs = (i + 1) - topThreadSize;
            }
            frsPageAlaInsertRecLiveHolder.hnq.setForumName(this.mForumName);
            frsPageAlaInsertRecLiveHolder.hnq.a(gVar);
        }
        return view;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
    }
}

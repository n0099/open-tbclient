package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.s;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaVideoHolder;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.k;
/* loaded from: classes10.dex */
public class f extends k<by, FrsPageAlaVideoHolder> implements com.baidu.tieba.a.f, y {
    private String aji;
    private aa<bz> hnl;
    private com.baidu.tieba.ala.livecard.a.e hnq;
    private String mForumName;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hnl = new aa<bz>() { // from class: com.baidu.tieba.ala.livecard.adapters.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && f.this.mPageContext != null) {
                    customMessage.setData(bzVar);
                    f.this.mPageContext.sendMessage(customMessage);
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
    /* renamed from: aD */
    public FrsPageAlaVideoHolder e(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hnq = new com.baidu.tieba.ala.livecard.a.e(this.mPageContext, this.mPageId);
        this.hnq.o(this.mPageId);
        this.hnq.setForumName(this.mForumName);
        this.hnq.c(this.hnl);
        return new FrsPageAlaVideoHolder(this.hnq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, FrsPageAlaVideoHolder frsPageAlaVideoHolder) {
        TiebaStatic.log("c11842");
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.jeH != null) {
            i2 = this.jeH.getTopThreadSize();
        }
        byVar.eMv.eQR = (i + 1) - i2;
        customMessage.setData(byVar.eMv);
        this.mPageContext.sendMessage(customMessage);
        if (byVar != null) {
            if (frsPageAlaVideoHolder.hnE instanceof com.baidu.tieba.a.e) {
                frsPageAlaVideoHolder.hnE.setPage(this.aji);
            }
            frsPageAlaVideoHolder.hnE.setForumName(this.mForumName);
            frsPageAlaVideoHolder.hnE.nA(cEN());
            frsPageAlaVideoHolder.hnE.a(byVar.eMv);
            byVar.eMv.bsF();
        }
        this.iKI = (s) viewGroup;
        return frsPageAlaVideoHolder.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void Fl(String str) {
        this.aji = str;
    }
}

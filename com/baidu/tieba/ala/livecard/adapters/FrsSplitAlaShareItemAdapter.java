package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
/* loaded from: classes10.dex */
public class FrsSplitAlaShareItemAdapter extends k<by, FrsPageAlaShareHolder> implements com.baidu.tieba.a.f, y {
    private String aji;
    private com.baidu.tieba.ala.livecard.a.c hnk;
    private aa<bz> hnl;
    private String mForumName;

    public FrsSplitAlaShareItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hnl = new aa<bz>() { // from class: com.baidu.tieba.ala.livecard.adapters.FrsSplitAlaShareItemAdapter.1
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
                if (customMessage != null && FrsSplitAlaShareItemAdapter.this.mPageContext != null) {
                    customMessage.setData(bzVar);
                    FrsSplitAlaShareItemAdapter.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public FrsPageAlaShareHolder e(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hnk = new com.baidu.tieba.ala.livecard.a.c(this.mPageContext, this.mPageId);
        this.hnk.o(this.mPageId);
        this.hnk.setForumName(this.mForumName);
        this.hnk.c(this.hnl);
        return new FrsPageAlaShareHolder(this.hnk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.jeH != null) {
            i2 = this.jeH.getTopThreadSize();
        }
        byVar.eMv.eQR = (byVar.position + 1) - i2;
        customMessage.setData(byVar.eMv);
        this.mPageContext.sendMessage(customMessage);
        if (byVar != null) {
            if (frsPageAlaShareHolder.hnn instanceof com.baidu.tieba.a.e) {
                frsPageAlaShareHolder.hnn.setPage(this.aji);
            }
            frsPageAlaShareHolder.hnn.setForumName(this.mForumName);
            j.a(frsPageAlaShareHolder.hnn.cbJ(), this.jeH);
            j.a(frsPageAlaShareHolder.hnn.cbK(), this.jeH);
            frsPageAlaShareHolder.hnn.a(byVar.eMv);
            byVar.eMv.bsE();
        }
        return frsPageAlaShareHolder.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }

    /* loaded from: classes10.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.ala.livecard.a.c hnn;

        public FrsPageAlaShareHolder(com.baidu.tieba.ala.livecard.a.c cVar) {
            super(cVar.getView());
            this.hnn = cVar;
        }
    }
}

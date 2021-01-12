package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
/* loaded from: classes9.dex */
public class FrsAlaShareItemAdapter extends k<bz, FrsPageAlaShareHolder> implements com.baidu.tieba.a.f, y {
    private String air;
    private com.baidu.tieba.ala.livecard.a.c hiE;
    private aa<bz> hiF;
    private String mForumName;

    public FrsAlaShareItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hiF = new aa<bz>() { // from class: com.baidu.tieba.ala.livecard.adapters.FrsAlaShareItemAdapter.1
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
                if (customMessage != null && FrsAlaShareItemAdapter.this.mPageContext != null) {
                    customMessage.setData(bzVar);
                    FrsAlaShareItemAdapter.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public FrsPageAlaShareHolder e(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hiE = new com.baidu.tieba.ala.livecard.a.c(this.mPageContext, this.mPageId);
        this.hiE.o(this.mPageId);
        this.hiE.setForumName(this.mForumName);
        this.hiE.c(this.hiF);
        return new FrsPageAlaShareHolder(this.hiE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bz bzVar, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.jaa != null) {
            i2 = this.jaa.getTopThreadSize();
        }
        bzVar.eMg = (i + 1) - i2;
        customMessage.setData(bzVar);
        this.mPageContext.sendMessage(customMessage);
        if (bzVar != null) {
            if (frsPageAlaShareHolder.hiH instanceof com.baidu.tieba.a.e) {
                frsPageAlaShareHolder.hiH.setPage(this.air);
            }
            frsPageAlaShareHolder.hiH.setForumName(this.mForumName);
            j.a(frsPageAlaShareHolder.hiH.bXS(), this.jaa);
            j.a(frsPageAlaShareHolder.hiH.bXT(), this.jaa);
            frsPageAlaShareHolder.hiH.a(bzVar);
            bzVar.boL();
        }
        return frsPageAlaShareHolder.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    /* loaded from: classes9.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.ala.livecard.a.c hiH;

        public FrsPageAlaShareHolder(com.baidu.tieba.ala.livecard.a.c cVar) {
            super(cVar.getView());
            this.hiH = cVar;
        }
    }
}

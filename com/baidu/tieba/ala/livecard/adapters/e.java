package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.s;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaVideoHolder;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
/* loaded from: classes10.dex */
public class e extends k<cb, FrsPageAlaVideoHolder> implements com.baidu.tieba.a.f, z {
    private String aif;
    private ab<cb> hng;
    private com.baidu.tieba.ala.livecard.a.e hnl;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hng = new ab<cb>() { // from class: com.baidu.tieba.ala.livecard.adapters.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && e.this.mPageContext != null) {
                    customMessage.setData(cbVar);
                    e.this.mPageContext.sendMessage(customMessage);
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
        this.hnl = new com.baidu.tieba.ala.livecard.a.e(this.mPageContext, this.mPageId);
        this.hnl.o(this.mPageId);
        this.hnl.setForumName(this.mForumName);
        this.hnl.c(this.hng);
        return new FrsPageAlaVideoHolder(this.hnl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, FrsPageAlaVideoHolder frsPageAlaVideoHolder) {
        TiebaStatic.log("c11842");
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.jfU != null) {
            i2 = this.jfU.getTopThreadSize();
        }
        cbVar.eOs = (i + 1) - i2;
        customMessage.setData(cbVar);
        this.mPageContext.sendMessage(customMessage);
        if (cbVar != null) {
            if (frsPageAlaVideoHolder.hnz instanceof com.baidu.tieba.a.e) {
                frsPageAlaVideoHolder.hnz.setPage(this.aif);
            }
            frsPageAlaVideoHolder.hnz.setForumName(this.mForumName);
            frsPageAlaVideoHolder.hnz.nH(cCn());
            frsPageAlaVideoHolder.hnz.a(cbVar);
            cbVar.bpd();
        }
        this.iLY = (s) viewGroup;
        return frsPageAlaVideoHolder.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }
}

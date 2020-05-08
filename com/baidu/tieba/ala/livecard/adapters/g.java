package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.y;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import com.baidu.tieba.card.x;
import com.baidu.tieba.card.z;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.frs.h<bi, a> implements com.baidu.tieba.a.f, x {
    private String aeB;
    private com.baidu.tieba.ala.livecard.b.c fsh;
    private z<bj> fsi;
    private String mForumName;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fsi = new z<bj>() { // from class: com.baidu.tieba.ala.livecard.adapters.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && g.this.mPageContext != null) {
                    customMessage.setData(bjVar);
                    g.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public a b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fsh = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.fsh.setForumName(this.mForumName);
        this.fsh.c(this.fsi);
        return new a(this.fsh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.gXU != null) {
            i2 = this.gXU.getTopThreadSize();
        }
        biVar.dqE.dpd = (biVar.position + 1) - i2;
        customMessage.setData(biVar.dqE);
        this.mPageContext.sendMessage(customMessage);
        if (biVar != null) {
            if (aVar.fsk instanceof com.baidu.tieba.a.e) {
                aVar.fsk.setPage(this.aeB);
            }
            aVar.fsk.setForumName(this.mForumName);
            com.baidu.tieba.frs.g.a(aVar.fsk.bqu(), this.gXU);
            com.baidu.tieba.frs.g.a(aVar.fsk.bqv(), this.gXU);
            aVar.fsk.a(biVar.dqE);
            biVar.dqE.aLL();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }

    /* loaded from: classes3.dex */
    public static class a extends y.a {
        public com.baidu.tieba.ala.livecard.b.c fsk;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.fsk = cVar;
        }
    }
}

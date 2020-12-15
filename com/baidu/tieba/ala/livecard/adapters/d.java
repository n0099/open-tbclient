package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class d extends k<by, a> implements com.baidu.tieba.a.f, z {
    private String aiw;
    private com.baidu.tieba.ala.livecard.b.c hby;
    private ab<by> hbz;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hbz = new ab<by>() { // from class: com.baidu.tieba.ala.livecard.adapters.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && d.this.mPageContext != null) {
                    customMessage.setData(byVar);
                    d.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a c(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hby = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.hby.o(this.mPageId);
        this.hby.setForumName(this.mForumName);
        this.hby.c(this.hbz);
        return new a(this.hby);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.iSv != null) {
            i2 = this.iSv.getTopThreadSize();
        }
        byVar.eHa = (i + 1) - i2;
        customMessage.setData(byVar);
        this.mPageContext.sendMessage(customMessage);
        if (byVar != null) {
            if (aVar.hbB instanceof com.baidu.tieba.a.e) {
                aVar.hbB.setPage(this.aiw);
            }
            aVar.hbB.setForumName(this.mForumName);
            j.a(aVar.hbB.bZc(), this.iSv);
            j.a(aVar.hbB.bZd(), this.iSv);
            aVar.hbB.a(byVar);
            byVar.bqd();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    /* loaded from: classes6.dex */
    public static class a extends af.a {
        public com.baidu.tieba.ala.livecard.b.c hbB;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.hbB = cVar;
        }
    }
}

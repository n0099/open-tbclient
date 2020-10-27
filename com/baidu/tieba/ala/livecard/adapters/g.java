package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class g extends k<bv, a> implements com.baidu.tieba.a.f, z {
    private String ahu;
    private com.baidu.tieba.ala.livecard.b.c gMd;
    private ab<bw> gMe;
    private String mForumName;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gMe = new ab<bw>() { // from class: com.baidu.tieba.ala.livecard.adapters.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && g.this.mPageContext != null) {
                    customMessage.setData(bwVar);
                    g.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public a c(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.gMd = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.gMd.setForumName(this.mForumName);
        this.gMd.c(this.gMe);
        return new a(this.gMd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.iAQ != null) {
            i2 = this.iAQ.getTopThreadSize();
        }
        bvVar.erH.evR = (bvVar.position + 1) - i2;
        customMessage.setData(bvVar.erH);
        this.mPageContext.sendMessage(customMessage);
        if (bvVar != null) {
            if (aVar.gMg instanceof com.baidu.tieba.a.e) {
                aVar.gMg.setPage(this.ahu);
            }
            aVar.gMg.setForumName(this.mForumName);
            j.a(aVar.gMg.bTq(), this.iAQ);
            j.a(aVar.gMg.bTr(), this.iAQ);
            aVar.gMg.a(bvVar.erH);
            bvVar.erH.blm();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public com.baidu.tieba.ala.livecard.b.c gMg;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.gMg = cVar;
        }
    }
}

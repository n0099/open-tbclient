package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import com.baidu.tieba.card.x;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.h;
/* loaded from: classes2.dex */
public class e extends h<bi, a> implements com.baidu.tieba.a.f, x {
    private String La;
    private com.baidu.tieba.ala.livecard.b.c eHW;
    private z<bj> eHX;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.eHX = new z<bj>() { // from class: com.baidu.tieba.ala.livecard.adapters.e.1
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
                if (customMessage != null && e.this.mPageContext != null) {
                    customMessage.setData(bjVar);
                    e.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public a b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.eHW = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.eHW.setForumName(this.mForumName);
        this.eHW.c(this.eHX);
        return new a(this.eHW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.giA != null) {
            i2 = this.giA.getTopThreadSize();
        }
        biVar.cMR.cLr = (biVar.position + 1) - i2;
        customMessage.setData(biVar.cMR);
        this.mPageContext.sendMessage(customMessage);
        if (biVar != null) {
            if (aVar.eHZ instanceof com.baidu.tieba.a.e) {
                aVar.eHZ.setPage(this.La);
            }
            aVar.eHZ.setForumName(this.mForumName);
            g.a(aVar.eHZ.bes(), this.giA);
            g.a(aVar.eHZ.bet(), this.giA);
            aVar.eHZ.a(biVar.cMR);
            biVar.cMR.aAO();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pm(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void wq(String str) {
        this.La = str;
    }

    /* loaded from: classes2.dex */
    public static class a extends v.a {
        public com.baidu.tieba.ala.livecard.b.c eHZ;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.eHZ = cVar;
        }
    }
}

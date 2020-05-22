package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.frs.h<bk, a> implements com.baidu.tieba.a.f, y {
    private String aeX;
    private com.baidu.tieba.ala.livecard.b.c fFZ;
    private aa<bk> fGa;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fGa = new aa<bk>() { // from class: com.baidu.tieba.ala.livecard.adapters.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && d.this.mPageContext != null) {
                    customMessage.setData(bkVar);
                    d.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public a b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fFZ = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.fFZ.setForumName(this.mForumName);
        this.fFZ.c(this.fGa);
        return new a(this.fFZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.hmG != null) {
            i2 = this.hmG.getTopThreadSize();
        }
        bkVar.dDb = (i + 1) - i2;
        customMessage.setData(bkVar);
        this.mPageContext.sendMessage(customMessage);
        if (bkVar != null) {
            if (aVar.fGc instanceof com.baidu.tieba.a.e) {
                aVar.fGc.setPage(this.aeX);
            }
            aVar.fGc.setForumName(this.mForumName);
            com.baidu.tieba.frs.g.a(aVar.fGc.bwl(), this.hmG);
            com.baidu.tieba.frs.g.a(aVar.fGc.bwm(), this.hmG);
            aVar.fGc.a(bkVar);
            bkVar.aRK();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    /* loaded from: classes3.dex */
    public static class a extends aa.a {
        public com.baidu.tieba.ala.livecard.b.c fGc;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.fGc = cVar;
        }
    }
}

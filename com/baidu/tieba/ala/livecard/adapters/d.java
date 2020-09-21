package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class d extends k<bw, a> implements com.baidu.tieba.a.f, y {
    private String ahc;
    private com.baidu.tieba.ala.livecard.b.c glW;
    private aa<bw> glX;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.glX = new aa<bw>() { // from class: com.baidu.tieba.ala.livecard.adapters.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
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
                if (customMessage != null && d.this.mPageContext != null) {
                    customMessage.setData(bwVar);
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
        this.glW = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.glW.setForumName(this.mForumName);
        this.glW.c(this.glX);
        return new a(this.glW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.hZt != null) {
            i2 = this.hZt.getTopThreadSize();
        }
        bwVar.ebp = (i + 1) - i2;
        customMessage.setData(bwVar);
        this.mPageContext.sendMessage(customMessage);
        if (bwVar != null) {
            if (aVar.glZ instanceof com.baidu.tieba.a.e) {
                aVar.glZ.setPage(this.ahc);
            }
            aVar.glZ.setForumName(this.mForumName);
            j.a(aVar.glZ.bNc(), this.hZt);
            j.a(aVar.glZ.bNd(), this.hZt);
            aVar.glZ.a(bwVar);
            bwVar.bgK();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public com.baidu.tieba.ala.livecard.b.c glZ;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.glZ = cVar;
        }
    }
}

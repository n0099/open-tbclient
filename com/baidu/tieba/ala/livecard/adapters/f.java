package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.j;
/* loaded from: classes4.dex */
public class f extends j<bv, com.baidu.tieba.ala.livecard.a.e> implements com.baidu.tieba.a.f, y {
    private String afx;
    private aa<bv> fWN;
    private com.baidu.tieba.ala.livecard.b.e fWS;
    private String mForumName;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fWN = new aa<bv>() { // from class: com.baidu.tieba.ala.livecard.adapters.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && f.this.mPageContext != null) {
                    customMessage.setData(bvVar);
                    f.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    @Override // com.baidu.tieba.frs.j
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.a(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public com.baidu.tieba.ala.livecard.a.e b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fWS = new com.baidu.tieba.ala.livecard.b.e(this.mPageContext, this.mPageId);
        this.fWS.p(this.mPageId);
        this.fWS.setForumName(this.mForumName);
        this.fWS.c(this.fWN);
        return new com.baidu.tieba.ala.livecard.a.e(this.fWS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.tieba.ala.livecard.a.e eVar) {
        TiebaStatic.log("c11842");
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.hEX != null) {
            i2 = this.hEX.getTopThreadSize();
        }
        bvVar.dPI = (i + 1) - i2;
        customMessage.setData(bvVar);
        this.mPageContext.sendMessage(customMessage);
        if (bvVar != null) {
            if (eVar.fXg instanceof com.baidu.tieba.a.e) {
                eVar.fXg.setPage(this.afx);
            }
            eVar.fXg.setForumName(this.mForumName);
            eVar.fXg.kY(cbj());
            eVar.fXg.a(bvVar);
            bvVar.aXx();
        }
        this.hlu = (v) viewGroup;
        return eVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }
}

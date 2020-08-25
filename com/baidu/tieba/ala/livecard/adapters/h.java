package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class h extends k<bv, com.baidu.tieba.ala.livecard.a.e> implements com.baidu.tieba.a.f, y {
    private String agH;
    private aa<bw> giM;
    private com.baidu.tieba.ala.livecard.b.e giR;
    private String mForumName;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.giM = new aa<bw>() { // from class: com.baidu.tieba.ala.livecard.adapters.h.1
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
                if (customMessage != null && h.this.mPageContext != null) {
                    customMessage.setData(bwVar);
                    h.this.mPageContext.sendMessage(customMessage);
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
    /* renamed from: aq */
    public com.baidu.tieba.ala.livecard.a.e b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.giR = new com.baidu.tieba.ala.livecard.b.e(this.mPageContext, this.mPageId);
        this.giR.p(this.mPageId);
        this.giR.setForumName(this.mForumName);
        this.giR.c(this.giM);
        return new com.baidu.tieba.ala.livecard.a.e(this.giR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.tieba.ala.livecard.a.e eVar) {
        TiebaStatic.log("c11842");
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.hSn != null) {
            i2 = this.hSn.getTopThreadSize();
        }
        bvVar.dUS.dZb = (i + 1) - i2;
        customMessage.setData(bvVar.dUS);
        this.mPageContext.sendMessage(customMessage);
        if (bvVar != null) {
            if (eVar.gjf instanceof com.baidu.tieba.a.e) {
                eVar.gjf.setPage(this.agH);
            }
            eVar.gjf.setForumName(this.mForumName);
            eVar.gjf.ly(clF());
            eVar.gjf.a(bvVar.dUS);
            bvVar.dUS.bfQ();
        }
        this.hyl = (v) viewGroup;
        return eVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }
}

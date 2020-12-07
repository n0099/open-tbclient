package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class f extends k<by, com.baidu.tieba.ala.livecard.a.e> implements com.baidu.tieba.a.f, z {
    private String aiw;
    private com.baidu.tieba.ala.livecard.b.e hbC;
    private ab<by> hbx;
    private String mForumName;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hbx = new ab<by>() { // from class: com.baidu.tieba.ala.livecard.adapters.f.1
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
                if (customMessage != null && f.this.mPageContext != null) {
                    customMessage.setData(byVar);
                    f.this.mPageContext.sendMessage(customMessage);
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
    /* renamed from: ar */
    public com.baidu.tieba.ala.livecard.a.e c(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.hbC = new com.baidu.tieba.ala.livecard.b.e(this.mPageContext, this.mPageId);
        this.hbC.o(this.mPageId);
        this.hbC.setForumName(this.mForumName);
        this.hbC.c(this.hbx);
        return new com.baidu.tieba.ala.livecard.a.e(this.hbC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, com.baidu.tieba.ala.livecard.a.e eVar) {
        TiebaStatic.log("c11842");
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.iSt != null) {
            i2 = this.iSt.getTopThreadSize();
        }
        byVar.eHa = (i + 1) - i2;
        customMessage.setData(byVar);
        this.mPageContext.sendMessage(customMessage);
        if (byVar != null) {
            if (eVar.hbQ instanceof com.baidu.tieba.a.e) {
                eVar.hbQ.setPage(this.aiw);
            }
            eVar.hbQ.setForumName(this.mForumName);
            eVar.hbQ.nb(cBR());
            eVar.hbQ.a(byVar);
            byVar.bqd();
        }
        this.iyt = (v) viewGroup;
        return eVar.getView();
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
}

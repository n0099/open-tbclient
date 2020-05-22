package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
/* loaded from: classes3.dex */
public class f extends com.baidu.tieba.frs.h<bk, com.baidu.tieba.ala.livecard.a.e> implements com.baidu.tieba.a.f, y {
    private String aeX;
    private aa<bk> fGa;
    private com.baidu.tieba.ala.livecard.b.e fGf;
    private String mForumName;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fGa = new aa<bk>() { // from class: com.baidu.tieba.ala.livecard.adapters.f.1
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
                if (customMessage != null && f.this.mPageContext != null) {
                    customMessage.setData(bkVar);
                    f.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    @Override // com.baidu.tieba.frs.h
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.a(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public com.baidu.tieba.ala.livecard.a.e b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fGf = new com.baidu.tieba.ala.livecard.b.e(this.mPageContext, this.mPageId);
        this.fGf.o(this.mPageId);
        this.fGf.setForumName(this.mForumName);
        this.fGf.c(this.fGa);
        return new com.baidu.tieba.ala.livecard.a.e(this.fGf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, com.baidu.tieba.ala.livecard.a.e eVar) {
        TiebaStatic.log("c11842");
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.hmG != null) {
            i2 = this.hmG.getTopThreadSize();
        }
        bkVar.dDb = (i + 1) - i2;
        customMessage.setData(bkVar);
        this.mPageContext.sendMessage(customMessage);
        if (bkVar != null) {
            if (eVar.fGt instanceof com.baidu.tieba.a.e) {
                eVar.fGt.setPage(this.aeX);
            }
            eVar.fGt.setForumName(this.mForumName);
            eVar.fGt.kg(bUE());
            eVar.fGt.a(bkVar);
            bkVar.aRK();
        }
        this.gSQ = (t) viewGroup;
        return eVar.getView();
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
}

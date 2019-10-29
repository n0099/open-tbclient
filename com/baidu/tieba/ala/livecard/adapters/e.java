package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.h;
/* loaded from: classes6.dex */
public class e extends h<bg, a> implements com.baidu.tieba.a.f, z {
    private String GC;
    private com.baidu.tieba.ala.livecard.b.c dTg;
    private ab<bh> dTh;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dTh = new ab<bh>() { // from class: com.baidu.tieba.ala.livecard.adapters.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && e.this.mPageContext != null) {
                    customMessage.setData(bhVar);
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
        this.dTg = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.dTg.setForumName(this.mForumName);
        this.dTg.d(this.dTh);
        return new a(this.dTg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.fuR != null) {
            i2 = this.fuR.getTopThreadSize();
        }
        bgVar.cbq.cez = (bgVar.position + 1) - i2;
        customMessage.setData(bgVar.cbq);
        this.mPageContext.sendMessage(customMessage);
        if (bgVar != null) {
            if (aVar.dTj instanceof com.baidu.tieba.a.e) {
                aVar.dTj.setPage(this.GC);
            }
            aVar.dTj.setForumName(this.mForumName);
            g.a(aVar.dTj.aMP(), this.fuR);
            g.a(aVar.dTj.aMQ(), this.fuR);
            aVar.dTj.a(bgVar.cbq);
            bgVar.cbq.ajK();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public com.baidu.tieba.ala.livecard.b.c dTj;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.dTj = cVar;
        }
    }
}

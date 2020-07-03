package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.j;
/* loaded from: classes3.dex */
public class g extends j<bt, a> implements com.baidu.tieba.a.f, y {
    private String afG;
    private com.baidu.tieba.ala.livecard.b.c fRt;
    private aa<bu> fRu;
    private String mForumName;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fRu = new aa<bu>() { // from class: com.baidu.tieba.ala.livecard.adapters.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bu buVar) {
                CustomMessage customMessage = null;
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK);
                } else if (view.getId() == R.id.card_home_page_normal_thread_user_name || view.getId() == R.id.card_home_page_normal_thread_user_header) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK);
                } else if (view.getId() == R.id.video_container) {
                    customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK);
                }
                if (customMessage != null && g.this.mPageContext != null) {
                    customMessage.setData(buVar);
                    g.this.mPageContext.sendMessage(customMessage);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fRt = new com.baidu.tieba.ala.livecard.b.c(this.mPageContext, this.mPageId);
        this.fRt.setForumName(this.mForumName);
        this.fRt.c(this.fRu);
        return new a(this.fRt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, a aVar) {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW);
        int i2 = 0;
        if (this.hzi != null) {
            i2 = this.hzi.getTopThreadSize();
        }
        btVar.dLi.dJw = (btVar.position + 1) - i2;
        customMessage.setData(btVar.dLi);
        this.mPageContext.sendMessage(customMessage);
        if (btVar != null) {
            if (aVar.fRw instanceof com.baidu.tieba.a.e) {
                aVar.fRw.setPage(this.afG);
            }
            aVar.fRw.setForumName(this.mForumName);
            i.a(aVar.fRw.bzi(), this.hzi);
            i.a(aVar.fRw.bzj(), this.hzi);
            aVar.fRw.a(btVar.dLi);
            btVar.dLi.aTB();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    /* loaded from: classes3.dex */
    public static class a extends ad.a {
        public com.baidu.tieba.ala.livecard.b.c fRw;

        public a(com.baidu.tieba.ala.livecard.b.c cVar) {
            super(cVar.getView());
            this.fRw = cVar;
        }
    }
}

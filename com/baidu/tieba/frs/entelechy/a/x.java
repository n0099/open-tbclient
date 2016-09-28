package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.az;
import com.baidu.tieba.frs.entelechy.view.p;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.widget.ListView.a<bi, a> implements az, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private cd<bi> bVT;
    private p bWx;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVT = new y(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: D */
    public a a(ViewGroup viewGroup) {
        this.bWx = new p(this.GM);
        this.bWx.j(this.GM.getUniqueId());
        this.bWx.setForumName(this.forumName);
        return new a(this.bWx);
    }

    private com.baidu.tieba.play.ad i(bi biVar) {
        if (biVar == null) {
            return null;
        }
        com.baidu.tieba.play.ad adVar = new com.baidu.tieba.play.ad();
        adVar.mLocate = biVar.sG() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        adVar.aPG = cdl.cdd;
        adVar.aPH = biVar.getTid();
        biVar.sL();
        return adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        aVar.bWz.a(i(biVar));
        aVar.bWz.k(biVar);
        aVar.bWz.setOnSubCardOnClickListenner(this.bVT);
        com.baidu.tieba.frs.g.b.afl().a(cdl, biVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.forumName = str;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public p bWz;

        public a(p pVar) {
            super(pVar.getView());
            this.bWz = pVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean Jr() {
            if (this.bWz == null) {
                return false;
            }
            return this.bWz.Jr();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.bWz == null) {
                return false;
            }
            return this.bWz.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Js() {
            if (this.bWz != null) {
                this.bWz.Js();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.bWz != null) {
                this.bWz.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.bWz == null) {
                return null;
            }
            return this.bWz.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.bWz == null) {
                return null;
            }
            return this.bWz.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.bWz == null) {
                return 0;
            }
            return this.bWz.getCurrentPosition();
        }
    }
}

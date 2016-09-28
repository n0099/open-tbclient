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
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.widget.ListView.a<bi, a> implements az, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private cd<bi> bVT;
    private com.baidu.tieba.frs.entelechy.view.a bWE;
    private String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVT = new ae(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public a a(ViewGroup viewGroup) {
        this.bWE = new com.baidu.tieba.frs.entelechy.view.a(this.GM);
        this.bWE.j(this.GM.getUniqueId());
        this.bWE.setForumName(this.mForumName);
        return new a(this.bWE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, a aVar) {
        aVar.bWG.a(i(biVar));
        aVar.bWG.onBindDataToView(biVar);
        aVar.bWG.setForumName(this.mForumName);
        aVar.bWG.setOnSubCardOnClickListenner(this.bVT);
        com.baidu.tieba.frs.g.b.afl().a(cdl, biVar);
        if (biVar != null) {
            biVar.sL();
        }
        return aVar.getView();
    }

    private com.baidu.tieba.play.ad i(bi biVar) {
        if (biVar == null) {
            return null;
        }
        com.baidu.tieba.play.ad adVar = new com.baidu.tieba.play.ad();
        adVar.mLocate = biVar.sG() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        adVar.aPG = cdl.cdd;
        adVar.aPH = biVar.getTid();
        return adVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public com.baidu.tieba.frs.entelechy.view.a bWG;

        public a(com.baidu.tieba.frs.entelechy.view.a aVar) {
            super(aVar.getView());
            this.bWG = aVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean Jr() {
            if (this.bWG == null) {
                return false;
            }
            return this.bWG.Jr();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.bWG == null) {
                return false;
            }
            return this.bWG.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Js() {
            if (this.bWG != null) {
                this.bWG.Js();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.bWG != null) {
                this.bWG.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.bWG == null) {
                return null;
            }
            return this.bWG.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.bWG == null) {
                return null;
            }
            return this.bWG.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.bWG == null) {
                return 0;
            }
            return this.bWG.getCurrentPosition();
        }
    }
}

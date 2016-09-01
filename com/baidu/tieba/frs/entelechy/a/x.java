package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.entelechy.view.az;
import com.baidu.tieba.frs.entelechy.view.p;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.widget.ListView.a<bg, a> implements az, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private cf<bg> bVU;
    private p bWy;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVU = new y(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: D */
    public a a(ViewGroup viewGroup) {
        this.bWy = new p(this.GM);
        this.bWy.j(this.GM.getUniqueId());
        this.bWy.setForumName(this.forumName);
        return new a(this.bWy);
    }

    private TextureVideoView.c h(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        TextureVideoView.c cVar = new TextureVideoView.c();
        cVar.mLocate = bgVar.su() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        cVar.ahj = cdn.cdf;
        cVar.ahi = bgVar.getTid();
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, a aVar) {
        aVar.bWA.setVideoStatsData(h(bgVar));
        aVar.bWA.i(bgVar);
        aVar.bWA.setOnSubCardOnClickListenner(this.bVU);
        com.baidu.tieba.frs.g.b.aeX().a(cdn, bgVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.forumName = str;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public p bWA;

        public a(p pVar) {
            super(pVar.getView());
            this.bWA = pVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean KA() {
            if (this.bWA == null) {
                return false;
            }
            return this.bWA.KA();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.bWA == null) {
                return false;
            }
            return this.bWA.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Kz() {
            if (this.bWA != null) {
                this.bWA.Kz();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.bWA != null) {
                this.bWA.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.bWA == null) {
                return null;
            }
            return this.bWA.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.bWA == null) {
                return null;
            }
            return this.bWA.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.bWA == null) {
                return 0;
            }
            return this.bWA.getCurrentPosition();
        }
    }
}

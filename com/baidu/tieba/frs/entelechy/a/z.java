package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.frs.entelechy.view.aw;
import com.baidu.tieba.frs.entelechy.view.n;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.a<be, a> implements aw, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> EA;
    private bx<be> bKK;
    private n bLo;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKK = new aa(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public a a(ViewGroup viewGroup) {
        this.bLo = new n(this.EA);
        this.bLo.j(this.EA.getUniqueId());
        this.bLo.setForumName(this.forumName);
        return new a(this.bLo);
    }

    private TextureVideoView.c h(be beVar) {
        if (beVar == null) {
            return null;
        }
        TextureVideoView.c cVar = new TextureVideoView.c();
        cVar.mLocate = beVar.rp() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        cVar.aeq = bSh.bRZ;
        cVar.aep = beVar.getTid();
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, be beVar, a aVar) {
        aVar.bLq.setVideoStatsData(h(beVar));
        aVar.bLq.i(beVar);
        aVar.bLq.a(this.bKK);
        com.baidu.tieba.frs.h.b.aam().a(bSh, beVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aw
    public void setForumName(String str) {
        this.forumName = str;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public n bLq;

        public a(n nVar) {
            super(nVar.getView());
            this.bLq = nVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean IA() {
            if (this.bLq == null) {
                return false;
            }
            return this.bLq.IA();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.bLq == null) {
                return false;
            }
            return this.bLq.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Iz() {
            if (this.bLq != null) {
                this.bLq.Iz();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.bLq != null) {
                this.bLq.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.bLq == null) {
                return null;
            }
            return this.bLq.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.bLq == null) {
                return null;
            }
            return this.bLq.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.bLq == null) {
                return 0;
            }
            return this.bLq.getCurrentPosition();
        }
    }
}

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
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.widget.ListView.a<be, a> implements aw, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> EA;
    private bx<be> bKK;
    private com.baidu.tieba.frs.entelechy.view.a bLu;
    private String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKK = new ah(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public a a(ViewGroup viewGroup) {
        this.bLu = new com.baidu.tieba.frs.entelechy.view.a(this.EA);
        this.bLu.j(this.EA.getUniqueId());
        this.bLu.setForumName(this.mForumName);
        return new a(this.bLu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, be beVar, a aVar) {
        aVar.bLw.setVideoStatsData(h(beVar));
        aVar.bLw.i(beVar);
        aVar.bLw.setForumName(this.mForumName);
        aVar.bLw.a(this.bKK);
        com.baidu.tieba.frs.h.b.aam().a(bSh, beVar);
        return aVar.getView();
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

    @Override // com.baidu.tieba.frs.entelechy.view.aw
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public com.baidu.tieba.frs.entelechy.view.a bLw;

        public a(com.baidu.tieba.frs.entelechy.view.a aVar) {
            super(aVar.getView());
            this.bLw = aVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean IA() {
            if (this.bLw == null) {
                return false;
            }
            return this.bLw.IA();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.bLw == null) {
                return false;
            }
            return this.bLw.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Iz() {
            if (this.bLw != null) {
                this.bLw.Iz();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.bLw != null) {
                this.bLw.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.bLw == null) {
                return null;
            }
            return this.bLw.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.bLw == null) {
                return null;
            }
            return this.bLw.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.bLw == null) {
                return 0;
            }
            return this.bLw.getCurrentPosition();
        }
    }
}

package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.frs.entelechy.view.ba;
import com.baidu.tieba.frs.entelechy.view.p;
import com.baidu.tieba.play.ax;
import com.baidu.tieba.play.s;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.widget.ListView.a<bk, a> implements ba, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> GO;
    private p bZO;
    private bz<bk> bZe;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZe = new ac(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public a a(ViewGroup viewGroup) {
        this.bZO = new p(this.GO);
        this.bZO.j(this.GO.getUniqueId());
        this.bZO.setForumName(this.forumName);
        return new a(this.bZO);
    }

    private ax e(bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        ax axVar = new ax();
        axVar.mLocate = bkVar.sI() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        axVar.aRN = chm.che;
        axVar.aRO = bkVar.getTid();
        bkVar.sN();
        return axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, a aVar) {
        aVar.bZQ.a(e(bkVar));
        aVar.bZQ.j(bkVar);
        aVar.bZQ.setOnSubCardOnClickListenner(this.bZe);
        com.baidu.tieba.frs.h.b.agV().a(chm, bkVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ba
    public void setForumName(String str) {
        this.forumName = str;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements s {
        public p bZQ;

        public a(p pVar) {
            super(pVar.getView());
            this.bZQ = pVar;
        }

        @Override // com.baidu.tieba.play.s
        public boolean JS() {
            if (this.bZQ == null) {
                return false;
            }
            return this.bZQ.JS();
        }

        @Override // com.baidu.tieba.play.s
        public boolean isPlaying() {
            if (this.bZQ == null) {
                return false;
            }
            return this.bZQ.isPlaying();
        }

        @Override // com.baidu.tieba.play.s
        public void JT() {
            if (this.bZQ != null) {
                this.bZQ.JT();
            }
        }

        @Override // com.baidu.tieba.play.s
        public void stopPlay() {
            if (this.bZQ != null) {
                this.bZQ.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.s
        public View getVideoContainer() {
            if (this.bZQ == null) {
                return null;
            }
            return this.bZQ.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.s
        public String getPlayUrl() {
            if (this.bZQ == null) {
                return null;
            }
            return this.bZQ.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.s
        public int getCurrentPosition() {
            if (this.bZQ == null) {
                return 0;
            }
            return this.bZQ.getCurrentPosition();
        }
    }
}

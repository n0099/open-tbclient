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
import com.baidu.tieba.play.ax;
import com.baidu.tieba.play.s;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.widget.ListView.a<bk, a> implements ba, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> GO;
    private com.baidu.tieba.frs.entelechy.view.a bZV;
    private bz<bk> bZe;
    private String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ah(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZe = new ai(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: M */
    public a a(ViewGroup viewGroup) {
        this.bZV = new com.baidu.tieba.frs.entelechy.view.a(this.GO);
        this.bZV.j(this.GO.getUniqueId());
        this.bZV.setForumName(this.mForumName);
        return new a(this.bZV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, a aVar) {
        aVar.bZX.a(e(bkVar));
        aVar.bZX.onBindDataToView(bkVar);
        aVar.bZX.setForumName(this.mForumName);
        aVar.bZX.setOnSubCardOnClickListenner(this.bZe);
        com.baidu.tieba.frs.h.b.agV().a(chm, bkVar);
        com.baidu.tieba.frs.h.b.agV().s(bkVar);
        if (bkVar != null) {
            bkVar.sN();
        }
        return aVar.getView();
    }

    private ax e(bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        ax axVar = new ax();
        axVar.mLocate = bkVar.sI() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        axVar.aRN = chm.che;
        axVar.aRO = bkVar.getTid();
        axVar.mSource = bkVar.Vl;
        axVar.fgJ = bkVar.Vq;
        axVar.fgK = bkVar.Vm;
        return axVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ba
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements s {
        public com.baidu.tieba.frs.entelechy.view.a bZX;

        public a(com.baidu.tieba.frs.entelechy.view.a aVar) {
            super(aVar.getView());
            this.bZX = aVar;
        }

        @Override // com.baidu.tieba.play.s
        public boolean JS() {
            if (this.bZX == null) {
                return false;
            }
            return this.bZX.JS();
        }

        @Override // com.baidu.tieba.play.s
        public boolean isPlaying() {
            if (this.bZX == null) {
                return false;
            }
            return this.bZX.isPlaying();
        }

        @Override // com.baidu.tieba.play.s
        public void JT() {
            if (this.bZX != null) {
                this.bZX.JT();
            }
        }

        @Override // com.baidu.tieba.play.s
        public void stopPlay() {
            if (this.bZX != null) {
                this.bZX.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.s
        public View getVideoContainer() {
            if (this.bZX == null) {
                return null;
            }
            return this.bZX.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.s
        public String getPlayUrl() {
            if (this.bZX == null) {
                return null;
            }
            return this.bZX.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.s
        public int getCurrentPosition() {
            if (this.bZX == null) {
                return 0;
            }
            return this.bZX.getCurrentPosition();
        }
    }
}

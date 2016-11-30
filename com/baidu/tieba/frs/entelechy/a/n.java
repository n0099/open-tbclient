package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.frs.entelechy.view.as;
import com.baidu.tieba.frs.entelechy.view.ba;
import com.baidu.tieba.play.ax;
import com.baidu.tieba.play.s;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.widget.ListView.a<bk, a> implements ba, com.baidu.tieba.frs.h.e {
    public static int bZx = 5;
    public static int bZy = 10;
    public static int bZz = 15;
    private TbPageContext<?> GO;
    private as bZA;
    private bz<bk> bZe;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bk bkVar, String str) {
        if (bkVar != null) {
            int sQ = bkVar.sQ();
            av avVar = new av(str);
            avVar.ab("obj_locate", m14if(sQ));
            avVar.ab("tid", bkVar.getTid());
            avVar.s("obj_type", 2);
            TiebaStatic.log(avVar);
        }
    }

    /* renamed from: if  reason: not valid java name */
    private String m14if(int i) {
        if (i == bZx) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == bZy) {
            return "10";
        }
        if (i != bZz) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZe = new o(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: E */
    public a a(ViewGroup viewGroup) {
        this.bZA = new as(this.GO);
        this.bZA.j(this.GO.getUniqueId());
        this.bZA.setForumName(this.forumName);
        return new a(this.bZA);
    }

    private ax e(bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        ax axVar = new ax();
        axVar.mLocate = m14if(bkVar.sQ());
        axVar.aRN = chm.che;
        axVar.aRO = bkVar.getTid();
        bkVar.sN();
        return axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, a aVar) {
        aVar.bZC.a(e(bkVar));
        aVar.bZC.j(bkVar);
        aVar.bZC.setOnSubCardOnClickListenner(this.bZe);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ba
    public void setForumName(String str) {
        this.forumName = str;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements s {
        public as bZC;

        public a(as asVar) {
            super(asVar.getView());
            this.bZC = asVar;
        }

        @Override // com.baidu.tieba.play.s
        public boolean JS() {
            if (this.bZC == null) {
                return false;
            }
            return this.bZC.JS();
        }

        @Override // com.baidu.tieba.play.s
        public boolean isPlaying() {
            if (this.bZC == null) {
                return false;
            }
            return this.bZC.isPlaying();
        }

        @Override // com.baidu.tieba.play.s
        public void JT() {
            if (this.bZC != null) {
                this.bZC.JT();
            }
        }

        @Override // com.baidu.tieba.play.s
        public void stopPlay() {
            if (this.bZC != null) {
                this.bZC.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.s
        public View getVideoContainer() {
            if (this.bZC == null) {
                return null;
            }
            return this.bZC.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.s
        public String getPlayUrl() {
            if (this.bZC == null) {
                return null;
            }
            return this.bZC.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.s
        public int getCurrentPosition() {
            if (this.bZC == null) {
                return 0;
            }
            return this.bZC.getCurrentPosition();
        }
    }
}

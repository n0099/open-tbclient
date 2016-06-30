package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.frs.entelechy.view.au;
import com.baidu.tieba.frs.entelechy.view.m;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.widget.ListView.a<az, a> implements au {
    private TbPageContext<?> Ea;
    private m bJK;
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public a a(ViewGroup viewGroup) {
        this.bJK = new m(this.Ea);
        this.bJK.j(this.Ea.getUniqueId());
        this.bJK.setForumName(this.forumName);
        return new a(this.bJK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, az azVar, a aVar) {
        aVar.bJL.h(azVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.entelechy.view.au
    public void setForumName(String str) {
        this.forumName = str;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public m bJL;

        public a(m mVar) {
            super(mVar.getView());
            this.bJL = mVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean IB() {
            if (this.bJL == null) {
                return false;
            }
            return this.bJL.IB();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.bJL == null) {
                return false;
            }
            return this.bJL.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void IA() {
            if (this.bJL != null) {
                this.bJL.IA();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.bJL != null) {
                this.bJL.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.bJL == null) {
                return null;
            }
            return this.bJL.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.bJL == null) {
                return null;
            }
            return this.bJL.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.bJL == null) {
                return 0;
            }
            return this.bJL.getCurrentPosition();
        }
    }
}

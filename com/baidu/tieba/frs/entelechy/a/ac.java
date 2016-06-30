package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.frs.entelechy.view.au;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.widget.ListView.a<az, a> implements au {
    private TbPageContext<?> Ea;
    private com.baidu.tieba.frs.entelechy.view.a bJP;
    private String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public a a(ViewGroup viewGroup) {
        this.bJP = new com.baidu.tieba.frs.entelechy.view.a(this.Ea);
        this.bJP.j(this.Ea.getUniqueId());
        this.bJP.setForumName(this.mForumName);
        return new a(this.bJP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, az azVar, a aVar) {
        aVar.bJQ.h(azVar);
        aVar.bJQ.setForumName(this.mForumName);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.entelechy.view.au
    public void setForumName(String str) {
        this.mForumName = str;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public com.baidu.tieba.frs.entelechy.view.a bJQ;

        public a(com.baidu.tieba.frs.entelechy.view.a aVar) {
            super(aVar.getView());
            this.bJQ = aVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean IB() {
            if (this.bJQ == null) {
                return false;
            }
            return this.bJQ.IB();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.bJQ == null) {
                return false;
            }
            return this.bJQ.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void IA() {
            if (this.bJQ != null) {
                this.bJQ.IA();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.bJQ != null) {
                this.bJQ.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.bJQ == null) {
                return null;
            }
            return this.bJQ.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.bJQ == null) {
                return null;
            }
            return this.bJQ.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.bJQ == null) {
                return 0;
            }
            return this.bJQ.getCurrentPosition();
        }
    }
}

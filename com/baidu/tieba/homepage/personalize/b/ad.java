package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ad {
    private BdTypeListView aPZ;
    private TbPageContext<?> ajr;
    private List<com.baidu.adp.widget.ListView.a> bSe;
    private com.baidu.adp.widget.ListView.a bVQ;
    private com.baidu.adp.widget.ListView.a bVR;
    private List<com.baidu.adp.widget.ListView.v> cvY;
    private a cvZ;
    private ac cwa;
    private com.baidu.adp.widget.ListView.a cwb;
    private com.baidu.adp.widget.ListView.a cwc;
    private m cwd;
    private s cwe;
    private g cwf;
    private k cwg;
    private q cwh;
    private com.baidu.tieba.homepage.alalivelist.a.d cwi;
    private com.baidu.tieba.homepage.alalivelist.a.f cwj;
    private d cwk;
    private b cwl;
    private boolean cwm;
    private boolean cwn;
    private CustomMessageListener bSm = new ae(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener amZ = new af(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new ag(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new ah(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> cvX = new ArrayList();

    public ad(Context context, BdTypeListView bdTypeListView) {
        this.aPZ = bdTypeListView;
        this.ajr = (TbPageContext) com.baidu.adp.base.k.Z(context);
        br(context);
        bdTypeListView.addAdapters(this.cvX);
    }

    private void br(Context context) {
        this.cvZ = new a(this.ajr);
        this.cwa = new ac(this.ajr);
        this.bVQ = com.baidu.tieba.recapp.x.aYp().c(this.ajr, AdvertAppInfo.Tg);
        this.bVR = com.baidu.tieba.recapp.x.aYp().c(this.ajr, AdvertAppInfo.Th);
        this.cwb = com.baidu.tieba.recapp.x.aYp().c(this.ajr, AdvertAppInfo.Ti);
        this.cwc = com.baidu.tieba.recapp.x.aYp().c(this.ajr, AdvertAppInfo.Tj);
        this.cwd = new m(this.ajr, com.baidu.tieba.card.data.l.TYPE);
        this.cwe = new s(this.ajr, com.baidu.tieba.card.data.n.bxC);
        this.cwl = new b(this.ajr, com.baidu.tieba.card.data.m.TYPE);
        this.cwf = new g(this.ajr, com.baidu.tieba.card.data.l.bxv);
        this.cwg = new k(this.ajr, com.baidu.tieba.card.data.n.bxD);
        this.cwh = new q(this.ajr);
        this.cwi = new com.baidu.tieba.homepage.alalivelist.a.d(this.ajr, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cwj = new com.baidu.tieba.homepage.alalivelist.a.f(this.ajr, com.baidu.tieba.homepage.alalivelist.view.h.TYPE);
        this.cwk = new d(this.ajr, com.baidu.tieba.card.data.k.TYPE);
        this.cvX.add(this.cvZ);
        this.cvX.add(this.cwa);
        this.cvX.add(this.bVQ);
        this.cvX.add(this.bVR);
        this.cvX.add(this.cwb);
        this.cvX.add(this.cwc);
        this.cvX.add(this.cwe);
        this.cvX.add(this.cwd);
        this.cvX.add(this.cwl);
        this.cvX.add(this.cwf);
        this.cvX.add(this.cwg);
        this.cvX.add(new y(this.ajr.getPageActivity()));
        this.cvX.add(new v(this.ajr.getPageActivity()));
        this.cvX.add(this.cwh);
        this.cvX.add(new com.baidu.tieba.homepage.personalize.c.c(this.ajr, com.baidu.tieba.homepage.personalize.c.e.TYPE));
        this.cvX.add(this.cwi);
        this.cvX.add(this.cwj);
        this.cvX.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.ajr, com.baidu.tieba.homepage.alalivelist.a.c.csA));
        this.cvX.add(this.cwk);
        aaA();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cwd.a(fVar);
        this.cwe.a(fVar);
        this.cwf.a(fVar);
        this.cwg.a(fVar);
    }

    public void aV(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.s.r(list, 2);
        this.aPZ.setData(list);
        this.cvY = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cvZ.onChangeSkinType(i);
        this.cwh.jP(i);
    }

    public void notifyDataSetChanged() {
        if (this.aPZ != null && (this.aPZ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.aPZ.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cwd != null) {
            this.cwd.setFromCDN(z);
        }
        if (this.cwf != null) {
            this.cwf.setFromCDN(z);
        }
        if (this.bVR != null && (this.bVR instanceof com.baidu.tieba.recapp.t)) {
            ((com.baidu.tieba.recapp.t) this.bVR).setIsFromCDN(z);
        }
        if (this.cwc != null && (this.cwc instanceof com.baidu.tieba.recapp.t)) {
            ((com.baidu.tieba.recapp.t) this.cwc).setIsFromCDN(z);
        }
        if (this.cwb != null && (this.cwb instanceof com.baidu.tieba.recapp.t)) {
            ((com.baidu.tieba.recapp.t) this.cwb).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cwd != null) {
            this.cwd.aLk = bdUniqueId;
        }
        if (this.cwe != null) {
            this.cwe.aLk = bdUniqueId;
        }
        if (this.cwl != null) {
            this.cwl.aLk = bdUniqueId;
        }
        if (this.cvZ != null) {
            this.cvZ.setPageUniqueId(bdUniqueId);
        }
        if (this.cwf != null) {
            this.cwf.aLk = bdUniqueId;
        }
        if (this.cwg != null) {
            this.cwg.aLk = bdUniqueId;
        }
        if (this.cwh != null) {
            this.cwh.aLk = bdUniqueId;
        }
        if (this.cwi != null) {
            this.cwi.aLk = bdUniqueId;
        }
        if (this.cwj != null) {
            this.cwj.aLk = bdUniqueId;
        }
        if (this.cwk != null) {
            this.cwk.aLk = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.r(this.bSe)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bSe) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.amZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.amZ);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cwn) {
            this.bSm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bSm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Object obj) {
        if (this.cvY != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cvY) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void aaA() {
        this.cwn = aaB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaB() {
        if (this.bSe == null || this.bSe.size() <= 0) {
            this.bSe = new ArrayList();
            ArrayList<BdUniqueId> bfT = com.baidu.tieba.tbadkCore.s.bfT();
            if (bfT == null || bfT.size() <= 0) {
                return false;
            }
            int size = bfT.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.axu().a(this.ajr, bfT.get(i), 2);
                if (this.cwm) {
                    a.setBusinessType(3);
                }
                if (this.cwd != null && this.cwd.aLk != null) {
                    a.setUniqueId(this.cwd.aLk);
                }
                this.bSe.add(a);
            }
            this.aPZ.addAdapters(this.bSe);
            return true;
        }
        return true;
    }

    public void a(o.a aVar) {
        if (this.cwd != null) {
            this.cwd.setEventCallback(aVar);
        }
        if (this.cwl != null) {
            this.cwl.setEventCallback(aVar);
        }
        if (this.cwe != null) {
            this.cwe.setEventCallback(aVar);
        }
        if (this.cwk != null) {
            this.cwk.setEventCallback(aVar);
        }
    }
}

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
    private BdTypeListView aPG;
    private TbPageContext<?> ajU;
    private List<com.baidu.adp.widget.ListView.a> bUk;
    private com.baidu.adp.widget.ListView.a bXQ;
    private com.baidu.adp.widget.ListView.a bXR;
    private List<com.baidu.adp.widget.ListView.v> cAO;
    private a cAP;
    private ac cAQ;
    private com.baidu.adp.widget.ListView.a cAR;
    private com.baidu.adp.widget.ListView.a cAS;
    private m cAT;
    private s cAU;
    private g cAV;
    private k cAW;
    private q cAX;
    private com.baidu.tieba.homepage.alalivelist.a.d cAY;
    private com.baidu.tieba.homepage.alalivelist.a.f cAZ;
    private d cBa;
    private b cBb;
    private com.baidu.tieba.homepage.mygod.a.c cBc;
    private com.baidu.tieba.homepage.mygod.a.e cBd;
    private boolean cBe;
    private boolean cBf;
    private com.baidu.tieba.homepage.mygod.a.a cBg;
    private CustomMessageListener bUs = new ae(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener amU = new af(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new ag(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new ah(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> cAN = new ArrayList();

    public ad(Context context, BdTypeListView bdTypeListView) {
        this.aPG = bdTypeListView;
        this.ajU = (TbPageContext) com.baidu.adp.base.k.Z(context);
        br(context);
        bdTypeListView.addAdapters(this.cAN);
    }

    public void fi(boolean z) {
        this.cBe = z;
        if (!com.baidu.tbadk.core.util.x.q(this.bUk)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bUk) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    if (z) {
                        ((com.baidu.tieba.lego.card.a.a) aVar).setBusinessType(3);
                    } else {
                        ((com.baidu.tieba.lego.card.a.a) aVar).setBusinessType(2);
                    }
                }
            }
        }
    }

    private void br(Context context) {
        this.cAP = new a(this.ajU);
        this.cAQ = new ac(this.ajU);
        this.bXQ = com.baidu.tieba.recapp.v.baQ().b(this.ajU, AdvertAppInfo.TO);
        this.bXR = com.baidu.tieba.recapp.v.baQ().b(this.ajU, AdvertAppInfo.TP);
        this.cAR = com.baidu.tieba.recapp.v.baQ().b(this.ajU, AdvertAppInfo.TQ);
        this.cAS = com.baidu.tieba.recapp.v.baQ().b(this.ajU, AdvertAppInfo.TR);
        this.cAT = new m(this.ajU, com.baidu.tieba.card.data.n.TYPE);
        this.cAU = new s(this.ajU, com.baidu.tieba.card.data.p.bxE);
        this.cBb = new b(this.ajU, com.baidu.tieba.card.data.o.TYPE);
        this.cAV = new g(this.ajU, com.baidu.tieba.card.data.n.bxx);
        this.cAW = new k(this.ajU, com.baidu.tieba.card.data.p.bxF);
        this.cBc = new com.baidu.tieba.homepage.mygod.a.c(this.ajU, com.baidu.tieba.card.data.f.TYPE);
        this.cBd = new com.baidu.tieba.homepage.mygod.a.e(this.ajU, com.baidu.tieba.card.data.g.TYPE);
        this.cAX = new q(this.ajU);
        this.cBg = new com.baidu.tieba.homepage.mygod.a.a(this.ajU, com.baidu.tieba.homepage.mygod.data.a.cyA);
        this.cAY = new com.baidu.tieba.homepage.alalivelist.a.d(this.ajU, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cAZ = new com.baidu.tieba.homepage.alalivelist.a.f(this.ajU, com.baidu.tieba.homepage.alalivelist.view.h.TYPE);
        this.cBa = new d(this.ajU, com.baidu.tieba.card.data.m.TYPE);
        this.cAN.add(this.cAP);
        this.cAN.add(this.cAQ);
        this.cAN.add(this.bXQ);
        this.cAN.add(this.bXR);
        this.cAN.add(this.cAR);
        this.cAN.add(this.cAS);
        this.cAN.add(this.cAU);
        this.cAN.add(this.cAT);
        this.cAN.add(this.cBb);
        this.cAN.add(new com.baidu.tieba.homepage.mygod.a.b(this.ajU.getPageActivity(), com.baidu.tieba.homepage.mygod.data.b.cyF));
        this.cAN.add(this.cBg);
        this.cAN.add(this.cBc);
        this.cAN.add(this.cBd);
        this.cAN.add(this.cAV);
        this.cAN.add(this.cAW);
        this.cAN.add(new y(this.ajU.getPageActivity()));
        this.cAN.add(new v(this.ajU.getPageActivity()));
        this.cAN.add(this.cAX);
        this.cAN.add(new com.baidu.tieba.homepage.personalize.c.c(this.ajU, com.baidu.tieba.homepage.personalize.c.e.TYPE));
        this.cAN.add(this.cAY);
        this.cAN.add(this.cAZ);
        this.cAN.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.ajU, com.baidu.tieba.homepage.alalivelist.a.c.cvA));
        this.cAN.add(this.cBa);
        aco();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cAT.a(fVar);
        this.cAU.a(fVar);
        this.cAV.a(fVar);
        this.cAW.a(fVar);
    }

    public void bd(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.t.r(list, 2);
        this.aPG.setData(list);
        this.cAO = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cAP.onChangeSkinType(i);
        this.cAX.jY(i);
    }

    public void notifyDataSetChanged() {
        if (this.aPG != null && (this.aPG.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.aPG.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cAT != null) {
            this.cAT.setFromCDN(z);
        }
        if (this.cAV != null) {
            this.cAV.setFromCDN(z);
        }
        if (this.bXR != null && (this.bXR instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.bXR).setIsFromCDN(z);
        }
        if (this.cAS != null && (this.cAS instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.cAS).setIsFromCDN(z);
        }
        if (this.cAR != null && (this.cAR instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.cAR).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cBc != null) {
            this.cBc.bbE = bdUniqueId;
        }
        if (this.cBd != null) {
            this.cBd.bbE = bdUniqueId;
        }
        if (this.cAT != null) {
            this.cAT.bbE = bdUniqueId;
        }
        if (this.cAU != null) {
            this.cAU.bbE = bdUniqueId;
        }
        if (this.cBb != null) {
            this.cBb.bbE = bdUniqueId;
        }
        if (this.cAP != null) {
            this.cAP.setPageUniqueId(bdUniqueId);
        }
        if (this.cAV != null) {
            this.cAV.bbE = bdUniqueId;
        }
        if (this.cAW != null) {
            this.cAW.bbE = bdUniqueId;
        }
        if (this.cAX != null) {
            this.cAX.bbE = bdUniqueId;
        }
        if (this.cBg != null) {
            this.cBg.bbE = bdUniqueId;
        }
        if (this.cAY != null) {
            this.cAY.bbE = bdUniqueId;
        }
        if (this.cAZ != null) {
            this.cAZ.bbE = bdUniqueId;
        }
        if (this.cBa != null) {
            this.cBa.bbE = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bUk)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bUk) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.amU.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.amU);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cBf) {
            this.bUs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Object obj) {
        if (this.cAO != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cAO) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void aco() {
        this.cBf = acp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acp() {
        if (this.bUk == null || this.bUk.size() <= 0) {
            this.bUk = new ArrayList();
            ArrayList<BdUniqueId> biv = com.baidu.tieba.tbadkCore.t.biv();
            if (biv == null || biv.size() <= 0) {
                return false;
            }
            int size = biv.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.aAt().a(this.ajU, biv.get(i), 2);
                if (this.cBe) {
                    a.setBusinessType(3);
                }
                if (this.cAT != null && this.cAT.bbE != null) {
                    a.setUniqueId(this.cAT.bbE);
                }
                this.bUk.add(a);
            }
            this.aPG.addAdapters(this.bUk);
            return true;
        }
        return true;
    }

    public void a(o.a aVar) {
        if (this.cAT != null) {
            this.cAT.setEventCallback(aVar);
        }
        if (this.cBb != null) {
            this.cBb.setEventCallback(aVar);
        }
        if (this.cAU != null) {
            this.cAU.setEventCallback(aVar);
        }
        if (this.cBa != null) {
            this.cBa.setEventCallback(aVar);
        }
    }
}

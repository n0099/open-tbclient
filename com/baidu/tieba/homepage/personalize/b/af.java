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
public class af {
    private BdTypeListView aQa;
    private TbPageContext<?> ajh;
    private List<com.baidu.adp.widget.ListView.a> bXW;
    private s cCA;
    private com.baidu.tieba.homepage.alalivelist.a.d cCB;
    private com.baidu.tieba.homepage.alalivelist.a.f cCC;
    private d cCD;
    private b cCE;
    private boolean cCF;
    private boolean cCG;
    private List<com.baidu.adp.widget.ListView.v> cCr;
    private a cCs;
    private ae cCt;
    private com.baidu.adp.widget.ListView.a cCu;
    private o cCv;
    private m cCw;
    private u cCx;
    private g cCy;
    private k cCz;
    private com.baidu.adp.widget.ListView.a cbR;
    private CustomMessageListener bYe = new ag(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener amV = new ah(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new ai(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new aj(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> cCq = new ArrayList();

    public af(Context context, BdTypeListView bdTypeListView) {
        this.aQa = bdTypeListView;
        this.ajh = (TbPageContext) com.baidu.adp.base.k.Z(context);
        br(context);
        bdTypeListView.addAdapters(this.cCq);
    }

    private void br(Context context) {
        this.cCs = new a(this.ajh);
        this.cCt = new ae(this.ajh);
        this.cbR = com.baidu.tieba.recapp.z.aZK().c(this.ajh, AdvertAppInfo.ST);
        this.cCu = com.baidu.tieba.recapp.z.aZK().c(this.ajh, AdvertAppInfo.SW);
        this.cCv = new o(this.ajh, com.baidu.tieba.card.data.l.TYPE);
        this.cCw = new m(this.ajh, com.baidu.tieba.card.data.l.Xp);
        this.cCx = new u(this.ajh, com.baidu.tieba.card.data.n.bDy);
        this.cCE = new b(this.ajh, com.baidu.tieba.card.data.m.TYPE);
        this.cCy = new g(this.ajh, com.baidu.tieba.card.data.l.bDr);
        this.cCz = new k(this.ajh, com.baidu.tieba.card.data.n.bDz);
        this.cCA = new s(this.ajh);
        this.cCB = new com.baidu.tieba.homepage.alalivelist.a.d(this.ajh, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cCC = new com.baidu.tieba.homepage.alalivelist.a.f(this.ajh, com.baidu.tieba.homepage.alalivelist.view.h.TYPE);
        this.cCD = new d(this.ajh, com.baidu.tieba.card.data.k.TYPE);
        this.cCq.add(this.cCs);
        this.cCq.add(this.cCt);
        this.cCq.add(this.cbR);
        this.cCq.add(this.cCu);
        this.cCq.add(this.cCx);
        this.cCq.add(this.cCv);
        this.cCq.add(this.cCw);
        this.cCq.add(this.cCE);
        this.cCq.add(this.cCy);
        this.cCq.add(this.cCz);
        this.cCq.add(new aa(this.ajh.getPageActivity()));
        this.cCq.add(new x(this.ajh.getPageActivity()));
        this.cCq.add(this.cCA);
        this.cCq.add(new com.baidu.tieba.homepage.personalize.c.c(this.ajh, com.baidu.tieba.homepage.personalize.c.e.TYPE));
        this.cCq.add(this.cCB);
        this.cCq.add(this.cCC);
        this.cCq.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.ajh, com.baidu.tieba.homepage.alalivelist.a.c.cyS));
        this.cCq.add(this.cCD);
        abD();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cCv.a(fVar);
        this.cCx.a(fVar);
        this.cCy.a(fVar);
        this.cCz.a(fVar);
    }

    public void aV(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.s.q(list, 2);
        this.aQa.setData(list);
        this.cCr = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cCs.onChangeSkinType(i);
        this.cCA.kn(i);
    }

    public void notifyDataSetChanged() {
        if (this.aQa != null && (this.aQa.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.aQa.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cCv != null) {
            this.cCv.setFromCDN(z);
        }
        if (this.cCy != null) {
            this.cCy.setFromCDN(z);
        }
        if (this.cCu != null && (this.cCu instanceof com.baidu.tieba.recapp.v)) {
            ((com.baidu.tieba.recapp.v) this.cCu).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cCv != null) {
            this.cCv.aKZ = bdUniqueId;
        }
        if (this.cCw != null) {
            this.cCw.aKZ = bdUniqueId;
        }
        if (this.cCx != null) {
            this.cCx.aKZ = bdUniqueId;
        }
        if (this.cCE != null) {
            this.cCE.aKZ = bdUniqueId;
        }
        if (this.cCs != null) {
            this.cCs.setPageUniqueId(bdUniqueId);
        }
        if (this.cCy != null) {
            this.cCy.aKZ = bdUniqueId;
        }
        if (this.cCz != null) {
            this.cCz.aKZ = bdUniqueId;
        }
        if (this.cCA != null) {
            this.cCA.aKZ = bdUniqueId;
        }
        if (this.cCB != null) {
            this.cCB.aKZ = bdUniqueId;
        }
        if (this.cCC != null) {
            this.cCC.aKZ = bdUniqueId;
        }
        if (this.cCD != null) {
            this.cCD.aKZ = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.r(this.bXW)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bXW) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.amV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.amV);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cCG) {
            this.bYe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bYe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Object obj) {
        if (this.cCr != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cCr) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void abD() {
        this.cCG = abE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abE() {
        if (this.bXW == null || this.bXW.size() <= 0) {
            this.bXW = new ArrayList();
            ArrayList<BdUniqueId> bhq = com.baidu.tieba.tbadkCore.s.bhq();
            if (bhq == null || bhq.size() <= 0) {
                return false;
            }
            int size = bhq.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.ayn().a(this.ajh, bhq.get(i), 2);
                if (this.cCF) {
                    a.setBusinessType(3);
                }
                if (this.cCv != null && this.cCv.aKZ != null) {
                    a.setUniqueId(this.cCv.aKZ);
                }
                this.bXW.add(a);
            }
            this.aQa.addAdapters(this.bXW);
            return true;
        }
        return true;
    }

    public void a(o.a aVar) {
        if (this.cCv != null) {
            this.cCv.setEventCallback(aVar);
        }
        if (this.cCw != null) {
            this.cCw.setEventCallback(aVar);
        }
        if (this.cCE != null) {
            this.cCE.setEventCallback(aVar);
        }
        if (this.cCx != null) {
            this.cCx.setEventCallback(aVar);
        }
        if (this.cCD != null) {
            this.cCD.setEventCallback(aVar);
        }
    }
}

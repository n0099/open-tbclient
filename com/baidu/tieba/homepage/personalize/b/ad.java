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
    private BdTypeListView aPo;
    private TbPageContext<?> ajF;
    private List<com.baidu.adp.widget.ListView.a> bSf;
    private com.baidu.adp.widget.ListView.a bVL;
    private com.baidu.adp.widget.ListView.a bVM;
    private com.baidu.adp.widget.ListView.a cAa;
    private com.baidu.adp.widget.ListView.a cAb;
    private m cAc;
    private s cAd;
    private g cAe;
    private k cAf;
    private q cAg;
    private com.baidu.tieba.homepage.alalivelist.a.d cAh;
    private com.baidu.tieba.homepage.alalivelist.a.f cAi;
    private d cAj;
    private b cAk;
    private com.baidu.tieba.homepage.mygod.a.c cAl;
    private com.baidu.tieba.homepage.mygod.a.e cAm;
    private boolean cAn;
    private boolean cAo;
    private com.baidu.tieba.homepage.mygod.a.a cAp;
    private List<com.baidu.adp.widget.ListView.v> czX;
    private a czY;
    private ac czZ;
    private CustomMessageListener bSn = new ae(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener amG = new af(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new ag(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new ah(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> czW = new ArrayList();

    public ad(Context context, BdTypeListView bdTypeListView) {
        this.aPo = bdTypeListView;
        this.ajF = (TbPageContext) com.baidu.adp.base.k.aa(context);
        by(context);
        bdTypeListView.addAdapters(this.czW);
    }

    public void eY(boolean z) {
        this.cAn = z;
        if (!com.baidu.tbadk.core.util.x.q(this.bSf)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bSf) {
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

    private void by(Context context) {
        this.czY = new a(this.ajF);
        this.czZ = new ac(this.ajF);
        this.bVL = com.baidu.tieba.recapp.r.aZD().b(this.ajF, AdvertAppInfo.Tt);
        this.bVM = com.baidu.tieba.recapp.r.aZD().b(this.ajF, AdvertAppInfo.Tu);
        this.cAa = com.baidu.tieba.recapp.r.aZD().b(this.ajF, AdvertAppInfo.Tv);
        this.cAb = com.baidu.tieba.recapp.r.aZD().b(this.ajF, AdvertAppInfo.Tw);
        this.cAc = new m(this.ajF, com.baidu.tieba.card.data.n.TYPE);
        this.cAd = new s(this.ajF, com.baidu.tieba.card.data.p.bvu);
        this.cAk = new b(this.ajF, com.baidu.tieba.card.data.o.TYPE);
        this.cAe = new g(this.ajF, com.baidu.tieba.card.data.n.bvn);
        this.cAf = new k(this.ajF, com.baidu.tieba.card.data.p.bvv);
        this.cAl = new com.baidu.tieba.homepage.mygod.a.c(this.ajF, com.baidu.tieba.card.data.f.TYPE);
        this.cAm = new com.baidu.tieba.homepage.mygod.a.e(this.ajF, com.baidu.tieba.card.data.g.TYPE);
        this.cAg = new q(this.ajF);
        this.cAp = new com.baidu.tieba.homepage.mygod.a.a(this.ajF, com.baidu.tieba.homepage.mygod.data.a.cxJ);
        this.cAh = new com.baidu.tieba.homepage.alalivelist.a.d(this.ajF, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cAi = new com.baidu.tieba.homepage.alalivelist.a.f(this.ajF, com.baidu.tieba.homepage.alalivelist.view.h.TYPE);
        this.cAj = new d(this.ajF, com.baidu.tieba.card.data.m.TYPE);
        this.czW.add(this.czY);
        this.czW.add(this.czZ);
        this.czW.add(this.bVL);
        this.czW.add(this.bVM);
        this.czW.add(this.cAa);
        this.czW.add(this.cAb);
        this.czW.add(this.cAd);
        this.czW.add(this.cAc);
        this.czW.add(this.cAk);
        this.czW.add(new com.baidu.tieba.homepage.mygod.a.b(this.ajF.getPageActivity(), com.baidu.tieba.homepage.mygod.data.b.cxO));
        this.czW.add(this.cAp);
        this.czW.add(this.cAl);
        this.czW.add(this.cAm);
        this.czW.add(this.cAe);
        this.czW.add(this.cAf);
        this.czW.add(new y(this.ajF.getPageActivity()));
        this.czW.add(new v(this.ajF.getPageActivity()));
        this.czW.add(this.cAg);
        this.czW.add(new com.baidu.tieba.homepage.personalize.c.c(this.ajF, com.baidu.tieba.homepage.personalize.c.e.TYPE));
        this.czW.add(this.cAh);
        this.czW.add(this.cAi);
        this.czW.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.ajF, com.baidu.tieba.homepage.alalivelist.a.c.cuJ));
        this.czW.add(this.cAj);
        aaP();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cAc.a(fVar);
        this.cAd.a(fVar);
        this.cAe.a(fVar);
        this.cAf.a(fVar);
    }

    public void bd(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.t.r(list, 2);
        this.aPo.setData(list);
        this.czX = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.czY.onChangeSkinType(i);
        this.cAg.jR(i);
    }

    public void notifyDataSetChanged() {
        if (this.aPo != null && (this.aPo.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.aPo.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cAc != null) {
            this.cAc.setFromCDN(z);
        }
        if (this.cAe != null) {
            this.cAe.setFromCDN(z);
        }
        if (this.bVM != null && (this.bVM instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.bVM).setIsFromCDN(z);
        }
        if (this.cAb != null && (this.cAb instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cAb).setIsFromCDN(z);
        }
        if (this.cAa != null && (this.cAa instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cAa).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cAl != null) {
            this.cAl.baP = bdUniqueId;
        }
        if (this.cAm != null) {
            this.cAm.baP = bdUniqueId;
        }
        if (this.cAc != null) {
            this.cAc.baP = bdUniqueId;
        }
        if (this.cAd != null) {
            this.cAd.baP = bdUniqueId;
        }
        if (this.cAk != null) {
            this.cAk.baP = bdUniqueId;
        }
        if (this.czY != null) {
            this.czY.setPageUniqueId(bdUniqueId);
        }
        if (this.cAe != null) {
            this.cAe.baP = bdUniqueId;
        }
        if (this.cAf != null) {
            this.cAf.baP = bdUniqueId;
        }
        if (this.cAg != null) {
            this.cAg.baP = bdUniqueId;
        }
        if (this.cAp != null) {
            this.cAp.baP = bdUniqueId;
        }
        if (this.cAh != null) {
            this.cAh.baP = bdUniqueId;
        }
        if (this.cAi != null) {
            this.cAi.baP = bdUniqueId;
        }
        if (this.cAj != null) {
            this.cAj.baP = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bSf)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bSf) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.amG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.amG);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cAo) {
            this.bSn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bSn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Object obj) {
        if (this.czX != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.czX) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void aaP() {
        this.cAo = aaQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaQ() {
        if (this.bSf == null || this.bSf.size() <= 0) {
            this.bSf = new ArrayList();
            ArrayList<BdUniqueId> bgJ = com.baidu.tieba.tbadkCore.t.bgJ();
            if (bgJ == null || bgJ.size() <= 0) {
                return false;
            }
            int size = bgJ.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.azM().a(this.ajF, bgJ.get(i), 2);
                if (this.cAn) {
                    a.setBusinessType(3);
                }
                if (this.cAc != null && this.cAc.baP != null) {
                    a.setUniqueId(this.cAc.baP);
                }
                this.bSf.add(a);
            }
            this.aPo.addAdapters(this.bSf);
            return true;
        }
        return true;
    }

    public void a(o.a aVar) {
        if (this.cAc != null) {
            this.cAc.setEventCallback(aVar);
        }
        if (this.cAk != null) {
            this.cAk.setEventCallback(aVar);
        }
        if (this.cAd != null) {
            this.cAd.setEventCallback(aVar);
        }
        if (this.cAj != null) {
            this.cAj.setEventCallback(aVar);
        }
    }
}

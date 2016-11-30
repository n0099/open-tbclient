package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac {
    private TbPageContext<?> GO;
    private com.baidu.adp.widget.ListView.a bYB;
    private com.baidu.adp.widget.ListView.a bYC;
    private List<com.baidu.adp.widget.ListView.a> bYT;
    private BdTypeListView cKw;
    private i cMA;
    private o cMB;
    private c cMC;
    private com.baidu.tieba.homepage.mygod.a.c cMD;
    private com.baidu.tieba.homepage.mygod.a.e cME;
    private boolean cMF;
    private boolean cMG;
    private com.baidu.tieba.homepage.mygod.a.a cMH;
    private List<com.baidu.adp.widget.ListView.v> cMq;
    private b cMr;
    private a cMs;
    private s cMt;
    private ab cMu;
    private com.baidu.adp.widget.ListView.a cMv;
    private com.baidu.adp.widget.ListView.a cMw;
    private k cMx;
    private q cMy;
    private e cMz;
    private CustomMessageListener bZa = new ad(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener aiv = new ae(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new af(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new ag(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> cMp = new ArrayList();

    public ac(Context context, BdTypeListView bdTypeListView) {
        this.cKw = bdTypeListView;
        this.GO = (TbPageContext) com.baidu.adp.base.l.C(context);
        aX(context);
        bdTypeListView.g(this.cMp);
    }

    public void fs(boolean z) {
        this.cMF = z;
        if (!com.baidu.tbadk.core.util.x.t(this.bYT)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bYT) {
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

    private void aX(Context context) {
        this.cMr = new b(this.GO);
        this.cMs = new a(this.GO);
        this.cMt = new s(this.GO);
        this.cMu = new ab(this.GO);
        this.bYB = com.baidu.tieba.recapp.e.bes().b(this.GO, com.baidu.tbadk.core.data.c.Ph);
        this.bYC = com.baidu.tieba.recapp.e.bes().b(this.GO, com.baidu.tbadk.core.data.c.Pi);
        this.cMv = com.baidu.tieba.recapp.e.bes().b(this.GO, com.baidu.tbadk.core.data.c.Pj);
        this.cMw = com.baidu.tieba.recapp.e.bes().b(this.GO, com.baidu.tbadk.core.data.c.Pk);
        this.cMx = new k(this.GO, com.baidu.tieba.card.data.m.RQ);
        this.cMy = new q(this.GO, com.baidu.tieba.card.data.o.bfq);
        this.cMC = new c(this.GO, com.baidu.tieba.card.data.n.RQ);
        this.cMz = new e(this.GO, com.baidu.tieba.card.data.m.bfj);
        this.cMA = new i(this.GO, com.baidu.tieba.card.data.o.bfr);
        this.cMD = new com.baidu.tieba.homepage.mygod.a.c(this.GO, com.baidu.tieba.card.data.g.RQ);
        this.cME = new com.baidu.tieba.homepage.mygod.a.e(this.GO, com.baidu.tieba.card.data.h.RQ);
        this.cMB = new o(this.GO);
        this.cMH = new com.baidu.tieba.homepage.mygod.a.a(this.GO, com.baidu.tieba.homepage.mygod.data.a.cJN);
        this.cMp.add(this.cMr);
        this.cMp.add(this.cMs);
        this.cMp.add(this.cMt);
        this.cMp.add(this.cMu);
        this.cMp.add(this.bYB);
        this.cMp.add(this.bYC);
        this.cMp.add(this.cMv);
        this.cMp.add(this.cMw);
        this.cMp.add(this.cMy);
        this.cMp.add(this.cMx);
        this.cMp.add(this.cMC);
        this.cMp.add(new com.baidu.tieba.homepage.mygod.a.b(this.GO.getPageActivity(), com.baidu.tieba.homepage.mygod.data.b.cJS));
        this.cMp.add(this.cMH);
        this.cMp.add(this.cMD);
        this.cMp.add(this.cME);
        this.cMp.add(this.cMz);
        this.cMp.add(this.cMA);
        this.cMp.add(new x(this.GO.getPageActivity()));
        this.cMp.add(new u(this.GO.getPageActivity()));
        this.cMp.add(this.cMB);
        this.cMp.add(new com.baidu.tieba.homepage.personalize.d.c(this.GO, com.baidu.tieba.homepage.personalize.d.e.RQ));
        aew();
    }

    public void b(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cMx.a(fVar);
        this.cMy.a(fVar);
        this.cMz.a(fVar);
        this.cMA.a(fVar);
    }

    public void by(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.v.s(list, 2);
        this.cKw.setData(list);
        this.cMq = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cMr.onChangeSkinType(i);
        this.cMs.onChangeSkinType(i);
        this.cMB.kp(i);
    }

    public void notifyDataSetChanged() {
        if (this.cKw != null && (this.cKw.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.cKw.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cMx != null) {
            this.cMx.setFromCDN(z);
        }
        if (this.cMz != null) {
            this.cMz.setFromCDN(z);
        }
        if (this.bYC != null && (this.bYC instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.bYC).setIsFromCDN(z);
        }
        if (this.cMw != null && (this.cMw instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.cMw).setIsFromCDN(z);
        }
        if (this.cMv != null && (this.cMv instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.cMv).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cMD != null) {
            this.cMD.bcf = bdUniqueId;
        }
        if (this.cME != null) {
            this.cME.bcf = bdUniqueId;
        }
        if (this.cMx != null) {
            this.cMx.bcf = bdUniqueId;
        }
        if (this.cMy != null) {
            this.cMy.bcf = bdUniqueId;
        }
        if (this.cMC != null) {
            this.cMC.bcf = bdUniqueId;
        }
        if (this.cMr != null) {
            this.cMr.setPageUniqueId(bdUniqueId);
        }
        if (this.cMs != null) {
            this.cMs.setPageUniqueId(bdUniqueId);
        }
        if (this.cMz != null) {
            this.cMz.bcf = bdUniqueId;
        }
        if (this.cMA != null) {
            this.cMA.bcf = bdUniqueId;
        }
        if (this.cMB != null) {
            this.cMB.bcf = bdUniqueId;
        }
        if (this.cMH != null) {
            this.cMH.bcf = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.t(this.bYT)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bYT) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.aiv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aiv);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cMG) {
            this.bZa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bZa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Object obj) {
        if (this.cMq != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cMq) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void aew() {
        this.cMG = aex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aex() {
        if (this.bYT == null || this.bYT.size() <= 0) {
            this.bYT = new ArrayList();
            ArrayList<BdUniqueId> bls = com.baidu.tieba.tbadkCore.v.bls();
            if (bls == null || bls.size() <= 0) {
                return false;
            }
            int size = bls.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aEB().a(this.GO, bls.get(i), 2);
                if (this.cMF) {
                    a.setBusinessType(3);
                }
                if (this.cMx != null && this.cMx.bcf != null) {
                    a.setUniqueId(this.cMx.bcf);
                }
                this.bYT.add(a);
            }
            this.cKw.g(this.bYT);
            return true;
        }
        return true;
    }

    public void a(o.a aVar) {
        if (this.cMx != null) {
            this.cMx.setEventCallback(aVar);
        }
        if (this.cMC != null) {
            this.cMC.setEventCallback(aVar);
        }
        if (this.cMy != null) {
            this.cMy.setEventCallback(aVar);
        }
    }
}

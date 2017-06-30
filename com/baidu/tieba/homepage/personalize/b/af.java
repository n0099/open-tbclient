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
    private BdTypeListView aRs;
    private TbPageContext<?> ajP;
    private com.baidu.tieba.homepage.alalivelist.a.f cKA;
    private d cKB;
    private b cKC;
    private boolean cKD;
    private boolean cKE;
    private List<com.baidu.adp.widget.ListView.v> cKp;
    private a cKq;
    private ae cKr;
    private com.baidu.adp.widget.ListView.a cKs;
    private o cKt;
    private m cKu;
    private u cKv;
    private g cKw;
    private k cKx;
    private s cKy;
    private com.baidu.tieba.homepage.alalivelist.a.d cKz;
    private List<com.baidu.adp.widget.ListView.a> cgf;
    private com.baidu.adp.widget.ListView.a ckc;
    private CustomMessageListener cgn = new ag(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener anV = new ah(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new ai(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new aj(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> cKo = new ArrayList();

    public af(Context context, BdTypeListView bdTypeListView) {
        this.aRs = bdTypeListView;
        this.ajP = (TbPageContext) com.baidu.adp.base.k.Z(context);
        bl(context);
        bdTypeListView.addAdapters(this.cKo);
    }

    private void bl(Context context) {
        this.cKq = new a(this.ajP);
        this.cKr = new ae(this.ajP);
        this.ckc = com.baidu.tieba.recapp.aa.bdU().c(this.ajP, AdvertAppInfo.SO);
        this.cKs = com.baidu.tieba.recapp.aa.bdU().c(this.ajP, AdvertAppInfo.SR);
        this.cKt = new o(this.ajP, com.baidu.tieba.card.data.l.TYPE);
        this.cKu = new m(this.ajP, com.baidu.tieba.card.data.l.Xp);
        this.cKv = new u(this.ajP, com.baidu.tieba.card.data.n.bEr);
        this.cKC = new b(this.ajP, com.baidu.tieba.card.data.m.TYPE);
        this.cKw = new g(this.ajP, com.baidu.tieba.card.data.l.bEk);
        this.cKx = new k(this.ajP, com.baidu.tieba.card.data.n.bEs);
        this.cKy = new s(this.ajP);
        this.cKz = new com.baidu.tieba.homepage.alalivelist.a.d(this.ajP, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cKA = new com.baidu.tieba.homepage.alalivelist.a.f(this.ajP, com.baidu.tieba.homepage.alalivelist.view.h.TYPE);
        this.cKB = new d(this.ajP, com.baidu.tieba.card.data.k.TYPE);
        this.cKo.add(this.cKq);
        this.cKo.add(this.cKr);
        this.cKo.add(this.ckc);
        this.cKo.add(this.cKs);
        this.cKo.add(this.cKv);
        this.cKo.add(this.cKt);
        this.cKo.add(this.cKu);
        this.cKo.add(this.cKC);
        this.cKo.add(this.cKw);
        this.cKo.add(this.cKx);
        this.cKo.add(new aa(this.ajP.getPageActivity()));
        this.cKo.add(new x(this.ajP.getPageActivity()));
        this.cKo.add(this.cKy);
        this.cKo.add(new com.baidu.tieba.homepage.personalize.c.c(this.ajP, com.baidu.tieba.homepage.personalize.c.e.TYPE));
        this.cKo.add(this.cKz);
        this.cKo.add(this.cKA);
        this.cKo.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.ajP, com.baidu.tieba.homepage.alalivelist.a.c.cGE));
        this.cKo.add(this.cKB);
        afu();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cKt.a(fVar);
        this.cKv.a(fVar);
        this.cKw.a(fVar);
        this.cKx.a(fVar);
    }

    public void bg(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.s.q(list, 2);
        this.aRs.setData(list);
        this.cKp = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cKq.onChangeSkinType(i);
        this.cKy.ky(i);
    }

    public void notifyDataSetChanged() {
        if (this.aRs != null && (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cKt != null) {
            this.cKt.setFromCDN(z);
        }
        if (this.cKw != null) {
            this.cKw.setFromCDN(z);
        }
        if (this.cKs != null && (this.cKs instanceof com.baidu.tieba.recapp.w)) {
            ((com.baidu.tieba.recapp.w) this.cKs).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cKt != null) {
            this.cKt.aMp = bdUniqueId;
        }
        if (this.cKu != null) {
            this.cKu.aMp = bdUniqueId;
        }
        if (this.cKv != null) {
            this.cKv.aMp = bdUniqueId;
        }
        if (this.cKC != null) {
            this.cKC.aMp = bdUniqueId;
        }
        if (this.cKq != null) {
            this.cKq.setPageUniqueId(bdUniqueId);
        }
        if (this.cKw != null) {
            this.cKw.aMp = bdUniqueId;
        }
        if (this.cKx != null) {
            this.cKx.aMp = bdUniqueId;
        }
        if (this.cKy != null) {
            this.cKy.aMp = bdUniqueId;
        }
        if (this.cKz != null) {
            this.cKz.aMp = bdUniqueId;
        }
        if (this.cKA != null) {
            this.cKA.aMp = bdUniqueId;
        }
        if (this.cKB != null) {
            this.cKB.aMp = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.z.t(this.cgf)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cgf) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.anV.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.anV);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cKE) {
            this.cgn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cgn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Object obj) {
        if (this.cKp != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cKp) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void afu() {
        this.cKE = afv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afv() {
        if (this.cgf == null || this.cgf.size() <= 0) {
            this.cgf = new ArrayList();
            ArrayList<BdUniqueId> blE = com.baidu.tieba.tbadkCore.s.blE();
            if (blE == null || blE.size() <= 0) {
                return false;
            }
            int size = blE.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aBU().a(this.ajP, blE.get(i), 2);
                if (this.cKD) {
                    a.setBusinessType(3);
                }
                if (this.cKt != null && this.cKt.aMp != null) {
                    a.setUniqueId(this.cKt.aMp);
                }
                this.cgf.add(a);
            }
            this.aRs.addAdapters(this.cgf);
            return true;
        }
        return true;
    }

    public void a(o.a aVar) {
        if (this.cKt != null) {
            this.cKt.setEventCallback(aVar);
        }
        if (this.cKu != null) {
            this.cKu.setEventCallback(aVar);
        }
        if (this.cKC != null) {
            this.cKC.setEventCallback(aVar);
        }
        if (this.cKv != null) {
            this.cKv.setEventCallback(aVar);
        }
        if (this.cKB != null) {
            this.cKB.setEventCallback(aVar);
        }
    }
}

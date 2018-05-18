package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    private BdTypeListView dBl;
    private List<com.baidu.adp.widget.ListView.h> dFN;
    private a dFO;
    private j dFP;
    private f dFQ;
    private e dFR;
    private i dFS;
    private g dFT;
    private b dFU;
    private h dFV;
    private f dFW;
    private i dFX;
    private d dFY;
    private com.baidu.adp.widget.ListView.a dFZ;
    private com.baidu.adp.widget.ListView.a dGa;
    private com.baidu.adp.widget.ListView.a dGb;
    private com.baidu.adp.widget.ListView.a dGc;
    private com.baidu.adp.widget.ListView.a dGd;
    private com.baidu.adp.widget.ListView.a dGe;
    private boolean dGf;
    private boolean dGg;
    private List<com.baidu.adp.widget.ListView.a> dem;
    private com.baidu.adp.widget.ListView.a dmM;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dew = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.arJ();
                if (l.this.dFN != null) {
                    l.this.af(l.this.dFN);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Ai) {
                l.this.T(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.homepage.personalize.a.l.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.eAJ = true;
                l.this.T(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.homepage.personalize.a.l.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.eAJ = false;
                l.this.T(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dBk = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.dBl = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        bp(context);
        bdTypeListView.addAdapters(this.dBk);
    }

    private void bp(Context context) {
        this.dFO = new a(this.mPageContext);
        this.dFP = new j(this.mPageContext);
        this.dFQ = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.dFR = new e(this.mPageContext, com.baidu.tieba.card.data.k.ZI);
        this.dFS = new i(this.mPageContext, com.baidu.tieba.card.data.l.cti);
        this.dFT = new g(this.mPageContext);
        this.dFU = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.dFV = new h(this.mPageContext, com.baidu.tieba.card.data.k.ZO);
        this.dFW = new f(this.mPageContext, com.baidu.tieba.card.data.k.cte);
        this.dFX = new i(this.mPageContext, com.baidu.tieba.card.data.l.ctj);
        this.dFY = new d(this.mPageContext, com.baidu.tieba.card.data.k.ctf);
        this.dBk.add(this.dFO);
        this.dBk.add(this.dFP);
        this.dBk.add(this.dFS);
        this.dBk.add(this.dFQ);
        this.dBk.add(this.dFR);
        this.dBk.add(this.dFT);
        this.dBk.add(this.dFW);
        this.dBk.add(this.dFX);
        this.dBk.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dBk.add(this.dFU);
        this.dBk.add(this.dFV);
        this.dBk.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.dBk.add(this.dFY);
        arI();
        axY();
        hZ("page_recommend");
    }

    private void axY() {
        if (!bd.ZS.get()) {
            AdvertAppInfo.VJ.set(false);
            return;
        }
        this.dmM = r.bjk().c(this.mPageContext, AdvertAppInfo.VA);
        this.dFZ = r.bjk().c(this.mPageContext, AdvertAppInfo.VD);
        this.dGa = r.bjk().c(this.mPageContext, AdvertAppInfo.VE);
        this.dGb = r.bjk().c(this.mPageContext, AdvertAppInfo.VF);
        this.dGc = r.bjk().c(this.mPageContext, AdvertAppInfo.VG);
        this.dGd = r.bjk().c(this.mPageContext, AdvertAppInfo.VH);
        this.dGe = r.bjk().c(this.mPageContext, AdvertAppInfo.VI);
        this.dBk.add(this.dmM);
        this.dBk.add(this.dFZ);
        this.dBk.add(this.dGa);
        this.dBk.add(this.dGb);
        this.dBk.add(this.dGc);
        this.dBk.add(this.dGd);
        this.dBk.add(this.dGe);
        AdvertAppInfo.VJ.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dFQ.a(eVar);
        this.dFS.a(eVar);
    }

    public void af(List<com.baidu.adp.widget.ListView.h> list) {
        q.n(list, 2);
        this.dBl.setData(list);
        this.dFN = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dFO.onChangeSkinType(i);
        this.dFT.mm(i);
    }

    public void notifyDataSetChanged() {
        if (this.dBl != null && (this.dBl.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dBl.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dFQ != null) {
            this.dFQ.setFromCDN(z);
        }
        if (this.dFZ != null && (this.dFZ instanceof m)) {
            ((m) this.dFZ).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dFQ != null) {
            this.dFQ.aTs = bdUniqueId;
        }
        if (this.dFR != null) {
            this.dFR.aTs = bdUniqueId;
        }
        if (this.dFS != null) {
            this.dFS.aTs = bdUniqueId;
        }
        if (this.dFO != null) {
            this.dFO.setPageUniqueId(bdUniqueId);
        }
        if (this.dFT != null) {
            this.dFT.aTs = bdUniqueId;
        }
        if (this.dFU != null) {
            this.dFU.aTs = bdUniqueId;
        }
        if (this.dFV != null) {
            this.dFV.aTs = bdUniqueId;
        }
        if (this.dFW != null) {
            this.dFW.aTs = bdUniqueId;
        }
        if (this.dFX != null) {
            this.dFX.aTs = bdUniqueId;
        }
        if (!v.w(this.dem)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dem) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.mAttentionListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.dGg) {
            this.dew.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dew);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dFN != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dFN.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof ICardInfo) && ((ICardInfo) next).responseAttention(obj)) {
                    z = true;
                }
                z2 = z;
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void arI() {
        this.dGg = arJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arJ() {
        if (this.dem == null || this.dem.size() <= 0) {
            this.dem = new ArrayList();
            ArrayList<BdUniqueId> brl = q.brl();
            if (brl == null || brl.size() <= 0) {
                return false;
            }
            int size = brl.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aMd().a(this.mPageContext, brl.get(i), 2);
                if (this.dGf) {
                    a.setBusinessType(3);
                }
                if (this.dFQ != null && this.dFQ.aTs != null) {
                    a.setUniqueId(this.dFQ.aTs);
                }
                this.dem.add(a);
            }
            this.dBl.addAdapters(this.dem);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.dFQ != null) {
            this.dFQ.setEventCallback(aVar);
        }
        if (this.dFR != null) {
            this.dFR.setEventCallback(aVar);
        }
        if (this.dFS != null) {
            this.dFS.setEventCallback(aVar);
        }
        if (this.dFU != null) {
            this.dFU.setEventCallback(aVar);
        }
        if (this.dFV != null) {
            this.dFV.setEventCallback(aVar);
        }
        if (this.dFW != null) {
            this.dFW.setEventCallback(aVar);
        }
        if (this.dFX != null) {
            this.dFX.setEventCallback(aVar);
        }
    }

    private void hZ(String str) {
        if (this.dBk != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dBk) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).hZ(str);
                }
            }
        }
    }
}

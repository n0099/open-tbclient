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
    private BdTypeListView dAe;
    private List<com.baidu.adp.widget.ListView.h> dEH;
    private a dEI;
    private j dEJ;
    private f dEK;
    private e dEL;
    private i dEM;
    private g dEN;
    private b dEO;
    private h dEP;
    private f dEQ;
    private i dER;
    private d dES;
    private com.baidu.adp.widget.ListView.a dET;
    private com.baidu.adp.widget.ListView.a dEU;
    private com.baidu.adp.widget.ListView.a dEV;
    private com.baidu.adp.widget.ListView.a dEW;
    private com.baidu.adp.widget.ListView.a dEX;
    private com.baidu.adp.widget.ListView.a dEY;
    private boolean dEZ;
    private boolean dFa;
    private List<com.baidu.adp.widget.ListView.a> dde;
    private com.baidu.adp.widget.ListView.a dlF;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener ddn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.arK();
                if (l.this.dEH != null) {
                    l.this.af(l.this.dEH);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Aj) {
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
                bVar.ezB = true;
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
                bVar.ezB = false;
                l.this.T(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dAd = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.dAe = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        bp(context);
        bdTypeListView.addAdapters(this.dAd);
    }

    private void bp(Context context) {
        this.dEI = new a(this.mPageContext);
        this.dEJ = new j(this.mPageContext);
        this.dEK = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.dEL = new e(this.mPageContext, com.baidu.tieba.card.data.k.ZI);
        this.dEM = new i(this.mPageContext, com.baidu.tieba.card.data.l.crZ);
        this.dEN = new g(this.mPageContext);
        this.dEO = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.dEP = new h(this.mPageContext, com.baidu.tieba.card.data.k.ZO);
        this.dEQ = new f(this.mPageContext, com.baidu.tieba.card.data.k.crV);
        this.dER = new i(this.mPageContext, com.baidu.tieba.card.data.l.csa);
        this.dES = new d(this.mPageContext, com.baidu.tieba.card.data.k.crW);
        this.dAd.add(this.dEI);
        this.dAd.add(this.dEJ);
        this.dAd.add(this.dEM);
        this.dAd.add(this.dEK);
        this.dAd.add(this.dEL);
        this.dAd.add(this.dEN);
        this.dAd.add(this.dEQ);
        this.dAd.add(this.dER);
        this.dAd.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dAd.add(this.dEO);
        this.dAd.add(this.dEP);
        this.dAd.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.dAd.add(this.dES);
        arJ();
        aya();
        hY("page_recommend");
    }

    private void aya() {
        if (!bd.ZS.get()) {
            AdvertAppInfo.VN.set(false);
            return;
        }
        this.dlF = r.bjl().c(this.mPageContext, AdvertAppInfo.VE);
        this.dET = r.bjl().c(this.mPageContext, AdvertAppInfo.VH);
        this.dEU = r.bjl().c(this.mPageContext, AdvertAppInfo.VI);
        this.dEV = r.bjl().c(this.mPageContext, AdvertAppInfo.VJ);
        this.dEW = r.bjl().c(this.mPageContext, AdvertAppInfo.VK);
        this.dEX = r.bjl().c(this.mPageContext, AdvertAppInfo.VL);
        this.dEY = r.bjl().c(this.mPageContext, AdvertAppInfo.VM);
        this.dAd.add(this.dlF);
        this.dAd.add(this.dET);
        this.dAd.add(this.dEU);
        this.dAd.add(this.dEV);
        this.dAd.add(this.dEW);
        this.dAd.add(this.dEX);
        this.dAd.add(this.dEY);
        AdvertAppInfo.VN.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dEK.a(eVar);
        this.dEM.a(eVar);
    }

    public void af(List<com.baidu.adp.widget.ListView.h> list) {
        q.n(list, 2);
        this.dAe.setData(list);
        this.dEH = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dEI.onChangeSkinType(i);
        this.dEN.mn(i);
    }

    public void notifyDataSetChanged() {
        if (this.dAe != null && (this.dAe.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dAe.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dEK != null) {
            this.dEK.setFromCDN(z);
        }
        if (this.dET != null && (this.dET instanceof m)) {
            ((m) this.dET).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dEK != null) {
            this.dEK.aTr = bdUniqueId;
        }
        if (this.dEL != null) {
            this.dEL.aTr = bdUniqueId;
        }
        if (this.dEM != null) {
            this.dEM.aTr = bdUniqueId;
        }
        if (this.dEI != null) {
            this.dEI.setPageUniqueId(bdUniqueId);
        }
        if (this.dEN != null) {
            this.dEN.aTr = bdUniqueId;
        }
        if (this.dEO != null) {
            this.dEO.aTr = bdUniqueId;
        }
        if (this.dEP != null) {
            this.dEP.aTr = bdUniqueId;
        }
        if (this.dEQ != null) {
            this.dEQ.aTr = bdUniqueId;
        }
        if (this.dER != null) {
            this.dER.aTr = bdUniqueId;
        }
        if (!v.w(this.dde)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dde) {
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
        if (!this.dFa) {
            this.ddn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ddn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dEH != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dEH.iterator();
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

    private void arJ() {
        this.dFa = arK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arK() {
        if (this.dde == null || this.dde.size() <= 0) {
            this.dde = new ArrayList();
            ArrayList<BdUniqueId> brn = q.brn();
            if (brn == null || brn.size() <= 0) {
                return false;
            }
            int size = brn.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aMe().a(this.mPageContext, brn.get(i), 2);
                if (this.dEZ) {
                    a.setBusinessType(3);
                }
                if (this.dEK != null && this.dEK.aTr != null) {
                    a.setUniqueId(this.dEK.aTr);
                }
                this.dde.add(a);
            }
            this.dAe.addAdapters(this.dde);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.dEK != null) {
            this.dEK.setEventCallback(aVar);
        }
        if (this.dEL != null) {
            this.dEL.setEventCallback(aVar);
        }
        if (this.dEM != null) {
            this.dEM.setEventCallback(aVar);
        }
        if (this.dEO != null) {
            this.dEO.setEventCallback(aVar);
        }
        if (this.dEP != null) {
            this.dEP.setEventCallback(aVar);
        }
        if (this.dEQ != null) {
            this.dEQ.setEventCallback(aVar);
        }
        if (this.dER != null) {
            this.dER.setEventCallback(aVar);
        }
    }

    private void hY(String str) {
        if (this.dAd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dAd) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).hY(str);
                }
            }
        }
    }
}

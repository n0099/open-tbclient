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
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> dJX;
    private com.baidu.adp.widget.ListView.a dRs;
    private BdTypeListView efl;
    private List<com.baidu.adp.widget.ListView.i> ejP;
    private a ejQ;
    private j ejR;
    private f ejS;
    private e ejT;
    private i ejU;
    private g ejV;
    private c ejW;
    private b ejX;
    private h ejY;
    private f ejZ;
    private i eka;
    private com.baidu.adp.widget.ListView.a ekb;
    private com.baidu.adp.widget.ListView.a ekc;
    private com.baidu.adp.widget.ListView.a ekd;
    private com.baidu.adp.widget.ListView.a eke;
    private com.baidu.adp.widget.ListView.a ekf;
    private com.baidu.adp.widget.ListView.a ekg;
    private boolean ekh;
    private boolean eki;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dKg = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.axk();
                if (l.this.ejP != null) {
                    l.this.ao(l.this.ejP);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apG) {
                l.this.aY(updateAttentionMessage.getData());
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
                bVar.feC = true;
                l.this.aY(bVar);
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
                bVar.feC = false;
                l.this.aY(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> efk = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.efl = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ak(context);
        bB(context);
        bdTypeListView.addAdapters(this.efk);
    }

    private void bB(Context context) {
        this.ejQ = new a(this.mPageContext);
        this.ejR = new j(this.mPageContext);
        this.ejS = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ejT = new e(this.mPageContext, com.baidu.tieba.card.data.k.aOk);
        this.ejU = new i(this.mPageContext, m.dae);
        this.ejX = new b(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.ejV = new g(this.mPageContext);
        this.ejW = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.ejY = new h(this.mPageContext, com.baidu.tieba.card.data.k.aOq);
        this.ejZ = new f(this.mPageContext, com.baidu.tieba.card.data.k.cZX);
        this.eka = new i(this.mPageContext, m.daf);
        this.efk.add(this.ejQ);
        this.efk.add(this.ejR);
        this.efk.add(this.ejU);
        this.efk.add(this.ejS);
        this.efk.add(this.ejT);
        this.efk.add(this.ejX);
        this.efk.add(this.ejV);
        this.efk.add(this.ejZ);
        this.efk.add(this.eka);
        this.efk.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.efk.add(this.ejW);
        this.efk.add(this.ejY);
        this.efk.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        axj();
        aDb();
    }

    private void aDb() {
        if (!bd.aOt.get()) {
            AdvertAppInfo.aKs.set(false);
            return;
        }
        this.dRs = r.boe().c(this.mPageContext, AdvertAppInfo.aKj);
        this.ekb = r.boe().c(this.mPageContext, AdvertAppInfo.aKm);
        this.ekc = r.boe().c(this.mPageContext, AdvertAppInfo.aKn);
        this.ekd = r.boe().c(this.mPageContext, AdvertAppInfo.aKo);
        this.eke = r.boe().c(this.mPageContext, AdvertAppInfo.aKp);
        this.ekf = r.boe().c(this.mPageContext, AdvertAppInfo.aKq);
        this.ekg = r.boe().c(this.mPageContext, AdvertAppInfo.aKr);
        this.efk.add(this.dRs);
        this.efk.add(this.ekb);
        this.efk.add(this.ekc);
        this.efk.add(this.ekd);
        this.efk.add(this.eke);
        this.efk.add(this.ekf);
        this.efk.add(this.ekg);
        AdvertAppInfo.aKs.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ejS.a(eVar);
        this.ejU.a(eVar);
    }

    public void ao(List<com.baidu.adp.widget.ListView.i> list) {
        q.r(list, 2);
        this.efl.setData(list);
        this.ejP = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.ejQ.onChangeSkinType(i);
        this.ejV.oO(i);
    }

    public void notifyDataSetChanged() {
        if (this.efl != null && (this.efl.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efl.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.ejS != null) {
            this.ejS.setFromCDN(z);
        }
        if (this.ekb != null && (this.ekb instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.ekb).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ejS != null) {
            this.ejS.bIv = bdUniqueId;
        }
        if (this.ejT != null) {
            this.ejT.bIv = bdUniqueId;
        }
        if (this.ejU != null) {
            this.ejU.bIv = bdUniqueId;
        }
        if (this.ejX != null) {
            this.ejX.bIv = bdUniqueId;
        }
        if (this.ejQ != null) {
            this.ejQ.setPageUniqueId(bdUniqueId);
        }
        if (this.ejV != null) {
            this.ejV.bIv = bdUniqueId;
        }
        if (this.ejW != null) {
            this.ejW.bIv = bdUniqueId;
        }
        if (this.ejY != null) {
            this.ejY.bIv = bdUniqueId;
        }
        if (this.ejZ != null) {
            this.ejZ.bIv = bdUniqueId;
        }
        if (this.eka != null) {
            this.eka.bIv = bdUniqueId;
        }
        if (!v.E(this.dJX)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dJX) {
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
        if (!this.eki) {
            this.dKg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dKg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.ejP != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.ejP.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
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

    private void axj() {
        this.eki = axk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axk() {
        if (this.dJX == null || this.dJX.size() <= 0) {
            this.dJX = new ArrayList();
            ArrayList<BdUniqueId> bwi = q.bwi();
            if (bwi == null || bwi.size() <= 0) {
                return false;
            }
            int size = bwi.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aRe().a(this.mPageContext, bwi.get(i), 2);
                if (this.ekh) {
                    a.setBusinessType(3);
                }
                if (this.ejS != null && this.ejS.bIv != null) {
                    a.setUniqueId(this.ejS.bIv);
                }
                this.dJX.add(a);
            }
            this.efl.addAdapters(this.dJX);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.ejS != null) {
            this.ejS.setEventCallback(aVar);
        }
        if (this.ejT != null) {
            this.ejT.setEventCallback(aVar);
        }
        if (this.ejX != null) {
            this.ejX.setEventCallback(aVar);
        }
        if (this.ejU != null) {
            this.ejU.setEventCallback(aVar);
        }
        if (this.ejW != null) {
            this.ejW.setEventCallback(aVar);
        }
        if (this.ejY != null) {
            this.ejY.setEventCallback(aVar);
        }
        if (this.ejZ != null) {
            this.ejZ.setEventCallback(aVar);
        }
        if (this.eka != null) {
            this.eka.setEventCallback(aVar);
        }
    }

    public void setCardShowType(int i) {
        this.ejS.setCardShowType(i);
        this.ejT.setCardShowType(i);
        this.ejU.setCardShowType(i);
        this.ejW.setCardShowType(i);
        this.ejY.setCardShowType(i);
        this.ejZ.setCardShowType(i);
        this.eka.setCardShowType(i);
    }
}

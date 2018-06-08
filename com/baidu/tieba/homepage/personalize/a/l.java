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
import com.baidu.tbadk.core.util.w;
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
    private BdTypeListView dMv;
    private List<com.baidu.adp.widget.ListView.h> dRd;
    private a dRe;
    private j dRf;
    private f dRg;
    private e dRh;
    private i dRi;
    private g dRj;
    private b dRk;
    private h dRl;
    private f dRm;
    private i dRn;
    private d dRo;
    private com.baidu.adp.widget.ListView.a dRp;
    private com.baidu.adp.widget.ListView.a dRq;
    private com.baidu.adp.widget.ListView.a dRr;
    private com.baidu.adp.widget.ListView.a dRs;
    private com.baidu.adp.widget.ListView.a dRt;
    private com.baidu.adp.widget.ListView.a dRu;
    private boolean dRv;
    private boolean dRw;
    private List<com.baidu.adp.widget.ListView.a> dnB;
    private com.baidu.adp.widget.ListView.a dwe;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dnK = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.avO();
                if (l.this.dRd != null) {
                    l.this.ai(l.this.dRd);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Gp) {
                l.this.W(updateAttentionMessage.getData());
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
                bVar.eMd = true;
                l.this.W(bVar);
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
                bVar.eMd = false;
                l.this.W(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dMu = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.dMv = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ad(context);
        bz(context);
        bdTypeListView.addAdapters(this.dMu);
    }

    private void bz(Context context) {
        this.dRe = new a(this.mPageContext);
        this.dRf = new j(this.mPageContext);
        this.dRg = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.dRh = new e(this.mPageContext, com.baidu.tieba.card.data.k.ahK);
        this.dRi = new i(this.mPageContext, com.baidu.tieba.card.data.l.cBN);
        this.dRj = new g(this.mPageContext);
        this.dRk = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.dRl = new h(this.mPageContext, com.baidu.tieba.card.data.k.ahQ);
        this.dRm = new f(this.mPageContext, com.baidu.tieba.card.data.k.cBJ);
        this.dRn = new i(this.mPageContext, com.baidu.tieba.card.data.l.cBO);
        this.dRo = new d(this.mPageContext, com.baidu.tieba.card.data.k.cBK);
        this.dMu.add(this.dRe);
        this.dMu.add(this.dRf);
        this.dMu.add(this.dRi);
        this.dMu.add(this.dRg);
        this.dMu.add(this.dRh);
        this.dMu.add(this.dRj);
        this.dMu.add(this.dRm);
        this.dMu.add(this.dRn);
        this.dMu.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dMu.add(this.dRk);
        this.dMu.add(this.dRl);
        this.dMu.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.dMu.add(this.dRo);
        avN();
        aCT();
        iy("page_recommend");
    }

    private void aCT() {
        if (!bd.ahU.get()) {
            AdvertAppInfo.adJ.set(false);
            return;
        }
        this.dwe = r.boj().c(this.mPageContext, AdvertAppInfo.adA);
        this.dRp = r.boj().c(this.mPageContext, AdvertAppInfo.adD);
        this.dRq = r.boj().c(this.mPageContext, AdvertAppInfo.adE);
        this.dRr = r.boj().c(this.mPageContext, AdvertAppInfo.adF);
        this.dRs = r.boj().c(this.mPageContext, AdvertAppInfo.adG);
        this.dRt = r.boj().c(this.mPageContext, AdvertAppInfo.adH);
        this.dRu = r.boj().c(this.mPageContext, AdvertAppInfo.adI);
        this.dMu.add(this.dwe);
        this.dMu.add(this.dRp);
        this.dMu.add(this.dRq);
        this.dMu.add(this.dRr);
        this.dMu.add(this.dRs);
        this.dMu.add(this.dRt);
        this.dMu.add(this.dRu);
        AdvertAppInfo.adJ.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dRg.a(eVar);
        this.dRi.a(eVar);
    }

    public void ai(List<com.baidu.adp.widget.ListView.h> list) {
        q.o(list, 2);
        this.dMv.setData(list);
        this.dRd = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dRe.onChangeSkinType(i);
        this.dRj.my(i);
    }

    public void notifyDataSetChanged() {
        if (this.dMv != null && (this.dMv.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dMv.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dRg != null) {
            this.dRg.setFromCDN(z);
        }
        if (this.dRp != null && (this.dRp instanceof m)) {
            ((m) this.dRp).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dRg != null) {
            this.dRg.aQJ = bdUniqueId;
        }
        if (this.dRh != null) {
            this.dRh.aQJ = bdUniqueId;
        }
        if (this.dRi != null) {
            this.dRi.aQJ = bdUniqueId;
        }
        if (this.dRe != null) {
            this.dRe.setPageUniqueId(bdUniqueId);
        }
        if (this.dRj != null) {
            this.dRj.aQJ = bdUniqueId;
        }
        if (this.dRk != null) {
            this.dRk.aQJ = bdUniqueId;
        }
        if (this.dRl != null) {
            this.dRl.aQJ = bdUniqueId;
        }
        if (this.dRm != null) {
            this.dRm.aQJ = bdUniqueId;
        }
        if (this.dRn != null) {
            this.dRn.aQJ = bdUniqueId;
        }
        if (!w.z(this.dnB)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dnB) {
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
        if (!this.dRw) {
            this.dnK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dnK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dRd != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dRd.iterator();
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

    private void avN() {
        this.dRw = avO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avO() {
        if (this.dnB == null || this.dnB.size() <= 0) {
            this.dnB = new ArrayList();
            ArrayList<BdUniqueId> bwn = q.bwn();
            if (bwn == null || bwn.size() <= 0) {
                return false;
            }
            int size = bwn.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aRa().a(this.mPageContext, bwn.get(i), 2);
                if (this.dRv) {
                    a.setBusinessType(3);
                }
                if (this.dRg != null && this.dRg.aQJ != null) {
                    a.setUniqueId(this.dRg.aQJ);
                }
                this.dnB.add(a);
            }
            this.dMv.addAdapters(this.dnB);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.dRg != null) {
            this.dRg.setEventCallback(aVar);
        }
        if (this.dRh != null) {
            this.dRh.setEventCallback(aVar);
        }
        if (this.dRi != null) {
            this.dRi.setEventCallback(aVar);
        }
        if (this.dRk != null) {
            this.dRk.setEventCallback(aVar);
        }
        if (this.dRl != null) {
            this.dRl.setEventCallback(aVar);
        }
        if (this.dRm != null) {
            this.dRm.setEventCallback(aVar);
        }
        if (this.dRn != null) {
            this.dRn.setEventCallback(aVar);
        }
    }

    private void iy(String str) {
        if (this.dMu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dMu) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iy(str);
                }
            }
        }
    }
}

package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    private com.baidu.adp.widget.ListView.a dBX;
    private e dYA;
    private i dYB;
    private g dYC;
    private b dYD;
    private h dYE;
    private f dYF;
    private i dYG;
    private d dYH;
    private com.baidu.adp.widget.ListView.a dYI;
    private com.baidu.adp.widget.ListView.a dYJ;
    private com.baidu.adp.widget.ListView.a dYK;
    private com.baidu.adp.widget.ListView.a dYL;
    private com.baidu.adp.widget.ListView.a dYM;
    private com.baidu.adp.widget.ListView.a dYN;
    private boolean dYO;
    private boolean dYP;
    private m dYv;
    private List<com.baidu.adp.widget.ListView.h> dYw;
    private a dYx;
    private j dYy;
    private f dYz;
    private List<com.baidu.adp.widget.ListView.a> dtu;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dtD = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.awW();
                if (l.this.dYw != null) {
                    l.this.ai(l.this.dYw);
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
                l.this.Y(updateAttentionMessage.getData());
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
                bVar.ahp = true;
                l.this.Y(bVar);
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
                bVar.ahp = false;
                l.this.Y(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dSs = new ArrayList();

    public l(Context context, m mVar) {
        this.dYv = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ad(context);
        bz(context);
        mVar.addAdapters(this.dSs);
    }

    private void bz(Context context) {
        this.dYx = new a(this.mPageContext);
        this.dYy = new j(this.mPageContext);
        this.dYz = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.dYA = new e(this.mPageContext, com.baidu.tieba.card.data.k.ahy);
        this.dYB = new i(this.mPageContext, com.baidu.tieba.card.data.l.cCk);
        this.dYC = new g(this.mPageContext);
        this.dYD = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.dYE = new h(this.mPageContext, com.baidu.tieba.card.data.k.ahE);
        this.dYF = new f(this.mPageContext, com.baidu.tieba.card.data.k.cCg);
        this.dYG = new i(this.mPageContext, com.baidu.tieba.card.data.l.cCl);
        this.dYH = new d(this.mPageContext, com.baidu.tieba.card.data.k.cCh);
        this.dSs.add(this.dYx);
        this.dSs.add(this.dYy);
        this.dSs.add(this.dYB);
        this.dSs.add(this.dYz);
        this.dSs.add(this.dYA);
        this.dSs.add(this.dYC);
        this.dSs.add(this.dYF);
        this.dSs.add(this.dYG);
        this.dSs.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dSs.add(this.dYD);
        this.dSs.add(this.dYE);
        this.dSs.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.dSs.add(this.dYH);
        awV();
        aEv();
        iB("page_recommend");
    }

    private void aEv() {
        if (!bb.ahJ.get()) {
            AdvertAppInfo.adC.set(false);
            return;
        }
        this.dBX = r.bno().c(this.mPageContext, AdvertAppInfo.adt);
        this.dYI = r.bno().c(this.mPageContext, AdvertAppInfo.adw);
        this.dYJ = r.bno().c(this.mPageContext, AdvertAppInfo.adx);
        this.dYK = r.bno().c(this.mPageContext, AdvertAppInfo.ady);
        this.dYL = r.bno().c(this.mPageContext, AdvertAppInfo.adz);
        this.dYM = r.bno().c(this.mPageContext, AdvertAppInfo.adA);
        this.dYN = r.bno().c(this.mPageContext, AdvertAppInfo.adB);
        this.dSs.add(this.dBX);
        this.dSs.add(this.dYI);
        this.dSs.add(this.dYJ);
        this.dSs.add(this.dYK);
        this.dSs.add(this.dYL);
        this.dSs.add(this.dYM);
        this.dSs.add(this.dYN);
        AdvertAppInfo.adC.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dYz.a(eVar);
        this.dYB.a(eVar);
    }

    public void ai(List<com.baidu.adp.widget.ListView.h> list) {
        q.p(list, 2);
        this.dYv.setData(list);
        this.dYw = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dYx.onChangeSkinType(i);
        this.dYC.mT(i);
    }

    public void notifyDataSetChanged() {
        if (this.dYv != null) {
            this.dYv.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dYz != null) {
            this.dYz.setFromCDN(z);
        }
        if (this.dYI != null && (this.dYI instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dYI).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dYz != null) {
            this.dYz.aRC = bdUniqueId;
        }
        if (this.dYA != null) {
            this.dYA.aRC = bdUniqueId;
        }
        if (this.dYB != null) {
            this.dYB.aRC = bdUniqueId;
        }
        if (this.dYx != null) {
            this.dYx.setPageUniqueId(bdUniqueId);
        }
        if (this.dYC != null) {
            this.dYC.aRC = bdUniqueId;
        }
        if (this.dYD != null) {
            this.dYD.aRC = bdUniqueId;
        }
        if (this.dYE != null) {
            this.dYE.aRC = bdUniqueId;
        }
        if (this.dYF != null) {
            this.dYF.aRC = bdUniqueId;
        }
        if (this.dYG != null) {
            this.dYG.aRC = bdUniqueId;
        }
        if (!w.z(this.dtu)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dtu) {
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
        if (!this.dYP) {
            this.dtD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dtD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dYw != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dYw.iterator();
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

    private void awV() {
        this.dYP = awW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awW() {
        if (this.dtu == null || this.dtu.size() <= 0) {
            this.dtu = new ArrayList();
            ArrayList<BdUniqueId> bvt = q.bvt();
            if (bvt == null || bvt.size() <= 0) {
                return false;
            }
            int size = bvt.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aSF().a(this.mPageContext, bvt.get(i), 2);
                if (this.dYO) {
                    a.setBusinessType(3);
                }
                if (this.dYz != null && this.dYz.aRC != null) {
                    a.setUniqueId(this.dYz.aRC);
                }
                this.dtu.add(a);
            }
            this.dYv.addAdapters(this.dtu);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.dYz != null) {
            this.dYz.setEventCallback(aVar);
        }
        if (this.dYA != null) {
            this.dYA.setEventCallback(aVar);
        }
        if (this.dYB != null) {
            this.dYB.setEventCallback(aVar);
        }
        if (this.dYD != null) {
            this.dYD.setEventCallback(aVar);
        }
        if (this.dYE != null) {
            this.dYE.setEventCallback(aVar);
        }
        if (this.dYF != null) {
            this.dYF.setEventCallback(aVar);
        }
        if (this.dYG != null) {
            this.dYG.setEventCallback(aVar);
        }
    }

    private void iB(String str) {
        if (this.dSs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dSs) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iB(str);
                }
            }
        }
    }
}

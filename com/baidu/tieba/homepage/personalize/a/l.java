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
    private com.baidu.adp.widget.ListView.a dCa;
    private a dYA;
    private j dYB;
    private f dYC;
    private e dYD;
    private i dYE;
    private g dYF;
    private b dYG;
    private h dYH;
    private f dYI;
    private i dYJ;
    private d dYK;
    private com.baidu.adp.widget.ListView.a dYL;
    private com.baidu.adp.widget.ListView.a dYM;
    private com.baidu.adp.widget.ListView.a dYN;
    private com.baidu.adp.widget.ListView.a dYO;
    private com.baidu.adp.widget.ListView.a dYP;
    private com.baidu.adp.widget.ListView.a dYQ;
    private boolean dYR;
    private boolean dYS;
    private m dYy;
    private List<com.baidu.adp.widget.ListView.h> dYz;
    private List<com.baidu.adp.widget.ListView.a> dtx;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dtG = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.awX();
                if (l.this.dYz != null) {
                    l.this.ai(l.this.dYz);
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
    private List<com.baidu.adp.widget.ListView.a> dSx = new ArrayList();

    public l(Context context, m mVar) {
        this.dYy = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ad(context);
        bz(context);
        mVar.addAdapters(this.dSx);
    }

    private void bz(Context context) {
        this.dYA = new a(this.mPageContext);
        this.dYB = new j(this.mPageContext);
        this.dYC = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.dYD = new e(this.mPageContext, com.baidu.tieba.card.data.k.ahy);
        this.dYE = new i(this.mPageContext, com.baidu.tieba.card.data.l.cCn);
        this.dYF = new g(this.mPageContext);
        this.dYG = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.dYH = new h(this.mPageContext, com.baidu.tieba.card.data.k.ahE);
        this.dYI = new f(this.mPageContext, com.baidu.tieba.card.data.k.cCj);
        this.dYJ = new i(this.mPageContext, com.baidu.tieba.card.data.l.cCo);
        this.dYK = new d(this.mPageContext, com.baidu.tieba.card.data.k.cCk);
        this.dSx.add(this.dYA);
        this.dSx.add(this.dYB);
        this.dSx.add(this.dYE);
        this.dSx.add(this.dYC);
        this.dSx.add(this.dYD);
        this.dSx.add(this.dYF);
        this.dSx.add(this.dYI);
        this.dSx.add(this.dYJ);
        this.dSx.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dSx.add(this.dYG);
        this.dSx.add(this.dYH);
        this.dSx.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.dSx.add(this.dYK);
        awW();
        aEy();
        iA("page_recommend");
    }

    private void aEy() {
        if (!bb.ahJ.get()) {
            AdvertAppInfo.adC.set(false);
            return;
        }
        this.dCa = r.bnn().c(this.mPageContext, AdvertAppInfo.adt);
        this.dYL = r.bnn().c(this.mPageContext, AdvertAppInfo.adw);
        this.dYM = r.bnn().c(this.mPageContext, AdvertAppInfo.adx);
        this.dYN = r.bnn().c(this.mPageContext, AdvertAppInfo.ady);
        this.dYO = r.bnn().c(this.mPageContext, AdvertAppInfo.adz);
        this.dYP = r.bnn().c(this.mPageContext, AdvertAppInfo.adA);
        this.dYQ = r.bnn().c(this.mPageContext, AdvertAppInfo.adB);
        this.dSx.add(this.dCa);
        this.dSx.add(this.dYL);
        this.dSx.add(this.dYM);
        this.dSx.add(this.dYN);
        this.dSx.add(this.dYO);
        this.dSx.add(this.dYP);
        this.dSx.add(this.dYQ);
        AdvertAppInfo.adC.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dYC.a(eVar);
        this.dYE.a(eVar);
    }

    public void ai(List<com.baidu.adp.widget.ListView.h> list) {
        q.p(list, 2);
        this.dYy.setData(list);
        this.dYz = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dYA.onChangeSkinType(i);
        this.dYF.mT(i);
    }

    public void notifyDataSetChanged() {
        if (this.dYy != null) {
            this.dYy.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dYC != null) {
            this.dYC.setFromCDN(z);
        }
        if (this.dYL != null && (this.dYL instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dYL).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dYC != null) {
            this.dYC.aRF = bdUniqueId;
        }
        if (this.dYD != null) {
            this.dYD.aRF = bdUniqueId;
        }
        if (this.dYE != null) {
            this.dYE.aRF = bdUniqueId;
        }
        if (this.dYA != null) {
            this.dYA.setPageUniqueId(bdUniqueId);
        }
        if (this.dYF != null) {
            this.dYF.aRF = bdUniqueId;
        }
        if (this.dYG != null) {
            this.dYG.aRF = bdUniqueId;
        }
        if (this.dYH != null) {
            this.dYH.aRF = bdUniqueId;
        }
        if (this.dYI != null) {
            this.dYI.aRF = bdUniqueId;
        }
        if (this.dYJ != null) {
            this.dYJ.aRF = bdUniqueId;
        }
        if (!w.z(this.dtx)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dtx) {
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
        if (!this.dYS) {
            this.dtG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dtG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dYz != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dYz.iterator();
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

    private void awW() {
        this.dYS = awX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awX() {
        if (this.dtx == null || this.dtx.size() <= 0) {
            this.dtx = new ArrayList();
            ArrayList<BdUniqueId> bvs = q.bvs();
            if (bvs == null || bvs.size() <= 0) {
                return false;
            }
            int size = bvs.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aSI().a(this.mPageContext, bvs.get(i), 2);
                if (this.dYR) {
                    a.setBusinessType(3);
                }
                if (this.dYC != null && this.dYC.aRF != null) {
                    a.setUniqueId(this.dYC.aRF);
                }
                this.dtx.add(a);
            }
            this.dYy.addAdapters(this.dtx);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.dYC != null) {
            this.dYC.setEventCallback(aVar);
        }
        if (this.dYD != null) {
            this.dYD.setEventCallback(aVar);
        }
        if (this.dYE != null) {
            this.dYE.setEventCallback(aVar);
        }
        if (this.dYG != null) {
            this.dYG.setEventCallback(aVar);
        }
        if (this.dYH != null) {
            this.dYH.setEventCallback(aVar);
        }
        if (this.dYI != null) {
            this.dYI.setEventCallback(aVar);
        }
        if (this.dYJ != null) {
            this.dYJ.setEventCallback(aVar);
        }
    }

    private void iA(String str) {
        if (this.dSx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dSx) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iA(str);
                }
            }
        }
    }
}

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
    private BdTypeListView dAh;
    private List<com.baidu.adp.widget.ListView.h> dEK;
    private a dEL;
    private j dEM;
    private f dEN;
    private e dEO;
    private i dEP;
    private g dEQ;
    private b dER;
    private h dES;
    private f dET;
    private i dEU;
    private d dEV;
    private com.baidu.adp.widget.ListView.a dEW;
    private com.baidu.adp.widget.ListView.a dEX;
    private com.baidu.adp.widget.ListView.a dEY;
    private com.baidu.adp.widget.ListView.a dEZ;
    private com.baidu.adp.widget.ListView.a dFa;
    private com.baidu.adp.widget.ListView.a dFb;
    private boolean dFc;
    private boolean dFd;
    private List<com.baidu.adp.widget.ListView.a> ddh;
    private com.baidu.adp.widget.ListView.a dlI;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener ddq = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.arK();
                if (l.this.dEK != null) {
                    l.this.af(l.this.dEK);
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
                bVar.ezE = true;
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
                bVar.ezE = false;
                l.this.T(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dAg = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.dAh = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        bp(context);
        bdTypeListView.addAdapters(this.dAg);
    }

    private void bp(Context context) {
        this.dEL = new a(this.mPageContext);
        this.dEM = new j(this.mPageContext);
        this.dEN = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.dEO = new e(this.mPageContext, com.baidu.tieba.card.data.k.ZI);
        this.dEP = new i(this.mPageContext, com.baidu.tieba.card.data.l.csc);
        this.dEQ = new g(this.mPageContext);
        this.dER = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.dES = new h(this.mPageContext, com.baidu.tieba.card.data.k.ZO);
        this.dET = new f(this.mPageContext, com.baidu.tieba.card.data.k.crY);
        this.dEU = new i(this.mPageContext, com.baidu.tieba.card.data.l.csd);
        this.dEV = new d(this.mPageContext, com.baidu.tieba.card.data.k.crZ);
        this.dAg.add(this.dEL);
        this.dAg.add(this.dEM);
        this.dAg.add(this.dEP);
        this.dAg.add(this.dEN);
        this.dAg.add(this.dEO);
        this.dAg.add(this.dEQ);
        this.dAg.add(this.dET);
        this.dAg.add(this.dEU);
        this.dAg.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dAg.add(this.dER);
        this.dAg.add(this.dES);
        this.dAg.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.dAg.add(this.dEV);
        arJ();
        aya();
        hY("page_recommend");
    }

    private void aya() {
        if (!bd.ZS.get()) {
            AdvertAppInfo.VN.set(false);
            return;
        }
        this.dlI = r.bjl().c(this.mPageContext, AdvertAppInfo.VE);
        this.dEW = r.bjl().c(this.mPageContext, AdvertAppInfo.VH);
        this.dEX = r.bjl().c(this.mPageContext, AdvertAppInfo.VI);
        this.dEY = r.bjl().c(this.mPageContext, AdvertAppInfo.VJ);
        this.dEZ = r.bjl().c(this.mPageContext, AdvertAppInfo.VK);
        this.dFa = r.bjl().c(this.mPageContext, AdvertAppInfo.VL);
        this.dFb = r.bjl().c(this.mPageContext, AdvertAppInfo.VM);
        this.dAg.add(this.dlI);
        this.dAg.add(this.dEW);
        this.dAg.add(this.dEX);
        this.dAg.add(this.dEY);
        this.dAg.add(this.dEZ);
        this.dAg.add(this.dFa);
        this.dAg.add(this.dFb);
        AdvertAppInfo.VN.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dEN.a(eVar);
        this.dEP.a(eVar);
    }

    public void af(List<com.baidu.adp.widget.ListView.h> list) {
        q.n(list, 2);
        this.dAh.setData(list);
        this.dEK = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dEL.onChangeSkinType(i);
        this.dEQ.mn(i);
    }

    public void notifyDataSetChanged() {
        if (this.dAh != null && (this.dAh.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dAh.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dEN != null) {
            this.dEN.setFromCDN(z);
        }
        if (this.dEW != null && (this.dEW instanceof m)) {
            ((m) this.dEW).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dEN != null) {
            this.dEN.aTr = bdUniqueId;
        }
        if (this.dEO != null) {
            this.dEO.aTr = bdUniqueId;
        }
        if (this.dEP != null) {
            this.dEP.aTr = bdUniqueId;
        }
        if (this.dEL != null) {
            this.dEL.setPageUniqueId(bdUniqueId);
        }
        if (this.dEQ != null) {
            this.dEQ.aTr = bdUniqueId;
        }
        if (this.dER != null) {
            this.dER.aTr = bdUniqueId;
        }
        if (this.dES != null) {
            this.dES.aTr = bdUniqueId;
        }
        if (this.dET != null) {
            this.dET.aTr = bdUniqueId;
        }
        if (this.dEU != null) {
            this.dEU.aTr = bdUniqueId;
        }
        if (!v.w(this.ddh)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.ddh) {
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
        if (!this.dFd) {
            this.ddq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ddq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dEK != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dEK.iterator();
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
        this.dFd = arK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arK() {
        if (this.ddh == null || this.ddh.size() <= 0) {
            this.ddh = new ArrayList();
            ArrayList<BdUniqueId> brn = q.brn();
            if (brn == null || brn.size() <= 0) {
                return false;
            }
            int size = brn.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aMe().a(this.mPageContext, brn.get(i), 2);
                if (this.dFc) {
                    a.setBusinessType(3);
                }
                if (this.dEN != null && this.dEN.aTr != null) {
                    a.setUniqueId(this.dEN.aTr);
                }
                this.ddh.add(a);
            }
            this.dAh.addAdapters(this.ddh);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.dEN != null) {
            this.dEN.setEventCallback(aVar);
        }
        if (this.dEO != null) {
            this.dEO.setEventCallback(aVar);
        }
        if (this.dEP != null) {
            this.dEP.setEventCallback(aVar);
        }
        if (this.dER != null) {
            this.dER.setEventCallback(aVar);
        }
        if (this.dES != null) {
            this.dES.setEventCallback(aVar);
        }
        if (this.dET != null) {
            this.dET.setEventCallback(aVar);
        }
        if (this.dEU != null) {
            this.dEU.setEventCallback(aVar);
        }
    }

    private void hY(String str) {
        if (this.dAg != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dAg) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).hY(str);
                }
            }
        }
    }
}

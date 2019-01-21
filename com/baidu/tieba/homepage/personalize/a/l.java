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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> dTf;
    private com.baidu.adp.widget.ListView.a ebO;
    private m ezD;
    private List<com.baidu.adp.widget.ListView.h> ezE;
    private a ezF;
    private j ezG;
    private f ezH;
    private e ezI;
    private i ezJ;
    private g ezK;
    private b ezL;
    private h ezM;
    private f ezN;
    private i ezO;
    private d ezP;
    private com.baidu.adp.widget.ListView.a ezQ;
    private com.baidu.adp.widget.ListView.a ezR;
    private com.baidu.adp.widget.ListView.a ezS;
    private com.baidu.adp.widget.ListView.a ezT;
    private com.baidu.adp.widget.ListView.a ezU;
    private com.baidu.adp.widget.ListView.a ezV;
    private boolean ezW;
    private boolean ezX;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dTo = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.aEW();
                if (l.this.ezE != null) {
                    l.this.al(l.this.ezE);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jr) {
                l.this.ae(updateAttentionMessage.getData());
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
                bVar.atB = true;
                l.this.ae(bVar);
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
                bVar.atB = false;
                l.this.ae(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> etq = new ArrayList();

    public l(Context context, m mVar) {
        this.ezD = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        cs(context);
        mVar.addAdapters(this.etq);
    }

    private void cs(Context context) {
        this.ezF = new a(this.mPageContext);
        this.ezG = new j(this.mPageContext);
        this.ezH = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ezI = new e(this.mPageContext, com.baidu.tieba.card.data.k.atK);
        this.ezJ = new i(this.mPageContext, com.baidu.tieba.card.data.l.dbL);
        this.ezK = new g(this.mPageContext);
        this.ezL = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.ezM = new h(this.mPageContext, com.baidu.tieba.card.data.k.atQ);
        this.ezN = new f(this.mPageContext, com.baidu.tieba.card.data.k.dbH);
        this.ezO = new i(this.mPageContext, com.baidu.tieba.card.data.l.dbM);
        this.ezP = new d(this.mPageContext, com.baidu.tieba.card.data.k.dbI);
        this.etq.add(this.ezF);
        this.etq.add(this.ezG);
        this.etq.add(this.ezJ);
        this.etq.add(this.ezH);
        this.etq.add(this.ezI);
        this.etq.add(this.ezK);
        this.etq.add(this.ezN);
        this.etq.add(this.ezO);
        this.etq.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.etq.add(this.ezL);
        this.etq.add(this.ezM);
        this.etq.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.etq.add(this.ezP);
        aEV();
        aMF();
        kb("page_recommend");
    }

    private void aMF() {
        if (!bb.atV.get()) {
            AdvertAppInfo.apR.set(false);
            return;
        }
        this.ebO = r.bvT().c(this.mPageContext, AdvertAppInfo.apI);
        this.ezQ = r.bvT().c(this.mPageContext, AdvertAppInfo.apL);
        this.ezR = r.bvT().c(this.mPageContext, AdvertAppInfo.apM);
        this.ezS = r.bvT().c(this.mPageContext, AdvertAppInfo.apN);
        this.ezT = r.bvT().c(this.mPageContext, AdvertAppInfo.apO);
        this.ezU = r.bvT().c(this.mPageContext, AdvertAppInfo.apP);
        this.ezV = r.bvT().c(this.mPageContext, AdvertAppInfo.apQ);
        this.etq.add(this.ebO);
        this.etq.add(this.ezQ);
        this.etq.add(this.ezR);
        this.etq.add(this.ezS);
        this.etq.add(this.ezT);
        this.etq.add(this.ezU);
        this.etq.add(this.ezV);
        AdvertAppInfo.apR.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ezH.a(eVar);
        this.ezJ.a(eVar);
    }

    public void al(List<com.baidu.adp.widget.ListView.h> list) {
        q.q(list, 2);
        this.ezD.setData(list);
        this.ezE = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.ezF.onChangeSkinType(i);
        this.ezK.oV(i);
    }

    public void notifyDataSetChanged() {
        if (this.ezD != null) {
            this.ezD.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.ezH != null) {
            this.ezH.setFromCDN(z);
        }
        if (this.ezQ != null && (this.ezQ instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.ezQ).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ezH != null) {
            this.ezH.beu = bdUniqueId;
        }
        if (this.ezI != null) {
            this.ezI.beu = bdUniqueId;
        }
        if (this.ezJ != null) {
            this.ezJ.beu = bdUniqueId;
        }
        if (this.ezF != null) {
            this.ezF.setPageUniqueId(bdUniqueId);
        }
        if (this.ezK != null) {
            this.ezK.beu = bdUniqueId;
        }
        if (this.ezL != null) {
            this.ezL.beu = bdUniqueId;
        }
        if (this.ezM != null) {
            this.ezM.beu = bdUniqueId;
        }
        if (this.ezN != null) {
            this.ezN.beu = bdUniqueId;
        }
        if (this.ezO != null) {
            this.ezO.beu = bdUniqueId;
        }
        if (!v.I(this.dTf)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dTf) {
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
        if (!this.ezX) {
            this.dTo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dTo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.ezE != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.ezE.iterator();
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

    private void aEV() {
        this.ezX = aEW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEW() {
        if (this.dTf == null || this.dTf.size() <= 0) {
            this.dTf = new ArrayList();
            ArrayList<BdUniqueId> bEf = q.bEf();
            if (bEf == null || bEf.size() <= 0) {
                return false;
            }
            int size = bEf.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.baI().a(this.mPageContext, bEf.get(i), 2);
                if (this.ezW) {
                    a.setBusinessType(3);
                }
                if (this.ezH != null && this.ezH.beu != null) {
                    a.setUniqueId(this.ezH.beu);
                }
                this.dTf.add(a);
            }
            this.ezD.addAdapters(this.dTf);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.ezH != null) {
            this.ezH.setEventCallback(aVar);
        }
        if (this.ezI != null) {
            this.ezI.setEventCallback(aVar);
        }
        if (this.ezJ != null) {
            this.ezJ.setEventCallback(aVar);
        }
        if (this.ezL != null) {
            this.ezL.setEventCallback(aVar);
        }
        if (this.ezM != null) {
            this.ezM.setEventCallback(aVar);
        }
        if (this.ezN != null) {
            this.ezN.setEventCallback(aVar);
        }
        if (this.ezO != null) {
            this.ezO.setEventCallback(aVar);
        }
    }

    private void kb(String str) {
        if (this.etq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.etq) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).kb(str);
                }
            }
        }
    }
}

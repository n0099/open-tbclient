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
    private List<com.baidu.adp.widget.ListView.a> dTe;
    private com.baidu.adp.widget.ListView.a ebN;
    private m ezC;
    private List<com.baidu.adp.widget.ListView.h> ezD;
    private a ezE;
    private j ezF;
    private f ezG;
    private e ezH;
    private i ezI;
    private g ezJ;
    private b ezK;
    private h ezL;
    private f ezM;
    private i ezN;
    private d ezO;
    private com.baidu.adp.widget.ListView.a ezP;
    private com.baidu.adp.widget.ListView.a ezQ;
    private com.baidu.adp.widget.ListView.a ezR;
    private com.baidu.adp.widget.ListView.a ezS;
    private com.baidu.adp.widget.ListView.a ezT;
    private com.baidu.adp.widget.ListView.a ezU;
    private boolean ezV;
    private boolean ezW;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dTn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.aEW();
                if (l.this.ezD != null) {
                    l.this.al(l.this.ezD);
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
                bVar.atA = true;
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
                bVar.atA = false;
                l.this.ae(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> etp = new ArrayList();

    public l(Context context, m mVar) {
        this.ezC = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        cs(context);
        mVar.addAdapters(this.etp);
    }

    private void cs(Context context) {
        this.ezE = new a(this.mPageContext);
        this.ezF = new j(this.mPageContext);
        this.ezG = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ezH = new e(this.mPageContext, com.baidu.tieba.card.data.k.atJ);
        this.ezI = new i(this.mPageContext, com.baidu.tieba.card.data.l.dbK);
        this.ezJ = new g(this.mPageContext);
        this.ezK = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.ezL = new h(this.mPageContext, com.baidu.tieba.card.data.k.atP);
        this.ezM = new f(this.mPageContext, com.baidu.tieba.card.data.k.dbG);
        this.ezN = new i(this.mPageContext, com.baidu.tieba.card.data.l.dbL);
        this.ezO = new d(this.mPageContext, com.baidu.tieba.card.data.k.dbH);
        this.etp.add(this.ezE);
        this.etp.add(this.ezF);
        this.etp.add(this.ezI);
        this.etp.add(this.ezG);
        this.etp.add(this.ezH);
        this.etp.add(this.ezJ);
        this.etp.add(this.ezM);
        this.etp.add(this.ezN);
        this.etp.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.etp.add(this.ezK);
        this.etp.add(this.ezL);
        this.etp.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.etp.add(this.ezO);
        aEV();
        aMF();
        kb("page_recommend");
    }

    private void aMF() {
        if (!bb.atU.get()) {
            AdvertAppInfo.apQ.set(false);
            return;
        }
        this.ebN = r.bvT().c(this.mPageContext, AdvertAppInfo.apH);
        this.ezP = r.bvT().c(this.mPageContext, AdvertAppInfo.apK);
        this.ezQ = r.bvT().c(this.mPageContext, AdvertAppInfo.apL);
        this.ezR = r.bvT().c(this.mPageContext, AdvertAppInfo.apM);
        this.ezS = r.bvT().c(this.mPageContext, AdvertAppInfo.apN);
        this.ezT = r.bvT().c(this.mPageContext, AdvertAppInfo.apO);
        this.ezU = r.bvT().c(this.mPageContext, AdvertAppInfo.apP);
        this.etp.add(this.ebN);
        this.etp.add(this.ezP);
        this.etp.add(this.ezQ);
        this.etp.add(this.ezR);
        this.etp.add(this.ezS);
        this.etp.add(this.ezT);
        this.etp.add(this.ezU);
        AdvertAppInfo.apQ.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ezG.a(eVar);
        this.ezI.a(eVar);
    }

    public void al(List<com.baidu.adp.widget.ListView.h> list) {
        q.q(list, 2);
        this.ezC.setData(list);
        this.ezD = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.ezE.onChangeSkinType(i);
        this.ezJ.oV(i);
    }

    public void notifyDataSetChanged() {
        if (this.ezC != null) {
            this.ezC.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.ezG != null) {
            this.ezG.setFromCDN(z);
        }
        if (this.ezP != null && (this.ezP instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.ezP).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ezG != null) {
            this.ezG.bes = bdUniqueId;
        }
        if (this.ezH != null) {
            this.ezH.bes = bdUniqueId;
        }
        if (this.ezI != null) {
            this.ezI.bes = bdUniqueId;
        }
        if (this.ezE != null) {
            this.ezE.setPageUniqueId(bdUniqueId);
        }
        if (this.ezJ != null) {
            this.ezJ.bes = bdUniqueId;
        }
        if (this.ezK != null) {
            this.ezK.bes = bdUniqueId;
        }
        if (this.ezL != null) {
            this.ezL.bes = bdUniqueId;
        }
        if (this.ezM != null) {
            this.ezM.bes = bdUniqueId;
        }
        if (this.ezN != null) {
            this.ezN.bes = bdUniqueId;
        }
        if (!v.I(this.dTe)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dTe) {
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
        if (!this.ezW) {
            this.dTn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dTn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.ezD != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.ezD.iterator();
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
        this.ezW = aEW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEW() {
        if (this.dTe == null || this.dTe.size() <= 0) {
            this.dTe = new ArrayList();
            ArrayList<BdUniqueId> bEf = q.bEf();
            if (bEf == null || bEf.size() <= 0) {
                return false;
            }
            int size = bEf.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.baI().a(this.mPageContext, bEf.get(i), 2);
                if (this.ezV) {
                    a.setBusinessType(3);
                }
                if (this.ezG != null && this.ezG.bes != null) {
                    a.setUniqueId(this.ezG.bes);
                }
                this.dTe.add(a);
            }
            this.ezC.addAdapters(this.dTe);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.ezG != null) {
            this.ezG.setEventCallback(aVar);
        }
        if (this.ezH != null) {
            this.ezH.setEventCallback(aVar);
        }
        if (this.ezI != null) {
            this.ezI.setEventCallback(aVar);
        }
        if (this.ezK != null) {
            this.ezK.setEventCallback(aVar);
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
    }

    private void kb(String str) {
        if (this.etp != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.etp) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).kb(str);
                }
            }
        }
    }
}

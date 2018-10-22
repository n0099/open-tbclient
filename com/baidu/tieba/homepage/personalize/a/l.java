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
    private List<com.baidu.adp.widget.ListView.a> dIa;
    private com.baidu.adp.widget.ListView.a dQL;
    private m enL;
    private List<com.baidu.adp.widget.ListView.h> enM;
    private a enN;
    private j enO;
    private f enP;
    private e enQ;
    private i enR;
    private g enS;
    private b enT;
    private h enU;
    private f enV;
    private i enW;
    private d enX;
    private com.baidu.adp.widget.ListView.a enY;
    private com.baidu.adp.widget.ListView.a enZ;
    private com.baidu.adp.widget.ListView.a eoa;
    private com.baidu.adp.widget.ListView.a eob;
    private com.baidu.adp.widget.ListView.a eoc;
    private com.baidu.adp.widget.ListView.a eod;
    private boolean eoe;
    private boolean eog;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dIj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.aCE();
                if (l.this.enM != null) {
                    l.this.al(l.this.enM);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jo) {
                l.this.af(updateAttentionMessage.getData());
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
                bVar.aoK = true;
                l.this.af(bVar);
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
                bVar.aoK = false;
                l.this.af(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> ehD = new ArrayList();

    public l(Context context, m mVar) {
        this.enL = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        ct(context);
        mVar.addAdapters(this.ehD);
    }

    private void ct(Context context) {
        this.enN = new a(this.mPageContext);
        this.enO = new j(this.mPageContext);
        this.enP = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.enQ = new e(this.mPageContext, com.baidu.tieba.card.data.k.aoT);
        this.enR = new i(this.mPageContext, com.baidu.tieba.card.data.l.cQu);
        this.enS = new g(this.mPageContext);
        this.enT = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.enU = new h(this.mPageContext, com.baidu.tieba.card.data.k.aoZ);
        this.enV = new f(this.mPageContext, com.baidu.tieba.card.data.k.cQq);
        this.enW = new i(this.mPageContext, com.baidu.tieba.card.data.l.cQv);
        this.enX = new d(this.mPageContext, com.baidu.tieba.card.data.k.cQr);
        this.ehD.add(this.enN);
        this.ehD.add(this.enO);
        this.ehD.add(this.enR);
        this.ehD.add(this.enP);
        this.ehD.add(this.enQ);
        this.ehD.add(this.enS);
        this.ehD.add(this.enV);
        this.ehD.add(this.enW);
        this.ehD.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.ehD.add(this.enT);
        this.ehD.add(this.enU);
        this.ehD.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.ehD.add(this.enX);
        aCD();
        aKc();
        jq("page_recommend");
    }

    private void aKc() {
        if (!bb.ape.get()) {
            AdvertAppInfo.akZ.set(false);
            return;
        }
        this.dQL = r.btk().c(this.mPageContext, AdvertAppInfo.akQ);
        this.enY = r.btk().c(this.mPageContext, AdvertAppInfo.akT);
        this.enZ = r.btk().c(this.mPageContext, AdvertAppInfo.akU);
        this.eoa = r.btk().c(this.mPageContext, AdvertAppInfo.akV);
        this.eob = r.btk().c(this.mPageContext, AdvertAppInfo.akW);
        this.eoc = r.btk().c(this.mPageContext, AdvertAppInfo.akX);
        this.eod = r.btk().c(this.mPageContext, AdvertAppInfo.akY);
        this.ehD.add(this.dQL);
        this.ehD.add(this.enY);
        this.ehD.add(this.enZ);
        this.ehD.add(this.eoa);
        this.ehD.add(this.eob);
        this.ehD.add(this.eoc);
        this.ehD.add(this.eod);
        AdvertAppInfo.akZ.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.enP.a(eVar);
        this.enR.a(eVar);
    }

    public void al(List<com.baidu.adp.widget.ListView.h> list) {
        q.q(list, 2);
        this.enL.setData(list);
        this.enM = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.enN.onChangeSkinType(i);
        this.enS.nV(i);
    }

    public void notifyDataSetChanged() {
        if (this.enL != null) {
            this.enL.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.enP != null) {
            this.enP.setFromCDN(z);
        }
        if (this.enY != null && (this.enY instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.enY).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.enP != null) {
            this.enP.aZt = bdUniqueId;
        }
        if (this.enQ != null) {
            this.enQ.aZt = bdUniqueId;
        }
        if (this.enR != null) {
            this.enR.aZt = bdUniqueId;
        }
        if (this.enN != null) {
            this.enN.setPageUniqueId(bdUniqueId);
        }
        if (this.enS != null) {
            this.enS.aZt = bdUniqueId;
        }
        if (this.enT != null) {
            this.enT.aZt = bdUniqueId;
        }
        if (this.enU != null) {
            this.enU.aZt = bdUniqueId;
        }
        if (this.enV != null) {
            this.enV.aZt = bdUniqueId;
        }
        if (this.enW != null) {
            this.enW.aZt = bdUniqueId;
        }
        if (!v.J(this.dIa)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dIa) {
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
        if (!this.eog) {
            this.dIj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dIj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.enM != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.enM.iterator();
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

    private void aCD() {
        this.eog = aCE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCE() {
        if (this.dIa == null || this.dIa.size() <= 0) {
            this.dIa = new ArrayList();
            ArrayList<BdUniqueId> bBo = q.bBo();
            if (bBo == null || bBo.size() <= 0) {
                return false;
            }
            int size = bBo.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aYg().a(this.mPageContext, bBo.get(i), 2);
                if (this.eoe) {
                    a.setBusinessType(3);
                }
                if (this.enP != null && this.enP.aZt != null) {
                    a.setUniqueId(this.enP.aZt);
                }
                this.dIa.add(a);
            }
            this.enL.addAdapters(this.dIa);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.enP != null) {
            this.enP.setEventCallback(aVar);
        }
        if (this.enQ != null) {
            this.enQ.setEventCallback(aVar);
        }
        if (this.enR != null) {
            this.enR.setEventCallback(aVar);
        }
        if (this.enT != null) {
            this.enT.setEventCallback(aVar);
        }
        if (this.enU != null) {
            this.enU.setEventCallback(aVar);
        }
        if (this.enV != null) {
            this.enV.setEventCallback(aVar);
        }
        if (this.enW != null) {
            this.enW.setEventCallback(aVar);
        }
    }

    private void jq(String str) {
        if (this.ehD != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.ehD) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jq(str);
                }
            }
        }
    }
}

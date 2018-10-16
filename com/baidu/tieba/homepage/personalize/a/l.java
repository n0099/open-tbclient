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
    private com.baidu.adp.widget.ListView.a dQK;
    private m enK;
    private List<com.baidu.adp.widget.ListView.h> enL;
    private a enM;
    private j enN;
    private f enO;
    private e enP;
    private i enQ;
    private g enR;
    private b enS;
    private h enT;
    private f enU;
    private i enV;
    private d enW;
    private com.baidu.adp.widget.ListView.a enX;
    private com.baidu.adp.widget.ListView.a enY;
    private com.baidu.adp.widget.ListView.a enZ;
    private com.baidu.adp.widget.ListView.a eoa;
    private com.baidu.adp.widget.ListView.a eob;
    private com.baidu.adp.widget.ListView.a eoc;
    private boolean eod;
    private boolean eoe;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dIj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.aCD();
                if (l.this.enL != null) {
                    l.this.al(l.this.enL);
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
    private List<com.baidu.adp.widget.ListView.a> ehC = new ArrayList();

    public l(Context context, m mVar) {
        this.enK = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        ct(context);
        mVar.addAdapters(this.ehC);
    }

    private void ct(Context context) {
        this.enM = new a(this.mPageContext);
        this.enN = new j(this.mPageContext);
        this.enO = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.enP = new e(this.mPageContext, com.baidu.tieba.card.data.k.aoT);
        this.enQ = new i(this.mPageContext, com.baidu.tieba.card.data.l.cQu);
        this.enR = new g(this.mPageContext);
        this.enS = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.enT = new h(this.mPageContext, com.baidu.tieba.card.data.k.aoZ);
        this.enU = new f(this.mPageContext, com.baidu.tieba.card.data.k.cQq);
        this.enV = new i(this.mPageContext, com.baidu.tieba.card.data.l.cQv);
        this.enW = new d(this.mPageContext, com.baidu.tieba.card.data.k.cQr);
        this.ehC.add(this.enM);
        this.ehC.add(this.enN);
        this.ehC.add(this.enQ);
        this.ehC.add(this.enO);
        this.ehC.add(this.enP);
        this.ehC.add(this.enR);
        this.ehC.add(this.enU);
        this.ehC.add(this.enV);
        this.ehC.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.ehC.add(this.enS);
        this.ehC.add(this.enT);
        this.ehC.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.ehC.add(this.enW);
        aCC();
        aKc();
        jq("page_recommend");
    }

    private void aKc() {
        if (!bb.ape.get()) {
            AdvertAppInfo.akZ.set(false);
            return;
        }
        this.dQK = r.btk().c(this.mPageContext, AdvertAppInfo.akQ);
        this.enX = r.btk().c(this.mPageContext, AdvertAppInfo.akT);
        this.enY = r.btk().c(this.mPageContext, AdvertAppInfo.akU);
        this.enZ = r.btk().c(this.mPageContext, AdvertAppInfo.akV);
        this.eoa = r.btk().c(this.mPageContext, AdvertAppInfo.akW);
        this.eob = r.btk().c(this.mPageContext, AdvertAppInfo.akX);
        this.eoc = r.btk().c(this.mPageContext, AdvertAppInfo.akY);
        this.ehC.add(this.dQK);
        this.ehC.add(this.enX);
        this.ehC.add(this.enY);
        this.ehC.add(this.enZ);
        this.ehC.add(this.eoa);
        this.ehC.add(this.eob);
        this.ehC.add(this.eoc);
        AdvertAppInfo.akZ.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.enO.a(eVar);
        this.enQ.a(eVar);
    }

    public void al(List<com.baidu.adp.widget.ListView.h> list) {
        q.q(list, 2);
        this.enK.setData(list);
        this.enL = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.enM.onChangeSkinType(i);
        this.enR.nV(i);
    }

    public void notifyDataSetChanged() {
        if (this.enK != null) {
            this.enK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.enO != null) {
            this.enO.setFromCDN(z);
        }
        if (this.enX != null && (this.enX instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.enX).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.enO != null) {
            this.enO.aZt = bdUniqueId;
        }
        if (this.enP != null) {
            this.enP.aZt = bdUniqueId;
        }
        if (this.enQ != null) {
            this.enQ.aZt = bdUniqueId;
        }
        if (this.enM != null) {
            this.enM.setPageUniqueId(bdUniqueId);
        }
        if (this.enR != null) {
            this.enR.aZt = bdUniqueId;
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
        if (!this.eoe) {
            this.dIj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dIj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.enL != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.enL.iterator();
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

    private void aCC() {
        this.eoe = aCD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCD() {
        if (this.dIa == null || this.dIa.size() <= 0) {
            this.dIa = new ArrayList();
            ArrayList<BdUniqueId> bBo = q.bBo();
            if (bBo == null || bBo.size() <= 0) {
                return false;
            }
            int size = bBo.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aYg().a(this.mPageContext, bBo.get(i), 2);
                if (this.eod) {
                    a.setBusinessType(3);
                }
                if (this.enO != null && this.enO.aZt != null) {
                    a.setUniqueId(this.enO.aZt);
                }
                this.dIa.add(a);
            }
            this.enK.addAdapters(this.dIa);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.enO != null) {
            this.enO.setEventCallback(aVar);
        }
        if (this.enP != null) {
            this.enP.setEventCallback(aVar);
        }
        if (this.enQ != null) {
            this.enQ.setEventCallback(aVar);
        }
        if (this.enS != null) {
            this.enS.setEventCallback(aVar);
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
    }

    private void jq(String str) {
        if (this.ehC != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.ehC) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jq(str);
                }
            }
        }
    }
}

package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bc;
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
    private m dUG;
    private List<com.baidu.adp.widget.ListView.h> dUH;
    private a dUI;
    private j dUJ;
    private f dUK;
    private e dUL;
    private i dUM;
    private g dUN;
    private b dUO;
    private h dUP;
    private f dUQ;
    private i dUR;
    private d dUS;
    private com.baidu.adp.widget.ListView.a dUT;
    private com.baidu.adp.widget.ListView.a dUU;
    private com.baidu.adp.widget.ListView.a dUV;
    private com.baidu.adp.widget.ListView.a dUW;
    private com.baidu.adp.widget.ListView.a dUX;
    private com.baidu.adp.widget.ListView.a dUY;
    private boolean dUZ;
    private boolean dVa;
    private List<com.baidu.adp.widget.ListView.a> dqK;
    private com.baidu.adp.widget.ListView.a dzo;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dqT = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.aws();
                if (l.this.dUH != null) {
                    l.this.aj(l.this.dUH);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Gr) {
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
                bVar.ePT = true;
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
                bVar.ePT = false;
                l.this.Y(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dPK = new ArrayList();

    public l(Context context, m mVar) {
        this.dUG = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ad(context);
        by(context);
        mVar.addAdapters(this.dPK);
    }

    private void by(Context context) {
        this.dUI = new a(this.mPageContext);
        this.dUJ = new j(this.mPageContext);
        this.dUK = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.dUL = new e(this.mPageContext, com.baidu.tieba.card.data.k.aic);
        this.dUM = new i(this.mPageContext, com.baidu.tieba.card.data.l.czH);
        this.dUN = new g(this.mPageContext);
        this.dUO = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.dUP = new h(this.mPageContext, com.baidu.tieba.card.data.k.aii);
        this.dUQ = new f(this.mPageContext, com.baidu.tieba.card.data.k.czD);
        this.dUR = new i(this.mPageContext, com.baidu.tieba.card.data.l.czI);
        this.dUS = new d(this.mPageContext, com.baidu.tieba.card.data.k.czE);
        this.dPK.add(this.dUI);
        this.dPK.add(this.dUJ);
        this.dPK.add(this.dUM);
        this.dPK.add(this.dUK);
        this.dPK.add(this.dUL);
        this.dPK.add(this.dUN);
        this.dPK.add(this.dUQ);
        this.dPK.add(this.dUR);
        this.dPK.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dPK.add(this.dUO);
        this.dPK.add(this.dUP);
        this.dPK.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.dPK.add(this.dUS);
        awr();
        aDy();
        iD("page_recommend");
    }

    private void aDy() {
        if (!bc.ain.get()) {
            AdvertAppInfo.adY.set(false);
            return;
        }
        this.dzo = r.boJ().c(this.mPageContext, AdvertAppInfo.adP);
        this.dUT = r.boJ().c(this.mPageContext, AdvertAppInfo.adS);
        this.dUU = r.boJ().c(this.mPageContext, AdvertAppInfo.adT);
        this.dUV = r.boJ().c(this.mPageContext, AdvertAppInfo.adU);
        this.dUW = r.boJ().c(this.mPageContext, AdvertAppInfo.adV);
        this.dUX = r.boJ().c(this.mPageContext, AdvertAppInfo.adW);
        this.dUY = r.boJ().c(this.mPageContext, AdvertAppInfo.adX);
        this.dPK.add(this.dzo);
        this.dPK.add(this.dUT);
        this.dPK.add(this.dUU);
        this.dPK.add(this.dUV);
        this.dPK.add(this.dUW);
        this.dPK.add(this.dUX);
        this.dPK.add(this.dUY);
        AdvertAppInfo.adY.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dUK.a(eVar);
        this.dUM.a(eVar);
    }

    public void aj(List<com.baidu.adp.widget.ListView.h> list) {
        q.p(list, 2);
        this.dUG.setData(list);
        this.dUH = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dUI.onChangeSkinType(i);
        this.dUN.mF(i);
    }

    public void notifyDataSetChanged() {
        if (this.dUG != null) {
            this.dUG.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dUK != null) {
            this.dUK.setFromCDN(z);
        }
        if (this.dUT != null && (this.dUT instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dUT).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dUK != null) {
            this.dUK.aRF = bdUniqueId;
        }
        if (this.dUL != null) {
            this.dUL.aRF = bdUniqueId;
        }
        if (this.dUM != null) {
            this.dUM.aRF = bdUniqueId;
        }
        if (this.dUI != null) {
            this.dUI.setPageUniqueId(bdUniqueId);
        }
        if (this.dUN != null) {
            this.dUN.aRF = bdUniqueId;
        }
        if (this.dUO != null) {
            this.dUO.aRF = bdUniqueId;
        }
        if (this.dUP != null) {
            this.dUP.aRF = bdUniqueId;
        }
        if (this.dUQ != null) {
            this.dUQ.aRF = bdUniqueId;
        }
        if (this.dUR != null) {
            this.dUR.aRF = bdUniqueId;
        }
        if (!w.A(this.dqK)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dqK) {
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
        if (!this.dVa) {
            this.dqT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dqT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dUH != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dUH.iterator();
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

    private void awr() {
        this.dVa = aws();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aws() {
        if (this.dqK == null || this.dqK.size() <= 0) {
            this.dqK = new ArrayList();
            ArrayList<BdUniqueId> bwO = q.bwO();
            if (bwO == null || bwO.size() <= 0) {
                return false;
            }
            int size = bwO.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aRG().a(this.mPageContext, bwO.get(i), 2);
                if (this.dUZ) {
                    a.setBusinessType(3);
                }
                if (this.dUK != null && this.dUK.aRF != null) {
                    a.setUniqueId(this.dUK.aRF);
                }
                this.dqK.add(a);
            }
            this.dUG.addAdapters(this.dqK);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.dUK != null) {
            this.dUK.setEventCallback(aVar);
        }
        if (this.dUL != null) {
            this.dUL.setEventCallback(aVar);
        }
        if (this.dUM != null) {
            this.dUM.setEventCallback(aVar);
        }
        if (this.dUO != null) {
            this.dUO.setEventCallback(aVar);
        }
        if (this.dUP != null) {
            this.dUP.setEventCallback(aVar);
        }
        if (this.dUQ != null) {
            this.dUQ.setEventCallback(aVar);
        }
        if (this.dUR != null) {
            this.dUR.setEventCallback(aVar);
        }
    }

    private void iD(String str) {
        if (this.dPK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dPK) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iD(str);
                }
            }
        }
    }
}

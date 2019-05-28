package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class w {
    private List<com.baidu.adp.widget.ListView.a> fGi;
    private q gdA;
    private k gdB;
    private t gdC;
    private i gdD;
    private m gdE;
    private n gdF;
    private p gdG;
    private com.baidu.adp.widget.ListView.a gdH;
    private com.baidu.adp.widget.ListView.a gdI;
    private com.baidu.adp.widget.ListView.a gdJ;
    private com.baidu.adp.widget.ListView.a gdK;
    private com.baidu.adp.widget.ListView.a gdL;
    private com.baidu.adp.widget.ListView.a gdM;
    private com.baidu.adp.widget.ListView.a gdN;
    private boolean gdO;
    private boolean gdP;
    private com.baidu.adp.widget.ListView.r gdj;
    private List<com.baidu.adp.widget.ListView.m> gdk;
    private a gdl;
    private u gdm;
    private k gdn;
    private r gdo;
    private g gdp;
    private h gdq;
    private o gdr;
    private f gds;
    private e gdt;
    private d gdu;
    private s gdv;
    private j gdw;
    private t gdx;
    private l gdy;
    private b gdz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fGj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.w.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                w.this.buq();
                if (w.this.gdk != null) {
                    w.this.aF(w.this.gdk);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.w.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Hi) {
                w.this.at(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.homepage.personalize.a.w.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.bHO = true;
                w.this.at(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.homepage.personalize.a.w.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.bHO = false;
                w.this.at(bVar);
            }
        }
    };
    private CustomMessageListener exz = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.w.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b xd;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (xd = w.this.xd(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, xd));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> fWy = new ArrayList();

    public w(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.gdj = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dD(context);
        b(rVar);
        rVar.addAdapters(this.fWy);
    }

    private void dD(Context context) {
        this.gdl = new a(this.mPageContext);
        this.gdm = new u(this.mPageContext);
        this.gdn = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gdo = new r(this.mPageContext, com.baidu.tieba.card.data.k.eAY);
        this.gdp = new g(this.mPageContext, com.baidu.tieba.card.data.k.eBd);
        this.gdq = new h(this.mPageContext, com.baidu.tieba.card.data.k.eBe);
        this.gdr = new o(this.mPageContext, com.baidu.tieba.card.data.k.eBf);
        this.gds = new f(this.mPageContext, com.baidu.tieba.card.data.k.eAZ);
        this.gdt = new e(this.mPageContext, com.baidu.tieba.card.data.k.eBb);
        this.gdu = new d(this.mPageContext, com.baidu.tieba.card.data.k.eBc);
        this.gdv = new s(this.mPageContext, com.baidu.tieba.card.data.l.bIw);
        this.gdw = new j(this.mPageContext, com.baidu.tieba.card.data.k.bIu);
        this.gdx = new t(this.mPageContext, com.baidu.tieba.card.data.l.eBl);
        this.gdy = new l(this.mPageContext);
        this.gdz = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gdA = new q(this.mPageContext, com.baidu.tieba.card.data.k.bIA);
        this.gdB = new k(this.mPageContext, com.baidu.tieba.card.data.k.eAW);
        this.gdC = new t(this.mPageContext, com.baidu.tieba.card.data.l.eBm);
        this.gdD = new i(this.mPageContext, com.baidu.tieba.card.data.k.eAX);
        this.gdE = new m(this.mPageContext, com.baidu.tieba.card.data.k.bIE);
        this.gdF = new n(this.mPageContext, com.baidu.tieba.card.data.k.bIF);
        this.gdG = new p(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.ggL);
        this.fWy.add(this.gdl);
        this.fWy.add(this.gdm);
        this.fWy.add(this.gdx);
        this.fWy.add(this.gdn);
        this.fWy.add(this.gdo);
        this.fWy.add(this.gdp);
        this.fWy.add(this.gdq);
        this.fWy.add(this.gdr);
        this.fWy.add(this.gds);
        this.fWy.add(this.gdt);
        this.fWy.add(this.gdu);
        this.fWy.add(this.gdv);
        this.fWy.add(this.gdw);
        this.fWy.add(this.gdy);
        this.fWy.add(this.gdB);
        this.fWy.add(this.gdC);
        this.fWy.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.fWy.add(this.gdz);
        this.fWy.add(this.gdA);
        this.fWy.add(new v(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.fWy.add(this.gdD);
        this.fWy.add(this.gdE);
        this.fWy.add(this.gdF);
        this.fWy.add(this.gdG);
        bup();
        buo();
        rV("page_recommend");
    }

    private void buo() {
        if (!bg.bII.get()) {
            AdvertAppInfo.bDQ.set(false);
            return;
        }
        this.gdH = com.baidu.tieba.recapp.r.ceL().c(this.mPageContext, AdvertAppInfo.bDH);
        this.gdI = com.baidu.tieba.recapp.r.ceL().c(this.mPageContext, AdvertAppInfo.bDK);
        this.gdJ = com.baidu.tieba.recapp.r.ceL().c(this.mPageContext, AdvertAppInfo.bDL);
        this.gdK = com.baidu.tieba.recapp.r.ceL().c(this.mPageContext, AdvertAppInfo.bDM);
        this.gdL = com.baidu.tieba.recapp.r.ceL().c(this.mPageContext, AdvertAppInfo.bDN);
        this.gdM = com.baidu.tieba.recapp.r.ceL().c(this.mPageContext, AdvertAppInfo.bDO);
        this.gdN = com.baidu.tieba.recapp.r.ceL().c(this.mPageContext, AdvertAppInfo.bDP);
        this.fWy.add(this.gdH);
        this.fWy.add(this.gdI);
        this.fWy.add(this.gdJ);
        this.fWy.add(this.gdK);
        this.fWy.add(this.gdL);
        this.fWy.add(this.gdM);
        this.fWy.add(this.gdN);
        AdvertAppInfo.bDQ.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gdn.a(eVar);
        this.gdo.a(eVar);
        this.gdp.a(eVar);
        this.gdq.a(eVar);
        this.gdr.a(eVar);
        this.gds.a(eVar);
        this.gdt.a(eVar);
        this.gdu.a(eVar);
        this.gdv.a(eVar);
        this.gdx.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gdo.b(rVar);
        this.gdp.b(rVar);
        this.gdq.b(rVar);
        this.gdr.b(rVar);
        this.gds.b(rVar);
        this.gdt.b(rVar);
        this.gdu.b(rVar);
        this.gdv.b(rVar);
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.q.p(list, 2);
        this.gdj.setData(list);
        this.gdk = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.gdl.onChangeSkinType(i);
        this.gdy.tH(i);
    }

    public void notifyDataSetChanged() {
        if (this.gdj != null) {
            this.gdj.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.gdn != null) {
            this.gdn.setFromCDN(z);
            this.gdB.setFromCDN(z);
            this.gdx.setFromCDN(z);
            this.gdC.setFromCDN(z);
            this.gdw.setFromCDN(z);
            this.gdA.setFromCDN(z);
        }
        if (this.gdq != null) {
            this.gdq.setFromCDN(z);
        }
        if (this.gdI != null && (this.gdI instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.gdI).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gdn != null) {
            this.gdn.cwh = bdUniqueId;
        }
        if (this.gdo != null) {
            this.gdo.cwh = bdUniqueId;
        }
        if (this.gdp != null) {
            this.gdp.cwh = bdUniqueId;
        }
        if (this.gdq != null) {
            this.gdq.cwh = bdUniqueId;
        }
        if (this.gdr != null) {
            this.gdr.cwh = bdUniqueId;
        }
        if (this.gds != null) {
            this.gds.cwh = bdUniqueId;
        }
        if (this.gdt != null) {
            this.gdt.cwh = bdUniqueId;
        }
        if (this.gdu != null) {
            this.gdu.cwh = bdUniqueId;
        }
        if (this.gdw != null) {
            this.gdw.cwh = bdUniqueId;
        }
        if (this.gdx != null) {
            this.gdx.cwh = bdUniqueId;
        }
        if (this.gdv != null) {
            this.gdv.cwh = bdUniqueId;
        }
        if (this.gdl != null) {
            this.gdl.setPageUniqueId(bdUniqueId);
        }
        if (this.gdy != null) {
            this.gdy.cwh = bdUniqueId;
        }
        if (this.gdz != null) {
            this.gdz.cwh = bdUniqueId;
        }
        if (this.gdA != null) {
            this.gdA.cwh = bdUniqueId;
        }
        if (this.gdB != null) {
            this.gdB.cwh = bdUniqueId;
        }
        if (this.gdC != null) {
            this.gdC.cwh = bdUniqueId;
        }
        if (this.gdE != null) {
            this.gdE.cwh = bdUniqueId;
        }
        if (this.gdF != null) {
            this.gdF.cwh = bdUniqueId;
        }
        if (this.gdG != null) {
            this.gdG.cwh = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fGi)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fGi) {
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
        this.exz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.exz);
        if (!this.gdP) {
            this.fGj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fGj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.gdk != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gdk.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
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

    private void bup() {
        this.gdP = buq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buq() {
        if (this.fGi == null || this.fGi.size() <= 0) {
            this.fGi = new ArrayList();
            ArrayList<BdUniqueId> clJ = com.baidu.tieba.tbadkCore.q.clJ();
            if (clJ == null || clJ.size() <= 0) {
                return false;
            }
            int size = clJ.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bIV().a(this.mPageContext, clJ.get(i), 2);
                if (this.gdO) {
                    a.setBusinessType(3);
                }
                if (this.gdn != null && this.gdn.cwh != null) {
                    a.setUniqueId(this.gdn.cwh);
                }
                this.fGi.add(a);
            }
            this.gdj.addAdapters(this.fGi);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gdn != null) {
            this.gdn.setEventCallback(aVar);
        }
        if (this.gdo != null) {
            this.gdo.setEventCallback(aVar);
        }
        if (this.gdw != null) {
            this.gdw.setEventCallback(aVar);
        }
        if (this.gdx != null) {
            this.gdx.setEventCallback(aVar);
        }
        if (this.gdz != null) {
            this.gdz.setEventCallback(aVar);
        }
        if (this.gdA != null) {
            this.gdA.setEventCallback(aVar);
        }
        if (this.gdB != null) {
            this.gdB.setEventCallback(aVar);
        }
        if (this.gdC != null) {
            this.gdC.setEventCallback(aVar);
        }
        if (this.gdE != null) {
            this.gdE.setEventCallback(aVar);
        }
        if (this.gdF != null) {
            this.gdF.setEventCallback(aVar);
        }
        if (this.gdG != null) {
            this.gdG.setEventCallback(aVar);
        }
    }

    private void rV(String str) {
        if (this.fWy != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fWy) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rV(str);
                }
            }
        }
    }

    private boolean h(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).eAB) != null && advertAppInfo.abE() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b xd(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.gdk == null || this.gdk.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.gdk.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.gdk.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.gdk.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (h(this.gdk.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.gdk.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.gdk.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.gdk.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.gdk.get(i4)) != null && lVar.threadData != null && str.equals(lVar.threadData.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.gdk.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.be(i6 - i >= -1 ? i6 - i : -1);
        bVar.bf(i7);
        bVar.bg(i2);
        return bVar;
    }

    public void onPause() {
        if (this.gdx != null) {
            this.gdx.onPause();
        }
        if (this.gdC != null) {
            this.gdC.onPause();
        }
        if (this.gdv != null) {
            this.gdv.onPause();
        }
    }

    public void onResume() {
        if (this.gdx != null) {
            this.gdx.onResume();
        }
        if (this.gdC != null) {
            this.gdC.onResume();
        }
        if (this.gdv != null) {
            this.gdv.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.gdx != null) {
            this.gdx.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gdk;
    }
}

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
    private List<com.baidu.adp.widget.ListView.a> fGj;
    private l gdA;
    private b gdB;
    private q gdC;
    private k gdD;
    private t gdE;
    private i gdF;
    private m gdG;
    private n gdH;
    private p gdI;
    private com.baidu.adp.widget.ListView.a gdJ;
    private com.baidu.adp.widget.ListView.a gdK;
    private com.baidu.adp.widget.ListView.a gdL;
    private com.baidu.adp.widget.ListView.a gdM;
    private com.baidu.adp.widget.ListView.a gdN;
    private com.baidu.adp.widget.ListView.a gdO;
    private com.baidu.adp.widget.ListView.a gdP;
    private boolean gdQ;
    private boolean gdR;
    private com.baidu.adp.widget.ListView.r gdl;
    private List<com.baidu.adp.widget.ListView.m> gdm;
    private a gdn;
    private u gdo;
    private k gdp;
    private r gdq;
    private g gdr;
    private h gds;
    private o gdt;
    private f gdu;
    private e gdv;
    private d gdw;
    private s gdx;
    private j gdy;
    private t gdz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fGl = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.w.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                w.this.bur();
                if (w.this.gdm != null) {
                    w.this.aF(w.this.gdm);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.w.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Hh) {
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
                bVar.bHP = true;
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
                bVar.bHP = false;
                w.this.at(bVar);
            }
        }
    };
    private CustomMessageListener exz = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.w.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b xf;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (xf = w.this.xf(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, xf));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> fWA = new ArrayList();

    public w(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.gdl = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dD(context);
        b(rVar);
        rVar.addAdapters(this.fWA);
    }

    private void dD(Context context) {
        this.gdn = new a(this.mPageContext);
        this.gdo = new u(this.mPageContext);
        this.gdp = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gdq = new r(this.mPageContext, com.baidu.tieba.card.data.k.eAY);
        this.gdr = new g(this.mPageContext, com.baidu.tieba.card.data.k.eBd);
        this.gds = new h(this.mPageContext, com.baidu.tieba.card.data.k.eBe);
        this.gdt = new o(this.mPageContext, com.baidu.tieba.card.data.k.eBf);
        this.gdu = new f(this.mPageContext, com.baidu.tieba.card.data.k.eAZ);
        this.gdv = new e(this.mPageContext, com.baidu.tieba.card.data.k.eBb);
        this.gdw = new d(this.mPageContext, com.baidu.tieba.card.data.k.eBc);
        this.gdx = new s(this.mPageContext, com.baidu.tieba.card.data.l.bIx);
        this.gdy = new j(this.mPageContext, com.baidu.tieba.card.data.k.bIv);
        this.gdz = new t(this.mPageContext, com.baidu.tieba.card.data.l.eBl);
        this.gdA = new l(this.mPageContext);
        this.gdB = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gdC = new q(this.mPageContext, com.baidu.tieba.card.data.k.bIB);
        this.gdD = new k(this.mPageContext, com.baidu.tieba.card.data.k.eAW);
        this.gdE = new t(this.mPageContext, com.baidu.tieba.card.data.l.eBm);
        this.gdF = new i(this.mPageContext, com.baidu.tieba.card.data.k.eAX);
        this.gdG = new m(this.mPageContext, com.baidu.tieba.card.data.k.bIF);
        this.gdH = new n(this.mPageContext, com.baidu.tieba.card.data.k.bIG);
        this.gdI = new p(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.ggN);
        this.fWA.add(this.gdn);
        this.fWA.add(this.gdo);
        this.fWA.add(this.gdz);
        this.fWA.add(this.gdp);
        this.fWA.add(this.gdq);
        this.fWA.add(this.gdr);
        this.fWA.add(this.gds);
        this.fWA.add(this.gdt);
        this.fWA.add(this.gdu);
        this.fWA.add(this.gdv);
        this.fWA.add(this.gdw);
        this.fWA.add(this.gdx);
        this.fWA.add(this.gdy);
        this.fWA.add(this.gdA);
        this.fWA.add(this.gdD);
        this.fWA.add(this.gdE);
        this.fWA.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.fWA.add(this.gdB);
        this.fWA.add(this.gdC);
        this.fWA.add(new v(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.fWA.add(this.gdF);
        this.fWA.add(this.gdG);
        this.fWA.add(this.gdH);
        this.fWA.add(this.gdI);
        buq();
        bup();
        rU("page_recommend");
    }

    private void bup() {
        if (!bg.bIJ.get()) {
            AdvertAppInfo.bDR.set(false);
            return;
        }
        this.gdJ = com.baidu.tieba.recapp.r.ceM().c(this.mPageContext, AdvertAppInfo.bDI);
        this.gdK = com.baidu.tieba.recapp.r.ceM().c(this.mPageContext, AdvertAppInfo.bDL);
        this.gdL = com.baidu.tieba.recapp.r.ceM().c(this.mPageContext, AdvertAppInfo.bDM);
        this.gdM = com.baidu.tieba.recapp.r.ceM().c(this.mPageContext, AdvertAppInfo.bDN);
        this.gdN = com.baidu.tieba.recapp.r.ceM().c(this.mPageContext, AdvertAppInfo.bDO);
        this.gdO = com.baidu.tieba.recapp.r.ceM().c(this.mPageContext, AdvertAppInfo.bDP);
        this.gdP = com.baidu.tieba.recapp.r.ceM().c(this.mPageContext, AdvertAppInfo.bDQ);
        this.fWA.add(this.gdJ);
        this.fWA.add(this.gdK);
        this.fWA.add(this.gdL);
        this.fWA.add(this.gdM);
        this.fWA.add(this.gdN);
        this.fWA.add(this.gdO);
        this.fWA.add(this.gdP);
        AdvertAppInfo.bDR.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gdp.a(eVar);
        this.gdq.a(eVar);
        this.gdr.a(eVar);
        this.gds.a(eVar);
        this.gdt.a(eVar);
        this.gdu.a(eVar);
        this.gdv.a(eVar);
        this.gdw.a(eVar);
        this.gdx.a(eVar);
        this.gdz.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gdq.b(rVar);
        this.gdr.b(rVar);
        this.gds.b(rVar);
        this.gdt.b(rVar);
        this.gdu.b(rVar);
        this.gdv.b(rVar);
        this.gdw.b(rVar);
        this.gdx.b(rVar);
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.q.p(list, 2);
        this.gdl.setData(list);
        this.gdm = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.gdn.onChangeSkinType(i);
        this.gdA.tH(i);
    }

    public void notifyDataSetChanged() {
        if (this.gdl != null) {
            this.gdl.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.gdp != null) {
            this.gdp.setFromCDN(z);
            this.gdD.setFromCDN(z);
            this.gdz.setFromCDN(z);
            this.gdE.setFromCDN(z);
            this.gdy.setFromCDN(z);
            this.gdC.setFromCDN(z);
        }
        if (this.gds != null) {
            this.gds.setFromCDN(z);
        }
        if (this.gdK != null && (this.gdK instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.gdK).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gdp != null) {
            this.gdp.cwi = bdUniqueId;
        }
        if (this.gdq != null) {
            this.gdq.cwi = bdUniqueId;
        }
        if (this.gdr != null) {
            this.gdr.cwi = bdUniqueId;
        }
        if (this.gds != null) {
            this.gds.cwi = bdUniqueId;
        }
        if (this.gdt != null) {
            this.gdt.cwi = bdUniqueId;
        }
        if (this.gdu != null) {
            this.gdu.cwi = bdUniqueId;
        }
        if (this.gdv != null) {
            this.gdv.cwi = bdUniqueId;
        }
        if (this.gdw != null) {
            this.gdw.cwi = bdUniqueId;
        }
        if (this.gdy != null) {
            this.gdy.cwi = bdUniqueId;
        }
        if (this.gdz != null) {
            this.gdz.cwi = bdUniqueId;
        }
        if (this.gdx != null) {
            this.gdx.cwi = bdUniqueId;
        }
        if (this.gdn != null) {
            this.gdn.setPageUniqueId(bdUniqueId);
        }
        if (this.gdA != null) {
            this.gdA.cwi = bdUniqueId;
        }
        if (this.gdB != null) {
            this.gdB.cwi = bdUniqueId;
        }
        if (this.gdC != null) {
            this.gdC.cwi = bdUniqueId;
        }
        if (this.gdD != null) {
            this.gdD.cwi = bdUniqueId;
        }
        if (this.gdE != null) {
            this.gdE.cwi = bdUniqueId;
        }
        if (this.gdG != null) {
            this.gdG.cwi = bdUniqueId;
        }
        if (this.gdH != null) {
            this.gdH.cwi = bdUniqueId;
        }
        if (this.gdI != null) {
            this.gdI.cwi = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fGj)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fGj) {
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
        if (!this.gdR) {
            this.fGl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fGl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.gdm != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gdm.iterator();
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

    private void buq() {
        this.gdR = bur();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bur() {
        if (this.fGj == null || this.fGj.size() <= 0) {
            this.fGj = new ArrayList();
            ArrayList<BdUniqueId> clK = com.baidu.tieba.tbadkCore.q.clK();
            if (clK == null || clK.size() <= 0) {
                return false;
            }
            int size = clK.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bIW().a(this.mPageContext, clK.get(i), 2);
                if (this.gdQ) {
                    a.setBusinessType(3);
                }
                if (this.gdp != null && this.gdp.cwi != null) {
                    a.setUniqueId(this.gdp.cwi);
                }
                this.fGj.add(a);
            }
            this.gdl.addAdapters(this.fGj);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gdp != null) {
            this.gdp.setEventCallback(aVar);
        }
        if (this.gdq != null) {
            this.gdq.setEventCallback(aVar);
        }
        if (this.gdy != null) {
            this.gdy.setEventCallback(aVar);
        }
        if (this.gdz != null) {
            this.gdz.setEventCallback(aVar);
        }
        if (this.gdB != null) {
            this.gdB.setEventCallback(aVar);
        }
        if (this.gdC != null) {
            this.gdC.setEventCallback(aVar);
        }
        if (this.gdD != null) {
            this.gdD.setEventCallback(aVar);
        }
        if (this.gdE != null) {
            this.gdE.setEventCallback(aVar);
        }
        if (this.gdG != null) {
            this.gdG.setEventCallback(aVar);
        }
        if (this.gdH != null) {
            this.gdH.setEventCallback(aVar);
        }
        if (this.gdI != null) {
            this.gdI.setEventCallback(aVar);
        }
    }

    private void rU(String str) {
        if (this.fWA != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fWA) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rU(str);
                }
            }
        }
    }

    private boolean h(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).eAB) != null && advertAppInfo.abE() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b xf(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.gdm == null || this.gdm.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.gdm.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.gdm.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.gdm.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (h(this.gdm.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.gdm.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.gdm.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.gdm.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.gdm.get(i4)) != null && lVar.threadData != null && str.equals(lVar.threadData.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.gdm.get(i4)).position;
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
        if (this.gdz != null) {
            this.gdz.onPause();
        }
        if (this.gdE != null) {
            this.gdE.onPause();
        }
        if (this.gdx != null) {
            this.gdx.onPause();
        }
    }

    public void onResume() {
        if (this.gdz != null) {
            this.gdz.onResume();
        }
        if (this.gdE != null) {
            this.gdE.onResume();
        }
        if (this.gdx != null) {
            this.gdx.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.gdz != null) {
            this.gdz.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gdm;
    }
}

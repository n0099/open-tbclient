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
    private List<com.baidu.adp.widget.ListView.a> fGh;
    private k gdA;
    private t gdB;
    private i gdC;
    private m gdD;
    private n gdE;
    private p gdF;
    private com.baidu.adp.widget.ListView.a gdG;
    private com.baidu.adp.widget.ListView.a gdH;
    private com.baidu.adp.widget.ListView.a gdI;
    private com.baidu.adp.widget.ListView.a gdJ;
    private com.baidu.adp.widget.ListView.a gdK;
    private com.baidu.adp.widget.ListView.a gdL;
    private com.baidu.adp.widget.ListView.a gdM;
    private boolean gdN;
    private boolean gdO;
    private com.baidu.adp.widget.ListView.r gdi;
    private List<com.baidu.adp.widget.ListView.m> gdj;
    private a gdk;
    private u gdl;
    private k gdm;
    private r gdn;
    private g gdo;
    private h gdp;
    private o gdq;
    private f gdr;
    private e gds;
    private d gdt;
    private s gdu;
    private j gdv;
    private t gdw;
    private l gdx;
    private b gdy;
    private q gdz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fGi = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.w.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                w.this.bun();
                if (w.this.gdj != null) {
                    w.this.aF(w.this.gdj);
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
    private CustomMessageListener exy = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.w.5
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
    private List<com.baidu.adp.widget.ListView.a> fWx = new ArrayList();

    public w(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.gdi = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dD(context);
        b(rVar);
        rVar.addAdapters(this.fWx);
    }

    private void dD(Context context) {
        this.gdk = new a(this.mPageContext);
        this.gdl = new u(this.mPageContext);
        this.gdm = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gdn = new r(this.mPageContext, com.baidu.tieba.card.data.k.eAX);
        this.gdo = new g(this.mPageContext, com.baidu.tieba.card.data.k.eBc);
        this.gdp = new h(this.mPageContext, com.baidu.tieba.card.data.k.eBd);
        this.gdq = new o(this.mPageContext, com.baidu.tieba.card.data.k.eBe);
        this.gdr = new f(this.mPageContext, com.baidu.tieba.card.data.k.eAY);
        this.gds = new e(this.mPageContext, com.baidu.tieba.card.data.k.eBa);
        this.gdt = new d(this.mPageContext, com.baidu.tieba.card.data.k.eBb);
        this.gdu = new s(this.mPageContext, com.baidu.tieba.card.data.l.bIw);
        this.gdv = new j(this.mPageContext, com.baidu.tieba.card.data.k.bIu);
        this.gdw = new t(this.mPageContext, com.baidu.tieba.card.data.l.eBk);
        this.gdx = new l(this.mPageContext);
        this.gdy = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gdz = new q(this.mPageContext, com.baidu.tieba.card.data.k.bIA);
        this.gdA = new k(this.mPageContext, com.baidu.tieba.card.data.k.eAV);
        this.gdB = new t(this.mPageContext, com.baidu.tieba.card.data.l.eBl);
        this.gdC = new i(this.mPageContext, com.baidu.tieba.card.data.k.eAW);
        this.gdD = new m(this.mPageContext, com.baidu.tieba.card.data.k.bIE);
        this.gdE = new n(this.mPageContext, com.baidu.tieba.card.data.k.bIF);
        this.gdF = new p(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.ggK);
        this.fWx.add(this.gdk);
        this.fWx.add(this.gdl);
        this.fWx.add(this.gdw);
        this.fWx.add(this.gdm);
        this.fWx.add(this.gdn);
        this.fWx.add(this.gdo);
        this.fWx.add(this.gdp);
        this.fWx.add(this.gdq);
        this.fWx.add(this.gdr);
        this.fWx.add(this.gds);
        this.fWx.add(this.gdt);
        this.fWx.add(this.gdu);
        this.fWx.add(this.gdv);
        this.fWx.add(this.gdx);
        this.fWx.add(this.gdA);
        this.fWx.add(this.gdB);
        this.fWx.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.fWx.add(this.gdy);
        this.fWx.add(this.gdz);
        this.fWx.add(new v(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.fWx.add(this.gdC);
        this.fWx.add(this.gdD);
        this.fWx.add(this.gdE);
        this.fWx.add(this.gdF);
        bum();
        bul();
        rV("page_recommend");
    }

    private void bul() {
        if (!bg.bII.get()) {
            AdvertAppInfo.bDQ.set(false);
            return;
        }
        this.gdG = com.baidu.tieba.recapp.r.ceJ().c(this.mPageContext, AdvertAppInfo.bDH);
        this.gdH = com.baidu.tieba.recapp.r.ceJ().c(this.mPageContext, AdvertAppInfo.bDK);
        this.gdI = com.baidu.tieba.recapp.r.ceJ().c(this.mPageContext, AdvertAppInfo.bDL);
        this.gdJ = com.baidu.tieba.recapp.r.ceJ().c(this.mPageContext, AdvertAppInfo.bDM);
        this.gdK = com.baidu.tieba.recapp.r.ceJ().c(this.mPageContext, AdvertAppInfo.bDN);
        this.gdL = com.baidu.tieba.recapp.r.ceJ().c(this.mPageContext, AdvertAppInfo.bDO);
        this.gdM = com.baidu.tieba.recapp.r.ceJ().c(this.mPageContext, AdvertAppInfo.bDP);
        this.fWx.add(this.gdG);
        this.fWx.add(this.gdH);
        this.fWx.add(this.gdI);
        this.fWx.add(this.gdJ);
        this.fWx.add(this.gdK);
        this.fWx.add(this.gdL);
        this.fWx.add(this.gdM);
        AdvertAppInfo.bDQ.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gdm.a(eVar);
        this.gdn.a(eVar);
        this.gdo.a(eVar);
        this.gdp.a(eVar);
        this.gdq.a(eVar);
        this.gdr.a(eVar);
        this.gds.a(eVar);
        this.gdt.a(eVar);
        this.gdu.a(eVar);
        this.gdw.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gdn.b(rVar);
        this.gdo.b(rVar);
        this.gdp.b(rVar);
        this.gdq.b(rVar);
        this.gdr.b(rVar);
        this.gds.b(rVar);
        this.gdt.b(rVar);
        this.gdu.b(rVar);
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.q.p(list, 2);
        this.gdi.setData(list);
        this.gdj = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.gdk.onChangeSkinType(i);
        this.gdx.tH(i);
    }

    public void notifyDataSetChanged() {
        if (this.gdi != null) {
            this.gdi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.gdm != null) {
            this.gdm.setFromCDN(z);
            this.gdA.setFromCDN(z);
            this.gdw.setFromCDN(z);
            this.gdB.setFromCDN(z);
            this.gdv.setFromCDN(z);
            this.gdz.setFromCDN(z);
        }
        if (this.gdp != null) {
            this.gdp.setFromCDN(z);
        }
        if (this.gdH != null && (this.gdH instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.gdH).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gdm != null) {
            this.gdm.cwh = bdUniqueId;
        }
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
        if (this.gdv != null) {
            this.gdv.cwh = bdUniqueId;
        }
        if (this.gdw != null) {
            this.gdw.cwh = bdUniqueId;
        }
        if (this.gdu != null) {
            this.gdu.cwh = bdUniqueId;
        }
        if (this.gdk != null) {
            this.gdk.setPageUniqueId(bdUniqueId);
        }
        if (this.gdx != null) {
            this.gdx.cwh = bdUniqueId;
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
        if (this.gdD != null) {
            this.gdD.cwh = bdUniqueId;
        }
        if (this.gdE != null) {
            this.gdE.cwh = bdUniqueId;
        }
        if (this.gdF != null) {
            this.gdF.cwh = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fGh)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fGh) {
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
        this.exy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.exy);
        if (!this.gdO) {
            this.fGi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fGi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.gdj != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gdj.iterator();
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

    private void bum() {
        this.gdO = bun();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bun() {
        if (this.fGh == null || this.fGh.size() <= 0) {
            this.fGh = new ArrayList();
            ArrayList<BdUniqueId> clH = com.baidu.tieba.tbadkCore.q.clH();
            if (clH == null || clH.size() <= 0) {
                return false;
            }
            int size = clH.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bIS().a(this.mPageContext, clH.get(i), 2);
                if (this.gdN) {
                    a.setBusinessType(3);
                }
                if (this.gdm != null && this.gdm.cwh != null) {
                    a.setUniqueId(this.gdm.cwh);
                }
                this.fGh.add(a);
            }
            this.gdi.addAdapters(this.fGh);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gdm != null) {
            this.gdm.setEventCallback(aVar);
        }
        if (this.gdn != null) {
            this.gdn.setEventCallback(aVar);
        }
        if (this.gdv != null) {
            this.gdv.setEventCallback(aVar);
        }
        if (this.gdw != null) {
            this.gdw.setEventCallback(aVar);
        }
        if (this.gdy != null) {
            this.gdy.setEventCallback(aVar);
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
        if (this.gdD != null) {
            this.gdD.setEventCallback(aVar);
        }
        if (this.gdE != null) {
            this.gdE.setEventCallback(aVar);
        }
        if (this.gdF != null) {
            this.gdF.setEventCallback(aVar);
        }
    }

    private void rV(String str) {
        if (this.fWx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fWx) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rV(str);
                }
            }
        }
    }

    private boolean h(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).eAA) != null && advertAppInfo.abE() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b xd(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.gdj == null || this.gdj.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.gdj.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.gdj.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.gdj.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (h(this.gdj.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.gdj.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.gdj.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.gdj.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.gdj.get(i4)) != null && lVar.threadData != null && str.equals(lVar.threadData.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.gdj.get(i4)).position;
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
        if (this.gdw != null) {
            this.gdw.onPause();
        }
        if (this.gdB != null) {
            this.gdB.onPause();
        }
        if (this.gdu != null) {
            this.gdu.onPause();
        }
    }

    public void onResume() {
        if (this.gdw != null) {
            this.gdw.onResume();
        }
        if (this.gdB != null) {
            this.gdB.onResume();
        }
        if (this.gdu != null) {
            this.gdu.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.gdw != null) {
            this.gdw.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gdj;
    }
}

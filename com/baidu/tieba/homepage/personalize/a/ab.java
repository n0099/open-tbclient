package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class ab {
    private List<com.baidu.adp.widget.ListView.a> gFW;
    private com.baidu.adp.widget.ListView.r hdX;
    private List<com.baidu.adp.widget.ListView.m> hdY;
    private a hdZ;
    private com.baidu.adp.widget.ListView.a heA;
    private com.baidu.adp.widget.ListView.a heB;
    private com.baidu.adp.widget.ListView.a heC;
    private com.baidu.adp.widget.ListView.a heD;
    private com.baidu.adp.widget.ListView.a heE;
    private com.baidu.adp.widget.ListView.a heF;
    private com.baidu.adp.widget.ListView.a heG;
    private boolean heH;
    private boolean heI;
    private z hea;
    private n heb;
    private w hec;
    private i hed;
    private j hee;
    private k hef;
    private q heg;
    private h heh;
    private g hei;
    private f hej;
    private x hek;
    private e hel;
    private m hem;
    private y hen;
    private b heo;
    private u hep;
    private t heq;
    private v her;
    private s hes;
    private n het;
    private y heu;
    private l hev;
    private o hew;
    private p hex;
    private r hey;
    private c hez;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener gFY = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.bPa();
                if (ab.this.hdY != null) {
                    ab.this.ac(ab.this.hdY);
                }
            }
        }
    };
    private CustomMessageListener dag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ab.this.av(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ab.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.cQO = true;
                ab.this.av(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ab.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.cQO = false;
                ab.this.av(bVar);
            }
        }
    };
    private CustomMessageListener fJP = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b BS;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (BS = ab.this.BS(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, BS));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> gWx = new ArrayList();

    public ab(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.hdX = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eP(context);
        b(rVar);
        rVar.addAdapters(this.gWx);
    }

    private void eP(Context context) {
        this.hdZ = new a(this.mPageContext);
        this.hea = new z(this.mPageContext);
        this.heb = new n(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.hec = new w(this.mPageContext, com.baidu.tieba.card.data.k.fNl);
        this.hed = new i(this.mPageContext, com.baidu.tieba.card.data.k.fNr);
        this.hee = new j(this.mPageContext, com.baidu.tieba.card.data.k.fNs);
        this.hef = new k(this.mPageContext, com.baidu.tieba.card.data.k.fNt);
        this.heg = new q(this.mPageContext, com.baidu.tieba.card.data.k.fNu);
        this.heh = new h(this.mPageContext, com.baidu.tieba.card.data.k.fNm);
        this.hei = new g(this.mPageContext, com.baidu.tieba.card.data.k.fNo);
        this.hej = new f(this.mPageContext, com.baidu.tieba.card.data.k.fNp);
        this.hek = new x(this.mPageContext, com.baidu.tieba.card.data.l.cRA);
        this.hem = new m(this.mPageContext, com.baidu.tieba.card.data.k.cRy);
        this.hen = new y(this.mPageContext, com.baidu.tieba.card.data.l.fNB);
        this.heo = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.hep = new u(this.mPageContext, com.baidu.tieba.card.data.k.cRE);
        this.heq = new t(this.mPageContext, com.baidu.tieba.card.data.k.cRF);
        this.her = new v(this.mPageContext, com.baidu.tieba.card.data.k.cRH);
        this.hes = new s(this.mPageContext, com.baidu.tieba.card.data.k.cRG);
        this.het = new n(this.mPageContext, com.baidu.tieba.card.data.k.fNj);
        this.heu = new y(this.mPageContext, com.baidu.tieba.card.data.l.fNC);
        this.hev = new l(this.mPageContext, com.baidu.tieba.card.data.k.fNk);
        this.hew = new o(this.mPageContext, com.baidu.tieba.card.data.k.cRL);
        this.hex = new p(this.mPageContext, com.baidu.tieba.card.data.k.cRM);
        this.hey = new r(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.hhJ);
        this.hez = new c(this.mPageContext, com.baidu.tieba.card.data.e.fMM);
        this.hez.setFrom(0);
        this.hel = new e(this.mPageContext, com.baidu.tieba.card.data.k.fNq);
        this.gWx.add(this.hdZ);
        this.gWx.add(this.hea);
        this.gWx.add(this.hen);
        this.gWx.add(this.heb);
        this.gWx.add(this.hec);
        this.gWx.add(this.hed);
        this.gWx.add(this.hee);
        this.gWx.add(this.hef);
        this.gWx.add(this.heg);
        this.gWx.add(this.heh);
        this.gWx.add(this.hei);
        this.gWx.add(this.hej);
        this.gWx.add(this.hek);
        this.gWx.add(this.hem);
        this.gWx.add(this.het);
        this.gWx.add(this.heu);
        this.gWx.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gWx.add(this.heo);
        this.gWx.add(this.hep);
        this.gWx.add(this.heq);
        this.gWx.add(this.hes);
        this.gWx.add(this.her);
        this.gWx.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.TYPE));
        this.gWx.add(this.hev);
        this.gWx.add(this.hew);
        this.gWx.add(this.hex);
        this.gWx.add(this.hey);
        this.gWx.add(this.hez);
        this.gWx.add(this.hel);
        bOZ();
        bOY();
        wP("page_recommend");
    }

    private void bOY() {
        if (!bj.cRP.get()) {
            AdvertAppInfo.cMV.set(false);
            return;
        }
        this.heA = com.baidu.tieba.recapp.r.cCw().c(this.mPageContext, AdvertAppInfo.cMM);
        this.heB = com.baidu.tieba.recapp.r.cCw().c(this.mPageContext, AdvertAppInfo.cMP);
        this.heC = com.baidu.tieba.recapp.r.cCw().c(this.mPageContext, AdvertAppInfo.cMQ);
        this.heD = com.baidu.tieba.recapp.r.cCw().c(this.mPageContext, AdvertAppInfo.cMR);
        this.heE = com.baidu.tieba.recapp.r.cCw().c(this.mPageContext, AdvertAppInfo.cMS);
        this.heF = com.baidu.tieba.recapp.r.cCw().c(this.mPageContext, AdvertAppInfo.cMT);
        this.heG = com.baidu.tieba.recapp.r.cCw().c(this.mPageContext, AdvertAppInfo.cMU);
        this.gWx.add(this.heA);
        this.gWx.add(this.heB);
        this.gWx.add(this.heC);
        this.gWx.add(this.heD);
        this.gWx.add(this.heE);
        this.gWx.add(this.heF);
        this.gWx.add(this.heG);
        AdvertAppInfo.cMV.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.heb.a(eVar);
        this.hec.a(eVar);
        this.hed.a(eVar);
        this.hef.a(eVar);
        this.heg.a(eVar);
        this.heh.a(eVar);
        this.hei.a(eVar);
        this.hej.a(eVar);
        this.hek.a(eVar);
        this.hel.a(eVar);
        this.hen.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.hec.b(rVar);
        this.hed.b(rVar);
        this.hee.b(rVar);
        this.hef.b(rVar);
        this.heg.b(rVar);
        this.heh.b(rVar);
        this.hei.b(rVar);
        this.hej.b(rVar);
        this.hel.b(rVar);
        this.hek.b(rVar);
        this.hez.b(rVar);
        this.heq.b(rVar);
        this.heq.b(rVar);
        this.hes.b(rVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.m> list, int i) {
        com.baidu.tieba.tbadkCore.s.o(list, 2);
        ViewGroup listView = this.hdX.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top2 = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).km();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top2);
                ((BdRecyclerView) listView).kn();
            }
        }
        this.hdX.setData(list);
        this.hdY = list;
    }

    public void ac(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.s.o(list, 2);
        this.hdX.setData(list);
        this.hdY = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.hdZ.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.hdX != null) {
            this.hdX.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.heb != null) {
            this.heb.setFromCDN(z);
            this.het.setFromCDN(z);
            this.hen.setFromCDN(z);
            this.heu.setFromCDN(z);
            this.hem.setFromCDN(z);
            this.hep.setFromCDN(z);
        }
        if (this.hef != null) {
            this.hef.setFromCDN(z);
        }
        if (this.hel != null) {
            this.hel.setFromCDN(z);
        }
        if (this.heB != null && (this.heB instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.heB).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.heb != null) {
            this.heb.dBx = bdUniqueId;
        }
        if (this.hec != null) {
            this.hec.dBx = bdUniqueId;
        }
        if (this.hed != null) {
            this.hed.dBx = bdUniqueId;
        }
        if (this.hee != null) {
            this.hee.dBx = bdUniqueId;
        }
        if (this.hef != null) {
            this.hef.dBx = bdUniqueId;
        }
        if (this.heg != null) {
            this.heg.dBx = bdUniqueId;
        }
        if (this.heh != null) {
            this.heh.dBx = bdUniqueId;
        }
        if (this.hei != null) {
            this.hei.dBx = bdUniqueId;
        }
        if (this.hej != null) {
            this.hej.dBx = bdUniqueId;
        }
        if (this.hem != null) {
            this.hem.dBx = bdUniqueId;
        }
        if (this.hen != null) {
            this.hen.dBx = bdUniqueId;
        }
        if (this.hek != null) {
            this.hek.dBx = bdUniqueId;
        }
        if (this.hdZ != null) {
            this.hdZ.setPageUniqueId(bdUniqueId);
        }
        if (this.heo != null) {
            this.heo.dBx = bdUniqueId;
        }
        if (this.hep != null) {
            this.hep.dBx = bdUniqueId;
        }
        if (this.heq != null) {
            this.heq.dBx = bdUniqueId;
        }
        if (this.hes != null) {
            this.hes.dBx = bdUniqueId;
        }
        if (this.her != null) {
            this.her.dBx = bdUniqueId;
        }
        if (this.het != null) {
            this.het.dBx = bdUniqueId;
        }
        if (this.heu != null) {
            this.heu.dBx = bdUniqueId;
        }
        if (this.hew != null) {
            this.hew.dBx = bdUniqueId;
        }
        if (this.hex != null) {
            this.hex.dBx = bdUniqueId;
        }
        if (this.hey != null) {
            this.hey.dBx = bdUniqueId;
        }
        if (this.hez != null) {
            this.hez.dBx = bdUniqueId;
        }
        if (this.hel != null) {
            this.hel.dBx = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFW)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gFW) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.dag.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dag);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.fJP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fJP);
        if (!this.heI) {
            this.gFY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gFY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.hdY != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hdY.iterator();
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

    private void bOZ() {
        this.heI = bPa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPa() {
        if (this.gFW == null || this.gFW.size() <= 0) {
            this.gFW = new ArrayList();
            ArrayList<BdUniqueId> cKt = com.baidu.tieba.tbadkCore.s.cKt();
            if (cKt == null || cKt.size() <= 0) {
                return false;
            }
            int size = cKt.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cdl().a(this.mPageContext, cKt.get(i), 2);
                if (this.heH) {
                    a.setBusinessType(3);
                }
                if (this.heb != null && this.heb.dBx != null) {
                    a.setUniqueId(this.heb.dBx);
                }
                this.gFW.add(a);
            }
            this.hdX.addAdapters(this.gFW);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.heb != null) {
            this.heb.setEventCallback(aVar);
        }
        if (this.heg != null) {
            this.heg.setEventCallback(aVar);
        }
        if (this.hee != null) {
            this.hee.setEventCallback(aVar);
        }
        if (this.hem != null) {
            this.hem.setEventCallback(aVar);
        }
        if (this.hen != null) {
            this.hen.setEventCallback(aVar);
        }
        if (this.heo != null) {
            this.heo.setEventCallback(aVar);
        }
        if (this.hep != null) {
            this.hep.setEventCallback(aVar);
        }
        if (this.heq != null) {
            this.heq.setEventCallback(aVar);
        }
        if (this.hes != null) {
            this.hes.setEventCallback(aVar);
        }
        if (this.her != null) {
            this.her.setEventCallback(aVar);
        }
        if (this.het != null) {
            this.het.setEventCallback(aVar);
        }
        if (this.heu != null) {
            this.heu.setEventCallback(aVar);
        }
        if (this.hew != null) {
            this.hew.setEventCallback(aVar);
        }
        if (this.hex != null) {
            this.hex.setEventCallback(aVar);
        }
        if (this.hey != null) {
            this.hey.setEventCallback(aVar);
        }
        if (this.hez != null) {
            this.hez.setEventCallback(aVar);
        }
    }

    private void wP(String str) {
        if (this.gWx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gWx) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wP(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).fML) != null && advertAppInfo.aAp() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b BS(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.hdY == null || this.hdY.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.hdY.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.hdY.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.f ? i3 + 1 : i3;
            if (this.hdY.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.hdY.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.hdY.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.hdY.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.hdY.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.hdY.get(i4)) != null && lVar.cRg != null && str.equals(lVar.cRg.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.hdY.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.az(i6 - i >= -1 ? i6 - i : -1);
        bVar.aA(i7);
        bVar.aB(i2);
        return bVar;
    }

    public void onPause() {
        if (this.hen != null) {
            this.hen.onPause();
        }
        if (this.heu != null) {
            this.heu.onPause();
        }
        if (this.hek != null) {
            this.hek.onPause();
        }
    }

    public void onResume() {
        if (this.hen != null) {
            this.hen.onResume();
        }
        if (this.heu != null) {
            this.heu.onResume();
        }
        if (this.hek != null) {
            this.hek.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hen != null) {
            this.hen.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.hdY;
    }
}

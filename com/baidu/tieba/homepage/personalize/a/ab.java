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
    private List<com.baidu.adp.widget.ListView.a> gFI;
    private com.baidu.adp.widget.ListView.r hdJ;
    private List<com.baidu.adp.widget.ListView.m> hdK;
    private a hdL;
    private z hdM;
    private n hdN;
    private w hdO;
    private i hdP;
    private j hdQ;
    private k hdR;
    private q hdS;
    private h hdT;
    private g hdU;
    private f hdV;
    private x hdW;
    private e hdX;
    private m hdY;
    private y hdZ;
    private b hea;
    private u heb;
    private t hec;
    private v hed;
    private s hee;
    private n hef;
    private y heg;
    private l heh;
    private o hei;
    private p hej;
    private r hek;
    private c hel;
    private com.baidu.adp.widget.ListView.a hem;
    private com.baidu.adp.widget.ListView.a hen;
    private com.baidu.adp.widget.ListView.a heo;
    private com.baidu.adp.widget.ListView.a hep;
    private com.baidu.adp.widget.ListView.a heq;
    private com.baidu.adp.widget.ListView.a her;
    private com.baidu.adp.widget.ListView.a hes;
    private boolean het;
    private boolean heu;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener gFK = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.bOX();
                if (ab.this.hdK != null) {
                    ab.this.ac(ab.this.hdK);
                }
            }
        }
    };
    private CustomMessageListener dae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
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
                bVar.cQM = true;
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
                bVar.cQM = false;
                ab.this.av(bVar);
            }
        }
    };
    private CustomMessageListener fJA = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b BR;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (BR = ab.this.BR(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, BR));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> gWj = new ArrayList();

    public ab(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.hdJ = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eP(context);
        b(rVar);
        rVar.addAdapters(this.gWj);
    }

    private void eP(Context context) {
        this.hdL = new a(this.mPageContext);
        this.hdM = new z(this.mPageContext);
        this.hdN = new n(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.hdO = new w(this.mPageContext, com.baidu.tieba.card.data.k.fMW);
        this.hdP = new i(this.mPageContext, com.baidu.tieba.card.data.k.fNc);
        this.hdQ = new j(this.mPageContext, com.baidu.tieba.card.data.k.fNd);
        this.hdR = new k(this.mPageContext, com.baidu.tieba.card.data.k.fNe);
        this.hdS = new q(this.mPageContext, com.baidu.tieba.card.data.k.fNf);
        this.hdT = new h(this.mPageContext, com.baidu.tieba.card.data.k.fMX);
        this.hdU = new g(this.mPageContext, com.baidu.tieba.card.data.k.fMZ);
        this.hdV = new f(this.mPageContext, com.baidu.tieba.card.data.k.fNa);
        this.hdW = new x(this.mPageContext, com.baidu.tieba.card.data.l.cRy);
        this.hdY = new m(this.mPageContext, com.baidu.tieba.card.data.k.cRw);
        this.hdZ = new y(this.mPageContext, com.baidu.tieba.card.data.l.fNm);
        this.hea = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.heb = new u(this.mPageContext, com.baidu.tieba.card.data.k.cRC);
        this.hec = new t(this.mPageContext, com.baidu.tieba.card.data.k.cRD);
        this.hed = new v(this.mPageContext, com.baidu.tieba.card.data.k.cRF);
        this.hee = new s(this.mPageContext, com.baidu.tieba.card.data.k.cRE);
        this.hef = new n(this.mPageContext, com.baidu.tieba.card.data.k.fMU);
        this.heg = new y(this.mPageContext, com.baidu.tieba.card.data.l.fNn);
        this.heh = new l(this.mPageContext, com.baidu.tieba.card.data.k.fMV);
        this.hei = new o(this.mPageContext, com.baidu.tieba.card.data.k.cRJ);
        this.hej = new p(this.mPageContext, com.baidu.tieba.card.data.k.cRK);
        this.hek = new r(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.hhv);
        this.hel = new c(this.mPageContext, com.baidu.tieba.card.data.e.fMx);
        this.hel.setFrom(0);
        this.hdX = new e(this.mPageContext, com.baidu.tieba.card.data.k.fNb);
        this.gWj.add(this.hdL);
        this.gWj.add(this.hdM);
        this.gWj.add(this.hdZ);
        this.gWj.add(this.hdN);
        this.gWj.add(this.hdO);
        this.gWj.add(this.hdP);
        this.gWj.add(this.hdQ);
        this.gWj.add(this.hdR);
        this.gWj.add(this.hdS);
        this.gWj.add(this.hdT);
        this.gWj.add(this.hdU);
        this.gWj.add(this.hdV);
        this.gWj.add(this.hdW);
        this.gWj.add(this.hdY);
        this.gWj.add(this.hef);
        this.gWj.add(this.heg);
        this.gWj.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gWj.add(this.hea);
        this.gWj.add(this.heb);
        this.gWj.add(this.hec);
        this.gWj.add(this.hee);
        this.gWj.add(this.hed);
        this.gWj.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.TYPE));
        this.gWj.add(this.heh);
        this.gWj.add(this.hei);
        this.gWj.add(this.hej);
        this.gWj.add(this.hek);
        this.gWj.add(this.hel);
        this.gWj.add(this.hdX);
        bOW();
        bOV();
        wO("page_recommend");
    }

    private void bOV() {
        if (!bj.cRN.get()) {
            AdvertAppInfo.cMT.set(false);
            return;
        }
        this.hem = com.baidu.tieba.recapp.r.cCt().c(this.mPageContext, AdvertAppInfo.cMK);
        this.hen = com.baidu.tieba.recapp.r.cCt().c(this.mPageContext, AdvertAppInfo.cMN);
        this.heo = com.baidu.tieba.recapp.r.cCt().c(this.mPageContext, AdvertAppInfo.cMO);
        this.hep = com.baidu.tieba.recapp.r.cCt().c(this.mPageContext, AdvertAppInfo.cMP);
        this.heq = com.baidu.tieba.recapp.r.cCt().c(this.mPageContext, AdvertAppInfo.cMQ);
        this.her = com.baidu.tieba.recapp.r.cCt().c(this.mPageContext, AdvertAppInfo.cMR);
        this.hes = com.baidu.tieba.recapp.r.cCt().c(this.mPageContext, AdvertAppInfo.cMS);
        this.gWj.add(this.hem);
        this.gWj.add(this.hen);
        this.gWj.add(this.heo);
        this.gWj.add(this.hep);
        this.gWj.add(this.heq);
        this.gWj.add(this.her);
        this.gWj.add(this.hes);
        AdvertAppInfo.cMT.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hdN.a(eVar);
        this.hdO.a(eVar);
        this.hdP.a(eVar);
        this.hdR.a(eVar);
        this.hdS.a(eVar);
        this.hdT.a(eVar);
        this.hdU.a(eVar);
        this.hdV.a(eVar);
        this.hdW.a(eVar);
        this.hdX.a(eVar);
        this.hdZ.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.hdO.b(rVar);
        this.hdP.b(rVar);
        this.hdQ.b(rVar);
        this.hdR.b(rVar);
        this.hdS.b(rVar);
        this.hdT.b(rVar);
        this.hdU.b(rVar);
        this.hdV.b(rVar);
        this.hdX.b(rVar);
        this.hdW.b(rVar);
        this.hel.b(rVar);
        this.hec.b(rVar);
        this.hec.b(rVar);
        this.hee.b(rVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.m> list, int i) {
        com.baidu.tieba.tbadkCore.s.o(list, 2);
        ViewGroup listView = this.hdJ.getListView();
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
        this.hdJ.setData(list);
        this.hdK = list;
    }

    public void ac(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.s.o(list, 2);
        this.hdJ.setData(list);
        this.hdK = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.hdL.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.hdJ != null) {
            this.hdJ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.hdN != null) {
            this.hdN.setFromCDN(z);
            this.hef.setFromCDN(z);
            this.hdZ.setFromCDN(z);
            this.heg.setFromCDN(z);
            this.hdY.setFromCDN(z);
            this.heb.setFromCDN(z);
        }
        if (this.hdR != null) {
            this.hdR.setFromCDN(z);
        }
        if (this.hdX != null) {
            this.hdX.setFromCDN(z);
        }
        if (this.hen != null && (this.hen instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hen).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hdN != null) {
            this.hdN.dBj = bdUniqueId;
        }
        if (this.hdO != null) {
            this.hdO.dBj = bdUniqueId;
        }
        if (this.hdP != null) {
            this.hdP.dBj = bdUniqueId;
        }
        if (this.hdQ != null) {
            this.hdQ.dBj = bdUniqueId;
        }
        if (this.hdR != null) {
            this.hdR.dBj = bdUniqueId;
        }
        if (this.hdS != null) {
            this.hdS.dBj = bdUniqueId;
        }
        if (this.hdT != null) {
            this.hdT.dBj = bdUniqueId;
        }
        if (this.hdU != null) {
            this.hdU.dBj = bdUniqueId;
        }
        if (this.hdV != null) {
            this.hdV.dBj = bdUniqueId;
        }
        if (this.hdY != null) {
            this.hdY.dBj = bdUniqueId;
        }
        if (this.hdZ != null) {
            this.hdZ.dBj = bdUniqueId;
        }
        if (this.hdW != null) {
            this.hdW.dBj = bdUniqueId;
        }
        if (this.hdL != null) {
            this.hdL.setPageUniqueId(bdUniqueId);
        }
        if (this.hea != null) {
            this.hea.dBj = bdUniqueId;
        }
        if (this.heb != null) {
            this.heb.dBj = bdUniqueId;
        }
        if (this.hec != null) {
            this.hec.dBj = bdUniqueId;
        }
        if (this.hee != null) {
            this.hee.dBj = bdUniqueId;
        }
        if (this.hed != null) {
            this.hed.dBj = bdUniqueId;
        }
        if (this.hef != null) {
            this.hef.dBj = bdUniqueId;
        }
        if (this.heg != null) {
            this.heg.dBj = bdUniqueId;
        }
        if (this.hei != null) {
            this.hei.dBj = bdUniqueId;
        }
        if (this.hej != null) {
            this.hej.dBj = bdUniqueId;
        }
        if (this.hek != null) {
            this.hek.dBj = bdUniqueId;
        }
        if (this.hel != null) {
            this.hel.dBj = bdUniqueId;
        }
        if (this.hdX != null) {
            this.hdX.dBj = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFI)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gFI) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.dae.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dae);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.fJA.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fJA);
        if (!this.heu) {
            this.gFK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gFK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.hdK != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hdK.iterator();
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

    private void bOW() {
        this.heu = bOX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOX() {
        if (this.gFI == null || this.gFI.size() <= 0) {
            this.gFI = new ArrayList();
            ArrayList<BdUniqueId> cKq = com.baidu.tieba.tbadkCore.s.cKq();
            if (cKq == null || cKq.size() <= 0) {
                return false;
            }
            int size = cKq.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cdi().a(this.mPageContext, cKq.get(i), 2);
                if (this.het) {
                    a.setBusinessType(3);
                }
                if (this.hdN != null && this.hdN.dBj != null) {
                    a.setUniqueId(this.hdN.dBj);
                }
                this.gFI.add(a);
            }
            this.hdJ.addAdapters(this.gFI);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hdN != null) {
            this.hdN.setEventCallback(aVar);
        }
        if (this.hdS != null) {
            this.hdS.setEventCallback(aVar);
        }
        if (this.hdQ != null) {
            this.hdQ.setEventCallback(aVar);
        }
        if (this.hdY != null) {
            this.hdY.setEventCallback(aVar);
        }
        if (this.hdZ != null) {
            this.hdZ.setEventCallback(aVar);
        }
        if (this.hea != null) {
            this.hea.setEventCallback(aVar);
        }
        if (this.heb != null) {
            this.heb.setEventCallback(aVar);
        }
        if (this.hec != null) {
            this.hec.setEventCallback(aVar);
        }
        if (this.hee != null) {
            this.hee.setEventCallback(aVar);
        }
        if (this.hed != null) {
            this.hed.setEventCallback(aVar);
        }
        if (this.hef != null) {
            this.hef.setEventCallback(aVar);
        }
        if (this.heg != null) {
            this.heg.setEventCallback(aVar);
        }
        if (this.hei != null) {
            this.hei.setEventCallback(aVar);
        }
        if (this.hej != null) {
            this.hej.setEventCallback(aVar);
        }
        if (this.hek != null) {
            this.hek.setEventCallback(aVar);
        }
        if (this.hel != null) {
            this.hel.setEventCallback(aVar);
        }
    }

    private void wO(String str) {
        if (this.gWj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gWj) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wO(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).fMw) != null && advertAppInfo.aAn() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b BR(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.hdK == null || this.hdK.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.hdK.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.hdK.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.f ? i3 + 1 : i3;
            if (this.hdK.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.hdK.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.hdK.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.hdK.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.hdK.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.hdK.get(i4)) != null && lVar.cRe != null && str.equals(lVar.cRe.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.hdK.get(i4)).position;
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
        if (this.hdZ != null) {
            this.hdZ.onPause();
        }
        if (this.heg != null) {
            this.heg.onPause();
        }
        if (this.hdW != null) {
            this.hdW.onPause();
        }
    }

    public void onResume() {
        if (this.hdZ != null) {
            this.hdZ.onResume();
        }
        if (this.heg != null) {
            this.heg.onResume();
        }
        if (this.hdW != null) {
            this.hdW.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hdZ != null) {
            this.hdZ.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.hdK;
    }
}

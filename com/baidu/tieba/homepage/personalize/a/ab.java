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
    private List<com.baidu.adp.widget.ListView.a> gFK;
    private com.baidu.adp.widget.ListView.r hdL;
    private List<com.baidu.adp.widget.ListView.m> hdM;
    private a hdN;
    private z hdO;
    private n hdP;
    private w hdQ;
    private i hdR;
    private j hdS;
    private k hdT;
    private q hdU;
    private h hdV;
    private g hdW;
    private f hdX;
    private x hdY;
    private e hdZ;
    private m hea;
    private y heb;
    private b hec;
    private u hed;
    private t hee;
    private v hef;
    private s heg;
    private n heh;
    private y hei;
    private l hej;
    private o hek;
    private p hel;
    private r hem;
    private c hen;
    private com.baidu.adp.widget.ListView.a heo;
    private com.baidu.adp.widget.ListView.a hep;
    private com.baidu.adp.widget.ListView.a heq;
    private com.baidu.adp.widget.ListView.a her;
    private com.baidu.adp.widget.ListView.a hes;
    private com.baidu.adp.widget.ListView.a het;
    private com.baidu.adp.widget.ListView.a heu;
    private boolean hev;
    private boolean hew;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener gFM = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.bOZ();
                if (ab.this.hdM != null) {
                    ab.this.ac(ab.this.hdM);
                }
            }
        }
    };
    private CustomMessageListener daf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
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
                bVar.cQN = true;
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
                bVar.cQN = false;
                ab.this.av(bVar);
            }
        }
    };
    private CustomMessageListener fJC = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ab.5
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
    private List<com.baidu.adp.widget.ListView.a> gWl = new ArrayList();

    public ab(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.hdL = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eP(context);
        b(rVar);
        rVar.addAdapters(this.gWl);
    }

    private void eP(Context context) {
        this.hdN = new a(this.mPageContext);
        this.hdO = new z(this.mPageContext);
        this.hdP = new n(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.hdQ = new w(this.mPageContext, com.baidu.tieba.card.data.k.fMY);
        this.hdR = new i(this.mPageContext, com.baidu.tieba.card.data.k.fNe);
        this.hdS = new j(this.mPageContext, com.baidu.tieba.card.data.k.fNf);
        this.hdT = new k(this.mPageContext, com.baidu.tieba.card.data.k.fNg);
        this.hdU = new q(this.mPageContext, com.baidu.tieba.card.data.k.fNh);
        this.hdV = new h(this.mPageContext, com.baidu.tieba.card.data.k.fMZ);
        this.hdW = new g(this.mPageContext, com.baidu.tieba.card.data.k.fNb);
        this.hdX = new f(this.mPageContext, com.baidu.tieba.card.data.k.fNc);
        this.hdY = new x(this.mPageContext, com.baidu.tieba.card.data.l.cRz);
        this.hea = new m(this.mPageContext, com.baidu.tieba.card.data.k.cRx);
        this.heb = new y(this.mPageContext, com.baidu.tieba.card.data.l.fNo);
        this.hec = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.hed = new u(this.mPageContext, com.baidu.tieba.card.data.k.cRD);
        this.hee = new t(this.mPageContext, com.baidu.tieba.card.data.k.cRE);
        this.hef = new v(this.mPageContext, com.baidu.tieba.card.data.k.cRG);
        this.heg = new s(this.mPageContext, com.baidu.tieba.card.data.k.cRF);
        this.heh = new n(this.mPageContext, com.baidu.tieba.card.data.k.fMW);
        this.hei = new y(this.mPageContext, com.baidu.tieba.card.data.l.fNp);
        this.hej = new l(this.mPageContext, com.baidu.tieba.card.data.k.fMX);
        this.hek = new o(this.mPageContext, com.baidu.tieba.card.data.k.cRK);
        this.hel = new p(this.mPageContext, com.baidu.tieba.card.data.k.cRL);
        this.hem = new r(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.hhx);
        this.hen = new c(this.mPageContext, com.baidu.tieba.card.data.e.fMz);
        this.hen.setFrom(0);
        this.hdZ = new e(this.mPageContext, com.baidu.tieba.card.data.k.fNd);
        this.gWl.add(this.hdN);
        this.gWl.add(this.hdO);
        this.gWl.add(this.heb);
        this.gWl.add(this.hdP);
        this.gWl.add(this.hdQ);
        this.gWl.add(this.hdR);
        this.gWl.add(this.hdS);
        this.gWl.add(this.hdT);
        this.gWl.add(this.hdU);
        this.gWl.add(this.hdV);
        this.gWl.add(this.hdW);
        this.gWl.add(this.hdX);
        this.gWl.add(this.hdY);
        this.gWl.add(this.hea);
        this.gWl.add(this.heh);
        this.gWl.add(this.hei);
        this.gWl.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gWl.add(this.hec);
        this.gWl.add(this.hed);
        this.gWl.add(this.hee);
        this.gWl.add(this.heg);
        this.gWl.add(this.hef);
        this.gWl.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.TYPE));
        this.gWl.add(this.hej);
        this.gWl.add(this.hek);
        this.gWl.add(this.hel);
        this.gWl.add(this.hem);
        this.gWl.add(this.hen);
        this.gWl.add(this.hdZ);
        bOY();
        bOX();
        wO("page_recommend");
    }

    private void bOX() {
        if (!bj.cRO.get()) {
            AdvertAppInfo.cMU.set(false);
            return;
        }
        this.heo = com.baidu.tieba.recapp.r.cCv().c(this.mPageContext, AdvertAppInfo.cML);
        this.hep = com.baidu.tieba.recapp.r.cCv().c(this.mPageContext, AdvertAppInfo.cMO);
        this.heq = com.baidu.tieba.recapp.r.cCv().c(this.mPageContext, AdvertAppInfo.cMP);
        this.her = com.baidu.tieba.recapp.r.cCv().c(this.mPageContext, AdvertAppInfo.cMQ);
        this.hes = com.baidu.tieba.recapp.r.cCv().c(this.mPageContext, AdvertAppInfo.cMR);
        this.het = com.baidu.tieba.recapp.r.cCv().c(this.mPageContext, AdvertAppInfo.cMS);
        this.heu = com.baidu.tieba.recapp.r.cCv().c(this.mPageContext, AdvertAppInfo.cMT);
        this.gWl.add(this.heo);
        this.gWl.add(this.hep);
        this.gWl.add(this.heq);
        this.gWl.add(this.her);
        this.gWl.add(this.hes);
        this.gWl.add(this.het);
        this.gWl.add(this.heu);
        AdvertAppInfo.cMU.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hdP.a(eVar);
        this.hdQ.a(eVar);
        this.hdR.a(eVar);
        this.hdT.a(eVar);
        this.hdU.a(eVar);
        this.hdV.a(eVar);
        this.hdW.a(eVar);
        this.hdX.a(eVar);
        this.hdY.a(eVar);
        this.hdZ.a(eVar);
        this.heb.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.hdQ.b(rVar);
        this.hdR.b(rVar);
        this.hdS.b(rVar);
        this.hdT.b(rVar);
        this.hdU.b(rVar);
        this.hdV.b(rVar);
        this.hdW.b(rVar);
        this.hdX.b(rVar);
        this.hdZ.b(rVar);
        this.hdY.b(rVar);
        this.hen.b(rVar);
        this.hee.b(rVar);
        this.hee.b(rVar);
        this.heg.b(rVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.m> list, int i) {
        com.baidu.tieba.tbadkCore.s.o(list, 2);
        ViewGroup listView = this.hdL.getListView();
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
        this.hdL.setData(list);
        this.hdM = list;
    }

    public void ac(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.s.o(list, 2);
        this.hdL.setData(list);
        this.hdM = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.hdN.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.hdL != null) {
            this.hdL.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.hdP != null) {
            this.hdP.setFromCDN(z);
            this.heh.setFromCDN(z);
            this.heb.setFromCDN(z);
            this.hei.setFromCDN(z);
            this.hea.setFromCDN(z);
            this.hed.setFromCDN(z);
        }
        if (this.hdT != null) {
            this.hdT.setFromCDN(z);
        }
        if (this.hdZ != null) {
            this.hdZ.setFromCDN(z);
        }
        if (this.hep != null && (this.hep instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hep).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hdP != null) {
            this.hdP.dBk = bdUniqueId;
        }
        if (this.hdQ != null) {
            this.hdQ.dBk = bdUniqueId;
        }
        if (this.hdR != null) {
            this.hdR.dBk = bdUniqueId;
        }
        if (this.hdS != null) {
            this.hdS.dBk = bdUniqueId;
        }
        if (this.hdT != null) {
            this.hdT.dBk = bdUniqueId;
        }
        if (this.hdU != null) {
            this.hdU.dBk = bdUniqueId;
        }
        if (this.hdV != null) {
            this.hdV.dBk = bdUniqueId;
        }
        if (this.hdW != null) {
            this.hdW.dBk = bdUniqueId;
        }
        if (this.hdX != null) {
            this.hdX.dBk = bdUniqueId;
        }
        if (this.hea != null) {
            this.hea.dBk = bdUniqueId;
        }
        if (this.heb != null) {
            this.heb.dBk = bdUniqueId;
        }
        if (this.hdY != null) {
            this.hdY.dBk = bdUniqueId;
        }
        if (this.hdN != null) {
            this.hdN.setPageUniqueId(bdUniqueId);
        }
        if (this.hec != null) {
            this.hec.dBk = bdUniqueId;
        }
        if (this.hed != null) {
            this.hed.dBk = bdUniqueId;
        }
        if (this.hee != null) {
            this.hee.dBk = bdUniqueId;
        }
        if (this.heg != null) {
            this.heg.dBk = bdUniqueId;
        }
        if (this.hef != null) {
            this.hef.dBk = bdUniqueId;
        }
        if (this.heh != null) {
            this.heh.dBk = bdUniqueId;
        }
        if (this.hei != null) {
            this.hei.dBk = bdUniqueId;
        }
        if (this.hek != null) {
            this.hek.dBk = bdUniqueId;
        }
        if (this.hel != null) {
            this.hel.dBk = bdUniqueId;
        }
        if (this.hem != null) {
            this.hem.dBk = bdUniqueId;
        }
        if (this.hen != null) {
            this.hen.dBk = bdUniqueId;
        }
        if (this.hdZ != null) {
            this.hdZ.dBk = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFK)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gFK) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.daf.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.daf);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.fJC.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fJC);
        if (!this.hew) {
            this.gFM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gFM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.hdM != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hdM.iterator();
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

    private void bOY() {
        this.hew = bOZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOZ() {
        if (this.gFK == null || this.gFK.size() <= 0) {
            this.gFK = new ArrayList();
            ArrayList<BdUniqueId> cKs = com.baidu.tieba.tbadkCore.s.cKs();
            if (cKs == null || cKs.size() <= 0) {
                return false;
            }
            int size = cKs.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cdk().a(this.mPageContext, cKs.get(i), 2);
                if (this.hev) {
                    a.setBusinessType(3);
                }
                if (this.hdP != null && this.hdP.dBk != null) {
                    a.setUniqueId(this.hdP.dBk);
                }
                this.gFK.add(a);
            }
            this.hdL.addAdapters(this.gFK);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hdP != null) {
            this.hdP.setEventCallback(aVar);
        }
        if (this.hdU != null) {
            this.hdU.setEventCallback(aVar);
        }
        if (this.hdS != null) {
            this.hdS.setEventCallback(aVar);
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
        if (this.hed != null) {
            this.hed.setEventCallback(aVar);
        }
        if (this.hee != null) {
            this.hee.setEventCallback(aVar);
        }
        if (this.heg != null) {
            this.heg.setEventCallback(aVar);
        }
        if (this.hef != null) {
            this.hef.setEventCallback(aVar);
        }
        if (this.heh != null) {
            this.heh.setEventCallback(aVar);
        }
        if (this.hei != null) {
            this.hei.setEventCallback(aVar);
        }
        if (this.hek != null) {
            this.hek.setEventCallback(aVar);
        }
        if (this.hel != null) {
            this.hel.setEventCallback(aVar);
        }
        if (this.hem != null) {
            this.hem.setEventCallback(aVar);
        }
        if (this.hen != null) {
            this.hen.setEventCallback(aVar);
        }
    }

    private void wO(String str) {
        if (this.gWl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gWl) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wO(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).fMy) != null && advertAppInfo.aAp() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b BR(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.hdM == null || this.hdM.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.hdM.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.hdM.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.f ? i3 + 1 : i3;
            if (this.hdM.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.hdM.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.hdM.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.hdM.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.hdM.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.hdM.get(i4)) != null && lVar.cRf != null && str.equals(lVar.cRf.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.hdM.get(i4)).position;
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
        if (this.heb != null) {
            this.heb.onPause();
        }
        if (this.hei != null) {
            this.hei.onPause();
        }
        if (this.hdY != null) {
            this.hdY.onPause();
        }
    }

    public void onResume() {
        if (this.heb != null) {
            this.heb.onResume();
        }
        if (this.hei != null) {
            this.hei.onResume();
        }
        if (this.hdY != null) {
            this.hdY.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.heb != null) {
            this.heb.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.hdM;
    }
}

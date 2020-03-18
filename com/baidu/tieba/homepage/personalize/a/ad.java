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
public class ad {
    private List<com.baidu.adp.widget.ListView.a> gGU;
    private i hfA;
    private h hfB;
    private z hfC;
    private g hfD;
    private o hfE;
    private aa hfF;
    private c hfG;
    private w hfH;
    private v hfI;
    private x hfJ;
    private u hfK;
    private p hfL;
    private aa hfM;
    private n hfN;
    private q hfO;
    private r hfP;
    private t hfQ;
    private e hfR;
    private com.baidu.adp.widget.ListView.a hfS;
    private com.baidu.adp.widget.ListView.a hfT;
    private com.baidu.adp.widget.ListView.a hfU;
    private com.baidu.adp.widget.ListView.a hfV;
    private com.baidu.adp.widget.ListView.a hfW;
    private com.baidu.adp.widget.ListView.a hfX;
    private com.baidu.adp.widget.ListView.a hfY;
    private com.baidu.adp.widget.ListView.a hfZ;
    private com.baidu.adp.widget.ListView.r hfo;
    private List<com.baidu.adp.widget.ListView.m> hfp;
    private b hfq;
    private ab hfr;
    private d hfs;
    private p hft;
    private y hfu;
    private k hfv;
    private l hfw;
    private m hfx;
    private s hfy;
    private j hfz;
    private com.baidu.adp.widget.ListView.a hga;
    private boolean hgb;
    private boolean hgc;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener gGW = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ad.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ad.this.bPo();
                if (ad.this.hfp != null) {
                    ad.this.ac(ad.this.hfp);
                }
            }
        }
    };
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ad.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ad.this.av(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ad.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.cRb = true;
                ad.this.av(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ad.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.cRb = false;
                ad.this.av(bVar);
            }
        }
    };
    private CustomMessageListener fKx = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ad.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b BR;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (BR = ad.this.BR(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, BR));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> gXE = new ArrayList();

    public ad(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.hfo = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eO(context);
        b(rVar);
        rVar.addAdapters(this.gXE);
    }

    private void eO(Context context) {
        this.hfq = new b(this.mPageContext);
        this.hfr = new ab(this.mPageContext);
        this.hfs = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.hgC);
        this.hft = new p(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.hfu = new y(this.mPageContext, com.baidu.tieba.card.data.k.fNT);
        this.hfv = new k(this.mPageContext, com.baidu.tieba.card.data.k.fNZ);
        this.hfw = new l(this.mPageContext, com.baidu.tieba.card.data.k.fOa);
        this.hfx = new m(this.mPageContext, com.baidu.tieba.card.data.k.fOb);
        this.hfy = new s(this.mPageContext, com.baidu.tieba.card.data.k.fOc);
        this.hfz = new j(this.mPageContext, com.baidu.tieba.card.data.k.fNU);
        this.hfA = new i(this.mPageContext, com.baidu.tieba.card.data.k.fNW);
        this.hfB = new h(this.mPageContext, com.baidu.tieba.card.data.k.fNX);
        this.hfC = new z(this.mPageContext, com.baidu.tieba.card.data.l.cRN);
        this.hfE = new o(this.mPageContext, com.baidu.tieba.card.data.k.cRL);
        this.hfF = new aa(this.mPageContext, com.baidu.tieba.card.data.l.fOj);
        this.hfG = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.hfH = new w(this.mPageContext, com.baidu.tieba.card.data.k.cRR);
        this.hfI = new v(this.mPageContext, com.baidu.tieba.card.data.k.cRS);
        this.hfJ = new x(this.mPageContext, com.baidu.tieba.card.data.k.cRU);
        this.hfK = new u(this.mPageContext, com.baidu.tieba.card.data.k.cRT);
        this.hfL = new p(this.mPageContext, com.baidu.tieba.card.data.k.fNR);
        this.hfM = new aa(this.mPageContext, com.baidu.tieba.card.data.l.fOk);
        this.hfN = new n(this.mPageContext, com.baidu.tieba.card.data.k.fNS);
        this.hfO = new q(this.mPageContext, com.baidu.tieba.card.data.k.cRY);
        this.hfP = new r(this.mPageContext, com.baidu.tieba.card.data.k.cRZ);
        this.hfQ = new t(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.hjk);
        this.hfR = new e(this.mPageContext, com.baidu.tieba.card.data.e.fNu);
        this.hfR.setFrom(0);
        this.hfD = new g(this.mPageContext, com.baidu.tieba.card.data.k.fNY);
        this.gXE.add(this.hfq);
        this.gXE.add(this.hfr);
        this.gXE.add(this.hfs);
        this.gXE.add(this.hfF);
        this.gXE.add(this.hft);
        this.gXE.add(this.hfu);
        this.gXE.add(this.hfv);
        this.gXE.add(this.hfw);
        this.gXE.add(this.hfx);
        this.gXE.add(this.hfy);
        this.gXE.add(this.hfz);
        this.gXE.add(this.hfA);
        this.gXE.add(this.hfB);
        this.gXE.add(this.hfC);
        this.gXE.add(this.hfE);
        this.gXE.add(this.hfL);
        this.gXE.add(this.hfM);
        this.gXE.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gXE.add(this.hfG);
        this.gXE.add(this.hfH);
        this.gXE.add(this.hfI);
        this.gXE.add(this.hfK);
        this.gXE.add(this.hfJ);
        this.gXE.add(new ac(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.gXE.add(this.hfN);
        this.gXE.add(this.hfO);
        this.gXE.add(this.hfP);
        this.gXE.add(this.hfQ);
        this.gXE.add(this.hfR);
        this.gXE.add(this.hfD);
        bPn();
        bPm();
        wP("page_recommend");
    }

    private void bPm() {
        if (!bj.cSc.get()) {
            AdvertAppInfo.cNi.set(false);
            return;
        }
        this.hfS = com.baidu.tieba.recapp.r.cCQ().c(this.mPageContext, AdvertAppInfo.cMX);
        this.hfT = com.baidu.tieba.recapp.r.cCQ().c(this.mPageContext, AdvertAppInfo.cNa);
        this.hfU = com.baidu.tieba.recapp.r.cCQ().c(this.mPageContext, AdvertAppInfo.cNb);
        this.hfV = com.baidu.tieba.recapp.r.cCQ().c(this.mPageContext, AdvertAppInfo.cNc);
        this.hfW = com.baidu.tieba.recapp.r.cCQ().c(this.mPageContext, AdvertAppInfo.cNd);
        this.hfX = com.baidu.tieba.recapp.r.cCQ().c(this.mPageContext, AdvertAppInfo.cNe);
        this.hfY = com.baidu.tieba.recapp.r.cCQ().c(this.mPageContext, AdvertAppInfo.cNf);
        this.hfZ = com.baidu.tieba.recapp.r.cCQ().c(this.mPageContext, AdvertAppInfo.cNh);
        this.hga = com.baidu.tieba.recapp.r.cCQ().c(this.mPageContext, AdvertAppInfo.cNg);
        this.gXE.add(this.hfS);
        this.gXE.add(this.hfT);
        this.gXE.add(this.hfU);
        this.gXE.add(this.hfV);
        this.gXE.add(this.hfW);
        this.gXE.add(this.hfX);
        this.gXE.add(this.hfY);
        this.gXE.add(this.hfZ);
        this.gXE.add(this.hga);
        AdvertAppInfo.cNi.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hft.a(eVar);
        this.hfu.a(eVar);
        this.hfv.a(eVar);
        this.hfx.a(eVar);
        this.hfy.a(eVar);
        this.hfz.a(eVar);
        this.hfA.a(eVar);
        this.hfB.a(eVar);
        this.hfC.a(eVar);
        this.hfD.a(eVar);
        this.hfF.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.hfu.b(rVar);
        this.hfv.b(rVar);
        this.hfw.b(rVar);
        this.hfx.b(rVar);
        this.hfy.b(rVar);
        this.hfz.b(rVar);
        this.hfA.b(rVar);
        this.hfB.b(rVar);
        this.hfD.b(rVar);
        this.hfC.b(rVar);
        this.hfR.b(rVar);
        this.hfI.b(rVar);
        this.hfI.b(rVar);
        this.hfK.b(rVar);
    }

    public void i(List<com.baidu.adp.widget.ListView.m> list, int i) {
        com.baidu.tieba.tbadkCore.t.n(list, 2);
        ViewGroup listView = this.hfo.getListView();
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
        this.hfo.setData(list);
        this.hfp = list;
    }

    public void ac(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.t.n(list, 2);
        this.hfo.setData(list);
        this.hfp = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.hfq.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.hfo != null) {
            this.hfo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.hft != null) {
            this.hft.setFromCDN(z);
            this.hfL.setFromCDN(z);
            this.hfF.setFromCDN(z);
            this.hfM.setFromCDN(z);
            this.hfE.setFromCDN(z);
            this.hfH.setFromCDN(z);
        }
        if (this.hfx != null) {
            this.hfx.setFromCDN(z);
        }
        if (this.hfD != null) {
            this.hfD.setFromCDN(z);
        }
        if (this.hfT != null && (this.hfT instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hfT).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hfs != null) {
            this.hfs.setPageUniqueId(bdUniqueId);
        }
        if (this.hft != null) {
            this.hft.dBK = bdUniqueId;
        }
        if (this.hfu != null) {
            this.hfu.dBK = bdUniqueId;
        }
        if (this.hfv != null) {
            this.hfv.dBK = bdUniqueId;
        }
        if (this.hfw != null) {
            this.hfw.dBK = bdUniqueId;
        }
        if (this.hfx != null) {
            this.hfx.dBK = bdUniqueId;
        }
        if (this.hfy != null) {
            this.hfy.dBK = bdUniqueId;
        }
        if (this.hfz != null) {
            this.hfz.dBK = bdUniqueId;
        }
        if (this.hfA != null) {
            this.hfA.dBK = bdUniqueId;
        }
        if (this.hfB != null) {
            this.hfB.dBK = bdUniqueId;
        }
        if (this.hfE != null) {
            this.hfE.dBK = bdUniqueId;
        }
        if (this.hfF != null) {
            this.hfF.dBK = bdUniqueId;
        }
        if (this.hfC != null) {
            this.hfC.dBK = bdUniqueId;
        }
        if (this.hfq != null) {
            this.hfq.setPageUniqueId(bdUniqueId);
        }
        if (this.hfG != null) {
            this.hfG.dBK = bdUniqueId;
        }
        if (this.hfH != null) {
            this.hfH.dBK = bdUniqueId;
        }
        if (this.hfI != null) {
            this.hfI.dBK = bdUniqueId;
        }
        if (this.hfK != null) {
            this.hfK.dBK = bdUniqueId;
        }
        if (this.hfJ != null) {
            this.hfJ.dBK = bdUniqueId;
        }
        if (this.hfL != null) {
            this.hfL.dBK = bdUniqueId;
        }
        if (this.hfM != null) {
            this.hfM.dBK = bdUniqueId;
        }
        if (this.hfO != null) {
            this.hfO.dBK = bdUniqueId;
        }
        if (this.hfP != null) {
            this.hfP.dBK = bdUniqueId;
        }
        if (this.hfQ != null) {
            this.hfQ.dBK = bdUniqueId;
        }
        if (this.hfR != null) {
            this.hfR.dBK = bdUniqueId;
        }
        if (this.hfD != null) {
            this.hfD.dBK = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gGU)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gGU) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.dat.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dat);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.fKx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fKx);
        if (!this.hgc) {
            this.gGW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gGW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.hfp != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hfp.iterator();
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

    private void bPn() {
        this.hgc = bPo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPo() {
        if (this.gGU == null || this.gGU.size() <= 0) {
            this.gGU = new ArrayList();
            ArrayList<BdUniqueId> cKN = com.baidu.tieba.tbadkCore.t.cKN();
            if (cKN == null || cKN.size() <= 0) {
                return false;
            }
            int size = cKN.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cdE().a(this.mPageContext, cKN.get(i), 2);
                if (this.hgb) {
                    a.setBusinessType(3);
                }
                if (this.hft != null && this.hft.dBK != null) {
                    a.setUniqueId(this.hft.dBK);
                }
                this.gGU.add(a);
            }
            this.hfo.addAdapters(this.gGU);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hft != null) {
            this.hft.setEventCallback(aVar);
        }
        if (this.hfy != null) {
            this.hfy.setEventCallback(aVar);
        }
        if (this.hfw != null) {
            this.hfw.setEventCallback(aVar);
        }
        if (this.hfE != null) {
            this.hfE.setEventCallback(aVar);
        }
        if (this.hfF != null) {
            this.hfF.setEventCallback(aVar);
        }
        if (this.hfG != null) {
            this.hfG.setEventCallback(aVar);
        }
        if (this.hfH != null) {
            this.hfH.setEventCallback(aVar);
        }
        if (this.hfI != null) {
            this.hfI.setEventCallback(aVar);
        }
        if (this.hfK != null) {
            this.hfK.setEventCallback(aVar);
        }
        if (this.hfJ != null) {
            this.hfJ.setEventCallback(aVar);
        }
        if (this.hfL != null) {
            this.hfL.setEventCallback(aVar);
        }
        if (this.hfM != null) {
            this.hfM.setEventCallback(aVar);
        }
        if (this.hfO != null) {
            this.hfO.setEventCallback(aVar);
        }
        if (this.hfP != null) {
            this.hfP.setEventCallback(aVar);
        }
        if (this.hfQ != null) {
            this.hfQ.setEventCallback(aVar);
        }
        if (this.hfR != null) {
            this.hfR.setEventCallback(aVar);
        }
    }

    private void wP(String str) {
        if (this.gXE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gXE) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wP(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).fNt) != null && advertAppInfo.aAs() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b BR(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.hfp == null || this.hfp.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.hfp.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.hfp.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.hfp.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.hfp.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.hfp.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.hfp.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.hfp.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.hfp.get(i4)) != null && lVar.cRt != null && str.equals(lVar.cRt.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.hfp.get(i4)).position;
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
        if (this.hfF != null) {
            this.hfF.onPause();
        }
        if (this.hfM != null) {
            this.hfM.onPause();
        }
        if (this.hfC != null) {
            this.hfC.onPause();
        }
    }

    public void onResume() {
        if (this.hfF != null) {
            this.hfF.onResume();
        }
        if (this.hfM != null) {
            this.hfM.onResume();
        }
        if (this.hfC != null) {
            this.hfC.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hfF != null) {
            this.hfF.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.hfp;
    }
}

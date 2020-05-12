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
    private v hPA;
    private x hPB;
    private u hPC;
    private p hPD;
    private aa hPE;
    private n hPF;
    private q hPG;
    private r hPH;
    private t hPI;
    private e hPJ;
    private com.baidu.adp.widget.ListView.a hPK;
    private com.baidu.adp.widget.ListView.a hPL;
    private com.baidu.adp.widget.ListView.a hPM;
    private com.baidu.adp.widget.ListView.a hPN;
    private com.baidu.adp.widget.ListView.a hPO;
    private com.baidu.adp.widget.ListView.a hPP;
    private com.baidu.adp.widget.ListView.a hPQ;
    private boolean hPR;
    private boolean hPS;
    private com.baidu.adp.widget.ListView.r hPg;
    private List<com.baidu.adp.widget.ListView.m> hPh;
    private b hPi;
    private ab hPj;
    private d hPk;
    private p hPl;
    private y hPm;
    private k hPn;
    private l hPo;
    private m hPp;
    private s hPq;
    private j hPr;
    private i hPs;
    private h hPt;
    private z hPu;
    private g hPv;
    private o hPw;
    private aa hPx;
    private c hPy;
    private w hPz;
    private List<com.baidu.adp.widget.ListView.a> hqt;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener hqv = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ad.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ad.this.bZO();
                if (ad.this.hPh != null) {
                    ad.this.ak(ad.this.hPh);
                }
            }
        }
    };
    private CustomMessageListener dzL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ad.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ad.this.ay(updateAttentionMessage.getData());
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
                bVar.dql = true;
                ad.this.ay(bVar);
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
                bVar.dql = false;
                ad.this.ay(bVar);
            }
        }
    };
    private CustomMessageListener gpj = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ad.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b DD;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (DD = ad.this.DD(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, DD));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> hHB = new ArrayList();

    public ad(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.hPg = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        ev(context);
        a(rVar);
        rVar.addAdapters(this.hHB);
    }

    private void ev(Context context) {
        this.hPi = new b(this.mPageContext);
        this.hPj = new ab(this.mPageContext);
        this.hPk = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.hQs);
        this.hPl = new p(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.hPm = new y(this.mPageContext, com.baidu.tieba.card.data.k.gsG);
        this.hPn = new k(this.mPageContext, com.baidu.tieba.card.data.k.gsM);
        this.hPo = new l(this.mPageContext, com.baidu.tieba.card.data.k.gsN);
        this.hPp = new m(this.mPageContext, com.baidu.tieba.card.data.k.gsO);
        this.hPq = new s(this.mPageContext, com.baidu.tieba.card.data.k.gsP);
        this.hPr = new j(this.mPageContext, com.baidu.tieba.card.data.k.gsH);
        this.hPs = new i(this.mPageContext, com.baidu.tieba.card.data.k.gsJ);
        this.hPt = new h(this.mPageContext, com.baidu.tieba.card.data.k.gsK);
        this.hPu = new z(this.mPageContext, com.baidu.tieba.card.data.l.dqZ);
        this.hPw = new o(this.mPageContext, com.baidu.tieba.card.data.k.dqX);
        this.hPx = new aa(this.mPageContext, com.baidu.tieba.card.data.l.gsW);
        this.hPy = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.hPz = new w(this.mPageContext, com.baidu.tieba.card.data.k.drd);
        this.hPA = new v(this.mPageContext, com.baidu.tieba.card.data.k.dre);
        this.hPB = new x(this.mPageContext, com.baidu.tieba.card.data.k.drg);
        this.hPC = new u(this.mPageContext, com.baidu.tieba.card.data.k.drf);
        this.hPD = new p(this.mPageContext, com.baidu.tieba.card.data.k.gsE);
        this.hPE = new aa(this.mPageContext, com.baidu.tieba.card.data.l.gsX);
        this.hPF = new n(this.mPageContext, com.baidu.tieba.card.data.k.gsF);
        this.hPG = new q(this.mPageContext, com.baidu.tieba.card.data.k.drk);
        this.hPH = new r(this.mPageContext, com.baidu.tieba.card.data.k.drl);
        this.hPI = new t(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.hSZ);
        this.hPJ = new e(this.mPageContext, com.baidu.tieba.card.data.e.gsh);
        this.hPJ.setFrom(0);
        this.hPv = new g(this.mPageContext, com.baidu.tieba.card.data.k.gsL);
        this.hHB.add(this.hPi);
        this.hHB.add(this.hPj);
        this.hHB.add(this.hPk);
        this.hHB.add(this.hPx);
        this.hHB.add(this.hPl);
        this.hHB.add(this.hPm);
        this.hHB.add(this.hPn);
        this.hHB.add(this.hPo);
        this.hHB.add(this.hPp);
        this.hHB.add(this.hPq);
        this.hHB.add(this.hPr);
        this.hHB.add(this.hPs);
        this.hHB.add(this.hPt);
        this.hHB.add(this.hPu);
        this.hHB.add(this.hPw);
        this.hHB.add(this.hPD);
        this.hHB.add(this.hPE);
        this.hHB.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.hHB.add(this.hPy);
        this.hHB.add(this.hPz);
        this.hHB.add(this.hPA);
        this.hHB.add(this.hPC);
        this.hHB.add(this.hPB);
        this.hHB.add(new ac(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.hHB.add(this.hPF);
        this.hHB.add(this.hPG);
        this.hHB.add(this.hPH);
        this.hHB.add(this.hPI);
        this.hHB.add(this.hPJ);
        this.hHB.add(this.hPv);
        bZN();
        bZM();
        yf("page_recommend");
    }

    private void bZM() {
        if (!bj.dro.get()) {
            AdvertAppInfo.dmq.set(false);
            return;
        }
        this.hPK = com.baidu.tieba.recapp.q.cNm().c(this.mPageContext, AdvertAppInfo.dmh);
        this.hPL = com.baidu.tieba.recapp.q.cNm().c(this.mPageContext, AdvertAppInfo.dmk);
        this.hPM = com.baidu.tieba.recapp.q.cNm().c(this.mPageContext, AdvertAppInfo.dml);
        this.hPN = com.baidu.tieba.recapp.q.cNm().c(this.mPageContext, AdvertAppInfo.dmm);
        this.hPO = com.baidu.tieba.recapp.q.cNm().c(this.mPageContext, AdvertAppInfo.dmn);
        this.hPP = com.baidu.tieba.recapp.q.cNm().c(this.mPageContext, AdvertAppInfo.dmp);
        this.hPQ = com.baidu.tieba.recapp.q.cNm().c(this.mPageContext, AdvertAppInfo.dmo);
        this.hHB.add(this.hPK);
        this.hHB.add(this.hPL);
        this.hHB.add(this.hPM);
        this.hHB.add(this.hPN);
        this.hHB.add(this.hPO);
        this.hHB.add(this.hPP);
        this.hHB.add(this.hPQ);
        AdvertAppInfo.dmq.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hPl.a(eVar);
        this.hPm.a(eVar);
        this.hPn.a(eVar);
        this.hPp.a(eVar);
        this.hPq.a(eVar);
        this.hPr.a(eVar);
        this.hPs.a(eVar);
        this.hPt.a(eVar);
        this.hPu.a(eVar);
        this.hPv.a(eVar);
        this.hPx.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.r rVar) {
        this.hPm.a(rVar);
        this.hPn.a(rVar);
        this.hPo.a(rVar);
        this.hPp.a(rVar);
        this.hPq.a(rVar);
        this.hPr.a(rVar);
        this.hPs.a(rVar);
        this.hPt.a(rVar);
        this.hPv.a(rVar);
        this.hPu.a(rVar);
        this.hPJ.a(rVar);
        this.hPA.a(rVar);
        this.hPA.a(rVar);
        this.hPC.a(rVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.m> list, int i) {
        com.baidu.tieba.tbadkCore.t.q(list, 2);
        ViewGroup listView = this.hPg.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top2 = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).oQ();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top2);
                ((BdRecyclerView) listView).oR();
            }
        }
        this.hPg.setData(list);
        this.hPh = list;
    }

    public void ak(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.t.q(list, 2);
        this.hPg.setData(list);
        this.hPh = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.hPi.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.hPg != null) {
            this.hPg.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.hPl != null) {
            this.hPl.setFromCDN(z);
            this.hPD.setFromCDN(z);
            this.hPx.setFromCDN(z);
            this.hPE.setFromCDN(z);
            this.hPw.setFromCDN(z);
            this.hPz.setFromCDN(z);
        }
        if (this.hPp != null) {
            this.hPp.setFromCDN(z);
        }
        if (this.hPv != null) {
            this.hPv.setFromCDN(z);
        }
        if (this.hPL != null && (this.hPL instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.hPL).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hPk != null) {
            this.hPk.setPageUniqueId(bdUniqueId);
        }
        if (this.hPl != null) {
            this.hPl.ebA = bdUniqueId;
        }
        if (this.hPm != null) {
            this.hPm.ebA = bdUniqueId;
        }
        if (this.hPn != null) {
            this.hPn.ebA = bdUniqueId;
        }
        if (this.hPo != null) {
            this.hPo.ebA = bdUniqueId;
        }
        if (this.hPp != null) {
            this.hPp.ebA = bdUniqueId;
        }
        if (this.hPq != null) {
            this.hPq.ebA = bdUniqueId;
        }
        if (this.hPr != null) {
            this.hPr.ebA = bdUniqueId;
        }
        if (this.hPs != null) {
            this.hPs.ebA = bdUniqueId;
        }
        if (this.hPt != null) {
            this.hPt.ebA = bdUniqueId;
        }
        if (this.hPw != null) {
            this.hPw.ebA = bdUniqueId;
        }
        if (this.hPx != null) {
            this.hPx.ebA = bdUniqueId;
        }
        if (this.hPu != null) {
            this.hPu.ebA = bdUniqueId;
        }
        if (this.hPi != null) {
            this.hPi.setPageUniqueId(bdUniqueId);
        }
        if (this.hPy != null) {
            this.hPy.ebA = bdUniqueId;
        }
        if (this.hPz != null) {
            this.hPz.ebA = bdUniqueId;
        }
        if (this.hPA != null) {
            this.hPA.ebA = bdUniqueId;
        }
        if (this.hPC != null) {
            this.hPC.ebA = bdUniqueId;
        }
        if (this.hPB != null) {
            this.hPB.ebA = bdUniqueId;
        }
        if (this.hPD != null) {
            this.hPD.ebA = bdUniqueId;
        }
        if (this.hPE != null) {
            this.hPE.ebA = bdUniqueId;
        }
        if (this.hPG != null) {
            this.hPG.ebA = bdUniqueId;
        }
        if (this.hPH != null) {
            this.hPH.ebA = bdUniqueId;
        }
        if (this.hPI != null) {
            this.hPI.ebA = bdUniqueId;
        }
        if (this.hPJ != null) {
            this.hPJ.ebA = bdUniqueId;
        }
        if (this.hPv != null) {
            this.hPv.ebA = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.hqt)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hqt) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.dzL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dzL);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.gpj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gpj);
        if (!this.hPS) {
            this.hqv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hqv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.hPh != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hPh.iterator();
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

    private void bZN() {
        this.hPS = bZO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZO() {
        if (this.hqt == null || this.hqt.size() <= 0) {
            this.hqt = new ArrayList();
            ArrayList<BdUniqueId> cVH = com.baidu.tieba.tbadkCore.t.cVH();
            if (cVH == null || cVH.size() <= 0) {
                return false;
            }
            int size = cVH.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cod().a(this.mPageContext, cVH.get(i), 2);
                if (this.hPR) {
                    a.setBusinessType(3);
                }
                if (this.hPl != null && this.hPl.ebA != null) {
                    a.setUniqueId(this.hPl.ebA);
                }
                this.hqt.add(a);
            }
            this.hPg.addAdapters(this.hqt);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hPl != null) {
            this.hPl.setEventCallback(aVar);
        }
        if (this.hPq != null) {
            this.hPq.setEventCallback(aVar);
        }
        if (this.hPo != null) {
            this.hPo.setEventCallback(aVar);
        }
        if (this.hPw != null) {
            this.hPw.setEventCallback(aVar);
        }
        if (this.hPx != null) {
            this.hPx.setEventCallback(aVar);
        }
        if (this.hPy != null) {
            this.hPy.setEventCallback(aVar);
        }
        if (this.hPz != null) {
            this.hPz.setEventCallback(aVar);
        }
        if (this.hPA != null) {
            this.hPA.setEventCallback(aVar);
        }
        if (this.hPC != null) {
            this.hPC.setEventCallback(aVar);
        }
        if (this.hPB != null) {
            this.hPB.setEventCallback(aVar);
        }
        if (this.hPD != null) {
            this.hPD.setEventCallback(aVar);
        }
        if (this.hPE != null) {
            this.hPE.setEventCallback(aVar);
        }
        if (this.hPG != null) {
            this.hPG.setEventCallback(aVar);
        }
        if (this.hPH != null) {
            this.hPH.setEventCallback(aVar);
        }
        if (this.hPI != null) {
            this.hPI.setEventCallback(aVar);
        }
        if (this.hPJ != null) {
            this.hPJ.setEventCallback(aVar);
        }
    }

    private void yf(String str) {
        if (this.hHB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hHB) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).yf(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).gsg) != null && advertAppInfo.aID() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b DD(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.hPh == null || this.hPh.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.hPh.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.hPh.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.hPh.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.hPh.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.hPh.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.hPh.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.hPh.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.hPh.get(i4)) != null && lVar.dqE != null && str.equals(lVar.dqE.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.hPh.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.aL(i6 - i >= -1 ? i6 - i : -1);
        bVar.aM(i7);
        bVar.aN(i2);
        return bVar;
    }

    public void onPause() {
        if (this.hPx != null) {
            this.hPx.onPause();
        }
        if (this.hPE != null) {
            this.hPE.onPause();
        }
        if (this.hPu != null) {
            this.hPu.onPause();
        }
    }

    public void onResume() {
        if (this.hPx != null) {
            this.hPx.onResume();
        }
        if (this.hPE != null) {
            this.hPE.onResume();
        }
        if (this.hPu != null) {
            this.hPu.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hPx != null) {
            this.hPx.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.hPh;
    }
}

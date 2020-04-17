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
    private q hPA;
    private r hPB;
    private t hPC;
    private e hPD;
    private com.baidu.adp.widget.ListView.a hPE;
    private com.baidu.adp.widget.ListView.a hPF;
    private com.baidu.adp.widget.ListView.a hPG;
    private com.baidu.adp.widget.ListView.a hPH;
    private com.baidu.adp.widget.ListView.a hPI;
    private com.baidu.adp.widget.ListView.a hPJ;
    private com.baidu.adp.widget.ListView.a hPK;
    private boolean hPL;
    private boolean hPM;
    private com.baidu.adp.widget.ListView.r hPa;
    private List<com.baidu.adp.widget.ListView.m> hPb;
    private b hPc;
    private ab hPd;
    private d hPe;
    private p hPf;
    private y hPg;
    private k hPh;
    private l hPi;
    private m hPj;
    private s hPk;
    private j hPl;
    private i hPm;
    private h hPn;
    private z hPo;
    private g hPp;
    private o hPq;
    private aa hPr;
    private c hPs;
    private w hPt;
    private v hPu;
    private x hPv;
    private u hPw;
    private p hPx;
    private aa hPy;
    private n hPz;
    private List<com.baidu.adp.widget.ListView.a> hqn;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener hqp = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ad.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ad.this.bZP();
                if (ad.this.hPb != null) {
                    ad.this.ak(ad.this.hPb);
                }
            }
        }
    };
    private CustomMessageListener dzH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ad.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ad.this.ax(updateAttentionMessage.getData());
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
                bVar.dqh = true;
                ad.this.ax(bVar);
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
                bVar.dqh = false;
                ad.this.ax(bVar);
            }
        }
    };
    private CustomMessageListener gpd = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ad.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b DA;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (DA = ad.this.DA(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, DA));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> hHv = new ArrayList();

    public ad(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.hPa = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.T(context);
        eH(context);
        a(rVar);
        rVar.addAdapters(this.hHv);
    }

    private void eH(Context context) {
        this.hPc = new b(this.mPageContext);
        this.hPd = new ab(this.mPageContext);
        this.hPe = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.hQm);
        this.hPf = new p(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.hPg = new y(this.mPageContext, com.baidu.tieba.card.data.k.gsA);
        this.hPh = new k(this.mPageContext, com.baidu.tieba.card.data.k.gsG);
        this.hPi = new l(this.mPageContext, com.baidu.tieba.card.data.k.gsH);
        this.hPj = new m(this.mPageContext, com.baidu.tieba.card.data.k.gsI);
        this.hPk = new s(this.mPageContext, com.baidu.tieba.card.data.k.gsJ);
        this.hPl = new j(this.mPageContext, com.baidu.tieba.card.data.k.gsB);
        this.hPm = new i(this.mPageContext, com.baidu.tieba.card.data.k.gsD);
        this.hPn = new h(this.mPageContext, com.baidu.tieba.card.data.k.gsE);
        this.hPo = new z(this.mPageContext, com.baidu.tieba.card.data.l.dqV);
        this.hPq = new o(this.mPageContext, com.baidu.tieba.card.data.k.dqT);
        this.hPr = new aa(this.mPageContext, com.baidu.tieba.card.data.l.gsQ);
        this.hPs = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.hPt = new w(this.mPageContext, com.baidu.tieba.card.data.k.dqZ);
        this.hPu = new v(this.mPageContext, com.baidu.tieba.card.data.k.dra);
        this.hPv = new x(this.mPageContext, com.baidu.tieba.card.data.k.drc);
        this.hPw = new u(this.mPageContext, com.baidu.tieba.card.data.k.drb);
        this.hPx = new p(this.mPageContext, com.baidu.tieba.card.data.k.gsy);
        this.hPy = new aa(this.mPageContext, com.baidu.tieba.card.data.l.gsR);
        this.hPz = new n(this.mPageContext, com.baidu.tieba.card.data.k.gsz);
        this.hPA = new q(this.mPageContext, com.baidu.tieba.card.data.k.drg);
        this.hPB = new r(this.mPageContext, com.baidu.tieba.card.data.k.drh);
        this.hPC = new t(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.hST);
        this.hPD = new e(this.mPageContext, com.baidu.tieba.card.data.e.gsb);
        this.hPD.setFrom(0);
        this.hPp = new g(this.mPageContext, com.baidu.tieba.card.data.k.gsF);
        this.hHv.add(this.hPc);
        this.hHv.add(this.hPd);
        this.hHv.add(this.hPe);
        this.hHv.add(this.hPr);
        this.hHv.add(this.hPf);
        this.hHv.add(this.hPg);
        this.hHv.add(this.hPh);
        this.hHv.add(this.hPi);
        this.hHv.add(this.hPj);
        this.hHv.add(this.hPk);
        this.hHv.add(this.hPl);
        this.hHv.add(this.hPm);
        this.hHv.add(this.hPn);
        this.hHv.add(this.hPo);
        this.hHv.add(this.hPq);
        this.hHv.add(this.hPx);
        this.hHv.add(this.hPy);
        this.hHv.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.hHv.add(this.hPs);
        this.hHv.add(this.hPt);
        this.hHv.add(this.hPu);
        this.hHv.add(this.hPw);
        this.hHv.add(this.hPv);
        this.hHv.add(new ac(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.hHv.add(this.hPz);
        this.hHv.add(this.hPA);
        this.hHv.add(this.hPB);
        this.hHv.add(this.hPC);
        this.hHv.add(this.hPD);
        this.hHv.add(this.hPp);
        bZO();
        bZN();
        yc("page_recommend");
    }

    private void bZN() {
        if (!bj.drk.get()) {
            AdvertAppInfo.dmm.set(false);
            return;
        }
        this.hPE = com.baidu.tieba.recapp.q.cNo().c(this.mPageContext, AdvertAppInfo.dmd);
        this.hPF = com.baidu.tieba.recapp.q.cNo().c(this.mPageContext, AdvertAppInfo.dmg);
        this.hPG = com.baidu.tieba.recapp.q.cNo().c(this.mPageContext, AdvertAppInfo.dmh);
        this.hPH = com.baidu.tieba.recapp.q.cNo().c(this.mPageContext, AdvertAppInfo.dmi);
        this.hPI = com.baidu.tieba.recapp.q.cNo().c(this.mPageContext, AdvertAppInfo.dmj);
        this.hPJ = com.baidu.tieba.recapp.q.cNo().c(this.mPageContext, AdvertAppInfo.dml);
        this.hPK = com.baidu.tieba.recapp.q.cNo().c(this.mPageContext, AdvertAppInfo.dmk);
        this.hHv.add(this.hPE);
        this.hHv.add(this.hPF);
        this.hHv.add(this.hPG);
        this.hHv.add(this.hPH);
        this.hHv.add(this.hPI);
        this.hHv.add(this.hPJ);
        this.hHv.add(this.hPK);
        AdvertAppInfo.dmm.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hPf.a(eVar);
        this.hPg.a(eVar);
        this.hPh.a(eVar);
        this.hPj.a(eVar);
        this.hPk.a(eVar);
        this.hPl.a(eVar);
        this.hPm.a(eVar);
        this.hPn.a(eVar);
        this.hPo.a(eVar);
        this.hPp.a(eVar);
        this.hPr.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.r rVar) {
        this.hPg.a(rVar);
        this.hPh.a(rVar);
        this.hPi.a(rVar);
        this.hPj.a(rVar);
        this.hPk.a(rVar);
        this.hPl.a(rVar);
        this.hPm.a(rVar);
        this.hPn.a(rVar);
        this.hPp.a(rVar);
        this.hPo.a(rVar);
        this.hPD.a(rVar);
        this.hPu.a(rVar);
        this.hPu.a(rVar);
        this.hPw.a(rVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.m> list, int i) {
        com.baidu.tieba.tbadkCore.t.q(list, 2);
        ViewGroup listView = this.hPa.getListView();
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
        this.hPa.setData(list);
        this.hPb = list;
    }

    public void ak(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.t.q(list, 2);
        this.hPa.setData(list);
        this.hPb = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.hPc.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.hPa != null) {
            this.hPa.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.hPf != null) {
            this.hPf.setFromCDN(z);
            this.hPx.setFromCDN(z);
            this.hPr.setFromCDN(z);
            this.hPy.setFromCDN(z);
            this.hPq.setFromCDN(z);
            this.hPt.setFromCDN(z);
        }
        if (this.hPj != null) {
            this.hPj.setFromCDN(z);
        }
        if (this.hPp != null) {
            this.hPp.setFromCDN(z);
        }
        if (this.hPF != null && (this.hPF instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.hPF).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hPe != null) {
            this.hPe.setPageUniqueId(bdUniqueId);
        }
        if (this.hPf != null) {
            this.hPf.ebv = bdUniqueId;
        }
        if (this.hPg != null) {
            this.hPg.ebv = bdUniqueId;
        }
        if (this.hPh != null) {
            this.hPh.ebv = bdUniqueId;
        }
        if (this.hPi != null) {
            this.hPi.ebv = bdUniqueId;
        }
        if (this.hPj != null) {
            this.hPj.ebv = bdUniqueId;
        }
        if (this.hPk != null) {
            this.hPk.ebv = bdUniqueId;
        }
        if (this.hPl != null) {
            this.hPl.ebv = bdUniqueId;
        }
        if (this.hPm != null) {
            this.hPm.ebv = bdUniqueId;
        }
        if (this.hPn != null) {
            this.hPn.ebv = bdUniqueId;
        }
        if (this.hPq != null) {
            this.hPq.ebv = bdUniqueId;
        }
        if (this.hPr != null) {
            this.hPr.ebv = bdUniqueId;
        }
        if (this.hPo != null) {
            this.hPo.ebv = bdUniqueId;
        }
        if (this.hPc != null) {
            this.hPc.setPageUniqueId(bdUniqueId);
        }
        if (this.hPs != null) {
            this.hPs.ebv = bdUniqueId;
        }
        if (this.hPt != null) {
            this.hPt.ebv = bdUniqueId;
        }
        if (this.hPu != null) {
            this.hPu.ebv = bdUniqueId;
        }
        if (this.hPw != null) {
            this.hPw.ebv = bdUniqueId;
        }
        if (this.hPv != null) {
            this.hPv.ebv = bdUniqueId;
        }
        if (this.hPx != null) {
            this.hPx.ebv = bdUniqueId;
        }
        if (this.hPy != null) {
            this.hPy.ebv = bdUniqueId;
        }
        if (this.hPA != null) {
            this.hPA.ebv = bdUniqueId;
        }
        if (this.hPB != null) {
            this.hPB.ebv = bdUniqueId;
        }
        if (this.hPC != null) {
            this.hPC.ebv = bdUniqueId;
        }
        if (this.hPD != null) {
            this.hPD.ebv = bdUniqueId;
        }
        if (this.hPp != null) {
            this.hPp.ebv = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.hqn)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hqn) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.dzH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dzH);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.gpd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gpd);
        if (!this.hPM) {
            this.hqp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hqp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.hPb != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hPb.iterator();
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

    private void bZO() {
        this.hPM = bZP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZP() {
        if (this.hqn == null || this.hqn.size() <= 0) {
            this.hqn = new ArrayList();
            ArrayList<BdUniqueId> cVJ = com.baidu.tieba.tbadkCore.t.cVJ();
            if (cVJ == null || cVJ.size() <= 0) {
                return false;
            }
            int size = cVJ.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cof().a(this.mPageContext, cVJ.get(i), 2);
                if (this.hPL) {
                    a.setBusinessType(3);
                }
                if (this.hPf != null && this.hPf.ebv != null) {
                    a.setUniqueId(this.hPf.ebv);
                }
                this.hqn.add(a);
            }
            this.hPa.addAdapters(this.hqn);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hPf != null) {
            this.hPf.setEventCallback(aVar);
        }
        if (this.hPk != null) {
            this.hPk.setEventCallback(aVar);
        }
        if (this.hPi != null) {
            this.hPi.setEventCallback(aVar);
        }
        if (this.hPq != null) {
            this.hPq.setEventCallback(aVar);
        }
        if (this.hPr != null) {
            this.hPr.setEventCallback(aVar);
        }
        if (this.hPs != null) {
            this.hPs.setEventCallback(aVar);
        }
        if (this.hPt != null) {
            this.hPt.setEventCallback(aVar);
        }
        if (this.hPu != null) {
            this.hPu.setEventCallback(aVar);
        }
        if (this.hPw != null) {
            this.hPw.setEventCallback(aVar);
        }
        if (this.hPv != null) {
            this.hPv.setEventCallback(aVar);
        }
        if (this.hPx != null) {
            this.hPx.setEventCallback(aVar);
        }
        if (this.hPy != null) {
            this.hPy.setEventCallback(aVar);
        }
        if (this.hPA != null) {
            this.hPA.setEventCallback(aVar);
        }
        if (this.hPB != null) {
            this.hPB.setEventCallback(aVar);
        }
        if (this.hPC != null) {
            this.hPC.setEventCallback(aVar);
        }
        if (this.hPD != null) {
            this.hPD.setEventCallback(aVar);
        }
    }

    private void yc(String str) {
        if (this.hHv != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hHv) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).yc(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).gsa) != null && advertAppInfo.aIF() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b DA(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.hPb == null || this.hPb.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.hPb.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.hPb.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.hPb.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.hPb.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.hPb.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.hPb.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.hPb.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.hPb.get(i4)) != null && lVar.dqA != null && str.equals(lVar.dqA.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.hPb.get(i4)).position;
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
        if (this.hPr != null) {
            this.hPr.onPause();
        }
        if (this.hPy != null) {
            this.hPy.onPause();
        }
        if (this.hPo != null) {
            this.hPo.onPause();
        }
    }

    public void onResume() {
        if (this.hPr != null) {
            this.hPr.onResume();
        }
        if (this.hPy != null) {
            this.hPy.onResume();
        }
        if (this.hPo != null) {
            this.hPo.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hPr != null) {
            this.hPr.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.hPb;
    }
}

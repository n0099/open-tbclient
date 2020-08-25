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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class af {
    private com.baidu.adp.widget.ListView.v iOG;
    private List<com.baidu.adp.widget.ListView.q> iOH;
    private b iOI;
    private ad iOJ;
    private d iOK;
    private q iOL;
    private aa iOM;
    private k iON;
    private l iOO;
    private m iOP;
    private u iOQ;
    private n iOR;
    private r iOS;
    private p iOT;
    private j iOU;
    private i iOV;
    private h iOW;
    private ab iOX;
    private g iOY;
    private o iOZ;
    private c iPa;
    private y iPb;
    private x iPc;
    private z iPd;
    private w iPe;
    private q iPf;
    private s iPg;
    private t iPh;
    private v iPi;
    private e iPj;
    private ac iPk;
    private com.baidu.adp.widget.ListView.a iPl;
    private com.baidu.adp.widget.ListView.a iPm;
    private com.baidu.adp.widget.ListView.a iPn;
    private com.baidu.adp.widget.ListView.a iPo;
    private com.baidu.adp.widget.ListView.a iPp;
    private com.baidu.adp.widget.ListView.a iPq;
    private com.baidu.adp.widget.ListView.a iPr;
    private boolean iPs;
    private boolean iPt;
    private List<com.baidu.adp.widget.ListView.a> inq;
    private TbPageContext<?> mPageContext;

    /* renamed from: int  reason: not valid java name */
    private CustomMessageListener f5int = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.af.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                af.this.cyn();
                if (af.this.iOH != null) {
                    af.this.bS(af.this.iOH);
                }
            }
        }
    };
    private CustomMessageListener ekH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.af.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                af.this.aE(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.af.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.eas = true;
                af.this.aE(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.af.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.eas = false;
                af.this.aE(bVar);
            }
        }
    };
    private CustomMessageListener hjy = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.af.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Jb;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Jb = af.this.Jb(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Jb));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> iFQ = new ArrayList();

    public af(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.iOG = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fb(context);
        a(vVar);
        vVar.addAdapters(this.iFQ);
    }

    private void fb(Context context) {
        this.iOI = new b(this.mPageContext);
        this.iOJ = new ad(this.mPageContext);
        this.iOK = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.iPT);
        this.iOL = new q(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.iOM = new aa(this.mPageContext, com.baidu.tieba.card.data.l.hnc);
        this.iON = new k(this.mPageContext, com.baidu.tieba.card.data.l.hni);
        this.iOO = new l(this.mPageContext, com.baidu.tieba.card.data.l.eaW);
        this.iOP = new m(this.mPageContext, com.baidu.tieba.card.data.l.hnj);
        this.iOQ = new u(this.mPageContext, com.baidu.tieba.card.data.l.hnh);
        this.iOR = new n(this.mPageContext, com.baidu.tieba.card.data.l.ebi);
        this.iOS = new r(this.mPageContext, com.baidu.tieba.card.data.l.ebk);
        this.iOT = new p(this.mPageContext, com.baidu.tieba.card.data.l.ebl);
        this.iOU = new j(this.mPageContext, com.baidu.tieba.card.data.l.hnd);
        this.iOV = new i(this.mPageContext, com.baidu.tieba.card.data.l.hne);
        this.iOW = new h(this.mPageContext, com.baidu.tieba.card.data.l.hnf);
        this.iOX = new ab(this.mPageContext, com.baidu.tieba.card.data.m.ebo);
        this.iOZ = new o(this.mPageContext, com.baidu.tieba.card.data.l.ebm);
        this.iPa = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.iPb = new y(this.mPageContext, com.baidu.tieba.card.data.l.ebs);
        this.iPc = new x(this.mPageContext, com.baidu.tieba.card.data.l.ebt);
        this.iPd = new z(this.mPageContext, com.baidu.tieba.card.data.l.ebv);
        this.iPe = new w(this.mPageContext, com.baidu.tieba.card.data.l.ebu);
        this.iPf = new q(this.mPageContext, com.baidu.tieba.card.data.l.hnb);
        this.iPg = new s(this.mPageContext, com.baidu.tieba.card.data.l.ebz);
        this.iPh = new t(this.mPageContext, com.baidu.tieba.card.data.l.ebA);
        this.iPi = new v(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.iUE);
        this.iPj = new e(this.mPageContext, com.baidu.tieba.card.data.f.hmE);
        this.iOY = new g(this.mPageContext, com.baidu.tieba.card.data.l.hng);
        this.iPk = new ac(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE);
        this.iFQ.add(this.iOI);
        this.iFQ.add(this.iOJ);
        this.iFQ.add(this.iOK);
        this.iFQ.add(this.iOL);
        this.iFQ.add(this.iOM);
        this.iFQ.add(this.iON);
        this.iFQ.add(this.iOO);
        this.iFQ.add(this.iOP);
        this.iFQ.add(this.iOQ);
        this.iFQ.add(this.iOR);
        this.iFQ.add(this.iOS);
        this.iFQ.add(this.iOT);
        this.iFQ.add(this.iOU);
        this.iFQ.add(this.iOV);
        this.iFQ.add(this.iOW);
        this.iFQ.add(this.iOX);
        this.iFQ.add(this.iOZ);
        this.iFQ.add(this.iPf);
        this.iFQ.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.iFQ.add(this.iPa);
        this.iFQ.add(this.iPb);
        this.iFQ.add(this.iPc);
        this.iFQ.add(this.iPe);
        this.iFQ.add(this.iPd);
        this.iFQ.add(new ae(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.iFQ.add(this.iPg);
        this.iFQ.add(this.iPh);
        this.iFQ.add(this.iPi);
        this.iFQ.add(this.iPj);
        this.iFQ.add(this.iOY);
        this.iFQ.add(this.iPk);
        cym();
        cyl();
        Dj("page_recommend");
    }

    private void cyl() {
        if (!bw.ebD.get()) {
            AdvertAppInfo.dWd.set(false);
            return;
        }
        this.iPl = com.baidu.tieba.recapp.r.dnh().c(this.mPageContext, AdvertAppInfo.dVU);
        this.iPm = com.baidu.tieba.recapp.r.dnh().c(this.mPageContext, AdvertAppInfo.dVX);
        this.iPn = com.baidu.tieba.recapp.r.dnh().c(this.mPageContext, AdvertAppInfo.dVY);
        this.iPo = com.baidu.tieba.recapp.r.dnh().c(this.mPageContext, AdvertAppInfo.dVZ);
        this.iPp = com.baidu.tieba.recapp.r.dnh().c(this.mPageContext, AdvertAppInfo.dWa);
        this.iPq = com.baidu.tieba.recapp.r.dnh().c(this.mPageContext, AdvertAppInfo.dWc);
        this.iPr = com.baidu.tieba.recapp.r.dnh().c(this.mPageContext, AdvertAppInfo.dWb);
        this.iFQ.add(this.iPl);
        this.iFQ.add(this.iPm);
        this.iFQ.add(this.iPn);
        this.iFQ.add(this.iPo);
        this.iFQ.add(this.iPp);
        this.iFQ.add(this.iPq);
        this.iFQ.add(this.iPr);
        AdvertAppInfo.dWd.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iOL.a(eVar);
        this.iOM.a(eVar);
        this.iON.a(eVar);
        this.iOP.a(eVar);
        this.iOQ.a(eVar);
        this.iOU.a(eVar);
        this.iOV.a(eVar);
        this.iOW.a(eVar);
        this.iOX.a(eVar);
        this.iOY.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.iOM.a(vVar);
        this.iON.a(vVar);
        this.iOO.a(vVar);
        this.iOP.a(vVar);
        this.iOQ.a(vVar);
        this.iOR.a(vVar);
        this.iOS.a(vVar);
        this.iOT.a(vVar);
        this.iOU.a(vVar);
        this.iOV.a(vVar);
        this.iOW.a(vVar);
        this.iOY.a(vVar);
        this.iOX.a(vVar);
        this.iPj.a(vVar);
        this.iPc.a(vVar);
        this.iPc.a(vVar);
        this.iPe.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.u.u(list, 2);
        ViewGroup listView = this.iOG.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).qM();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                ((BdRecyclerView) listView).qN();
            }
        }
        this.iOG.setData(list);
        this.iOH = list;
    }

    public void bS(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.u.u(list, 2);
        this.iOG.setData(list);
        this.iOH = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.iOI.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.iOG != null) {
            this.iOG.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.iOL != null) {
            this.iOL.setFromCDN(z);
            this.iPf.setFromCDN(z);
            this.iOZ.setFromCDN(z);
            this.iPb.setFromCDN(z);
        }
        if (this.iOP != null) {
            this.iOP.setFromCDN(z);
        }
        if (this.iOY != null) {
            this.iOY.setFromCDN(z);
        }
        if (this.iPm != null && (this.iPm instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.iPm).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iOK != null) {
            this.iOK.setPageUniqueId(bdUniqueId);
        }
        if (this.iOL != null) {
            this.iOL.ePv = bdUniqueId;
        }
        if (this.iOM != null) {
            this.iOM.ePv = bdUniqueId;
        }
        if (this.iON != null) {
            this.iON.ePv = bdUniqueId;
        }
        if (this.iOO != null) {
            this.iOO.ePv = bdUniqueId;
        }
        if (this.iOP != null) {
            this.iOP.ePv = bdUniqueId;
        }
        if (this.iOQ != null) {
            this.iOQ.ePv = bdUniqueId;
        }
        if (this.iOR != null) {
            this.iOR.ePv = bdUniqueId;
        }
        if (this.iOS != null) {
            this.iOS.ePv = bdUniqueId;
        }
        if (this.iOT != null) {
            this.iOT.ePv = bdUniqueId;
        }
        if (this.iOU != null) {
            this.iOU.ePv = bdUniqueId;
        }
        if (this.iOV != null) {
            this.iOV.ePv = bdUniqueId;
        }
        if (this.iOW != null) {
            this.iOW.ePv = bdUniqueId;
        }
        if (this.iOZ != null) {
            this.iOZ.ePv = bdUniqueId;
        }
        if (this.iOX != null) {
            this.iOX.ePv = bdUniqueId;
        }
        if (this.iOI != null) {
            this.iOI.setPageUniqueId(bdUniqueId);
        }
        if (this.iPa != null) {
            this.iPa.ePv = bdUniqueId;
        }
        if (this.iPb != null) {
            this.iPb.ePv = bdUniqueId;
        }
        if (this.iPc != null) {
            this.iPc.ePv = bdUniqueId;
        }
        if (this.iPe != null) {
            this.iPe.ePv = bdUniqueId;
        }
        if (this.iPd != null) {
            this.iPd.ePv = bdUniqueId;
        }
        if (this.iPf != null) {
            this.iPf.ePv = bdUniqueId;
        }
        if (this.iPg != null) {
            this.iPg.ePv = bdUniqueId;
        }
        if (this.iPh != null) {
            this.iPh.ePv = bdUniqueId;
        }
        if (this.iPi != null) {
            this.iPi.ePv = bdUniqueId;
        }
        if (this.iPj != null) {
            this.iPj.ePv = bdUniqueId;
        }
        if (this.iOY != null) {
            this.iOY.ePv = bdUniqueId;
        }
        if (this.iPk != null) {
            this.iPk.ePv = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.inq)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.inq) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.ekH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ekH);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.hjy.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hjy);
        if (!this.iPt) {
            this.f5int.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.f5int);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.iOH != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.iOH.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q next = it.next();
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

    private void cym() {
        this.iPt = cyn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyn() {
        if (this.inq == null || this.inq.size() <= 0) {
            this.inq = new ArrayList();
            ArrayList<BdUniqueId> dvW = com.baidu.tieba.tbadkCore.u.dvW();
            if (dvW == null || dvW.size() <= 0) {
                return false;
            }
            int size = dvW.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cNu().a(this.mPageContext, dvW.get(i), 2);
                if (this.iPs) {
                    a.setBusinessType(3);
                }
                if (this.iOL != null && this.iOL.ePv != null) {
                    a.setUniqueId(this.iOL.ePv);
                }
                this.inq.add(a);
            }
            this.iOG.addAdapters(this.inq);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.iFQ) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.iOL != null) {
            this.iOL.setEventCallback(aVar);
        }
        if (this.iOQ != null) {
            this.iOQ.setEventCallback(aVar);
        }
        if (this.iOO != null) {
            this.iOO.setEventCallback(aVar);
        }
        if (this.iOZ != null) {
            this.iOZ.setEventCallback(aVar);
        }
        if (this.iPa != null) {
            this.iPa.setEventCallback(aVar);
        }
        if (this.iPb != null) {
            this.iPb.setEventCallback(aVar);
        }
        if (this.iPc != null) {
            this.iPc.setEventCallback(aVar);
        }
        if (this.iPe != null) {
            this.iPe.setEventCallback(aVar);
        }
        if (this.iPd != null) {
            this.iPd.setEventCallback(aVar);
        }
        if (this.iPf != null) {
            this.iPf.setEventCallback(aVar);
        }
        if (this.iPg != null) {
            this.iPg.setEventCallback(aVar);
        }
        if (this.iPh != null) {
            this.iPh.setEventCallback(aVar);
        }
        if (this.iPi != null) {
            this.iPi.setEventCallback(aVar);
        }
        if (this.iPj != null) {
            this.iPj.setEventCallback(aVar);
        }
        if (this.iPk != null) {
            this.iPk.setEventCallback(aVar);
        }
    }

    private void Dj(String str) {
        if (this.iFQ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.iFQ) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Dj(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).hmD) != null && advertAppInfo.bcv() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Jb(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.m mVar;
        int i3 = 0;
        if (this.iOH == null || this.iOH.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.iOH.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.iOH.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.iOH.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.iOH.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.iOH.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.iOH.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.iOH.get(i4) instanceof com.baidu.tieba.card.data.m) && (mVar = (com.baidu.tieba.card.data.m) this.iOH.get(i4)) != null && mVar.dUS != null && str.equals(mVar.dUS.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.m) this.iOH.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.aX(i6 - i >= -1 ? i6 - i : -1);
        bVar.aY(i7);
        bVar.aZ(i2);
        return bVar;
    }

    public void onPause() {
        if (this.iOX != null) {
            this.iOX.onPause();
        }
    }

    public void onResume() {
        if (this.iOX != null) {
            this.iOX.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.iOH;
    }
}

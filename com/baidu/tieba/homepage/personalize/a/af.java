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
    private com.baidu.adp.widget.ListView.v iOM;
    private List<com.baidu.adp.widget.ListView.q> iON;
    private b iOO;
    private ad iOP;
    private d iOQ;
    private q iOR;
    private aa iOS;
    private k iOT;
    private l iOU;
    private m iOV;
    private u iOW;
    private n iOX;
    private r iOY;
    private p iOZ;
    private j iPa;
    private i iPb;
    private h iPc;
    private ab iPd;
    private g iPe;
    private o iPf;
    private c iPg;
    private y iPh;
    private x iPi;
    private z iPj;
    private w iPk;
    private q iPl;
    private s iPm;
    private t iPn;
    private v iPo;
    private e iPp;
    private ac iPq;
    private com.baidu.adp.widget.ListView.a iPr;
    private com.baidu.adp.widget.ListView.a iPs;
    private com.baidu.adp.widget.ListView.a iPt;
    private com.baidu.adp.widget.ListView.a iPu;
    private com.baidu.adp.widget.ListView.a iPv;
    private com.baidu.adp.widget.ListView.a iPw;
    private com.baidu.adp.widget.ListView.a iPx;
    private boolean iPy;
    private boolean iPz;
    private List<com.baidu.adp.widget.ListView.a> inx;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener inz = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.af.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                af.this.cyo();
                if (af.this.iON != null) {
                    af.this.bS(af.this.iON);
                }
            }
        }
    };
    private CustomMessageListener ekL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.af.2
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
                bVar.eaw = true;
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
                bVar.eaw = false;
                af.this.aE(bVar);
            }
        }
    };
    private CustomMessageListener hjC = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.af.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Jc;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Jc = af.this.Jc(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Jc));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> iFW = new ArrayList();

    public af(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.iOM = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fb(context);
        a(vVar);
        vVar.addAdapters(this.iFW);
    }

    private void fb(Context context) {
        this.iOO = new b(this.mPageContext);
        this.iOP = new ad(this.mPageContext);
        this.iOQ = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.iPZ);
        this.iOR = new q(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.iOS = new aa(this.mPageContext, com.baidu.tieba.card.data.l.hng);
        this.iOT = new k(this.mPageContext, com.baidu.tieba.card.data.l.hnm);
        this.iOU = new l(this.mPageContext, com.baidu.tieba.card.data.l.eba);
        this.iOV = new m(this.mPageContext, com.baidu.tieba.card.data.l.hnn);
        this.iOW = new u(this.mPageContext, com.baidu.tieba.card.data.l.hnl);
        this.iOX = new n(this.mPageContext, com.baidu.tieba.card.data.l.ebm);
        this.iOY = new r(this.mPageContext, com.baidu.tieba.card.data.l.ebo);
        this.iOZ = new p(this.mPageContext, com.baidu.tieba.card.data.l.ebp);
        this.iPa = new j(this.mPageContext, com.baidu.tieba.card.data.l.hnh);
        this.iPb = new i(this.mPageContext, com.baidu.tieba.card.data.l.hni);
        this.iPc = new h(this.mPageContext, com.baidu.tieba.card.data.l.hnj);
        this.iPd = new ab(this.mPageContext, com.baidu.tieba.card.data.m.ebs);
        this.iPf = new o(this.mPageContext, com.baidu.tieba.card.data.l.ebq);
        this.iPg = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.iPh = new y(this.mPageContext, com.baidu.tieba.card.data.l.ebw);
        this.iPi = new x(this.mPageContext, com.baidu.tieba.card.data.l.ebx);
        this.iPj = new z(this.mPageContext, com.baidu.tieba.card.data.l.ebz);
        this.iPk = new w(this.mPageContext, com.baidu.tieba.card.data.l.eby);
        this.iPl = new q(this.mPageContext, com.baidu.tieba.card.data.l.hnf);
        this.iPm = new s(this.mPageContext, com.baidu.tieba.card.data.l.ebD);
        this.iPn = new t(this.mPageContext, com.baidu.tieba.card.data.l.ebE);
        this.iPo = new v(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.iUK);
        this.iPp = new e(this.mPageContext, com.baidu.tieba.card.data.f.hmI);
        this.iPe = new g(this.mPageContext, com.baidu.tieba.card.data.l.hnk);
        this.iPq = new ac(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE);
        this.iFW.add(this.iOO);
        this.iFW.add(this.iOP);
        this.iFW.add(this.iOQ);
        this.iFW.add(this.iOR);
        this.iFW.add(this.iOS);
        this.iFW.add(this.iOT);
        this.iFW.add(this.iOU);
        this.iFW.add(this.iOV);
        this.iFW.add(this.iOW);
        this.iFW.add(this.iOX);
        this.iFW.add(this.iOY);
        this.iFW.add(this.iOZ);
        this.iFW.add(this.iPa);
        this.iFW.add(this.iPb);
        this.iFW.add(this.iPc);
        this.iFW.add(this.iPd);
        this.iFW.add(this.iPf);
        this.iFW.add(this.iPl);
        this.iFW.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.iFW.add(this.iPg);
        this.iFW.add(this.iPh);
        this.iFW.add(this.iPi);
        this.iFW.add(this.iPk);
        this.iFW.add(this.iPj);
        this.iFW.add(new ae(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.iFW.add(this.iPm);
        this.iFW.add(this.iPn);
        this.iFW.add(this.iPo);
        this.iFW.add(this.iPp);
        this.iFW.add(this.iPe);
        this.iFW.add(this.iPq);
        cyn();
        cym();
        Dk("page_recommend");
    }

    private void cym() {
        if (!bw.ebH.get()) {
            AdvertAppInfo.dWh.set(false);
            return;
        }
        this.iPr = com.baidu.tieba.recapp.r.dnk().c(this.mPageContext, AdvertAppInfo.dVY);
        this.iPs = com.baidu.tieba.recapp.r.dnk().c(this.mPageContext, AdvertAppInfo.dWb);
        this.iPt = com.baidu.tieba.recapp.r.dnk().c(this.mPageContext, AdvertAppInfo.dWc);
        this.iPu = com.baidu.tieba.recapp.r.dnk().c(this.mPageContext, AdvertAppInfo.dWd);
        this.iPv = com.baidu.tieba.recapp.r.dnk().c(this.mPageContext, AdvertAppInfo.dWe);
        this.iPw = com.baidu.tieba.recapp.r.dnk().c(this.mPageContext, AdvertAppInfo.dWg);
        this.iPx = com.baidu.tieba.recapp.r.dnk().c(this.mPageContext, AdvertAppInfo.dWf);
        this.iFW.add(this.iPr);
        this.iFW.add(this.iPs);
        this.iFW.add(this.iPt);
        this.iFW.add(this.iPu);
        this.iFW.add(this.iPv);
        this.iFW.add(this.iPw);
        this.iFW.add(this.iPx);
        AdvertAppInfo.dWh.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iOR.a(eVar);
        this.iOS.a(eVar);
        this.iOT.a(eVar);
        this.iOV.a(eVar);
        this.iOW.a(eVar);
        this.iPa.a(eVar);
        this.iPb.a(eVar);
        this.iPc.a(eVar);
        this.iPd.a(eVar);
        this.iPe.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.iOS.a(vVar);
        this.iOT.a(vVar);
        this.iOU.a(vVar);
        this.iOV.a(vVar);
        this.iOW.a(vVar);
        this.iOX.a(vVar);
        this.iOY.a(vVar);
        this.iOZ.a(vVar);
        this.iPa.a(vVar);
        this.iPb.a(vVar);
        this.iPc.a(vVar);
        this.iPe.a(vVar);
        this.iPd.a(vVar);
        this.iPp.a(vVar);
        this.iPi.a(vVar);
        this.iPi.a(vVar);
        this.iPk.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.u.u(list, 2);
        ViewGroup listView = this.iOM.getListView();
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
        this.iOM.setData(list);
        this.iON = list;
    }

    public void bS(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.u.u(list, 2);
        this.iOM.setData(list);
        this.iON = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.iOO.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.iOM != null) {
            this.iOM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.iOR != null) {
            this.iOR.setFromCDN(z);
            this.iPl.setFromCDN(z);
            this.iPf.setFromCDN(z);
            this.iPh.setFromCDN(z);
        }
        if (this.iOV != null) {
            this.iOV.setFromCDN(z);
        }
        if (this.iPe != null) {
            this.iPe.setFromCDN(z);
        }
        if (this.iPs != null && (this.iPs instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.iPs).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iOQ != null) {
            this.iOQ.setPageUniqueId(bdUniqueId);
        }
        if (this.iOR != null) {
            this.iOR.ePz = bdUniqueId;
        }
        if (this.iOS != null) {
            this.iOS.ePz = bdUniqueId;
        }
        if (this.iOT != null) {
            this.iOT.ePz = bdUniqueId;
        }
        if (this.iOU != null) {
            this.iOU.ePz = bdUniqueId;
        }
        if (this.iOV != null) {
            this.iOV.ePz = bdUniqueId;
        }
        if (this.iOW != null) {
            this.iOW.ePz = bdUniqueId;
        }
        if (this.iOX != null) {
            this.iOX.ePz = bdUniqueId;
        }
        if (this.iOY != null) {
            this.iOY.ePz = bdUniqueId;
        }
        if (this.iOZ != null) {
            this.iOZ.ePz = bdUniqueId;
        }
        if (this.iPa != null) {
            this.iPa.ePz = bdUniqueId;
        }
        if (this.iPb != null) {
            this.iPb.ePz = bdUniqueId;
        }
        if (this.iPc != null) {
            this.iPc.ePz = bdUniqueId;
        }
        if (this.iPf != null) {
            this.iPf.ePz = bdUniqueId;
        }
        if (this.iPd != null) {
            this.iPd.ePz = bdUniqueId;
        }
        if (this.iOO != null) {
            this.iOO.setPageUniqueId(bdUniqueId);
        }
        if (this.iPg != null) {
            this.iPg.ePz = bdUniqueId;
        }
        if (this.iPh != null) {
            this.iPh.ePz = bdUniqueId;
        }
        if (this.iPi != null) {
            this.iPi.ePz = bdUniqueId;
        }
        if (this.iPk != null) {
            this.iPk.ePz = bdUniqueId;
        }
        if (this.iPj != null) {
            this.iPj.ePz = bdUniqueId;
        }
        if (this.iPl != null) {
            this.iPl.ePz = bdUniqueId;
        }
        if (this.iPm != null) {
            this.iPm.ePz = bdUniqueId;
        }
        if (this.iPn != null) {
            this.iPn.ePz = bdUniqueId;
        }
        if (this.iPo != null) {
            this.iPo.ePz = bdUniqueId;
        }
        if (this.iPp != null) {
            this.iPp.ePz = bdUniqueId;
        }
        if (this.iPe != null) {
            this.iPe.ePz = bdUniqueId;
        }
        if (this.iPq != null) {
            this.iPq.ePz = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.inx)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.inx) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.ekL.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ekL);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.hjC.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hjC);
        if (!this.iPz) {
            this.inz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.inz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.iON != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.iON.iterator();
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

    private void cyn() {
        this.iPz = cyo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyo() {
        if (this.inx == null || this.inx.size() <= 0) {
            this.inx = new ArrayList();
            ArrayList<BdUniqueId> dwb = com.baidu.tieba.tbadkCore.u.dwb();
            if (dwb == null || dwb.size() <= 0) {
                return false;
            }
            int size = dwb.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cNv().a(this.mPageContext, dwb.get(i), 2);
                if (this.iPy) {
                    a.setBusinessType(3);
                }
                if (this.iOR != null && this.iOR.ePz != null) {
                    a.setUniqueId(this.iOR.ePz);
                }
                this.inx.add(a);
            }
            this.iOM.addAdapters(this.inx);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.iFW) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.iOR != null) {
            this.iOR.setEventCallback(aVar);
        }
        if (this.iOW != null) {
            this.iOW.setEventCallback(aVar);
        }
        if (this.iOU != null) {
            this.iOU.setEventCallback(aVar);
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
        if (this.iPk != null) {
            this.iPk.setEventCallback(aVar);
        }
        if (this.iPj != null) {
            this.iPj.setEventCallback(aVar);
        }
        if (this.iPl != null) {
            this.iPl.setEventCallback(aVar);
        }
        if (this.iPm != null) {
            this.iPm.setEventCallback(aVar);
        }
        if (this.iPn != null) {
            this.iPn.setEventCallback(aVar);
        }
        if (this.iPo != null) {
            this.iPo.setEventCallback(aVar);
        }
        if (this.iPp != null) {
            this.iPp.setEventCallback(aVar);
        }
        if (this.iPq != null) {
            this.iPq.setEventCallback(aVar);
        }
    }

    private void Dk(String str) {
        if (this.iFW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.iFW) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Dk(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).hmH) != null && advertAppInfo.bcv() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Jc(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.m mVar;
        int i3 = 0;
        if (this.iON == null || this.iON.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.iON.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.iON.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.iON.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.iON.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.iON.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.iON.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.iON.get(i4) instanceof com.baidu.tieba.card.data.m) && (mVar = (com.baidu.tieba.card.data.m) this.iON.get(i4)) != null && mVar.dUW != null && str.equals(mVar.dUW.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.m) this.iON.get(i4)).position;
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
        if (this.iPd != null) {
            this.iPd.onPause();
        }
    }

    public void onResume() {
        if (this.iPd != null) {
            this.iPd.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.iON;
    }
}

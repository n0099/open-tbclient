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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class af {
    private List<com.baidu.adp.widget.ListView.a> hTh;
    private com.baidu.adp.widget.ListView.v itI;
    private List<com.baidu.adp.widget.ListView.q> itJ;
    private b itK;
    private ad itL;
    private d itM;
    private q itN;
    private aa itO;
    private k itP;
    private l itQ;
    private m itR;
    private u itS;
    private n itT;
    private r itU;
    private p itV;
    private j itW;
    private i itX;
    private h itY;
    private ab itZ;
    private g iua;
    private o iub;
    private c iuc;
    private y iud;
    private x iue;
    private z iuf;
    private w iug;
    private q iuh;
    private s iui;
    private t iuj;
    private v iuk;
    private e iul;
    private ac ium;
    private com.baidu.adp.widget.ListView.a iun;
    private com.baidu.adp.widget.ListView.a iuo;
    private com.baidu.adp.widget.ListView.a iup;
    private com.baidu.adp.widget.ListView.a iuq;
    private com.baidu.adp.widget.ListView.a iur;
    private com.baidu.adp.widget.ListView.a ius;
    private com.baidu.adp.widget.ListView.a iut;
    private boolean iuu;
    private boolean iuv;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener hTj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.af.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                af.this.cjT();
                if (af.this.itJ != null) {
                    af.this.bN(af.this.itJ);
                }
            }
        }
    };
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.af.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                af.this.aC(updateAttentionMessage.getData());
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
                bVar.dKM = true;
                af.this.aC(bVar);
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
                bVar.dKM = false;
                af.this.aC(bVar);
            }
        }
    };
    private CustomMessageListener gRa = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.af.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b FN;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (FN = af.this.FN(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, FN));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> ilw = new ArrayList();

    public af(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.itI = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        eL(context);
        a(vVar);
        vVar.addAdapters(this.ilw);
    }

    private void eL(Context context) {
        this.itK = new b(this.mPageContext);
        this.itL = new ad(this.mPageContext);
        this.itM = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.iuV);
        this.itN = new q(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.itO = new aa(this.mPageContext, com.baidu.tieba.card.data.k.gUF);
        this.itP = new k(this.mPageContext, com.baidu.tieba.card.data.k.gUM);
        this.itQ = new l(this.mPageContext, com.baidu.tieba.card.data.k.gUG);
        this.itR = new m(this.mPageContext, com.baidu.tieba.card.data.k.gUN);
        this.itS = new u(this.mPageContext, com.baidu.tieba.card.data.k.gUL);
        this.itT = new n(this.mPageContext, com.baidu.tieba.card.data.k.dLB);
        this.itU = new r(this.mPageContext, com.baidu.tieba.card.data.k.dLD);
        this.itV = new p(this.mPageContext, com.baidu.tieba.card.data.k.dLE);
        this.itW = new j(this.mPageContext, com.baidu.tieba.card.data.k.gUH);
        this.itX = new i(this.mPageContext, com.baidu.tieba.card.data.k.gUI);
        this.itY = new h(this.mPageContext, com.baidu.tieba.card.data.k.gUJ);
        this.itZ = new ab(this.mPageContext, com.baidu.tieba.card.data.l.dLH);
        this.iub = new o(this.mPageContext, com.baidu.tieba.card.data.k.dLF);
        this.iuc = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.iud = new y(this.mPageContext, com.baidu.tieba.card.data.k.dLL);
        this.iue = new x(this.mPageContext, com.baidu.tieba.card.data.k.dLM);
        this.iuf = new z(this.mPageContext, com.baidu.tieba.card.data.k.dLO);
        this.iug = new w(this.mPageContext, com.baidu.tieba.card.data.k.dLN);
        this.iuh = new q(this.mPageContext, com.baidu.tieba.card.data.k.gUE);
        this.iui = new s(this.mPageContext, com.baidu.tieba.card.data.k.dLS);
        this.iuj = new t(this.mPageContext, com.baidu.tieba.card.data.k.dLT);
        this.iuk = new v(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.izA);
        this.iul = new e(this.mPageContext, com.baidu.tieba.card.data.e.gUh);
        this.iua = new g(this.mPageContext, com.baidu.tieba.card.data.k.gUK);
        this.ium = new ac(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE);
        this.ilw.add(this.itK);
        this.ilw.add(this.itL);
        this.ilw.add(this.itM);
        this.ilw.add(this.itN);
        this.ilw.add(this.itO);
        this.ilw.add(this.itP);
        this.ilw.add(this.itQ);
        this.ilw.add(this.itR);
        this.ilw.add(this.itS);
        this.ilw.add(this.itT);
        this.ilw.add(this.itU);
        this.ilw.add(this.itV);
        this.ilw.add(this.itW);
        this.ilw.add(this.itX);
        this.ilw.add(this.itY);
        this.ilw.add(this.itZ);
        this.ilw.add(this.iub);
        this.ilw.add(this.iuh);
        this.ilw.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.ilw.add(this.iuc);
        this.ilw.add(this.iud);
        this.ilw.add(this.iue);
        this.ilw.add(this.iug);
        this.ilw.add(this.iuf);
        this.ilw.add(new ae(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.ilw.add(this.iui);
        this.ilw.add(this.iuj);
        this.ilw.add(this.iuk);
        this.ilw.add(this.iul);
        this.ilw.add(this.iua);
        this.ilw.add(this.ium);
        cjS();
        cjR();
        Ae("page_recommend");
    }

    private void cjR() {
        if (!bu.dLW.get()) {
            AdvertAppInfo.dGJ.set(false);
            return;
        }
        this.iun = com.baidu.tieba.recapp.q.cYT().c(this.mPageContext, AdvertAppInfo.dGA);
        this.iuo = com.baidu.tieba.recapp.q.cYT().c(this.mPageContext, AdvertAppInfo.dGD);
        this.iup = com.baidu.tieba.recapp.q.cYT().c(this.mPageContext, AdvertAppInfo.dGE);
        this.iuq = com.baidu.tieba.recapp.q.cYT().c(this.mPageContext, AdvertAppInfo.dGF);
        this.iur = com.baidu.tieba.recapp.q.cYT().c(this.mPageContext, AdvertAppInfo.dGG);
        this.ius = com.baidu.tieba.recapp.q.cYT().c(this.mPageContext, AdvertAppInfo.dGI);
        this.iut = com.baidu.tieba.recapp.q.cYT().c(this.mPageContext, AdvertAppInfo.dGH);
        this.ilw.add(this.iun);
        this.ilw.add(this.iuo);
        this.ilw.add(this.iup);
        this.ilw.add(this.iuq);
        this.ilw.add(this.iur);
        this.ilw.add(this.ius);
        this.ilw.add(this.iut);
        AdvertAppInfo.dGJ.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.itN.a(eVar);
        this.itO.a(eVar);
        this.itP.a(eVar);
        this.itR.a(eVar);
        this.itS.a(eVar);
        this.itW.a(eVar);
        this.itX.a(eVar);
        this.itY.a(eVar);
        this.itZ.a(eVar);
        this.iua.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.itO.a(vVar);
        this.itP.a(vVar);
        this.itQ.a(vVar);
        this.itR.a(vVar);
        this.itS.a(vVar);
        this.itT.a(vVar);
        this.itU.a(vVar);
        this.itV.a(vVar);
        this.itW.a(vVar);
        this.itX.a(vVar);
        this.itY.a(vVar);
        this.iua.a(vVar);
        this.itZ.a(vVar);
        this.iul.a(vVar);
        this.iue.a(vVar);
        this.iue.a(vVar);
        this.iug.a(vVar);
    }

    public void l(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.t.t(list, 2);
        ViewGroup listView = this.itI.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top2 = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).pm();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top2);
                ((BdRecyclerView) listView).pn();
            }
        }
        this.itI.setData(list);
        this.itJ = list;
    }

    public void bN(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.t.t(list, 2);
        this.itI.setData(list);
        this.itJ = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.itK.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.itI != null) {
            this.itI.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.itN != null) {
            this.itN.setFromCDN(z);
            this.iuh.setFromCDN(z);
            this.iub.setFromCDN(z);
            this.iud.setFromCDN(z);
        }
        if (this.itR != null) {
            this.itR.setFromCDN(z);
        }
        if (this.iua != null) {
            this.iua.setFromCDN(z);
        }
        if (this.iuo != null && (this.iuo instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.iuo).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.itM != null) {
            this.itM.setPageUniqueId(bdUniqueId);
        }
        if (this.itN != null) {
            this.itN.eyE = bdUniqueId;
        }
        if (this.itO != null) {
            this.itO.eyE = bdUniqueId;
        }
        if (this.itP != null) {
            this.itP.eyE = bdUniqueId;
        }
        if (this.itQ != null) {
            this.itQ.eyE = bdUniqueId;
        }
        if (this.itR != null) {
            this.itR.eyE = bdUniqueId;
        }
        if (this.itS != null) {
            this.itS.eyE = bdUniqueId;
        }
        if (this.itT != null) {
            this.itT.eyE = bdUniqueId;
        }
        if (this.itU != null) {
            this.itU.eyE = bdUniqueId;
        }
        if (this.itV != null) {
            this.itV.eyE = bdUniqueId;
        }
        if (this.itW != null) {
            this.itW.eyE = bdUniqueId;
        }
        if (this.itX != null) {
            this.itX.eyE = bdUniqueId;
        }
        if (this.itY != null) {
            this.itY.eyE = bdUniqueId;
        }
        if (this.iub != null) {
            this.iub.eyE = bdUniqueId;
        }
        if (this.itZ != null) {
            this.itZ.eyE = bdUniqueId;
        }
        if (this.itK != null) {
            this.itK.setPageUniqueId(bdUniqueId);
        }
        if (this.iuc != null) {
            this.iuc.eyE = bdUniqueId;
        }
        if (this.iud != null) {
            this.iud.eyE = bdUniqueId;
        }
        if (this.iue != null) {
            this.iue.eyE = bdUniqueId;
        }
        if (this.iug != null) {
            this.iug.eyE = bdUniqueId;
        }
        if (this.iuf != null) {
            this.iuf.eyE = bdUniqueId;
        }
        if (this.iuh != null) {
            this.iuh.eyE = bdUniqueId;
        }
        if (this.iui != null) {
            this.iui.eyE = bdUniqueId;
        }
        if (this.iuj != null) {
            this.iuj.eyE = bdUniqueId;
        }
        if (this.iuk != null) {
            this.iuk.eyE = bdUniqueId;
        }
        if (this.iul != null) {
            this.iul.eyE = bdUniqueId;
        }
        if (this.iua != null) {
            this.iua.eyE = bdUniqueId;
        }
        if (this.ium != null) {
            this.ium.eyE = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.w.isEmpty(this.hTh)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hTh) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.dUF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dUF);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.gRa.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gRa);
        if (!this.iuv) {
            this.hTj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hTj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.itJ != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.itJ.iterator();
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

    private void cjS() {
        this.iuv = cjT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cjT() {
        if (this.hTh == null || this.hTh.size() <= 0) {
            this.hTh = new ArrayList();
            ArrayList<BdUniqueId> dhq = com.baidu.tieba.tbadkCore.t.dhq();
            if (dhq == null || dhq.size() <= 0) {
                return false;
            }
            int size = dhq.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cyE().a(this.mPageContext, dhq.get(i), 2);
                if (this.iuu) {
                    a.setBusinessType(3);
                }
                if (this.itN != null && this.itN.eyE != null) {
                    a.setUniqueId(this.itN.eyE);
                }
                this.hTh.add(a);
            }
            this.itI.addAdapters(this.hTh);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.ilw) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.itN != null) {
            this.itN.setEventCallback(aVar);
        }
        if (this.itS != null) {
            this.itS.setEventCallback(aVar);
        }
        if (this.itQ != null) {
            this.itQ.setEventCallback(aVar);
        }
        if (this.iub != null) {
            this.iub.setEventCallback(aVar);
        }
        if (this.iuc != null) {
            this.iuc.setEventCallback(aVar);
        }
        if (this.iud != null) {
            this.iud.setEventCallback(aVar);
        }
        if (this.iue != null) {
            this.iue.setEventCallback(aVar);
        }
        if (this.iug != null) {
            this.iug.setEventCallback(aVar);
        }
        if (this.iuf != null) {
            this.iuf.setEventCallback(aVar);
        }
        if (this.iuh != null) {
            this.iuh.setEventCallback(aVar);
        }
        if (this.iui != null) {
            this.iui.setEventCallback(aVar);
        }
        if (this.iuj != null) {
            this.iuj.setEventCallback(aVar);
        }
        if (this.iuk != null) {
            this.iuk.setEventCallback(aVar);
        }
        if (this.iul != null) {
            this.iul.setEventCallback(aVar);
        }
        if (this.ium != null) {
            this.ium.setEventCallback(aVar);
        }
    }

    private void Ae(String str) {
        if (this.ilw != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.ilw) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ae(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).gUg) != null && advertAppInfo.aQi() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b FN(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.itJ == null || this.itJ.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.itJ.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.itJ.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.itJ.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.itJ.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.itJ.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.itJ.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.itJ.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.itJ.get(i4)) != null && lVar.dLi != null && str.equals(lVar.dLi.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.itJ.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.aS(i6 - i >= -1 ? i6 - i : -1);
        bVar.aT(i7);
        bVar.aU(i2);
        return bVar;
    }

    public void onPause() {
        if (this.itZ != null) {
            this.itZ.onPause();
        }
    }

    public void onResume() {
        if (this.itZ != null) {
            this.itZ.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.itJ;
    }
}

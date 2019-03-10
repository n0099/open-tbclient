package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.y;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Qq;
    private l fdE;
    private FrsCommonTabFragment ffZ;
    private com.baidu.tieba.frs.entelechy.a.d fga;
    private com.baidu.tieba.frs.entelechy.a.d fgb;
    private u fgc;
    private y fgd;
    private y fge;
    private boolean fgf;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fgg = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof com.baidu.tieba.card.y) && "FrsHottopicDelegateAdapter".equals(((com.baidu.tieba.card.y) aVar).aQI()) && a.this.mAdapters != null) {
                        ((com.baidu.tieba.card.y) aVar).a(a.this.ffZ.getPageContext(), a.this.ffZ.getUniqueId());
                        if (a.this.fgf) {
                            ((com.baidu.tieba.card.y) aVar).setFrom("c13010");
                        }
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Qq = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.ffZ = frsCommonTabFragment;
        this.fgg.setPriority(1);
        this.fgg.setSelfListener(true);
        this.ffZ.registerListener(this.fgg);
        this.fga = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bAO, this.ffZ.getUniqueId());
        this.fga.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fgb = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bBa, this.ffZ.getUniqueId());
        this.fgb.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fgc = new u(frsCommonTabFragment.getPageContext(), bg.bBf, this.ffZ.getUniqueId());
        this.fgd = new y(frsCommonTabFragment.getPageContext(), bg.bBb, this.ffZ.getUniqueId());
        this.fgd.fgm = this.ffZ.fgm;
        this.fge = new y(frsCommonTabFragment.getPageContext(), bg.bBg, this.ffZ.getUniqueId());
        this.fge.fgm = this.ffZ.fgm;
        this.fdE = new l(frsCommonTabFragment.getPageContext(), m.fbK);
        this.mAdapters.add(this.fga);
        this.mAdapters.add(this.fgb);
        this.mAdapters.add(this.fgc);
        this.mAdapters.add(this.fgd);
        this.mAdapters.add(this.fge);
        this.mAdapters.add(this.fdE);
        if (frsCommonTabFragment.tabId == 89) {
            this.fgf = true;
            this.fga.setFrom("c13010");
            this.fgb.setFrom("c13010");
            this.fgc.setFrom("c13010");
            this.fgd.setFrom("c13010");
            this.fge.setFrom("c13010");
            qN("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        bfd();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.Qq.setData(arrayList);
    }

    private void bfd() {
        if (this.ffZ != null && !v.T(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bfA() != null) {
                        dVar.bfA().ftb = this.ffZ.fgl;
                        dVar.bfA().ftd = this.ffZ.forumId;
                        dVar.bfA().fte = this.ffZ.tabId;
                        if (this.ffZ.tabId == 502) {
                            dVar.bfA().ftg = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Qq.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void qN(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).qN(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }
}

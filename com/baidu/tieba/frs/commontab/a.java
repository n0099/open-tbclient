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
    private BdTypeRecyclerView Qr;
    private l fdD;
    private FrsCommonTabFragment ffY;
    private com.baidu.tieba.frs.entelechy.a.d ffZ;
    private com.baidu.tieba.frs.entelechy.a.d fga;
    private u fgb;
    private y fgc;
    private y fgd;
    private boolean fge;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fgf = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof com.baidu.tieba.card.y) && "FrsHottopicDelegateAdapter".equals(((com.baidu.tieba.card.y) aVar).aQH()) && a.this.mAdapters != null) {
                        ((com.baidu.tieba.card.y) aVar).a(a.this.ffY.getPageContext(), a.this.ffY.getUniqueId());
                        if (a.this.fge) {
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
        this.Qr = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.ffY = frsCommonTabFragment;
        this.fgf.setPriority(1);
        this.fgf.setSelfListener(true);
        this.ffY.registerListener(this.fgf);
        this.ffZ = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bAQ, this.ffY.getUniqueId());
        this.ffZ.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fga = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bBc, this.ffY.getUniqueId());
        this.fga.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fgb = new u(frsCommonTabFragment.getPageContext(), bg.bBh, this.ffY.getUniqueId());
        this.fgc = new y(frsCommonTabFragment.getPageContext(), bg.bBd, this.ffY.getUniqueId());
        this.fgc.fgl = this.ffY.fgl;
        this.fgd = new y(frsCommonTabFragment.getPageContext(), bg.bBi, this.ffY.getUniqueId());
        this.fgd.fgl = this.ffY.fgl;
        this.fdD = new l(frsCommonTabFragment.getPageContext(), m.fbJ);
        this.mAdapters.add(this.ffZ);
        this.mAdapters.add(this.fga);
        this.mAdapters.add(this.fgb);
        this.mAdapters.add(this.fgc);
        this.mAdapters.add(this.fgd);
        this.mAdapters.add(this.fdD);
        if (frsCommonTabFragment.tabId == 89) {
            this.fge = true;
            this.ffZ.setFrom("c13010");
            this.fga.setFrom("c13010");
            this.fgb.setFrom("c13010");
            this.fgc.setFrom("c13010");
            this.fgd.setFrom("c13010");
            qL("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        bfc();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.Qr.setData(arrayList);
    }

    private void bfc() {
        if (this.ffY != null && !v.T(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bfz() != null) {
                        dVar.bfz().fta = this.ffY.fgk;
                        dVar.bfz().ftc = this.ffY.forumId;
                        dVar.bfz().ftd = this.ffY.tabId;
                        if (this.ffY.tabId == 502) {
                            dVar.bfz().ftf = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Qr.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void qL(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).qL(str);
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

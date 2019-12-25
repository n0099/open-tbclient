package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.w;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ae;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView Bn;
    private m gnG;
    private FrsCommonTabFragment gqi;
    private i gqj;
    private i gqk;
    private aa gql;
    private ae gqm;
    private ae gqn;
    private boolean isDynamic;
    private List<com.baidu.adp.widget.ListView.a> aoz = new LinkedList();
    private CustomMessageListener gqo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof w) && "FrsHottopicDelegateAdapter".equals(((w) aVar).bsA()) && a.this.aoz != null) {
                        ((w) aVar).a(a.this.gqi.getPageContext(), a.this.gqi.getUniqueId());
                        if (a.this.isDynamic) {
                            ((w) aVar).setFrom("c13010");
                        }
                        a.this.aoz.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Bn = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.gqi = frsCommonTabFragment;
        this.gqo.setPriority(1);
        this.gqo.setSelfListener(true);
        this.gqi.registerListener(this.gqo);
        this.gqj = new i(frsCommonTabFragment.getPageContext(), bj.cMV, this.gqi.getUniqueId());
        this.gqk = new i(frsCommonTabFragment.getPageContext(), bj.cNk, this.gqi.getUniqueId());
        this.gql = new aa(frsCommonTabFragment.getPageContext(), bj.cNp, this.gqi.getUniqueId());
        this.gqm = new ae(frsCommonTabFragment.getPageContext(), bj.cNl, this.gqi.getUniqueId());
        this.gqm.gqu = this.gqi.gqu;
        this.gqn = new ae(frsCommonTabFragment.getPageContext(), bj.cNt, this.gqi.getUniqueId());
        this.gqn.gqu = this.gqi.gqu;
        this.gnG = new m(frsCommonTabFragment.getPageContext(), n.glO);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), bj.cNi, frsCommonTabFragment.getUniqueId());
        this.aoz.add(this.gqj);
        this.aoz.add(this.gqk);
        this.aoz.add(this.gql);
        this.aoz.add(this.gqm);
        this.aoz.add(this.gqn);
        this.aoz.add(this.gnG);
        this.aoz.add(aVar);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.gqj.setFrom("c13010");
            this.gqk.setFrom("c13010");
            this.gql.setFrom("c13010");
            this.gqm.setFrom("c13010");
            this.gqn.setFrom("c13010");
            wq("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bDo();
        bdTypeRecyclerView.addAdapters(this.aoz);
        bDS();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.Bn.setData(arrayList);
    }

    private void bDo() {
        if (!v.isEmpty(this.aoz) && this.gqi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gqi.getTbPageTag());
                }
            }
        }
    }

    private void bDS() {
        if (this.gqi != null && !v.isEmpty(this.aoz)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bEr() != null) {
                        dVar.bEr().gDW = this.gqi.gqt;
                        dVar.bEr().gDY = this.gqi.forumId;
                        dVar.bEr().gDZ = this.gqi.tabId;
                        if (this.gqi.tabId == 502) {
                            dVar.bEr().gEb = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Bn.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void wq(String str) {
        if (this.aoz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof f) {
                    ((f) aVar).wq(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void lx(boolean z) {
        if (this.gqj != null) {
            this.gqj.lz(z);
        }
        if (this.gqk != null) {
            this.gqk.lz(z);
        }
        if (this.gqm != null) {
            this.gqm.lz(z);
        }
        if (this.gqn != null) {
            this.gqn.lz(z);
        }
    }
}

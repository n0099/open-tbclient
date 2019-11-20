package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.v;
import com.baidu.tieba.frs.entelechy.a.z;
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
    private FrsCommonTabFragment fBW;
    private com.baidu.tieba.frs.entelechy.a.d fBX;
    private com.baidu.tieba.frs.entelechy.a.d fBY;
    private v fBZ;
    private z fCa;
    private z fCb;
    private boolean fCc;
    private l fzk;
    private BdTypeRecyclerView yJ;
    private List<com.baidu.adp.widget.ListView.a> agy = new LinkedList();
    private CustomMessageListener fCd = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).baw()) && a.this.agy != null) {
                        ((y) aVar).a(a.this.fBW.getPageContext(), a.this.fBW.getUniqueId());
                        if (a.this.fCc) {
                            ((y) aVar).setFrom("c13010");
                        }
                        a.this.agy.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.yJ = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.fBW = frsCommonTabFragment;
        this.fCd.setPriority(1);
        this.fCd.setSelfListener(true);
        this.fBW.registerListener(this.fCd);
        this.fBX = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bh.caD, this.fBW.getUniqueId());
        this.fBX.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fBY = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bh.caQ, this.fBW.getUniqueId());
        this.fBY.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fBZ = new v(frsCommonTabFragment.getPageContext(), bh.caV, this.fBW.getUniqueId());
        this.fCa = new z(frsCommonTabFragment.getPageContext(), bh.caR, this.fBW.getUniqueId());
        this.fCa.fCj = this.fBW.fCj;
        this.fCb = new z(frsCommonTabFragment.getPageContext(), bh.caW, this.fBW.getUniqueId());
        this.fCb.fCj = this.fBW.fCj;
        this.fzk = new l(frsCommonTabFragment.getPageContext(), m.fxr);
        this.agy.add(this.fBX);
        this.agy.add(this.fBY);
        this.agy.add(this.fBZ);
        this.agy.add(this.fCa);
        this.agy.add(this.fCb);
        this.agy.add(this.fzk);
        if (frsCommonTabFragment.tabId == 89) {
            this.fCc = true;
            this.fBX.setFrom("c13010");
            this.fBY.setFrom("c13010");
            this.fBZ.setFrom("c13010");
            this.fCa.setFrom("c13010");
            this.fCb.setFrom("c13010");
            rh("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bdTypeRecyclerView.addAdapters(this.agy);
        bmx();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.yJ.setData(arrayList);
    }

    private void bmx() {
        if (this.fBW != null && !com.baidu.tbadk.core.util.v.isEmpty(this.agy)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bmV() != null) {
                        dVar.bmV().fPK = this.fBW.fCi;
                        dVar.bmV().fPM = this.fBW.forumId;
                        dVar.bmV().fPN = this.fBW.tabId;
                        if (this.fBW.tabId == 502) {
                            dVar.bmV().fPP = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.yJ.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void rh(String str) {
        if (this.agy != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof f) {
                    ((f) aVar).rh(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void kl(boolean z) {
        if (this.fBX != null) {
            this.fBX.kn(z);
        }
        if (this.fBY != null) {
            this.fBY.kn(z);
        }
        if (this.fCa != null) {
            this.fCa.kn(z);
        }
        if (this.fCb != null) {
            this.fCb.kn(z);
        }
    }
}

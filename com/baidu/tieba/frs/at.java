package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class at {
    private FrsActivity aVM;
    private BdTypeListView aVN;
    private cm aVO;
    private br aVP;
    private View.OnClickListener aVQ;
    private View.OnClickListener aVR;
    private bv aVS;
    private db aVT;
    private az aVU;
    private ba aVV;
    private cs aVW;
    private cg aVX;
    private cd aVY;
    private cn aVZ;
    private ce aWa;
    private dd aWb;
    private com.baidu.tieba.frs.a.a aWc;
    private com.baidu.tieba.frs.a.c aWd;
    private com.baidu.tieba.frs.a.e aWe;
    private bs aWf;
    private final HashMap<Integer, com.baidu.tbadk.core.data.x> aWh;
    private List<com.baidu.adp.widget.ListView.a> aWg = new LinkedList();
    private boolean aTI = false;
    private CustomMessageListener aWi = new au(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private boolean aWj = false;
    private boolean alf = false;

    public at(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.aVN = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.aWh = new HashMap<>();
        bY(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aVM = frsActivity;
        this.aVS = new bv(frsActivity, com.baidu.tbadk.core.data.x.VE);
        this.aVT = new db(frsActivity, com.baidu.tbadk.core.data.x.VD);
        this.aWb = new dd(frsActivity, com.baidu.tbadk.core.data.x.VF);
        this.aVU = new az(frsActivity, com.baidu.tbadk.core.data.c.Uc);
        this.aVV = new ba(frsActivity, com.baidu.tbadk.core.data.c.Ud);
        this.aVX = new cg(frsActivity, com.baidu.tbadk.core.data.p.Vj);
        this.aVY = new cd(frsActivity, com.baidu.tieba.tbadkCore.z.cQk);
        this.aVZ = new cn(frsActivity, com.baidu.tbadk.core.data.r.Vn);
        this.aWc = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.c.Ug);
        this.aWe = new com.baidu.tieba.frs.a.e(frsActivity, com.baidu.tbadk.core.data.c.Uf);
        this.aWd = new com.baidu.tieba.frs.a.c(frsActivity, com.baidu.tbadk.core.data.c.Ue);
        this.aVW = new cs(frsActivity, com.baidu.tbadk.core.data.t.Vz);
        this.aWf = new bs(frsActivity, bt.aXC);
        this.aWa = new ce(frsActivity, com.baidu.tbadk.core.data.q.Vl);
        this.aWg.add(this.aVS);
        this.aWg.add(this.aVT);
        this.aWg.add(this.aVU);
        this.aWg.add(this.aVV);
        this.aWg.add(this.aVX);
        this.aWg.add(this.aVY);
        this.aWg.add(this.aVZ);
        this.aWg.add(this.aWc);
        this.aWg.add(this.aWe);
        this.aWg.add(this.aWd);
        this.aWg.add(this.aVW);
        this.aWg.add(this.aWf);
        this.aWg.add(this.aWb);
        this.aWg.add(this.aWa);
        this.aWg.add(new cu(frsActivity, cv.aYI));
        this.aWi.setPriority(1);
        frsActivity.registerListener(this.aWi);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList()));
        bdTypeListView.h(this.aWg);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWg) {
            if (aVar instanceof bd) {
                ((bd) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z, boolean z2) {
        a(oVar);
        C(arrayList);
        D(arrayList);
        this.aVN.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(arrayList, oVar, this.aWj, this.alf);
    }

    private ArrayList<Integer> C(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return arrayList2;
            }
            com.baidu.adp.widget.ListView.u uVar = arrayList.get(i2);
            if (uVar instanceof com.baidu.tbadk.core.data.c) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.aWh != null && !this.aWh.containsValue(uVar)) {
                    this.aWh.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.x) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bY(boolean z) {
        if (this.aTI != z) {
            this.aTI = z;
            if (this.aVS != null) {
                this.aVS.bY(z);
            }
        }
    }

    public void cd(boolean z) {
        if (this.aVP != null) {
            this.aVP.cd(z);
        }
    }

    public void ce(boolean z) {
        if (this.aVO != null) {
            this.aVO.ce(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.x> Lw() {
        return this.aWh;
    }

    public void ar(String str, String str2) {
        if (this.aVZ != null) {
            this.aVZ.ar(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aVU != null) {
            this.aVU.h(onClickListener);
        }
        if (this.aVV != null) {
            this.aVV.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aVU != null) {
            this.aVU.i(onClickListener);
        }
        if (this.aVV != null) {
            this.aVV.i(onClickListener);
        }
    }

    public void Lx() {
        if (this.aVN != null && this.aVN.getData() != null && this.aVN.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aVN.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.x) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVN.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVN.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aVO != null) {
            this.aVO.onChangeSkinType(i);
        }
        if (this.aVP != null) {
            this.aVP.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aVN.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVN.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aWg != null && this.aWg.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWg) {
                if (aVar instanceof bd) {
                    ((bd) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.aWg != null && this.aWg.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWg) {
                if (aVar instanceof bd) {
                    ((bd) aVar).a(oVar);
                }
            }
        }
    }

    public void a(av avVar) {
        if (this.aWg != null && this.aWg.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWg) {
                if (aVar instanceof bd) {
                    ((bd) aVar).a(avVar);
                }
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.aVQ = onClickListener;
        if (this.aVO != null) {
            this.aVO.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aVR = onClickListener;
        if (this.aVP != null) {
            this.aVP.m(onClickListener);
        }
    }

    public int Ly() {
        if (this.aVS != null) {
            return this.aVS.Ly();
        }
        return 0;
    }

    public int KR() {
        if (this.aVS != null) {
            return this.aVS.KR();
        }
        return 0;
    }

    public int Lz() {
        if (this.aVY != null) {
            return this.aVY.Lz();
        }
        return 0;
    }

    public int LA() {
        if (this.aVS != null) {
            return this.aVS.LA();
        }
        return 0;
    }

    public int LB() {
        if (this.aVY != null) {
            return this.aVY.LB();
        }
        return 0;
    }

    public int LC() {
        if (this.aWa != null) {
            return this.aWa.Mm();
        }
        return 0;
    }

    public int LD() {
        if (this.aVX != null) {
            return this.aVX.Mn();
        }
        return 0;
    }

    public int LE() {
        if (this.aWa != null) {
            return this.aWa.LE();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aWg != null && this.aWg.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWg) {
                if (aVar instanceof bd) {
                    ((bd) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aWg != null && this.aWg.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWg) {
                if (aVar instanceof bd) {
                    ((bd) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        if (this.aVN != null) {
            return this.aVN.aA(i);
        }
        return null;
    }

    private void D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aWg != null && this.aWg.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.x.VD.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aWj) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aWg) {
                if (aVar instanceof bd) {
                    ((bd) aVar).fp(i);
                }
            }
        }
    }
}

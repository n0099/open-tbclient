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
public class as {
    private bv aVA;
    private View.OnClickListener aVB;
    private View.OnClickListener aVC;
    private bz aVD;
    private cv aVE;
    private ay aVF;
    private az aVG;
    private bh aVH;
    private ch aVI;
    private cj aVJ;
    private cx aVK;
    private com.baidu.tieba.frs.a.a aVL;
    private com.baidu.tieba.frs.a.c aVM;
    private com.baidu.tieba.frs.a.e aVN;
    private bw aVO;
    private final HashMap<Integer, com.baidu.tbadk.core.data.v> aVQ;
    private FrsActivity aVx;
    private BdTypeListView aVy;
    private ci aVz;
    private List<com.baidu.adp.widget.ListView.a> aVP = new LinkedList();
    private boolean aTu = false;
    private CustomMessageListener aVR = new at(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private boolean aVS = false;
    private boolean akN = false;

    public as(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.aVy = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.aVQ = new HashMap<>();
        bT(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aVx = frsActivity;
        this.aVD = new bz(frsActivity, com.baidu.tbadk.core.data.v.Vz);
        this.aVE = new cv(frsActivity, com.baidu.tbadk.core.data.v.Vy);
        this.aVK = new cx(frsActivity, com.baidu.tbadk.core.data.v.VA);
        this.aVF = new ay(frsActivity, com.baidu.tbadk.core.data.c.Ub);
        this.aVG = new az(frsActivity, com.baidu.tbadk.core.data.c.Uc);
        this.aVH = new bh(frsActivity, com.baidu.tbadk.core.data.l.Va);
        this.aVI = new ch(frsActivity, com.baidu.tieba.tbadkCore.y.cHK);
        this.aVJ = new cj(frsActivity, com.baidu.tbadk.core.data.q.Vk);
        this.aVL = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.c.Uf);
        this.aVN = new com.baidu.tieba.frs.a.e(frsActivity, com.baidu.tbadk.core.data.c.Ue);
        this.aVM = new com.baidu.tieba.frs.a.c(frsActivity, com.baidu.tbadk.core.data.c.Ud);
        this.aVO = new bw(frsActivity, bx.aXH);
        this.aVP.add(this.aVD);
        this.aVP.add(this.aVE);
        this.aVP.add(this.aVF);
        this.aVP.add(this.aVG);
        this.aVP.add(this.aVH);
        this.aVP.add(this.aVI);
        this.aVP.add(this.aVJ);
        this.aVP.add(this.aVL);
        this.aVP.add(this.aVN);
        this.aVP.add(this.aVM);
        this.aVP.add(this.aVO);
        this.aVP.add(this.aVK);
        this.aVP.add(new co(frsActivity, cp.aYr));
        this.aVR.setPriority(1);
        frsActivity.registerListener(this.aVR);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList()));
        bdTypeListView.h(this.aVP);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVP) {
            if (aVar instanceof bc) {
                ((bc) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.n nVar, boolean z, boolean z2) {
        a(nVar);
        D(arrayList);
        E(arrayList);
        this.aVy.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.n nVar) {
        a(arrayList, nVar, this.aVS, this.akN);
    }

    private ArrayList<Integer> D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
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
                if (this.aVQ != null && !this.aVQ.containsValue(uVar)) {
                    this.aVQ.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.v) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bT(boolean z) {
        if (this.aTu != z) {
            this.aTu = z;
            if (this.aVD != null) {
                this.aVD.bT(z);
            }
        }
    }

    public void bY(boolean z) {
        if (this.aVA != null) {
            this.aVA.bY(z);
        }
    }

    public void bZ(boolean z) {
        if (this.aVz != null) {
            this.aVz.bZ(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.v> LF() {
        return this.aVQ;
    }

    public void aq(String str, String str2) {
        if (this.aVJ != null) {
            this.aVJ.aq(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aVF != null) {
            this.aVF.h(onClickListener);
        }
        if (this.aVG != null) {
            this.aVG.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aVF != null) {
            this.aVF.i(onClickListener);
        }
        if (this.aVG != null) {
            this.aVG.i(onClickListener);
        }
    }

    public void LG() {
        if (this.aVy != null && this.aVy.getData() != null && this.aVy.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aVy.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.v) && ((com.baidu.tbadk.core.data.v) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.v) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVy.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVy.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aVz != null) {
            this.aVz.onChangeSkinType(i);
        }
        if (this.aVA != null) {
            this.aVA.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aVy.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVy.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aVP != null && this.aVP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVP) {
                if (aVar instanceof bc) {
                    ((bc) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        if (this.aVP != null && this.aVP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVP) {
                if (aVar instanceof bc) {
                    ((bc) aVar).a(nVar);
                }
            }
        }
    }

    public void a(au auVar) {
        if (this.aVP != null && this.aVP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVP) {
                if (aVar instanceof bc) {
                    ((bc) aVar).a(auVar);
                }
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.aVB = onClickListener;
        if (this.aVz != null) {
            this.aVz.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aVC = onClickListener;
        if (this.aVA != null) {
            this.aVA.m(onClickListener);
        }
    }

    public int LH() {
        if (this.aVD != null) {
            return this.aVD.LH();
        }
        return 0;
    }

    public int Ld() {
        if (this.aVD != null) {
            return this.aVD.Ld();
        }
        return 0;
    }

    public int LI() {
        if (this.aVI != null) {
            return this.aVI.LI();
        }
        return 0;
    }

    public int LJ() {
        if (this.aVD != null) {
            return this.aVD.LJ();
        }
        return 0;
    }

    public int LK() {
        if (this.aVI != null) {
            return this.aVI.LK();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aVP != null && this.aVP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVP) {
                if (aVar instanceof bc) {
                    ((bc) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aVP != null && this.aVP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVP) {
                if (aVar instanceof bc) {
                    ((bc) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        if (this.aVy != null) {
            return this.aVy.aA(i);
        }
        return null;
    }

    private void E(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aVP != null && this.aVP.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.v.Vy.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aVS) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aVP) {
                if (aVar instanceof bc) {
                    ((bc) aVar).fh(i);
                }
            }
        }
    }
}

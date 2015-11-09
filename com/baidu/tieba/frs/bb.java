package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class bb {
    private cn aVA;
    private dc aVB;
    private co aVC;
    private dy aVD;
    private com.baidu.tieba.frs.a.a aVE;
    private com.baidu.tieba.frs.a.c aVF;
    private com.baidu.tieba.frs.a.e aVG;
    private cw aVH;
    private dr aVI;
    private cc aVJ;
    private final HashMap<Integer, com.baidu.tbadk.core.data.w> aVL;
    private FrsActivity aVn;
    private BdTypeListView aVo;
    private db aVp;
    private cb aVq;
    private View.OnClickListener aVr;
    private View.OnClickListener aVs;
    private cf aVt;
    private dw aVu;
    private bh aVv;
    private bk aVw;
    private bi aVx;
    private dh aVy;
    private cq aVz;
    private List<com.baidu.adp.widget.ListView.a> aVK = new LinkedList();
    private boolean aSX = false;
    private CustomMessageListener aVM = new bc(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private boolean aVN = false;
    private boolean akd = false;

    public bb(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.aVo = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.aVL = new HashMap<>();
        bX(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aVn = frsActivity;
        this.aVt = new cf(frsActivity, com.baidu.tbadk.core.data.w.Vx);
        this.aVu = new dw(frsActivity, com.baidu.tbadk.core.data.w.Vw);
        this.aVD = new dy(frsActivity, com.baidu.tbadk.core.data.w.Vy);
        this.aVv = new bh(frsActivity, com.baidu.tbadk.core.data.b.TP);
        this.aVw = new bk(frsActivity, com.baidu.tbadk.core.data.b.TQ);
        this.aVx = new bi(frsActivity, com.baidu.tbadk.core.data.b.TR);
        this.aVz = new cq(frsActivity, com.baidu.tbadk.core.data.p.Vc);
        this.aVA = new cn(frsActivity, com.baidu.tieba.tbadkCore.z.cZA);
        this.aVB = new dc(frsActivity, com.baidu.tbadk.core.data.r.Vg);
        this.aVE = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.b.TU);
        this.aVG = new com.baidu.tieba.frs.a.e(frsActivity, com.baidu.tbadk.core.data.b.TT);
        this.aVF = new com.baidu.tieba.frs.a.c(frsActivity, com.baidu.tbadk.core.data.b.TS);
        this.aVy = new dh(frsActivity, com.baidu.tbadk.core.data.t.Vs);
        this.aVJ = new cc(frsActivity, cd.aXq);
        this.aVC = new co(frsActivity, com.baidu.tbadk.core.data.q.Ve);
        this.aVH = new cw(frsActivity, com.baidu.tbadk.core.data.w.Vz);
        this.aVI = new dr(frsActivity, com.baidu.tbadk.core.data.w.VA);
        this.aVK.add(this.aVt);
        this.aVK.add(this.aVu);
        this.aVK.add(this.aVv);
        this.aVK.add(this.aVw);
        this.aVK.add(this.aVx);
        this.aVK.add(this.aVz);
        this.aVK.add(this.aVA);
        this.aVK.add(this.aVB);
        this.aVK.add(this.aVE);
        this.aVK.add(this.aVG);
        this.aVK.add(this.aVF);
        this.aVK.add(this.aVy);
        this.aVK.add(this.aVJ);
        this.aVK.add(this.aVD);
        this.aVK.add(this.aVC);
        this.aVK.add(this.aVH);
        this.aVK.add(this.aVI);
        this.aVK.add(new dj(frsActivity, dk.aYE));
        this.aVM.setSelfListener(true);
        this.aVM.setPriority(1);
        this.aVM.setSelfListener(true);
        frsActivity.registerListener(this.aVM);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.h(this.aVK);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
            if (aVar instanceof bn) {
                ((bn) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z, boolean z2) {
        a(oVar);
        C(arrayList);
        D(arrayList);
        this.aVo.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(arrayList, oVar, this.aVN, this.akd);
    }

    public int LF() {
        return this.aVo.getHeaderViewsCount();
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
            if (uVar instanceof com.baidu.tbadk.core.data.b) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.aVL != null && !this.aVL.containsValue(uVar)) {
                    this.aVL.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.w) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bX(boolean z) {
        if (this.aSX != z) {
            this.aSX = z;
            if (this.aVt != null) {
                this.aVt.bX(z);
            }
        }
    }

    public void cc(boolean z) {
        if (this.aVq != null) {
            this.aVq.cc(z);
        }
    }

    public void cd(boolean z) {
        if (this.aVp != null) {
            this.aVp.cd(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.w> LG() {
        return this.aVL;
    }

    public void an(String str, String str2) {
        if (this.aVB != null) {
            this.aVB.an(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aVv != null) {
            this.aVv.h(onClickListener);
        }
        if (this.aVw != null) {
            this.aVw.h(onClickListener);
        }
        if (this.aVx != null) {
            this.aVx.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aVv != null) {
            this.aVv.i(onClickListener);
        }
        if (this.aVw != null) {
            this.aVw.i(onClickListener);
        }
        if (this.aVx != null) {
            this.aVx.i(onClickListener);
        }
    }

    public void LH() {
        if (this.aVo != null && this.aVo.getData() != null && this.aVo.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aVo.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.w) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVo.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVo.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aVp != null) {
            this.aVp.onChangeSkinType(i);
        }
        if (this.aVq != null) {
            this.aVq.onChangeSkinType(i);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(oVar);
                }
            }
        }
    }

    public void a(bd bdVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(bdVar);
                }
                if (aVar instanceof cw) {
                    ((bn) aVar).a(bdVar);
                }
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.aVr = onClickListener;
        if (this.aVp != null) {
            this.aVp.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aVs = onClickListener;
        if (this.aVq != null) {
            this.aVq.m(onClickListener);
        }
    }

    public int LI() {
        if (this.aVt != null) {
            return this.aVt.LI();
        }
        return 0;
    }

    public int KY() {
        if (this.aVt != null) {
            return this.aVt.KY();
        }
        return 0;
    }

    public int LJ() {
        if (this.aVA != null) {
            return this.aVA.LJ();
        }
        return 0;
    }

    public int LK() {
        if (this.aVt != null) {
            return this.aVt.LK();
        }
        return 0;
    }

    public int LL() {
        if (this.aVA != null) {
            return this.aVA.LL();
        }
        return 0;
    }

    public int LM() {
        if (this.aVC != null) {
            return this.aVC.Mx();
        }
        return 0;
    }

    public int LN() {
        if (this.aVz != null) {
            return this.aVz.My();
        }
        return 0;
    }

    public int LO() {
        if (this.aVC != null) {
            return this.aVC.LO();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        if (this.aVo != null) {
            return this.aVo.aA(i);
        }
        return null;
    }

    private void D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aVK != null && this.aVK.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.w.Vw.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aVN) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).fC(i);
                }
            }
        }
    }
}

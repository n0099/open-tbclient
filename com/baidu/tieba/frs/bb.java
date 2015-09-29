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
    private FrsActivity aUU;
    private BdTypeListView aUV;
    private db aUW;
    private cb aUX;
    private View.OnClickListener aUY;
    private View.OnClickListener aUZ;
    private cf aVa;
    private du aVb;
    private bh aVc;
    private bk aVd;
    private bi aVe;
    private dh aVf;
    private cq aVg;
    private cn aVh;
    private dc aVi;
    private co aVj;
    private dw aVk;
    private com.baidu.tieba.frs.a.a aVl;
    private com.baidu.tieba.frs.a.c aVm;
    private com.baidu.tieba.frs.a.e aVn;
    private cw aVo;
    private dp aVp;
    private cc aVq;
    private final HashMap<Integer, com.baidu.tbadk.core.data.v> aVs;
    private List<com.baidu.adp.widget.ListView.a> aVr = new LinkedList();
    private boolean aSE = false;
    private CustomMessageListener aVt = new bc(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private boolean aVu = false;
    private boolean ajX = false;

    public bb(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.aUV = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.aVs = new HashMap<>();
        bV(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aUU = frsActivity;
        this.aVa = new cf(frsActivity, com.baidu.tbadk.core.data.v.Vs);
        this.aVb = new du(frsActivity, com.baidu.tbadk.core.data.v.Vr);
        this.aVk = new dw(frsActivity, com.baidu.tbadk.core.data.v.Vt);
        this.aVc = new bh(frsActivity, com.baidu.tbadk.core.data.b.TM);
        this.aVd = new bk(frsActivity, com.baidu.tbadk.core.data.b.TO);
        this.aVe = new bi(frsActivity, com.baidu.tbadk.core.data.b.TP);
        this.aVg = new cq(frsActivity, com.baidu.tbadk.core.data.o.UY);
        this.aVh = new cn(frsActivity, com.baidu.tieba.tbadkCore.z.cXD);
        this.aVi = new dc(frsActivity, com.baidu.tbadk.core.data.q.Vc);
        this.aVl = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.b.TS);
        this.aVn = new com.baidu.tieba.frs.a.e(frsActivity, com.baidu.tbadk.core.data.b.TR);
        this.aVm = new com.baidu.tieba.frs.a.c(frsActivity, com.baidu.tbadk.core.data.b.TQ);
        this.aVf = new dh(frsActivity, com.baidu.tbadk.core.data.s.Vo);
        this.aVq = new cc(frsActivity, cd.aWW);
        this.aVj = new co(frsActivity, com.baidu.tbadk.core.data.p.Va);
        this.aVo = new cw(frsActivity, com.baidu.tbadk.core.data.v.Vu);
        this.aVp = new dp(frsActivity, com.baidu.tbadk.core.data.v.Vv);
        this.aVr.add(this.aVa);
        this.aVr.add(this.aVb);
        this.aVr.add(this.aVc);
        this.aVr.add(this.aVd);
        this.aVr.add(this.aVe);
        this.aVr.add(this.aVg);
        this.aVr.add(this.aVh);
        this.aVr.add(this.aVi);
        this.aVr.add(this.aVl);
        this.aVr.add(this.aVn);
        this.aVr.add(this.aVm);
        this.aVr.add(this.aVf);
        this.aVr.add(this.aVq);
        this.aVr.add(this.aVk);
        this.aVr.add(this.aVj);
        this.aVr.add(this.aVo);
        this.aVr.add(this.aVp);
        this.aVr.add(new dj(frsActivity, dk.aYk));
        this.aVt.setPriority(1);
        this.aVt.setSelfListener(true);
        frsActivity.registerListener(this.aVt);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.h(this.aVr);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
            if (aVar instanceof bn) {
                ((bn) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z, boolean z2) {
        a(oVar);
        C(arrayList);
        D(arrayList);
        this.aUV.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(arrayList, oVar, this.aVu, this.ajX);
    }

    public int Lt() {
        return this.aUV.getHeaderViewsCount();
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
                if (this.aVs != null && !this.aVs.containsValue(uVar)) {
                    this.aVs.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.v) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bV(boolean z) {
        if (this.aSE != z) {
            this.aSE = z;
            if (this.aVa != null) {
                this.aVa.bV(z);
            }
        }
    }

    public void ca(boolean z) {
        if (this.aUX != null) {
            this.aUX.ca(z);
        }
    }

    public void cb(boolean z) {
        if (this.aUW != null) {
            this.aUW.cb(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.v> Lu() {
        return this.aVs;
    }

    public void aq(String str, String str2) {
        if (this.aVi != null) {
            this.aVi.aq(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aVc != null) {
            this.aVc.h(onClickListener);
        }
        if (this.aVd != null) {
            this.aVd.h(onClickListener);
        }
        if (this.aVe != null) {
            this.aVe.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aVc != null) {
            this.aVc.i(onClickListener);
        }
        if (this.aVd != null) {
            this.aVd.i(onClickListener);
        }
        if (this.aVe != null) {
            this.aVe.i(onClickListener);
        }
    }

    public void Lv() {
        if (this.aUV != null && this.aUV.getData() != null && this.aUV.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aUV.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.v) && ((com.baidu.tbadk.core.data.v) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.v) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aUV.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aUW != null) {
            this.aUW.onChangeSkinType(i);
        }
        if (this.aUX != null) {
            this.aUX.onChangeSkinType(i);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aVr != null && this.aVr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.aVr != null && this.aVr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(oVar);
                }
            }
        }
    }

    public void a(bd bdVar) {
        if (this.aVr != null && this.aVr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
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
        this.aUY = onClickListener;
        if (this.aUW != null) {
            this.aUW.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aUZ = onClickListener;
        if (this.aUX != null) {
            this.aUX.m(onClickListener);
        }
    }

    public int Lw() {
        if (this.aVa != null) {
            return this.aVa.Lw();
        }
        return 0;
    }

    public int KM() {
        if (this.aVa != null) {
            return this.aVa.KM();
        }
        return 0;
    }

    public int Lx() {
        if (this.aVh != null) {
            return this.aVh.Lx();
        }
        return 0;
    }

    public int Ly() {
        if (this.aVa != null) {
            return this.aVa.Ly();
        }
        return 0;
    }

    public int Lz() {
        if (this.aVh != null) {
            return this.aVh.Lz();
        }
        return 0;
    }

    public int LA() {
        if (this.aVj != null) {
            return this.aVj.Ml();
        }
        return 0;
    }

    public int LB() {
        if (this.aVg != null) {
            return this.aVg.Mm();
        }
        return 0;
    }

    public int LC() {
        if (this.aVj != null) {
            return this.aVj.LC();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aVr != null && this.aVr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aVr != null && this.aVr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        if (this.aUV != null) {
            return this.aUV.aA(i);
        }
        return null;
    }

    private void D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aVr != null && this.aVr.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.v.Vr.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aVu) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).fu(i);
                }
            }
        }
    }
}

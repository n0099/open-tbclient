package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.frsgood.FrsGoodActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class cl {
    private BdTypeListView aXu;
    private dw bgX;
    private db bgY;
    private df bhb;
    private ey bhe;
    private bl bhf;
    private bq bhg;
    private bn bhh;
    private dl bhk;
    private dx bhl;
    private fa bhn;
    private ee bhs;
    private dr bht;
    private es bhu;
    private dc bhv;
    private final HashMap<Integer, com.baidu.tbadk.core.data.ah> bhw;
    private FrsGoodActivity bjc;
    private ec bjd;
    private List<com.baidu.adp.widget.ListView.a> aXX = new LinkedList();
    private boolean bez = false;
    private boolean bhz = false;
    private boolean anN = false;

    public cl(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsGoodActivity, bdTypeListView);
        this.aXu = bdTypeListView;
        this.bhw = new HashMap<>();
        ck(z);
    }

    public void a(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView) {
        this.bjc = frsGoodActivity;
        this.bhb = new df(frsGoodActivity, com.baidu.tbadk.core.data.ah.WG);
        this.bhe = new ey(frsGoodActivity, com.baidu.tbadk.core.data.ah.WF);
        this.bhf = new bl(frsGoodActivity, com.baidu.tbadk.core.data.c.Um);
        this.bhg = new bq(frsGoodActivity, com.baidu.tbadk.core.data.c.Un);
        this.bhh = new bn(frsGoodActivity, com.baidu.tbadk.core.data.c.Uo);
        this.bhk = new dl(frsGoodActivity, com.baidu.tieba.tbadkCore.z.dVD);
        this.bhl = new dx(frsGoodActivity, com.baidu.tbadk.core.data.y.Wa);
        this.bhn = new fa(frsGoodActivity, com.baidu.tbadk.core.data.ah.WH);
        this.bhv = new dc(frsGoodActivity, dd.bkd);
        this.bhu = new es(frsGoodActivity, com.baidu.tbadk.core.data.ah.WJ);
        this.bht = new dr(frsGoodActivity, com.baidu.tbadk.core.data.ah.WI);
        this.bjd = new ec(frsGoodActivity, com.baidu.tbadk.core.data.ab.Wt);
        this.bhs = new ee(frsGoodActivity, com.baidu.tbadk.core.data.ah.Xw);
        this.aXX.add(this.bhb);
        this.aXX.add(this.bhe);
        this.aXX.add(this.bhf);
        this.aXX.add(this.bhg);
        this.aXX.add(this.bhh);
        this.aXX.add(this.bhk);
        this.aXX.add(this.bhl);
        this.aXX.add(this.bhn);
        this.aXX.add(this.bhv);
        this.aXX.add(this.bhu);
        this.aXX.add(this.bht);
        this.aXX.add(this.bjd);
        this.aXX.add(this.bhs);
        for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
            if (aVar instanceof bv) {
                ((bv) aVar).e(this.bjc);
            }
        }
        bdTypeListView.g(this.aXX);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
            if (aVar instanceof bv) {
                ((bv) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z, boolean z2) {
        a(oVar);
        F(arrayList);
        G(arrayList);
        this.aXu.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(arrayList, oVar, this.bhz, this.anN);
    }

    private ArrayList<Integer> F(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
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
                if (this.bhw != null && !this.bhw.containsValue(uVar)) {
                    this.bhw.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.ah) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void ck(boolean z) {
        if (this.bez != z) {
            this.bez = z;
            if (this.bhb != null) {
                this.bhb.ck(z);
            }
        }
    }

    public void cq(boolean z) {
        if (this.bgY != null) {
            this.bgY.cq(z);
        }
    }

    public void cr(boolean z) {
        if (this.bgX != null) {
            this.bgX.cr(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.ah> Px() {
        return this.bhw;
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.bhf != null) {
            this.bhf.l(onClickListener);
        }
        if (this.bhg != null) {
            this.bhg.l(onClickListener);
        }
        if (this.bhh != null) {
            this.bhh.l(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.bhf != null) {
            this.bhf.m(onClickListener);
        }
        if (this.bhg != null) {
            this.bhg.m(onClickListener);
        }
        if (this.bhh != null) {
            this.bhh.m(onClickListener);
        }
    }

    public void Py() {
        if (this.aXu != null && this.aXu.getData() != null && this.aXu.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aXu.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.ah) && ((com.baidu.tbadk.core.data.ah) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.ah) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bgX != null) {
            this.bgX.onChangeSkinType(i);
        }
        if (this.bgY != null) {
            this.bgY.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(oVar);
                }
            }
        }
    }

    public void a(bh bhVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(bhVar);
                }
            }
        }
    }

    public int Pz() {
        if (this.bhb != null) {
            return this.bhb.Pz();
        }
        return 0;
    }

    public int OL() {
        if (this.bhb != null) {
            return this.bhb.OL();
        }
        return 0;
    }

    public int PA() {
        if (this.bhk != null) {
            return this.bhk.PA();
        }
        return 0;
    }

    public int PB() {
        if (this.bhb != null) {
            return this.bhb.PB();
        }
        return 0;
    }

    public int PC() {
        if (this.bhk != null) {
            return this.bhk.PC();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aG(int i) {
        if (this.aXu != null) {
            return this.aXu.aG(i);
        }
        return null;
    }

    private void G(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aXX != null && this.aXX.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.ah.WF.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.bhz) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).gq(i);
                }
            }
        }
    }
}

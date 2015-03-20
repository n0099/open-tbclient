package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class am {
    private FrsActivity aJT;
    private BdTypeListView aJU;
    private bz aJV;
    private br aJW;
    private View.OnClickListener aJX;
    private View.OnClickListener aJY;
    private bs aJZ;
    private cg aKa;
    private ar aKb;
    private as aKc;
    private ba aKd;
    private by aKe;
    private cb aKf;
    private com.baidu.tieba.frs.a.a aKg;
    private com.baidu.tieba.frs.a.c aKh;
    private com.baidu.tieba.frs.a.e aKi;
    private final HashMap<Integer, com.baidu.tbadk.core.data.w> aKk;
    private List<com.baidu.adp.widget.ListView.a> aKj = new ArrayList();
    private boolean aHR = false;
    private boolean aKl = false;
    private boolean aeu = false;

    public am(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsActivity, bdTypeListView);
        this.aJU = bdTypeListView;
        this.aKk = new HashMap<>();
        bG(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aJT = frsActivity;
        this.aJZ = new bs(frsActivity, com.baidu.tbadk.core.data.w.Qn);
        this.aKa = new cg(frsActivity, com.baidu.tbadk.core.data.w.Qm);
        this.aKb = new ar(frsActivity, com.baidu.tbadk.core.data.c.OP);
        this.aKc = new as(frsActivity, com.baidu.tbadk.core.data.c.OQ);
        this.aKd = new ba(frsActivity, com.baidu.tbadk.core.data.m.PK);
        this.aKe = new by(frsActivity, com.baidu.tieba.tbadkCore.aj.clA);
        this.aKf = new cb(frsActivity, com.baidu.tbadk.core.data.s.PZ);
        this.aKg = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.c.OT);
        this.aKi = new com.baidu.tieba.frs.a.e(frsActivity, com.baidu.tbadk.core.data.c.OS);
        this.aKh = new com.baidu.tieba.frs.a.c(frsActivity, com.baidu.tbadk.core.data.c.OR);
        this.aKj.add(this.aJZ);
        this.aKj.add(this.aKa);
        this.aKj.add(this.aKb);
        this.aKj.add(this.aKc);
        this.aKj.add(this.aKd);
        this.aKj.add(this.aKe);
        this.aKj.add(this.aKf);
        this.aKj.add(this.aKg);
        this.aKj.add(this.aKi);
        this.aKj.add(this.aKh);
        bdTypeListView.g(this.aKj);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, com.baidu.tieba.tbadkCore.w wVar, boolean z, boolean z2) {
        a(wVar);
        this.aeu = z2;
        bP(this.aeu);
        this.aKl = z;
        bO(this.aKl);
        w(arrayList);
        x(arrayList);
        this.aJU.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, com.baidu.tieba.tbadkCore.w wVar) {
        a(arrayList, wVar, this.aKl, this.aeu);
    }

    private ArrayList<Integer> w(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
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
            com.baidu.adp.widget.ListView.ai aiVar = arrayList.get(i2);
            if (aiVar instanceof com.baidu.tbadk.core.data.c) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.aKk != null && !this.aKk.containsValue(aiVar)) {
                    this.aKk.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.w) aiVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bG(boolean z) {
        if (this.aHR != z) {
            this.aHR = z;
            if (this.aJZ != null) {
                this.aJZ.bG(z);
            }
        }
    }

    public void bM(boolean z) {
        if (this.aJW != null) {
            this.aJW.bM(z);
        }
    }

    public void bN(boolean z) {
        if (this.aJV != null) {
            this.aJV.bN(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.w> JG() {
        return this.aKk;
    }

    public void al(String str, String str2) {
        if (this.aKf != null) {
            this.aKf.al(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aKb != null) {
            this.aKb.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aKb != null) {
            this.aKb.i(onClickListener);
        }
        if (this.aKc != null) {
            this.aKc.i(onClickListener);
        }
    }

    public void JH() {
        if (this.aJU != null && this.aJU.getData() != null && this.aJU.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.ai aiVar : this.aJU.getData()) {
                if ((aiVar instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) aiVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.w) aiVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aJU.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aJU.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aJV != null) {
            this.aJV.onChangeSkinType(i);
        }
        if (this.aJW != null) {
            this.aJW.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aJU.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aJU.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aKj != null && this.aKj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aKj) {
                if (aVar instanceof av) {
                    ((av) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        if (this.aKj != null && this.aKj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aKj) {
                if (aVar instanceof av) {
                    ((av) aVar).a(wVar);
                }
            }
        }
    }

    public void a(an anVar) {
        if (this.aKj != null && this.aKj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aKj) {
                if (aVar instanceof av) {
                    ((av) aVar).a(anVar);
                }
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.aJX = onClickListener;
        if (this.aJV != null) {
            this.aJV.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aJY = onClickListener;
        if (this.aJW != null) {
            this.aJW.m(onClickListener);
        }
    }

    public int JI() {
        if (this.aJZ != null) {
            return this.aJZ.JI();
        }
        return 0;
    }

    public int IX() {
        if (this.aJZ != null) {
            return this.aJZ.IX();
        }
        return 0;
    }

    public int JJ() {
        if (this.aKe != null) {
            return this.aKe.JJ();
        }
        return 0;
    }

    public int JK() {
        if (this.aKe != null) {
            return this.aKe.JK();
        }
        return 0;
    }

    private void bO(boolean z) {
        if (z) {
            if (this.aJV == null) {
                this.aJV = new bz(this.aJT);
                this.aJV.j(this.aJX);
            }
            if (this.aJU != null) {
                this.aJU.setPrePage(this.aJV);
            }
        } else if (this.aJV != null && this.aJU != null) {
            this.aJU.setPrePage(null);
        }
    }

    private void bP(boolean z) {
        if (z) {
            if (this.aJW == null) {
                this.aJW = new br(this.aJT);
                this.aJW.m(this.aJY);
            }
            if (this.aJU != null) {
                this.aJU.setNextPage(this.aJW);
            }
        } else if (this.aJW != null && this.aJU != null) {
            this.aJU.setNextPage(null);
        }
    }

    public void a(com.baidu.adp.widget.ListView.aj ajVar) {
        if (this.aKj != null && this.aKj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aKj) {
                if (aVar instanceof av) {
                    ((av) aVar).a(ajVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ak akVar) {
        if (this.aKj != null && this.aKj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aKj) {
                if (aVar instanceof av) {
                    ((av) aVar).a(akVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.ai aA(int i) {
        if (this.aJU != null) {
            return this.aJU.aA(i);
        }
        return null;
    }

    private void x(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
        int i;
        if (this.aKj != null && this.aKj.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.ai> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.w.Qm.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aKl) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aKj) {
                if (aVar instanceof av) {
                    ((av) aVar).eH(i);
                }
            }
        }
    }
}

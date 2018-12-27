package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class a {
    private View byS;
    private FrsFragment dMs;
    private View dTN;
    private TextView dTO;
    private TextView dTP;
    private List<x> dTQ;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dTR;
    private int dTS = -1;
    private boolean dTT = false;
    private View.OnClickListener dTU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.aAJ().aAK()) {
                if (!j.kK()) {
                    a.this.dMs.showToast(e.j.neterror);
                } else if (!v.I(a.this.dTQ)) {
                    if (a.this.dTR == null) {
                        a.this.dTR = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dMs, a.this.dTV);
                    }
                    a.this.dTR.setData(a.this.dTQ);
                    a.this.dTR.d(a.this.dMs.getPageContext()).BI();
                }
            }
        }
    };
    private b.InterfaceC0158b dTV = new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(b bVar, int i, View view) {
            if (!j.kK()) {
                a.this.dMs.showToast(e.j.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) v.d(a.this.dTR.aEX(), i);
            if (xVar != null) {
                if (a.this.dTS != xVar.dOd) {
                    a.this.dTT = true;
                    a.this.op(xVar.name);
                    if (a.this.dMs.aBs() != null) {
                        a.this.dMs.aBs().np(a.this.dTS);
                        a.this.dTS = xVar.dOd;
                        bVar.dismiss();
                        if (a.this.dTS != 7) {
                            com.baidu.tbadk.util.v.Qi();
                            com.baidu.tieba.tbadkCore.util.e.bFh();
                        } else {
                            com.baidu.tieba.tbadkCore.util.e.bFg();
                        }
                        if (a.this.dMs.aBs() != null && a.this.dMs.aBx() != null) {
                            a.this.dMs.aBs().no(xVar.dOd);
                            a.this.dMs.aBx().startPullRefresh();
                            a.this.dMs.aBs().ho(true);
                            a.this.aEU();
                            return;
                        }
                        return;
                    }
                    return;
                }
                bVar.dismiss();
                return;
            }
            bVar.dismiss();
        }
    };
    private String daG;
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.daG = str;
    }

    public TextView aET() {
        return this.dTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(String str) {
        this.dTP.setText(str);
    }

    public void mN(int i) {
        this.dTS = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEU() {
        am amVar = new am("c11437");
        amVar.x("obj_type", this.dTS);
        amVar.aA(ImageViewerConfig.FORUM_ID, this.daG);
        TiebaStatic.log(amVar);
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.dMs = frsFragment;
            this.mRootView = relativeLayout;
            this.dTN = LayoutInflater.from(frsFragment.getContext()).inflate(e.h.frs_sort_tab_layout, relativeLayout);
            this.dTO = (TextView) this.dTN.findViewById(e.g.sort_tab_menu_button);
            this.dTP = (TextView) this.dTN.findViewById(e.g.sort_tab_sort_name);
            this.byS = this.dTN.findViewById(e.g.sort_tab_divider_line);
            this.dTO.setOnClickListener(this.dTU);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dTO != null) {
            al.h(this.dTO, e.d.cp_cont_j);
            al.j(this.dTO, e.d.transparent);
            this.dTO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_gray_down), (Drawable) null);
        }
        al.h(this.dTP, e.d.cp_cont_b);
        al.j(this.dTN, e.d.cp_bg_line_d);
        al.j(this.byS, e.d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.I(list)) {
            aEW();
        } else if (this.dMs != null && this.dMs.aBs() != null && this.dMs.aBs().aHc()) {
            aEV();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bH(arrayList)) {
                if (!this.dTT) {
                    mO(i);
                    return;
                }
                return;
            }
            this.dTQ = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.dOd = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.dTQ.add(xVar);
                }
            }
            if (!this.dTT) {
                mO(i);
            }
        } else {
            aEW();
        }
    }

    private void mO(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.dTQ.get(0);
            if (xVar3 != null) {
                mN(xVar3.dOd);
                op(xVar3.name);
                if (this.dMs != null && this.dMs.aBs() != null) {
                    this.dMs.aBs().no(xVar3.dOd);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dTQ.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.dTQ.get(i2);
                if (xVar2 == null || xVar2.dOd != i) {
                    i2++;
                } else {
                    xVar = xVar2;
                    z = true;
                    break;
                }
            } else {
                xVar = xVar2;
                z = false;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                op(TbadkCoreApplication.getInst().getResources().getString(e.j.attention_users_thread));
                return;
            }
            x xVar4 = this.dTQ.get(0);
            if (xVar4 != null) {
                mN(xVar4.dOd);
                op(xVar4.name);
                if (this.dMs != null && this.dMs.aBs() != null) {
                    this.dMs.aBs().no(xVar4.dOd);
                }
            }
        } else if (xVar != null) {
            mN(xVar.dOd);
            op(xVar.name);
            if (this.dMs != null && this.dMs.aBs() != null) {
                this.dMs.aBs().no(xVar.dOd);
            }
        }
    }

    private boolean bH(List<FrsTabInfo> list) {
        if (!v.I(this.dTQ) && v.H(list) == v.H(this.dTQ)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dTQ.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void aEV() {
        if (this.dTO != null) {
            this.dTO.setVisibility(0);
        }
    }

    private void aEW() {
        if (this.dTO != null) {
            this.dTO.setVisibility(8);
        }
    }
}

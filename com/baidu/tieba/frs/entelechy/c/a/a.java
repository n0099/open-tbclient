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
    private View bvs;
    private String cRh;
    private FrsFragment dDf;
    private View dKt;
    private TextView dKu;
    private TextView dKv;
    private List<x> dKw;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dKx;
    private ViewGroup mRootView;
    private int dKy = -1;
    private boolean dKz = false;
    private View.OnClickListener dKA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.ayk().ayl()) {
                if (!j.kK()) {
                    a.this.dDf.showToast(e.j.neterror);
                } else if (!v.I(a.this.dKw)) {
                    if (a.this.dKx == null) {
                        a.this.dKx = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dDf, a.this.dKB);
                    }
                    a.this.dKx.setData(a.this.dKw);
                    a.this.dKx.d(a.this.dDf.getPageContext()).AE();
                }
            }
        }
    };
    private b.InterfaceC0148b dKB = new b.InterfaceC0148b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
        public void a(b bVar, int i, View view) {
            if (!j.kK()) {
                a.this.dDf.showToast(e.j.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) v.d(a.this.dKx.aCw(), i);
            if (xVar != null) {
                if (a.this.dKy != xVar.dEQ) {
                    a.this.dKz = true;
                    a.this.nL(xVar.name);
                    if (a.this.dDf.ayT() != null) {
                        a.this.dDf.ayT().mM(a.this.dKy);
                        a.this.dKy = xVar.dEQ;
                        bVar.dismiss();
                        if (a.this.dKy != 7) {
                            com.baidu.tbadk.util.v.Pa();
                            com.baidu.tieba.tbadkCore.util.e.bCv();
                        } else {
                            com.baidu.tieba.tbadkCore.util.e.bCu();
                        }
                        if (a.this.dDf.ayT() != null && a.this.dDf.ayY() != null) {
                            a.this.dDf.ayT().mL(xVar.dEQ);
                            a.this.dDf.ayY().startPullRefresh();
                            a.this.dDf.ayT().hj(true);
                            a.this.aCt();
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

    public void setFid(String str) {
        this.cRh = str;
    }

    public TextView aCs() {
        return this.dKu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nL(String str) {
        this.dKv.setText(str);
    }

    public void mk(int i) {
        this.dKy = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCt() {
        am amVar = new am("c11437");
        amVar.x("obj_type", this.dKy);
        amVar.ax(ImageViewerConfig.FORUM_ID, this.cRh);
        TiebaStatic.log(amVar);
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.dDf = frsFragment;
            this.mRootView = relativeLayout;
            this.dKt = LayoutInflater.from(frsFragment.getContext()).inflate(e.h.frs_sort_tab_layout, relativeLayout);
            this.dKu = (TextView) this.dKt.findViewById(e.g.sort_tab_menu_button);
            this.dKv = (TextView) this.dKt.findViewById(e.g.sort_tab_sort_name);
            this.bvs = this.dKt.findViewById(e.g.sort_tab_divider_line);
            this.dKu.setOnClickListener(this.dKA);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dKu != null) {
            al.h(this.dKu, e.d.cp_cont_j);
            al.j(this.dKu, e.d.transparent);
            this.dKu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_gray_down), (Drawable) null);
        }
        al.h(this.dKv, e.d.cp_cont_b);
        al.j(this.dKt, e.d.cp_bg_line_d);
        al.j(this.bvs, e.d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.I(list)) {
            aCv();
        } else if (this.dDf != null && this.dDf.ayT() != null && this.dDf.ayT().aEB()) {
            aCu();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bE(arrayList)) {
                if (!this.dKz) {
                    ml(i);
                    return;
                }
                return;
            }
            this.dKw = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.dEQ = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.dKw.add(xVar);
                }
            }
            if (!this.dKz) {
                ml(i);
            }
        } else {
            aCv();
        }
    }

    private void ml(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.dKw.get(0);
            if (xVar3 != null) {
                mk(xVar3.dEQ);
                nL(xVar3.name);
                if (this.dDf != null && this.dDf.ayT() != null) {
                    this.dDf.ayT().mL(xVar3.dEQ);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dKw.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.dKw.get(i2);
                if (xVar2 == null || xVar2.dEQ != i) {
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
                nL(TbadkCoreApplication.getInst().getResources().getString(e.j.attention_users_thread));
                return;
            }
            x xVar4 = this.dKw.get(0);
            if (xVar4 != null) {
                mk(xVar4.dEQ);
                nL(xVar4.name);
                if (this.dDf != null && this.dDf.ayT() != null) {
                    this.dDf.ayT().mL(xVar4.dEQ);
                }
            }
        } else if (xVar != null) {
            mk(xVar.dEQ);
            nL(xVar.name);
            if (this.dDf != null && this.dDf.ayT() != null) {
                this.dDf.ayT().mL(xVar.dEQ);
            }
        }
    }

    private boolean bE(List<FrsTabInfo> list) {
        if (!v.I(this.dKw) && v.H(list) == v.H(this.dKw)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dKw.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void aCu() {
        if (this.dKu != null) {
            this.dKu.setVisibility(0);
        }
    }

    private void aCv() {
        if (this.dKu != null) {
            this.dKu.setVisibility(8);
        }
    }
}

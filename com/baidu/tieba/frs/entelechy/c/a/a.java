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
    private View buH;
    private String cQb;
    private FrsFragment dBO;
    private View dJp;
    private TextView dJq;
    private TextView dJr;
    private List<x> dJs;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dJt;
    private int dJu = -1;
    private boolean dJv = false;
    private View.OnClickListener dJw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.ayM().ayN()) {
                if (!j.kM()) {
                    a.this.dBO.showToast(e.j.neterror);
                } else if (!v.J(a.this.dJs)) {
                    if (a.this.dJt == null) {
                        a.this.dJt = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dBO, a.this.dJx);
                    }
                    a.this.dJt.setData(a.this.dJs);
                    a.this.dJt.d(a.this.dBO.getPageContext()).Ax();
                }
            }
        }
    };
    private b.InterfaceC0124b dJx = new b.InterfaceC0124b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
        public void a(b bVar, int i, View view) {
            if (!j.kM()) {
                a.this.dBO.showToast(e.j.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) v.d(a.this.dJt.aDb(), i);
            if (xVar != null) {
                if (a.this.dJu != xVar.dDA) {
                    a.this.dJv = true;
                    a.this.nK(xVar.name);
                    if (a.this.dBO.azv() != null) {
                        a.this.dBO.azv().mu(a.this.dJu);
                        a.this.dJu = xVar.dDA;
                        bVar.dismiss();
                        if (a.this.dJu != 7) {
                            com.baidu.tbadk.util.v.OR();
                            com.baidu.tieba.tbadkCore.util.e.bDa();
                        } else {
                            com.baidu.tieba.tbadkCore.util.e.bCZ();
                        }
                        if (a.this.dBO.azv() != null && a.this.dBO.azA() != null) {
                            a.this.dBO.azv().mt(xVar.dDA);
                            a.this.dBO.azA().startPullRefresh();
                            a.this.dBO.azv().gZ(true);
                            a.this.aCY();
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
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.cQb = str;
    }

    public TextView aCX() {
        return this.dJq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK(String str) {
        this.dJr.setText(str);
    }

    public void lT(int i) {
        this.dJu = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCY() {
        am amVar = new am("c11437");
        amVar.x("obj_type", this.dJu);
        amVar.ax(ImageViewerConfig.FORUM_ID, this.cQb);
        TiebaStatic.log(amVar);
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.dBO = frsFragment;
            this.mRootView = relativeLayout;
            this.dJp = LayoutInflater.from(frsFragment.getContext()).inflate(e.h.frs_sort_tab_layout, relativeLayout);
            this.dJq = (TextView) this.dJp.findViewById(e.g.sort_tab_menu_button);
            this.dJr = (TextView) this.dJp.findViewById(e.g.sort_tab_sort_name);
            this.buH = this.dJp.findViewById(e.g.sort_tab_divider_line);
            this.dJq.setOnClickListener(this.dJw);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dJq != null) {
            al.h(this.dJq, e.d.cp_cont_j);
            al.j(this.dJq, e.d.transparent);
            this.dJq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_gray_down), (Drawable) null);
        }
        al.h(this.dJr, e.d.cp_cont_b);
        al.j(this.dJp, e.d.cp_bg_line_d);
        al.j(this.buH, e.d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.J(list)) {
            aDa();
        } else if (this.dBO != null && this.dBO.azv() != null && this.dBO.azv().aFf()) {
            aCZ();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bG(arrayList)) {
                if (!this.dJv) {
                    lU(i);
                    return;
                }
                return;
            }
            this.dJs = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.dDA = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.dJs.add(xVar);
                }
            }
            if (!this.dJv) {
                lU(i);
            }
        } else {
            aDa();
        }
    }

    private void lU(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.dJs.get(0);
            if (xVar3 != null) {
                lT(xVar3.dDA);
                nK(xVar3.name);
                if (this.dBO != null && this.dBO.azv() != null) {
                    this.dBO.azv().mt(xVar3.dDA);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dJs.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.dJs.get(i2);
                if (xVar2 == null || xVar2.dDA != i) {
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
                nK(TbadkCoreApplication.getInst().getResources().getString(e.j.attention_users_thread));
                return;
            }
            x xVar4 = this.dJs.get(0);
            if (xVar4 != null) {
                lT(xVar4.dDA);
                nK(xVar4.name);
                if (this.dBO != null && this.dBO.azv() != null) {
                    this.dBO.azv().mt(xVar4.dDA);
                }
            }
        } else if (xVar != null) {
            lT(xVar.dDA);
            nK(xVar.name);
            if (this.dBO != null && this.dBO.azv() != null) {
                this.dBO.azv().mt(xVar.dDA);
            }
        }
    }

    private boolean bG(List<FrsTabInfo> list) {
        if (!v.J(this.dJs) && v.I(list) == v.I(this.dJs)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dJs.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void aCZ() {
        if (this.dJq != null) {
            this.dJq.setVisibility(0);
        }
    }

    private void aDa() {
        if (this.dJq != null) {
            this.dJq.setVisibility(8);
        }
    }
}

package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.tbadkCore.util.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup aaQ;
    private String azL;
    private f crm;
    private TextView cwC;
    private List<x> cwD;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cwE;
    private int cwF = -1;
    private boolean cwG = false;
    private View.OnClickListener cwH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!i.gW()) {
                a.this.crm.showToast(d.l.neterror);
                return;
            }
            if (a.this.cwE == null) {
                a.this.cwE = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.crm, a.this.cwI);
            }
            a.this.cwE.setData(a.this.cwD);
            a.this.cwE.d(a.this.crm.getPageContext()).tr();
        }
    };
    private b.InterfaceC0046b cwI = new b.InterfaceC0046b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
        public void a(b bVar, int i, View view) {
            if (!i.gW()) {
                a.this.crm.showToast(d.l.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) v.c(a.this.cwE.ajx(), i);
            if (xVar != null) {
                if (a.this.cwF != xVar.csJ) {
                    a.this.cwG = true;
                    a.this.cwC.setText(xVar.name);
                    if (a.this.cwF == 7) {
                        ak akVar = new ak("c11437");
                        akVar.r("obj_locate", xVar.csJ);
                        akVar.ad("fid", a.this.azL);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.crm.agT() != null) {
                        a.this.crm.agT().jG(a.this.cwF);
                        a.this.cwF = xVar.csJ;
                        bVar.dismiss();
                        if (a.this.cwF != 7) {
                            s.Hr();
                            g.btw();
                        } else {
                            g.btv();
                        }
                        if (a.this.crm.agT() != null && a.this.crm.agY() != null) {
                            a.this.crm.agT().jF(xVar.csJ);
                            a.this.crm.agY().startPullRefresh();
                            a.this.crm.agT().fj(true);
                            com.baidu.tieba.frs.smartsort.d.alp().g(a.this.crm.agT().getForumName(), xVar.csJ, xVar.name);
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
        this.azL = str;
    }

    public TextView aju() {
        return this.cwC;
    }

    public void kI(String str) {
        this.cwC.setText(str);
    }

    public void jm(int i) {
        this.cwF = i;
    }

    public a(f fVar, ViewGroup viewGroup) {
        if (fVar != null && viewGroup != null) {
            this.crm = fVar;
            this.aaQ = viewGroup;
            this.cwC = new TextView(fVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.f(TbadkCoreApplication.getInst(), d.f.ds82));
            layoutParams.topMargin = k.f(fVar.getActivity(), d.f.ds26);
            int f = k.f(fVar.getActivity(), d.f.ds30);
            this.cwC.setPadding(f, 0, f, 0);
            this.cwC.setGravity(17);
            this.cwC.setTextSize(0, k.f(fVar.getActivity(), d.f.ds28));
            this.cwC.setCompoundDrawablePadding(k.f(fVar.getActivity(), d.f.ds8));
            this.cwC.setLayoutParams(layoutParams);
            this.cwC.setOnClickListener(this.cwH);
            this.aaQ.addView(this.cwC);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cwC != null) {
            aj.i(this.cwC, d.e.cp_cont_f);
            aj.k(this.cwC, d.e.transparent);
            this.cwC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (v.v(list)) {
            ajw();
        } else if (this.crm != null && this.crm.agT() != null && this.crm.agT().akU()) {
            ajv();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!aM(arrayList)) {
                if (!this.cwG) {
                    jn(i);
                    return;
                }
                return;
            }
            this.cwD = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.csJ = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.cwD.add(xVar);
                }
            }
            if (!this.cwG) {
                jn(i);
            }
        } else {
            ajw();
        }
    }

    private void jn(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.cwD.get(0);
            if (xVar3 != null) {
                jm(xVar3.csJ);
                kI(xVar3.name);
                if (this.crm != null && this.crm.agT() != null) {
                    this.crm.agT().jF(xVar3.csJ);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cwD.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.cwD.get(i2);
                if (xVar2 == null || xVar2.csJ != i) {
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
                kI(TbadkCoreApplication.getInst().getResources().getString(d.l.attention_users_thread));
                return;
            }
            x xVar4 = this.cwD.get(0);
            if (xVar4 != null) {
                jm(xVar4.csJ);
                kI(xVar4.name);
                if (this.crm != null && this.crm.agT() != null) {
                    this.crm.agT().jF(xVar4.csJ);
                }
            }
        } else if (xVar != null) {
            jm(xVar.csJ);
            kI(xVar.name);
            if (this.crm != null && this.crm.agT() != null) {
                this.crm.agT().jF(xVar.csJ);
            }
        }
    }

    private boolean aM(List<FrsTabInfo> list) {
        if (!v.v(this.cwD) && v.u(list) == v.u(this.cwD)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cwD.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void ajv() {
        if (this.cwC != null) {
            this.cwC.setVisibility(0);
        }
    }

    public void ajw() {
        if (this.cwC != null) {
            this.cwC.setVisibility(8);
        }
    }
}

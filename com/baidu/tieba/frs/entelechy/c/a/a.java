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
    private String azO;
    private f cqt;
    private TextView cvK;
    private List<x> cvL;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cvM;
    private int cvN = -1;
    private boolean cvO = false;
    private View.OnClickListener cvP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!i.gW()) {
                a.this.cqt.showToast(d.l.neterror);
                return;
            }
            if (a.this.cvM == null) {
                a.this.cvM = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.cqt, a.this.cvQ);
            }
            a.this.cvM.setData(a.this.cvL);
            a.this.cvM.d(a.this.cqt.getPageContext()).tr();
        }
    };
    private b.InterfaceC0047b cvQ = new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(b bVar, int i, View view) {
            if (!i.gW()) {
                a.this.cqt.showToast(d.l.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) v.c(a.this.cvM.ajm(), i);
            if (xVar != null) {
                if (a.this.cvN != xVar.crR) {
                    a.this.cvO = true;
                    a.this.cvK.setText(xVar.name);
                    if (a.this.cvN == 7) {
                        ak akVar = new ak("c11437");
                        akVar.r("obj_locate", xVar.crR);
                        akVar.ad("fid", a.this.azO);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.cqt.agI() != null) {
                        a.this.cqt.agI().jE(a.this.cvN);
                        a.this.cvN = xVar.crR;
                        bVar.dismiss();
                        if (a.this.cvN != 7) {
                            s.Hr();
                            g.btl();
                        } else {
                            g.btk();
                        }
                        if (a.this.cqt.agI() != null && a.this.cqt.agN() != null) {
                            a.this.cqt.agI().jD(xVar.crR);
                            a.this.cqt.agN().startPullRefresh();
                            a.this.cqt.agI().fi(true);
                            com.baidu.tieba.frs.smartsort.d.ale().g(a.this.cqt.agI().getForumName(), xVar.crR, xVar.name);
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
        this.azO = str;
    }

    public TextView ajj() {
        return this.cvK;
    }

    public void kG(String str) {
        this.cvK.setText(str);
    }

    public void jk(int i) {
        this.cvN = i;
    }

    public a(f fVar, ViewGroup viewGroup) {
        if (fVar != null && viewGroup != null) {
            this.cqt = fVar;
            this.aaQ = viewGroup;
            this.cvK = new TextView(fVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.g(TbadkCoreApplication.getInst(), d.f.ds82));
            layoutParams.topMargin = k.g(fVar.getActivity(), d.f.ds26);
            int g = k.g(fVar.getActivity(), d.f.ds30);
            this.cvK.setPadding(g, 0, g, 0);
            this.cvK.setGravity(17);
            this.cvK.setTextSize(0, k.g(fVar.getActivity(), d.f.ds28));
            this.cvK.setCompoundDrawablePadding(k.g(fVar.getActivity(), d.f.ds8));
            this.cvK.setLayoutParams(layoutParams);
            this.cvK.setOnClickListener(this.cvP);
            this.aaQ.addView(this.cvK);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cvK != null) {
            aj.i(this.cvK, d.e.cp_cont_f);
            aj.k(this.cvK, d.e.transparent);
            this.cvK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (v.v(list)) {
            ajl();
        } else if (this.cqt != null && this.cqt.agI() != null && this.cqt.agI().akJ()) {
            ajk();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!aM(arrayList)) {
                if (!this.cvO) {
                    jl(i);
                    return;
                }
                return;
            }
            this.cvL = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.crR = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.cvL.add(xVar);
                }
            }
            if (!this.cvO) {
                jl(i);
            }
        } else {
            ajl();
        }
    }

    private void jl(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.cvL.get(0);
            if (xVar3 != null) {
                jk(xVar3.crR);
                kG(xVar3.name);
                if (this.cqt != null && this.cqt.agI() != null) {
                    this.cqt.agI().jD(xVar3.crR);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cvL.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.cvL.get(i2);
                if (xVar2 == null || xVar2.crR != i) {
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
                kG(TbadkCoreApplication.getInst().getResources().getString(d.l.attention_users_thread));
                return;
            }
            x xVar4 = this.cvL.get(0);
            if (xVar4 != null) {
                jk(xVar4.crR);
                kG(xVar4.name);
                if (this.cqt != null && this.cqt.agI() != null) {
                    this.cqt.agI().jD(xVar4.crR);
                }
            }
        } else if (xVar != null) {
            jk(xVar.crR);
            kG(xVar.name);
            if (this.cqt != null && this.cqt.agI() != null) {
                this.cqt.agI().jD(xVar.crR);
            }
        }
    }

    private boolean aM(List<FrsTabInfo> list) {
        if (!v.v(this.cvL) && v.u(list) == v.u(this.cvL)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cvL.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void ajk() {
        if (this.cvK != null) {
            this.cvK.setVisibility(0);
        }
    }

    public void ajl() {
        if (this.cvK != null) {
            this.cvK.setVisibility(8);
        }
    }
}

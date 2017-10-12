package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup aaQ;
    private String azf;
    private f crI;
    private TextView cxs;
    private List<y> cxt;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cxu;
    private int cxv = -1;
    private boolean cxw = false;
    private View.OnClickListener cxx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.gV()) {
                a.this.crI.showToast(d.l.neterror);
                return;
            }
            if (a.this.cxu == null) {
                a.this.cxu = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.crI, a.this.cxy);
            }
            a.this.cxu.setData(a.this.cxt);
            a.this.cxu.d(a.this.crI.getPageContext()).tl();
        }
    };
    private b.InterfaceC0047b cxy = new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(b bVar, int i, View view) {
            if (!j.gV()) {
                a.this.crI.showToast(d.l.neterror);
                bVar.dismiss();
                return;
            }
            y yVar = (y) v.c(a.this.cxu.ajC(), i);
            if (yVar != null) {
                if (a.this.cxv != yVar.ctl) {
                    a.this.cxw = true;
                    a.this.cxs.setText(yVar.name);
                    if (a.this.cxv == 7) {
                        ak akVar = new ak("c11437");
                        akVar.r("obj_locate", yVar.ctl);
                        akVar.ad("fid", a.this.azf);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.crI.agP() != null) {
                        a.this.crI.agP().jO(a.this.cxv);
                        a.this.cxv = yVar.ctl;
                        bVar.dismiss();
                        if (a.this.cxv != 7) {
                            r.GV();
                            com.baidu.tieba.tbadkCore.util.f.bsu();
                        } else {
                            com.baidu.tieba.tbadkCore.util.f.bst();
                        }
                        if (a.this.crI.agP() != null && a.this.crI.agU() != null) {
                            a.this.crI.agP().jN(yVar.ctl);
                            a.this.crI.agU().startPullRefresh();
                            a.this.crI.agP().fd(true);
                            com.baidu.tieba.frs.smartsort.d.alt().g(a.this.crI.agP().getForumName(), yVar.ctl, yVar.name);
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
        this.azf = str;
    }

    public TextView ajz() {
        return this.cxs;
    }

    public void kD(String str) {
        this.cxs.setText(str);
    }

    public void jv(int i) {
        this.cxv = i;
    }

    public a(f fVar, ViewGroup viewGroup) {
        if (fVar != null && viewGroup != null) {
            this.crI = fVar;
            this.aaQ = viewGroup;
            this.cxs = new TextView(fVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(TbadkCoreApplication.getInst(), d.f.ds82));
            layoutParams.topMargin = l.f(fVar.getActivity(), d.f.ds26);
            int f = l.f(fVar.getActivity(), d.f.ds30);
            this.cxs.setPadding(f, 0, f, 0);
            this.cxs.setGravity(17);
            this.cxs.setTextSize(0, l.f(fVar.getActivity(), d.f.ds28));
            this.cxs.setCompoundDrawablePadding(l.f(fVar.getActivity(), d.f.ds8));
            this.cxs.setLayoutParams(layoutParams);
            this.cxs.setOnClickListener(this.cxx);
            this.aaQ.addView(this.cxs);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cxs != null) {
            aj.i(this.cxs, d.e.cp_cont_f);
            aj.k(this.cxs, d.e.transparent);
            this.cxs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (v.u(list)) {
            ajB();
        } else if (this.crI != null && this.crI.agP() != null && this.crI.agP().akY()) {
            ajA();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!aM(arrayList)) {
                if (!this.cxw) {
                    jw(i);
                    return;
                }
                return;
            }
            this.cxt = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    y yVar = new y();
                    yVar.ctl = frsTabInfo.tab_id.intValue();
                    yVar.name = frsTabInfo.tab_name;
                    this.cxt.add(yVar);
                }
            }
            if (!this.cxw) {
                jw(i);
            }
        } else {
            ajB();
        }
    }

    private void jw(int i) {
        y yVar;
        boolean z;
        y yVar2 = null;
        if (i <= 0) {
            y yVar3 = this.cxt.get(0);
            if (yVar3 != null) {
                jv(yVar3.ctl);
                kD(yVar3.name);
                if (this.crI != null && this.crI.agP() != null) {
                    this.crI.agP().jN(yVar3.ctl);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cxt.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                yVar2 = this.cxt.get(i2);
                if (yVar2 == null || yVar2.ctl != i) {
                    i2++;
                } else {
                    yVar = yVar2;
                    z = true;
                    break;
                }
            } else {
                yVar = yVar2;
                z = false;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                kD(TbadkCoreApplication.getInst().getResources().getString(d.l.attention_users_thread));
                return;
            }
            y yVar4 = this.cxt.get(0);
            if (yVar4 != null) {
                jv(yVar4.ctl);
                kD(yVar4.name);
                if (this.crI != null && this.crI.agP() != null) {
                    this.crI.agP().jN(yVar4.ctl);
                }
            }
        } else if (yVar != null) {
            jv(yVar.ctl);
            kD(yVar.name);
            if (this.crI != null && this.crI.agP() != null) {
                this.crI.agP().jN(yVar.ctl);
            }
        }
    }

    private boolean aM(List<FrsTabInfo> list) {
        if (!v.u(this.cxt) && v.t(list) == v.t(this.cxt)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cxt.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void ajA() {
        if (this.cxs != null) {
            this.cxs.setVisibility(0);
        }
    }

    public void ajB() {
        if (this.cxs != null) {
            this.cxs.setVisibility(8);
        }
    }
}

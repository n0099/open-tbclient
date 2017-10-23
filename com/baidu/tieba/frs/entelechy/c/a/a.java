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
    private ViewGroup aaE;
    private String ayT;
    private f crw;
    private TextView cxg;
    private List<y> cxh;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cxi;
    private int cxj = -1;
    private boolean cxk = false;
    private View.OnClickListener cxl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.gV()) {
                a.this.crw.showToast(d.l.neterror);
                return;
            }
            if (a.this.cxi == null) {
                a.this.cxi = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.crw, a.this.cxm);
            }
            a.this.cxi.setData(a.this.cxh);
            a.this.cxi.d(a.this.crw.getPageContext()).te();
        }
    };
    private b.InterfaceC0047b cxm = new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(b bVar, int i, View view) {
            if (!j.gV()) {
                a.this.crw.showToast(d.l.neterror);
                bVar.dismiss();
                return;
            }
            y yVar = (y) v.c(a.this.cxi.ajx(), i);
            if (yVar != null) {
                if (a.this.cxj != yVar.csZ) {
                    a.this.cxk = true;
                    a.this.cxg.setText(yVar.name);
                    if (a.this.cxj == 7) {
                        ak akVar = new ak("c11437");
                        akVar.r("obj_locate", yVar.csZ);
                        akVar.ac("fid", a.this.ayT);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.crw.agK() != null) {
                        a.this.crw.agK().jN(a.this.cxj);
                        a.this.cxj = yVar.csZ;
                        bVar.dismiss();
                        if (a.this.cxj != 7) {
                            r.GP();
                            com.baidu.tieba.tbadkCore.util.f.bsn();
                        } else {
                            com.baidu.tieba.tbadkCore.util.f.bsm();
                        }
                        if (a.this.crw.agK() != null && a.this.crw.agP() != null) {
                            a.this.crw.agK().jM(yVar.csZ);
                            a.this.crw.agP().startPullRefresh();
                            a.this.crw.agK().fc(true);
                            com.baidu.tieba.frs.smartsort.d.alo().g(a.this.crw.agK().getForumName(), yVar.csZ, yVar.name);
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
        this.ayT = str;
    }

    public TextView aju() {
        return this.cxg;
    }

    public void kC(String str) {
        this.cxg.setText(str);
    }

    public void ju(int i) {
        this.cxj = i;
    }

    public a(f fVar, ViewGroup viewGroup) {
        if (fVar != null && viewGroup != null) {
            this.crw = fVar;
            this.aaE = viewGroup;
            this.cxg = new TextView(fVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(TbadkCoreApplication.getInst(), d.f.ds82));
            layoutParams.topMargin = l.f(fVar.getActivity(), d.f.ds26);
            int f = l.f(fVar.getActivity(), d.f.ds30);
            this.cxg.setPadding(f, 0, f, 0);
            this.cxg.setGravity(17);
            this.cxg.setTextSize(0, l.f(fVar.getActivity(), d.f.ds28));
            this.cxg.setCompoundDrawablePadding(l.f(fVar.getActivity(), d.f.ds8));
            this.cxg.setLayoutParams(layoutParams);
            this.cxg.setOnClickListener(this.cxl);
            this.aaE.addView(this.cxg);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cxg != null) {
            aj.i(this.cxg, d.e.cp_cont_f);
            aj.k(this.cxg, d.e.transparent);
            this.cxg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (v.u(list)) {
            ajw();
        } else if (this.crw != null && this.crw.agK() != null && this.crw.agK().akT()) {
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
                if (!this.cxk) {
                    jv(i);
                    return;
                }
                return;
            }
            this.cxh = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    y yVar = new y();
                    yVar.csZ = frsTabInfo.tab_id.intValue();
                    yVar.name = frsTabInfo.tab_name;
                    this.cxh.add(yVar);
                }
            }
            if (!this.cxk) {
                jv(i);
            }
        } else {
            ajw();
        }
    }

    private void jv(int i) {
        y yVar;
        boolean z;
        y yVar2 = null;
        if (i <= 0) {
            y yVar3 = this.cxh.get(0);
            if (yVar3 != null) {
                ju(yVar3.csZ);
                kC(yVar3.name);
                if (this.crw != null && this.crw.agK() != null) {
                    this.crw.agK().jM(yVar3.csZ);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cxh.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                yVar2 = this.cxh.get(i2);
                if (yVar2 == null || yVar2.csZ != i) {
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
                kC(TbadkCoreApplication.getInst().getResources().getString(d.l.attention_users_thread));
                return;
            }
            y yVar4 = this.cxh.get(0);
            if (yVar4 != null) {
                ju(yVar4.csZ);
                kC(yVar4.name);
                if (this.crw != null && this.crw.agK() != null) {
                    this.crw.agK().jM(yVar4.csZ);
                }
            }
        } else if (yVar != null) {
            ju(yVar.csZ);
            kC(yVar.name);
            if (this.crw != null && this.crw.agK() != null) {
                this.crw.agK().jM(yVar.csZ);
            }
        }
    }

    private boolean aM(List<FrsTabInfo> list) {
        if (!v.u(this.cxh) && v.t(list) == v.t(this.cxh)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cxh.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void ajv() {
        if (this.cxg != null) {
            this.cxg.setVisibility(0);
        }
    }

    public void ajw() {
        if (this.cxg != null) {
            this.cxg.setVisibility(8);
        }
    }
}

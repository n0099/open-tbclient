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
/* loaded from: classes2.dex */
public class a {
    private View bqy;
    private String cHI;
    private View dBp;
    private TextView dBq;
    private TextView dBr;
    private List<x> dBs;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dBt;
    private int dBu = -1;
    private boolean dBv = false;
    private View.OnClickListener dBw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.avq().avr()) {
                if (!j.ky()) {
                    a.this.dtN.showToast(e.j.neterror);
                } else if (!v.z(a.this.dBs)) {
                    if (a.this.dBt == null) {
                        a.this.dBt = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dtN, a.this.dBx);
                    }
                    a.this.dBt.setData(a.this.dBs);
                    a.this.dBt.d(a.this.dtN.getPageContext()).yo();
                }
            }
        }
    };
    private b.InterfaceC0100b dBx = new b.InterfaceC0100b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
        public void a(b bVar, int i, View view) {
            if (!j.ky()) {
                a.this.dtN.showToast(e.j.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) v.d(a.this.dBt.azI(), i);
            if (xVar != null) {
                if (a.this.dBu != xVar.dvz) {
                    a.this.dBv = true;
                    a.this.ni(xVar.name);
                    if (a.this.dtN.avZ() != null) {
                        a.this.dtN.avZ().lW(a.this.dBu);
                        a.this.dBu = xVar.dvz;
                        bVar.dismiss();
                        if (a.this.dBu != 7) {
                            com.baidu.tbadk.util.v.MT();
                            com.baidu.tieba.tbadkCore.util.e.bzL();
                        } else {
                            com.baidu.tieba.tbadkCore.util.e.bzK();
                        }
                        if (a.this.dtN.avZ() != null && a.this.dtN.awe() != null) {
                            a.this.dtN.avZ().lV(xVar.dvz);
                            a.this.dtN.awe().startPullRefresh();
                            a.this.dtN.avZ().gH(true);
                            a.this.azF();
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
    private FrsFragment dtN;
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.cHI = str;
    }

    public TextView azE() {
        return this.dBq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(String str) {
        this.dBr.setText(str);
    }

    public void lv(int i) {
        this.dBu = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azF() {
        am amVar = new am("c11437");
        amVar.w("obj_type", this.dBu);
        amVar.al(ImageViewerConfig.FORUM_ID, this.cHI);
        TiebaStatic.log(amVar);
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.dtN = frsFragment;
            this.mRootView = relativeLayout;
            this.dBp = LayoutInflater.from(frsFragment.getContext()).inflate(e.h.frs_sort_tab_layout, relativeLayout);
            this.dBq = (TextView) this.dBp.findViewById(e.g.sort_tab_menu_button);
            this.dBr = (TextView) this.dBp.findViewById(e.g.sort_tab_sort_name);
            this.bqy = this.dBp.findViewById(e.g.sort_tab_divider_line);
            this.dBq.setOnClickListener(this.dBw);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dBq != null) {
            al.h(this.dBq, e.d.cp_cont_j);
            al.j(this.dBq, e.d.transparent);
            this.dBq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_gray_down), (Drawable) null);
        }
        al.h(this.dBr, e.d.cp_cont_b);
        al.j(this.dBp, e.d.cp_bg_line_d);
        al.j(this.bqy, e.d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.z(list)) {
            azH();
        } else if (this.dtN != null && this.dtN.avZ() != null && this.dtN.avZ().aBM()) {
            azG();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bq(arrayList)) {
                if (!this.dBv) {
                    lw(i);
                    return;
                }
                return;
            }
            this.dBs = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.dvz = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.dBs.add(xVar);
                }
            }
            if (!this.dBv) {
                lw(i);
            }
        } else {
            azH();
        }
    }

    private void lw(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.dBs.get(0);
            if (xVar3 != null) {
                lv(xVar3.dvz);
                ni(xVar3.name);
                if (this.dtN != null && this.dtN.avZ() != null) {
                    this.dtN.avZ().lV(xVar3.dvz);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dBs.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.dBs.get(i2);
                if (xVar2 == null || xVar2.dvz != i) {
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
                ni(TbadkCoreApplication.getInst().getResources().getString(e.j.attention_users_thread));
                return;
            }
            x xVar4 = this.dBs.get(0);
            if (xVar4 != null) {
                lv(xVar4.dvz);
                ni(xVar4.name);
                if (this.dtN != null && this.dtN.avZ() != null) {
                    this.dtN.avZ().lV(xVar4.dvz);
                }
            }
        } else if (xVar != null) {
            lv(xVar.dvz);
            ni(xVar.name);
            if (this.dtN != null && this.dtN.avZ() != null) {
                this.dtN.avZ().lV(xVar.dvz);
            }
        }
    }

    private boolean bq(List<FrsTabInfo> list) {
        if (!v.z(this.dBs) && v.y(list) == v.y(this.dBs)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dBs.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void azG() {
        if (this.dBq != null) {
            this.dBq.setVisibility(0);
        }
    }

    private void azH() {
        if (this.dBq != null) {
            this.dBq.setVisibility(8);
        }
    }
}

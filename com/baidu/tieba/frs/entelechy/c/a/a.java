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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    private View biz;
    private String cBu;
    private FrsFragment diZ;
    private View doO;
    private TextView doP;
    private TextView doQ;
    private List<v> doR;
    private com.baidu.tieba.frs.entelechy.c.a.a.a doS;
    private int doT = -1;
    private boolean doU = false;
    private View.OnClickListener doV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jr()) {
                a.this.diZ.showToast(d.k.neterror);
            } else if (!w.z(a.this.doR)) {
                if (a.this.doS == null) {
                    a.this.doS = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.diZ, a.this.doW);
                }
                a.this.doS.setData(a.this.doR);
                a.this.doS.d(a.this.diZ.getPageContext()).xd();
            }
        }
    };
    private b.InterfaceC0103b doW = new b.InterfaceC0103b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
        public void a(b bVar, int i, View view) {
            if (!j.jr()) {
                a.this.diZ.showToast(d.k.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) w.c(a.this.doS.awm(), i);
            if (vVar != null) {
                if (a.this.doT != vVar.dkv) {
                    a.this.doU = true;
                    a.this.mE(vVar.name);
                    if (a.this.doT == 7) {
                        am amVar = new am("c11437");
                        amVar.r("obj_locate", vVar.dkv);
                        amVar.ah(ImageViewerConfig.FORUM_ID, a.this.cBu);
                        TiebaStatic.log(amVar);
                    }
                    if (a.this.diZ.atm() != null) {
                        a.this.diZ.atm().lc(a.this.doT);
                        a.this.doT = vVar.dkv;
                        bVar.dismiss();
                        if (a.this.doT != 7) {
                            u.Lk();
                            e.bxZ();
                        } else {
                            e.bxY();
                        }
                        if (a.this.diZ.atm() != null && a.this.diZ.atr() != null) {
                            a.this.diZ.atm().lb(vVar.dkv);
                            a.this.diZ.atr().startPullRefresh();
                            a.this.diZ.atm().fZ(true);
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
        this.cBu = str;
    }

    public TextView awj() {
        return this.doP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(String str) {
        this.doQ.setText(str);
    }

    public void kB(int i) {
        this.doT = i;
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.diZ = frsFragment;
            this.mRootView = relativeLayout;
            this.doO = LayoutInflater.from(frsFragment.getContext()).inflate(d.i.frs_sort_tab_layout, relativeLayout);
            this.doP = (TextView) this.doO.findViewById(d.g.sort_tab_menu_button);
            this.doQ = (TextView) this.doO.findViewById(d.g.sort_tab_sort_name);
            this.biz = this.doO.findViewById(d.g.sort_tab_divider_line);
            this.doP.setOnClickListener(this.doV);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.doP != null) {
            al.h(this.doP, d.C0141d.cp_cont_j);
            al.j(this.doP, d.C0141d.transparent);
            this.doP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
        al.h(this.doQ, d.C0141d.cp_cont_b);
        al.j(this.doO, d.C0141d.cp_bg_line_d);
        al.j(this.biz, d.C0141d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (w.z(list)) {
            awl();
        } else if (this.diZ != null && this.diZ.atm() != null && this.diZ.atm().ayu()) {
            awk();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bn(arrayList)) {
                if (!this.doU) {
                    kC(i);
                    return;
                }
                return;
            }
            this.doR = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.dkv = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.doR.add(vVar);
                }
            }
            if (!this.doU) {
                kC(i);
            }
        } else {
            awl();
        }
    }

    private void kC(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.doR.get(0);
            if (vVar3 != null) {
                kB(vVar3.dkv);
                mE(vVar3.name);
                if (this.diZ != null && this.diZ.atm() != null) {
                    this.diZ.atm().lb(vVar3.dkv);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.doR.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.doR.get(i2);
                if (vVar2 == null || vVar2.dkv != i) {
                    i2++;
                } else {
                    vVar = vVar2;
                    z = true;
                    break;
                }
            } else {
                vVar = vVar2;
                z = false;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                mE(TbadkCoreApplication.getInst().getResources().getString(d.k.attention_users_thread));
                return;
            }
            v vVar4 = this.doR.get(0);
            if (vVar4 != null) {
                kB(vVar4.dkv);
                mE(vVar4.name);
                if (this.diZ != null && this.diZ.atm() != null) {
                    this.diZ.atm().lb(vVar4.dkv);
                }
            }
        } else if (vVar != null) {
            kB(vVar.dkv);
            mE(vVar.name);
            if (this.diZ != null && this.diZ.atm() != null) {
                this.diZ.atm().lb(vVar.dkv);
            }
        }
    }

    private boolean bn(List<FrsTabInfo> list) {
        if (!w.z(this.doR) && w.y(list) == w.y(this.doR)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.doR.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void awk() {
        if (this.doP != null) {
            this.doP.setVisibility(0);
        }
    }

    private void awl() {
        if (this.doP != null) {
            this.doP.setVisibility(8);
        }
    }

    public void resetData() {
        this.doR = null;
    }
}

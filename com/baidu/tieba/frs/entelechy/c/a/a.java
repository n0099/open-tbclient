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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.util.t;
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
    private View ban;
    private FrsFragment cZJ;
    private String csP;
    private TextView dfA;
    private TextView dfB;
    private List<v> dfC;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dfD;
    private int dfE = -1;
    private boolean dfF = false;
    private View.OnClickListener dfG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                a.this.cZJ.showToast(d.k.neterror);
            } else if (!com.baidu.tbadk.core.util.v.w(a.this.dfC)) {
                if (a.this.dfD == null) {
                    a.this.dfD = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.cZJ, a.this.dfH);
                }
                a.this.dfD.setData(a.this.dfC);
                a.this.dfD.d(a.this.cZJ.getPageContext()).tF();
            }
        }
    };
    private b.InterfaceC0086b dfH = new b.InterfaceC0086b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
        public void a(b bVar, int i, View view2) {
            if (!j.gD()) {
                a.this.cZJ.showToast(d.k.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) com.baidu.tbadk.core.util.v.c(a.this.dfD.ash(), i);
            if (vVar != null) {
                if (a.this.dfE != vVar.dbf) {
                    a.this.dfF = true;
                    a.this.lX(vVar.name);
                    if (a.this.dfE == 7) {
                        al alVar = new al("c11437");
                        alVar.r("obj_locate", vVar.dbf);
                        alVar.ac(ImageViewerConfig.FORUM_ID, a.this.csP);
                        TiebaStatic.log(alVar);
                    }
                    if (a.this.cZJ.apg() != null) {
                        a.this.cZJ.apg().kV(a.this.dfE);
                        a.this.dfE = vVar.dbf;
                        bVar.dismiss();
                        if (a.this.dfE != 7) {
                            t.HO();
                            e.bsU();
                        } else {
                            e.bsT();
                        }
                        if (a.this.cZJ.apg() != null && a.this.cZJ.apm() != null) {
                            a.this.cZJ.apg().kU(vVar.dbf);
                            a.this.cZJ.apm().startPullRefresh();
                            a.this.cZJ.apg().fT(true);
                            com.baidu.tieba.frs.smartsort.d.auC().i(a.this.cZJ.apg().getForumName(), vVar.dbf, vVar.name);
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
    private View dfz;
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.csP = str;
    }

    public TextView ase() {
        return this.dfA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX(String str) {
        this.dfB.setText(str);
    }

    public void kw(int i) {
        this.dfE = i;
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.cZJ = frsFragment;
            this.mRootView = relativeLayout;
            this.dfz = LayoutInflater.from(frsFragment.getContext()).inflate(d.i.frs_sort_tab_layout, relativeLayout);
            this.dfA = (TextView) this.dfz.findViewById(d.g.sort_tab_menu_button);
            this.dfB = (TextView) this.dfz.findViewById(d.g.sort_tab_sort_name);
            this.ban = this.dfz.findViewById(d.g.sort_tab_divider_line);
            this.dfA.setOnClickListener(this.dfG);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dfA != null) {
            ak.h(this.dfA, d.C0126d.cp_cont_j);
            ak.j(this.dfA, d.C0126d.transparent);
            this.dfA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
        ak.h(this.dfB, d.C0126d.cp_cont_b);
        ak.j(this.dfz, d.C0126d.cp_bg_line_d);
        ak.j(this.ban, d.C0126d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.w(list)) {
            asg();
        } else if (this.cZJ != null && this.cZJ.apg() != null && this.cZJ.apg().auh()) {
            asf();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bk(arrayList)) {
                if (!this.dfF) {
                    kx(i);
                    return;
                }
                return;
            }
            this.dfC = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.dbf = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.dfC.add(vVar);
                }
            }
            if (!this.dfF) {
                kx(i);
            }
        } else {
            asg();
        }
    }

    private void kx(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.dfC.get(0);
            if (vVar3 != null) {
                kw(vVar3.dbf);
                lX(vVar3.name);
                if (this.cZJ != null && this.cZJ.apg() != null) {
                    this.cZJ.apg().kU(vVar3.dbf);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dfC.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.dfC.get(i2);
                if (vVar2 == null || vVar2.dbf != i) {
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
                lX(TbadkCoreApplication.getInst().getResources().getString(d.k.attention_users_thread));
                return;
            }
            v vVar4 = this.dfC.get(0);
            if (vVar4 != null) {
                kw(vVar4.dbf);
                lX(vVar4.name);
                if (this.cZJ != null && this.cZJ.apg() != null) {
                    this.cZJ.apg().kU(vVar4.dbf);
                }
            }
        } else if (vVar != null) {
            kw(vVar.dbf);
            lX(vVar.name);
            if (this.cZJ != null && this.cZJ.apg() != null) {
                this.cZJ.apg().kU(vVar.dbf);
            }
        }
    }

    private boolean bk(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.w(this.dfC) && com.baidu.tbadk.core.util.v.v(list) == com.baidu.tbadk.core.util.v.v(this.dfC)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dfC.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void asf() {
        if (this.dfA != null) {
            this.dfA.setVisibility(0);
        }
    }

    private void asg() {
        if (this.dfA != null) {
            this.dfA.setVisibility(8);
        }
    }

    public void resetData() {
        this.dfC = null;
    }
}

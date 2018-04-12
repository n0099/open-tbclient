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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    private View bam;
    private FrsFragment cYF;
    private String crJ;
    private int deA = -1;
    private boolean deB = false;
    private View.OnClickListener deC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                a.this.cYF.showToast(d.k.neterror);
            } else if (!v.w(a.this.dey)) {
                if (a.this.dez == null) {
                    a.this.dez = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.cYF, a.this.deD);
                }
                a.this.dez.setData(a.this.dey);
                a.this.dez.d(a.this.cYF.getPageContext()).tG();
            }
        }
    };
    private b.InterfaceC0086b deD = new b.InterfaceC0086b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
        public void a(b bVar, int i, View view2) {
            if (!j.gD()) {
                a.this.cYF.showToast(d.k.neterror);
                bVar.dismiss();
                return;
            }
            com.baidu.tieba.frs.v vVar = (com.baidu.tieba.frs.v) v.c(a.this.dez.asi(), i);
            if (vVar != null) {
                if (a.this.deA != vVar.cZZ) {
                    a.this.deB = true;
                    a.this.lU(vVar.name);
                    if (a.this.deA == 7) {
                        al alVar = new al("c11437");
                        alVar.r("obj_locate", vVar.cZZ);
                        alVar.ac(ImageViewerConfig.FORUM_ID, a.this.crJ);
                        TiebaStatic.log(alVar);
                    }
                    if (a.this.cYF.aph() != null) {
                        a.this.cYF.aph().kX(a.this.deA);
                        a.this.deA = vVar.cZZ;
                        bVar.dismiss();
                        if (a.this.deA != 7) {
                            t.HQ();
                            f.bsW();
                        } else {
                            f.bsV();
                        }
                        if (a.this.cYF.aph() != null && a.this.cYF.apn() != null) {
                            a.this.cYF.aph().kW(vVar.cZZ);
                            a.this.cYF.apn().startPullRefresh();
                            a.this.cYF.aph().fS(true);
                            com.baidu.tieba.frs.smartsort.d.auC().i(a.this.cYF.aph().getForumName(), vVar.cZZ, vVar.name);
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
    private View dev;
    private TextView dew;
    private TextView dex;
    private List<com.baidu.tieba.frs.v> dey;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dez;
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.crJ = str;
    }

    public TextView asf() {
        return this.dew;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(String str) {
        this.dex.setText(str);
    }

    public void ky(int i) {
        this.deA = i;
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.cYF = frsFragment;
            this.mRootView = relativeLayout;
            this.dev = LayoutInflater.from(frsFragment.getContext()).inflate(d.i.frs_sort_tab_layout, relativeLayout);
            this.dew = (TextView) this.dev.findViewById(d.g.sort_tab_menu_button);
            this.dex = (TextView) this.dev.findViewById(d.g.sort_tab_sort_name);
            this.bam = this.dev.findViewById(d.g.sort_tab_divider_line);
            this.dew.setOnClickListener(this.deC);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dew != null) {
            ak.h(this.dew, d.C0126d.cp_cont_j);
            ak.j(this.dew, d.C0126d.transparent);
            this.dew.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
        ak.h(this.dex, d.C0126d.cp_cont_b);
        ak.j(this.dev, d.C0126d.cp_bg_line_d);
        ak.j(this.bam, d.C0126d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.w(list)) {
            ash();
        } else if (this.cYF != null && this.cYF.aph() != null && this.cYF.aph().aui()) {
            asg();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bh(arrayList)) {
                if (!this.deB) {
                    kz(i);
                    return;
                }
                return;
            }
            this.dey = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    com.baidu.tieba.frs.v vVar = new com.baidu.tieba.frs.v();
                    vVar.cZZ = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.dey.add(vVar);
                }
            }
            if (!this.deB) {
                kz(i);
            }
        } else {
            ash();
        }
    }

    private void kz(int i) {
        com.baidu.tieba.frs.v vVar;
        boolean z;
        com.baidu.tieba.frs.v vVar2 = null;
        if (i <= 0) {
            com.baidu.tieba.frs.v vVar3 = this.dey.get(0);
            if (vVar3 != null) {
                ky(vVar3.cZZ);
                lU(vVar3.name);
                if (this.cYF != null && this.cYF.aph() != null) {
                    this.cYF.aph().kW(vVar3.cZZ);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dey.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.dey.get(i2);
                if (vVar2 == null || vVar2.cZZ != i) {
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
                lU(TbadkCoreApplication.getInst().getResources().getString(d.k.attention_users_thread));
                return;
            }
            com.baidu.tieba.frs.v vVar4 = this.dey.get(0);
            if (vVar4 != null) {
                ky(vVar4.cZZ);
                lU(vVar4.name);
                if (this.cYF != null && this.cYF.aph() != null) {
                    this.cYF.aph().kW(vVar4.cZZ);
                }
            }
        } else if (vVar != null) {
            ky(vVar.cZZ);
            lU(vVar.name);
            if (this.cYF != null && this.cYF.aph() != null) {
                this.cYF.aph().kW(vVar.cZZ);
            }
        }
    }

    private boolean bh(List<FrsTabInfo> list) {
        if (!v.w(this.dey) && v.v(list) == v.v(this.dey)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dey.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void asg() {
        if (this.dew != null) {
            this.dew.setVisibility(0);
        }
    }

    private void ash() {
        if (this.dew != null) {
            this.dew.setVisibility(8);
        }
    }

    public void resetData() {
        this.dey = null;
    }
}

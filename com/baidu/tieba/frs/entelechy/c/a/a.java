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
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    private View bam;
    private FrsFragment cYC;
    private String crG;
    private View der;
    private TextView det;
    private TextView deu;
    private List<v> dev;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dew;
    private ViewGroup mRootView;
    private int dex = -1;
    private boolean dey = false;
    private View.OnClickListener dez = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                a.this.cYC.showToast(d.k.neterror);
            } else if (!com.baidu.tbadk.core.util.v.w(a.this.dev)) {
                if (a.this.dew == null) {
                    a.this.dew = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.cYC, a.this.deA);
                }
                a.this.dew.setData(a.this.dev);
                a.this.dew.d(a.this.cYC.getPageContext()).tG();
            }
        }
    };
    private b.InterfaceC0086b deA = new b.InterfaceC0086b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
        public void a(b bVar, int i, View view2) {
            if (!j.gD()) {
                a.this.cYC.showToast(d.k.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) com.baidu.tbadk.core.util.v.c(a.this.dew.asi(), i);
            if (vVar != null) {
                if (a.this.dex != vVar.cZW) {
                    a.this.dey = true;
                    a.this.lU(vVar.name);
                    if (a.this.dex == 7) {
                        al alVar = new al("c11437");
                        alVar.r("obj_locate", vVar.cZW);
                        alVar.ac(ImageViewerConfig.FORUM_ID, a.this.crG);
                        TiebaStatic.log(alVar);
                    }
                    if (a.this.cYC.aph() != null) {
                        a.this.cYC.aph().kW(a.this.dex);
                        a.this.dex = vVar.cZW;
                        bVar.dismiss();
                        if (a.this.dex != 7) {
                            t.HQ();
                            f.bsW();
                        } else {
                            f.bsV();
                        }
                        if (a.this.cYC.aph() != null && a.this.cYC.apn() != null) {
                            a.this.cYC.aph().kV(vVar.cZW);
                            a.this.cYC.apn().startPullRefresh();
                            a.this.cYC.aph().fS(true);
                            com.baidu.tieba.frs.smartsort.d.auC().i(a.this.cYC.aph().getForumName(), vVar.cZW, vVar.name);
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
        this.crG = str;
    }

    public TextView asf() {
        return this.det;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(String str) {
        this.deu.setText(str);
    }

    public void kx(int i) {
        this.dex = i;
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.cYC = frsFragment;
            this.mRootView = relativeLayout;
            this.der = LayoutInflater.from(frsFragment.getContext()).inflate(d.i.frs_sort_tab_layout, relativeLayout);
            this.det = (TextView) this.der.findViewById(d.g.sort_tab_menu_button);
            this.deu = (TextView) this.der.findViewById(d.g.sort_tab_sort_name);
            this.bam = this.der.findViewById(d.g.sort_tab_divider_line);
            this.det.setOnClickListener(this.dez);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.det != null) {
            ak.h(this.det, d.C0126d.cp_cont_j);
            ak.j(this.det, d.C0126d.transparent);
            this.det.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
        ak.h(this.deu, d.C0126d.cp_cont_b);
        ak.j(this.der, d.C0126d.cp_bg_line_d);
        ak.j(this.bam, d.C0126d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.w(list)) {
            ash();
        } else if (this.cYC != null && this.cYC.aph() != null && this.cYC.aph().aui()) {
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
                if (!this.dey) {
                    ky(i);
                    return;
                }
                return;
            }
            this.dev = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.cZW = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.dev.add(vVar);
                }
            }
            if (!this.dey) {
                ky(i);
            }
        } else {
            ash();
        }
    }

    private void ky(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.dev.get(0);
            if (vVar3 != null) {
                kx(vVar3.cZW);
                lU(vVar3.name);
                if (this.cYC != null && this.cYC.aph() != null) {
                    this.cYC.aph().kV(vVar3.cZW);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dev.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.dev.get(i2);
                if (vVar2 == null || vVar2.cZW != i) {
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
            v vVar4 = this.dev.get(0);
            if (vVar4 != null) {
                kx(vVar4.cZW);
                lU(vVar4.name);
                if (this.cYC != null && this.cYC.aph() != null) {
                    this.cYC.aph().kV(vVar4.cZW);
                }
            }
        } else if (vVar != null) {
            kx(vVar.cZW);
            lU(vVar.name);
            if (this.cYC != null && this.cYC.aph() != null) {
                this.cYC.aph().kV(vVar.cZW);
            }
        }
    }

    private boolean bh(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.w(this.dev) && com.baidu.tbadk.core.util.v.v(list) == com.baidu.tbadk.core.util.v.v(this.dev)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dev.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void asg() {
        if (this.det != null) {
            this.det.setVisibility(0);
        }
    }

    private void ash() {
        if (this.det != null) {
            this.det.setVisibility(8);
        }
    }

    public void resetData() {
        this.dev = null;
    }
}

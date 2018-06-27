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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    private View bjZ;
    private String czo;
    private FrsFragment dla;
    private View drX;
    private TextView drY;
    private TextView drZ;
    private List<x> dsa;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dsb;
    private int dsc = -1;
    private boolean dsd = false;
    private View.OnClickListener dse = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.asZ().ata()) {
                if (!j.jr()) {
                    a.this.dla.showToast(d.k.neterror);
                } else if (!w.A(a.this.dsa)) {
                    if (a.this.dsb == null) {
                        a.this.dsb = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dla, a.this.dsf);
                    }
                    a.this.dsb.setData(a.this.dsa);
                    a.this.dsb.d(a.this.dla.getPageContext()).xq();
                }
            }
        }
    };
    private b.InterfaceC0104b dsf = new b.InterfaceC0104b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
        public void a(b bVar, int i, View view) {
            if (!j.jr()) {
                a.this.dla.showToast(d.k.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) w.d(a.this.dsb.awQ(), i);
            if (xVar != null) {
                if (a.this.dsc != xVar.dmC) {
                    a.this.dsd = true;
                    a.this.mE(xVar.name);
                    if (a.this.dsc == 7) {
                        an anVar = new an("c11437");
                        anVar.r("obj_locate", xVar.dmC);
                        anVar.ah(ImageViewerConfig.FORUM_ID, a.this.czo);
                        TiebaStatic.log(anVar);
                    }
                    if (a.this.dla.atD() != null) {
                        a.this.dla.atD().lj(a.this.dsc);
                        a.this.dsc = xVar.dmC;
                        bVar.dismiss();
                        if (a.this.dsc != 7) {
                            u.LC();
                            e.byD();
                        } else {
                            e.byC();
                        }
                        if (a.this.dla.atD() != null && a.this.dla.atI() != null) {
                            a.this.dla.atD().li(xVar.dmC);
                            a.this.dla.atI().startPullRefresh();
                            a.this.dla.atD().gj(true);
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
        this.czo = str;
    }

    public TextView awN() {
        return this.drY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(String str) {
        this.drZ.setText(str);
    }

    public void kI(int i) {
        this.dsc = i;
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.dla = frsFragment;
            this.mRootView = relativeLayout;
            this.drX = LayoutInflater.from(frsFragment.getContext()).inflate(d.i.frs_sort_tab_layout, relativeLayout);
            this.drY = (TextView) this.drX.findViewById(d.g.sort_tab_menu_button);
            this.drZ = (TextView) this.drX.findViewById(d.g.sort_tab_sort_name);
            this.bjZ = this.drX.findViewById(d.g.sort_tab_divider_line);
            this.drY.setOnClickListener(this.dse);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.drY != null) {
            am.h(this.drY, d.C0142d.cp_cont_j);
            am.j(this.drY, d.C0142d.transparent);
            this.drY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
        am.h(this.drZ, d.C0142d.cp_cont_b);
        am.j(this.drX, d.C0142d.cp_bg_line_d);
        am.j(this.bjZ, d.C0142d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (w.A(list)) {
            awP();
        } else if (this.dla != null && this.dla.atD() != null && this.dla.atD().aza()) {
            awO();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bq(arrayList)) {
                if (!this.dsd) {
                    kJ(i);
                    return;
                }
                return;
            }
            this.dsa = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.dmC = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.dsa.add(xVar);
                }
            }
            if (!this.dsd) {
                kJ(i);
            }
        } else {
            awP();
        }
    }

    private void kJ(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.dsa.get(0);
            if (xVar3 != null) {
                kI(xVar3.dmC);
                mE(xVar3.name);
                if (this.dla != null && this.dla.atD() != null) {
                    this.dla.atD().li(xVar3.dmC);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dsa.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.dsa.get(i2);
                if (xVar2 == null || xVar2.dmC != i) {
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
                mE(TbadkCoreApplication.getInst().getResources().getString(d.k.attention_users_thread));
                return;
            }
            x xVar4 = this.dsa.get(0);
            if (xVar4 != null) {
                kI(xVar4.dmC);
                mE(xVar4.name);
                if (this.dla != null && this.dla.atD() != null) {
                    this.dla.atD().li(xVar4.dmC);
                }
            }
        } else if (xVar != null) {
            kI(xVar.dmC);
            mE(xVar.name);
            if (this.dla != null && this.dla.atD() != null) {
                this.dla.atD().li(xVar.dmC);
            }
        }
    }

    private boolean bq(List<FrsTabInfo> list) {
        if (!w.A(this.dsa) && w.z(list) == w.z(this.dsa)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dsa.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void awO() {
        if (this.drY != null) {
            this.drY.setVisibility(0);
        }
    }

    private void awP() {
        if (this.drY != null) {
            this.drY.setVisibility(8);
        }
    }

    public void resetData() {
        this.dsa = null;
    }
}

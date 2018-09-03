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
import com.baidu.tbadk.util.t;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    private View bkJ;
    private String cBR;
    private FrsFragment dnP;
    private View duH;
    private TextView duI;
    private TextView duJ;
    private List<x> duK;
    private com.baidu.tieba.frs.entelechy.c.a.a.a duL;
    private int duM = -1;
    private boolean duN = false;
    private View.OnClickListener duO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.atC().atD()) {
                if (!j.js()) {
                    a.this.dnP.showToast(f.j.neterror);
                } else if (!w.z(a.this.duK)) {
                    if (a.this.duL == null) {
                        a.this.duL = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dnP, a.this.duP);
                    }
                    a.this.duL.setData(a.this.duK);
                    a.this.duL.d(a.this.dnP.getPageContext()).xh();
                }
            }
        }
    };
    private b.InterfaceC0101b duP = new b.InterfaceC0101b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
        public void a(b bVar, int i, View view) {
            if (!j.js()) {
                a.this.dnP.showToast(f.j.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) w.d(a.this.duL.axu(), i);
            if (xVar != null) {
                if (a.this.duM != xVar.dps) {
                    a.this.duN = true;
                    a.this.mF(xVar.name);
                    if (a.this.duM == 7) {
                        an anVar = new an("c11437");
                        anVar.r("obj_locate", xVar.dps);
                        anVar.ae(ImageViewerConfig.FORUM_ID, a.this.cBR);
                        TiebaStatic.log(anVar);
                    }
                    if (a.this.dnP.aug() != null) {
                        a.this.dnP.aug().lu(a.this.duM);
                        a.this.duM = xVar.dps;
                        bVar.dismiss();
                        if (a.this.duM != 7) {
                            t.LB();
                            e.bxh();
                        } else {
                            e.bxg();
                        }
                        if (a.this.dnP.aug() != null && a.this.dnP.aul() != null) {
                            a.this.dnP.aug().lt(xVar.dps);
                            a.this.dnP.aul().startPullRefresh();
                            a.this.dnP.aug().gl(true);
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
        this.cBR = str;
    }

    public TextView axr() {
        return this.duI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(String str) {
        this.duJ.setText(str);
    }

    public void kS(int i) {
        this.duM = i;
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.dnP = frsFragment;
            this.mRootView = relativeLayout;
            this.duH = LayoutInflater.from(frsFragment.getContext()).inflate(f.h.frs_sort_tab_layout, relativeLayout);
            this.duI = (TextView) this.duH.findViewById(f.g.sort_tab_menu_button);
            this.duJ = (TextView) this.duH.findViewById(f.g.sort_tab_sort_name);
            this.bkJ = this.duH.findViewById(f.g.sort_tab_divider_line);
            this.duI.setOnClickListener(this.duO);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.duI != null) {
            am.h(this.duI, f.d.cp_cont_j);
            am.j(this.duI, f.d.transparent);
            this.duI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_arrow_gray_down), (Drawable) null);
        }
        am.h(this.duJ, f.d.cp_cont_b);
        am.j(this.duH, f.d.cp_bg_line_d);
        am.j(this.bkJ, f.d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (w.z(list)) {
            axt();
        } else if (this.dnP != null && this.dnP.aug() != null && this.dnP.aug().azD()) {
            axs();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bp(arrayList)) {
                if (!this.duN) {
                    kT(i);
                    return;
                }
                return;
            }
            this.duK = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.dps = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.duK.add(xVar);
                }
            }
            if (!this.duN) {
                kT(i);
            }
        } else {
            axt();
        }
    }

    private void kT(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.duK.get(0);
            if (xVar3 != null) {
                kS(xVar3.dps);
                mF(xVar3.name);
                if (this.dnP != null && this.dnP.aug() != null) {
                    this.dnP.aug().lt(xVar3.dps);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.duK.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.duK.get(i2);
                if (xVar2 == null || xVar2.dps != i) {
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
                mF(TbadkCoreApplication.getInst().getResources().getString(f.j.attention_users_thread));
                return;
            }
            x xVar4 = this.duK.get(0);
            if (xVar4 != null) {
                kS(xVar4.dps);
                mF(xVar4.name);
                if (this.dnP != null && this.dnP.aug() != null) {
                    this.dnP.aug().lt(xVar4.dps);
                }
            }
        } else if (xVar != null) {
            kS(xVar.dps);
            mF(xVar.name);
            if (this.dnP != null && this.dnP.aug() != null) {
                this.dnP.aug().lt(xVar.dps);
            }
        }
    }

    private boolean bp(List<FrsTabInfo> list) {
        if (!w.z(this.duK) && w.y(list) == w.y(this.duK)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.duK.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void axs() {
        if (this.duI != null) {
            this.duI.setVisibility(0);
        }
    }

    private void axt() {
        if (this.duI != null) {
            this.duI.setVisibility(8);
        }
    }

    public void resetData() {
        this.duK = null;
    }
}

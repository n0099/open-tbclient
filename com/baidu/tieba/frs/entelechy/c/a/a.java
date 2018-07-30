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
    private View bkE;
    private String cBU;
    private FrsFragment dnR;
    private View duK;
    private TextView duL;
    private TextView duM;
    private List<x> duN;
    private com.baidu.tieba.frs.entelechy.c.a.a.a duO;
    private int duP = -1;
    private boolean duQ = false;
    private View.OnClickListener duR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.atD().atE()) {
                if (!j.js()) {
                    a.this.dnR.showToast(d.j.neterror);
                } else if (!w.z(a.this.duN)) {
                    if (a.this.duO == null) {
                        a.this.duO = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dnR, a.this.duS);
                    }
                    a.this.duO.setData(a.this.duN);
                    a.this.duO.d(a.this.dnR.getPageContext()).xi();
                }
            }
        }
    };
    private b.InterfaceC0101b duS = new b.InterfaceC0101b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
        public void a(b bVar, int i, View view) {
            if (!j.js()) {
                a.this.dnR.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) w.d(a.this.duO.axv(), i);
            if (xVar != null) {
                if (a.this.duP != xVar.dpu) {
                    a.this.duQ = true;
                    a.this.mD(xVar.name);
                    if (a.this.duP == 7) {
                        an anVar = new an("c11437");
                        anVar.r("obj_locate", xVar.dpu);
                        anVar.af(ImageViewerConfig.FORUM_ID, a.this.cBU);
                        TiebaStatic.log(anVar);
                    }
                    if (a.this.dnR.auh() != null) {
                        a.this.dnR.auh().lu(a.this.duP);
                        a.this.duP = xVar.dpu;
                        bVar.dismiss();
                        if (a.this.duP != 7) {
                            t.Lx();
                            e.bxg();
                        } else {
                            e.bxf();
                        }
                        if (a.this.dnR.auh() != null && a.this.dnR.aum() != null) {
                            a.this.dnR.auh().lt(xVar.dpu);
                            a.this.dnR.aum().startPullRefresh();
                            a.this.dnR.auh().gl(true);
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
        this.cBU = str;
    }

    public TextView axs() {
        return this.duL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(String str) {
        this.duM.setText(str);
    }

    public void kT(int i) {
        this.duP = i;
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.dnR = frsFragment;
            this.mRootView = relativeLayout;
            this.duK = LayoutInflater.from(frsFragment.getContext()).inflate(d.h.frs_sort_tab_layout, relativeLayout);
            this.duL = (TextView) this.duK.findViewById(d.g.sort_tab_menu_button);
            this.duM = (TextView) this.duK.findViewById(d.g.sort_tab_sort_name);
            this.bkE = this.duK.findViewById(d.g.sort_tab_divider_line);
            this.duL.setOnClickListener(this.duR);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.duL != null) {
            am.h(this.duL, d.C0140d.cp_cont_j);
            am.j(this.duL, d.C0140d.transparent);
            this.duL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
        am.h(this.duM, d.C0140d.cp_cont_b);
        am.j(this.duK, d.C0140d.cp_bg_line_d);
        am.j(this.bkE, d.C0140d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (w.z(list)) {
            axu();
        } else if (this.dnR != null && this.dnR.auh() != null && this.dnR.auh().azG()) {
            axt();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bp(arrayList)) {
                if (!this.duQ) {
                    kU(i);
                    return;
                }
                return;
            }
            this.duN = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.dpu = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.duN.add(xVar);
                }
            }
            if (!this.duQ) {
                kU(i);
            }
        } else {
            axu();
        }
    }

    private void kU(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.duN.get(0);
            if (xVar3 != null) {
                kT(xVar3.dpu);
                mD(xVar3.name);
                if (this.dnR != null && this.dnR.auh() != null) {
                    this.dnR.auh().lt(xVar3.dpu);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.duN.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.duN.get(i2);
                if (xVar2 == null || xVar2.dpu != i) {
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
                mD(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            x xVar4 = this.duN.get(0);
            if (xVar4 != null) {
                kT(xVar4.dpu);
                mD(xVar4.name);
                if (this.dnR != null && this.dnR.auh() != null) {
                    this.dnR.auh().lt(xVar4.dpu);
                }
            }
        } else if (xVar != null) {
            kT(xVar.dpu);
            mD(xVar.name);
            if (this.dnR != null && this.dnR.auh() != null) {
                this.dnR.auh().lt(xVar.dpu);
            }
        }
    }

    private boolean bp(List<FrsTabInfo> list) {
        if (!w.z(this.duN) && w.y(list) == w.y(this.duN)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.duN.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void axt() {
        if (this.duL != null) {
            this.duL.setVisibility(0);
        }
    }

    private void axu() {
        if (this.duL != null) {
            this.duL.setVisibility(8);
        }
    }

    public void resetData() {
        this.duN = null;
    }
}

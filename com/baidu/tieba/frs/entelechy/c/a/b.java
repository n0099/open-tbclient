package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.c.a.c;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes7.dex */
public class b {
    private String fKa;
    private TextView fRd;
    private FrsFragment gnW;
    private View gvM;
    private TextView gvO;
    private c gvP;
    private List<w> gvQ;
    private com.baidu.tieba.frs.entelechy.c.a.a.a gvX;
    private ViewGroup mRootView;
    private int gvR = -1;
    private boolean gvS = false;
    private boolean gvT = false;
    private c.a gvU = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(w wVar) {
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.gnW.showToast(R.string.neterror);
                b.this.gvP.dismiss();
                b.this.gvT = false;
            } else if (wVar == null) {
                b.this.gvP.dismiss();
                b.this.gvT = false;
            } else if (b.this.gvR == wVar.gpO) {
                b.this.gvP.dismiss();
                b.this.gvT = false;
            } else {
                b.this.gvS = true;
                b.this.AW(wVar.name);
                if (b.this.gnW.bCf() != null) {
                    b.this.gnW.bCf().tI(b.this.gvR);
                    b.this.gvR = wVar.gpO;
                    b.this.gvP.dismiss();
                    b.this.gvT = false;
                    if (b.this.gvR != 7) {
                        aa.aPY();
                        e.cKz();
                    } else {
                        e.cKy();
                    }
                    if (b.this.gnW.bCf() != null && b.this.gnW.bCk() != null) {
                        b.this.gnW.bCf().tH(wVar.gpO);
                        b.this.gnW.bCk().startPullRefresh();
                        b.this.gnW.bCf().lW(true);
                        b.this.bFK();
                    }
                }
            }
        }
    };
    private View.OnClickListener gvV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bBr().bBs()) {
                if (!j.isNetworkAvailableForImmediately()) {
                    b.this.gnW.showToast(R.string.neterror);
                } else if (!v.isEmpty(b.this.gvQ)) {
                    b.this.a(b.this.gvQ, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.fRd != null) {
                Drawable a = SvgManager.aEp().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                b.this.fRd.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private b.a gvY = new b.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.gnW.showToast(R.string.neterror);
                bVar.dismiss();
                return;
            }
            w wVar = (w) v.getItem(b.this.gvX.bFP(), i);
            if (wVar != null) {
                if (b.this.gvR != wVar.gpO) {
                    b.this.gvS = true;
                    b.this.AW(wVar.name);
                    if (b.this.gnW.bCf() != null) {
                        b.this.gnW.bCf().tI(b.this.gvR);
                        b.this.gvR = wVar.gpO;
                        bVar.dismiss();
                        if (b.this.gvR != 7) {
                            aa.aPY();
                            e.cKz();
                        } else {
                            e.cKy();
                        }
                        if (b.this.gnW.bCf() != null && b.this.gnW.bCk() != null) {
                            b.this.gnW.bCf().tH(wVar.gpO);
                            b.this.gnW.bCk().startPullRefresh();
                            b.this.gnW.bCf().lW(true);
                            b.this.bFK();
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
        this.fKa = str;
    }

    public TextView bFN() {
        return this.fRd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AW(String str) {
        this.fRd.setText(str);
    }

    public void tg(int i) {
        this.gvR = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<w> list, View view) {
        if (this.gvP == null) {
            this.gvP = new c(this.gnW.getContext());
            this.gvP.setOnDismissListener(this.mOnDismissListener);
            this.gvP.a(this.gvU);
        }
        this.gvP.setData(list, this.gvR);
        this.gvP.R(view);
        this.gvT = true;
        this.fRd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFK() {
        an anVar = new an("c11437");
        anVar.Z("obj_type", this.gvR);
        anVar.cp("fid", this.fKa);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.gnW = frsFragment;
            this.mRootView = relativeLayout;
            this.gvM = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.fRd = (TextView) this.gvM.findViewById(R.id.sort_tab_menu_button);
            this.gvO = (TextView) this.gvM.findViewById(R.id.sort_tab_sort_name);
            this.fRd.setOnClickListener(this.gvV);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Drawable a;
        if (this.fRd != null) {
            am.setViewTextColor(this.fRd, (int) R.color.cp_cont_j);
            am.setBackgroundColor(this.fRd, R.color.transparent);
            if (this.gvT) {
                a = SvgManager.aEp().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            } else {
                a = SvgManager.aEp().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.fRd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a, (Drawable) null);
        }
        am.setViewTextColor(this.gvO, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.gvM, R.color.cp_bg_line_d);
        if (this.gvP != null && this.gvT) {
            this.gvP.bFO();
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.isEmpty(list)) {
            bFM();
        } else if (this.gnW != null && this.gnW.bCf() != null && this.gnW.bCf().bHH()) {
            bFL();
            ArrayList arrayList = new ArrayList(list);
            if (!ck(arrayList)) {
                if (!this.gvS) {
                    th(i);
                    return;
                }
                return;
            }
            this.gvQ = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    w wVar = new w();
                    wVar.gpO = frsTabInfo.tab_id.intValue();
                    wVar.name = frsTabInfo.tab_name;
                    this.gvQ.add(wVar);
                }
            }
            if (!this.gvS) {
                th(i);
            }
        } else {
            bFM();
        }
    }

    private void th(int i) {
        w wVar;
        boolean z;
        w wVar2 = null;
        if (i <= 0) {
            w wVar3 = this.gvQ.get(0);
            if (wVar3 != null) {
                tg(wVar3.gpO);
                AW(wVar3.name);
                if (this.gnW != null && this.gnW.bCf() != null) {
                    this.gnW.bCf().tH(wVar3.gpO);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.gvQ.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                wVar2 = this.gvQ.get(i2);
                if (wVar2 == null || wVar2.gpO != i) {
                    i2++;
                } else {
                    wVar = wVar2;
                    z = true;
                    break;
                }
            } else {
                wVar = wVar2;
                z = false;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                AW(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            w wVar4 = this.gvQ.get(0);
            if (wVar4 != null) {
                tg(wVar4.gpO);
                AW(wVar4.name);
                if (this.gnW != null && this.gnW.bCf() != null) {
                    this.gnW.bCf().tH(wVar4.gpO);
                }
            }
        } else if (wVar != null) {
            tg(wVar.gpO);
            AW(wVar.name);
            if (this.gnW != null && this.gnW.bCf() != null) {
                this.gnW.bCf().tH(wVar.gpO);
            }
        }
    }

    private boolean ck(List<FrsTabInfo> list) {
        if (!v.isEmpty(this.gvQ) && v.getCount(list) == v.getCount(this.gvQ)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.gvQ.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bFL() {
        if (this.fRd != null) {
            this.fRd.setVisibility(0);
        }
    }

    private void bFM() {
        if (this.fRd != null) {
            this.fRd.setVisibility(8);
        }
    }
}

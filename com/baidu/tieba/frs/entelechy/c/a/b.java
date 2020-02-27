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
/* loaded from: classes9.dex */
public class b {
    private String ema;
    private TextView fTy;
    private FrsFragment gpX;
    private View gxN;
    private TextView gxP;
    private c gxQ;
    private List<w> gxR;
    private com.baidu.tieba.frs.entelechy.c.a.a.a gxY;
    private ViewGroup mRootView;
    private int gxS = -1;
    private boolean gxT = false;
    private boolean gxU = false;
    private c.a gxV = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(w wVar) {
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.gpX.showToast(R.string.neterror);
                b.this.gxQ.dismiss();
                b.this.gxU = false;
            } else if (wVar == null) {
                b.this.gxQ.dismiss();
                b.this.gxU = false;
            } else if (b.this.gxS == wVar.grP) {
                b.this.gxQ.dismiss();
                b.this.gxU = false;
            } else {
                b.this.gxT = true;
                b.this.Bm(wVar.name);
                if (b.this.gpX.bDI() != null) {
                    b.this.gpX.bDI().tO(b.this.gxS);
                    b.this.gxS = wVar.grP;
                    b.this.gxQ.dismiss();
                    b.this.gxU = false;
                    if (b.this.gxS != 7) {
                        aa.aSp();
                        e.cLZ();
                    } else {
                        e.cLY();
                    }
                    if (b.this.gpX.bDI() != null && b.this.gpX.bDN() != null) {
                        b.this.gpX.bDI().tN(wVar.grP);
                        b.this.gpX.bDN().startPullRefresh();
                        b.this.gpX.bDI().lY(true);
                        b.this.bHm();
                    }
                }
            }
        }
    };
    private View.OnClickListener gxW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bCT().bCU()) {
                if (!j.isNetworkAvailableForImmediately()) {
                    b.this.gpX.showToast(R.string.neterror);
                } else if (!v.isEmpty(b.this.gxR)) {
                    b.this.a(b.this.gxR, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.fTy != null) {
                Drawable a = SvgManager.aGA().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                b.this.fTy.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private b.a gxZ = new b.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.gpX.showToast(R.string.neterror);
                bVar.dismiss();
                return;
            }
            w wVar = (w) v.getItem(b.this.gxY.bHr(), i);
            if (wVar != null) {
                if (b.this.gxS != wVar.grP) {
                    b.this.gxT = true;
                    b.this.Bm(wVar.name);
                    if (b.this.gpX.bDI() != null) {
                        b.this.gpX.bDI().tO(b.this.gxS);
                        b.this.gxS = wVar.grP;
                        bVar.dismiss();
                        if (b.this.gxS != 7) {
                            aa.aSp();
                            e.cLZ();
                        } else {
                            e.cLY();
                        }
                        if (b.this.gpX.bDI() != null && b.this.gpX.bDN() != null) {
                            b.this.gpX.bDI().tN(wVar.grP);
                            b.this.gpX.bDN().startPullRefresh();
                            b.this.gpX.bDI().lY(true);
                            b.this.bHm();
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
        this.ema = str;
    }

    public TextView bHp() {
        return this.fTy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm(String str) {
        this.fTy.setText(str);
    }

    public void tm(int i) {
        this.gxS = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<w> list, View view) {
        if (this.gxQ == null) {
            this.gxQ = new c(this.gpX.getContext());
            this.gxQ.setOnDismissListener(this.mOnDismissListener);
            this.gxQ.a(this.gxV);
        }
        this.gxQ.setData(list, this.gxS);
        this.gxQ.R(view);
        this.gxU = true;
        this.fTy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHm() {
        an anVar = new an("c11437");
        anVar.X("obj_type", this.gxS);
        anVar.cy("fid", this.ema);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.gpX = frsFragment;
            this.mRootView = relativeLayout;
            this.gxN = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.fTy = (TextView) this.gxN.findViewById(R.id.sort_tab_menu_button);
            this.gxP = (TextView) this.gxN.findViewById(R.id.sort_tab_sort_name);
            this.fTy.setOnClickListener(this.gxW);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Drawable a;
        if (this.fTy != null) {
            am.setViewTextColor(this.fTy, (int) R.color.cp_cont_j);
            am.setBackgroundColor(this.fTy, R.color.transparent);
            if (this.gxU) {
                a = SvgManager.aGA().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            } else {
                a = SvgManager.aGA().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.fTy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a, (Drawable) null);
        }
        am.setViewTextColor(this.gxP, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.gxN, R.color.cp_bg_line_d);
        if (this.gxQ != null && this.gxU) {
            this.gxQ.bHq();
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.isEmpty(list)) {
            bHo();
        } else if (this.gpX != null && this.gpX.bDI() != null && this.gpX.bDI().bJj()) {
            bHn();
            ArrayList arrayList = new ArrayList(list);
            if (!cg(arrayList)) {
                if (!this.gxT) {
                    tn(i);
                    return;
                }
                return;
            }
            this.gxR = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    w wVar = new w();
                    wVar.grP = frsTabInfo.tab_id.intValue();
                    wVar.name = frsTabInfo.tab_name;
                    this.gxR.add(wVar);
                }
            }
            if (!this.gxT) {
                tn(i);
            }
        } else {
            bHo();
        }
    }

    private void tn(int i) {
        w wVar;
        boolean z;
        w wVar2 = null;
        if (i <= 0) {
            w wVar3 = this.gxR.get(0);
            if (wVar3 != null) {
                tm(wVar3.grP);
                Bm(wVar3.name);
                if (this.gpX != null && this.gpX.bDI() != null) {
                    this.gpX.bDI().tN(wVar3.grP);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.gxR.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                wVar2 = this.gxR.get(i2);
                if (wVar2 == null || wVar2.grP != i) {
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
                Bm(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            w wVar4 = this.gxR.get(0);
            if (wVar4 != null) {
                tm(wVar4.grP);
                Bm(wVar4.name);
                if (this.gpX != null && this.gpX.bDI() != null) {
                    this.gpX.bDI().tN(wVar4.grP);
                }
            }
        } else if (wVar != null) {
            tm(wVar.grP);
            Bm(wVar.name);
            if (this.gpX != null && this.gpX.bDI() != null) {
                this.gpX.bDI().tN(wVar.grP);
            }
        }
    }

    private boolean cg(List<FrsTabInfo> list) {
        if (!v.isEmpty(this.gxR) && v.getCount(list) == v.getCount(this.gxR)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.gxR.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bHn() {
        if (this.fTy != null) {
            this.fTy.setVisibility(0);
        }
    }

    private void bHo() {
        if (this.fTy != null) {
            this.fTy.setVisibility(8);
        }
    }
}

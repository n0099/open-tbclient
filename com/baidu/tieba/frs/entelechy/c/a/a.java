package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.c.a.c;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class a {
    private String ema;
    private TextView fTy;
    private View gxN;
    private FrsNewAreaFragment gxO;
    private TextView gxP;
    private c gxQ;
    private List<w> gxR;
    private int gxS = -1;
    private boolean gxT = false;
    private boolean gxU = false;
    private c.a gxV = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(w wVar) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.gxO.showToast(R.string.neterror);
                a.this.gxQ.dismiss();
                a.this.gxU = false;
            } else if (wVar == null) {
                a.this.gxQ.dismiss();
                a.this.gxU = false;
            } else if (a.this.gxS == wVar.grP) {
                a.this.gxQ.dismiss();
                a.this.gxU = false;
            } else {
                a.this.gxT = true;
                a.this.Bm(wVar.name);
                if (a.this.gxO.bJu() != null) {
                    a.this.gxS = wVar.grP;
                    a.this.gxQ.dismiss();
                    a.this.gxU = false;
                    if (a.this.gxS != 7) {
                        aa.aSp();
                        e.cLZ();
                    } else {
                        e.cLY();
                    }
                    if (a.this.gxO.bJu() != null && a.this.gxO.bJv() != null) {
                        a.this.gxO.bJu().tN(wVar.grP);
                        a.this.gxO.bJv().startPullRefresh();
                        a.this.bHm();
                    }
                }
            }
        }
    };
    private View.OnClickListener gxW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bCT().bCU()) {
                if (!j.isNetworkAvailableForImmediately()) {
                    a.this.gxO.showToast(R.string.neterror);
                } else if (!v.isEmpty(a.this.gxR)) {
                    a.this.a(a.this.gxR, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.fTy != null) {
                Drawable a = SvgManager.aGA().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                a.this.fTy.setCompoundDrawables(null, null, a, null);
            }
        }
    };

    public void setFid(String str) {
        this.ema = str;
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
            this.gxQ = new c(this.gxO.getContext());
            this.gxQ.setOnDismissListener(this.mOnDismissListener);
            this.gxQ.a(this.gxV);
        }
        this.gxQ.setData(list, this.gxS);
        this.gxQ.R(view);
        this.gxU = true;
        this.fTy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHm() {
        an anVar = new an("c11437");
        anVar.X("obj_type", this.gxS);
        anVar.cy("fid", this.ema);
        TiebaStatic.log(anVar);
    }

    public a(FrsNewAreaFragment frsNewAreaFragment, RelativeLayout relativeLayout) {
        if (frsNewAreaFragment != null && relativeLayout != null) {
            this.gxO = frsNewAreaFragment;
            this.gxN = LayoutInflater.from(frsNewAreaFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
                a = SvgManager.aGA().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null);
            } else {
                a = SvgManager.aGA().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null);
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
        } else if (this.gxO != null && this.gxO.bJu() != null) {
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
                if (this.gxO != null && this.gxO.bJu() != null) {
                    this.gxO.bJu().tN(wVar3.grP);
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
                if (this.gxO != null && this.gxO.bJu() != null) {
                    this.gxO.bJu().tN(wVar4.grP);
                }
            }
        } else if (wVar != null) {
            tm(wVar.grP);
            Bm(wVar.name);
            if (this.gxO != null && this.gxO.bJu() != null) {
                this.gxO.bJu().tN(wVar.grP);
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

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
/* loaded from: classes6.dex */
public class b {
    private String fGQ;
    private TextView fNU;
    private FrsFragment gkN;
    private View gsD;
    private TextView gsF;
    private c gsG;
    private List<w> gsH;
    private com.baidu.tieba.frs.entelechy.c.a.a.a gsO;
    private ViewGroup mRootView;
    private int gsI = -1;
    private boolean gsJ = false;
    private boolean gsK = false;
    private c.a gsL = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(w wVar) {
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.gkN.showToast(R.string.neterror);
                b.this.gsG.dismiss();
                b.this.gsK = false;
            } else if (wVar == null) {
                b.this.gsG.dismiss();
                b.this.gsK = false;
            } else if (b.this.gsI == wVar.gmF) {
                b.this.gsG.dismiss();
                b.this.gsK = false;
            } else {
                b.this.gsJ = true;
                b.this.AM(wVar.name);
                if (b.this.gkN.bBd() != null) {
                    b.this.gkN.bBd().tD(b.this.gsI);
                    b.this.gsI = wVar.gmF;
                    b.this.gsG.dismiss();
                    b.this.gsK = false;
                    if (b.this.gsI != 7) {
                        aa.aPF();
                        e.cJv();
                    } else {
                        e.cJu();
                    }
                    if (b.this.gkN.bBd() != null && b.this.gkN.bBi() != null) {
                        b.this.gkN.bBd().tC(wVar.gmF);
                        b.this.gkN.bBi().startPullRefresh();
                        b.this.gkN.bBd().lL(true);
                        b.this.bEI();
                    }
                }
            }
        }
    };
    private View.OnClickListener gsM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bAp().bAq()) {
                if (!j.isNetworkAvailableForImmediately()) {
                    b.this.gkN.showToast(R.string.neterror);
                } else if (!v.isEmpty(b.this.gsH)) {
                    b.this.a(b.this.gsH, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.fNU != null) {
                Drawable a = SvgManager.aDW().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                b.this.fNU.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private b.a gsP = new b.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.gkN.showToast(R.string.neterror);
                bVar.dismiss();
                return;
            }
            w wVar = (w) v.getItem(b.this.gsO.bEN(), i);
            if (wVar != null) {
                if (b.this.gsI != wVar.gmF) {
                    b.this.gsJ = true;
                    b.this.AM(wVar.name);
                    if (b.this.gkN.bBd() != null) {
                        b.this.gkN.bBd().tD(b.this.gsI);
                        b.this.gsI = wVar.gmF;
                        bVar.dismiss();
                        if (b.this.gsI != 7) {
                            aa.aPF();
                            e.cJv();
                        } else {
                            e.cJu();
                        }
                        if (b.this.gkN.bBd() != null && b.this.gkN.bBi() != null) {
                            b.this.gkN.bBd().tC(wVar.gmF);
                            b.this.gkN.bBi().startPullRefresh();
                            b.this.gkN.bBd().lL(true);
                            b.this.bEI();
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
        this.fGQ = str;
    }

    public TextView bEL() {
        return this.fNU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM(String str) {
        this.fNU.setText(str);
    }

    public void tb(int i) {
        this.gsI = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<w> list, View view) {
        if (this.gsG == null) {
            this.gsG = new c(this.gkN.getContext());
            this.gsG.setOnDismissListener(this.mOnDismissListener);
            this.gsG.a(this.gsL);
        }
        this.gsG.setData(list, this.gsI);
        this.gsG.P(view);
        this.gsK = true;
        this.fNU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aDW().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEI() {
        an anVar = new an("c11437");
        anVar.Z("obj_type", this.gsI);
        anVar.cp("fid", this.fGQ);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.gkN = frsFragment;
            this.mRootView = relativeLayout;
            this.gsD = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.fNU = (TextView) this.gsD.findViewById(R.id.sort_tab_menu_button);
            this.gsF = (TextView) this.gsD.findViewById(R.id.sort_tab_sort_name);
            this.fNU.setOnClickListener(this.gsM);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Drawable a;
        if (this.fNU != null) {
            am.setViewTextColor(this.fNU, (int) R.color.cp_cont_j);
            am.setBackgroundColor(this.fNU, R.color.transparent);
            if (this.gsK) {
                a = SvgManager.aDW().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            } else {
                a = SvgManager.aDW().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.fNU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a, (Drawable) null);
        }
        am.setViewTextColor(this.gsF, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.gsD, R.color.cp_bg_line_d);
        if (this.gsG != null && this.gsK) {
            this.gsG.bEM();
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.isEmpty(list)) {
            bEK();
        } else if (this.gkN != null && this.gkN.bBd() != null && this.gkN.bBd().bGF()) {
            bEJ();
            ArrayList arrayList = new ArrayList(list);
            if (!ck(arrayList)) {
                if (!this.gsJ) {
                    tc(i);
                    return;
                }
                return;
            }
            this.gsH = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    w wVar = new w();
                    wVar.gmF = frsTabInfo.tab_id.intValue();
                    wVar.name = frsTabInfo.tab_name;
                    this.gsH.add(wVar);
                }
            }
            if (!this.gsJ) {
                tc(i);
            }
        } else {
            bEK();
        }
    }

    private void tc(int i) {
        w wVar;
        boolean z;
        w wVar2 = null;
        if (i <= 0) {
            w wVar3 = this.gsH.get(0);
            if (wVar3 != null) {
                tb(wVar3.gmF);
                AM(wVar3.name);
                if (this.gkN != null && this.gkN.bBd() != null) {
                    this.gkN.bBd().tC(wVar3.gmF);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.gsH.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                wVar2 = this.gsH.get(i2);
                if (wVar2 == null || wVar2.gmF != i) {
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
                AM(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            w wVar4 = this.gsH.get(0);
            if (wVar4 != null) {
                tb(wVar4.gmF);
                AM(wVar4.name);
                if (this.gkN != null && this.gkN.bBd() != null) {
                    this.gkN.bBd().tC(wVar4.gmF);
                }
            }
        } else if (wVar != null) {
            tb(wVar.gmF);
            AM(wVar.name);
            if (this.gkN != null && this.gkN.bBd() != null) {
                this.gkN.bBd().tC(wVar.gmF);
            }
        }
    }

    private boolean ck(List<FrsTabInfo> list) {
        if (!v.isEmpty(this.gsH) && v.getCount(list) == v.getCount(this.gsH)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.gsH.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bEJ() {
        if (this.fNU != null) {
            this.fNU.setVisibility(0);
        }
    }

    private void bEK() {
        if (this.fNU != null) {
            this.fNU.setVisibility(8);
        }
    }
}

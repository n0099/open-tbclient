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
import com.baidu.tbadk.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.c.a.c;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b {
    private String eHo;
    private TextView eXr;
    private View fFK;
    private TextView fFM;
    private c fFN;
    private List<v> fFO;
    private com.baidu.tieba.frs.entelechy.c.a.a.a fFV;
    private FrsFragment fxT;
    private ViewGroup mRootView;
    private int fFP = -1;
    private boolean fFQ = false;
    private boolean fFR = false;
    private c.a fFS = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.jQ()) {
                b.this.fxT.showToast(R.string.neterror);
                b.this.fFN.dismiss();
                b.this.fFR = false;
            } else if (vVar == null) {
                b.this.fFN.dismiss();
                b.this.fFR = false;
            } else if (b.this.fFP == vVar.fzK) {
                b.this.fFN.dismiss();
                b.this.fFR = false;
            } else {
                b.this.fFQ = true;
                b.this.xF(vVar.name);
                if (b.this.fxT.bmE() != null) {
                    b.this.fxT.bmE().sF(b.this.fFP);
                    b.this.fFP = vVar.fzK;
                    b.this.fFN.dismiss();
                    b.this.fFR = false;
                    if (b.this.fFP != 7) {
                        x.awN();
                        e.cry();
                    } else {
                        e.crx();
                    }
                    if (b.this.fxT.bmE() != null && b.this.fxT.bmJ() != null) {
                        b.this.fxT.bmE().sE(vVar.fzK);
                        b.this.fxT.bmJ().startPullRefresh();
                        b.this.fxT.bmE().kM(true);
                        b.this.bqh();
                    }
                }
            }
        }
    };
    private View.OnClickListener fFT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.blQ().blR()) {
                if (!j.jQ()) {
                    b.this.fxT.showToast(R.string.neterror);
                } else if (!com.baidu.tbadk.core.util.v.aa(b.this.fFO)) {
                    b.this.a(b.this.fFO, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.eXr != null) {
                Drawable a = SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                b.this.eXr.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private b.a fFW = new b.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.jQ()) {
                b.this.fxT.showToast(R.string.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) com.baidu.tbadk.core.util.v.c(b.this.fFV.bqm(), i);
            if (vVar != null) {
                if (b.this.fFP != vVar.fzK) {
                    b.this.fFQ = true;
                    b.this.xF(vVar.name);
                    if (b.this.fxT.bmE() != null) {
                        b.this.fxT.bmE().sF(b.this.fFP);
                        b.this.fFP = vVar.fzK;
                        bVar.dismiss();
                        if (b.this.fFP != 7) {
                            x.awN();
                            e.cry();
                        } else {
                            e.crx();
                        }
                        if (b.this.fxT.bmE() != null && b.this.fxT.bmJ() != null) {
                            b.this.fxT.bmE().sE(vVar.fzK);
                            b.this.fxT.bmJ().startPullRefresh();
                            b.this.fxT.bmE().kM(true);
                            b.this.bqh();
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
        this.eHo = str;
    }

    public TextView bqk() {
        return this.eXr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF(String str) {
        this.eXr.setText(str);
    }

    public void sd(int i) {
        this.fFP = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fFN == null) {
            this.fFN = new c(this.fxT.getContext());
            this.fFN.setOnDismissListener(this.mOnDismissListener);
            this.fFN.a(this.fFS);
        }
        this.fFN.setData(list, this.fFP);
        this.fFN.bo(view);
        this.fFR = true;
        this.eXr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqh() {
        an anVar = new an("c11437");
        anVar.P("obj_type", this.fFP);
        anVar.bT("fid", this.eHo);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.fxT = frsFragment;
            this.mRootView = relativeLayout;
            this.fFK = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.eXr = (TextView) this.fFK.findViewById(R.id.sort_tab_menu_button);
            this.fFM = (TextView) this.fFK.findViewById(R.id.sort_tab_sort_name);
            this.eXr.setOnClickListener(this.fFT);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Drawable a;
        if (this.eXr != null) {
            am.j(this.eXr, R.color.cp_cont_j);
            am.l(this.eXr, R.color.transparent);
            if (this.fFR) {
                a = SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            } else {
                a = SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.eXr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a, (Drawable) null);
        }
        am.j(this.fFM, R.color.cp_cont_b);
        am.l(this.fFK, R.color.cp_bg_line_d);
        if (this.fFN != null && this.fFR) {
            this.fFN.bql();
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            bqj();
        } else if (this.fxT != null && this.fxT.bmE() != null && this.fxT.bmE().bsh()) {
            bqi();
            ArrayList arrayList = new ArrayList(list);
            if (!cb(arrayList)) {
                if (!this.fFQ) {
                    se(i);
                    return;
                }
                return;
            }
            this.fFO = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.fzK = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.fFO.add(vVar);
                }
            }
            if (!this.fFQ) {
                se(i);
            }
        } else {
            bqj();
        }
    }

    private void se(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.fFO.get(0);
            if (vVar3 != null) {
                sd(vVar3.fzK);
                xF(vVar3.name);
                if (this.fxT != null && this.fxT.bmE() != null) {
                    this.fxT.bmE().sE(vVar3.fzK);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.fFO.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.fFO.get(i2);
                if (vVar2 == null || vVar2.fzK != i) {
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
                xF(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            v vVar4 = this.fFO.get(0);
            if (vVar4 != null) {
                sd(vVar4.fzK);
                xF(vVar4.name);
                if (this.fxT != null && this.fxT.bmE() != null) {
                    this.fxT.bmE().sE(vVar4.fzK);
                }
            }
        } else if (vVar != null) {
            sd(vVar.fzK);
            xF(vVar.name);
            if (this.fxT != null && this.fxT.bmE() != null) {
                this.fxT.bmE().sE(vVar.fzK);
            }
        }
    }

    private boolean cb(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.aa(this.fFO) && com.baidu.tbadk.core.util.v.Z(list) == com.baidu.tbadk.core.util.v.Z(this.fFO)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.fFO.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bqi() {
        if (this.eXr != null) {
            this.eXr.setVisibility(0);
        }
    }

    private void bqj() {
        if (this.eXr != null) {
            this.eXr.setVisibility(8);
        }
    }
}

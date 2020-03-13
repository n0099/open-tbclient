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
    private String emo;
    private TextView fTN;
    private FrsFragment gqm;
    private View gyb;
    private TextView gyd;
    private c gye;
    private List<w> gyf;
    private com.baidu.tieba.frs.entelechy.c.a.a.a gym;
    private ViewGroup mRootView;
    private int gyg = -1;
    private boolean gyh = false;
    private boolean gyi = false;
    private c.a gyj = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(w wVar) {
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.gqm.showToast(R.string.neterror);
                b.this.gye.dismiss();
                b.this.gyi = false;
            } else if (wVar == null) {
                b.this.gye.dismiss();
                b.this.gyi = false;
            } else if (b.this.gyg == wVar.gse) {
                b.this.gye.dismiss();
                b.this.gyi = false;
            } else {
                b.this.gyh = true;
                b.this.Bn(wVar.name);
                if (b.this.gqm.bDL() != null) {
                    b.this.gqm.bDL().tO(b.this.gyg);
                    b.this.gyg = wVar.gse;
                    b.this.gye.dismiss();
                    b.this.gyi = false;
                    if (b.this.gyg != 7) {
                        aa.aSs();
                        e.cMc();
                    } else {
                        e.cMb();
                    }
                    if (b.this.gqm.bDL() != null && b.this.gqm.bDQ() != null) {
                        b.this.gqm.bDL().tN(wVar.gse);
                        b.this.gqm.bDQ().startPullRefresh();
                        b.this.gqm.bDL().lY(true);
                        b.this.bHp();
                    }
                }
            }
        }
    };
    private View.OnClickListener gyk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bCW().bCX()) {
                if (!j.isNetworkAvailableForImmediately()) {
                    b.this.gqm.showToast(R.string.neterror);
                } else if (!v.isEmpty(b.this.gyf)) {
                    b.this.a(b.this.gyf, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.fTN != null) {
                Drawable a = SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                b.this.fTN.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private b.a gyn = new b.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.gqm.showToast(R.string.neterror);
                bVar.dismiss();
                return;
            }
            w wVar = (w) v.getItem(b.this.gym.bHu(), i);
            if (wVar != null) {
                if (b.this.gyg != wVar.gse) {
                    b.this.gyh = true;
                    b.this.Bn(wVar.name);
                    if (b.this.gqm.bDL() != null) {
                        b.this.gqm.bDL().tO(b.this.gyg);
                        b.this.gyg = wVar.gse;
                        bVar.dismiss();
                        if (b.this.gyg != 7) {
                            aa.aSs();
                            e.cMc();
                        } else {
                            e.cMb();
                        }
                        if (b.this.gqm.bDL() != null && b.this.gqm.bDQ() != null) {
                            b.this.gqm.bDL().tN(wVar.gse);
                            b.this.gqm.bDQ().startPullRefresh();
                            b.this.gqm.bDL().lY(true);
                            b.this.bHp();
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
        this.emo = str;
    }

    public TextView bHs() {
        return this.fTN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn(String str) {
        this.fTN.setText(str);
    }

    public void tm(int i) {
        this.gyg = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<w> list, View view) {
        if (this.gye == null) {
            this.gye = new c(this.gqm.getContext());
            this.gye.setOnDismissListener(this.mOnDismissListener);
            this.gye.a(this.gyj);
        }
        this.gye.setData(list, this.gyg);
        this.gye.R(view);
        this.gyi = true;
        this.fTN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHp() {
        an anVar = new an("c11437");
        anVar.X("obj_type", this.gyg);
        anVar.cy("fid", this.emo);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.gqm = frsFragment;
            this.mRootView = relativeLayout;
            this.gyb = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.fTN = (TextView) this.gyb.findViewById(R.id.sort_tab_menu_button);
            this.gyd = (TextView) this.gyb.findViewById(R.id.sort_tab_sort_name);
            this.fTN.setOnClickListener(this.gyk);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Drawable a;
        if (this.fTN != null) {
            am.setViewTextColor(this.fTN, (int) R.color.cp_cont_j);
            am.setBackgroundColor(this.fTN, R.color.transparent);
            if (this.gyi) {
                a = SvgManager.aGC().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            } else {
                a = SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.fTN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a, (Drawable) null);
        }
        am.setViewTextColor(this.gyd, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.gyb, R.color.cp_bg_line_d);
        if (this.gye != null && this.gyi) {
            this.gye.bHt();
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.isEmpty(list)) {
            bHr();
        } else if (this.gqm != null && this.gqm.bDL() != null && this.gqm.bDL().bJm()) {
            bHq();
            ArrayList arrayList = new ArrayList(list);
            if (!cg(arrayList)) {
                if (!this.gyh) {
                    tn(i);
                    return;
                }
                return;
            }
            this.gyf = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    w wVar = new w();
                    wVar.gse = frsTabInfo.tab_id.intValue();
                    wVar.name = frsTabInfo.tab_name;
                    this.gyf.add(wVar);
                }
            }
            if (!this.gyh) {
                tn(i);
            }
        } else {
            bHr();
        }
    }

    private void tn(int i) {
        w wVar;
        boolean z;
        w wVar2 = null;
        if (i <= 0) {
            w wVar3 = this.gyf.get(0);
            if (wVar3 != null) {
                tm(wVar3.gse);
                Bn(wVar3.name);
                if (this.gqm != null && this.gqm.bDL() != null) {
                    this.gqm.bDL().tN(wVar3.gse);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.gyf.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                wVar2 = this.gyf.get(i2);
                if (wVar2 == null || wVar2.gse != i) {
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
                Bn(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            w wVar4 = this.gyf.get(0);
            if (wVar4 != null) {
                tm(wVar4.gse);
                Bn(wVar4.name);
                if (this.gqm != null && this.gqm.bDL() != null) {
                    this.gqm.bDL().tN(wVar4.gse);
                }
            }
        } else if (wVar != null) {
            tm(wVar.gse);
            Bn(wVar.name);
            if (this.gqm != null && this.gqm.bDL() != null) {
                this.gqm.bDL().tN(wVar.gse);
            }
        }
    }

    private boolean cg(List<FrsTabInfo> list) {
        if (!v.isEmpty(this.gyf) && v.getCount(list) == v.getCount(this.gyf)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.gyf.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bHq() {
        if (this.fTN != null) {
            this.fTN.setVisibility(0);
        }
    }

    private void bHr() {
        if (this.fTN != null) {
            this.fTN.setVisibility(8);
        }
    }
}

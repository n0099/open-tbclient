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
    private String emb;
    private TextView fTA;
    private View gxP;
    private FrsNewAreaFragment gxQ;
    private TextView gxR;
    private c gxS;
    private List<w> gxT;
    private int gxU = -1;
    private boolean gxV = false;
    private boolean gxW = false;
    private c.a gxX = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(w wVar) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.gxQ.showToast(R.string.neterror);
                a.this.gxS.dismiss();
                a.this.gxW = false;
            } else if (wVar == null) {
                a.this.gxS.dismiss();
                a.this.gxW = false;
            } else if (a.this.gxU == wVar.grR) {
                a.this.gxS.dismiss();
                a.this.gxW = false;
            } else {
                a.this.gxV = true;
                a.this.Bm(wVar.name);
                if (a.this.gxQ.bJw() != null) {
                    a.this.gxU = wVar.grR;
                    a.this.gxS.dismiss();
                    a.this.gxW = false;
                    if (a.this.gxU != 7) {
                        aa.aSr();
                        e.cMb();
                    } else {
                        e.cMa();
                    }
                    if (a.this.gxQ.bJw() != null && a.this.gxQ.bJx() != null) {
                        a.this.gxQ.bJw().tN(wVar.grR);
                        a.this.gxQ.bJx().startPullRefresh();
                        a.this.bHo();
                    }
                }
            }
        }
    };
    private View.OnClickListener gxY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bCV().bCW()) {
                if (!j.isNetworkAvailableForImmediately()) {
                    a.this.gxQ.showToast(R.string.neterror);
                } else if (!v.isEmpty(a.this.gxT)) {
                    a.this.a(a.this.gxT, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.fTA != null) {
                Drawable a = SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                a.this.fTA.setCompoundDrawables(null, null, a, null);
            }
        }
    };

    public void setFid(String str) {
        this.emb = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm(String str) {
        this.fTA.setText(str);
    }

    public void tm(int i) {
        this.gxU = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<w> list, View view) {
        if (this.gxS == null) {
            this.gxS = new c(this.gxQ.getContext());
            this.gxS.setOnDismissListener(this.mOnDismissListener);
            this.gxS.a(this.gxX);
        }
        this.gxS.setData(list, this.gxU);
        this.gxS.R(view);
        this.gxW = true;
        this.fTA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHo() {
        an anVar = new an("c11437");
        anVar.X("obj_type", this.gxU);
        anVar.cy("fid", this.emb);
        TiebaStatic.log(anVar);
    }

    public a(FrsNewAreaFragment frsNewAreaFragment, RelativeLayout relativeLayout) {
        if (frsNewAreaFragment != null && relativeLayout != null) {
            this.gxQ = frsNewAreaFragment;
            this.gxP = LayoutInflater.from(frsNewAreaFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.fTA = (TextView) this.gxP.findViewById(R.id.sort_tab_menu_button);
            this.gxR = (TextView) this.gxP.findViewById(R.id.sort_tab_sort_name);
            this.fTA.setOnClickListener(this.gxY);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Drawable a;
        if (this.fTA != null) {
            am.setViewTextColor(this.fTA, (int) R.color.cp_cont_j);
            am.setBackgroundColor(this.fTA, R.color.transparent);
            if (this.gxW) {
                a = SvgManager.aGC().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null);
            } else {
                a = SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null);
            }
            this.fTA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a, (Drawable) null);
        }
        am.setViewTextColor(this.gxR, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.gxP, R.color.cp_bg_line_d);
        if (this.gxS != null && this.gxW) {
            this.gxS.bHs();
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.isEmpty(list)) {
            bHq();
        } else if (this.gxQ != null && this.gxQ.bJw() != null) {
            bHp();
            ArrayList arrayList = new ArrayList(list);
            if (!cg(arrayList)) {
                if (!this.gxV) {
                    tn(i);
                    return;
                }
                return;
            }
            this.gxT = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    w wVar = new w();
                    wVar.grR = frsTabInfo.tab_id.intValue();
                    wVar.name = frsTabInfo.tab_name;
                    this.gxT.add(wVar);
                }
            }
            if (!this.gxV) {
                tn(i);
            }
        } else {
            bHq();
        }
    }

    private void tn(int i) {
        w wVar;
        boolean z;
        w wVar2 = null;
        if (i <= 0) {
            w wVar3 = this.gxT.get(0);
            if (wVar3 != null) {
                tm(wVar3.grR);
                Bm(wVar3.name);
                if (this.gxQ != null && this.gxQ.bJw() != null) {
                    this.gxQ.bJw().tN(wVar3.grR);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.gxT.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                wVar2 = this.gxT.get(i2);
                if (wVar2 == null || wVar2.grR != i) {
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
            w wVar4 = this.gxT.get(0);
            if (wVar4 != null) {
                tm(wVar4.grR);
                Bm(wVar4.name);
                if (this.gxQ != null && this.gxQ.bJw() != null) {
                    this.gxQ.bJw().tN(wVar4.grR);
                }
            }
        } else if (wVar != null) {
            tm(wVar.grR);
            Bm(wVar.name);
            if (this.gxQ != null && this.gxQ.bJw() != null) {
                this.gxQ.bJw().tN(wVar.grR);
            }
        }
    }

    private boolean cg(List<FrsTabInfo> list) {
        if (!v.isEmpty(this.gxT) && v.getCount(list) == v.getCount(this.gxT)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.gxT.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bHp() {
        if (this.fTA != null) {
            this.fTA.setVisibility(0);
        }
    }

    private void bHq() {
        if (this.fTA != null) {
            this.fTA.setVisibility(8);
        }
    }
}

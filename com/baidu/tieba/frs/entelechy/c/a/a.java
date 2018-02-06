package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    private String cZU;
    private i dFP;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dLA;
    private int dLB = -1;
    private boolean dLC = false;
    private View.OnClickListener dLD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                a.this.dFP.showToast(d.j.neterror);
                return;
            }
            if (a.this.dLA == null) {
                a.this.dLA = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dFP, a.this.dLE);
            }
            a.this.dLA.setData(a.this.dLz);
            a.this.dLA.d(a.this.dFP.getPageContext()).AX();
        }
    };
    private b.InterfaceC0096b dLE = new b.InterfaceC0096b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
        public void a(b bVar, int i, View view) {
            if (!j.ox()) {
                a.this.dFP.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            z zVar = (z) v.f(a.this.dLA.axI(), i);
            if (zVar != null) {
                if (a.this.dLB != zVar.dHn) {
                    a.this.dLC = true;
                    a.this.dLy.setText(zVar.name);
                    if (a.this.dLB == 7) {
                        ak akVar = new ak("c11437");
                        akVar.s("obj_locate", zVar.dHn);
                        akVar.ab(ImageViewerConfig.FORUM_ID, a.this.cZU);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.dFP.auO() != null) {
                        a.this.dFP.auO().nI(a.this.dLB);
                        a.this.dLB = zVar.dHn;
                        bVar.dismiss();
                        if (a.this.dLB != 7) {
                            t.Po();
                            f.bxS();
                        } else {
                            f.bxR();
                        }
                        if (a.this.dFP.auO() != null && a.this.dFP.auT() != null) {
                            a.this.dFP.auO().nH(zVar.dHn);
                            a.this.dFP.auT().startPullRefresh();
                            a.this.dFP.auO().go(true);
                            com.baidu.tieba.frs.smartsort.d.azM().h(a.this.dFP.auO().getForumName(), zVar.dHn, zVar.name);
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
    private TextView dLy;
    private List<z> dLz;
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.cZU = str;
    }

    public TextView axF() {
        return this.dLy;
    }

    public void lQ(String str) {
        this.dLy.setText(str);
    }

    public void nj(int i) {
        this.dLB = i;
    }

    public a(i iVar, RelativeLayout relativeLayout) {
        if (iVar != null && relativeLayout != null) {
            this.dFP = iVar;
            this.mRootView = relativeLayout;
            this.dLy = new TextView(iVar.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.t(TbadkCoreApplication.getInst(), d.e.tbds104));
            layoutParams.addRule(15);
            this.dLy.setPadding(l.t(iVar.getActivity(), d.e.tbds30), 0, l.t(iVar.getActivity(), d.e.tbds44), 0);
            this.dLy.setGravity(17);
            this.dLy.setTextSize(0, l.t(iVar.getActivity(), d.e.ds28));
            this.dLy.setCompoundDrawablePadding(l.t(iVar.getActivity(), d.e.tbds20));
            this.dLy.setOnClickListener(this.dLD);
            this.mRootView.addView(this.dLy, layoutParams);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dLy != null) {
            aj.r(this.dLy, d.C0140d.cp_cont_j);
            aj.t(this.dLy, d.C0140d.transparent);
            this.dLy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.E(list)) {
            axH();
        } else if (this.dFP != null && this.dFP.auO() != null && this.dFP.auO().azs()) {
            axG();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bn(arrayList)) {
                if (!this.dLC) {
                    nk(i);
                    return;
                }
                return;
            }
            this.dLz = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    z zVar = new z();
                    zVar.dHn = frsTabInfo.tab_id.intValue();
                    zVar.name = frsTabInfo.tab_name;
                    this.dLz.add(zVar);
                }
            }
            if (!this.dLC) {
                nk(i);
            }
        } else {
            axH();
        }
    }

    private void nk(int i) {
        z zVar;
        boolean z;
        z zVar2 = null;
        if (i <= 0) {
            z zVar3 = this.dLz.get(0);
            if (zVar3 != null) {
                nj(zVar3.dHn);
                lQ(zVar3.name);
                if (this.dFP != null && this.dFP.auO() != null) {
                    this.dFP.auO().nH(zVar3.dHn);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dLz.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                zVar2 = this.dLz.get(i2);
                if (zVar2 == null || zVar2.dHn != i) {
                    i2++;
                } else {
                    zVar = zVar2;
                    z = true;
                    break;
                }
            } else {
                zVar = zVar2;
                z = false;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                lQ(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            z zVar4 = this.dLz.get(0);
            if (zVar4 != null) {
                nj(zVar4.dHn);
                lQ(zVar4.name);
                if (this.dFP != null && this.dFP.auO() != null) {
                    this.dFP.auO().nH(zVar4.dHn);
                }
            }
        } else if (zVar != null) {
            nj(zVar.dHn);
            lQ(zVar.name);
            if (this.dFP != null && this.dFP.auO() != null) {
                this.dFP.auO().nH(zVar.dHn);
            }
        }
    }

    private boolean bn(List<FrsTabInfo> list) {
        if (!v.E(this.dLz) && v.D(list) == v.D(this.dLz)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dLz.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void axG() {
        if (this.dLy != null) {
            this.dLy.setVisibility(0);
        }
    }

    public void axH() {
        if (this.dLy != null) {
            this.dLy.setVisibility(8);
        }
    }

    public void resetData() {
        this.dLz = null;
    }
}

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
    private String cZI;
    private i dFD;
    private TextView dLm;
    private List<z> dLn;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dLo;
    private int dLp = -1;
    private boolean dLq = false;
    private View.OnClickListener dLr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                a.this.dFD.showToast(d.j.neterror);
                return;
            }
            if (a.this.dLo == null) {
                a.this.dLo = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dFD, a.this.dLs);
            }
            a.this.dLo.setData(a.this.dLn);
            a.this.dLo.d(a.this.dFD.getPageContext()).AX();
        }
    };
    private b.InterfaceC0097b dLs = new b.InterfaceC0097b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
        public void a(b bVar, int i, View view) {
            if (!j.ox()) {
                a.this.dFD.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            z zVar = (z) v.f(a.this.dLo.axH(), i);
            if (zVar != null) {
                if (a.this.dLp != zVar.dHb) {
                    a.this.dLq = true;
                    a.this.dLm.setText(zVar.name);
                    if (a.this.dLp == 7) {
                        ak akVar = new ak("c11437");
                        akVar.s("obj_locate", zVar.dHb);
                        akVar.ab(ImageViewerConfig.FORUM_ID, a.this.cZI);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.dFD.auN() != null) {
                        a.this.dFD.auN().nI(a.this.dLp);
                        a.this.dLp = zVar.dHb;
                        bVar.dismiss();
                        if (a.this.dLp != 7) {
                            t.Pn();
                            f.bxR();
                        } else {
                            f.bxQ();
                        }
                        if (a.this.dFD.auN() != null && a.this.dFD.auS() != null) {
                            a.this.dFD.auN().nH(zVar.dHb);
                            a.this.dFD.auS().startPullRefresh();
                            a.this.dFD.auN().go(true);
                            com.baidu.tieba.frs.smartsort.d.azL().h(a.this.dFD.auN().getForumName(), zVar.dHb, zVar.name);
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
        this.cZI = str;
    }

    public TextView axE() {
        return this.dLm;
    }

    public void lQ(String str) {
        this.dLm.setText(str);
    }

    public void nj(int i) {
        this.dLp = i;
    }

    public a(i iVar, RelativeLayout relativeLayout) {
        if (iVar != null && relativeLayout != null) {
            this.dFD = iVar;
            this.mRootView = relativeLayout;
            this.dLm = new TextView(iVar.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.t(TbadkCoreApplication.getInst(), d.e.tbds104));
            layoutParams.addRule(15);
            this.dLm.setPadding(l.t(iVar.getActivity(), d.e.tbds30), 0, l.t(iVar.getActivity(), d.e.tbds44), 0);
            this.dLm.setGravity(17);
            this.dLm.setTextSize(0, l.t(iVar.getActivity(), d.e.ds28));
            this.dLm.setCompoundDrawablePadding(l.t(iVar.getActivity(), d.e.tbds20));
            this.dLm.setOnClickListener(this.dLr);
            this.mRootView.addView(this.dLm, layoutParams);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dLm != null) {
            aj.r(this.dLm, d.C0141d.cp_cont_j);
            aj.t(this.dLm, d.C0141d.transparent);
            this.dLm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.E(list)) {
            axG();
        } else if (this.dFD != null && this.dFD.auN() != null && this.dFD.auN().azr()) {
            axF();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bn(arrayList)) {
                if (!this.dLq) {
                    nk(i);
                    return;
                }
                return;
            }
            this.dLn = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    z zVar = new z();
                    zVar.dHb = frsTabInfo.tab_id.intValue();
                    zVar.name = frsTabInfo.tab_name;
                    this.dLn.add(zVar);
                }
            }
            if (!this.dLq) {
                nk(i);
            }
        } else {
            axG();
        }
    }

    private void nk(int i) {
        z zVar;
        boolean z;
        z zVar2 = null;
        if (i <= 0) {
            z zVar3 = this.dLn.get(0);
            if (zVar3 != null) {
                nj(zVar3.dHb);
                lQ(zVar3.name);
                if (this.dFD != null && this.dFD.auN() != null) {
                    this.dFD.auN().nH(zVar3.dHb);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dLn.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                zVar2 = this.dLn.get(i2);
                if (zVar2 == null || zVar2.dHb != i) {
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
            z zVar4 = this.dLn.get(0);
            if (zVar4 != null) {
                nj(zVar4.dHb);
                lQ(zVar4.name);
                if (this.dFD != null && this.dFD.auN() != null) {
                    this.dFD.auN().nH(zVar4.dHb);
                }
            }
        } else if (zVar != null) {
            nj(zVar.dHb);
            lQ(zVar.name);
            if (this.dFD != null && this.dFD.auN() != null) {
                this.dFD.auN().nH(zVar.dHb);
            }
        }
    }

    private boolean bn(List<FrsTabInfo> list) {
        if (!v.E(this.dLn) && v.D(list) == v.D(this.dLn)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dLn.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void axF() {
        if (this.dLm != null) {
            this.dLm.setVisibility(0);
        }
    }

    public void axG() {
        if (this.dLm != null) {
            this.dLm.setVisibility(8);
        }
    }

    public void resetData() {
        this.dLn = null;
    }
}

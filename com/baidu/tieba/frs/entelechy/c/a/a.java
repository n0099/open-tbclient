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
    private String cZL;
    private i dFH;
    private TextView dLr;
    private List<z> dLs;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dLt;
    private int dLu = -1;
    private boolean dLv = false;
    private View.OnClickListener dLw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                a.this.dFH.showToast(d.j.neterror);
                return;
            }
            if (a.this.dLt == null) {
                a.this.dLt = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dFH, a.this.dLx);
            }
            a.this.dLt.setData(a.this.dLs);
            a.this.dLt.d(a.this.dFH.getPageContext()).AY();
        }
    };
    private b.InterfaceC0097b dLx = new b.InterfaceC0097b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
        public void a(b bVar, int i, View view) {
            if (!j.ox()) {
                a.this.dFH.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            z zVar = (z) v.f(a.this.dLt.axJ(), i);
            if (zVar != null) {
                if (a.this.dLu != zVar.dHg) {
                    a.this.dLv = true;
                    a.this.dLr.setText(zVar.name);
                    if (a.this.dLu == 7) {
                        ak akVar = new ak("c11437");
                        akVar.s("obj_locate", zVar.dHg);
                        akVar.ab(ImageViewerConfig.FORUM_ID, a.this.cZL);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.dFH.auO() != null) {
                        a.this.dFH.auO().nI(a.this.dLu);
                        a.this.dLu = zVar.dHg;
                        bVar.dismiss();
                        if (a.this.dLu != 7) {
                            t.Po();
                            f.bxW();
                        } else {
                            f.bxV();
                        }
                        if (a.this.dFH.auO() != null && a.this.dFH.auT() != null) {
                            a.this.dFH.auO().nH(zVar.dHg);
                            a.this.dFH.auT().startPullRefresh();
                            a.this.dFH.auO().gq(true);
                            com.baidu.tieba.frs.smartsort.d.azN().h(a.this.dFH.auO().getForumName(), zVar.dHg, zVar.name);
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
        this.cZL = str;
    }

    public TextView axG() {
        return this.dLr;
    }

    public void lQ(String str) {
        this.dLr.setText(str);
    }

    public void nj(int i) {
        this.dLu = i;
    }

    public a(i iVar, RelativeLayout relativeLayout) {
        if (iVar != null && relativeLayout != null) {
            this.dFH = iVar;
            this.mRootView = relativeLayout;
            this.dLr = new TextView(iVar.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.t(TbadkCoreApplication.getInst(), d.e.tbds104));
            layoutParams.addRule(15);
            this.dLr.setPadding(l.t(iVar.getActivity(), d.e.tbds30), 0, l.t(iVar.getActivity(), d.e.tbds44), 0);
            this.dLr.setGravity(17);
            this.dLr.setTextSize(0, l.t(iVar.getActivity(), d.e.ds28));
            this.dLr.setCompoundDrawablePadding(l.t(iVar.getActivity(), d.e.tbds20));
            this.dLr.setOnClickListener(this.dLw);
            this.mRootView.addView(this.dLr, layoutParams);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dLr != null) {
            aj.r(this.dLr, d.C0141d.cp_cont_j);
            aj.t(this.dLr, d.C0141d.transparent);
            this.dLr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.E(list)) {
            axI();
        } else if (this.dFH != null && this.dFH.auO() != null && this.dFH.auO().azt()) {
            axH();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bn(arrayList)) {
                if (!this.dLv) {
                    nk(i);
                    return;
                }
                return;
            }
            this.dLs = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    z zVar = new z();
                    zVar.dHg = frsTabInfo.tab_id.intValue();
                    zVar.name = frsTabInfo.tab_name;
                    this.dLs.add(zVar);
                }
            }
            if (!this.dLv) {
                nk(i);
            }
        } else {
            axI();
        }
    }

    private void nk(int i) {
        z zVar;
        boolean z;
        z zVar2 = null;
        if (i <= 0) {
            z zVar3 = this.dLs.get(0);
            if (zVar3 != null) {
                nj(zVar3.dHg);
                lQ(zVar3.name);
                if (this.dFH != null && this.dFH.auO() != null) {
                    this.dFH.auO().nH(zVar3.dHg);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dLs.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                zVar2 = this.dLs.get(i2);
                if (zVar2 == null || zVar2.dHg != i) {
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
            z zVar4 = this.dLs.get(0);
            if (zVar4 != null) {
                nj(zVar4.dHg);
                lQ(zVar4.name);
                if (this.dFH != null && this.dFH.auO() != null) {
                    this.dFH.auO().nH(zVar4.dHg);
                }
            }
        } else if (zVar != null) {
            nj(zVar.dHg);
            lQ(zVar.name);
            if (this.dFH != null && this.dFH.auO() != null) {
                this.dFH.auO().nH(zVar.dHg);
            }
        }
    }

    private boolean bn(List<FrsTabInfo> list) {
        if (!v.E(this.dLs) && v.D(list) == v.D(this.dLs)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dLs.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void axH() {
        if (this.dLr != null) {
            this.dLr.setVisibility(0);
        }
    }

    public void axI() {
        if (this.dLr != null) {
            this.dLr.setVisibility(8);
        }
    }

    public void resetData() {
        this.dLs = null;
    }
}

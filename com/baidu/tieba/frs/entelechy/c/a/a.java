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
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private String aAv;
    private g cIC;
    private TextView cOL;
    private List<z> cOM;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cON;
    private int cOO = -1;
    private boolean cOP = false;
    private View.OnClickListener cOQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.gV()) {
                a.this.cIC.showToast(d.j.neterror);
                return;
            }
            if (a.this.cON == null) {
                a.this.cON = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.cIC, a.this.cOR);
            }
            a.this.cON.setData(a.this.cOM);
            a.this.cON.d(a.this.cIC.getPageContext()).tl();
        }
    };
    private b.InterfaceC0060b cOR = new b.InterfaceC0060b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
        public void a(b bVar, int i, View view) {
            if (!j.gV()) {
                a.this.cIC.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            z zVar = (z) v.c(a.this.cON.aoc(), i);
            if (zVar != null) {
                if (a.this.cOO != zVar.cKh) {
                    a.this.cOP = true;
                    a.this.cOL.setText(zVar.name);
                    if (a.this.cOO == 7) {
                        ak akVar = new ak("c11437");
                        akVar.r("obj_locate", zVar.cKh);
                        akVar.ac(ImageViewerConfig.FORUM_ID, a.this.aAv);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.cIC.ali() != null) {
                        a.this.cIC.ali().kJ(a.this.cOO);
                        a.this.cOO = zVar.cKh;
                        bVar.dismiss();
                        if (a.this.cOO != 7) {
                            t.Hu();
                            f.bxU();
                        } else {
                            f.bxT();
                        }
                        if (a.this.cIC.ali() != null && a.this.cIC.aln() != null) {
                            a.this.cIC.ali().kI(zVar.cKh);
                            a.this.cIC.aln().startPullRefresh();
                            a.this.cIC.ali().fy(true);
                            com.baidu.tieba.frs.smartsort.d.aqr().h(a.this.cIC.ali().getForumName(), zVar.cKh, zVar.name);
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
        this.aAv = str;
    }

    public TextView anZ() {
        return this.cOL;
    }

    public void li(String str) {
        this.cOL.setText(str);
    }

    public void kk(int i) {
        this.cOO = i;
    }

    public a(g gVar, RelativeLayout relativeLayout) {
        if (gVar != null && relativeLayout != null) {
            this.cIC = gVar;
            this.mRootView = relativeLayout;
            this.cOL = new TextView(gVar.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.f(TbadkCoreApplication.getInst(), d.e.tbds104));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            int f = l.f(gVar.getActivity(), d.e.ds30);
            this.cOL.setPadding(f, 0, f, 0);
            this.cOL.setGravity(17);
            this.cOL.setTextSize(0, l.f(gVar.getActivity(), d.e.ds28));
            this.cOL.setCompoundDrawablePadding(l.f(gVar.getActivity(), d.e.tbds20));
            this.cOL.setOnClickListener(this.cOQ);
            this.mRootView.addView(this.cOL, layoutParams);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.cOL != null) {
            aj.i(this.cOL, d.C0095d.cp_cont_j);
            aj.k(this.cOL, d.C0095d.transparent);
            this.cOL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.w(list)) {
            aob();
        } else if (this.cIC != null && this.cIC.ali() != null && this.cIC.ali().apW()) {
            aoa();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!ba(arrayList)) {
                if (!this.cOP) {
                    kl(i);
                    return;
                }
                return;
            }
            this.cOM = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    z zVar = new z();
                    zVar.cKh = frsTabInfo.tab_id.intValue();
                    zVar.name = frsTabInfo.tab_name;
                    this.cOM.add(zVar);
                }
            }
            if (!this.cOP) {
                kl(i);
            }
        } else {
            aob();
        }
    }

    private void kl(int i) {
        z zVar;
        boolean z;
        z zVar2 = null;
        if (i <= 0) {
            z zVar3 = this.cOM.get(0);
            if (zVar3 != null) {
                kk(zVar3.cKh);
                li(zVar3.name);
                if (this.cIC != null && this.cIC.ali() != null) {
                    this.cIC.ali().kI(zVar3.cKh);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cOM.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                zVar2 = this.cOM.get(i2);
                if (zVar2 == null || zVar2.cKh != i) {
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
                li(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            z zVar4 = this.cOM.get(0);
            if (zVar4 != null) {
                kk(zVar4.cKh);
                li(zVar4.name);
                if (this.cIC != null && this.cIC.ali() != null) {
                    this.cIC.ali().kI(zVar4.cKh);
                }
            }
        } else if (zVar != null) {
            kk(zVar.cKh);
            li(zVar.name);
            if (this.cIC != null && this.cIC.ali() != null) {
                this.cIC.ali().kI(zVar.cKh);
            }
        }
    }

    private boolean ba(List<FrsTabInfo> list) {
        if (!v.w(this.cOM) && v.v(list) == v.v(this.cOM)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cOM.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void aoa() {
        if (this.cOL != null) {
            this.cOL.setVisibility(0);
        }
    }

    public void aob() {
        if (this.cOL != null) {
            this.cOL.setVisibility(8);
        }
    }
}

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
    private String aAs;
    private g cIy;
    private TextView cOH;
    private List<z> cOI;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cOJ;
    private int cOK = -1;
    private boolean cOL = false;
    private View.OnClickListener cOM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.gV()) {
                a.this.cIy.showToast(d.j.neterror);
                return;
            }
            if (a.this.cOJ == null) {
                a.this.cOJ = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.cIy, a.this.cON);
            }
            a.this.cOJ.setData(a.this.cOI);
            a.this.cOJ.d(a.this.cIy.getPageContext()).tl();
        }
    };
    private b.InterfaceC0061b cON = new b.InterfaceC0061b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
        public void a(b bVar, int i, View view) {
            if (!j.gV()) {
                a.this.cIy.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            z zVar = (z) v.c(a.this.cOJ.aoc(), i);
            if (zVar != null) {
                if (a.this.cOK != zVar.cKd) {
                    a.this.cOL = true;
                    a.this.cOH.setText(zVar.name);
                    if (a.this.cOK == 7) {
                        ak akVar = new ak("c11437");
                        akVar.r("obj_locate", zVar.cKd);
                        akVar.ac(ImageViewerConfig.FORUM_ID, a.this.aAs);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.cIy.alj() != null) {
                        a.this.cIy.alj().kJ(a.this.cOK);
                        a.this.cOK = zVar.cKd;
                        bVar.dismiss();
                        if (a.this.cOK != 7) {
                            t.Hu();
                            f.bxU();
                        } else {
                            f.bxT();
                        }
                        if (a.this.cIy.alj() != null && a.this.cIy.alo() != null) {
                            a.this.cIy.alj().kI(zVar.cKd);
                            a.this.cIy.alo().startPullRefresh();
                            a.this.cIy.alj().fy(true);
                            com.baidu.tieba.frs.smartsort.d.aqr().h(a.this.cIy.alj().getForumName(), zVar.cKd, zVar.name);
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
        this.aAs = str;
    }

    public TextView anZ() {
        return this.cOH;
    }

    public void li(String str) {
        this.cOH.setText(str);
    }

    public void kk(int i) {
        this.cOK = i;
    }

    public a(g gVar, RelativeLayout relativeLayout) {
        if (gVar != null && relativeLayout != null) {
            this.cIy = gVar;
            this.mRootView = relativeLayout;
            this.cOH = new TextView(gVar.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.f(TbadkCoreApplication.getInst(), d.e.tbds104));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            int f = l.f(gVar.getActivity(), d.e.ds30);
            this.cOH.setPadding(f, 0, f, 0);
            this.cOH.setGravity(17);
            this.cOH.setTextSize(0, l.f(gVar.getActivity(), d.e.ds28));
            this.cOH.setCompoundDrawablePadding(l.f(gVar.getActivity(), d.e.tbds20));
            this.cOH.setOnClickListener(this.cOM);
            this.mRootView.addView(this.cOH, layoutParams);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.cOH != null) {
            aj.i(this.cOH, d.C0096d.cp_cont_j);
            aj.k(this.cOH, d.C0096d.transparent);
            this.cOH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.w(list)) {
            aob();
        } else if (this.cIy != null && this.cIy.alj() != null && this.cIy.alj().apW()) {
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
                if (!this.cOL) {
                    kl(i);
                    return;
                }
                return;
            }
            this.cOI = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    z zVar = new z();
                    zVar.cKd = frsTabInfo.tab_id.intValue();
                    zVar.name = frsTabInfo.tab_name;
                    this.cOI.add(zVar);
                }
            }
            if (!this.cOL) {
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
            z zVar3 = this.cOI.get(0);
            if (zVar3 != null) {
                kk(zVar3.cKd);
                li(zVar3.name);
                if (this.cIy != null && this.cIy.alj() != null) {
                    this.cIy.alj().kI(zVar3.cKd);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cOI.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                zVar2 = this.cOI.get(i2);
                if (zVar2 == null || zVar2.cKd != i) {
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
            z zVar4 = this.cOI.get(0);
            if (zVar4 != null) {
                kk(zVar4.cKd);
                li(zVar4.name);
                if (this.cIy != null && this.cIy.alj() != null) {
                    this.cIy.alj().kI(zVar4.cKd);
                }
            }
        } else if (zVar != null) {
            kk(zVar.cKd);
            li(zVar.name);
            if (this.cIy != null && this.cIy.alj() != null) {
                this.cIy.alj().kI(zVar.cKd);
            }
        }
    }

    private boolean ba(List<FrsTabInfo> list) {
        if (!v.w(this.cOI) && v.v(list) == v.v(this.cOI)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cOI.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void aoa() {
        if (this.cOH != null) {
            this.cOH.setVisibility(0);
        }
    }

    public void aob() {
        if (this.cOH != null) {
            this.cOH.setVisibility(8);
        }
    }
}

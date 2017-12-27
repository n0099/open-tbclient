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
    private String cSk;
    private TextView dDB;
    private List<z> dDC;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dDD;
    private int dDE = -1;
    private boolean dDF = false;
    private View.OnClickListener dDG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ow()) {
                a.this.dxW.showToast(d.j.neterror);
                return;
            }
            if (a.this.dDD == null) {
                a.this.dDD = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dxW, a.this.dDH);
            }
            a.this.dDD.setData(a.this.dDC);
            a.this.dDD.d(a.this.dxW.getPageContext()).AL();
        }
    };
    private b.InterfaceC0074b dDH = new b.InterfaceC0074b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
        public void a(b bVar, int i, View view) {
            if (!j.ow()) {
                a.this.dxW.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            z zVar = (z) v.f(a.this.dDD.avB(), i);
            if (zVar != null) {
                if (a.this.dDE != zVar.dzo) {
                    a.this.dDF = true;
                    a.this.dDB.setText(zVar.name);
                    if (a.this.dDE == 7) {
                        ak akVar = new ak("c11437");
                        akVar.s("obj_locate", zVar.dzo);
                        akVar.ab(ImageViewerConfig.FORUM_ID, a.this.cSk);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.dxW.asQ() != null) {
                        a.this.dxW.asQ().nF(a.this.dDE);
                        a.this.dDE = zVar.dzo;
                        bVar.dismiss();
                        if (a.this.dDE != 7) {
                            t.OT();
                            f.bDk();
                        } else {
                            f.bDj();
                        }
                        if (a.this.dxW.asQ() != null && a.this.dxW.asV() != null) {
                            a.this.dxW.asQ().nE(zVar.dzo);
                            a.this.dxW.asV().startPullRefresh();
                            a.this.dxW.asQ().fY(true);
                            com.baidu.tieba.frs.smartsort.d.axC().h(a.this.dxW.asQ().getForumName(), zVar.dzo, zVar.name);
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
    private i dxW;
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.cSk = str;
    }

    public TextView avy() {
        return this.dDB;
    }

    public void lq(String str) {
        this.dDB.setText(str);
    }

    public void ni(int i) {
        this.dDE = i;
    }

    public a(i iVar, RelativeLayout relativeLayout) {
        if (iVar != null && relativeLayout != null) {
            this.dxW = iVar;
            this.mRootView = relativeLayout;
            this.dDB = new TextView(iVar.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.s(TbadkCoreApplication.getInst(), d.e.tbds104));
            layoutParams.addRule(15);
            this.dDB.setPadding(l.s(iVar.getActivity(), d.e.tbds30), 0, l.s(iVar.getActivity(), d.e.tbds44), 0);
            this.dDB.setGravity(17);
            this.dDB.setTextSize(0, l.s(iVar.getActivity(), d.e.ds28));
            this.dDB.setCompoundDrawablePadding(l.s(iVar.getActivity(), d.e.tbds20));
            this.dDB.setOnClickListener(this.dDG);
            this.mRootView.addView(this.dDB, layoutParams);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dDB != null) {
            aj.r(this.dDB, d.C0108d.cp_cont_j);
            aj.t(this.dDB, d.C0108d.transparent);
            this.dDB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.G(list)) {
            avA();
        } else if (this.dxW != null && this.dxW.asQ() != null && this.dxW.asQ().axi()) {
            avz();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bn(arrayList)) {
                if (!this.dDF) {
                    nj(i);
                    return;
                }
                return;
            }
            this.dDC = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    z zVar = new z();
                    zVar.dzo = frsTabInfo.tab_id.intValue();
                    zVar.name = frsTabInfo.tab_name;
                    this.dDC.add(zVar);
                }
            }
            if (!this.dDF) {
                nj(i);
            }
        } else {
            avA();
        }
    }

    private void nj(int i) {
        z zVar;
        boolean z;
        z zVar2 = null;
        if (i <= 0) {
            z zVar3 = this.dDC.get(0);
            if (zVar3 != null) {
                ni(zVar3.dzo);
                lq(zVar3.name);
                if (this.dxW != null && this.dxW.asQ() != null) {
                    this.dxW.asQ().nE(zVar3.dzo);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dDC.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                zVar2 = this.dDC.get(i2);
                if (zVar2 == null || zVar2.dzo != i) {
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
                lq(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            z zVar4 = this.dDC.get(0);
            if (zVar4 != null) {
                ni(zVar4.dzo);
                lq(zVar4.name);
                if (this.dxW != null && this.dxW.asQ() != null) {
                    this.dxW.asQ().nE(zVar4.dzo);
                }
            }
        } else if (zVar != null) {
            ni(zVar.dzo);
            lq(zVar.name);
            if (this.dxW != null && this.dxW.asQ() != null) {
                this.dxW.asQ().nE(zVar.dzo);
            }
        }
    }

    private boolean bn(List<FrsTabInfo> list) {
        if (!v.G(this.dDC) && v.F(list) == v.F(this.dDC)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dDC.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void avz() {
        if (this.dDB != null) {
            this.dDB.setVisibility(0);
        }
    }

    public void avA() {
        if (this.dDB != null) {
            this.dDB.setVisibility(8);
        }
    }

    public void resetData() {
        this.dDC = null;
    }
}

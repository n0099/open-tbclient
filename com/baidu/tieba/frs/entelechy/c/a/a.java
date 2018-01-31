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
    private String cXh;
    private i dCS;
    private int dIA = -1;
    private boolean dIB = false;
    private View.OnClickListener dIC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ox()) {
                a.this.dCS.showToast(d.j.neterror);
                return;
            }
            if (a.this.dIz == null) {
                a.this.dIz = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dCS, a.this.dID);
            }
            a.this.dIz.setData(a.this.dIy);
            a.this.dIz.d(a.this.dCS.getPageContext()).AE();
        }
    };
    private b.InterfaceC0073b dID = new b.InterfaceC0073b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
        public void a(b bVar, int i, View view) {
            if (!j.ox()) {
                a.this.dCS.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            z zVar = (z) v.f(a.this.dIz.awJ(), i);
            if (zVar != null) {
                if (a.this.dIA != zVar.dEk) {
                    a.this.dIB = true;
                    a.this.dIx.setText(zVar.name);
                    if (a.this.dIA == 7) {
                        ak akVar = new ak("c11437");
                        akVar.s("obj_locate", zVar.dEk);
                        akVar.aa(ImageViewerConfig.FORUM_ID, a.this.cXh);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.dCS.atY() != null) {
                        a.this.dCS.atY().nI(a.this.dIA);
                        a.this.dIA = zVar.dEk;
                        bVar.dismiss();
                        if (a.this.dIA != 7) {
                            t.OJ();
                            f.bwJ();
                        } else {
                            f.bwI();
                        }
                        if (a.this.dCS.atY() != null && a.this.dCS.aud() != null) {
                            a.this.dCS.atY().nH(zVar.dEk);
                            a.this.dCS.aud().startPullRefresh();
                            a.this.dCS.atY().ge(true);
                            com.baidu.tieba.frs.smartsort.d.ayK().h(a.this.dCS.atY().getForumName(), zVar.dEk, zVar.name);
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
    private TextView dIx;
    private List<z> dIy;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dIz;
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.cXh = str;
    }

    public TextView awG() {
        return this.dIx;
    }

    public void lF(String str) {
        this.dIx.setText(str);
    }

    public void nl(int i) {
        this.dIA = i;
    }

    public a(i iVar, RelativeLayout relativeLayout) {
        if (iVar != null && relativeLayout != null) {
            this.dCS = iVar;
            this.mRootView = relativeLayout;
            this.dIx = new TextView(iVar.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.s(TbadkCoreApplication.getInst(), d.e.tbds104));
            layoutParams.addRule(15);
            this.dIx.setPadding(l.s(iVar.getActivity(), d.e.tbds30), 0, l.s(iVar.getActivity(), d.e.tbds44), 0);
            this.dIx.setGravity(17);
            this.dIx.setTextSize(0, l.s(iVar.getActivity(), d.e.ds28));
            this.dIx.setCompoundDrawablePadding(l.s(iVar.getActivity(), d.e.tbds20));
            this.dIx.setOnClickListener(this.dIC);
            this.mRootView.addView(this.dIx, layoutParams);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dIx != null) {
            aj.r(this.dIx, d.C0108d.cp_cont_j);
            aj.t(this.dIx, d.C0108d.transparent);
            this.dIx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.E(list)) {
            awI();
        } else if (this.dCS != null && this.dCS.atY() != null && this.dCS.atY().ayq()) {
            awH();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bl(arrayList)) {
                if (!this.dIB) {
                    nm(i);
                    return;
                }
                return;
            }
            this.dIy = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    z zVar = new z();
                    zVar.dEk = frsTabInfo.tab_id.intValue();
                    zVar.name = frsTabInfo.tab_name;
                    this.dIy.add(zVar);
                }
            }
            if (!this.dIB) {
                nm(i);
            }
        } else {
            awI();
        }
    }

    private void nm(int i) {
        z zVar;
        boolean z;
        z zVar2 = null;
        if (i <= 0) {
            z zVar3 = this.dIy.get(0);
            if (zVar3 != null) {
                nl(zVar3.dEk);
                lF(zVar3.name);
                if (this.dCS != null && this.dCS.atY() != null) {
                    this.dCS.atY().nH(zVar3.dEk);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dIy.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                zVar2 = this.dIy.get(i2);
                if (zVar2 == null || zVar2.dEk != i) {
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
                lF(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            z zVar4 = this.dIy.get(0);
            if (zVar4 != null) {
                nl(zVar4.dEk);
                lF(zVar4.name);
                if (this.dCS != null && this.dCS.atY() != null) {
                    this.dCS.atY().nH(zVar4.dEk);
                }
            }
        } else if (zVar != null) {
            nl(zVar.dEk);
            lF(zVar.name);
            if (this.dCS != null && this.dCS.atY() != null) {
                this.dCS.atY().nH(zVar.dEk);
            }
        }
    }

    private boolean bl(List<FrsTabInfo> list) {
        if (!v.E(this.dIy) && v.D(list) == v.D(this.dIy)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dIy.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void awH() {
        if (this.dIx != null) {
            this.dIx.setVisibility(0);
        }
    }

    public void awI() {
        if (this.dIx != null) {
            this.dIx.setVisibility(8);
        }
    }

    public void resetData() {
        this.dIy = null;
    }
}

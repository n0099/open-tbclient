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
    private String cWM;
    private i dCx;
    private TextView dIc;
    private List<z> dId;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dIe;
    private int dIf = -1;
    private boolean dIg = false;
    private View.OnClickListener dIh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ow()) {
                a.this.dCx.showToast(d.j.neterror);
                return;
            }
            if (a.this.dIe == null) {
                a.this.dIe = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dCx, a.this.dIi);
            }
            a.this.dIe.setData(a.this.dId);
            a.this.dIe.d(a.this.dCx.getPageContext()).AD();
        }
    };
    private b.InterfaceC0073b dIi = new b.InterfaceC0073b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
        public void a(b bVar, int i, View view) {
            if (!j.ow()) {
                a.this.dCx.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            z zVar = (z) v.f(a.this.dIe.awE(), i);
            if (zVar != null) {
                if (a.this.dIf != zVar.dDP) {
                    a.this.dIg = true;
                    a.this.dIc.setText(zVar.name);
                    if (a.this.dIf == 7) {
                        ak akVar = new ak("c11437");
                        akVar.s("obj_locate", zVar.dDP);
                        akVar.ab(ImageViewerConfig.FORUM_ID, a.this.cWM);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.dCx.atT() != null) {
                        a.this.dCx.atT().nI(a.this.dIf);
                        a.this.dIf = zVar.dDP;
                        bVar.dismiss();
                        if (a.this.dIf != 7) {
                            t.OH();
                            f.bwH();
                        } else {
                            f.bwG();
                        }
                        if (a.this.dCx.atT() != null && a.this.dCx.atY() != null) {
                            a.this.dCx.atT().nH(zVar.dDP);
                            a.this.dCx.atY().startPullRefresh();
                            a.this.dCx.atT().gc(true);
                            com.baidu.tieba.frs.smartsort.d.ayF().h(a.this.dCx.atT().getForumName(), zVar.dDP, zVar.name);
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
        this.cWM = str;
    }

    public TextView awB() {
        return this.dIc;
    }

    public void ly(String str) {
        this.dIc.setText(str);
    }

    public void nl(int i) {
        this.dIf = i;
    }

    public a(i iVar, RelativeLayout relativeLayout) {
        if (iVar != null && relativeLayout != null) {
            this.dCx = iVar;
            this.mRootView = relativeLayout;
            this.dIc = new TextView(iVar.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.s(TbadkCoreApplication.getInst(), d.e.tbds104));
            layoutParams.addRule(15);
            this.dIc.setPadding(l.s(iVar.getActivity(), d.e.tbds30), 0, l.s(iVar.getActivity(), d.e.tbds44), 0);
            this.dIc.setGravity(17);
            this.dIc.setTextSize(0, l.s(iVar.getActivity(), d.e.ds28));
            this.dIc.setCompoundDrawablePadding(l.s(iVar.getActivity(), d.e.tbds20));
            this.dIc.setOnClickListener(this.dIh);
            this.mRootView.addView(this.dIc, layoutParams);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dIc != null) {
            aj.r(this.dIc, d.C0107d.cp_cont_j);
            aj.t(this.dIc, d.C0107d.transparent);
            this.dIc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.E(list)) {
            awD();
        } else if (this.dCx != null && this.dCx.atT() != null && this.dCx.atT().ayl()) {
            awC();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bl(arrayList)) {
                if (!this.dIg) {
                    nm(i);
                    return;
                }
                return;
            }
            this.dId = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    z zVar = new z();
                    zVar.dDP = frsTabInfo.tab_id.intValue();
                    zVar.name = frsTabInfo.tab_name;
                    this.dId.add(zVar);
                }
            }
            if (!this.dIg) {
                nm(i);
            }
        } else {
            awD();
        }
    }

    private void nm(int i) {
        z zVar;
        boolean z;
        z zVar2 = null;
        if (i <= 0) {
            z zVar3 = this.dId.get(0);
            if (zVar3 != null) {
                nl(zVar3.dDP);
                ly(zVar3.name);
                if (this.dCx != null && this.dCx.atT() != null) {
                    this.dCx.atT().nH(zVar3.dDP);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dId.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                zVar2 = this.dId.get(i2);
                if (zVar2 == null || zVar2.dDP != i) {
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
                ly(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            z zVar4 = this.dId.get(0);
            if (zVar4 != null) {
                nl(zVar4.dDP);
                ly(zVar4.name);
                if (this.dCx != null && this.dCx.atT() != null) {
                    this.dCx.atT().nH(zVar4.dDP);
                }
            }
        } else if (zVar != null) {
            nl(zVar.dDP);
            ly(zVar.name);
            if (this.dCx != null && this.dCx.atT() != null) {
                this.dCx.atT().nH(zVar.dDP);
            }
        }
    }

    private boolean bl(List<FrsTabInfo> list) {
        if (!v.E(this.dId) && v.D(list) == v.D(this.dId)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dId.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void awC() {
        if (this.dIc != null) {
            this.dIc.setVisibility(0);
        }
    }

    public void awD() {
        if (this.dIc != null) {
            this.dIc.setVisibility(8);
        }
    }

    public void resetData() {
        this.dId = null;
    }
}

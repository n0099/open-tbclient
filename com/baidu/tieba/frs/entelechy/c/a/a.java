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
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private String aAn;
    private f cIp;
    private TextView cOw;
    private List<y> cOx;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cOy;
    private ViewGroup mRootView;
    private int cOz = -1;
    private boolean cOA = false;
    private View.OnClickListener cOB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.gV()) {
                a.this.cIp.showToast(d.j.neterror);
                return;
            }
            if (a.this.cOy == null) {
                a.this.cOy = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.cIp, a.this.cOC);
            }
            a.this.cOy.setData(a.this.cOx);
            a.this.cOy.d(a.this.cIp.getPageContext()).to();
        }
    };
    private b.InterfaceC0047b cOC = new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(b bVar, int i, View view) {
            if (!j.gV()) {
                a.this.cIp.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            y yVar = (y) v.c(a.this.cOy.anT(), i);
            if (yVar != null) {
                if (a.this.cOz != yVar.cJT) {
                    a.this.cOA = true;
                    a.this.cOw.setText(yVar.name);
                    if (a.this.cOz == 7) {
                        ak akVar = new ak("c11437");
                        akVar.r("obj_locate", yVar.cJT);
                        akVar.ac(ImageViewerConfig.FORUM_ID, a.this.aAn);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.cIp.akZ() != null) {
                        a.this.cIp.akZ().kH(a.this.cOz);
                        a.this.cOz = yVar.cJT;
                        bVar.dismiss();
                        if (a.this.cOz != 7) {
                            t.Ht();
                            com.baidu.tieba.tbadkCore.util.f.bxn();
                        } else {
                            com.baidu.tieba.tbadkCore.util.f.bxm();
                        }
                        if (a.this.cIp.akZ() != null && a.this.cIp.ale() != null) {
                            a.this.cIp.akZ().kG(yVar.cJT);
                            a.this.cIp.ale().startPullRefresh();
                            a.this.cIp.akZ().fx(true);
                            com.baidu.tieba.frs.smartsort.d.aqi().h(a.this.cIp.akZ().getForumName(), yVar.cJT, yVar.name);
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
        this.aAn = str;
    }

    public TextView anQ() {
        return this.cOw;
    }

    public void lj(String str) {
        this.cOw.setText(str);
    }

    public void ki(int i) {
        this.cOz = i;
    }

    public a(f fVar, RelativeLayout relativeLayout) {
        if (fVar != null && relativeLayout != null) {
            this.cIp = fVar;
            this.mRootView = relativeLayout;
            this.cOw = new TextView(fVar.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.f(TbadkCoreApplication.getInst(), d.e.tbds104));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            int f = l.f(fVar.getActivity(), d.e.ds30);
            this.cOw.setPadding(f, 0, f, 0);
            this.cOw.setGravity(17);
            this.cOw.setTextSize(0, l.f(fVar.getActivity(), d.e.ds28));
            this.cOw.setCompoundDrawablePadding(l.f(fVar.getActivity(), d.e.tbds20));
            this.cOw.setOnClickListener(this.cOB);
            this.mRootView.addView(this.cOw, layoutParams);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.cOw != null) {
            aj.i(this.cOw, d.C0082d.cp_cont_j);
            aj.k(this.cOw, d.C0082d.transparent);
            this.cOw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.w(list)) {
            anS();
        } else if (this.cIp != null && this.cIp.akZ() != null && this.cIp.akZ().apN()) {
            anR();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!ba(arrayList)) {
                if (!this.cOA) {
                    kj(i);
                    return;
                }
                return;
            }
            this.cOx = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    y yVar = new y();
                    yVar.cJT = frsTabInfo.tab_id.intValue();
                    yVar.name = frsTabInfo.tab_name;
                    this.cOx.add(yVar);
                }
            }
            if (!this.cOA) {
                kj(i);
            }
        } else {
            anS();
        }
    }

    private void kj(int i) {
        y yVar;
        boolean z;
        y yVar2 = null;
        if (i <= 0) {
            y yVar3 = this.cOx.get(0);
            if (yVar3 != null) {
                ki(yVar3.cJT);
                lj(yVar3.name);
                if (this.cIp != null && this.cIp.akZ() != null) {
                    this.cIp.akZ().kG(yVar3.cJT);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cOx.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                yVar2 = this.cOx.get(i2);
                if (yVar2 == null || yVar2.cJT != i) {
                    i2++;
                } else {
                    yVar = yVar2;
                    z = true;
                    break;
                }
            } else {
                yVar = yVar2;
                z = false;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                lj(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            y yVar4 = this.cOx.get(0);
            if (yVar4 != null) {
                ki(yVar4.cJT);
                lj(yVar4.name);
                if (this.cIp != null && this.cIp.akZ() != null) {
                    this.cIp.akZ().kG(yVar4.cJT);
                }
            }
        } else if (yVar != null) {
            ki(yVar.cJT);
            lj(yVar.name);
            if (this.cIp != null && this.cIp.akZ() != null) {
                this.cIp.akZ().kG(yVar.cJT);
            }
        }
    }

    private boolean ba(List<FrsTabInfo> list) {
        if (!v.w(this.cOx) && v.v(list) == v.v(this.cOx)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cOx.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void anR() {
        if (this.cOw != null) {
            this.cOw.setVisibility(0);
        }
    }

    public void anS() {
        if (this.cOw != null) {
            this.cOw.setVisibility(8);
        }
    }
}

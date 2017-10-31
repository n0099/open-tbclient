package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.baidu.tieba.frs.y;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private String azE;
    private TextView cEX;
    private List<y> cEY;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cEZ;
    private int cFa = -1;
    private boolean cFb = false;
    private View.OnClickListener cFc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.gV()) {
                a.this.cyR.showToast(d.j.neterror);
                return;
            }
            if (a.this.cEZ == null) {
                a.this.cEZ = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.cyR, a.this.cFd);
            }
            a.this.cEZ.setData(a.this.cEY);
            a.this.cEZ.d(a.this.cyR.getPageContext()).tl();
        }
    };
    private b.InterfaceC0047b cFd = new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(b bVar, int i, View view) {
            if (!j.gV()) {
                a.this.cyR.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            y yVar = (y) v.c(a.this.cEZ.alK(), i);
            if (yVar != null) {
                if (a.this.cFa != yVar.cAw) {
                    a.this.cFb = true;
                    a.this.cEX.setText(yVar.name);
                    if (a.this.cFa == 7) {
                        ak akVar = new ak("c11437");
                        akVar.r("obj_locate", yVar.cAw);
                        akVar.ac(ImageViewerConfig.FORUM_ID, a.this.azE);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.cyR.aiR() != null) {
                        a.this.cyR.aiR().kj(a.this.cFa);
                        a.this.cFa = yVar.cAw;
                        bVar.dismiss();
                        if (a.this.cFa != 7) {
                            t.Hb();
                            f.bvr();
                        } else {
                            f.bvq();
                        }
                        if (a.this.cyR.aiR() != null && a.this.cyR.aiW() != null) {
                            a.this.cyR.aiR().ki(yVar.cAw);
                            a.this.cyR.aiW().startPullRefresh();
                            a.this.cyR.aiR().fb(true);
                            com.baidu.tieba.frs.smartsort.d.anZ().h(a.this.cyR.aiR().getForumName(), yVar.cAw, yVar.name);
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
    private com.baidu.tieba.frs.f cyR;
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.azE = str;
    }

    public TextView alH() {
        return this.cEX;
    }

    public void kZ(String str) {
        this.cEX.setText(str);
    }

    public void jL(int i) {
        this.cFa = i;
    }

    public a(com.baidu.tieba.frs.f fVar, ViewGroup viewGroup) {
        if (fVar != null && viewGroup != null) {
            this.cyR = fVar;
            this.mRootView = viewGroup;
            this.cEX = new TextView(fVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(TbadkCoreApplication.getInst(), d.e.ds82));
            layoutParams.topMargin = l.f(fVar.getActivity(), d.e.ds26);
            int f = l.f(fVar.getActivity(), d.e.ds30);
            this.cEX.setPadding(f, 0, f, 0);
            this.cEX.setGravity(17);
            this.cEX.setTextSize(0, l.f(fVar.getActivity(), d.e.ds28));
            this.cEX.setCompoundDrawablePadding(l.f(fVar.getActivity(), d.e.ds8));
            this.cEX.setLayoutParams(layoutParams);
            this.cEX.setOnClickListener(this.cFc);
            this.mRootView.addView(this.cEX);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cEX != null) {
            aj.i(this.cEX, d.C0080d.cp_cont_f);
            aj.k(this.cEX, d.C0080d.transparent);
            this.cEX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void j(List<FrsTabInfo> list, int i) {
        if (v.v(list)) {
            alJ();
        } else if (this.cyR != null && this.cyR.aiR() != null && this.cyR.aiR().anE()) {
            alI();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!aO(arrayList)) {
                if (!this.cFb) {
                    jM(i);
                    return;
                }
                return;
            }
            this.cEY = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    y yVar = new y();
                    yVar.cAw = frsTabInfo.tab_id.intValue();
                    yVar.name = frsTabInfo.tab_name;
                    this.cEY.add(yVar);
                }
            }
            if (!this.cFb) {
                jM(i);
            }
        } else {
            alJ();
        }
    }

    private void jM(int i) {
        y yVar;
        boolean z;
        y yVar2 = null;
        if (i <= 0) {
            y yVar3 = this.cEY.get(0);
            if (yVar3 != null) {
                jL(yVar3.cAw);
                kZ(yVar3.name);
                if (this.cyR != null && this.cyR.aiR() != null) {
                    this.cyR.aiR().ki(yVar3.cAw);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cEY.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                yVar2 = this.cEY.get(i2);
                if (yVar2 == null || yVar2.cAw != i) {
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
                kZ(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            y yVar4 = this.cEY.get(0);
            if (yVar4 != null) {
                jL(yVar4.cAw);
                kZ(yVar4.name);
                if (this.cyR != null && this.cyR.aiR() != null) {
                    this.cyR.aiR().ki(yVar4.cAw);
                }
            }
        } else if (yVar != null) {
            jL(yVar.cAw);
            kZ(yVar.name);
            if (this.cyR != null && this.cyR.aiR() != null) {
                this.cyR.aiR().ki(yVar.cAw);
            }
        }
    }

    private boolean aO(List<FrsTabInfo> list) {
        if (!v.v(this.cEY) && v.u(list) == v.u(this.cEY)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cEY.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void alI() {
        if (this.cEX != null) {
            this.cEX.setVisibility(0);
        }
    }

    public void alJ() {
        if (this.cEX != null) {
            this.cEX.setVisibility(8);
        }
    }
}

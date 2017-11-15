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
    private String azM;
    private TextView cFq;
    private List<y> cFr;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cFs;
    private int cFt = -1;
    private boolean cFu = false;
    private View.OnClickListener cFv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.gV()) {
                a.this.czk.showToast(d.j.neterror);
                return;
            }
            if (a.this.cFs == null) {
                a.this.cFs = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.czk, a.this.cFw);
            }
            a.this.cFs.setData(a.this.cFr);
            a.this.cFs.d(a.this.czk.getPageContext()).tl();
        }
    };
    private b.InterfaceC0047b cFw = new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
        public void a(b bVar, int i, View view) {
            if (!j.gV()) {
                a.this.czk.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            y yVar = (y) v.c(a.this.cFs.alY(), i);
            if (yVar != null) {
                if (a.this.cFt != yVar.cAP) {
                    a.this.cFu = true;
                    a.this.cFq.setText(yVar.name);
                    if (a.this.cFt == 7) {
                        ak akVar = new ak("c11437");
                        akVar.r("obj_locate", yVar.cAP);
                        akVar.ac(ImageViewerConfig.FORUM_ID, a.this.azM);
                        TiebaStatic.log(akVar);
                    }
                    if (a.this.czk.ajf() != null) {
                        a.this.czk.ajf().kj(a.this.cFt);
                        a.this.cFt = yVar.cAP;
                        bVar.dismiss();
                        if (a.this.cFt != 7) {
                            t.Hm();
                            f.bvD();
                        } else {
                            f.bvC();
                        }
                        if (a.this.czk.ajf() != null && a.this.czk.ajk() != null) {
                            a.this.czk.ajf().ki(yVar.cAP);
                            a.this.czk.ajk().startPullRefresh();
                            a.this.czk.ajf().fg(true);
                            com.baidu.tieba.frs.smartsort.d.aoo().h(a.this.czk.ajf().getForumName(), yVar.cAP, yVar.name);
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
    private com.baidu.tieba.frs.f czk;
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.azM = str;
    }

    public TextView alV() {
        return this.cFq;
    }

    public void la(String str) {
        this.cFq.setText(str);
    }

    public void jK(int i) {
        this.cFt = i;
    }

    public a(com.baidu.tieba.frs.f fVar, ViewGroup viewGroup) {
        if (fVar != null && viewGroup != null) {
            this.czk = fVar;
            this.mRootView = viewGroup;
            this.cFq = new TextView(fVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(TbadkCoreApplication.getInst(), d.e.ds82));
            layoutParams.topMargin = l.f(fVar.getActivity(), d.e.ds26);
            int f = l.f(fVar.getActivity(), d.e.ds30);
            this.cFq.setPadding(f, 0, f, 0);
            this.cFq.setGravity(17);
            this.cFq.setTextSize(0, l.f(fVar.getActivity(), d.e.ds28));
            this.cFq.setCompoundDrawablePadding(l.f(fVar.getActivity(), d.e.ds8));
            this.cFq.setLayoutParams(layoutParams);
            this.cFq.setOnClickListener(this.cFv);
            this.mRootView.addView(this.cFq);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cFq != null) {
            aj.i(this.cFq, d.C0080d.cp_cont_f);
            aj.k(this.cFq, d.C0080d.transparent);
            this.cFq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void j(List<FrsTabInfo> list, int i) {
        if (v.v(list)) {
            alX();
        } else if (this.czk != null && this.czk.ajf() != null && this.czk.ajf().anT()) {
            alW();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!aO(arrayList)) {
                if (!this.cFu) {
                    jL(i);
                    return;
                }
                return;
            }
            this.cFr = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    y yVar = new y();
                    yVar.cAP = frsTabInfo.tab_id.intValue();
                    yVar.name = frsTabInfo.tab_name;
                    this.cFr.add(yVar);
                }
            }
            if (!this.cFu) {
                jL(i);
            }
        } else {
            alX();
        }
    }

    private void jL(int i) {
        y yVar;
        boolean z;
        y yVar2 = null;
        if (i <= 0) {
            y yVar3 = this.cFr.get(0);
            if (yVar3 != null) {
                jK(yVar3.cAP);
                la(yVar3.name);
                if (this.czk != null && this.czk.ajf() != null) {
                    this.czk.ajf().ki(yVar3.cAP);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cFr.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                yVar2 = this.cFr.get(i2);
                if (yVar2 == null || yVar2.cAP != i) {
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
                la(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            y yVar4 = this.cFr.get(0);
            if (yVar4 != null) {
                jK(yVar4.cAP);
                la(yVar4.name);
                if (this.czk != null && this.czk.ajf() != null) {
                    this.czk.ajf().ki(yVar4.cAP);
                }
            }
        } else if (yVar != null) {
            jK(yVar.cAP);
            la(yVar.name);
            if (this.czk != null && this.czk.ajf() != null) {
                this.czk.ajf().ki(yVar.cAP);
            }
        }
    }

    private boolean aO(List<FrsTabInfo> list) {
        if (!v.v(this.cFr) && v.u(list) == v.u(this.cFr)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cFr.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void alW() {
        if (this.cFq != null) {
            this.cFq.setVisibility(0);
        }
    }

    public void alX() {
        if (this.cFq != null) {
            this.cFq.setVisibility(8);
        }
    }
}

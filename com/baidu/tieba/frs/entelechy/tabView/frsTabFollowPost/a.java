package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.model.GetFrsTabFollowPostNumRequest;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup Sb;
    private FrsActivity bKb;
    private TextView bKc;
    private List<dc> bKd;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.a bKe;
    private GetFrsTabFollowPostNumRequest bKh;
    private int bKf = -1;
    private boolean bKg = false;
    private View.OnClickListener bKi = new b(this);
    private c.b bKj = new c(this);

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.bKb = frsActivity;
            this.Sb = viewGroup;
            this.bKc = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int c = k.c(frsActivity.getActivity(), u.e.ds30);
            this.bKc.setPadding(c, 0, c, 0);
            this.bKc.setGravity(17);
            this.bKc.setTextSize(0, k.c(frsActivity.getActivity(), u.e.ds28));
            this.bKc.setCompoundDrawablePadding(k.c(frsActivity.getActivity(), u.e.ds20));
            this.bKc.setLayoutParams(layoutParams);
            this.bKc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(u.f.icon_frs_arrow_selector), (Drawable) null);
            this.bKc.setOnClickListener(this.bKi);
            this.Sb.addView(this.bKc);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public int Yi() {
        return this.bKf;
    }

    public void onChangeSkinType(int i) {
        if (this.bKc != null) {
            av.j((View) this.bKc, u.d.cp_cont_c);
            av.l(this.bKc, u.d.cp_bg_line_d);
            this.bKc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(u.f.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void h(List<FrsTabInfo> list, int i) {
        if (y.t(list)) {
            Yk();
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList != null) {
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
        }
        if (!ar(arrayList)) {
            if (!this.bKg) {
                hC(i);
                return;
            }
            return;
        }
        this.bKd = new ArrayList();
        for (FrsTabInfo frsTabInfo : arrayList) {
            if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                dc dcVar = new dc();
                dcVar.bGN = frsTabInfo.tab_id.intValue();
                dcVar.name = frsTabInfo.tab_name;
                this.bKd.add(dcVar);
            }
        }
        if (!this.bKg) {
            hC(i);
        }
    }

    private void hC(int i) {
        dc dcVar;
        boolean z;
        dc dcVar2 = null;
        if (i <= 0) {
            dc dcVar3 = this.bKd.get(0);
            if (dcVar3 != null) {
                jb(dcVar3.name);
                return;
            }
            return;
        }
        int size = this.bKd.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dcVar = dcVar2;
                z = false;
                break;
            }
            dcVar2 = this.bKd.get(i2);
            if (dcVar2 == null || dcVar2.bGN != i) {
                i2++;
            } else {
                dcVar = dcVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                jb(TbadkCoreApplication.m9getInst().getResources().getString(u.j.attention_users_thread));
                return;
            }
            dc dcVar4 = this.bKd.get(0);
            if (dcVar4 != null) {
                jb(dcVar4.name);
                return;
            }
            return;
        }
        jb(dcVar.name);
    }

    private void jb(String str) {
        this.bKc.setText(str);
    }

    private boolean ar(List<FrsTabInfo> list) {
        dc dcVar;
        if (!y.t(this.bKd) && y.s(list) == y.s(this.bKd)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && (dcVar = this.bKd.get(i)) != null && dcVar.bGN != dcVar.bGN) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void Yj() {
        if (this.bKc != null) {
            this.bKc.setVisibility(0);
        }
    }

    public void Yk() {
        if (this.bKc != null) {
            this.bKc.setVisibility(8);
        }
    }

    public View Yc() {
        return this.bKc;
    }
}

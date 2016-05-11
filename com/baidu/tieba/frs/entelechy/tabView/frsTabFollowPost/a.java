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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.em;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.model.GetFrsTabFollowPostNumRequest;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup RI;
    private FrsActivity bpt;
    private TextView bpu;
    private List<em> bpv;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.a bpw;
    private GetFrsTabFollowPostNumRequest bpy;
    private int bpx = -1;
    private View.OnClickListener bpz = new b(this);
    private c.b bpA = new c(this);

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.bpt = frsActivity;
            this.RI = viewGroup;
            this.bpu = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int c = k.c(frsActivity.getActivity(), t.e.ds30);
            this.bpu.setPadding(c, 0, c, 0);
            this.bpu.setGravity(17);
            this.bpu.setTextSize(0, k.c(frsActivity.getActivity(), t.e.ds28));
            this.bpu.setCompoundDrawablePadding(k.c(frsActivity.getActivity(), t.e.ds20));
            this.bpu.setLayoutParams(layoutParams);
            this.bpu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, at.getDrawable(t.f.icon_frs_arrow_selector), (Drawable) null);
            this.bpu.setOnClickListener(this.bpz);
            this.RI.addView(this.bpu);
            onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    public int SH() {
        return this.bpx;
    }

    public void onChangeSkinType(int i) {
        if (this.bpu != null) {
            at.j((View) this.bpu, t.d.cp_cont_c);
            at.l(this.bpu, t.d.cp_bg_line_d);
            this.bpu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, at.getDrawable(t.f.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (y.s(list)) {
            SJ();
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
        if (ag(arrayList)) {
            this.bpv = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    em emVar = new em();
                    emVar.blZ = frsTabInfo.tab_id.intValue();
                    emVar.name = frsTabInfo.tab_name;
                    this.bpv.add(emVar);
                }
            }
            em emVar2 = this.bpv.get(0);
            if (emVar2 != null) {
                this.bpu.setText(emVar2.name);
            }
        }
    }

    private boolean ag(List<FrsTabInfo> list) {
        em emVar;
        if (!y.s(this.bpv) && y.r(list) == y.r(this.bpv)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && (emVar = this.bpv.get(i)) != null && emVar.blZ != emVar.blZ) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void SI() {
        if (this.bpu != null) {
            this.bpu.setVisibility(0);
        }
    }

    public void SJ() {
        if (this.bpu != null) {
            this.bpu.setVisibility(8);
        }
    }
}

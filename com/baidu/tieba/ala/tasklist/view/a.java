package com.baidu.tieba.ala.tasklist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.p;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private AlaTaskListActivity eDd;
    private int eDe = -1;
    private ArrayList<p> bbZ = new ArrayList<>();

    public a(AlaTaskListActivity alaTaskListActivity) {
        this.eDd = alaTaskListActivity;
    }

    public void setData(ArrayList<p> arrayList) {
        if (arrayList != null) {
            this.bbZ.clear();
            this.bbZ.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbZ == null) {
            return 0;
        }
        return this.bbZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oq */
    public p getItem(int i) {
        if (this.bbZ == null) {
            return null;
        }
        return this.bbZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0390a c0390a;
        if (view == null) {
            view = LayoutInflater.from(this.eDd.getPageContext().getPageActivity()).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
            c0390a = new C0390a(view);
            view.setTag(c0390a);
        } else {
            c0390a = (C0390a) view.getTag();
        }
        a(c0390a, getItem(i));
        return view;
    }

    private void a(C0390a c0390a, final p pVar) {
        if (pVar != null) {
            c0390a.eDh.setText(pVar.Sv);
            c0390a.eDi.setText(pVar.SA);
            c0390a.eDj.setText(this.eDd.getPageContext().getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(pVar.Sz)));
            if (pVar.status == 3) {
                c0390a.eDj.setVisibility(8);
            } else {
                c0390a.eDj.setVisibility(0);
            }
            c0390a.eDk.setTag(Integer.valueOf(pVar.Su));
            if (pVar.status == 2) {
                b(c0390a);
            } else if (pVar.status == 3) {
                a(c0390a, this.eDd.getPageContext().getString(a.i.ala_task_status_success));
            } else {
                b(c0390a, pVar);
            }
            c0390a.eDk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (pVar.status == 2) {
                        a.this.eDd.oo(pVar.Su);
                    }
                }
            });
        }
    }

    private void b(C0390a c0390a, p pVar) {
        String string;
        if (pVar.op()) {
            if (this.eDe < 0) {
                if (pVar.Sy != null) {
                    this.eDe = pVar.Sy.SD;
                }
                a(c0390a);
                return;
            } else if (this.eDe == 0) {
                b(c0390a);
                return;
            } else {
                a(c0390a);
                return;
            }
        }
        if (pVar.oq()) {
            string = this.eDd.getPageContext().getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(pVar.Sy.SF));
        } else {
            string = this.eDd.getPageContext().getString(a.i.ala_task_status_not_over);
        }
        a(c0390a, string);
    }

    private void a(C0390a c0390a) {
        c0390a.eDk.setText(StringHelper.formatSecondsTime(this.eDe * 1000));
        c0390a.eDk.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        c0390a.eDk.setTextColor(this.eDd.getPageContext().getResources().getColor(a.d.sdk_common_color_10260));
        b(c0390a.eDk, true);
    }

    private void a(C0390a c0390a, String str) {
        c0390a.eDk.setText(str);
        c0390a.eDk.setBackgroundResource(a.f.sdk_transparent_bg);
        c0390a.eDk.setTextColor(this.eDd.getPageContext().getResources().getColor(a.d.sdk_cp_cont_d));
        b(c0390a.eDk, false);
    }

    private void b(C0390a c0390a) {
        c0390a.eDk.setText(this.eDd.getPageContext().getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            c0390a.eDk.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            c0390a.eDk.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            c0390a.eDk.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            c0390a.eDk.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        c0390a.eDk.setTextColor(this.eDd.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
        b(c0390a.eDk, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.eDd.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.eDd.getResources().getDimension(a.e.sdk_ds50);
            textView.setGravity(17);
            textView.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        textView.setGravity(21);
        textView.setLayoutParams(layoutParams2);
    }

    public void c(Integer num) {
        this.eDe = num.intValue();
        p ot = ot();
        if (ot != null) {
            if (this.eDe == 0) {
                ot.status = 2;
            } else if (this.eDe > 0) {
                ot.status = 1;
            } else {
                ot.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public p ot() {
        if (!ListUtils.isEmpty(this.bbZ)) {
            Iterator<p> it = this.bbZ.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next.op()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.ala.tasklist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0390a {
        public View cfY;
        public TextView eDh;
        public TextView eDi;
        public TextView eDj;
        public TextView eDk;
        public View rootView;

        public C0390a(View view) {
            this.rootView = view;
            this.eDh = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.eDi = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.eDj = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.eDk = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.cfY = view.findViewById(a.g.divider);
        }
    }
}

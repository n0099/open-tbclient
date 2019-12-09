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
    private AlaTaskListActivity eCm;
    private int eCn = -1;
    private ArrayList<p> bbH = new ArrayList<>();

    public a(AlaTaskListActivity alaTaskListActivity) {
        this.eCm = alaTaskListActivity;
    }

    public void setData(ArrayList<p> arrayList) {
        if (arrayList != null) {
            this.bbH.clear();
            this.bbH.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbH == null) {
            return 0;
        }
        return this.bbH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: op */
    public p getItem(int i) {
        if (this.bbH == null) {
            return null;
        }
        return this.bbH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0385a c0385a;
        if (view == null) {
            view = LayoutInflater.from(this.eCm.getPageContext().getPageActivity()).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
            c0385a = new C0385a(view);
            view.setTag(c0385a);
        } else {
            c0385a = (C0385a) view.getTag();
        }
        a(c0385a, getItem(i));
        return view;
    }

    private void a(C0385a c0385a, final p pVar) {
        if (pVar != null) {
            c0385a.eCq.setText(pVar.Sc);
            c0385a.eCr.setText(pVar.Sh);
            c0385a.eCs.setText(this.eCm.getPageContext().getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(pVar.Sg)));
            if (pVar.status == 3) {
                c0385a.eCs.setVisibility(8);
            } else {
                c0385a.eCs.setVisibility(0);
            }
            c0385a.eCt.setTag(Integer.valueOf(pVar.Sb));
            if (pVar.status == 2) {
                b(c0385a);
            } else if (pVar.status == 3) {
                a(c0385a, this.eCm.getPageContext().getString(a.i.ala_task_status_success));
            } else {
                b(c0385a, pVar);
            }
            c0385a.eCt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (pVar.status == 2) {
                        a.this.eCm.on(pVar.Sb);
                    }
                }
            });
        }
    }

    private void b(C0385a c0385a, p pVar) {
        String string;
        if (pVar.op()) {
            if (this.eCn < 0) {
                if (pVar.Sf != null) {
                    this.eCn = pVar.Sf.Sk;
                }
                a(c0385a);
                return;
            } else if (this.eCn == 0) {
                b(c0385a);
                return;
            } else {
                a(c0385a);
                return;
            }
        }
        if (pVar.oq()) {
            string = this.eCm.getPageContext().getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(pVar.Sf.Sl));
        } else {
            string = this.eCm.getPageContext().getString(a.i.ala_task_status_not_over);
        }
        a(c0385a, string);
    }

    private void a(C0385a c0385a) {
        c0385a.eCt.setText(StringHelper.formatSecondsTime(this.eCn * 1000));
        c0385a.eCt.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        c0385a.eCt.setTextColor(this.eCm.getPageContext().getResources().getColor(a.d.sdk_common_color_10260));
        b(c0385a.eCt, true);
    }

    private void a(C0385a c0385a, String str) {
        c0385a.eCt.setText(str);
        c0385a.eCt.setBackgroundResource(a.f.sdk_transparent_bg);
        c0385a.eCt.setTextColor(this.eCm.getPageContext().getResources().getColor(a.d.sdk_cp_cont_d));
        b(c0385a.eCt, false);
    }

    private void b(C0385a c0385a) {
        c0385a.eCt.setText(this.eCm.getPageContext().getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            c0385a.eCt.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            c0385a.eCt.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            c0385a.eCt.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            c0385a.eCt.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        c0385a.eCt.setTextColor(this.eCm.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
        b(c0385a.eCt, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.eCm.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.eCm.getResources().getDimension(a.e.sdk_ds50);
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
        this.eCn = num.intValue();
        p ot = ot();
        if (ot != null) {
            if (this.eCn == 0) {
                ot.status = 2;
            } else if (this.eCn > 0) {
                ot.status = 1;
            } else {
                ot.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public p ot() {
        if (!ListUtils.isEmpty(this.bbH)) {
            Iterator<p> it = this.bbH.iterator();
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
    public static class C0385a {
        public View cfh;
        public TextView eCq;
        public TextView eCr;
        public TextView eCs;
        public TextView eCt;
        public View rootView;

        public C0385a(View view) {
            this.rootView = view;
            this.eCq = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.eCr = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.eCs = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.eCt = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.cfh = view.findViewById(a.g.divider);
        }
    }
}

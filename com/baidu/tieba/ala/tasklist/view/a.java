package com.baidu.tieba.ala.tasklist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private AlaTaskListActivity fAA;
    private int fAB = -1;
    private ArrayList<u> cWf = new ArrayList<>();

    public a(AlaTaskListActivity alaTaskListActivity) {
        this.fAA = alaTaskListActivity;
    }

    public void setData(ArrayList<u> arrayList) {
        if (arrayList != null) {
            this.cWf.clear();
            this.cWf.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cWf == null) {
            return 0;
        }
        return this.cWf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qX */
    public u getItem(int i) {
        if (this.cWf == null) {
            return null;
        }
        return this.cWf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0486a c0486a;
        if (view == null) {
            view = LayoutInflater.from(this.fAA.getPageContext().getPageActivity()).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
            c0486a = new C0486a(view);
            view.setTag(c0486a);
        } else {
            c0486a = (C0486a) view.getTag();
        }
        a(c0486a, getItem(i));
        return view;
    }

    private void a(C0486a c0486a, final u uVar) {
        if (uVar != null) {
            c0486a.fAE.setText(uVar.abi);
            c0486a.fAF.setText(uVar.abn);
            c0486a.fAG.setText(this.fAA.getPageContext().getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(uVar.abm)));
            if (uVar.status == 3) {
                c0486a.fAG.setVisibility(8);
            } else {
                c0486a.fAG.setVisibility(0);
            }
            c0486a.fAH.setTag(Integer.valueOf(uVar.abh));
            if (uVar.status == 2) {
                b(c0486a);
            } else if (uVar.status == 3) {
                a(c0486a, this.fAA.getPageContext().getString(a.i.ala_task_status_success));
            } else {
                b(c0486a, uVar);
            }
            c0486a.fAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (uVar.status == 2) {
                        a.this.fAA.qV(uVar.abh);
                    }
                }
            });
        }
    }

    private void b(C0486a c0486a, u uVar) {
        String string;
        if (uVar.qE()) {
            if (this.fAB < 0) {
                if (uVar.abl != null) {
                    this.fAB = uVar.abl.abq;
                }
                a(c0486a);
                return;
            } else if (this.fAB == 0) {
                b(c0486a);
                return;
            } else {
                a(c0486a);
                return;
            }
        }
        if (uVar.qF()) {
            string = this.fAA.getPageContext().getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(uVar.abl.abr));
        } else {
            string = this.fAA.getPageContext().getString(a.i.ala_task_status_not_over);
        }
        a(c0486a, string);
    }

    private void a(C0486a c0486a) {
        c0486a.fAH.setText(StringHelper.formatSecondsTime(this.fAB * 1000));
        c0486a.fAH.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        c0486a.fAH.setTextColor(this.fAA.getPageContext().getResources().getColor(a.d.sdk_common_color_10260));
        b(c0486a.fAH, true);
    }

    private void a(C0486a c0486a, String str) {
        c0486a.fAH.setText(str);
        c0486a.fAH.setBackgroundResource(a.f.sdk_transparent_bg);
        c0486a.fAH.setTextColor(this.fAA.getPageContext().getResources().getColor(a.d.sdk_cp_cont_d));
        b(c0486a.fAH, false);
    }

    private void b(C0486a c0486a) {
        c0486a.fAH.setText(this.fAA.getPageContext().getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            c0486a.fAH.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            c0486a.fAH.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            c0486a.fAH.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            c0486a.fAH.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        c0486a.fAH.setTextColor(this.fAA.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
        b(c0486a.fAH, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.fAA.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.fAA.getResources().getDimension(a.e.sdk_ds50);
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

    public void i(Integer num) {
        this.fAB = num.intValue();
        u qI = qI();
        if (qI != null) {
            if (this.fAB == 0) {
                qI.status = 2;
            } else if (this.fAB > 0) {
                qI.status = 1;
            } else {
                qI.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public u qI() {
        if (!ListUtils.isEmpty(this.cWf)) {
            Iterator<u> it = this.cWf.iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (next.qE()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.ala.tasklist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0486a {
        public View cWh;
        public TextView fAE;
        public TextView fAF;
        public TextView fAG;
        public TextView fAH;
        public View rootView;

        public C0486a(View view) {
            this.rootView = view;
            this.fAE = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.fAF = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.fAG = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.fAH = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.cWh = view.findViewById(a.g.divider);
        }
    }
}

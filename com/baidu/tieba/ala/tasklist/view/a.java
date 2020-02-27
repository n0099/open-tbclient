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
    private AlaTaskListActivity fzD;
    private int fzE = -1;
    private ArrayList<u> cVQ = new ArrayList<>();

    public a(AlaTaskListActivity alaTaskListActivity) {
        this.fzD = alaTaskListActivity;
    }

    public void setData(ArrayList<u> arrayList) {
        if (arrayList != null) {
            this.cVQ.clear();
            this.cVQ.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVQ == null) {
            return 0;
        }
        return this.cVQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qV */
    public u getItem(int i) {
        if (this.cVQ == null) {
            return null;
        }
        return this.cVQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0486a c0486a;
        if (view == null) {
            view = LayoutInflater.from(this.fzD.getPageContext().getPageActivity()).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
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
            c0486a.fzH.setText(uVar.aaX);
            c0486a.fzI.setText(uVar.abd);
            c0486a.fzJ.setText(this.fzD.getPageContext().getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(uVar.abb)));
            if (uVar.status == 3) {
                c0486a.fzJ.setVisibility(8);
            } else {
                c0486a.fzJ.setVisibility(0);
            }
            c0486a.fzK.setTag(Integer.valueOf(uVar.aaW));
            if (uVar.status == 2) {
                b(c0486a);
            } else if (uVar.status == 3) {
                a(c0486a, this.fzD.getPageContext().getString(a.i.ala_task_status_success));
            } else {
                b(c0486a, uVar);
            }
            c0486a.fzK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (uVar.status == 2) {
                        a.this.fzD.qT(uVar.aaW);
                    }
                }
            });
        }
    }

    private void b(C0486a c0486a, u uVar) {
        String string;
        if (uVar.qz()) {
            if (this.fzE < 0) {
                if (uVar.aba != null) {
                    this.fzE = uVar.aba.abg;
                }
                a(c0486a);
                return;
            } else if (this.fzE == 0) {
                b(c0486a);
                return;
            } else {
                a(c0486a);
                return;
            }
        }
        if (uVar.qA()) {
            string = this.fzD.getPageContext().getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(uVar.aba.abh));
        } else {
            string = this.fzD.getPageContext().getString(a.i.ala_task_status_not_over);
        }
        a(c0486a, string);
    }

    private void a(C0486a c0486a) {
        c0486a.fzK.setText(StringHelper.formatSecondsTime(this.fzE * 1000));
        c0486a.fzK.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        c0486a.fzK.setTextColor(this.fzD.getPageContext().getResources().getColor(a.d.sdk_common_color_10260));
        b(c0486a.fzK, true);
    }

    private void a(C0486a c0486a, String str) {
        c0486a.fzK.setText(str);
        c0486a.fzK.setBackgroundResource(a.f.sdk_transparent_bg);
        c0486a.fzK.setTextColor(this.fzD.getPageContext().getResources().getColor(a.d.sdk_cp_cont_d));
        b(c0486a.fzK, false);
    }

    private void b(C0486a c0486a) {
        c0486a.fzK.setText(this.fzD.getPageContext().getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            c0486a.fzK.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            c0486a.fzK.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            c0486a.fzK.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            c0486a.fzK.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        c0486a.fzK.setTextColor(this.fzD.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
        b(c0486a.fzK, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.fzD.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.fzD.getResources().getDimension(a.e.sdk_ds50);
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
        this.fzE = num.intValue();
        u qD = qD();
        if (qD != null) {
            if (this.fzE == 0) {
                qD.status = 2;
            } else if (this.fzE > 0) {
                qD.status = 1;
            } else {
                qD.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public u qD() {
        if (!ListUtils.isEmpty(this.cVQ)) {
            Iterator<u> it = this.cVQ.iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (next.qz()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.ala.tasklist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0486a {
        public View cVS;
        public TextView fzH;
        public TextView fzI;
        public TextView fzJ;
        public TextView fzK;
        public View rootView;

        public C0486a(View view) {
            this.rootView = view;
            this.fzH = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.fzI = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.fzJ = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.fzK = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.cVS = view.findViewById(a.g.divider);
        }
    }
}

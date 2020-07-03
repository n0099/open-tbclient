package com.baidu.tieba.ala.tasklist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private AlaTaskListActivity gGX;
    private int gGY = -1;
    private ArrayList<ab> dQf = new ArrayList<>();

    public a(AlaTaskListActivity alaTaskListActivity) {
        this.gGX = alaTaskListActivity;
    }

    public void setData(ArrayList<ab> arrayList) {
        if (arrayList != null) {
            this.dQf.clear();
            this.dQf.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQf == null) {
            return 0;
        }
        return this.dQf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: su */
    public ab getItem(int i) {
        if (this.dQf == null) {
            return null;
        }
        return this.dQf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0602a c0602a;
        if (view == null) {
            view = LayoutInflater.from(this.gGX.getPageContext().getPageActivity()).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
            c0602a = new C0602a(view);
            view.setTag(c0602a);
        } else {
            c0602a = (C0602a) view.getTag();
        }
        a(c0602a, getItem(i));
        return view;
    }

    private void a(C0602a c0602a, final ab abVar) {
        if (abVar != null) {
            c0602a.gHb.setText(abVar.aBc);
            c0602a.gHc.setText(abVar.aBh);
            c0602a.gHd.setText(this.gGX.getPageContext().getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(abVar.aBg)));
            if (abVar.status == 3) {
                c0602a.gHd.setVisibility(8);
            } else {
                c0602a.gHd.setVisibility(0);
            }
            c0602a.gHe.setTag(Integer.valueOf(abVar.aBb));
            if (abVar.status == 2) {
                b(c0602a);
            } else if (abVar.status == 3) {
                a(c0602a, this.gGX.getPageContext().getString(a.i.ala_task_status_success));
            } else {
                b(c0602a, abVar);
            }
            c0602a.gHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (abVar.status == 2) {
                        a.this.gGX.ss(abVar.aBb);
                    }
                }
            });
        }
    }

    private void b(C0602a c0602a, ab abVar) {
        String string;
        if (abVar.wH()) {
            if (this.gGY < 0) {
                if (abVar.aBf != null) {
                    this.gGY = abVar.aBf.aBk;
                }
                a(c0602a);
                return;
            } else if (this.gGY == 0) {
                b(c0602a);
                return;
            } else {
                a(c0602a);
                return;
            }
        }
        if (abVar.wI()) {
            string = this.gGX.getPageContext().getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(abVar.aBf.aBl));
        } else {
            string = this.gGX.getPageContext().getString(a.i.ala_task_status_not_over);
        }
        a(c0602a, string);
    }

    private void a(C0602a c0602a) {
        c0602a.gHe.setText(StringHelper.formatSecondsTime(this.gGY * 1000));
        c0602a.gHe.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        c0602a.gHe.setTextColor(this.gGX.getPageContext().getResources().getColor(a.d.sdk_common_color_10260));
        b(c0602a.gHe, true);
    }

    private void a(C0602a c0602a, String str) {
        c0602a.gHe.setText(str);
        c0602a.gHe.setBackgroundResource(a.f.sdk_transparent_bg);
        c0602a.gHe.setTextColor(this.gGX.getPageContext().getResources().getColor(a.d.sdk_cp_cont_d));
        b(c0602a.gHe, false);
    }

    private void b(C0602a c0602a) {
        c0602a.gHe.setText(this.gGX.getPageContext().getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            c0602a.gHe.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            c0602a.gHe.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            c0602a.gHe.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            c0602a.gHe.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        c0602a.gHe.setTextColor(this.gGX.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
        b(c0602a.gHe, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.gGX.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.gGX.getResources().getDimension(a.e.sdk_ds50);
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

    public void j(Integer num) {
        this.gGY = num.intValue();
        ab wL = wL();
        if (wL != null) {
            if (this.gGY == 0) {
                wL.status = 2;
            } else if (this.gGY > 0) {
                wL.status = 1;
            } else {
                wL.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public ab wL() {
        if (!ListUtils.isEmpty(this.dQf)) {
            Iterator<ab> it = this.dQf.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (next.wH()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.ala.tasklist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0602a {
        public View dQh;
        public TextView gHb;
        public TextView gHc;
        public TextView gHd;
        public TextView gHe;
        public View rootView;

        public C0602a(View view) {
            this.rootView = view;
            this.gHb = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.gHc = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.gHd = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.gHe = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.dQh = view.findViewById(a.g.divider);
        }
    }
}

package com.baidu.tieba.ala.tasklist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private AlaTaskListActivity gfb;
    private int gfc = -1;
    private ArrayList<w> dvq = new ArrayList<>();

    public a(AlaTaskListActivity alaTaskListActivity) {
        this.gfb = alaTaskListActivity;
    }

    public void setData(ArrayList<w> arrayList) {
        if (arrayList != null) {
            this.dvq.clear();
            this.dvq.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvq == null) {
            return 0;
        }
        return this.dvq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rq */
    public w getItem(int i) {
        if (this.dvq == null) {
            return null;
        }
        return this.dvq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0522a c0522a;
        if (view == null) {
            view = LayoutInflater.from(this.gfb.getPageContext().getPageActivity()).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
            c0522a = new C0522a(view);
            view.setTag(c0522a);
        } else {
            c0522a = (C0522a) view.getTag();
        }
        a(c0522a, getItem(i));
        return view;
    }

    private void a(C0522a c0522a, final w wVar) {
        if (wVar != null) {
            c0522a.gff.setText(wVar.atC);
            c0522a.gfg.setText(wVar.atH);
            c0522a.gfh.setText(this.gfb.getPageContext().getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(wVar.atG)));
            if (wVar.status == 3) {
                c0522a.gfh.setVisibility(8);
            } else {
                c0522a.gfh.setVisibility(0);
            }
            c0522a.gfi.setTag(Integer.valueOf(wVar.atB));
            if (wVar.status == 2) {
                b(c0522a);
            } else if (wVar.status == 3) {
                a(c0522a, this.gfb.getPageContext().getString(a.i.ala_task_status_success));
            } else {
                b(c0522a, wVar);
            }
            c0522a.gfi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (wVar.status == 2) {
                        a.this.gfb.ro(wVar.atB);
                    }
                }
            });
        }
    }

    private void b(C0522a c0522a, w wVar) {
        String string;
        if (wVar.uV()) {
            if (this.gfc < 0) {
                if (wVar.atF != null) {
                    this.gfc = wVar.atF.atK;
                }
                a(c0522a);
                return;
            } else if (this.gfc == 0) {
                b(c0522a);
                return;
            } else {
                a(c0522a);
                return;
            }
        }
        if (wVar.uW()) {
            string = this.gfb.getPageContext().getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(wVar.atF.atL));
        } else {
            string = this.gfb.getPageContext().getString(a.i.ala_task_status_not_over);
        }
        a(c0522a, string);
    }

    private void a(C0522a c0522a) {
        c0522a.gfi.setText(StringHelper.formatSecondsTime(this.gfc * 1000));
        c0522a.gfi.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        c0522a.gfi.setTextColor(this.gfb.getPageContext().getResources().getColor(a.d.sdk_common_color_10260));
        b(c0522a.gfi, true);
    }

    private void a(C0522a c0522a, String str) {
        c0522a.gfi.setText(str);
        c0522a.gfi.setBackgroundResource(a.f.sdk_transparent_bg);
        c0522a.gfi.setTextColor(this.gfb.getPageContext().getResources().getColor(a.d.sdk_cp_cont_d));
        b(c0522a.gfi, false);
    }

    private void b(C0522a c0522a) {
        c0522a.gfi.setText(this.gfb.getPageContext().getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            c0522a.gfi.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            c0522a.gfi.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            c0522a.gfi.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            c0522a.gfi.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        c0522a.gfi.setTextColor(this.gfb.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
        b(c0522a.gfi, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.gfb.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.gfb.getResources().getDimension(a.e.sdk_ds50);
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
        this.gfc = num.intValue();
        w uZ = uZ();
        if (uZ != null) {
            if (this.gfc == 0) {
                uZ.status = 2;
            } else if (this.gfc > 0) {
                uZ.status = 1;
            } else {
                uZ.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public w uZ() {
        if (!ListUtils.isEmpty(this.dvq)) {
            Iterator<w> it = this.dvq.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.uV()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.ala.tasklist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0522a {
        public View dvs;
        public TextView gff;
        public TextView gfg;
        public TextView gfh;
        public TextView gfi;
        public View rootView;

        public C0522a(View view) {
            this.rootView = view;
            this.gff = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.gfg = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.gfh = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.gfi = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.dvs = view.findViewById(a.g.divider);
        }
    }
}

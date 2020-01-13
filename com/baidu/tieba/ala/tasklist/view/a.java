package com.baidu.tieba.ala.tasklist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.t;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private AlaTaskListActivity fxc;
    private int fxd = -1;
    private ArrayList<t> cRO = new ArrayList<>();

    public a(AlaTaskListActivity alaTaskListActivity) {
        this.fxc = alaTaskListActivity;
    }

    public void setData(ArrayList<t> arrayList) {
        if (arrayList != null) {
            this.cRO.clear();
            this.cRO.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRO == null) {
            return 0;
        }
        return this.cRO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qO */
    public t getItem(int i) {
        if (this.cRO == null) {
            return null;
        }
        return this.cRO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0478a c0478a;
        if (view == null) {
            view = LayoutInflater.from(this.fxc.getPageContext().getPageActivity()).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
            c0478a = new C0478a(view);
            view.setTag(c0478a);
        } else {
            c0478a = (C0478a) view.getTag();
        }
        a(c0478a, getItem(i));
        return view;
    }

    private void a(C0478a c0478a, final t tVar) {
        if (tVar != null) {
            c0478a.fxg.setText(tVar.Zf);
            c0478a.fxh.setText(tVar.Zk);
            c0478a.fxi.setText(this.fxc.getPageContext().getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(tVar.Zj)));
            if (tVar.status == 3) {
                c0478a.fxi.setVisibility(8);
            } else {
                c0478a.fxi.setVisibility(0);
            }
            c0478a.fxj.setTag(Integer.valueOf(tVar.Ze));
            if (tVar.status == 2) {
                b(c0478a);
            } else if (tVar.status == 3) {
                a(c0478a, this.fxc.getPageContext().getString(a.i.ala_task_status_success));
            } else {
                b(c0478a, tVar);
            }
            c0478a.fxj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (tVar.status == 2) {
                        a.this.fxc.qM(tVar.Ze);
                    }
                }
            });
        }
    }

    private void b(C0478a c0478a, t tVar) {
        String string;
        if (tVar.pO()) {
            if (this.fxd < 0) {
                if (tVar.Zi != null) {
                    this.fxd = tVar.Zi.Zn;
                }
                a(c0478a);
                return;
            } else if (this.fxd == 0) {
                b(c0478a);
                return;
            } else {
                a(c0478a);
                return;
            }
        }
        if (tVar.pP()) {
            string = this.fxc.getPageContext().getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(tVar.Zi.Zo));
        } else {
            string = this.fxc.getPageContext().getString(a.i.ala_task_status_not_over);
        }
        a(c0478a, string);
    }

    private void a(C0478a c0478a) {
        c0478a.fxj.setText(StringHelper.formatSecondsTime(this.fxd * 1000));
        c0478a.fxj.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        c0478a.fxj.setTextColor(this.fxc.getPageContext().getResources().getColor(a.d.sdk_common_color_10260));
        b(c0478a.fxj, true);
    }

    private void a(C0478a c0478a, String str) {
        c0478a.fxj.setText(str);
        c0478a.fxj.setBackgroundResource(a.f.sdk_transparent_bg);
        c0478a.fxj.setTextColor(this.fxc.getPageContext().getResources().getColor(a.d.sdk_cp_cont_d));
        b(c0478a.fxj, false);
    }

    private void b(C0478a c0478a) {
        c0478a.fxj.setText(this.fxc.getPageContext().getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            c0478a.fxj.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            c0478a.fxj.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            c0478a.fxj.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            c0478a.fxj.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        c0478a.fxj.setTextColor(this.fxc.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
        b(c0478a.fxj, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.fxc.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.fxc.getResources().getDimension(a.e.sdk_ds50);
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
        this.fxd = num.intValue();
        t pS = pS();
        if (pS != null) {
            if (this.fxd == 0) {
                pS.status = 2;
            } else if (this.fxd > 0) {
                pS.status = 1;
            } else {
                pS.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public t pS() {
        if (!ListUtils.isEmpty(this.cRO)) {
            Iterator<t> it = this.cRO.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next.pO()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.ala.tasklist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0478a {
        public View cRQ;
        public TextView fxg;
        public TextView fxh;
        public TextView fxi;
        public TextView fxj;
        public View rootView;

        public C0478a(View view) {
            this.rootView = view;
            this.fxg = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.fxh = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.fxi = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.fxj = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.cRQ = view.findViewById(a.g.divider);
        }
    }
}

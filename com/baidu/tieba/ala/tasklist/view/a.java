package com.baidu.tieba.ala.tasklist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.aa;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private AlaTaskListActivity gtZ;
    private int gua = -1;
    private ArrayList<aa> dJp = new ArrayList<>();

    public a(AlaTaskListActivity alaTaskListActivity) {
        this.gtZ = alaTaskListActivity;
    }

    public void setData(ArrayList<aa> arrayList) {
        if (arrayList != null) {
            this.dJp.clear();
            this.dJp.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dJp == null) {
            return 0;
        }
        return this.dJp.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rT */
    public aa getItem(int i) {
        if (this.dJp == null) {
            return null;
        }
        return this.dJp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0593a c0593a;
        if (view == null) {
            view = LayoutInflater.from(this.gtZ.getPageContext().getPageActivity()).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
            c0593a = new C0593a(view);
            view.setTag(c0593a);
        } else {
            c0593a = (C0593a) view.getTag();
        }
        a(c0593a, getItem(i));
        return view;
    }

    private void a(C0593a c0593a, final aa aaVar) {
        if (aaVar != null) {
            c0593a.gud.setText(aaVar.ayL);
            c0593a.gue.setText(aaVar.ayQ);
            c0593a.guf.setText(this.gtZ.getPageContext().getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(aaVar.ayP)));
            if (aaVar.status == 3) {
                c0593a.guf.setVisibility(8);
            } else {
                c0593a.guf.setVisibility(0);
            }
            c0593a.gug.setTag(Integer.valueOf(aaVar.ayK));
            if (aaVar.status == 2) {
                b(c0593a);
            } else if (aaVar.status == 3) {
                a(c0593a, this.gtZ.getPageContext().getString(a.i.ala_task_status_success));
            } else {
                b(c0593a, aaVar);
            }
            c0593a.gug.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aaVar.status == 2) {
                        a.this.gtZ.rR(aaVar.ayK);
                    }
                }
            });
        }
    }

    private void b(C0593a c0593a, aa aaVar) {
        String string;
        if (aaVar.wj()) {
            if (this.gua < 0) {
                if (aaVar.ayO != null) {
                    this.gua = aaVar.ayO.ayT;
                }
                a(c0593a);
                return;
            } else if (this.gua == 0) {
                b(c0593a);
                return;
            } else {
                a(c0593a);
                return;
            }
        }
        if (aaVar.wk()) {
            string = this.gtZ.getPageContext().getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(aaVar.ayO.ayU));
        } else {
            string = this.gtZ.getPageContext().getString(a.i.ala_task_status_not_over);
        }
        a(c0593a, string);
    }

    private void a(C0593a c0593a) {
        c0593a.gug.setText(StringHelper.formatSecondsTime(this.gua * 1000));
        c0593a.gug.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        c0593a.gug.setTextColor(this.gtZ.getPageContext().getResources().getColor(a.d.sdk_common_color_10260));
        b(c0593a.gug, true);
    }

    private void a(C0593a c0593a, String str) {
        c0593a.gug.setText(str);
        c0593a.gug.setBackgroundResource(a.f.sdk_transparent_bg);
        c0593a.gug.setTextColor(this.gtZ.getPageContext().getResources().getColor(a.d.sdk_cp_cont_d));
        b(c0593a.gug, false);
    }

    private void b(C0593a c0593a) {
        c0593a.gug.setText(this.gtZ.getPageContext().getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            c0593a.gug.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            c0593a.gug.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            c0593a.gug.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            c0593a.gug.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        c0593a.gug.setTextColor(this.gtZ.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
        b(c0593a.gug, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.gtZ.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.gtZ.getResources().getDimension(a.e.sdk_ds50);
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
        this.gua = num.intValue();
        aa wn = wn();
        if (wn != null) {
            if (this.gua == 0) {
                wn.status = 2;
            } else if (this.gua > 0) {
                wn.status = 1;
            } else {
                wn.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public aa wn() {
        if (!ListUtils.isEmpty(this.dJp)) {
            Iterator<aa> it = this.dJp.iterator();
            while (it.hasNext()) {
                aa next = it.next();
                if (next.wj()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.ala.tasklist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0593a {
        public View dJr;
        public TextView gud;
        public TextView gue;
        public TextView guf;
        public TextView gug;
        public View rootView;

        public C0593a(View view) {
            this.rootView = view;
            this.gud = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.gue = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.guf = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.gug = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.dJr = view.findViewById(a.g.divider);
        }
    }
}

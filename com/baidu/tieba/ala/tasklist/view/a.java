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
    private AlaTaskListActivity gfh;
    private int gfi = -1;
    private ArrayList<w> dvu = new ArrayList<>();

    public a(AlaTaskListActivity alaTaskListActivity) {
        this.gfh = alaTaskListActivity;
    }

    public void setData(ArrayList<w> arrayList) {
        if (arrayList != null) {
            this.dvu.clear();
            this.dvu.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvu == null) {
            return 0;
        }
        return this.dvu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rq */
    public w getItem(int i) {
        if (this.dvu == null) {
            return null;
        }
        return this.dvu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0543a c0543a;
        if (view == null) {
            view = LayoutInflater.from(this.gfh.getPageContext().getPageActivity()).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
            c0543a = new C0543a(view);
            view.setTag(c0543a);
        } else {
            c0543a = (C0543a) view.getTag();
        }
        a(c0543a, getItem(i));
        return view;
    }

    private void a(C0543a c0543a, final w wVar) {
        if (wVar != null) {
            c0543a.gfl.setText(wVar.atI);
            c0543a.gfm.setText(wVar.atN);
            c0543a.gfn.setText(this.gfh.getPageContext().getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(wVar.atM)));
            if (wVar.status == 3) {
                c0543a.gfn.setVisibility(8);
            } else {
                c0543a.gfn.setVisibility(0);
            }
            c0543a.gfo.setTag(Integer.valueOf(wVar.atH));
            if (wVar.status == 2) {
                b(c0543a);
            } else if (wVar.status == 3) {
                a(c0543a, this.gfh.getPageContext().getString(a.i.ala_task_status_success));
            } else {
                b(c0543a, wVar);
            }
            c0543a.gfo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (wVar.status == 2) {
                        a.this.gfh.ro(wVar.atH);
                    }
                }
            });
        }
    }

    private void b(C0543a c0543a, w wVar) {
        String string;
        if (wVar.uU()) {
            if (this.gfi < 0) {
                if (wVar.atL != null) {
                    this.gfi = wVar.atL.atQ;
                }
                a(c0543a);
                return;
            } else if (this.gfi == 0) {
                b(c0543a);
                return;
            } else {
                a(c0543a);
                return;
            }
        }
        if (wVar.uV()) {
            string = this.gfh.getPageContext().getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(wVar.atL.atR));
        } else {
            string = this.gfh.getPageContext().getString(a.i.ala_task_status_not_over);
        }
        a(c0543a, string);
    }

    private void a(C0543a c0543a) {
        c0543a.gfo.setText(StringHelper.formatSecondsTime(this.gfi * 1000));
        c0543a.gfo.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        c0543a.gfo.setTextColor(this.gfh.getPageContext().getResources().getColor(a.d.sdk_common_color_10260));
        b(c0543a.gfo, true);
    }

    private void a(C0543a c0543a, String str) {
        c0543a.gfo.setText(str);
        c0543a.gfo.setBackgroundResource(a.f.sdk_transparent_bg);
        c0543a.gfo.setTextColor(this.gfh.getPageContext().getResources().getColor(a.d.sdk_cp_cont_d));
        b(c0543a.gfo, false);
    }

    private void b(C0543a c0543a) {
        c0543a.gfo.setText(this.gfh.getPageContext().getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            c0543a.gfo.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            c0543a.gfo.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            c0543a.gfo.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            c0543a.gfo.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        c0543a.gfo.setTextColor(this.gfh.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
        b(c0543a.gfo, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.gfh.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.gfh.getResources().getDimension(a.e.sdk_ds50);
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
        this.gfi = num.intValue();
        w uY = uY();
        if (uY != null) {
            if (this.gfi == 0) {
                uY.status = 2;
            } else if (this.gfi > 0) {
                uY.status = 1;
            } else {
                uY.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public w uY() {
        if (!ListUtils.isEmpty(this.dvu)) {
            Iterator<w> it = this.dvu.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.uU()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.ala.tasklist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0543a {
        public View dvw;
        public TextView gfl;
        public TextView gfm;
        public TextView gfn;
        public TextView gfo;
        public View rootView;

        public C0543a(View view) {
            this.rootView = view;
            this.gfl = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.gfm = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.gfn = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.gfo = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.dvw = view.findViewById(a.g.divider);
        }
    }
}

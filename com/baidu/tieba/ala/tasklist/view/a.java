package com.baidu.tieba.ala.tasklist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.r;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private AlaTaskListActivity ftR;
    private int ftS = -1;
    private ArrayList<r> cRE = new ArrayList<>();

    public a(AlaTaskListActivity alaTaskListActivity) {
        this.ftR = alaTaskListActivity;
    }

    public void setData(ArrayList<r> arrayList) {
        if (arrayList != null) {
            this.cRE.clear();
            this.cRE.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRE == null) {
            return 0;
        }
        return this.cRE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qJ */
    public r getItem(int i) {
        if (this.cRE == null) {
            return null;
        }
        return this.cRE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0474a c0474a;
        if (view == null) {
            view = LayoutInflater.from(this.ftR.getPageContext().getPageActivity()).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
            c0474a = new C0474a(view);
            view.setTag(c0474a);
        } else {
            c0474a = (C0474a) view.getTag();
        }
        a(c0474a, getItem(i));
        return view;
    }

    private void a(C0474a c0474a, final r rVar) {
        if (rVar != null) {
            c0474a.ftV.setText(rVar.YR);
            c0474a.ftW.setText(rVar.YW);
            c0474a.ftX.setText(this.ftR.getPageContext().getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(rVar.YV)));
            if (rVar.status == 3) {
                c0474a.ftX.setVisibility(8);
            } else {
                c0474a.ftX.setVisibility(0);
            }
            c0474a.ftY.setTag(Integer.valueOf(rVar.YQ));
            if (rVar.status == 2) {
                b(c0474a);
            } else if (rVar.status == 3) {
                a(c0474a, this.ftR.getPageContext().getString(a.i.ala_task_status_success));
            } else {
                b(c0474a, rVar);
            }
            c0474a.ftY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (rVar.status == 2) {
                        a.this.ftR.qH(rVar.YQ);
                    }
                }
            });
        }
    }

    private void b(C0474a c0474a, r rVar) {
        String string;
        if (rVar.pK()) {
            if (this.ftS < 0) {
                if (rVar.YU != null) {
                    this.ftS = rVar.YU.YZ;
                }
                a(c0474a);
                return;
            } else if (this.ftS == 0) {
                b(c0474a);
                return;
            } else {
                a(c0474a);
                return;
            }
        }
        if (rVar.pL()) {
            string = this.ftR.getPageContext().getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(rVar.YU.Za));
        } else {
            string = this.ftR.getPageContext().getString(a.i.ala_task_status_not_over);
        }
        a(c0474a, string);
    }

    private void a(C0474a c0474a) {
        c0474a.ftY.setText(StringHelper.formatSecondsTime(this.ftS * 1000));
        c0474a.ftY.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        c0474a.ftY.setTextColor(this.ftR.getPageContext().getResources().getColor(a.d.sdk_common_color_10260));
        b(c0474a.ftY, true);
    }

    private void a(C0474a c0474a, String str) {
        c0474a.ftY.setText(str);
        c0474a.ftY.setBackgroundResource(a.f.sdk_transparent_bg);
        c0474a.ftY.setTextColor(this.ftR.getPageContext().getResources().getColor(a.d.sdk_cp_cont_d));
        b(c0474a.ftY, false);
    }

    private void b(C0474a c0474a) {
        c0474a.ftY.setText(this.ftR.getPageContext().getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            c0474a.ftY.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            c0474a.ftY.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            c0474a.ftY.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            c0474a.ftY.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        c0474a.ftY.setTextColor(this.ftR.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
        b(c0474a.ftY, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.ftR.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.ftR.getResources().getDimension(a.e.sdk_ds50);
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
        this.ftS = num.intValue();
        r pO = pO();
        if (pO != null) {
            if (this.ftS == 0) {
                pO.status = 2;
            } else if (this.ftS > 0) {
                pO.status = 1;
            } else {
                pO.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public r pO() {
        if (!ListUtils.isEmpty(this.cRE)) {
            Iterator<r> it = this.cRE.iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next.pK()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: com.baidu.tieba.ala.tasklist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0474a {
        public View cRG;
        public TextView ftV;
        public TextView ftW;
        public TextView ftX;
        public TextView ftY;
        public View rootView;

        public C0474a(View view) {
            this.rootView = view;
            this.ftV = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.ftW = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.ftX = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.ftY = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.cRG = view.findViewById(a.g.divider);
        }
    }
}

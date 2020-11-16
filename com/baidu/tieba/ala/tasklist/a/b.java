package com.baidu.tieba.ala.tasklist.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.am;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.ala.tasklist.a.a hJU;
    private Context mActivity;
    private int hJV = -1;
    private ArrayList<am> eHj = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.hJU = aVar;
    }

    public void setData(ArrayList<am> arrayList) {
        if (arrayList != null) {
            this.eHj.clear();
            this.eHj.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHj == null) {
            return 0;
        }
        return this.eHj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xe */
    public am getItem(int i) {
        if (this.eHj == null) {
            return null;
        }
        return this.eHj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity).inflate(a.g.ala_task_list_item_layout, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, getItem(i));
        return view;
    }

    private void a(a aVar, final am amVar) {
        if (amVar != null) {
            aVar.hJY.setText(amVar.aLW);
            aVar.hJZ.setText(amVar.aMb);
            aVar.hKa.setText(this.mActivity.getResources().getString(a.h.ala_task_title_reward_mode, Integer.valueOf(amVar.aMa)));
            if (amVar.status == 3) {
                aVar.hKa.setVisibility(8);
            } else {
                aVar.hKa.setVisibility(0);
            }
            aVar.hKb.setTag(Integer.valueOf(amVar.aLV));
            if (amVar.status == 2) {
                b(aVar);
            } else if (amVar.status == 3) {
                a(aVar, this.mActivity.getString(a.h.ala_task_status_success));
            } else {
                b(aVar, amVar);
            }
            aVar.hKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (amVar.status == 2 && b.this.hJU != null) {
                        b.this.hJU.xc(amVar.aLV);
                    }
                }
            });
        }
    }

    private void b(a aVar, am amVar) {
        String string;
        if (amVar.DV()) {
            if (this.hJV < 0) {
                if (amVar.aLZ != null) {
                    this.hJV = amVar.aLZ.aMe;
                }
                a(aVar);
                return;
            } else if (this.hJV == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (amVar.DW()) {
            string = this.mActivity.getResources().getString(a.h.ala_task_level_up_to_level_num, Integer.valueOf(amVar.aLZ.aMf));
        } else {
            string = this.mActivity.getString(a.h.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.hKb.setText(StringHelper.formatSecondsTime(this.hJV * 1000));
        aVar.hKb.setBackgroundResource(a.e.ala_bg_rectangle_stroke_blue);
        aVar.hKb.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_common_color_10260));
        b(aVar.hKb, true);
    }

    private void a(a aVar, String str) {
        aVar.hKb.setText(str);
        aVar.hKb.setBackgroundResource(a.e.sdk_transparent_bg);
        aVar.hKb.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_d));
        b(aVar.hKb, false);
    }

    private void b(a aVar) {
        aVar.hKb.setText(this.mActivity.getString(a.h.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.hKb.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            aVar.hKb.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.hKb.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.hKb.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue);
        }
        aVar.hKb.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_g));
        b(aVar.hKb, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.mActivity.getResources().getDimension(a.d.sdk_ds110);
            layoutParams.height = (int) this.mActivity.getResources().getDimension(a.d.sdk_ds50);
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

    public void m(Integer num) {
        this.hJV = num.intValue();
        am DZ = DZ();
        if (DZ != null) {
            if (this.hJV == 0) {
                DZ.status = 2;
            } else if (this.hJV > 0) {
                DZ.status = 1;
            } else {
                DZ.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public am DZ() {
        if (!ListUtils.isEmpty(this.eHj)) {
            Iterator<am> it = this.eHj.iterator();
            while (it.hasNext()) {
                am next = it.next();
                if (next.DV()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public View eHl;
        public TextView hJY;
        public TextView hJZ;
        public TextView hKa;
        public TextView hKb;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hJY = (TextView) view.findViewById(a.f.tvTaskTitle);
            this.hJZ = (TextView) view.findViewById(a.f.tvTaskSubTitle);
            this.hKa = (TextView) view.findViewById(a.f.tvTaskRewardNum);
            this.hKb = (TextView) view.findViewById(a.f.tvTaskStatus);
            this.eHl = view.findViewById(a.f.divider);
        }
    }
}

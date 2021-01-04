package com.baidu.tieba.ala.tasklist.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.ap;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.ala.tasklist.a.a ihq;
    private Context mActivity;
    private int ihr = -1;
    private ArrayList<ap> eYq = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.ihq = aVar;
    }

    public void setData(ArrayList<ap> arrayList) {
        if (arrayList != null) {
            this.eYq.clear();
            this.eYq.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eYq == null) {
            return 0;
        }
        return this.eYq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xX */
    public ap getItem(int i) {
        if (this.eYq == null) {
            return null;
        }
        return this.eYq.get(i);
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

    private void a(a aVar, final ap apVar) {
        if (apVar != null) {
            aVar.ihu.setText(apVar.aPA);
            aVar.ihv.setText(apVar.aPF);
            aVar.ihw.setText(this.mActivity.getResources().getString(a.h.ala_task_title_reward_mode, Integer.valueOf(apVar.aPE)));
            if (apVar.status == 3) {
                aVar.ihw.setVisibility(8);
            } else {
                aVar.ihw.setVisibility(0);
            }
            aVar.ihx.setTag(Integer.valueOf(apVar.aPz));
            if (apVar.status == 2) {
                b(aVar);
            } else if (apVar.status == 3) {
                a(aVar, this.mActivity.getString(a.h.ala_task_status_success));
            } else {
                b(aVar, apVar);
            }
            aVar.ihx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (apVar.status == 2 && b.this.ihq != null) {
                        b.this.ihq.xV(apVar.aPz);
                    }
                }
            });
        }
    }

    private void b(a aVar, ap apVar) {
        String string;
        if (apVar.EW()) {
            if (this.ihr < 0) {
                if (apVar.aPD != null) {
                    this.ihr = apVar.aPD.aPQ;
                }
                a(aVar);
                return;
            } else if (this.ihr == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (apVar.EX()) {
            string = this.mActivity.getResources().getString(a.h.ala_task_level_up_to_level_num, Integer.valueOf(apVar.aPD.aPR));
        } else {
            string = this.mActivity.getString(a.h.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.ihx.setText(StringHelper.formatSecondsTime(this.ihr * 1000));
        aVar.ihx.setBackgroundResource(a.e.ala_bg_rectangle_stroke_blue);
        aVar.ihx.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_common_color_10260));
        b(aVar.ihx, true);
    }

    private void a(a aVar, String str) {
        aVar.ihx.setText(str);
        aVar.ihx.setBackgroundResource(a.e.sdk_transparent_bg);
        aVar.ihx.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_d));
        b(aVar.ihx, false);
    }

    private void b(a aVar) {
        aVar.ihx.setText(this.mActivity.getString(a.h.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.ihx.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            aVar.ihx.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.ihx.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.ihx.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue);
        }
        aVar.ihx.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_g));
        b(aVar.ihx, true);
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

    public void o(Integer num) {
        this.ihr = num.intValue();
        ap Fa = Fa();
        if (Fa != null) {
            if (this.ihr == 0) {
                Fa.status = 2;
            } else if (this.ihr > 0) {
                Fa.status = 1;
            } else {
                Fa.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public ap Fa() {
        if (!ListUtils.isEmpty(this.eYq)) {
            Iterator<ap> it = this.eYq.iterator();
            while (it.hasNext()) {
                ap next = it.next();
                if (next.EW()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes11.dex */
    public static class a {
        public View bUk;
        public TextView ihu;
        public TextView ihv;
        public TextView ihw;
        public TextView ihx;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.ihu = (TextView) view.findViewById(a.f.tvTaskTitle);
            this.ihv = (TextView) view.findViewById(a.f.tvTaskSubTitle);
            this.ihw = (TextView) view.findViewById(a.f.tvTaskRewardNum);
            this.ihx = (TextView) view.findViewById(a.f.tvTaskStatus);
            this.bUk = view.findViewById(a.f.divider);
        }
    }
}

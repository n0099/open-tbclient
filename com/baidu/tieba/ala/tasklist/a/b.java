package com.baidu.tieba.ala.tasklist.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.ad;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.ala.tasklist.a.a gZt;
    private Context mActivity;
    private int gZu = -1;
    private ArrayList<ad> egb = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.gZt = aVar;
    }

    public void setData(ArrayList<ad> arrayList) {
        if (arrayList != null) {
            this.egb.clear();
            this.egb.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.egb == null) {
            return 0;
        }
        return this.egb.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: va */
    public ad getItem(int i) {
        if (this.egb == null) {
            return null;
        }
        return this.egb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity).inflate(a.h.ala_task_list_item_layout, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, getItem(i));
        return view;
    }

    private void a(a aVar, final ad adVar) {
        if (adVar != null) {
            aVar.gZx.setText(adVar.aHB);
            aVar.gZy.setText(adVar.aHG);
            aVar.gZz.setText(this.mActivity.getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(adVar.aHF)));
            if (adVar.status == 3) {
                aVar.gZz.setVisibility(8);
            } else {
                aVar.gZz.setVisibility(0);
            }
            aVar.gZA.setTag(Integer.valueOf(adVar.aHA));
            if (adVar.status == 2) {
                b(aVar);
            } else if (adVar.status == 3) {
                a(aVar, this.mActivity.getString(a.i.ala_task_status_success));
            } else {
                b(aVar, adVar);
            }
            aVar.gZA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (adVar.status == 2 && b.this.gZt != null) {
                        b.this.gZt.uY(adVar.aHA);
                    }
                }
            });
        }
    }

    private void b(a aVar, ad adVar) {
        String string;
        if (adVar.CM()) {
            if (this.gZu < 0) {
                if (adVar.aHE != null) {
                    this.gZu = adVar.aHE.aHJ;
                }
                a(aVar);
                return;
            } else if (this.gZu == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (adVar.CN()) {
            string = this.mActivity.getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(adVar.aHE.aHK));
        } else {
            string = this.mActivity.getString(a.i.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.gZA.setText(StringHelper.formatSecondsTime(this.gZu * 1000));
        aVar.gZA.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        aVar.gZA.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_common_color_10260));
        b(aVar.gZA, true);
    }

    private void a(a aVar, String str) {
        aVar.gZA.setText(str);
        aVar.gZA.setBackgroundResource(a.f.sdk_transparent_bg);
        aVar.gZA.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_d));
        b(aVar.gZA, false);
    }

    private void b(a aVar) {
        aVar.gZA.setText(this.mActivity.getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.gZA.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            aVar.gZA.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.gZA.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.gZA.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        aVar.gZA.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_g));
        b(aVar.gZA, true);
    }

    public void b(TextView textView, boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) this.mActivity.getResources().getDimension(a.e.sdk_ds110);
            layoutParams.height = (int) this.mActivity.getResources().getDimension(a.e.sdk_ds50);
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

    public void k(Integer num) {
        this.gZu = num.intValue();
        ad CQ = CQ();
        if (CQ != null) {
            if (this.gZu == 0) {
                CQ.status = 2;
            } else if (this.gZu > 0) {
                CQ.status = 1;
            } else {
                CQ.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public ad CQ() {
        if (!ListUtils.isEmpty(this.egb)) {
            Iterator<ad> it = this.egb.iterator();
            while (it.hasNext()) {
                ad next = it.next();
                if (next.CM()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes7.dex */
    public static class a {
        public View egd;
        public TextView gZA;
        public TextView gZx;
        public TextView gZy;
        public TextView gZz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gZx = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.gZy = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.gZz = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.gZA = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.egd = view.findViewById(a.g.divider);
        }
    }
}

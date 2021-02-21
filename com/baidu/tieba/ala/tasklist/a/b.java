package com.baidu.tieba.ala.tasklist.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.at;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.ala.tasklist.a.a ihM;
    private Context mActivity;
    private int ihN = -1;
    private ArrayList<at> eVV = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.ihM = aVar;
    }

    public void setData(ArrayList<at> arrayList) {
        if (arrayList != null) {
            this.eVV.clear();
            this.eVV.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVV == null) {
            return 0;
        }
        return this.eVV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wC */
    public at getItem(int i) {
        if (this.eVV == null) {
            return null;
        }
        return this.eVV.get(i);
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

    private void a(a aVar, final at atVar) {
        if (atVar != null) {
            aVar.ihQ.setText(atVar.aNJ);
            aVar.ihR.setText(atVar.aNO);
            aVar.ihS.setText(this.mActivity.getResources().getString(a.h.ala_task_title_reward_mode, Integer.valueOf(atVar.aNN)));
            if (atVar.status == 3) {
                aVar.ihS.setVisibility(8);
            } else {
                aVar.ihS.setVisibility(0);
            }
            aVar.ihT.setTag(Integer.valueOf(atVar.aNI));
            if (atVar.status == 2) {
                b(aVar);
            } else if (atVar.status == 3) {
                a(aVar, this.mActivity.getString(a.h.ala_task_status_success));
            } else {
                b(aVar, atVar);
            }
            aVar.ihT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (atVar.status == 2 && b.this.ihM != null) {
                        b.this.ihM.wA(atVar.aNI);
                    }
                }
            });
        }
    }

    private void b(a aVar, at atVar) {
        String string;
        if (atVar.Co()) {
            if (this.ihN < 0) {
                if (atVar.aNM != null) {
                    this.ihN = atVar.aNM.aNZ;
                }
                a(aVar);
                return;
            } else if (this.ihN == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (atVar.Cp()) {
            string = this.mActivity.getResources().getString(a.h.ala_task_level_up_to_level_num, Integer.valueOf(atVar.aNM.aOa));
        } else {
            string = this.mActivity.getString(a.h.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.ihT.setText(StringHelper.formatSecondsTime(this.ihN * 1000));
        aVar.ihT.setBackgroundResource(a.e.ala_bg_rectangle_stroke_blue);
        aVar.ihT.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_common_color_10260));
        c(aVar.ihT, true);
    }

    private void a(a aVar, String str) {
        aVar.ihT.setText(str);
        aVar.ihT.setBackgroundResource(a.e.sdk_transparent_bg);
        aVar.ihT.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_d));
        c(aVar.ihT, false);
    }

    private void b(a aVar) {
        aVar.ihT.setText(this.mActivity.getString(a.h.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.ihT.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            aVar.ihT.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.ihT.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.ihT.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue);
        }
        aVar.ihT.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_g));
        c(aVar.ihT, true);
    }

    public void c(TextView textView, boolean z) {
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
        this.ihN = num.intValue();
        at Cs = Cs();
        if (Cs != null) {
            if (this.ihN == 0) {
                Cs.status = 2;
            } else if (this.ihN > 0) {
                Cs.status = 1;
            } else {
                Cs.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public at Cs() {
        if (!ListUtils.isEmpty(this.eVV)) {
            Iterator<at> it = this.eVV.iterator();
            while (it.hasNext()) {
                at next = it.next();
                if (next.Co()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes11.dex */
    public static class a {
        public View bTo;
        public TextView ihQ;
        public TextView ihR;
        public TextView ihS;
        public TextView ihT;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.ihQ = (TextView) view.findViewById(a.f.tvTaskTitle);
            this.ihR = (TextView) view.findViewById(a.f.tvTaskSubTitle);
            this.ihS = (TextView) view.findViewById(a.f.tvTaskRewardNum);
            this.ihT = (TextView) view.findViewById(a.f.tvTaskStatus);
            this.bTo = view.findViewById(a.f.divider);
        }
    }
}

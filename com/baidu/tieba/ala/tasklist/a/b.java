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
    private com.baidu.tieba.ala.tasklist.a.a ihy;
    private Context mActivity;
    private int ihz = -1;
    private ArrayList<at> eVV = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.ihy = aVar;
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
            aVar.ihC.setText(atVar.aNJ);
            aVar.ihD.setText(atVar.aNO);
            aVar.ihE.setText(this.mActivity.getResources().getString(a.h.ala_task_title_reward_mode, Integer.valueOf(atVar.aNN)));
            if (atVar.status == 3) {
                aVar.ihE.setVisibility(8);
            } else {
                aVar.ihE.setVisibility(0);
            }
            aVar.ihF.setTag(Integer.valueOf(atVar.aNI));
            if (atVar.status == 2) {
                b(aVar);
            } else if (atVar.status == 3) {
                a(aVar, this.mActivity.getString(a.h.ala_task_status_success));
            } else {
                b(aVar, atVar);
            }
            aVar.ihF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (atVar.status == 2 && b.this.ihy != null) {
                        b.this.ihy.wA(atVar.aNI);
                    }
                }
            });
        }
    }

    private void b(a aVar, at atVar) {
        String string;
        if (atVar.Co()) {
            if (this.ihz < 0) {
                if (atVar.aNM != null) {
                    this.ihz = atVar.aNM.aNZ;
                }
                a(aVar);
                return;
            } else if (this.ihz == 0) {
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
        aVar.ihF.setText(StringHelper.formatSecondsTime(this.ihz * 1000));
        aVar.ihF.setBackgroundResource(a.e.ala_bg_rectangle_stroke_blue);
        aVar.ihF.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_common_color_10260));
        c(aVar.ihF, true);
    }

    private void a(a aVar, String str) {
        aVar.ihF.setText(str);
        aVar.ihF.setBackgroundResource(a.e.sdk_transparent_bg);
        aVar.ihF.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_d));
        c(aVar.ihF, false);
    }

    private void b(a aVar) {
        aVar.ihF.setText(this.mActivity.getString(a.h.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.ihF.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            aVar.ihF.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.ihF.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.ihF.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue);
        }
        aVar.ihF.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_g));
        c(aVar.ihF, true);
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
        this.ihz = num.intValue();
        at Cs = Cs();
        if (Cs != null) {
            if (this.ihz == 0) {
                Cs.status = 2;
            } else if (this.ihz > 0) {
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
        public TextView ihC;
        public TextView ihD;
        public TextView ihE;
        public TextView ihF;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.ihC = (TextView) view.findViewById(a.f.tvTaskTitle);
            this.ihD = (TextView) view.findViewById(a.f.tvTaskSubTitle);
            this.ihE = (TextView) view.findViewById(a.f.tvTaskRewardNum);
            this.ihF = (TextView) view.findViewById(a.f.tvTaskStatus);
            this.bTo = view.findViewById(a.f.divider);
        }
    }
}

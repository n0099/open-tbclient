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
    private com.baidu.tieba.ala.tasklist.a.a gZp;
    private Context mActivity;
    private int gZq = -1;
    private ArrayList<ad> efX = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.gZp = aVar;
    }

    public void setData(ArrayList<ad> arrayList) {
        if (arrayList != null) {
            this.efX.clear();
            this.efX.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.efX == null) {
            return 0;
        }
        return this.efX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: va */
    public ad getItem(int i) {
        if (this.efX == null) {
            return null;
        }
        return this.efX.get(i);
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
            aVar.gZt.setText(adVar.aHz);
            aVar.gZu.setText(adVar.aHE);
            aVar.gZv.setText(this.mActivity.getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(adVar.aHD)));
            if (adVar.status == 3) {
                aVar.gZv.setVisibility(8);
            } else {
                aVar.gZv.setVisibility(0);
            }
            aVar.gZw.setTag(Integer.valueOf(adVar.aHy));
            if (adVar.status == 2) {
                b(aVar);
            } else if (adVar.status == 3) {
                a(aVar, this.mActivity.getString(a.i.ala_task_status_success));
            } else {
                b(aVar, adVar);
            }
            aVar.gZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (adVar.status == 2 && b.this.gZp != null) {
                        b.this.gZp.uY(adVar.aHy);
                    }
                }
            });
        }
    }

    private void b(a aVar, ad adVar) {
        String string;
        if (adVar.CM()) {
            if (this.gZq < 0) {
                if (adVar.aHC != null) {
                    this.gZq = adVar.aHC.aHH;
                }
                a(aVar);
                return;
            } else if (this.gZq == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (adVar.CN()) {
            string = this.mActivity.getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(adVar.aHC.aHI));
        } else {
            string = this.mActivity.getString(a.i.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.gZw.setText(StringHelper.formatSecondsTime(this.gZq * 1000));
        aVar.gZw.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        aVar.gZw.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_common_color_10260));
        b(aVar.gZw, true);
    }

    private void a(a aVar, String str) {
        aVar.gZw.setText(str);
        aVar.gZw.setBackgroundResource(a.f.sdk_transparent_bg);
        aVar.gZw.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_d));
        b(aVar.gZw, false);
    }

    private void b(a aVar) {
        aVar.gZw.setText(this.mActivity.getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.gZw.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            aVar.gZw.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.gZw.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.gZw.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        aVar.gZw.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_g));
        b(aVar.gZw, true);
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
        this.gZq = num.intValue();
        ad CQ = CQ();
        if (CQ != null) {
            if (this.gZq == 0) {
                CQ.status = 2;
            } else if (this.gZq > 0) {
                CQ.status = 1;
            } else {
                CQ.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public ad CQ() {
        if (!ListUtils.isEmpty(this.efX)) {
            Iterator<ad> it = this.efX.iterator();
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
        public View efZ;
        public TextView gZt;
        public TextView gZu;
        public TextView gZv;
        public TextView gZw;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gZt = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.gZu = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.gZv = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.gZw = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.efZ = view.findViewById(a.g.divider);
        }
    }
}

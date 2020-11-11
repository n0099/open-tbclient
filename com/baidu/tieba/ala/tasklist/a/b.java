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
    private com.baidu.tieba.ala.tasklist.a.a hKn;
    private Context mActivity;
    private int hKo = -1;
    private ArrayList<am> eIM = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.hKn = aVar;
    }

    public void setData(ArrayList<am> arrayList) {
        if (arrayList != null) {
            this.eIM.clear();
            this.eIM.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIM == null) {
            return 0;
        }
        return this.eIM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wG */
    public am getItem(int i) {
        if (this.eIM == null) {
            return null;
        }
        return this.eIM.get(i);
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
            aVar.hKr.setText(amVar.aNH);
            aVar.hKs.setText(amVar.aNM);
            aVar.hKt.setText(this.mActivity.getResources().getString(a.h.ala_task_title_reward_mode, Integer.valueOf(amVar.aNL)));
            if (amVar.status == 3) {
                aVar.hKt.setVisibility(8);
            } else {
                aVar.hKt.setVisibility(0);
            }
            aVar.hKu.setTag(Integer.valueOf(amVar.aNG));
            if (amVar.status == 2) {
                b(aVar);
            } else if (amVar.status == 3) {
                a(aVar, this.mActivity.getString(a.h.ala_task_status_success));
            } else {
                b(aVar, amVar);
            }
            aVar.hKu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (amVar.status == 2 && b.this.hKn != null) {
                        b.this.hKn.wE(amVar.aNG);
                    }
                }
            });
        }
    }

    private void b(a aVar, am amVar) {
        String string;
        if (amVar.EE()) {
            if (this.hKo < 0) {
                if (amVar.aNK != null) {
                    this.hKo = amVar.aNK.aNP;
                }
                a(aVar);
                return;
            } else if (this.hKo == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (amVar.EF()) {
            string = this.mActivity.getResources().getString(a.h.ala_task_level_up_to_level_num, Integer.valueOf(amVar.aNK.aNQ));
        } else {
            string = this.mActivity.getString(a.h.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.hKu.setText(StringHelper.formatSecondsTime(this.hKo * 1000));
        aVar.hKu.setBackgroundResource(a.e.ala_bg_rectangle_stroke_blue);
        aVar.hKu.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_common_color_10260));
        b(aVar.hKu, true);
    }

    private void a(a aVar, String str) {
        aVar.hKu.setText(str);
        aVar.hKu.setBackgroundResource(a.e.sdk_transparent_bg);
        aVar.hKu.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_d));
        b(aVar.hKu, false);
    }

    private void b(a aVar) {
        aVar.hKu.setText(this.mActivity.getString(a.h.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.hKu.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            aVar.hKu.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.hKu.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.hKu.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue);
        }
        aVar.hKu.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_g));
        b(aVar.hKu, true);
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
        this.hKo = num.intValue();
        am EI = EI();
        if (EI != null) {
            if (this.hKo == 0) {
                EI.status = 2;
            } else if (this.hKo > 0) {
                EI.status = 1;
            } else {
                EI.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public am EI() {
        if (!ListUtils.isEmpty(this.eIM)) {
            Iterator<am> it = this.eIM.iterator();
            while (it.hasNext()) {
                am next = it.next();
                if (next.EE()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public View eIO;
        public TextView hKr;
        public TextView hKs;
        public TextView hKt;
        public TextView hKu;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hKr = (TextView) view.findViewById(a.f.tvTaskTitle);
            this.hKs = (TextView) view.findViewById(a.f.tvTaskSubTitle);
            this.hKt = (TextView) view.findViewById(a.f.tvTaskRewardNum);
            this.hKu = (TextView) view.findViewById(a.f.tvTaskStatus);
            this.eIO = view.findViewById(a.f.divider);
        }
    }
}

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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.ala.tasklist.a.a icF;
    private Context mActivity;
    private int icG = -1;
    private ArrayList<ap> eTF = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.icF = aVar;
    }

    public void setData(ArrayList<ap> arrayList) {
        if (arrayList != null) {
            this.eTF.clear();
            this.eTF.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTF == null) {
            return 0;
        }
        return this.eTF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wr */
    public ap getItem(int i) {
        if (this.eTF == null) {
            return null;
        }
        return this.eTF.get(i);
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
            aVar.icJ.setText(apVar.aKN);
            aVar.icK.setText(apVar.aKS);
            aVar.icL.setText(this.mActivity.getResources().getString(a.h.ala_task_title_reward_mode, Integer.valueOf(apVar.aKR)));
            if (apVar.status == 3) {
                aVar.icL.setVisibility(8);
            } else {
                aVar.icL.setVisibility(0);
            }
            aVar.icM.setTag(Integer.valueOf(apVar.aKM));
            if (apVar.status == 2) {
                b(aVar);
            } else if (apVar.status == 3) {
                a(aVar, this.mActivity.getString(a.h.ala_task_status_success));
            } else {
                b(aVar, apVar);
            }
            aVar.icM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (apVar.status == 2 && b.this.icF != null) {
                        b.this.icF.wp(apVar.aKM);
                    }
                }
            });
        }
    }

    private void b(a aVar, ap apVar) {
        String string;
        if (apVar.Bb()) {
            if (this.icG < 0) {
                if (apVar.aKQ != null) {
                    this.icG = apVar.aKQ.aLd;
                }
                a(aVar);
                return;
            } else if (this.icG == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (apVar.Bc()) {
            string = this.mActivity.getResources().getString(a.h.ala_task_level_up_to_level_num, Integer.valueOf(apVar.aKQ.aLe));
        } else {
            string = this.mActivity.getString(a.h.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.icM.setText(StringHelper.formatSecondsTime(this.icG * 1000));
        aVar.icM.setBackgroundResource(a.e.ala_bg_rectangle_stroke_blue);
        aVar.icM.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_common_color_10260));
        b(aVar.icM, true);
    }

    private void a(a aVar, String str) {
        aVar.icM.setText(str);
        aVar.icM.setBackgroundResource(a.e.sdk_transparent_bg);
        aVar.icM.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_d));
        b(aVar.icM, false);
    }

    private void b(a aVar) {
        aVar.icM.setText(this.mActivity.getString(a.h.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.icM.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            aVar.icM.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.icM.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.icM.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue);
        }
        aVar.icM.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_g));
        b(aVar.icM, true);
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
        this.icG = num.intValue();
        ap Bf = Bf();
        if (Bf != null) {
            if (this.icG == 0) {
                Bf.status = 2;
            } else if (this.icG > 0) {
                Bf.status = 1;
            } else {
                Bf.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public ap Bf() {
        if (!ListUtils.isEmpty(this.eTF)) {
            Iterator<ap> it = this.eTF.iterator();
            while (it.hasNext()) {
                ap next = it.next();
                if (next.Bb()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public View bPy;
        public TextView icJ;
        public TextView icK;
        public TextView icL;
        public TextView icM;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.icJ = (TextView) view.findViewById(a.f.tvTaskTitle);
            this.icK = (TextView) view.findViewById(a.f.tvTaskSubTitle);
            this.icL = (TextView) view.findViewById(a.f.tvTaskRewardNum);
            this.icM = (TextView) view.findViewById(a.f.tvTaskStatus);
            this.bPy = view.findViewById(a.f.divider);
        }
    }
}

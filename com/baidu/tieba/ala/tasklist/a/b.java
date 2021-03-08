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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.ala.tasklist.a.a ijv;
    private Context mActivity;
    private int ijw = -1;
    private ArrayList<at> eXu = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.ijv = aVar;
    }

    public void setData(ArrayList<at> arrayList) {
        if (arrayList != null) {
            this.eXu.clear();
            this.eXu.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXu == null) {
            return 0;
        }
        return this.eXu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wD */
    public at getItem(int i) {
        if (this.eXu == null) {
            return null;
        }
        return this.eXu.get(i);
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
            aVar.ijz.setText(atVar.aPj);
            aVar.ijA.setText(atVar.aPo);
            aVar.ijB.setText(this.mActivity.getResources().getString(a.h.ala_task_title_reward_mode, Integer.valueOf(atVar.aPn)));
            if (atVar.status == 3) {
                aVar.ijB.setVisibility(8);
            } else {
                aVar.ijB.setVisibility(0);
            }
            aVar.ijC.setTag(Integer.valueOf(atVar.aPi));
            if (atVar.status == 2) {
                b(aVar);
            } else if (atVar.status == 3) {
                a(aVar, this.mActivity.getString(a.h.ala_task_status_success));
            } else {
                b(aVar, atVar);
            }
            aVar.ijC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (atVar.status == 2 && b.this.ijv != null) {
                        b.this.ijv.wB(atVar.aPi);
                    }
                }
            });
        }
    }

    private void b(a aVar, at atVar) {
        String string;
        if (atVar.Cr()) {
            if (this.ijw < 0) {
                if (atVar.aPm != null) {
                    this.ijw = atVar.aPm.aPz;
                }
                a(aVar);
                return;
            } else if (this.ijw == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (atVar.Cs()) {
            string = this.mActivity.getResources().getString(a.h.ala_task_level_up_to_level_num, Integer.valueOf(atVar.aPm.aPA));
        } else {
            string = this.mActivity.getString(a.h.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.ijC.setText(StringHelper.formatSecondsTime(this.ijw * 1000));
        aVar.ijC.setBackgroundResource(a.e.ala_bg_rectangle_stroke_blue);
        aVar.ijC.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_common_color_10260));
        c(aVar.ijC, true);
    }

    private void a(a aVar, String str) {
        aVar.ijC.setText(str);
        aVar.ijC.setBackgroundResource(a.e.sdk_transparent_bg);
        aVar.ijC.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_d));
        c(aVar.ijC, false);
    }

    private void b(a aVar) {
        aVar.ijC.setText(this.mActivity.getString(a.h.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.ijC.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            aVar.ijC.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.ijC.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.ijC.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue);
        }
        aVar.ijC.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_g));
        c(aVar.ijC, true);
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
        this.ijw = num.intValue();
        at Cv = Cv();
        if (Cv != null) {
            if (this.ijw == 0) {
                Cv.status = 2;
            } else if (this.ijw > 0) {
                Cv.status = 1;
            } else {
                Cv.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public at Cv() {
        if (!ListUtils.isEmpty(this.eXu)) {
            Iterator<at> it = this.eXu.iterator();
            while (it.hasNext()) {
                at next = it.next();
                if (next.Cr()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public View bUO;
        public TextView ijA;
        public TextView ijB;
        public TextView ijC;
        public TextView ijz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.ijz = (TextView) view.findViewById(a.f.tvTaskTitle);
            this.ijA = (TextView) view.findViewById(a.f.tvTaskSubTitle);
            this.ijB = (TextView) view.findViewById(a.f.tvTaskRewardNum);
            this.ijC = (TextView) view.findViewById(a.f.tvTaskStatus);
            this.bUO = view.findViewById(a.f.divider);
        }
    }
}

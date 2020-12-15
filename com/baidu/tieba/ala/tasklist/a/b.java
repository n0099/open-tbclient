package com.baidu.tieba.ala.tasklist.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.an;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.ala.tasklist.a.a hUQ;
    private Context mActivity;
    private int hUR = -1;
    private ArrayList<an> eOt = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.hUQ = aVar;
    }

    public void setData(ArrayList<an> arrayList) {
        if (arrayList != null) {
            this.eOt.clear();
            this.eOt.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xK */
    public an getItem(int i) {
        if (this.eOt == null) {
            return null;
        }
        return this.eOt.get(i);
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

    private void a(a aVar, final an anVar) {
        if (anVar != null) {
            aVar.hUU.setText(anVar.aOT);
            aVar.hUV.setText(anVar.aOY);
            aVar.hUW.setText(this.mActivity.getResources().getString(a.h.ala_task_title_reward_mode, Integer.valueOf(anVar.aOX)));
            if (anVar.status == 3) {
                aVar.hUW.setVisibility(8);
            } else {
                aVar.hUW.setVisibility(0);
            }
            aVar.hUX.setTag(Integer.valueOf(anVar.aOS));
            if (anVar.status == 2) {
                b(aVar);
            } else if (anVar.status == 3) {
                a(aVar, this.mActivity.getString(a.h.ala_task_status_success));
            } else {
                b(aVar, anVar);
            }
            aVar.hUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (anVar.status == 2 && b.this.hUQ != null) {
                        b.this.hUQ.xI(anVar.aOS);
                    }
                }
            });
        }
    }

    private void b(a aVar, an anVar) {
        String string;
        if (anVar.FG()) {
            if (this.hUR < 0) {
                if (anVar.aOW != null) {
                    this.hUR = anVar.aOW.aPb;
                }
                a(aVar);
                return;
            } else if (this.hUR == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (anVar.FH()) {
            string = this.mActivity.getResources().getString(a.h.ala_task_level_up_to_level_num, Integer.valueOf(anVar.aOW.aPc));
        } else {
            string = this.mActivity.getString(a.h.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.hUX.setText(StringHelper.formatSecondsTime(this.hUR * 1000));
        aVar.hUX.setBackgroundResource(a.e.ala_bg_rectangle_stroke_blue);
        aVar.hUX.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_common_color_10260));
        b(aVar.hUX, true);
    }

    private void a(a aVar, String str) {
        aVar.hUX.setText(str);
        aVar.hUX.setBackgroundResource(a.e.sdk_transparent_bg);
        aVar.hUX.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_d));
        b(aVar.hUX, false);
    }

    private void b(a aVar) {
        aVar.hUX.setText(this.mActivity.getString(a.h.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.hUX.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            aVar.hUX.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.hUX.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.hUX.setBackgroundResource(a.e.ala_btn_bg_round_rectangle_blue);
        }
        aVar.hUX.setTextColor(this.mActivity.getResources().getColor(a.c.sdk_cp_cont_g));
        b(aVar.hUX, true);
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
        this.hUR = num.intValue();
        an FK = FK();
        if (FK != null) {
            if (this.hUR == 0) {
                FK.status = 2;
            } else if (this.hUR > 0) {
                FK.status = 1;
            } else {
                FK.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public an FK() {
        if (!ListUtils.isEmpty(this.eOt)) {
            Iterator<an> it = this.eOt.iterator();
            while (it.hasNext()) {
                an next = it.next();
                if (next.FG()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public View eOv;
        public TextView hUU;
        public TextView hUV;
        public TextView hUW;
        public TextView hUX;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hUU = (TextView) view.findViewById(a.f.tvTaskTitle);
            this.hUV = (TextView) view.findViewById(a.f.tvTaskSubTitle);
            this.hUW = (TextView) view.findViewById(a.f.tvTaskRewardNum);
            this.hUX = (TextView) view.findViewById(a.f.tvTaskStatus);
            this.eOv = view.findViewById(a.f.divider);
        }
    }
}

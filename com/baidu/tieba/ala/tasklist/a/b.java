package com.baidu.tieba.ala.tasklist.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.ai;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.ala.tasklist.a.a hdt;
    private Context mActivity;
    private int hdu = -1;
    private ArrayList<ai> eiq = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.hdt = aVar;
    }

    public void setData(ArrayList<ai> arrayList) {
        if (arrayList != null) {
            this.eiq.clear();
            this.eiq.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eiq == null) {
            return 0;
        }
        return this.eiq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vt */
    public ai getItem(int i) {
        if (this.eiq == null) {
            return null;
        }
        return this.eiq.get(i);
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

    private void a(a aVar, final ai aiVar) {
        if (aiVar != null) {
            aVar.hdx.setText(aiVar.aIV);
            aVar.hdy.setText(aiVar.aJa);
            aVar.hdz.setText(this.mActivity.getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(aiVar.aIZ)));
            if (aiVar.status == 3) {
                aVar.hdz.setVisibility(8);
            } else {
                aVar.hdz.setVisibility(0);
            }
            aVar.hdA.setTag(Integer.valueOf(aiVar.aIU));
            if (aiVar.status == 2) {
                b(aVar);
            } else if (aiVar.status == 3) {
                a(aVar, this.mActivity.getString(a.i.ala_task_status_success));
            } else {
                b(aVar, aiVar);
            }
            aVar.hdA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aiVar.status == 2 && b.this.hdt != null) {
                        b.this.hdt.vr(aiVar.aIU);
                    }
                }
            });
        }
    }

    private void b(a aVar, ai aiVar) {
        String string;
        if (aiVar.Dc()) {
            if (this.hdu < 0) {
                if (aiVar.aIY != null) {
                    this.hdu = aiVar.aIY.aJd;
                }
                a(aVar);
                return;
            } else if (this.hdu == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (aiVar.Dd()) {
            string = this.mActivity.getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(aiVar.aIY.aJe));
        } else {
            string = this.mActivity.getString(a.i.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.hdA.setText(StringHelper.formatSecondsTime(this.hdu * 1000));
        aVar.hdA.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        aVar.hdA.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_common_color_10260));
        b(aVar.hdA, true);
    }

    private void a(a aVar, String str) {
        aVar.hdA.setText(str);
        aVar.hdA.setBackgroundResource(a.f.sdk_transparent_bg);
        aVar.hdA.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_d));
        b(aVar.hdA, false);
    }

    private void b(a aVar) {
        aVar.hdA.setText(this.mActivity.getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.hdA.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            aVar.hdA.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.hdA.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.hdA.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        aVar.hdA.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_g));
        b(aVar.hdA, true);
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
        this.hdu = num.intValue();
        ai Dg = Dg();
        if (Dg != null) {
            if (this.hdu == 0) {
                Dg.status = 2;
            } else if (this.hdu > 0) {
                Dg.status = 1;
            } else {
                Dg.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public ai Dg() {
        if (!ListUtils.isEmpty(this.eiq)) {
            Iterator<ai> it = this.eiq.iterator();
            while (it.hasNext()) {
                ai next = it.next();
                if (next.Dc()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public View eis;
        public TextView hdA;
        public TextView hdx;
        public TextView hdy;
        public TextView hdz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hdx = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.hdy = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.hdz = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.hdA = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.eis = view.findViewById(a.g.divider);
        }
    }
}

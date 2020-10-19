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
    private com.baidu.tieba.ala.tasklist.a.a hsw;
    private Context mActivity;
    private int hsx = -1;
    private ArrayList<ai> euy = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.hsw = aVar;
    }

    public void setData(ArrayList<ai> arrayList) {
        if (arrayList != null) {
            this.euy.clear();
            this.euy.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.euy == null) {
            return 0;
        }
        return this.euy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vZ */
    public ai getItem(int i) {
        if (this.euy == null) {
            return null;
        }
        return this.euy.get(i);
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
            aVar.hsA.setText(aiVar.aMa);
            aVar.hsB.setText(aiVar.aMf);
            aVar.hsC.setText(this.mActivity.getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(aiVar.aMe)));
            if (aiVar.status == 3) {
                aVar.hsC.setVisibility(8);
            } else {
                aVar.hsC.setVisibility(0);
            }
            aVar.hsD.setTag(Integer.valueOf(aiVar.aLZ));
            if (aiVar.status == 2) {
                b(aVar);
            } else if (aiVar.status == 3) {
                a(aVar, this.mActivity.getString(a.i.ala_task_status_success));
            } else {
                b(aVar, aiVar);
            }
            aVar.hsD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aiVar.status == 2 && b.this.hsw != null) {
                        b.this.hsw.vX(aiVar.aLZ);
                    }
                }
            });
        }
    }

    private void b(a aVar, ai aiVar) {
        String string;
        if (aiVar.DZ()) {
            if (this.hsx < 0) {
                if (aiVar.aMd != null) {
                    this.hsx = aiVar.aMd.aMi;
                }
                a(aVar);
                return;
            } else if (this.hsx == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (aiVar.Ea()) {
            string = this.mActivity.getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(aiVar.aMd.aMj));
        } else {
            string = this.mActivity.getString(a.i.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.hsD.setText(StringHelper.formatSecondsTime(this.hsx * 1000));
        aVar.hsD.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        aVar.hsD.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_common_color_10260));
        b(aVar.hsD, true);
    }

    private void a(a aVar, String str) {
        aVar.hsD.setText(str);
        aVar.hsD.setBackgroundResource(a.f.sdk_transparent_bg);
        aVar.hsD.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_d));
        b(aVar.hsD, false);
    }

    private void b(a aVar) {
        aVar.hsD.setText(this.mActivity.getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.hsD.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            aVar.hsD.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.hsD.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.hsD.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        aVar.hsD.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_g));
        b(aVar.hsD, true);
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

    public void m(Integer num) {
        this.hsx = num.intValue();
        ai Ed = Ed();
        if (Ed != null) {
            if (this.hsx == 0) {
                Ed.status = 2;
            } else if (this.hsx > 0) {
                Ed.status = 1;
            } else {
                Ed.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public ai Ed() {
        if (!ListUtils.isEmpty(this.euy)) {
            Iterator<ai> it = this.euy.iterator();
            while (it.hasNext()) {
                ai next = it.next();
                if (next.DZ()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public View euA;
        public TextView hsA;
        public TextView hsB;
        public TextView hsC;
        public TextView hsD;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hsA = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.hsB = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.hsC = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.hsD = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.euA = view.findViewById(a.g.divider);
        }
    }
}

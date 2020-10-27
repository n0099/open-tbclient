package com.baidu.tieba.ala.tasklist.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.al;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.ala.tasklist.a.a hEq;
    private Context mActivity;
    private int hEr = -1;
    private ArrayList<al> eCX = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.hEq = aVar;
    }

    public void setData(ArrayList<al> arrayList) {
        if (arrayList != null) {
            this.eCX.clear();
            this.eCX.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eCX == null) {
            return 0;
        }
        return this.eCX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wt */
    public al getItem(int i) {
        if (this.eCX == null) {
            return null;
        }
        return this.eCX.get(i);
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

    private void a(a aVar, final al alVar) {
        if (alVar != null) {
            aVar.hEu.setText(alVar.aMF);
            aVar.hEv.setText(alVar.aMK);
            aVar.hEw.setText(this.mActivity.getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(alVar.aMJ)));
            if (alVar.status == 3) {
                aVar.hEw.setVisibility(8);
            } else {
                aVar.hEw.setVisibility(0);
            }
            aVar.hEx.setTag(Integer.valueOf(alVar.aME));
            if (alVar.status == 2) {
                b(aVar);
            } else if (alVar.status == 3) {
                a(aVar, this.mActivity.getString(a.i.ala_task_status_success));
            } else {
                b(aVar, alVar);
            }
            aVar.hEx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (alVar.status == 2 && b.this.hEq != null) {
                        b.this.hEq.wr(alVar.aME);
                    }
                }
            });
        }
    }

    private void b(a aVar, al alVar) {
        String string;
        if (alVar.Ei()) {
            if (this.hEr < 0) {
                if (alVar.aMI != null) {
                    this.hEr = alVar.aMI.aMN;
                }
                a(aVar);
                return;
            } else if (this.hEr == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (alVar.Ej()) {
            string = this.mActivity.getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(alVar.aMI.aMO));
        } else {
            string = this.mActivity.getString(a.i.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.hEx.setText(StringHelper.formatSecondsTime(this.hEr * 1000));
        aVar.hEx.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        aVar.hEx.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_common_color_10260));
        b(aVar.hEx, true);
    }

    private void a(a aVar, String str) {
        aVar.hEx.setText(str);
        aVar.hEx.setBackgroundResource(a.f.sdk_transparent_bg);
        aVar.hEx.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_d));
        b(aVar.hEx, false);
    }

    private void b(a aVar) {
        aVar.hEx.setText(this.mActivity.getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.hEx.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            aVar.hEx.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.hEx.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.hEx.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        aVar.hEx.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_g));
        b(aVar.hEx, true);
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
        this.hEr = num.intValue();
        al Em = Em();
        if (Em != null) {
            if (this.hEr == 0) {
                Em.status = 2;
            } else if (this.hEr > 0) {
                Em.status = 1;
            } else {
                Em.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public al Em() {
        if (!ListUtils.isEmpty(this.eCX)) {
            Iterator<al> it = this.eCX.iterator();
            while (it.hasNext()) {
                al next = it.next();
                if (next.Ei()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public View eCZ;
        public TextView hEu;
        public TextView hEv;
        public TextView hEw;
        public TextView hEx;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.hEu = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.hEv = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.hEw = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.hEx = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.eCZ = view.findViewById(a.g.divider);
        }
    }
}

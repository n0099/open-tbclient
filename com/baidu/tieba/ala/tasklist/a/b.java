package com.baidu.tieba.ala.tasklist.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private com.baidu.tieba.ala.tasklist.a.a gMy;
    private Context mActivity;
    private int gMz = -1;
    private ArrayList<ab> dWx = new ArrayList<>();

    public b(Context context, com.baidu.tieba.ala.tasklist.a.a aVar) {
        this.mActivity = context;
        this.gMy = aVar;
    }

    public void setData(ArrayList<ab> arrayList) {
        if (arrayList != null) {
            this.dWx.clear();
            this.dWx.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWx == null) {
            return 0;
        }
        return this.dWx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sM */
    public ab getItem(int i) {
        if (this.dWx == null) {
            return null;
        }
        return this.dWx.get(i);
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

    private void a(a aVar, final ab abVar) {
        if (abVar != null) {
            aVar.gMC.setText(abVar.aCp);
            aVar.gMD.setText(abVar.aCu);
            aVar.gME.setText(this.mActivity.getResources().getString(a.i.ala_task_title_reward_mode, Integer.valueOf(abVar.aCt)));
            if (abVar.status == 3) {
                aVar.gME.setVisibility(8);
            } else {
                aVar.gME.setVisibility(0);
            }
            aVar.gMF.setTag(Integer.valueOf(abVar.aCo));
            if (abVar.status == 2) {
                b(aVar);
            } else if (abVar.status == 3) {
                a(aVar, this.mActivity.getString(a.i.ala_task_status_success));
            } else {
                b(aVar, abVar);
            }
            aVar.gMF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (abVar.status == 2 && b.this.gMy != null) {
                        b.this.gMy.sK(abVar.aCo);
                    }
                }
            });
        }
    }

    private void b(a aVar, ab abVar) {
        String string;
        if (abVar.xj()) {
            if (this.gMz < 0) {
                if (abVar.aCs != null) {
                    this.gMz = abVar.aCs.aCx;
                }
                a(aVar);
                return;
            } else if (this.gMz == 0) {
                b(aVar);
                return;
            } else {
                a(aVar);
                return;
            }
        }
        if (abVar.xk()) {
            string = this.mActivity.getResources().getString(a.i.ala_task_level_up_to_level_num, Integer.valueOf(abVar.aCs.aCy));
        } else {
            string = this.mActivity.getString(a.i.ala_task_status_not_over);
        }
        a(aVar, string);
    }

    private void a(a aVar) {
        aVar.gMF.setText(StringHelper.formatSecondsTime(this.gMz * 1000));
        aVar.gMF.setBackgroundResource(a.f.ala_bg_rectangle_stroke_blue);
        aVar.gMF.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_common_color_10260));
        b(aVar.gMF, true);
    }

    private void a(a aVar, String str) {
        aVar.gMF.setText(str);
        aVar.gMF.setBackgroundResource(a.f.sdk_transparent_bg);
        aVar.gMF.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_d));
        b(aVar.gMF, false);
    }

    private void b(a aVar) {
        aVar.gMF.setText(this.mActivity.getString(a.i.ala_task_status_can_get));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            aVar.gMF.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_hk);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            aVar.gMF.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            aVar.gMF.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue_qm);
        } else {
            aVar.gMF.setBackgroundResource(a.f.ala_btn_bg_round_rectangle_blue);
        }
        aVar.gMF.setTextColor(this.mActivity.getResources().getColor(a.d.sdk_cp_cont_g));
        b(aVar.gMF, true);
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

    public void j(Integer num) {
        this.gMz = num.intValue();
        ab xn = xn();
        if (xn != null) {
            if (this.gMz == 0) {
                xn.status = 2;
            } else if (this.gMz > 0) {
                xn.status = 1;
            } else {
                xn.status = 3;
            }
        }
        notifyDataSetChanged();
    }

    public ab xn() {
        if (!ListUtils.isEmpty(this.dWx)) {
            Iterator<ab> it = this.dWx.iterator();
            while (it.hasNext()) {
                ab next = it.next();
                if (next.xj()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public View dWz;
        public TextView gMC;
        public TextView gMD;
        public TextView gME;
        public TextView gMF;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gMC = (TextView) view.findViewById(a.g.tvTaskTitle);
            this.gMD = (TextView) view.findViewById(a.g.tvTaskSubTitle);
            this.gME = (TextView) view.findViewById(a.g.tvTaskRewardNum);
            this.gMF = (TextView) view.findViewById(a.g.tvTaskStatus);
            this.dWz = view.findViewById(a.g.divider);
        }
    }
}

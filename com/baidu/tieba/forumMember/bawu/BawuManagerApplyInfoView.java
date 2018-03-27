package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View aHT;
    private TextView dAw;
    private TextView dAx;
    private TextView dAy;
    private Context mContext;

    public BawuManagerApplyInfoView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public BawuManagerApplyInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public BawuManagerApplyInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.aHT = LayoutInflater.from(this.mContext).inflate(d.h.bawu_manager_apply_layout, this);
        this.dAw = (TextView) this.aHT.findViewById(d.g.imageview_apply_btn);
        this.dAx = (TextView) this.aHT.findViewById(d.g.textview_manager_apply);
        this.dAy = (TextView) this.aHT.findViewById(d.g.textview_manager_left_num);
    }

    public void V(String str, int i) {
        this.dAx.setText(str);
        if (i > 0) {
            this.dAy.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), am.C(i)));
            this.dAw.setEnabled(true);
            this.dAw.setClickable(true);
            aj.e(this.dAx, d.C0141d.cp_link_tip_a, 1);
            aj.e(this.dAy, d.C0141d.cp_cont_d, 1);
            aj.s(this.dAw, d.f.bg_manager_apply);
            return;
        }
        this.dAy.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
        this.dAw.setEnabled(false);
        this.dAw.setClickable(false);
        aj.e(this.dAx, d.C0141d.cp_cont_d, 1);
        aj.e(this.dAy, d.C0141d.cp_cont_d, 1);
        aj.s(this.dAw, d.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dAw.setOnClickListener(onClickListener);
    }
}

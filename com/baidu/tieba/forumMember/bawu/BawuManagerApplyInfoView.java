package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View bub;
    private TextView eUk;
    private TextView eUl;
    private TextView eUm;
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
        this.bub = LayoutInflater.from(this.mContext).inflate(d.h.bawu_manager_apply_layout, this);
        this.eUk = (TextView) this.bub.findViewById(d.g.imageview_apply_btn);
        this.eUl = (TextView) this.bub.findViewById(d.g.textview_manager_apply);
        this.eUm = (TextView) this.bub.findViewById(d.g.textview_manager_left_num);
    }

    public void aw(String str, int i) {
        this.eUl.setText(str);
        if (i > 0) {
            this.eUm.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), ap.as(i)));
            this.eUk.setEnabled(true);
            this.eUk.setClickable(true);
            al.d(this.eUl, d.C0277d.cp_link_tip_a, 1);
            al.d(this.eUm, d.C0277d.cp_cont_d, 1);
            al.k(this.eUk, d.f.bg_manager_apply);
            return;
        }
        this.eUm.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
        this.eUk.setEnabled(false);
        this.eUk.setClickable(false);
        al.d(this.eUl, d.C0277d.cp_cont_d, 1);
        al.d(this.eUm, d.C0277d.cp_cont_d, 1);
        al.k(this.eUk, d.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eUk.setOnClickListener(onClickListener);
    }
}

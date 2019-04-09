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
    private View buc;
    private TextView eUl;
    private TextView eUm;
    private TextView eUn;
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
        this.buc = LayoutInflater.from(this.mContext).inflate(d.h.bawu_manager_apply_layout, this);
        this.eUl = (TextView) this.buc.findViewById(d.g.imageview_apply_btn);
        this.eUm = (TextView) this.buc.findViewById(d.g.textview_manager_apply);
        this.eUn = (TextView) this.buc.findViewById(d.g.textview_manager_left_num);
    }

    public void aw(String str, int i) {
        this.eUm.setText(str);
        if (i > 0) {
            this.eUn.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), ap.as(i)));
            this.eUl.setEnabled(true);
            this.eUl.setClickable(true);
            al.d(this.eUm, d.C0277d.cp_link_tip_a, 1);
            al.d(this.eUn, d.C0277d.cp_cont_d, 1);
            al.k(this.eUl, d.f.bg_manager_apply);
            return;
        }
        this.eUn.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
        this.eUl.setEnabled(false);
        this.eUl.setClickable(false);
        al.d(this.eUm, d.C0277d.cp_cont_d, 1);
        al.d(this.eUn, d.C0277d.cp_cont_d, 1);
        al.k(this.eUl, d.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eUl.setOnClickListener(onClickListener);
    }
}

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
    private View btY;
    private TextView eUA;
    private TextView eUy;
    private TextView eUz;
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
        this.btY = LayoutInflater.from(this.mContext).inflate(d.h.bawu_manager_apply_layout, this);
        this.eUy = (TextView) this.btY.findViewById(d.g.imageview_apply_btn);
        this.eUz = (TextView) this.btY.findViewById(d.g.textview_manager_apply);
        this.eUA = (TextView) this.btY.findViewById(d.g.textview_manager_left_num);
    }

    public void aw(String str, int i) {
        this.eUz.setText(str);
        if (i > 0) {
            this.eUA.setText(String.format(this.mContext.getResources().getString(d.j.apply_left_num_tip), ap.as(i)));
            this.eUy.setEnabled(true);
            this.eUy.setClickable(true);
            al.d(this.eUz, d.C0277d.cp_link_tip_a, 1);
            al.d(this.eUA, d.C0277d.cp_cont_d, 1);
            al.k(this.eUy, d.f.bg_manager_apply);
            return;
        }
        this.eUA.setText(this.mContext.getResources().getString(d.j.apply_no_left_tip));
        this.eUy.setEnabled(false);
        this.eUy.setClickable(false);
        al.d(this.eUz, d.C0277d.cp_cont_d, 1);
        al.d(this.eUA, d.C0277d.cp_cont_d, 1);
        al.k(this.eUy, d.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eUy.setOnClickListener(onClickListener);
    }
}

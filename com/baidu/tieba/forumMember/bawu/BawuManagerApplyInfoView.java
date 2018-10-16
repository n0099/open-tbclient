package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View aix;
    private TextView dvW;
    private TextView dvX;
    private TextView dvY;
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
        this.aix = LayoutInflater.from(this.mContext).inflate(e.h.bawu_manager_apply_layout, this);
        this.dvW = (TextView) this.aix.findViewById(e.g.imageview_apply_btn);
        this.dvX = (TextView) this.aix.findViewById(e.g.textview_manager_apply);
        this.dvY = (TextView) this.aix.findViewById(e.g.textview_manager_left_num);
    }

    public void aa(String str, int i) {
        this.dvX.setText(str);
        if (i > 0) {
            this.dvY.setText(String.format(this.mContext.getResources().getString(e.j.apply_left_num_tip), ao.G(i)));
            this.dvW.setEnabled(true);
            this.dvW.setClickable(true);
            al.c(this.dvX, e.d.cp_link_tip_a, 1);
            al.c(this.dvY, e.d.cp_cont_d, 1);
            al.i(this.dvW, e.f.bg_manager_apply);
            return;
        }
        this.dvY.setText(this.mContext.getResources().getString(e.j.apply_no_left_tip));
        this.dvW.setEnabled(false);
        this.dvW.setClickable(false);
        al.c(this.dvX, e.d.cp_cont_d, 1);
        al.c(this.dvY, e.d.cp_cont_d, 1);
        al.i(this.dvW, e.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dvW.setOnClickListener(onClickListener);
    }
}

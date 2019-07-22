package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private TextView fpu;
    private TextView fpv;
    private TextView fpw;
    private Context mContext;
    private View mRoot;

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
        this.mRoot = LayoutInflater.from(this.mContext).inflate(R.layout.bawu_manager_apply_layout, this);
        this.fpu = (TextView) this.mRoot.findViewById(R.id.imageview_apply_btn);
        this.fpv = (TextView) this.mRoot.findViewById(R.id.textview_manager_apply);
        this.fpw = (TextView) this.mRoot.findViewById(R.id.textview_manager_left_num);
    }

    public void at(String str, int i) {
        this.fpv.setText(str);
        if (i > 0) {
            this.fpw.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), aq.aH(i)));
            this.fpu.setEnabled(true);
            this.fpu.setClickable(true);
            am.f(this.fpv, R.color.cp_link_tip_a, 1);
            am.f(this.fpw, R.color.cp_cont_d, 1);
            am.k(this.fpu, R.drawable.bg_manager_apply);
            return;
        }
        this.fpw.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.fpu.setEnabled(false);
        this.fpu.setClickable(false);
        am.f(this.fpv, R.color.cp_cont_d, 1);
        am.f(this.fpw, R.color.cp_cont_d, 1);
        am.k(this.fpu, R.drawable.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fpu.setOnClickListener(onClickListener);
    }
}

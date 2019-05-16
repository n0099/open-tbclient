package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View bBg;
    private TextView fkv;
    private TextView fkw;
    private TextView fkx;
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
        this.bBg = LayoutInflater.from(this.mContext).inflate(R.layout.bawu_manager_apply_layout, this);
        this.fkv = (TextView) this.bBg.findViewById(R.id.imageview_apply_btn);
        this.fkw = (TextView) this.bBg.findViewById(R.id.textview_manager_apply);
        this.fkx = (TextView) this.bBg.findViewById(R.id.textview_manager_left_num);
    }

    public void as(String str, int i) {
        this.fkw.setText(str);
        if (i > 0) {
            this.fkx.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), ap.aG(i)));
            this.fkv.setEnabled(true);
            this.fkv.setClickable(true);
            al.f(this.fkw, R.color.cp_link_tip_a, 1);
            al.f(this.fkx, R.color.cp_cont_d, 1);
            al.k(this.fkv, R.drawable.bg_manager_apply);
            return;
        }
        this.fkx.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.fkv.setEnabled(false);
        this.fkv.setClickable(false);
        al.f(this.fkw, R.color.cp_cont_d, 1);
        al.f(this.fkx, R.color.cp_cont_d, 1);
        al.k(this.fkv, R.drawable.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fkv.setOnClickListener(onClickListener);
    }
}

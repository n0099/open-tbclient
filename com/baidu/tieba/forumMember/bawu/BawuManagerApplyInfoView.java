package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private TextView hNY;
    private TextView hNZ;
    private TextView hOa;
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
        this.hNY = (TextView) this.mRoot.findViewById(R.id.imageview_apply_btn);
        this.hNZ = (TextView) this.mRoot.findViewById(R.id.textview_manager_apply);
        this.hOa = (TextView) this.mRoot.findViewById(R.id.textview_manager_left_num);
    }

    public void aK(String str, int i) {
        this.hNZ.setText(str);
        this.hNY.setBackgroundDrawable(SvgManager.bjq().a(R.drawable.ic_icon_pure_ba_add_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS_DISABLE));
        if (i > 0) {
            this.hOa.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), at.numberUniformFormat(i)));
            this.hNY.setEnabled(true);
            this.hNY.setClickable(true);
            ap.setViewTextColor(this.hNZ, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hOa, R.color.cp_link_tip_d, 1);
            return;
        }
        this.hOa.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.hNY.setEnabled(false);
        this.hNY.setClickable(false);
        ap.setViewTextColor(this.hNZ, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.hOa, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hNY.setOnClickListener(onClickListener);
    }
}

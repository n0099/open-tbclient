package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private TextView hAJ;
    private TextView hAK;
    private TextView hAL;
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
        this.hAJ = (TextView) this.mRoot.findViewById(R.id.imageview_apply_btn);
        this.hAK = (TextView) this.mRoot.findViewById(R.id.textview_manager_apply);
        this.hAL = (TextView) this.mRoot.findViewById(R.id.textview_manager_left_num);
    }

    public void aH(String str, int i) {
        this.hAK.setText(str);
        this.hAJ.setBackgroundDrawable(SvgManager.baR().a(R.drawable.ic_icon_pure_ba_add_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS_DISABLE));
        if (i > 0) {
            this.hAL.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), as.numberUniformFormat(i)));
            this.hAJ.setEnabled(true);
            this.hAJ.setClickable(true);
            ao.setViewTextColor(this.hAK, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.hAL, R.color.cp_link_tip_d, 1);
            return;
        }
        this.hAL.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.hAJ.setEnabled(false);
        this.hAJ.setClickable(false);
        ao.setViewTextColor(this.hAK, R.color.cp_cont_d, 1);
        ao.setViewTextColor(this.hAL, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hAJ.setOnClickListener(onClickListener);
    }
}

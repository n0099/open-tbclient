package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private TextView huX;
    private TextView huY;
    private TextView huZ;
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
        this.huX = (TextView) this.mRoot.findViewById(R.id.imageview_apply_btn);
        this.huY = (TextView) this.mRoot.findViewById(R.id.textview_manager_apply);
        this.huZ = (TextView) this.mRoot.findViewById(R.id.textview_manager_left_num);
    }

    public void aI(String str, int i) {
        this.huY.setText(str);
        this.huX.setBackgroundDrawable(SvgManager.aWQ().a(R.drawable.ic_icon_pure_ba_add_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS_DISABLE));
        if (i > 0) {
            this.huZ.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), ar.numberUniformFormat(i)));
            this.huX.setEnabled(true);
            this.huX.setClickable(true);
            an.setViewTextColor(this.huY, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.huZ, R.color.cp_link_tip_d, 1);
            return;
        }
        this.huZ.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.huX.setEnabled(false);
        this.huX.setClickable(false);
        an.setViewTextColor(this.huY, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.huZ, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.huX.setOnClickListener(onClickListener);
    }
}

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
/* loaded from: classes23.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private TextView iCA;
    private TextView iCy;
    private TextView iCz;
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
        this.iCy = (TextView) this.mRoot.findViewById(R.id.imageview_apply_btn);
        this.iCz = (TextView) this.mRoot.findViewById(R.id.textview_manager_apply);
        this.iCA = (TextView) this.mRoot.findViewById(R.id.textview_manager_left_num);
    }

    public void aO(String str, int i) {
        this.iCz.setText(str);
        this.iCy.setBackgroundDrawable(SvgManager.brn().a(R.drawable.ic_icon_pure_ba_add_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS_DISABLE));
        if (i > 0) {
            this.iCA.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), at.numberUniformFormat(i)));
            this.iCy.setEnabled(true);
            this.iCy.setClickable(true);
            ap.setViewTextColor(this.iCz, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.iCA, R.color.cp_link_tip_d, 1);
            return;
        }
        this.iCA.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.iCy.setEnabled(false);
        this.iCy.setClickable(false);
        ap.setViewTextColor(this.iCz, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.iCA, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iCy.setOnClickListener(onClickListener);
    }
}

package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private TextView gjJ;
    private TextView gjK;
    private TextView gjL;
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
        this.gjJ = (TextView) this.mRoot.findViewById(R.id.imageview_apply_btn);
        this.gjK = (TextView) this.mRoot.findViewById(R.id.textview_manager_apply);
        this.gjL = (TextView) this.mRoot.findViewById(R.id.textview_manager_left_num);
    }

    public void ay(String str, int i) {
        this.gjK.setText(str);
        this.gjJ.setBackgroundDrawable(SvgManager.aGC().a(R.drawable.ic_icon_pure_ba_add_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS_DISABLE));
        if (i > 0) {
            this.gjL.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), aq.numberUniformFormat(i)));
            this.gjJ.setEnabled(true);
            this.gjJ.setClickable(true);
            am.setViewTextColor(this.gjK, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gjL, R.color.cp_link_tip_d, 1);
            return;
        }
        this.gjL.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.gjJ.setEnabled(false);
        this.gjJ.setClickable(false);
        am.setViewTextColor(this.gjK, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.gjL, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gjJ.setOnClickListener(onClickListener);
    }
}

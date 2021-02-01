package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private TextView jbs;
    private TextView jbt;
    private TextView jbu;
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
        this.jbs = (TextView) this.mRoot.findViewById(R.id.imageview_apply_btn);
        this.jbt = (TextView) this.mRoot.findViewById(R.id.textview_manager_apply);
        this.jbu = (TextView) this.mRoot.findViewById(R.id.textview_manager_left_num);
    }

    public void aW(String str, int i) {
        this.jbt.setText(str);
        this.jbs.setBackgroundDrawable(SvgManager.bsR().a(R.drawable.ic_icon_pure_ba_add_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS_DISABLE));
        if (i > 0) {
            this.jbu.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), au.numberUniformFormat(i)));
            this.jbs.setEnabled(true);
            this.jbs.setClickable(true);
            ap.setViewTextColor(this.jbt, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.jbu, R.color.CAM_X0305, 1);
            return;
        }
        this.jbu.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.jbs.setEnabled(false);
        this.jbs.setClickable(false);
        ap.setViewTextColor(this.jbt, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.jbu, R.color.CAM_X0109, 1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jbs.setOnClickListener(onClickListener);
    }
}

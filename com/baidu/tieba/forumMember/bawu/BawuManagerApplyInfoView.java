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
/* loaded from: classes23.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private TextView iOf;
    private TextView iOg;
    private TextView iOh;
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
        this.iOf = (TextView) this.mRoot.findViewById(R.id.imageview_apply_btn);
        this.iOg = (TextView) this.mRoot.findViewById(R.id.textview_manager_apply);
        this.iOh = (TextView) this.mRoot.findViewById(R.id.textview_manager_left_num);
    }

    public void aO(String str, int i) {
        this.iOg.setText(str);
        this.iOf.setBackgroundDrawable(SvgManager.btW().a(R.drawable.ic_icon_pure_ba_add_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS_DISABLE));
        if (i > 0) {
            this.iOh.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), au.numberUniformFormat(i)));
            this.iOf.setEnabled(true);
            this.iOf.setClickable(true);
            ap.setViewTextColor(this.iOg, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.iOh, R.color.CAM_X0305, 1);
            return;
        }
        this.iOh.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.iOf.setEnabled(false);
        this.iOf.setClickable(false);
        ap.setViewTextColor(this.iOg, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.iOh, R.color.CAM_X0109, 1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iOf.setOnClickListener(onClickListener);
    }
}

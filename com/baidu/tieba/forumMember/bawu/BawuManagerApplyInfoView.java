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
/* loaded from: classes7.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private TextView gex;
    private TextView gey;
    private TextView gez;
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
        this.gex = (TextView) this.mRoot.findViewById(R.id.imageview_apply_btn);
        this.gey = (TextView) this.mRoot.findViewById(R.id.textview_manager_apply);
        this.gez = (TextView) this.mRoot.findViewById(R.id.textview_manager_left_num);
    }

    public void az(String str, int i) {
        this.gey.setText(str);
        if (i > 0) {
            this.gez.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), aq.numberUniformFormat(i)));
            this.gex.setEnabled(true);
            this.gex.setClickable(true);
            am.setViewTextColor(this.gey, R.color.cp_link_tip_a, 1);
            am.setViewTextColor(this.gez, R.color.cp_cont_d, 1);
            am.setBackgroundResource(this.gex, R.drawable.bg_manager_apply);
            return;
        }
        this.gez.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.gex.setEnabled(false);
        this.gex.setClickable(false);
        am.setViewTextColor(this.gey, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.gez, R.color.cp_cont_d, 1);
        am.setBackgroundResource(this.gex, R.drawable.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gex.setOnClickListener(onClickListener);
    }
}

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
    private TextView frH;
    private TextView frI;
    private TextView frJ;
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
        this.frH = (TextView) this.mRoot.findViewById(R.id.imageview_apply_btn);
        this.frI = (TextView) this.mRoot.findViewById(R.id.textview_manager_apply);
        this.frJ = (TextView) this.mRoot.findViewById(R.id.textview_manager_left_num);
    }

    public void av(String str, int i) {
        this.frI.setText(str);
        if (i > 0) {
            this.frJ.setText(String.format(this.mContext.getResources().getString(R.string.apply_left_num_tip), aq.aH(i)));
            this.frH.setEnabled(true);
            this.frH.setClickable(true);
            am.f(this.frI, R.color.cp_link_tip_a, 1);
            am.f(this.frJ, R.color.cp_cont_d, 1);
            am.k(this.frH, R.drawable.bg_manager_apply);
            return;
        }
        this.frJ.setText(this.mContext.getResources().getString(R.string.apply_no_left_tip));
        this.frH.setEnabled(false);
        this.frH.setClickable(false);
        am.f(this.frI, R.color.cp_cont_d, 1);
        am.f(this.frJ, R.color.cp_cont_d, 1);
        am.k(this.frH, R.drawable.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.frH.setOnClickListener(onClickListener);
    }
}

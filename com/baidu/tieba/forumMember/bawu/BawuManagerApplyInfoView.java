package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View aaW;
    private TextView dib;
    private TextView dic;
    private TextView did;
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
        this.aaW = LayoutInflater.from(this.mContext).inflate(f.h.bawu_manager_apply_layout, this);
        this.dib = (TextView) this.aaW.findViewById(f.g.imageview_apply_btn);
        this.dic = (TextView) this.aaW.findViewById(f.g.textview_manager_apply);
        this.did = (TextView) this.aaW.findViewById(f.g.textview_manager_left_num);
    }

    public void R(String str, int i) {
        this.dic.setText(str);
        if (i > 0) {
            this.did.setText(String.format(this.mContext.getResources().getString(f.j.apply_left_num_tip), ap.A(i)));
            this.dib.setEnabled(true);
            this.dib.setClickable(true);
            am.c(this.dic, f.d.cp_link_tip_a, 1);
            am.c(this.did, f.d.cp_cont_d, 1);
            am.i(this.dib, f.C0146f.bg_manager_apply);
            return;
        }
        this.did.setText(this.mContext.getResources().getString(f.j.apply_no_left_tip));
        this.dib.setEnabled(false);
        this.dib.setClickable(false);
        am.c(this.dic, f.d.cp_cont_d, 1);
        am.c(this.did, f.d.cp_cont_d, 1);
        am.i(this.dib, f.C0146f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dib.setOnClickListener(onClickListener);
    }
}

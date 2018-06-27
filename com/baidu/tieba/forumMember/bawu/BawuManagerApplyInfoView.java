package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    private View abt;
    private TextView dfn;
    private TextView dfo;
    private TextView dfp;
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
        this.abt = LayoutInflater.from(this.mContext).inflate(d.i.bawu_manager_apply_layout, this);
        this.dfn = (TextView) this.abt.findViewById(d.g.imageview_apply_btn);
        this.dfo = (TextView) this.abt.findViewById(d.g.textview_manager_apply);
        this.dfp = (TextView) this.abt.findViewById(d.g.textview_manager_left_num);
    }

    public void V(String str, int i) {
        this.dfo.setText(str);
        if (i > 0) {
            this.dfp.setText(String.format(this.mContext.getResources().getString(d.k.apply_left_num_tip), ap.z(i)));
            this.dfn.setEnabled(true);
            this.dfn.setClickable(true);
            am.c(this.dfo, d.C0142d.cp_link_tip_a, 1);
            am.c(this.dfp, d.C0142d.cp_cont_d, 1);
            am.i(this.dfn, d.f.bg_manager_apply);
            return;
        }
        this.dfp.setText(this.mContext.getResources().getString(d.k.apply_no_left_tip));
        this.dfn.setEnabled(false);
        this.dfn.setClickable(false);
        am.c(this.dfo, d.C0142d.cp_cont_d, 1);
        am.c(this.dfp, d.C0142d.cp_cont_d, 1);
        am.i(this.dfn, d.f.icon_number_add_d);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dfn.setOnClickListener(onClickListener);
    }
}

package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes9.dex */
public class d implements a, b {
    private View hIM;
    private z hIN;
    private TextView hIQ;
    private TextView hIR;
    private TextView hIS;
    private TbClipImageView hIT;
    private ImageView hzB;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.a(view.getContext(), d.this.hIN, d.this.hIM);
            e.c(d.this.hIN);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.hIQ = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.hIR = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.hIS = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.hIT = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.hIT.setDrawerType(1);
        this.hIT.setIsRound(true);
        this.hIT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.hIM = this.mRootView.findViewById(R.id.view_red_dot);
        this.hzB = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(y yVar) {
        z zVar;
        if (yVar != null && !v.isEmpty(yVar.dataList) && (zVar = yVar.dataList.get(0)) != null) {
            this.hIN = zVar;
            if (this.hIN.lkY != null) {
                this.hIR.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.hIR.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.hIS.setText(aq.ah(zVar.name, 20));
            this.hIT.startLoad(zVar.imageUrl, 10, false);
            this.hIM.setVisibility(zVar.gQs ? 0 : 8);
            e.b(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.hIR, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hIS, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.hIM.setBackground(am.getDrawable(R.drawable.frs_service_red_dot));
        this.hzB.setImageDrawable(SvgManager.aUW().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.hIQ.setTextColor(i);
    }
}

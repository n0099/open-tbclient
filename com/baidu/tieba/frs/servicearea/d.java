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
    private ImageView hjU;
    private View htf;
    private z htg;
    private TextView htj;
    private TextView htk;
    private TextView htl;
    private TbClipImageView htm;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.a(view.getContext(), d.this.htg, d.this.htf);
            e.c(d.this.htg);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.htj = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.htk = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.htl = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.htm = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.htm.setDrawerType(1);
        this.htm.setIsRound(true);
        this.htm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.htf = this.mRootView.findViewById(R.id.view_red_dot);
        this.hjU = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(y yVar) {
        z zVar;
        if (yVar != null && !v.isEmpty(yVar.dataList) && (zVar = yVar.dataList.get(0)) != null) {
            this.htg = zVar;
            if (this.htg.kRv != null) {
                this.htk.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.htk.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.htl.setText(aq.ag(zVar.name, 20));
            this.htm.startLoad(zVar.imageUrl, 10, false);
            this.htf.setVisibility(zVar.gBs ? 0 : 8);
            e.b(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.htk, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htl, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.htf.setBackground(am.getDrawable(R.drawable.frs_service_red_dot));
        this.hjU.setImageDrawable(SvgManager.aOU().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.htj.setTextColor(i);
    }
}

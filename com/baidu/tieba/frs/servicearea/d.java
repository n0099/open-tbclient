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
    private ImageView hka;
    private View htl;
    private z htm;
    private TextView htp;
    private TextView htq;
    private TextView htr;
    private TbClipImageView hts;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.a(view.getContext(), d.this.htm, d.this.htl);
            e.c(d.this.htm);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.htp = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.htq = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.htr = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.hts = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.hts.setDrawerType(1);
        this.hts.setIsRound(true);
        this.hts.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.htl = this.mRootView.findViewById(R.id.view_red_dot);
        this.hka = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(y yVar) {
        z zVar;
        if (yVar != null && !v.isEmpty(yVar.dataList) && (zVar = yVar.dataList.get(0)) != null) {
            this.htm = zVar;
            if (this.htm.kRz != null) {
                this.htq.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.htq.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.htr.setText(aq.ag(zVar.name, 20));
            this.hts.startLoad(zVar.imageUrl, 10, false);
            this.htl.setVisibility(zVar.gBy ? 0 : 8);
            e.b(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.htq, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htr, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.htl.setBackground(am.getDrawable(R.drawable.frs_service_red_dot));
        this.hka.setImageDrawable(SvgManager.aOR().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.htp.setTextColor(i);
    }
}

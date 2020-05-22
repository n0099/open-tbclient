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
    private View hHZ;
    private z hIa;
    private TextView hId;
    private TextView hIe;
    private TextView hIf;
    private TbClipImageView hIg;
    private ImageView hyO;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.a(view.getContext(), d.this.hIa, d.this.hHZ);
            e.c(d.this.hIa);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.hId = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.hIe = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.hIf = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.hIg = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.hIg.setDrawerType(1);
        this.hIg.setIsRound(true);
        this.hIg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.hHZ = this.mRootView.findViewById(R.id.view_red_dot);
        this.hyO = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(y yVar) {
        z zVar;
        if (yVar != null && !v.isEmpty(yVar.dataList) && (zVar = yVar.dataList.get(0)) != null) {
            this.hIa = zVar;
            if (this.hIa.ljP != null) {
                this.hIe.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.hIe.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.hIf.setText(aq.ah(zVar.name, 20));
            this.hIg.startLoad(zVar.imageUrl, 10, false);
            this.hHZ.setVisibility(zVar.gQh ? 0 : 8);
            e.b(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.hIe, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hIf, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.hHZ.setBackground(am.getDrawable(R.drawable.frs_service_red_dot));
        this.hyO.setImageDrawable(SvgManager.aUV().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.hId.setTextColor(i);
    }
}

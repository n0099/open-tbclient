package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes9.dex */
public class d implements a, b {
    private ImageView hMJ;
    private View hVY;
    private z hVZ;
    private TextView hWc;
    private TextView hWd;
    private TextView hWe;
    private TbClipImageView hWf;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.a(view.getContext(), d.this.hVZ, d.this.hVY);
            e.c(d.this.hVZ);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.hWc = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.hWd = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.hWe = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.hWf = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.hWf.setDrawerType(1);
        this.hWf.setIsRound(true);
        this.hWf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.hVY = this.mRootView.findViewById(R.id.view_red_dot);
        this.hMJ = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(y yVar) {
        z zVar;
        if (yVar != null && !w.isEmpty(yVar.dataList) && (zVar = yVar.dataList.get(0)) != null) {
            this.hVZ = zVar;
            if (this.hVZ.lES != null) {
                this.hWd.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.hWd.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.hWe.setText(ar.ah(zVar.name, 20));
            this.hWf.startLoad(zVar.imageUrl, 10, false);
            this.hVY.setVisibility(zVar.hdb ? 0 : 8);
            e.b(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        an.setViewTextColor(this.hWd, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hWe, (int) R.color.cp_cont_b);
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.hVY.setBackground(an.getDrawable(R.drawable.frs_service_red_dot));
        this.hMJ.setImageDrawable(SvgManager.aWQ().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.hWc.setTextColor(i);
    }
}

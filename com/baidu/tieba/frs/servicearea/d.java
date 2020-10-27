package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes22.dex */
public class d implements a, b {
    private TextView dDh;
    private ImageView iPp;
    private View iYR;
    private aa iYS;
    private TextView iYV;
    private TextView iYW;
    private TbClipImageView iYX;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.iYS != null && d.this.iYS.mPU != null) {
                TiebaStatic.log(new aq("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", d.this.iYS.forumId).dR("obj_source", "frs_card").dR("obj_id", d.this.iYS.mPU.id).dR("obj_name", d.this.iYS.mPU.name).aj("obj_param1", d.this.iYS.mPU.emo.intValue()));
            }
            e.a(view.getContext(), d.this.iYS, d.this.iYR);
            e.c(d.this.iYS);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dDh = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.iYV = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.iYW = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.iYX = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.iYX.setDrawerType(1);
        this.iYX.setIsRound(true);
        this.iYX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.iYR = this.mRootView.findViewById(R.id.view_red_dot);
        this.iPp = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(z zVar) {
        aa aaVar;
        if (zVar != null && !y.isEmpty(zVar.dataList) && (aaVar = zVar.dataList.get(0)) != null) {
            this.iYS = aaVar;
            if (this.iYS.mPU != null) {
                this.iYV.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.iYV.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.iYW.setText(at.ak(aaVar.name, 20));
            this.iYX.startLoad(aaVar.imageUrl, 10, false);
            this.iYR.setVisibility(aaVar.beq ? 0 : 8);
            e.b(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.iYV, R.color.cp_cont_b);
        ap.setViewTextColor(this.iYW, R.color.cp_cont_b);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.iYR.setBackground(ap.getDrawable(R.drawable.frs_service_red_dot));
        this.iPp.setImageDrawable(SvgManager.boN().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.dDh.setTextColor(i);
    }
}

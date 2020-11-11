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
    private TextView dIZ;
    private ImageView iVm;
    private View jeO;
    private aa jeP;
    private TextView jeS;
    private TextView jeT;
    private TbClipImageView jeU;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.jeP != null && d.this.jeP.mVX != null) {
                TiebaStatic.log(new aq("c13274").w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", d.this.jeP.forumId).dR("obj_source", "frs_card").dR("obj_id", d.this.jeP.mVX.id).dR("obj_name", d.this.jeP.mVX.name).al("obj_param1", d.this.jeP.mVX.esj.intValue()));
            }
            e.a(view.getContext(), d.this.jeP, d.this.jeO);
            e.c(d.this.jeP);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dIZ = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.jeS = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.jeT = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.jeU = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.jeU.setDrawerType(1);
        this.jeU.setIsRound(true);
        this.jeU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.jeO = this.mRootView.findViewById(R.id.view_red_dot);
        this.iVm = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(z zVar) {
        aa aaVar;
        if (zVar != null && !y.isEmpty(zVar.dataList) && (aaVar = zVar.dataList.get(0)) != null) {
            this.jeP = aaVar;
            if (this.jeP.mVX != null) {
                this.jeS.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.jeS.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.jeT.setText(at.am(aaVar.name, 20));
            this.jeU.startLoad(aaVar.imageUrl, 10, false);
            this.jeO.setVisibility(aaVar.bfM ? 0 : 8);
            e.b(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.jeS, R.color.cp_cont_b);
        ap.setViewTextColor(this.jeT, R.color.cp_cont_b);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.jeO.setBackground(ap.getDrawable(R.drawable.frs_service_red_dot));
        this.iVm.setImageDrawable(SvgManager.brn().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.dIZ.setTextColor(i);
    }
}

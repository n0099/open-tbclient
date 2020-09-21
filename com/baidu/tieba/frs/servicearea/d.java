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
/* loaded from: classes21.dex */
public class d implements a, b {
    private TextView diE;
    private ImageView ioa;
    private View ixC;
    private aa ixD;
    private TextView ixG;
    private TextView ixH;
    private TbClipImageView ixI;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.ixD != null && d.this.ixD.mnH != null) {
                TiebaStatic.log(new aq("c13274").u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("fid", d.this.ixD.forumId).dF("obj_source", "frs_card").dF("obj_id", d.this.ixD.mnH.id).dF("obj_name", d.this.ixD.mnH.name).ai("obj_param1", d.this.ixD.mnH.dRR.intValue()));
            }
            e.a(view.getContext(), d.this.ixD, d.this.ixC);
            e.c(d.this.ixD);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.diE = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.ixG = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.ixH = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.ixI = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.ixI.setDrawerType(1);
        this.ixI.setIsRound(true);
        this.ixI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.ixC = this.mRootView.findViewById(R.id.view_red_dot);
        this.ioa = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(z zVar) {
        aa aaVar;
        if (zVar != null && !y.isEmpty(zVar.dataList) && (aaVar = zVar.dataList.get(0)) != null) {
            this.ixD = aaVar;
            if (this.ixD.mnH != null) {
                this.ixG.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.ixG.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.ixH.setText(at.aj(aaVar.name, 20));
            this.ixI.startLoad(aaVar.imageUrl, 10, false);
            this.ixC.setVisibility(aaVar.aZH ? 0 : 8);
            e.b(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.ixG, R.color.cp_cont_b);
        ap.setViewTextColor(this.ixH, R.color.cp_cont_b);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.ixC.setBackground(ap.getDrawable(R.drawable.frs_service_red_dot));
        this.ioa.setImageDrawable(SvgManager.bkl().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.diE.setTextColor(i);
    }
}

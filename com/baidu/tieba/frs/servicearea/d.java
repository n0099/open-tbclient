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
/* loaded from: classes16.dex */
public class d implements a, b {
    private TextView dgB;
    private ImageView igY;
    private View iqm;
    private aa iqn;
    private TextView iqq;
    private TextView iqr;
    private TbClipImageView iqs;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.iqn != null && d.this.iqn.mei != null) {
                TiebaStatic.log(new aq("c13274").u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("fid", d.this.iqn.forumId).dD("obj_source", "frs_card").dD("obj_id", d.this.iqn.mei.id).dD("obj_name", d.this.iqn.mei.name).ai("obj_param1", d.this.iqn.mei.dPK.intValue()));
            }
            e.a(view.getContext(), d.this.iqn, d.this.iqm);
            e.c(d.this.iqn);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dgB = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.iqq = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.iqr = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.iqs = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.iqs.setDrawerType(1);
        this.iqs.setIsRound(true);
        this.iqs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.iqm = this.mRootView.findViewById(R.id.view_red_dot);
        this.igY = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(z zVar) {
        aa aaVar;
        if (zVar != null && !y.isEmpty(zVar.dataList) && (aaVar = zVar.dataList.get(0)) != null) {
            this.iqn = aaVar;
            if (this.iqn.mei != null) {
                this.iqq.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.iqq.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.iqr.setText(at.aj(aaVar.name, 20));
            this.iqs.startLoad(aaVar.imageUrl, 10, false);
            this.iqm.setVisibility(aaVar.hvP ? 0 : 8);
            e.b(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.iqq, R.color.cp_cont_b);
        ap.setViewTextColor(this.iqr, R.color.cp_cont_b);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.iqm.setBackground(ap.getDrawable(R.drawable.frs_service_red_dot));
        this.igY.setImageDrawable(SvgManager.bjq().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.dgB.setTextColor(i);
    }
}

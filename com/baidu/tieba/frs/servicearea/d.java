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
    private TextView dgx;
    private ImageView igS;
    private View iqg;
    private aa iqh;
    private TextView iqk;
    private TextView iql;
    private TbClipImageView iqm;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.iqh != null && d.this.iqh.mdT != null) {
                TiebaStatic.log(new aq("c13274").u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("fid", d.this.iqh.forumId).dD("obj_source", "frs_card").dD("obj_id", d.this.iqh.mdT.id).dD("obj_name", d.this.iqh.mdT.name).ai("obj_param1", d.this.iqh.mdT.dPG.intValue()));
            }
            e.a(view.getContext(), d.this.iqh, d.this.iqg);
            e.c(d.this.iqh);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.dgx = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.iqk = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.iql = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.iqm = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.iqm.setDrawerType(1);
        this.iqm.setIsRound(true);
        this.iqm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.iqg = this.mRootView.findViewById(R.id.view_red_dot);
        this.igS = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(z zVar) {
        aa aaVar;
        if (zVar != null && !y.isEmpty(zVar.dataList) && (aaVar = zVar.dataList.get(0)) != null) {
            this.iqh = aaVar;
            if (this.iqh.mdT != null) {
                this.iqk.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.iqk.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.iql.setText(at.aj(aaVar.name, 20));
            this.iqm.startLoad(aaVar.imageUrl, 10, false);
            this.iqg.setVisibility(aaVar.hvJ ? 0 : 8);
            e.b(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.iqk, R.color.cp_cont_b);
        ap.setViewTextColor(this.iql, R.color.cp_cont_b);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.iqg.setBackground(ap.getDrawable(R.drawable.frs_service_red_dot));
        this.igS.setImageDrawable(SvgManager.bjq().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.dgx.setTextColor(i);
    }
}

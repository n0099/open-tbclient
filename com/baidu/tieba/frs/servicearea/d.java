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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes16.dex */
public class d implements a, b {
    private TextView cXo;
    private ImageView hSI;
    private View ibX;
    private z ibY;
    private TextView icb;
    private TextView icc;
    private TbClipImageView icd;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.ibY != null && d.this.ibY.lMh != null) {
                TiebaStatic.log(new ap("c13274").t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("fid", d.this.ibY.forumId).dn("obj_source", "frs_card").dn("obj_id", d.this.ibY.lMh.id).dn("obj_name", d.this.ibY.lMh.name).ah("obj_param1", d.this.ibY.lMh.dGy.intValue()));
            }
            e.a(view.getContext(), d.this.ibY, d.this.ibX);
            e.c(d.this.ibY);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.cXo = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.icb = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.icc = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.icd = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.icd.setDrawerType(1);
        this.icd.setIsRound(true);
        this.icd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.ibX = this.mRootView.findViewById(R.id.view_red_dot);
        this.hSI = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(y yVar) {
        z zVar;
        if (yVar != null && !x.isEmpty(yVar.dataList) && (zVar = yVar.dataList.get(0)) != null) {
            this.ibY = zVar;
            if (this.ibY.lMh != null) {
                this.icb.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.icb.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.icc.setText(as.ai(zVar.name, 20));
            this.icd.startLoad(zVar.imageUrl, 10, false);
            this.ibX.setVisibility(zVar.hiL ? 0 : 8);
            e.b(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.icb, R.color.cp_cont_b);
        ao.setViewTextColor(this.icc, R.color.cp_cont_b);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.ibX.setBackground(ao.getDrawable(R.drawable.frs_service_red_dot));
        this.hSI.setImageDrawable(SvgManager.baR().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.cXo.setTextColor(i);
    }
}

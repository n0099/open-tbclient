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
    private ImageView hSK;
    private View ibZ;
    private z ica;
    private TextView icd;
    private TextView ice;
    private TbClipImageView icf;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.ica != null && d.this.ica.lMj != null) {
                TiebaStatic.log(new ap("c13274").t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("fid", d.this.ica.forumId).dn("obj_source", "frs_card").dn("obj_id", d.this.ica.lMj.id).dn("obj_name", d.this.ica.lMj.name).ah("obj_param1", d.this.ica.lMj.dGy.intValue()));
            }
            e.a(view.getContext(), d.this.ica, d.this.ibZ);
            e.c(d.this.ica);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.cXo = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.icd = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.ice = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.icf = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.icf.setDrawerType(1);
        this.icf.setIsRound(true);
        this.icf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.ibZ = this.mRootView.findViewById(R.id.view_red_dot);
        this.hSK = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(y yVar) {
        z zVar;
        if (yVar != null && !x.isEmpty(yVar.dataList) && (zVar = yVar.dataList.get(0)) != null) {
            this.ica = zVar;
            if (this.ica.lMj != null) {
                this.icd.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.icd.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.ice.setText(as.ai(zVar.name, 20));
            this.icf.startLoad(zVar.imageUrl, 10, false);
            this.ibZ.setVisibility(zVar.hiL ? 0 : 8);
            e.b(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.icd, R.color.cp_cont_b);
        ao.setViewTextColor(this.ice, R.color.cp_cont_b);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.ibZ.setBackground(ao.getDrawable(R.drawable.frs_service_red_dot));
        this.hSK.setImageDrawable(SvgManager.baR().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.cXo.setTextColor(i);
    }
}

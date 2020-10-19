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
    private TextView duK;
    private ImageView iCT;
    private TextView iMA;
    private TbClipImageView iMB;
    private View iMv;
    private aa iMw;
    private TextView iMz;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.iMw != null && d.this.iMw.mDm != null) {
                TiebaStatic.log(new aq("c13274").u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("fid", d.this.iMw.forumId).dK("obj_source", "frs_card").dK("obj_id", d.this.iMw.mDm.id).dK("obj_name", d.this.iMw.mDm.name).aj("obj_param1", d.this.iMw.mDm.edS.intValue()));
            }
            e.a(view.getContext(), d.this.iMw, d.this.iMv);
            e.c(d.this.iMw);
        }
    };
    private View mRootView;

    public d(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.duK = (TextView) this.mRootView.findViewById(R.id.frs_service);
        this.iMz = (TextView) this.mRootView.findViewById(R.id.frs_service_category);
        this.iMA = (TextView) this.mRootView.findViewById(R.id.frs_service_name);
        this.iMB = (TbClipImageView) this.mRootView.findViewById(R.id.frs_service_icon);
        this.iMB.setDrawerType(1);
        this.iMB.setIsRound(true);
        this.iMB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.iMv = this.mRootView.findViewById(R.id.view_red_dot);
        this.iCT = (ImageView) this.mRootView.findViewById(R.id.frs_service_arrow);
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(z zVar) {
        aa aaVar;
        if (zVar != null && !y.isEmpty(zVar.dataList) && (aaVar = zVar.dataList.get(0)) != null) {
            this.iMw = aaVar;
            if (this.iMw.mDm != null) {
                this.iMz.setText(this.mRootView.getContext().getString(R.string.ai_smart_app));
            } else {
                this.iMz.setText(this.mRootView.getContext().getString(R.string.frs_service_special));
            }
            this.iMA.setText(at.ak(aaVar.name, 20));
            this.iMB.startLoad(aaVar.imageUrl, 10, false);
            this.iMv.setVisibility(aaVar.bdb ? 0 : 8);
            e.b(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.iMz, R.color.cp_cont_b);
        ap.setViewTextColor(this.iMA, R.color.cp_cont_b);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.iMv.setBackground(ap.getDrawable(R.drawable.frs_service_red_dot));
        this.iCT.setImageDrawable(SvgManager.bmU().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null));
    }

    @Override // com.baidu.tieba.frs.servicearea.a
    public void setThemeFontColor(int i) {
        this.duK.setTextColor(i);
    }
}

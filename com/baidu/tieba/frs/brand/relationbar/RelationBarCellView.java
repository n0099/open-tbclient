package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import tbclient.OriForumInfo;
/* loaded from: classes2.dex */
public class RelationBarCellView extends RelativeLayout implements View.OnClickListener {
    private TbImageView dsq;
    private TextView dsr;
    private TextView dss;
    private OriForumInfo dst;
    private int mHeight;
    private int mSkinType;
    private int mWidth;

    public RelationBarCellView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public RelationBarCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public RelationBarCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(f.h.frs_brand_relation_bar_cell_layout, (ViewGroup) this, true);
        this.dsq = (TbImageView) findViewById(f.g.frs_brand_bar_cell_img);
        this.dsr = (TextView) findViewById(f.g.frs_brand_bar_cell_name);
        this.dss = (TextView) findViewById(f.g.frs_brand_bar_cell_attention);
        this.dsq.setDefaultResource(17170445);
        this.dsq.setDefaultBgResource(f.d.cp_bg_line_e);
        this.mWidth = l.f(context, f.e.tbds394);
        this.mHeight = l.f(context, f.e.tbds146);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void setData(OriForumInfo oriForumInfo) {
        if (oriForumInfo == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dst = oriForumInfo;
        this.dsq.startLoad(oriForumInfo.ori_avatar, 10, false);
        this.dsr.setText(oriForumInfo.ori_fname);
        this.dss.setText(String.format(getContext().getString(f.j.frs_brand_relation_bar_attention), ap.G(oriForumInfo.ori_member_num.longValue())));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13110").f(VideoPlayActivityConfig.OBJ_ID, this.dst.ori_fid.longValue()));
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getContext()).createNormalCfg(this.dst.ori_fname, "")));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.i(this, f.C0146f.cp_bg_line_d_e_selector);
            am.h(this.dsr, f.d.cp_cont_b);
            am.h(this.dss, f.d.cp_cont_d);
        }
    }
}

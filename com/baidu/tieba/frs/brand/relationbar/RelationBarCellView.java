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
import com.baidu.tieba.d;
import tbclient.OriForumInfo;
/* loaded from: classes2.dex */
public class RelationBarCellView extends RelativeLayout implements View.OnClickListener {
    private TbImageView dpG;
    private TextView dpH;
    private TextView dpI;
    private OriForumInfo dpJ;
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
        LayoutInflater.from(context).inflate(d.i.frs_brand_relation_bar_cell_layout, (ViewGroup) this, true);
        this.dpG = (TbImageView) findViewById(d.g.frs_brand_bar_cell_img);
        this.dpH = (TextView) findViewById(d.g.frs_brand_bar_cell_name);
        this.dpI = (TextView) findViewById(d.g.frs_brand_bar_cell_attention);
        this.dpG.setDefaultResource(17170445);
        this.dpG.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.mWidth = l.e(context, d.e.tbds394);
        this.mHeight = l.e(context, d.e.tbds146);
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
        this.dpJ = oriForumInfo;
        this.dpG.startLoad(oriForumInfo.ori_avatar, 10, false);
        this.dpH.setText(oriForumInfo.ori_fname);
        this.dpI.setText(String.format(getContext().getString(d.k.frs_brand_relation_bar_attention), ap.E(oriForumInfo.ori_member_num.longValue())));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new an("c13110").f(VideoPlayActivityConfig.OBJ_ID, this.dpJ.ori_fid.longValue()));
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getContext()).createNormalCfg(this.dpJ.ori_fname, "")));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.i(this, d.f.cp_bg_line_d_e_selector);
            am.h(this.dpH, d.C0142d.cp_cont_b);
            am.h(this.dpI, d.C0142d.cp_cont_d);
        }
    }
}

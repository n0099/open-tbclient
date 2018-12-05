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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import tbclient.OriForumInfo;
/* loaded from: classes6.dex */
public class RelationBarCellView extends RelativeLayout implements View.OnClickListener {
    private TbImageView dOu;
    private TextView dOv;
    private TextView dOw;
    private OriForumInfo dOx;
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
        LayoutInflater.from(context).inflate(e.h.frs_brand_relation_bar_cell_layout, (ViewGroup) this, true);
        this.dOu = (TbImageView) findViewById(e.g.frs_brand_bar_cell_img);
        this.dOv = (TextView) findViewById(e.g.frs_brand_bar_cell_name);
        this.dOw = (TextView) findViewById(e.g.frs_brand_bar_cell_attention);
        this.dOu.setDefaultResource(17170445);
        this.dOu.setDefaultBgResource(e.d.cp_bg_line_e);
        this.mWidth = l.h(context, e.C0210e.tbds394);
        this.mHeight = l.h(context, e.C0210e.tbds146);
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
        this.dOx = oriForumInfo;
        this.dOu.startLoad(oriForumInfo.ori_avatar, 10, false);
        this.dOv.setText(oriForumInfo.ori_fname);
        this.dOw.setText(String.format(getContext().getString(e.j.frs_brand_relation_bar_attention), ao.V(oriForumInfo.ori_member_num.longValue())));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13110").i(VideoPlayActivityConfig.OBJ_ID, this.dOx.ori_fid.longValue()));
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getContext()).createNormalCfg(this.dOx.ori_fname, "")));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.i(this, e.f.cp_bg_line_d_e_selector);
            al.h(this.dOv, e.d.cp_cont_b);
            al.h(this.dOw, e.d.cp_cont_d);
        }
    }
}

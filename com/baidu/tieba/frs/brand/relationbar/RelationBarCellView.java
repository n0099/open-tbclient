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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import tbclient.OriForumInfo;
/* loaded from: classes4.dex */
public class RelationBarCellView extends RelativeLayout implements View.OnClickListener {
    private TbImageView eEH;
    private TextView ffG;
    private TextView ffH;
    private OriForumInfo ffI;
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
        LayoutInflater.from(context).inflate(d.h.frs_brand_relation_bar_cell_layout, (ViewGroup) this, true);
        this.eEH = (TbImageView) findViewById(d.g.frs_brand_bar_cell_img);
        this.ffG = (TextView) findViewById(d.g.frs_brand_bar_cell_name);
        this.ffH = (TextView) findViewById(d.g.frs_brand_bar_cell_attention);
        this.eEH.setDefaultResource(17170445);
        this.eEH.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.eEH.setBorderColor(0);
        this.eEH.setRadius(l.h(getContext(), d.e.tbds20));
        this.eEH.setConrers(5);
        this.mWidth = l.h(context, d.e.tbds471);
        this.mHeight = l.h(context, d.e.tbds164);
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
        this.ffI = oriForumInfo;
        this.eEH.startLoad(oriForumInfo.ori_avatar, 10, false);
        this.ffG.setText(oriForumInfo.ori_fname);
        this.ffH.setText(String.format(getContext().getString(d.j.frs_brand_relation_bar_attention), ap.ay(oriForumInfo.ori_member_num.longValue())));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13110").k(VideoPlayActivityConfig.OBJ_ID, this.ffI.ori_fid.longValue()));
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getContext()).createNormalCfg(this.ffI.ori_fname, "")));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.k(this, d.f.cp_bg_line_d_e_selector);
            al.j(this.ffG, d.C0277d.cp_cont_f);
            al.j(this.ffH, d.C0277d.cp_cont_d);
        }
    }
}

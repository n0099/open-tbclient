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
import com.baidu.tieba.R;
import tbclient.OriForumInfo;
/* loaded from: classes4.dex */
public class RelationBarCellView extends RelativeLayout implements View.OnClickListener {
    private TbImageView eUD;
    private TextView fvU;
    private TextView fvV;
    private OriForumInfo fvW;
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
        LayoutInflater.from(context).inflate(R.layout.frs_brand_relation_bar_cell_layout, (ViewGroup) this, true);
        this.eUD = (TbImageView) findViewById(R.id.frs_brand_bar_cell_img);
        this.fvU = (TextView) findViewById(R.id.frs_brand_bar_cell_name);
        this.fvV = (TextView) findViewById(R.id.frs_brand_bar_cell_attention);
        this.eUD.setDefaultResource(17170445);
        this.eUD.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eUD.setBorderColor(0);
        this.eUD.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.eUD.setConrers(5);
        this.mWidth = l.g(context, R.dimen.tbds471);
        this.mHeight = l.g(context, R.dimen.tbds164);
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
        this.fvW = oriForumInfo;
        this.eUD.startLoad(oriForumInfo.ori_avatar, 10, false);
        this.fvU.setText(oriForumInfo.ori_fname);
        this.fvV.setText(String.format(getContext().getString(R.string.frs_brand_relation_bar_attention), ap.aM(oriForumInfo.ori_member_num.longValue())));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new am("c13110").l(VideoPlayActivityConfig.OBJ_ID, this.fvW.ori_fid.longValue()));
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getContext()).createNormalCfg(this.fvW.ori_fname, "")));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.k(this, R.drawable.cp_bg_line_d_e_selector);
            al.j(this.fvU, R.color.cp_cont_f);
            al.j(this.fvV, R.color.cp_cont_d);
        }
    }
}

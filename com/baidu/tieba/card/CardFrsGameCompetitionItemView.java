package com.baidu.tieba.card;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes3.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout cwQ;
    private TbImageView cwR;
    private LinearLayout cwS;
    private ClickableHeaderImageView cwT;
    private TextView cwU;
    private RelativeLayout cwV;
    private TextView cwW;
    private ClickableHeaderImageView cwX;
    private TextView cwY;
    private ClickableHeaderImageView cwZ;
    private TextView cxa;
    private TextView cxb;
    private String mForumId;
    public int mSkinType;

    public CardFrsGameCompetitionItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public CardFrsGameCompetitionItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public CardFrsGameCompetitionItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(f.h.card_frs_game_competition_view_item, (ViewGroup) this, true);
        this.cwQ = (RelativeLayout) findViewById(f.g.card_competition_layout);
        this.cwR = (TbImageView) findViewById(f.g.card_competition_bg);
        this.cwS = (LinearLayout) findViewById(f.g.card_competition_title_layout);
        this.cwT = (ClickableHeaderImageView) findViewById(f.g.card_competition_title_header);
        this.cwU = (TextView) findViewById(f.g.card_competition_title);
        this.cwV = (RelativeLayout) findViewById(f.g.card_competition_content_layout);
        this.cwW = (TextView) findViewById(f.g.card_competition_vs);
        this.cwX = (ClickableHeaderImageView) findViewById(f.g.card_competition_left_img);
        this.cwY = (TextView) findViewById(f.g.card_competition_left_name);
        this.cwZ = (ClickableHeaderImageView) findViewById(f.g.card_competition_right_img);
        this.cxa = (TextView) findViewById(f.g.card_competition_right_name);
        this.cxb = (TextView) findViewById(f.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(f.e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cwR.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cwR.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cwQ.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cwQ.setLayoutParams(layoutParams2);
        this.cwR.setDefaultBgResource(f.C0146f.icon_morenpic);
        this.cwR.setDefaultErrorResource(f.C0146f.icon_morenpic);
        this.cwT.setDrawBorder(true);
        this.cwT.setDrawerType(1);
        this.cwT.setRadius(context.getResources().getDimensionPixelSize(f.e.tbds5));
        this.cwT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cwT.setBorderColor(am.getColor(f.d.common_color_10043));
        this.cwT.setBorderWidth(context.getResources().getDimensionPixelSize(f.e.tbds1));
        this.cwX.setDefaultResource(17170445);
        this.cwX.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.cwX.setDefaultBgResource(f.d.cp_bg_line_e);
        this.cwX.setIsRound(true);
        this.cwX.setDrawBorder(true);
        this.cwX.setBorderColor(am.getColor(f.d.common_color_10043));
        this.cwX.setBorderWidth(context.getResources().getDimensionPixelSize(f.e.tbds1));
        this.cwZ.setDefaultResource(17170445);
        this.cwZ.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.cwZ.setDefaultBgResource(f.d.cp_bg_line_e);
        this.cwZ.setIsRound(true);
        this.cwZ.setDrawBorder(true);
        this.cwZ.setBorderColor(am.getColor(f.d.common_color_10043));
        this.cwZ.setBorderWidth(context.getResources().getDimensionPixelSize(f.e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").r("obj_locate", 7).ae(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    az.zI().a((TbPageContext) com.baidu.adp.base.i.ad(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cwT.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cwR.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cwU.setText(featureCardCompetitionSubNode.title);
        this.cwX.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cwY.setText(featureCardCompetitionSubNode.team1_name);
        this.cwZ.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cxa.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.cwU, f.d.cp_cont_i, 1);
            am.c(this.cwW, f.d.cp_cont_i, 1);
            am.c(this.cwY, f.d.cp_cont_i, 1);
            am.c(this.cxa, f.d.cp_cont_i, 1);
            am.c(this.cxb, f.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

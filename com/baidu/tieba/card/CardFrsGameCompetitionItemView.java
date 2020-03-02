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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes9.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout fHM;
    private TbImageView fHN;
    private LinearLayout fHO;
    private ClickableHeaderImageView fHP;
    private TextView fHQ;
    private RelativeLayout fHR;
    private TextView fHS;
    private ClickableHeaderImageView fHT;
    private TextView fHU;
    private ClickableHeaderImageView fHV;
    private TextView fHW;
    private TextView fHX;
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
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_competition_view_item, (ViewGroup) this, true);
        this.fHM = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.fHN = (TbImageView) findViewById(R.id.card_competition_bg);
        this.fHO = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.fHP = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.fHQ = (TextView) findViewById(R.id.card_competition_title);
        this.fHR = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.fHS = (TextView) findViewById(R.id.card_competition_vs);
        this.fHT = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.fHU = (TextView) findViewById(R.id.card_competition_left_name);
        this.fHV = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.fHW = (TextView) findViewById(R.id.card_competition_right_name);
        this.fHX = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fHN.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.fHN.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fHM.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.fHM.setLayoutParams(layoutParams2);
        this.fHN.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fHN.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fHP.setDrawBorder(true);
        this.fHP.setDrawerType(1);
        this.fHP.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.fHP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fHP.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHP.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fHT.setDefaultResource(17170445);
        this.fHT.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fHT.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fHT.setIsRound(true);
        this.fHT.setDrawBorder(true);
        this.fHT.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHT.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fHV.setDefaultResource(17170445);
        this.fHV.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fHV.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fHV.setIsRound(true);
        this.fHV.setDrawBorder(true);
        this.fHV.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHV.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").X("obj_locate", 7).cy("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aGG().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.fHP.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.fHN.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.fHQ.setText(featureCardCompetitionSubNode.title);
        this.fHT.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.fHU.setText(featureCardCompetitionSubNode.team1_name);
        this.fHV.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.fHW.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fHQ, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fHS, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fHU, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fHW, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fHX, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

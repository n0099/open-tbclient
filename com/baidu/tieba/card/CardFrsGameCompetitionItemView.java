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
    private RelativeLayout fHK;
    private TbImageView fHL;
    private LinearLayout fHM;
    private ClickableHeaderImageView fHN;
    private TextView fHO;
    private RelativeLayout fHP;
    private TextView fHQ;
    private ClickableHeaderImageView fHR;
    private TextView fHS;
    private ClickableHeaderImageView fHT;
    private TextView fHU;
    private TextView fHV;
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
        this.fHK = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.fHL = (TbImageView) findViewById(R.id.card_competition_bg);
        this.fHM = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.fHN = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.fHO = (TextView) findViewById(R.id.card_competition_title);
        this.fHP = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.fHQ = (TextView) findViewById(R.id.card_competition_vs);
        this.fHR = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.fHS = (TextView) findViewById(R.id.card_competition_left_name);
        this.fHT = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.fHU = (TextView) findViewById(R.id.card_competition_right_name);
        this.fHV = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fHL.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.fHL.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fHK.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.fHK.setLayoutParams(layoutParams2);
        this.fHL.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fHL.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fHN.setDrawBorder(true);
        this.fHN.setDrawerType(1);
        this.fHN.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.fHN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fHN.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHN.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fHR.setDefaultResource(17170445);
        this.fHR.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fHR.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fHR.setIsRound(true);
        this.fHR.setDrawBorder(true);
        this.fHR.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHR.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fHT.setDefaultResource(17170445);
        this.fHT.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fHT.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fHT.setIsRound(true);
        this.fHT.setDrawBorder(true);
        this.fHT.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHT.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").X("obj_locate", 7).cy("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aGE().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.fHN.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.fHL.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.fHO.setText(featureCardCompetitionSubNode.title);
        this.fHR.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.fHS.setText(featureCardCompetitionSubNode.team1_name);
        this.fHT.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.fHU.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fHO, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fHQ, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fHS, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fHU, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fHV, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes22.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout ihE;
    private TbImageView ihF;
    private LinearLayout ihG;
    private ClickableHeaderImageView ihH;
    private TextView ihI;
    private RelativeLayout ihJ;
    private TextView ihK;
    private ClickableHeaderImageView ihL;
    private TextView ihM;
    private ClickableHeaderImageView ihN;
    private TextView ihO;
    private TextView ihP;
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
        this.ihE = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.ihF = (TbImageView) findViewById(R.id.card_competition_bg);
        this.ihG = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.ihH = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.ihI = (TextView) findViewById(R.id.card_competition_title);
        this.ihJ = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.ihK = (TextView) findViewById(R.id.card_competition_vs);
        this.ihL = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.ihM = (TextView) findViewById(R.id.card_competition_left_name);
        this.ihN = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.ihO = (TextView) findViewById(R.id.card_competition_right_name);
        this.ihP = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ihF.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.ihF.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ihE.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.ihE.setLayoutParams(layoutParams2);
        this.ihF.setDefaultBgResource(R.drawable.icon_morenpic);
        this.ihF.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.ihH.setDrawBorder(true);
        this.ihH.setDrawerType(1);
        this.ihH.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.ihH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ihH.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ihH.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ihL.setDefaultResource(17170445);
        this.ihL.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ihL.setDefaultBgResource(R.color.CAM_X0205);
        this.ihL.setIsRound(true);
        this.ihL.setDrawBorder(true);
        this.ihL.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ihL.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ihN.setDefaultResource(17170445);
        this.ihN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ihN.setDefaultBgResource(R.color.CAM_X0205);
        this.ihN.setIsRound(true);
        this.ihN.setDrawBorder(true);
        this.ihN.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ihN.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ar("c13047").al("obj_locate", 7).dY("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    bf.bua().a((TbPageContext) com.baidu.adp.base.i.J(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.ihH.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.ihF.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.ihI.setText(featureCardCompetitionSubNode.title);
        this.ihL.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.ihM.setText(featureCardCompetitionSubNode.team1_name);
        this.ihN.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.ihO.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ihI, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ihK, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ihM, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ihO, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ihP, R.color.CAM_X0101, 1);
        }
        this.mSkinType = i;
    }
}

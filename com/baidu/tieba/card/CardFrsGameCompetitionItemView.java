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
    private RelativeLayout ihG;
    private TbImageView ihH;
    private LinearLayout ihI;
    private ClickableHeaderImageView ihJ;
    private TextView ihK;
    private RelativeLayout ihL;
    private TextView ihM;
    private ClickableHeaderImageView ihN;
    private TextView ihO;
    private ClickableHeaderImageView ihP;
    private TextView ihQ;
    private TextView ihR;
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
        this.ihG = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.ihH = (TbImageView) findViewById(R.id.card_competition_bg);
        this.ihI = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.ihJ = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.ihK = (TextView) findViewById(R.id.card_competition_title);
        this.ihL = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.ihM = (TextView) findViewById(R.id.card_competition_vs);
        this.ihN = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.ihO = (TextView) findViewById(R.id.card_competition_left_name);
        this.ihP = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.ihQ = (TextView) findViewById(R.id.card_competition_right_name);
        this.ihR = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ihH.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.ihH.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ihG.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.ihG.setLayoutParams(layoutParams2);
        this.ihH.setDefaultBgResource(R.drawable.icon_morenpic);
        this.ihH.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.ihJ.setDrawBorder(true);
        this.ihJ.setDrawerType(1);
        this.ihJ.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.ihJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ihJ.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ihJ.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ihN.setDefaultResource(17170445);
        this.ihN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ihN.setDefaultBgResource(R.color.CAM_X0205);
        this.ihN.setIsRound(true);
        this.ihN.setDrawBorder(true);
        this.ihN.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ihN.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ihP.setDefaultResource(17170445);
        this.ihP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ihP.setDefaultBgResource(R.color.CAM_X0205);
        this.ihP.setIsRound(true);
        this.ihP.setDrawBorder(true);
        this.ihP.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ihP.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
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
        this.ihJ.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.ihH.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.ihK.setText(featureCardCompetitionSubNode.title);
        this.ihN.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.ihO.setText(featureCardCompetitionSubNode.team1_name);
        this.ihP.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.ihQ.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ihK, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ihM, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ihO, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ihQ, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ihR, R.color.CAM_X0101, 1);
        }
        this.mSkinType = i;
    }
}

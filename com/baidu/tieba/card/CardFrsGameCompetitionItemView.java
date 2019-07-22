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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes4.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private LinearLayout eAA;
    private ClickableHeaderImageView eAB;
    private TextView eAC;
    private RelativeLayout eAD;
    private TextView eAE;
    private ClickableHeaderImageView eAF;
    private TextView eAG;
    private ClickableHeaderImageView eAH;
    private TextView eAI;
    private TextView eAJ;
    private RelativeLayout eAy;
    private TbImageView eAz;
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
        this.eAy = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.eAz = (TbImageView) findViewById(R.id.card_competition_bg);
        this.eAA = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.eAB = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.eAC = (TextView) findViewById(R.id.card_competition_title);
        this.eAD = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.eAE = (TextView) findViewById(R.id.card_competition_vs);
        this.eAF = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.eAG = (TextView) findViewById(R.id.card_competition_left_name);
        this.eAH = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.eAI = (TextView) findViewById(R.id.card_competition_right_name);
        this.eAJ = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAz.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.eAz.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eAy.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.eAy.setLayoutParams(layoutParams2);
        this.eAz.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eAz.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.eAB.setDrawBorder(true);
        this.eAB.setDrawerType(1);
        this.eAB.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.eAB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eAB.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eAB.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eAF.setDefaultResource(17170445);
        this.eAF.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eAF.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eAF.setIsRound(true);
        this.eAF.setDrawBorder(true);
        this.eAF.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eAF.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eAH.setDefaultResource(17170445);
        this.eAH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eAH.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eAH.setIsRound(true);
        this.eAH.setDrawBorder(true);
        this.eAH.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eAH.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").P("obj_locate", 7).bT("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    bb.ajC().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.eAB.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.eAz.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.eAC.setText(featureCardCompetitionSubNode.title);
        this.eAF.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.eAG.setText(featureCardCompetitionSubNode.team1_name);
        this.eAH.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.eAI.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.f(this.eAC, R.color.cp_btn_a, 1);
            am.f(this.eAE, R.color.cp_btn_a, 1);
            am.f(this.eAG, R.color.cp_btn_a, 1);
            am.f(this.eAI, R.color.cp_btn_a, 1);
            am.f(this.eAJ, R.color.cp_btn_a, 1);
        }
        this.mSkinType = i;
    }
}

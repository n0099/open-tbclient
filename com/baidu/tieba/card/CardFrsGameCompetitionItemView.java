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
    private RelativeLayout eAF;
    private TbImageView eAG;
    private LinearLayout eAH;
    private ClickableHeaderImageView eAI;
    private TextView eAJ;
    private RelativeLayout eAK;
    private TextView eAL;
    private ClickableHeaderImageView eAM;
    private TextView eAN;
    private ClickableHeaderImageView eAO;
    private TextView eAP;
    private TextView eAQ;
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
        this.eAF = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.eAG = (TbImageView) findViewById(R.id.card_competition_bg);
        this.eAH = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.eAI = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.eAJ = (TextView) findViewById(R.id.card_competition_title);
        this.eAK = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.eAL = (TextView) findViewById(R.id.card_competition_vs);
        this.eAM = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.eAN = (TextView) findViewById(R.id.card_competition_left_name);
        this.eAO = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.eAP = (TextView) findViewById(R.id.card_competition_right_name);
        this.eAQ = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAG.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.eAG.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eAF.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.eAF.setLayoutParams(layoutParams2);
        this.eAG.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eAG.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.eAI.setDrawBorder(true);
        this.eAI.setDrawerType(1);
        this.eAI.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.eAI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eAI.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eAI.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eAM.setDefaultResource(17170445);
        this.eAM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eAM.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eAM.setIsRound(true);
        this.eAM.setDrawBorder(true);
        this.eAM.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eAM.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eAO.setDefaultResource(17170445);
        this.eAO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eAO.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eAO.setIsRound(true);
        this.eAO.setDrawBorder(true);
        this.eAO.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eAO.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").P("obj_locate", 7).bT("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    bb.ajE().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.eAI.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.eAG.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.eAJ.setText(featureCardCompetitionSubNode.title);
        this.eAM.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.eAN.setText(featureCardCompetitionSubNode.team1_name);
        this.eAO.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.eAP.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.f(this.eAJ, R.color.cp_btn_a, 1);
            am.f(this.eAL, R.color.cp_btn_a, 1);
            am.f(this.eAN, R.color.cp_btn_a, 1);
            am.f(this.eAP, R.color.cp_btn_a, 1);
            am.f(this.eAQ, R.color.cp_btn_a, 1);
        }
        this.mSkinType = i;
    }
}

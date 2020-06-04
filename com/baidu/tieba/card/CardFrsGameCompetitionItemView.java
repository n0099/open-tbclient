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
    private LinearLayout gCA;
    private ClickableHeaderImageView gCB;
    private TextView gCC;
    private RelativeLayout gCD;
    private TextView gCE;
    private ClickableHeaderImageView gCF;
    private TextView gCG;
    private ClickableHeaderImageView gCH;
    private TextView gCI;
    private TextView gCJ;
    private RelativeLayout gCy;
    private TbImageView gCz;
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
        this.gCy = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.gCz = (TbImageView) findViewById(R.id.card_competition_bg);
        this.gCA = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.gCB = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.gCC = (TextView) findViewById(R.id.card_competition_title);
        this.gCD = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.gCE = (TextView) findViewById(R.id.card_competition_vs);
        this.gCF = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.gCG = (TextView) findViewById(R.id.card_competition_left_name);
        this.gCH = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.gCI = (TextView) findViewById(R.id.card_competition_right_name);
        this.gCJ = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gCz.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.gCz.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gCy.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.gCy.setLayoutParams(layoutParams2);
        this.gCz.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gCz.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gCB.setDrawBorder(true);
        this.gCB.setDrawerType(1);
        this.gCB.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.gCB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gCB.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCB.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gCF.setDefaultResource(17170445);
        this.gCF.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gCF.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gCF.setIsRound(true);
        this.gCF.setDrawBorder(true);
        this.gCF.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCF.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gCH.setDefaultResource(17170445);
        this.gCH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gCH.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gCH.setIsRound(true);
        this.gCH.setDrawBorder(true);
        this.gCH.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCH.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").ag("obj_locate", 7).dh("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aVa().a((TbPageContext) com.baidu.adp.base.i.G(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.gCB.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.gCz.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.gCC.setText(featureCardCompetitionSubNode.title);
        this.gCF.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.gCG.setText(featureCardCompetitionSubNode.team1_name);
        this.gCH.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.gCI.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gCC, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gCE, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gCG, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gCI, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gCJ, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

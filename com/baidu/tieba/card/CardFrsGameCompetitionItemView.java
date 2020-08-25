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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes16.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout hhM;
    private TbImageView hhN;
    private LinearLayout hhO;
    private ClickableHeaderImageView hhP;
    private TextView hhQ;
    private RelativeLayout hhR;
    private TextView hhS;
    private ClickableHeaderImageView hhT;
    private TextView hhU;
    private ClickableHeaderImageView hhV;
    private TextView hhW;
    private TextView hhX;
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
        this.hhM = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.hhN = (TbImageView) findViewById(R.id.card_competition_bg);
        this.hhO = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.hhP = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.hhQ = (TextView) findViewById(R.id.card_competition_title);
        this.hhR = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.hhS = (TextView) findViewById(R.id.card_competition_vs);
        this.hhT = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.hhU = (TextView) findViewById(R.id.card_competition_left_name);
        this.hhV = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.hhW = (TextView) findViewById(R.id.card_competition_right_name);
        this.hhX = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hhN.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.hhN.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hhM.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.hhM.setLayoutParams(layoutParams2);
        this.hhN.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hhN.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hhP.setDrawBorder(true);
        this.hhP.setDrawerType(1);
        this.hhP.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.hhP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hhP.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hhP.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hhT.setDefaultResource(17170445);
        this.hhT.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hhT.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hhT.setIsRound(true);
        this.hhT.setDrawBorder(true);
        this.hhT.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hhT.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hhV.setDefaultResource(17170445);
        this.hhV.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hhV.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hhV.setIsRound(true);
        this.hhV.setDrawBorder(true);
        this.hhV.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hhV.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").ai("obj_locate", 7).dD("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    be.bju().a((TbPageContext) com.baidu.adp.base.i.I(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.hhP.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.hhN.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.hhQ.setText(featureCardCompetitionSubNode.title);
        this.hhT.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.hhU.setText(featureCardCompetitionSubNode.team1_name);
        this.hhV.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.hhW.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.hhQ, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hhS, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hhU, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hhW, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hhX, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

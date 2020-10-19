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
/* loaded from: classes22.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout hDO;
    private TbImageView hDP;
    private LinearLayout hDQ;
    private ClickableHeaderImageView hDR;
    private TextView hDS;
    private RelativeLayout hDT;
    private TextView hDU;
    private ClickableHeaderImageView hDV;
    private TextView hDW;
    private ClickableHeaderImageView hDX;
    private TextView hDY;
    private TextView hDZ;
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
        this.hDO = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.hDP = (TbImageView) findViewById(R.id.card_competition_bg);
        this.hDQ = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.hDR = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.hDS = (TextView) findViewById(R.id.card_competition_title);
        this.hDT = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.hDU = (TextView) findViewById(R.id.card_competition_vs);
        this.hDV = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.hDW = (TextView) findViewById(R.id.card_competition_left_name);
        this.hDX = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.hDY = (TextView) findViewById(R.id.card_competition_right_name);
        this.hDZ = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDP.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.hDP.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hDO.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.hDO.setLayoutParams(layoutParams2);
        this.hDP.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hDP.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hDR.setDrawBorder(true);
        this.hDR.setDrawerType(1);
        this.hDR.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.hDR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hDR.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hDR.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hDV.setDefaultResource(17170445);
        this.hDV.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hDV.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hDV.setIsRound(true);
        this.hDV.setDrawBorder(true);
        this.hDV.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hDV.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hDX.setDefaultResource(17170445);
        this.hDX.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hDX.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hDX.setIsRound(true);
        this.hDX.setDrawBorder(true);
        this.hDX.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hDX.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").aj("obj_locate", 7).dK("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    be.bmY().a((TbPageContext) com.baidu.adp.base.i.I(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.hDR.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.hDP.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.hDS.setText(featureCardCompetitionSubNode.title);
        this.hDV.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.hDW.setText(featureCardCompetitionSubNode.team1_name);
        this.hDX.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.hDY.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.hDS, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hDU, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hDW, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hDY, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hDZ, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

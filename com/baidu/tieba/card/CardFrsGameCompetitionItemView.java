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
/* loaded from: classes21.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout hWH;
    private TbImageView hWI;
    private LinearLayout hWJ;
    private ClickableHeaderImageView hWK;
    private TextView hWL;
    private RelativeLayout hWM;
    private TextView hWN;
    private ClickableHeaderImageView hWO;
    private TextView hWP;
    private ClickableHeaderImageView hWQ;
    private TextView hWR;
    private TextView hWS;
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
        this.hWH = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.hWI = (TbImageView) findViewById(R.id.card_competition_bg);
        this.hWJ = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.hWK = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.hWL = (TextView) findViewById(R.id.card_competition_title);
        this.hWM = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.hWN = (TextView) findViewById(R.id.card_competition_vs);
        this.hWO = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.hWP = (TextView) findViewById(R.id.card_competition_left_name);
        this.hWQ = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.hWR = (TextView) findViewById(R.id.card_competition_right_name);
        this.hWS = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hWI.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.hWI.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hWH.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.hWH.setLayoutParams(layoutParams2);
        this.hWI.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hWI.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hWK.setDrawBorder(true);
        this.hWK.setDrawerType(1);
        this.hWK.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.hWK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hWK.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hWK.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hWO.setDefaultResource(17170445);
        this.hWO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hWO.setDefaultBgResource(R.color.CAM_X0205);
        this.hWO.setIsRound(true);
        this.hWO.setDrawBorder(true);
        this.hWO.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hWO.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hWQ.setDefaultResource(17170445);
        this.hWQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hWQ.setDefaultBgResource(R.color.CAM_X0205);
        this.hWQ.setIsRound(true);
        this.hWQ.setDrawBorder(true);
        this.hWQ.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hWQ.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ar("c13047").ak("obj_locate", 7).dR("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    bf.bqF().a((TbPageContext) com.baidu.adp.base.i.I(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.hWK.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.hWI.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.hWL.setText(featureCardCompetitionSubNode.title);
        this.hWO.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.hWP.setText(featureCardCompetitionSubNode.team1_name);
        this.hWQ.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.hWR.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.hWL, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.hWN, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.hWP, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.hWR, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.hWS, R.color.CAM_X0101, 1);
        }
        this.mSkinType = i;
    }
}

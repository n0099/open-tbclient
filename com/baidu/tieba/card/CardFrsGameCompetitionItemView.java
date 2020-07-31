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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes16.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout gUU;
    private TbImageView gUV;
    private LinearLayout gUW;
    private ClickableHeaderImageView gUX;
    private TextView gUY;
    private RelativeLayout gUZ;
    private TextView gVa;
    private ClickableHeaderImageView gVb;
    private TextView gVc;
    private ClickableHeaderImageView gVd;
    private TextView gVe;
    private TextView gVf;
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
        this.gUU = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.gUV = (TbImageView) findViewById(R.id.card_competition_bg);
        this.gUW = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.gUX = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.gUY = (TextView) findViewById(R.id.card_competition_title);
        this.gUZ = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.gVa = (TextView) findViewById(R.id.card_competition_vs);
        this.gVb = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.gVc = (TextView) findViewById(R.id.card_competition_left_name);
        this.gVd = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.gVe = (TextView) findViewById(R.id.card_competition_right_name);
        this.gVf = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gUV.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.gUV.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gUU.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.gUU.setLayoutParams(layoutParams2);
        this.gUV.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gUV.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gUX.setDrawBorder(true);
        this.gUX.setDrawerType(1);
        this.gUX.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.gUX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gUX.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.gUX.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gVb.setDefaultResource(17170445);
        this.gVb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gVb.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gVb.setIsRound(true);
        this.gVb.setDrawBorder(true);
        this.gVb.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.gVb.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gVd.setDefaultResource(17170445);
        this.gVd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gVd.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gVd.setIsRound(true);
        this.gVd.setDrawBorder(true);
        this.gVd.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.gVd.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ap("c13047").ah("obj_locate", 7).dn("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    bd.baV().a((TbPageContext) com.baidu.adp.base.i.G(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.gUX.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.gUV.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.gUY.setText(featureCardCompetitionSubNode.title);
        this.gVb.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.gVc.setText(featureCardCompetitionSubNode.team1_name);
        this.gVd.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.gVe.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.gUY, R.color.cp_cont_a, 1);
            ao.setViewTextColor(this.gVa, R.color.cp_cont_a, 1);
            ao.setViewTextColor(this.gVc, R.color.cp_cont_a, 1);
            ao.setViewTextColor(this.gVe, R.color.cp_cont_a, 1);
            ao.setViewTextColor(this.gVf, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

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
    private RelativeLayout hQk;
    private TbImageView hQl;
    private LinearLayout hQm;
    private ClickableHeaderImageView hQn;
    private TextView hQo;
    private RelativeLayout hQp;
    private TextView hQq;
    private ClickableHeaderImageView hQr;
    private TextView hQs;
    private ClickableHeaderImageView hQt;
    private TextView hQu;
    private TextView hQv;
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
        this.hQk = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.hQl = (TbImageView) findViewById(R.id.card_competition_bg);
        this.hQm = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.hQn = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.hQo = (TextView) findViewById(R.id.card_competition_title);
        this.hQp = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.hQq = (TextView) findViewById(R.id.card_competition_vs);
        this.hQr = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.hQs = (TextView) findViewById(R.id.card_competition_left_name);
        this.hQt = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.hQu = (TextView) findViewById(R.id.card_competition_right_name);
        this.hQv = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hQl.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.hQl.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hQk.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.hQk.setLayoutParams(layoutParams2);
        this.hQl.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hQl.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hQn.setDrawBorder(true);
        this.hQn.setDrawerType(1);
        this.hQn.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.hQn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hQn.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hQn.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hQr.setDefaultResource(17170445);
        this.hQr.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hQr.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hQr.setIsRound(true);
        this.hQr.setDrawBorder(true);
        this.hQr.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hQr.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hQt.setDefaultResource(17170445);
        this.hQt.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hQt.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hQt.setIsRound(true);
        this.hQt.setDrawBorder(true);
        this.hQt.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hQt.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").aj("obj_locate", 7).dR("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    be.boR().a((TbPageContext) com.baidu.adp.base.i.I(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.hQn.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.hQl.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.hQo.setText(featureCardCompetitionSubNode.title);
        this.hQr.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.hQs.setText(featureCardCompetitionSubNode.team1_name);
        this.hQt.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.hQu.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.hQo, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hQq, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hQs, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hQu, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hQv, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

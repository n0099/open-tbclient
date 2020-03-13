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
    private RelativeLayout fHZ;
    private TbImageView fIa;
    private LinearLayout fIb;
    private ClickableHeaderImageView fIc;
    private TextView fId;
    private RelativeLayout fIe;
    private TextView fIf;
    private ClickableHeaderImageView fIg;
    private TextView fIh;
    private ClickableHeaderImageView fIi;
    private TextView fIj;
    private TextView fIk;
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
        this.fHZ = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.fIa = (TbImageView) findViewById(R.id.card_competition_bg);
        this.fIb = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.fIc = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.fId = (TextView) findViewById(R.id.card_competition_title);
        this.fIe = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.fIf = (TextView) findViewById(R.id.card_competition_vs);
        this.fIg = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.fIh = (TextView) findViewById(R.id.card_competition_left_name);
        this.fIi = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.fIj = (TextView) findViewById(R.id.card_competition_right_name);
        this.fIk = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fIa.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.fIa.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fHZ.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.fHZ.setLayoutParams(layoutParams2);
        this.fIa.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fIa.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fIc.setDrawBorder(true);
        this.fIc.setDrawerType(1);
        this.fIc.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.fIc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fIc.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIc.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fIg.setDefaultResource(17170445);
        this.fIg.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIg.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fIg.setIsRound(true);
        this.fIg.setDrawBorder(true);
        this.fIg.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIg.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fIi.setDefaultResource(17170445);
        this.fIi.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIi.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fIi.setIsRound(true);
        this.fIi.setDrawBorder(true);
        this.fIi.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIi.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").X("obj_locate", 7).cy("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aGG().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.fIc.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.fIa.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.fId.setText(featureCardCompetitionSubNode.title);
        this.fIg.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.fIh.setText(featureCardCompetitionSubNode.team1_name);
        this.fIi.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.fIj.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fId, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fIf, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fIh, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fIj, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fIk, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

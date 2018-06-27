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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes3.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private ClickableHeaderImageView cuA;
    private TextView cuB;
    private TextView cuC;
    private RelativeLayout cuq;
    private TbImageView cus;
    private LinearLayout cut;
    private ClickableHeaderImageView cuu;
    private TextView cuv;
    private RelativeLayout cuw;
    private TextView cux;
    private ClickableHeaderImageView cuy;
    private TextView cuz;
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
        LayoutInflater.from(context).inflate(d.i.card_frs_game_competition_view_item, (ViewGroup) this, true);
        this.cuq = (RelativeLayout) findViewById(d.g.card_competition_layout);
        this.cus = (TbImageView) findViewById(d.g.card_competition_bg);
        this.cut = (LinearLayout) findViewById(d.g.card_competition_title_layout);
        this.cuu = (ClickableHeaderImageView) findViewById(d.g.card_competition_title_header);
        this.cuv = (TextView) findViewById(d.g.card_competition_title);
        this.cuw = (RelativeLayout) findViewById(d.g.card_competition_content_layout);
        this.cux = (TextView) findViewById(d.g.card_competition_vs);
        this.cuy = (ClickableHeaderImageView) findViewById(d.g.card_competition_left_img);
        this.cuz = (TextView) findViewById(d.g.card_competition_left_name);
        this.cuA = (ClickableHeaderImageView) findViewById(d.g.card_competition_right_img);
        this.cuB = (TextView) findViewById(d.g.card_competition_right_name);
        this.cuC = (TextView) findViewById(d.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cus.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cus.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cuq.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cuq.setLayoutParams(layoutParams2);
        this.cus.setDefaultBgResource(d.f.icon_morenpic);
        this.cus.setDefaultErrorResource(d.f.icon_morenpic);
        this.cuu.setDrawBorder(true);
        this.cuu.setDrawerType(1);
        this.cuu.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds5));
        this.cuu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cuu.setBorderColor(am.getColor(d.C0142d.common_color_10043));
        this.cuu.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cuy.setDefaultResource(17170445);
        this.cuy.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cuy.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.cuy.setIsRound(true);
        this.cuy.setDrawBorder(true);
        this.cuy.setBorderColor(am.getColor(d.C0142d.common_color_10043));
        this.cuy.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cuA.setDefaultResource(17170445);
        this.cuA.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cuA.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.cuA.setIsRound(true);
        this.cuA.setDrawBorder(true);
        this.cuA.setBorderColor(am.getColor(d.C0142d.common_color_10043));
        this.cuA.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").r("obj_locate", 7).ah(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    az.zV().a((TbPageContext) com.baidu.adp.base.i.ad(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cuu.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cus.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cuv.setText(featureCardCompetitionSubNode.title);
        this.cuy.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cuz.setText(featureCardCompetitionSubNode.team1_name);
        this.cuA.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cuB.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.cuv, d.C0142d.cp_cont_i, 1);
            am.c(this.cux, d.C0142d.cp_cont_i, 1);
            am.c(this.cuz, d.C0142d.cp_cont_i, 1);
            am.c(this.cuB, d.C0142d.cp_cont_i, 1);
            am.c(this.cuC, d.C0142d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

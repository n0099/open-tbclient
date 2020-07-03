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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes9.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout gPo;
    private TbImageView gPp;
    private LinearLayout gPq;
    private ClickableHeaderImageView gPr;
    private TextView gPs;
    private RelativeLayout gPt;
    private TextView gPu;
    private ClickableHeaderImageView gPv;
    private TextView gPw;
    private ClickableHeaderImageView gPx;
    private TextView gPy;
    private TextView gPz;
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
        this.gPo = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.gPp = (TbImageView) findViewById(R.id.card_competition_bg);
        this.gPq = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.gPr = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.gPs = (TextView) findViewById(R.id.card_competition_title);
        this.gPt = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.gPu = (TextView) findViewById(R.id.card_competition_vs);
        this.gPv = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.gPw = (TextView) findViewById(R.id.card_competition_left_name);
        this.gPx = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.gPy = (TextView) findViewById(R.id.card_competition_right_name);
        this.gPz = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPp.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.gPp.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gPo.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.gPo.setLayoutParams(layoutParams2);
        this.gPp.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gPp.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gPr.setDrawBorder(true);
        this.gPr.setDrawerType(1);
        this.gPr.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.gPr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gPr.setBorderColor(an.getColor(R.color.common_color_10043));
        this.gPr.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gPv.setDefaultResource(17170445);
        this.gPv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gPv.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gPv.setIsRound(true);
        this.gPv.setDrawBorder(true);
        this.gPv.setBorderColor(an.getColor(R.color.common_color_10043));
        this.gPv.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gPx.setDefaultResource(17170445);
        this.gPx.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gPx.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gPx.setIsRound(true);
        this.gPx.setDrawBorder(true);
        this.gPx.setBorderColor(an.getColor(R.color.common_color_10043));
        this.gPx.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ao("c13047").ag("obj_locate", 7).dk("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    bc.aWU().a((TbPageContext) com.baidu.adp.base.i.G(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.gPr.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.gPp.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.gPs.setText(featureCardCompetitionSubNode.title);
        this.gPv.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.gPw.setText(featureCardCompetitionSubNode.team1_name);
        this.gPx.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.gPy.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            an.setViewTextColor(this.gPs, R.color.cp_cont_a, 1);
            an.setViewTextColor(this.gPu, R.color.cp_cont_a, 1);
            an.setViewTextColor(this.gPw, R.color.cp_cont_a, 1);
            an.setViewTextColor(this.gPy, R.color.cp_cont_a, 1);
            an.setViewTextColor(this.gPz, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

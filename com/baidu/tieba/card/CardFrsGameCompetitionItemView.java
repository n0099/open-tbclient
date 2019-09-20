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
/* loaded from: classes4.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout eCo;
    private TbImageView eCp;
    private LinearLayout eCq;
    private ClickableHeaderImageView eCr;
    private TextView eCs;
    private RelativeLayout eCt;
    private TextView eCu;
    private ClickableHeaderImageView eCv;
    private TextView eCw;
    private ClickableHeaderImageView eCx;
    private TextView eCy;
    private TextView eCz;
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
        this.eCo = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.eCp = (TbImageView) findViewById(R.id.card_competition_bg);
        this.eCq = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.eCr = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.eCs = (TextView) findViewById(R.id.card_competition_title);
        this.eCt = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.eCu = (TextView) findViewById(R.id.card_competition_vs);
        this.eCv = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.eCw = (TextView) findViewById(R.id.card_competition_left_name);
        this.eCx = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.eCy = (TextView) findViewById(R.id.card_competition_right_name);
        this.eCz = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eCp.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.eCp.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eCo.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.eCo.setLayoutParams(layoutParams2);
        this.eCp.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eCp.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.eCr.setDrawBorder(true);
        this.eCr.setDrawerType(1);
        this.eCr.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.eCr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eCr.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eCr.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eCv.setDefaultResource(17170445);
        this.eCv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eCv.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eCv.setIsRound(true);
        this.eCv.setDrawBorder(true);
        this.eCv.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eCv.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eCx.setDefaultResource(17170445);
        this.eCx.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eCx.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eCx.setIsRound(true);
        this.eCx.setDrawBorder(true);
        this.eCx.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eCx.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").P("obj_locate", 7).bT("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.ajK().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.eCr.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.eCp.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.eCs.setText(featureCardCompetitionSubNode.title);
        this.eCv.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.eCw.setText(featureCardCompetitionSubNode.team1_name);
        this.eCx.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.eCy.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.f(this.eCs, R.color.cp_cont_a, 1);
            am.f(this.eCu, R.color.cp_cont_a, 1);
            am.f(this.eCw, R.color.cp_cont_a, 1);
            am.f(this.eCy, R.color.cp_cont_a, 1);
            am.f(this.eCz, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes4.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private LinearLayout evA;
    private ClickableHeaderImageView evB;
    private TextView evC;
    private RelativeLayout evD;
    private TextView evE;
    private ClickableHeaderImageView evF;
    private TextView evG;
    private ClickableHeaderImageView evH;
    private TextView evI;
    private TextView evJ;
    private RelativeLayout evy;
    private TbImageView evz;
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
        this.evy = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.evz = (TbImageView) findViewById(R.id.card_competition_bg);
        this.evA = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.evB = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.evC = (TextView) findViewById(R.id.card_competition_title);
        this.evD = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.evE = (TextView) findViewById(R.id.card_competition_vs);
        this.evF = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.evG = (TextView) findViewById(R.id.card_competition_left_name);
        this.evH = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.evI = (TextView) findViewById(R.id.card_competition_right_name);
        this.evJ = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evz.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.evz.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.evy.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.evy.setLayoutParams(layoutParams2);
        this.evz.setDefaultBgResource(R.drawable.icon_morenpic);
        this.evz.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.evB.setDrawBorder(true);
        this.evB.setDrawerType(1);
        this.evB.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.evB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.evB.setBorderColor(al.getColor(R.color.common_color_10043));
        this.evB.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.evF.setDefaultResource(17170445);
        this.evF.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.evF.setDefaultBgResource(R.color.cp_bg_line_e);
        this.evF.setIsRound(true);
        this.evF.setDrawBorder(true);
        this.evF.setBorderColor(al.getColor(R.color.common_color_10043));
        this.evF.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.evH.setDefaultResource(17170445);
        this.evH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.evH.setDefaultBgResource(R.color.cp_bg_line_e);
        this.evH.setIsRound(true);
        this.evH.setDrawBorder(true);
        this.evH.setBorderColor(al.getColor(R.color.common_color_10043));
        this.evH.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").P("obj_locate", 7).bT("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aiz().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.evB.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.evz.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.evC.setText(featureCardCompetitionSubNode.title);
        this.evF.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.evG.setText(featureCardCompetitionSubNode.team1_name);
        this.evH.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.evI.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.f(this.evC, R.color.cp_btn_a, 1);
            al.f(this.evE, R.color.cp_btn_a, 1);
            al.f(this.evG, R.color.cp_btn_a, 1);
            al.f(this.evI, R.color.cp_btn_a, 1);
            al.f(this.evJ, R.color.cp_btn_a, 1);
        }
        this.mSkinType = i;
    }
}

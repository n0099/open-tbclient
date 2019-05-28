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
    private TbImageView evA;
    private LinearLayout evB;
    private ClickableHeaderImageView evC;
    private TextView evD;
    private RelativeLayout evE;
    private TextView evF;
    private ClickableHeaderImageView evG;
    private TextView evH;
    private ClickableHeaderImageView evI;
    private TextView evJ;
    private TextView evK;
    private RelativeLayout evz;
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
        this.evz = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.evA = (TbImageView) findViewById(R.id.card_competition_bg);
        this.evB = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.evC = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.evD = (TextView) findViewById(R.id.card_competition_title);
        this.evE = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.evF = (TextView) findViewById(R.id.card_competition_vs);
        this.evG = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.evH = (TextView) findViewById(R.id.card_competition_left_name);
        this.evI = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.evJ = (TextView) findViewById(R.id.card_competition_right_name);
        this.evK = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evA.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.evA.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.evz.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.evz.setLayoutParams(layoutParams2);
        this.evA.setDefaultBgResource(R.drawable.icon_morenpic);
        this.evA.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.evC.setDrawBorder(true);
        this.evC.setDrawerType(1);
        this.evC.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.evC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.evC.setBorderColor(al.getColor(R.color.common_color_10043));
        this.evC.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.evG.setDefaultResource(17170445);
        this.evG.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.evG.setDefaultBgResource(R.color.cp_bg_line_e);
        this.evG.setIsRound(true);
        this.evG.setDrawBorder(true);
        this.evG.setBorderColor(al.getColor(R.color.common_color_10043));
        this.evG.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.evI.setDefaultResource(17170445);
        this.evI.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.evI.setDefaultBgResource(R.color.cp_bg_line_e);
        this.evI.setIsRound(true);
        this.evI.setDrawBorder(true);
        this.evI.setBorderColor(al.getColor(R.color.common_color_10043));
        this.evI.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
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
        this.evC.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.evA.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.evD.setText(featureCardCompetitionSubNode.title);
        this.evG.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.evH.setText(featureCardCompetitionSubNode.team1_name);
        this.evI.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.evJ.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.f(this.evD, R.color.cp_btn_a, 1);
            al.f(this.evF, R.color.cp_btn_a, 1);
            al.f(this.evH, R.color.cp_btn_a, 1);
            al.f(this.evJ, R.color.cp_btn_a, 1);
            al.f(this.evK, R.color.cp_btn_a, 1);
        }
        this.mSkinType = i;
    }
}

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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes3.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout cVE;
    private TbImageView cVF;
    private LinearLayout cVG;
    private ClickableHeaderImageView cVH;
    private TextView cVI;
    private RelativeLayout cVJ;
    private TextView cVK;
    private ClickableHeaderImageView cVL;
    private TextView cVM;
    private ClickableHeaderImageView cVN;
    private TextView cVO;
    private TextView cVP;
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
        LayoutInflater.from(context).inflate(e.h.card_frs_game_competition_view_item, (ViewGroup) this, true);
        this.cVE = (RelativeLayout) findViewById(e.g.card_competition_layout);
        this.cVF = (TbImageView) findViewById(e.g.card_competition_bg);
        this.cVG = (LinearLayout) findViewById(e.g.card_competition_title_layout);
        this.cVH = (ClickableHeaderImageView) findViewById(e.g.card_competition_title_header);
        this.cVI = (TextView) findViewById(e.g.card_competition_title);
        this.cVJ = (RelativeLayout) findViewById(e.g.card_competition_content_layout);
        this.cVK = (TextView) findViewById(e.g.card_competition_vs);
        this.cVL = (ClickableHeaderImageView) findViewById(e.g.card_competition_left_img);
        this.cVM = (TextView) findViewById(e.g.card_competition_left_name);
        this.cVN = (ClickableHeaderImageView) findViewById(e.g.card_competition_right_img);
        this.cVO = (TextView) findViewById(e.g.card_competition_right_name);
        this.cVP = (TextView) findViewById(e.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.C0210e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cVF.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cVF.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cVE.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cVE.setLayoutParams(layoutParams2);
        this.cVF.setDefaultBgResource(e.f.icon_morenpic);
        this.cVF.setDefaultErrorResource(e.f.icon_morenpic);
        this.cVH.setDrawBorder(true);
        this.cVH.setDrawerType(1);
        this.cVH.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.tbds5));
        this.cVH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cVH.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cVH.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cVL.setDefaultResource(17170445);
        this.cVL.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cVL.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cVL.setIsRound(true);
        this.cVL.setDrawBorder(true);
        this.cVL.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cVL.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cVN.setDefaultResource(17170445);
        this.cVN.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cVN.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cVN.setIsRound(true);
        this.cVN.setDrawBorder(true);
        this.cVN.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cVN.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").x("obj_locate", 7).aA(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ay.Ef().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cVH.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cVF.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cVI.setText(featureCardCompetitionSubNode.title);
        this.cVL.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cVM.setText(featureCardCompetitionSubNode.team1_name);
        this.cVN.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cVO.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.cVI, e.d.cp_cont_i, 1);
            al.c(this.cVK, e.d.cp_cont_i, 1);
            al.c(this.cVM, e.d.cp_cont_i, 1);
            al.c(this.cVO, e.d.cp_cont_i, 1);
            al.c(this.cVP, e.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

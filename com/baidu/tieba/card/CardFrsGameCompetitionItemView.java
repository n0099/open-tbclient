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
    private RelativeLayout cSO;
    private TbImageView cSP;
    private LinearLayout cSQ;
    private ClickableHeaderImageView cSR;
    private TextView cSS;
    private RelativeLayout cST;
    private TextView cSU;
    private ClickableHeaderImageView cSV;
    private TextView cSW;
    private ClickableHeaderImageView cSX;
    private TextView cSY;
    private TextView cSZ;
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
        this.cSO = (RelativeLayout) findViewById(e.g.card_competition_layout);
        this.cSP = (TbImageView) findViewById(e.g.card_competition_bg);
        this.cSQ = (LinearLayout) findViewById(e.g.card_competition_title_layout);
        this.cSR = (ClickableHeaderImageView) findViewById(e.g.card_competition_title_header);
        this.cSS = (TextView) findViewById(e.g.card_competition_title);
        this.cST = (RelativeLayout) findViewById(e.g.card_competition_content_layout);
        this.cSU = (TextView) findViewById(e.g.card_competition_vs);
        this.cSV = (ClickableHeaderImageView) findViewById(e.g.card_competition_left_img);
        this.cSW = (TextView) findViewById(e.g.card_competition_left_name);
        this.cSX = (ClickableHeaderImageView) findViewById(e.g.card_competition_right_img);
        this.cSY = (TextView) findViewById(e.g.card_competition_right_name);
        this.cSZ = (TextView) findViewById(e.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.C0210e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cSP.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cSP.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cSO.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cSO.setLayoutParams(layoutParams2);
        this.cSP.setDefaultBgResource(e.f.icon_morenpic);
        this.cSP.setDefaultErrorResource(e.f.icon_morenpic);
        this.cSR.setDrawBorder(true);
        this.cSR.setDrawerType(1);
        this.cSR.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.tbds5));
        this.cSR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cSR.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cSR.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cSV.setDefaultResource(17170445);
        this.cSV.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cSV.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cSV.setIsRound(true);
        this.cSV.setDrawBorder(true);
        this.cSV.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cSV.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cSX.setDefaultResource(17170445);
        this.cSX.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cSX.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cSX.setIsRound(true);
        this.cSX.setDrawBorder(true);
        this.cSX.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cSX.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
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
        this.cSR.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cSP.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cSS.setText(featureCardCompetitionSubNode.title);
        this.cSV.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cSW.setText(featureCardCompetitionSubNode.team1_name);
        this.cSX.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cSY.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.cSS, e.d.cp_cont_i, 1);
            al.c(this.cSU, e.d.cp_cont_i, 1);
            al.c(this.cSW, e.d.cp_cont_i, 1);
            al.c(this.cSY, e.d.cp_cont_i, 1);
            al.c(this.cSZ, e.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

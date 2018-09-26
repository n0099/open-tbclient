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
    private RelativeLayout cCG;
    private TbImageView cCH;
    private LinearLayout cCI;
    private ClickableHeaderImageView cCJ;
    private TextView cCK;
    private RelativeLayout cCL;
    private TextView cCM;
    private ClickableHeaderImageView cCN;
    private TextView cCO;
    private ClickableHeaderImageView cCP;
    private TextView cCQ;
    private TextView cCR;
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
        this.cCG = (RelativeLayout) findViewById(e.g.card_competition_layout);
        this.cCH = (TbImageView) findViewById(e.g.card_competition_bg);
        this.cCI = (LinearLayout) findViewById(e.g.card_competition_title_layout);
        this.cCJ = (ClickableHeaderImageView) findViewById(e.g.card_competition_title_header);
        this.cCK = (TextView) findViewById(e.g.card_competition_title);
        this.cCL = (RelativeLayout) findViewById(e.g.card_competition_content_layout);
        this.cCM = (TextView) findViewById(e.g.card_competition_vs);
        this.cCN = (ClickableHeaderImageView) findViewById(e.g.card_competition_left_img);
        this.cCO = (TextView) findViewById(e.g.card_competition_left_name);
        this.cCP = (ClickableHeaderImageView) findViewById(e.g.card_competition_right_img);
        this.cCQ = (TextView) findViewById(e.g.card_competition_right_name);
        this.cCR = (TextView) findViewById(e.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.C0141e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cCH.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cCH.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cCG.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cCG.setLayoutParams(layoutParams2);
        this.cCH.setDefaultBgResource(e.f.icon_morenpic);
        this.cCH.setDefaultErrorResource(e.f.icon_morenpic);
        this.cCJ.setDrawBorder(true);
        this.cCJ.setDrawerType(1);
        this.cCJ.setRadius(context.getResources().getDimensionPixelSize(e.C0141e.tbds5));
        this.cCJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cCJ.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cCJ.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0141e.tbds1));
        this.cCN.setDefaultResource(17170445);
        this.cCN.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cCN.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cCN.setIsRound(true);
        this.cCN.setDrawBorder(true);
        this.cCN.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cCN.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0141e.tbds1));
        this.cCP.setDefaultResource(17170445);
        this.cCP.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cCP.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cCP.setIsRound(true);
        this.cCP.setDrawBorder(true);
        this.cCP.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cCP.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0141e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").w("obj_locate", 7).al(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ay.AN().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cCJ.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cCH.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cCK.setText(featureCardCompetitionSubNode.title);
        this.cCN.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cCO.setText(featureCardCompetitionSubNode.team1_name);
        this.cCP.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cCQ.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.cCK, e.d.cp_cont_i, 1);
            al.c(this.cCM, e.d.cp_cont_i, 1);
            al.c(this.cCO, e.d.cp_cont_i, 1);
            al.c(this.cCQ, e.d.cp_cont_i, 1);
            al.c(this.cCR, e.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

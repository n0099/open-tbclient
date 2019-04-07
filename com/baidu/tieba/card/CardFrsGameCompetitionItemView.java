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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes4.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout efK;
    private TbImageView efL;
    private LinearLayout efM;
    private ClickableHeaderImageView efN;
    private TextView efO;
    private RelativeLayout efP;
    private TextView efQ;
    private ClickableHeaderImageView efR;
    private TextView efS;
    private ClickableHeaderImageView efT;
    private TextView efU;
    private TextView efV;
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
        LayoutInflater.from(context).inflate(d.h.card_frs_game_competition_view_item, (ViewGroup) this, true);
        this.efK = (RelativeLayout) findViewById(d.g.card_competition_layout);
        this.efL = (TbImageView) findViewById(d.g.card_competition_bg);
        this.efM = (LinearLayout) findViewById(d.g.card_competition_title_layout);
        this.efN = (ClickableHeaderImageView) findViewById(d.g.card_competition_title_header);
        this.efO = (TextView) findViewById(d.g.card_competition_title);
        this.efP = (RelativeLayout) findViewById(d.g.card_competition_content_layout);
        this.efQ = (TextView) findViewById(d.g.card_competition_vs);
        this.efR = (ClickableHeaderImageView) findViewById(d.g.card_competition_left_img);
        this.efS = (TextView) findViewById(d.g.card_competition_left_name);
        this.efT = (ClickableHeaderImageView) findViewById(d.g.card_competition_right_img);
        this.efU = (TextView) findViewById(d.g.card_competition_right_name);
        this.efV = (TextView) findViewById(d.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.efL.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.efL.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.efK.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.efK.setLayoutParams(layoutParams2);
        this.efL.setDefaultBgResource(d.f.icon_morenpic);
        this.efL.setDefaultErrorResource(d.f.icon_morenpic);
        this.efN.setDrawBorder(true);
        this.efN.setDrawerType(1);
        this.efN.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds5));
        this.efN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.efN.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efN.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.efR.setDefaultResource(17170445);
        this.efR.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.efR.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.efR.setIsRound(true);
        this.efR.setDrawBorder(true);
        this.efR.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efR.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.efT.setDefaultResource(17170445);
        this.efT.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.efT.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.efT.setIsRound(true);
        this.efT.setDrawBorder(true);
        this.efT.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efT.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").T("obj_locate", 7).bJ(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ba.adA().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.efN.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.efL.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.efO.setText(featureCardCompetitionSubNode.title);
        this.efR.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.efS.setText(featureCardCompetitionSubNode.team1_name);
        this.efT.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.efU.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.d(this.efO, d.C0277d.cp_btn_a, 1);
            al.d(this.efQ, d.C0277d.cp_btn_a, 1);
            al.d(this.efS, d.C0277d.cp_btn_a, 1);
            al.d(this.efU, d.C0277d.cp_btn_a, 1);
            al.d(this.efV, d.C0277d.cp_btn_a, 1);
        }
        this.mSkinType = i;
    }
}

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
    private RelativeLayout efL;
    private TbImageView efM;
    private LinearLayout efN;
    private ClickableHeaderImageView efO;
    private TextView efP;
    private RelativeLayout efQ;
    private TextView efR;
    private ClickableHeaderImageView efS;
    private TextView efT;
    private ClickableHeaderImageView efU;
    private TextView efV;
    private TextView efW;
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
        this.efL = (RelativeLayout) findViewById(d.g.card_competition_layout);
        this.efM = (TbImageView) findViewById(d.g.card_competition_bg);
        this.efN = (LinearLayout) findViewById(d.g.card_competition_title_layout);
        this.efO = (ClickableHeaderImageView) findViewById(d.g.card_competition_title_header);
        this.efP = (TextView) findViewById(d.g.card_competition_title);
        this.efQ = (RelativeLayout) findViewById(d.g.card_competition_content_layout);
        this.efR = (TextView) findViewById(d.g.card_competition_vs);
        this.efS = (ClickableHeaderImageView) findViewById(d.g.card_competition_left_img);
        this.efT = (TextView) findViewById(d.g.card_competition_left_name);
        this.efU = (ClickableHeaderImageView) findViewById(d.g.card_competition_right_img);
        this.efV = (TextView) findViewById(d.g.card_competition_right_name);
        this.efW = (TextView) findViewById(d.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.efM.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.efM.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.efL.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.efL.setLayoutParams(layoutParams2);
        this.efM.setDefaultBgResource(d.f.icon_morenpic);
        this.efM.setDefaultErrorResource(d.f.icon_morenpic);
        this.efO.setDrawBorder(true);
        this.efO.setDrawerType(1);
        this.efO.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds5));
        this.efO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.efO.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efO.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.efS.setDefaultResource(17170445);
        this.efS.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.efS.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.efS.setIsRound(true);
        this.efS.setDrawBorder(true);
        this.efS.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efS.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.efU.setDefaultResource(17170445);
        this.efU.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.efU.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.efU.setIsRound(true);
        this.efU.setDrawBorder(true);
        this.efU.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efU.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
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
        this.efO.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.efM.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.efP.setText(featureCardCompetitionSubNode.title);
        this.efS.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.efT.setText(featureCardCompetitionSubNode.team1_name);
        this.efU.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.efV.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.d(this.efP, d.C0277d.cp_btn_a, 1);
            al.d(this.efR, d.C0277d.cp_btn_a, 1);
            al.d(this.efT, d.C0277d.cp_btn_a, 1);
            al.d(this.efV, d.C0277d.cp_btn_a, 1);
            al.d(this.efW, d.C0277d.cp_btn_a, 1);
        }
        this.mSkinType = i;
    }
}

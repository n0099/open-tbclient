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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes3.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private TbImageView cmA;
    private LinearLayout cmB;
    private ClickableHeaderImageView cmC;
    private TextView cmD;
    private RelativeLayout cmE;
    private TextView cmF;
    private ClickableHeaderImageView cmG;
    private TextView cmH;
    private ClickableHeaderImageView cmI;
    private TextView cmJ;
    private TextView cmK;
    private RelativeLayout cmz;
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
        this.cmz = (RelativeLayout) findViewById(d.g.card_competition_layout);
        this.cmA = (TbImageView) findViewById(d.g.card_competition_bg);
        this.cmB = (LinearLayout) findViewById(d.g.card_competition_title_layout);
        this.cmC = (ClickableHeaderImageView) findViewById(d.g.card_competition_title_header);
        this.cmD = (TextView) findViewById(d.g.card_competition_title);
        this.cmE = (RelativeLayout) findViewById(d.g.card_competition_content_layout);
        this.cmF = (TextView) findViewById(d.g.card_competition_vs);
        this.cmG = (ClickableHeaderImageView) findViewById(d.g.card_competition_left_img);
        this.cmH = (TextView) findViewById(d.g.card_competition_left_name);
        this.cmI = (ClickableHeaderImageView) findViewById(d.g.card_competition_right_img);
        this.cmJ = (TextView) findViewById(d.g.card_competition_right_name);
        this.cmK = (TextView) findViewById(d.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cmA.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cmA.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cmz.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cmz.setLayoutParams(layoutParams2);
        this.cmA.setDefaultBgResource(d.f.icon_morenpic);
        this.cmA.setDefaultErrorResource(d.f.icon_morenpic);
        this.cmC.setDrawBorder(true);
        this.cmC.setDrawerType(1);
        this.cmC.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds5));
        this.cmC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cmC.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cmC.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cmG.setDefaultResource(17170445);
        this.cmG.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cmG.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cmG.setIsRound(true);
        this.cmG.setDrawBorder(true);
        this.cmG.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cmG.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cmI.setDefaultResource(17170445);
        this.cmI.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cmI.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cmI.setIsRound(true);
        this.cmI.setDrawBorder(true);
        this.cmI.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cmI.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getTag() instanceof String) {
                    TiebaStatic.log(new al("c13047").r("obj_locate", 7).ac(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ax.wg().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view2.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cmC.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cmA.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cmD.setText(featureCardCompetitionSubNode.title);
        this.cmG.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cmH.setText(featureCardCompetitionSubNode.team1_name);
        this.cmI.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cmJ.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.c(this.cmD, d.C0126d.cp_cont_i, 1);
            ak.c(this.cmF, d.C0126d.cp_cont_i, 1);
            ak.c(this.cmH, d.C0126d.cp_cont_i, 1);
            ak.c(this.cmJ, d.C0126d.cp_cont_i, 1);
            ak.c(this.cmK, d.C0126d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

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
    private TextView cmA;
    private RelativeLayout cmB;
    private TextView cmC;
    private ClickableHeaderImageView cmD;
    private TextView cmE;
    private ClickableHeaderImageView cmF;
    private TextView cmG;
    private TextView cmH;
    private RelativeLayout cmw;
    private TbImageView cmx;
    private LinearLayout cmy;
    private ClickableHeaderImageView cmz;
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
        this.cmw = (RelativeLayout) findViewById(d.g.card_competition_layout);
        this.cmx = (TbImageView) findViewById(d.g.card_competition_bg);
        this.cmy = (LinearLayout) findViewById(d.g.card_competition_title_layout);
        this.cmz = (ClickableHeaderImageView) findViewById(d.g.card_competition_title_header);
        this.cmA = (TextView) findViewById(d.g.card_competition_title);
        this.cmB = (RelativeLayout) findViewById(d.g.card_competition_content_layout);
        this.cmC = (TextView) findViewById(d.g.card_competition_vs);
        this.cmD = (ClickableHeaderImageView) findViewById(d.g.card_competition_left_img);
        this.cmE = (TextView) findViewById(d.g.card_competition_left_name);
        this.cmF = (ClickableHeaderImageView) findViewById(d.g.card_competition_right_img);
        this.cmG = (TextView) findViewById(d.g.card_competition_right_name);
        this.cmH = (TextView) findViewById(d.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cmx.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cmx.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cmw.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cmw.setLayoutParams(layoutParams2);
        this.cmx.setDefaultBgResource(d.f.icon_morenpic);
        this.cmx.setDefaultErrorResource(d.f.icon_morenpic);
        this.cmz.setDrawBorder(true);
        this.cmz.setDrawerType(1);
        this.cmz.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds5));
        this.cmz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cmz.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cmz.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cmD.setDefaultResource(17170445);
        this.cmD.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cmD.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cmD.setIsRound(true);
        this.cmD.setDrawBorder(true);
        this.cmD.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cmD.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cmF.setDefaultResource(17170445);
        this.cmF.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cmF.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cmF.setIsRound(true);
        this.cmF.setDrawBorder(true);
        this.cmF.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cmF.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
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
        this.cmz.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cmx.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cmA.setText(featureCardCompetitionSubNode.title);
        this.cmD.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cmE.setText(featureCardCompetitionSubNode.team1_name);
        this.cmF.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cmG.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.c(this.cmA, d.C0126d.cp_cont_i, 1);
            ak.c(this.cmC, d.C0126d.cp_cont_i, 1);
            ak.c(this.cmE, d.C0126d.cp_cont_i, 1);
            ak.c(this.cmG, d.C0126d.cp_cont_i, 1);
            ak.c(this.cmH, d.C0126d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

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
    private RelativeLayout cLb;
    private TbImageView cLc;
    private LinearLayout cLd;
    private ClickableHeaderImageView cLe;
    private TextView cLf;
    private RelativeLayout cLg;
    private TextView cLh;
    private ClickableHeaderImageView cLi;
    private TextView cLj;
    private ClickableHeaderImageView cLk;
    private TextView cLl;
    private TextView cLm;
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
        this.cLb = (RelativeLayout) findViewById(e.g.card_competition_layout);
        this.cLc = (TbImageView) findViewById(e.g.card_competition_bg);
        this.cLd = (LinearLayout) findViewById(e.g.card_competition_title_layout);
        this.cLe = (ClickableHeaderImageView) findViewById(e.g.card_competition_title_header);
        this.cLf = (TextView) findViewById(e.g.card_competition_title);
        this.cLg = (RelativeLayout) findViewById(e.g.card_competition_content_layout);
        this.cLh = (TextView) findViewById(e.g.card_competition_vs);
        this.cLi = (ClickableHeaderImageView) findViewById(e.g.card_competition_left_img);
        this.cLj = (TextView) findViewById(e.g.card_competition_left_name);
        this.cLk = (ClickableHeaderImageView) findViewById(e.g.card_competition_right_img);
        this.cLl = (TextView) findViewById(e.g.card_competition_right_name);
        this.cLm = (TextView) findViewById(e.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.C0175e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cLc.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cLc.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cLb.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cLb.setLayoutParams(layoutParams2);
        this.cLc.setDefaultBgResource(e.f.icon_morenpic);
        this.cLc.setDefaultErrorResource(e.f.icon_morenpic);
        this.cLe.setDrawBorder(true);
        this.cLe.setDrawerType(1);
        this.cLe.setRadius(context.getResources().getDimensionPixelSize(e.C0175e.tbds5));
        this.cLe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cLe.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cLe.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0175e.tbds1));
        this.cLi.setDefaultResource(17170445);
        this.cLi.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cLi.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cLi.setIsRound(true);
        this.cLi.setDrawBorder(true);
        this.cLi.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cLi.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0175e.tbds1));
        this.cLk.setDefaultResource(17170445);
        this.cLk.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cLk.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cLk.setIsRound(true);
        this.cLk.setDrawBorder(true);
        this.cLk.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cLk.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0175e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").x("obj_locate", 7).ax(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ay.CU().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cLe.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cLc.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cLf.setText(featureCardCompetitionSubNode.title);
        this.cLi.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cLj.setText(featureCardCompetitionSubNode.team1_name);
        this.cLk.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cLl.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.cLf, e.d.cp_cont_i, 1);
            al.c(this.cLh, e.d.cp_cont_i, 1);
            al.c(this.cLj, e.d.cp_cont_i, 1);
            al.c(this.cLl, e.d.cp_cont_i, 1);
            al.c(this.cLm, e.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

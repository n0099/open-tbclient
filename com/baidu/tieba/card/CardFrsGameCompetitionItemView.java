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
    private TextView cWA;
    private TextView cWB;
    private RelativeLayout cWq;
    private TbImageView cWr;
    private LinearLayout cWs;
    private ClickableHeaderImageView cWt;
    private TextView cWu;
    private RelativeLayout cWv;
    private TextView cWw;
    private ClickableHeaderImageView cWx;
    private TextView cWy;
    private ClickableHeaderImageView cWz;
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
        this.cWq = (RelativeLayout) findViewById(e.g.card_competition_layout);
        this.cWr = (TbImageView) findViewById(e.g.card_competition_bg);
        this.cWs = (LinearLayout) findViewById(e.g.card_competition_title_layout);
        this.cWt = (ClickableHeaderImageView) findViewById(e.g.card_competition_title_header);
        this.cWu = (TextView) findViewById(e.g.card_competition_title);
        this.cWv = (RelativeLayout) findViewById(e.g.card_competition_content_layout);
        this.cWw = (TextView) findViewById(e.g.card_competition_vs);
        this.cWx = (ClickableHeaderImageView) findViewById(e.g.card_competition_left_img);
        this.cWy = (TextView) findViewById(e.g.card_competition_left_name);
        this.cWz = (ClickableHeaderImageView) findViewById(e.g.card_competition_right_img);
        this.cWA = (TextView) findViewById(e.g.card_competition_right_name);
        this.cWB = (TextView) findViewById(e.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.C0210e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cWr.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cWr.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWq.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cWq.setLayoutParams(layoutParams2);
        this.cWr.setDefaultBgResource(e.f.icon_morenpic);
        this.cWr.setDefaultErrorResource(e.f.icon_morenpic);
        this.cWt.setDrawBorder(true);
        this.cWt.setDrawerType(1);
        this.cWt.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.tbds5));
        this.cWt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cWt.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWt.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cWx.setDefaultResource(17170445);
        this.cWx.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWx.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWx.setIsRound(true);
        this.cWx.setDrawBorder(true);
        this.cWx.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWx.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cWz.setDefaultResource(17170445);
        this.cWz.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWz.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWz.setIsRound(true);
        this.cWz.setDrawBorder(true);
        this.cWz.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWz.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").y("obj_locate", 7).aB(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ay.Es().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cWt.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cWr.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cWu.setText(featureCardCompetitionSubNode.title);
        this.cWx.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cWy.setText(featureCardCompetitionSubNode.team1_name);
        this.cWz.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cWA.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.cWu, e.d.cp_cont_i, 1);
            al.c(this.cWw, e.d.cp_cont_i, 1);
            al.c(this.cWy, e.d.cp_cont_i, 1);
            al.c(this.cWA, e.d.cp_cont_i, 1);
            al.c(this.cWB, e.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

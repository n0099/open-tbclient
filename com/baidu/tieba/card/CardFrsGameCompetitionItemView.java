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
    private RelativeLayout cWp;
    private TbImageView cWq;
    private LinearLayout cWr;
    private ClickableHeaderImageView cWs;
    private TextView cWt;
    private RelativeLayout cWu;
    private TextView cWv;
    private ClickableHeaderImageView cWw;
    private TextView cWx;
    private ClickableHeaderImageView cWy;
    private TextView cWz;
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
        this.cWp = (RelativeLayout) findViewById(e.g.card_competition_layout);
        this.cWq = (TbImageView) findViewById(e.g.card_competition_bg);
        this.cWr = (LinearLayout) findViewById(e.g.card_competition_title_layout);
        this.cWs = (ClickableHeaderImageView) findViewById(e.g.card_competition_title_header);
        this.cWt = (TextView) findViewById(e.g.card_competition_title);
        this.cWu = (RelativeLayout) findViewById(e.g.card_competition_content_layout);
        this.cWv = (TextView) findViewById(e.g.card_competition_vs);
        this.cWw = (ClickableHeaderImageView) findViewById(e.g.card_competition_left_img);
        this.cWx = (TextView) findViewById(e.g.card_competition_left_name);
        this.cWy = (ClickableHeaderImageView) findViewById(e.g.card_competition_right_img);
        this.cWz = (TextView) findViewById(e.g.card_competition_right_name);
        this.cWA = (TextView) findViewById(e.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.C0210e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cWq.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cWq.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWp.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cWp.setLayoutParams(layoutParams2);
        this.cWq.setDefaultBgResource(e.f.icon_morenpic);
        this.cWq.setDefaultErrorResource(e.f.icon_morenpic);
        this.cWs.setDrawBorder(true);
        this.cWs.setDrawerType(1);
        this.cWs.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.tbds5));
        this.cWs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cWs.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWs.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cWw.setDefaultResource(17170445);
        this.cWw.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWw.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWw.setIsRound(true);
        this.cWw.setDrawBorder(true);
        this.cWw.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWw.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cWy.setDefaultResource(17170445);
        this.cWy.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWy.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWy.setIsRound(true);
        this.cWy.setDrawBorder(true);
        this.cWy.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWy.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0210e.tbds1));
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
        this.cWs.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cWq.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cWt.setText(featureCardCompetitionSubNode.title);
        this.cWw.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cWx.setText(featureCardCompetitionSubNode.team1_name);
        this.cWy.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cWz.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.cWt, e.d.cp_cont_i, 1);
            al.c(this.cWv, e.d.cp_cont_i, 1);
            al.c(this.cWx, e.d.cp_cont_i, 1);
            al.c(this.cWz, e.d.cp_cont_i, 1);
            al.c(this.cWA, e.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

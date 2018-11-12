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
    private RelativeLayout cMh;
    private TbImageView cMi;
    private LinearLayout cMj;
    private ClickableHeaderImageView cMk;
    private TextView cMl;
    private RelativeLayout cMm;
    private TextView cMn;
    private ClickableHeaderImageView cMo;
    private TextView cMp;
    private ClickableHeaderImageView cMq;
    private TextView cMr;
    private TextView cMs;
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
        this.cMh = (RelativeLayout) findViewById(e.g.card_competition_layout);
        this.cMi = (TbImageView) findViewById(e.g.card_competition_bg);
        this.cMj = (LinearLayout) findViewById(e.g.card_competition_title_layout);
        this.cMk = (ClickableHeaderImageView) findViewById(e.g.card_competition_title_header);
        this.cMl = (TextView) findViewById(e.g.card_competition_title);
        this.cMm = (RelativeLayout) findViewById(e.g.card_competition_content_layout);
        this.cMn = (TextView) findViewById(e.g.card_competition_vs);
        this.cMo = (ClickableHeaderImageView) findViewById(e.g.card_competition_left_img);
        this.cMp = (TextView) findViewById(e.g.card_competition_left_name);
        this.cMq = (ClickableHeaderImageView) findViewById(e.g.card_competition_right_img);
        this.cMr = (TextView) findViewById(e.g.card_competition_right_name);
        this.cMs = (TextView) findViewById(e.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.C0200e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cMi.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cMi.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cMh.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cMh.setLayoutParams(layoutParams2);
        this.cMi.setDefaultBgResource(e.f.icon_morenpic);
        this.cMi.setDefaultErrorResource(e.f.icon_morenpic);
        this.cMk.setDrawBorder(true);
        this.cMk.setDrawerType(1);
        this.cMk.setRadius(context.getResources().getDimensionPixelSize(e.C0200e.tbds5));
        this.cMk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cMk.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cMk.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0200e.tbds1));
        this.cMo.setDefaultResource(17170445);
        this.cMo.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cMo.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cMo.setIsRound(true);
        this.cMo.setDrawBorder(true);
        this.cMo.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cMo.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0200e.tbds1));
        this.cMq.setDefaultResource(17170445);
        this.cMq.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cMq.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cMq.setIsRound(true);
        this.cMq.setDrawBorder(true);
        this.cMq.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cMq.setBorderWidth(context.getResources().getDimensionPixelSize(e.C0200e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").x("obj_locate", 7).ax(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ay.Db().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cMk.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cMi.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cMl.setText(featureCardCompetitionSubNode.title);
        this.cMo.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cMp.setText(featureCardCompetitionSubNode.team1_name);
        this.cMq.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cMr.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.cMl, e.d.cp_cont_i, 1);
            al.c(this.cMn, e.d.cp_cont_i, 1);
            al.c(this.cMp, e.d.cp_cont_i, 1);
            al.c(this.cMr, e.d.cp_cont_i, 1);
            al.c(this.cMs, e.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

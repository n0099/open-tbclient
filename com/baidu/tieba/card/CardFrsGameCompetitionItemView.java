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
    private RelativeLayout efY;
    private TbImageView efZ;
    private LinearLayout ega;
    private ClickableHeaderImageView egb;
    private TextView egc;
    private RelativeLayout egd;
    private TextView ege;
    private ClickableHeaderImageView egf;
    private TextView egg;
    private ClickableHeaderImageView egh;
    private TextView egi;
    private TextView egj;
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
        this.efY = (RelativeLayout) findViewById(d.g.card_competition_layout);
        this.efZ = (TbImageView) findViewById(d.g.card_competition_bg);
        this.ega = (LinearLayout) findViewById(d.g.card_competition_title_layout);
        this.egb = (ClickableHeaderImageView) findViewById(d.g.card_competition_title_header);
        this.egc = (TextView) findViewById(d.g.card_competition_title);
        this.egd = (RelativeLayout) findViewById(d.g.card_competition_content_layout);
        this.ege = (TextView) findViewById(d.g.card_competition_vs);
        this.egf = (ClickableHeaderImageView) findViewById(d.g.card_competition_left_img);
        this.egg = (TextView) findViewById(d.g.card_competition_left_name);
        this.egh = (ClickableHeaderImageView) findViewById(d.g.card_competition_right_img);
        this.egi = (TextView) findViewById(d.g.card_competition_right_name);
        this.egj = (TextView) findViewById(d.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.efZ.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.efZ.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.efY.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.efY.setLayoutParams(layoutParams2);
        this.efZ.setDefaultBgResource(d.f.icon_morenpic);
        this.efZ.setDefaultErrorResource(d.f.icon_morenpic);
        this.egb.setDrawBorder(true);
        this.egb.setDrawerType(1);
        this.egb.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds5));
        this.egb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.egb.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.egb.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.egf.setDefaultResource(17170445);
        this.egf.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.egf.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.egf.setIsRound(true);
        this.egf.setDrawBorder(true);
        this.egf.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.egf.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.egh.setDefaultResource(17170445);
        this.egh.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.egh.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.egh.setIsRound(true);
        this.egh.setDrawBorder(true);
        this.egh.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.egh.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").T("obj_locate", 7).bJ(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ba.adD().a((TbPageContext) com.baidu.adp.base.i.aK(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.egb.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.efZ.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.egc.setText(featureCardCompetitionSubNode.title);
        this.egf.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.egg.setText(featureCardCompetitionSubNode.team1_name);
        this.egh.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.egi.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.d(this.egc, d.C0277d.cp_btn_a, 1);
            al.d(this.ege, d.C0277d.cp_btn_a, 1);
            al.d(this.egg, d.C0277d.cp_btn_a, 1);
            al.d(this.egi, d.C0277d.cp_btn_a, 1);
            al.d(this.egj, d.C0277d.cp_btn_a, 1);
        }
        this.mSkinType = i;
    }
}

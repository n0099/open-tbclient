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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes3.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout cwk;
    private TbImageView cwl;
    private LinearLayout cwm;
    private ClickableHeaderImageView cwn;
    private TextView cwo;
    private RelativeLayout cwp;
    private TextView cwq;
    private ClickableHeaderImageView cwr;
    private TextView cws;
    private ClickableHeaderImageView cwt;
    private TextView cwu;
    private TextView cwv;
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
        this.cwk = (RelativeLayout) findViewById(d.g.card_competition_layout);
        this.cwl = (TbImageView) findViewById(d.g.card_competition_bg);
        this.cwm = (LinearLayout) findViewById(d.g.card_competition_title_layout);
        this.cwn = (ClickableHeaderImageView) findViewById(d.g.card_competition_title_header);
        this.cwo = (TextView) findViewById(d.g.card_competition_title);
        this.cwp = (RelativeLayout) findViewById(d.g.card_competition_content_layout);
        this.cwq = (TextView) findViewById(d.g.card_competition_vs);
        this.cwr = (ClickableHeaderImageView) findViewById(d.g.card_competition_left_img);
        this.cws = (TextView) findViewById(d.g.card_competition_left_name);
        this.cwt = (ClickableHeaderImageView) findViewById(d.g.card_competition_right_img);
        this.cwu = (TextView) findViewById(d.g.card_competition_right_name);
        this.cwv = (TextView) findViewById(d.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cwl.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cwl.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cwk.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cwk.setLayoutParams(layoutParams2);
        this.cwl.setDefaultBgResource(d.f.icon_morenpic);
        this.cwl.setDefaultErrorResource(d.f.icon_morenpic);
        this.cwn.setDrawBorder(true);
        this.cwn.setDrawerType(1);
        this.cwn.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds5));
        this.cwn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cwn.setBorderColor(al.getColor(d.C0141d.common_color_10043));
        this.cwn.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cwr.setDefaultResource(17170445);
        this.cwr.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cwr.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cwr.setIsRound(true);
        this.cwr.setDrawBorder(true);
        this.cwr.setBorderColor(al.getColor(d.C0141d.common_color_10043));
        this.cwr.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cwt.setDefaultResource(17170445);
        this.cwt.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cwt.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cwt.setIsRound(true);
        this.cwt.setDrawBorder(true);
        this.cwt.setBorderColor(al.getColor(d.C0141d.common_color_10043));
        this.cwt.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new am("c13047").r("obj_locate", 7).ah(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ay.zG().a((TbPageContext) com.baidu.adp.base.i.ad(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cwn.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cwl.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cwo.setText(featureCardCompetitionSubNode.title);
        this.cwr.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cws.setText(featureCardCompetitionSubNode.team1_name);
        this.cwt.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cwu.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.c(this.cwo, d.C0141d.cp_cont_i, 1);
            al.c(this.cwq, d.C0141d.cp_cont_i, 1);
            al.c(this.cws, d.C0141d.cp_cont_i, 1);
            al.c(this.cwu, d.C0141d.cp_cont_i, 1);
            al.c(this.cwv, d.C0141d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

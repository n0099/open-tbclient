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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes21.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout hoU;
    private TbImageView hoV;
    private LinearLayout hoW;
    private ClickableHeaderImageView hoX;
    private TextView hoY;
    private RelativeLayout hoZ;
    private TextView hpa;
    private ClickableHeaderImageView hpb;
    private TextView hpc;
    private ClickableHeaderImageView hpd;
    private TextView hpe;
    private TextView hpf;
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
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_competition_view_item, (ViewGroup) this, true);
        this.hoU = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.hoV = (TbImageView) findViewById(R.id.card_competition_bg);
        this.hoW = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.hoX = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.hoY = (TextView) findViewById(R.id.card_competition_title);
        this.hoZ = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.hpa = (TextView) findViewById(R.id.card_competition_vs);
        this.hpb = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.hpc = (TextView) findViewById(R.id.card_competition_left_name);
        this.hpd = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.hpe = (TextView) findViewById(R.id.card_competition_right_name);
        this.hpf = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hoV.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.hoV.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hoU.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.hoU.setLayoutParams(layoutParams2);
        this.hoV.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hoV.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hoX.setDrawBorder(true);
        this.hoX.setDrawerType(1);
        this.hoX.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.hoX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hoX.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hoX.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hpb.setDefaultResource(17170445);
        this.hpb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hpb.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hpb.setIsRound(true);
        this.hpb.setDrawBorder(true);
        this.hpb.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hpb.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hpd.setDefaultResource(17170445);
        this.hpd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hpd.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hpd.setIsRound(true);
        this.hpd.setDrawBorder(true);
        this.hpd.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hpd.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").ai("obj_locate", 7).dF("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    be.bkp().a((TbPageContext) com.baidu.adp.base.i.I(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.hoX.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.hoV.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.hoY.setText(featureCardCompetitionSubNode.title);
        this.hpb.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.hpc.setText(featureCardCompetitionSubNode.team1_name);
        this.hpd.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.hpe.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.hoY, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hpa, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hpc, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hpe, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hpf, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

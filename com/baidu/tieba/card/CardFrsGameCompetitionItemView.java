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
/* loaded from: classes16.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout hhQ;
    private TbImageView hhR;
    private LinearLayout hhS;
    private ClickableHeaderImageView hhT;
    private TextView hhU;
    private RelativeLayout hhV;
    private TextView hhW;
    private ClickableHeaderImageView hhX;
    private TextView hhY;
    private ClickableHeaderImageView hhZ;
    private TextView hia;
    private TextView hib;
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
        this.hhQ = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.hhR = (TbImageView) findViewById(R.id.card_competition_bg);
        this.hhS = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.hhT = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.hhU = (TextView) findViewById(R.id.card_competition_title);
        this.hhV = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.hhW = (TextView) findViewById(R.id.card_competition_vs);
        this.hhX = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.hhY = (TextView) findViewById(R.id.card_competition_left_name);
        this.hhZ = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.hia = (TextView) findViewById(R.id.card_competition_right_name);
        this.hib = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hhR.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.hhR.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hhQ.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.hhQ.setLayoutParams(layoutParams2);
        this.hhR.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hhR.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hhT.setDrawBorder(true);
        this.hhT.setDrawerType(1);
        this.hhT.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.hhT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hhT.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hhT.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hhX.setDefaultResource(17170445);
        this.hhX.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hhX.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hhX.setIsRound(true);
        this.hhX.setDrawBorder(true);
        this.hhX.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hhX.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hhZ.setDefaultResource(17170445);
        this.hhZ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hhZ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hhZ.setIsRound(true);
        this.hhZ.setDrawBorder(true);
        this.hhZ.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hhZ.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").ai("obj_locate", 7).dD("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    be.bju().a((TbPageContext) com.baidu.adp.base.i.I(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.hhT.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.hhR.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.hhU.setText(featureCardCompetitionSubNode.title);
        this.hhX.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.hhY.setText(featureCardCompetitionSubNode.team1_name);
        this.hhZ.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.hia.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.hhU, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hhW, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hhY, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hia, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hib, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

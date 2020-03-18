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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes9.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout fIH;
    private TbImageView fII;
    private LinearLayout fIJ;
    private ClickableHeaderImageView fIK;
    private TextView fIL;
    private RelativeLayout fIM;
    private TextView fIN;
    private ClickableHeaderImageView fIO;
    private TextView fIP;
    private ClickableHeaderImageView fIQ;
    private TextView fIR;
    private TextView fIS;
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
        this.fIH = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.fII = (TbImageView) findViewById(R.id.card_competition_bg);
        this.fIJ = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.fIK = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.fIL = (TextView) findViewById(R.id.card_competition_title);
        this.fIM = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.fIN = (TextView) findViewById(R.id.card_competition_vs);
        this.fIO = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.fIP = (TextView) findViewById(R.id.card_competition_left_name);
        this.fIQ = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.fIR = (TextView) findViewById(R.id.card_competition_right_name);
        this.fIS = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fII.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.fII.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fIH.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.fIH.setLayoutParams(layoutParams2);
        this.fII.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fII.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fIK.setDrawBorder(true);
        this.fIK.setDrawerType(1);
        this.fIK.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.fIK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fIK.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIK.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fIO.setDefaultResource(17170445);
        this.fIO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIO.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fIO.setIsRound(true);
        this.fIO.setDrawBorder(true);
        this.fIO.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIO.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fIQ.setDefaultResource(17170445);
        this.fIQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIQ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fIQ.setIsRound(true);
        this.fIQ.setDrawBorder(true);
        this.fIQ.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIQ.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").X("obj_locate", 7).cx("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aGK().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.fIK.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.fII.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.fIL.setText(featureCardCompetitionSubNode.title);
        this.fIO.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.fIP.setText(featureCardCompetitionSubNode.team1_name);
        this.fIQ.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.fIR.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fIL, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fIN, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fIP, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fIR, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fIS, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

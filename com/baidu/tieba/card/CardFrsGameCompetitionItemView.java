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
/* loaded from: classes22.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout hWh;
    private TbImageView hWi;
    private LinearLayout hWj;
    private ClickableHeaderImageView hWk;
    private TextView hWl;
    private RelativeLayout hWm;
    private TextView hWn;
    private ClickableHeaderImageView hWo;
    private TextView hWp;
    private ClickableHeaderImageView hWq;
    private TextView hWr;
    private TextView hWs;
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
        this.hWh = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.hWi = (TbImageView) findViewById(R.id.card_competition_bg);
        this.hWj = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.hWk = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.hWl = (TextView) findViewById(R.id.card_competition_title);
        this.hWm = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.hWn = (TextView) findViewById(R.id.card_competition_vs);
        this.hWo = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.hWp = (TextView) findViewById(R.id.card_competition_left_name);
        this.hWq = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.hWr = (TextView) findViewById(R.id.card_competition_right_name);
        this.hWs = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hWi.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.hWi.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hWh.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.hWh.setLayoutParams(layoutParams2);
        this.hWi.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hWi.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hWk.setDrawBorder(true);
        this.hWk.setDrawerType(1);
        this.hWk.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.hWk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hWk.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hWk.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hWo.setDefaultResource(17170445);
        this.hWo.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hWo.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hWo.setIsRound(true);
        this.hWo.setDrawBorder(true);
        this.hWo.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hWo.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hWq.setDefaultResource(17170445);
        this.hWq.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hWq.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hWq.setIsRound(true);
        this.hWq.setDrawBorder(true);
        this.hWq.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hWq.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").al("obj_locate", 7).dR("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    be.brr().a((TbPageContext) com.baidu.adp.base.i.I(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.hWk.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.hWi.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.hWl.setText(featureCardCompetitionSubNode.title);
        this.hWo.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.hWp.setText(featureCardCompetitionSubNode.team1_name);
        this.hWq.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.hWr.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.hWl, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hWn, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hWp, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hWr, R.color.cp_cont_a, 1);
            ap.setViewTextColor(this.hWs, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

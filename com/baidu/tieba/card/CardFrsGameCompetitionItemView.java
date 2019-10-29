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
/* loaded from: classes4.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout eKW;
    private TbImageView eKX;
    private LinearLayout eKY;
    private ClickableHeaderImageView eKZ;
    private TextView eLa;
    private RelativeLayout eLb;
    private TextView eLc;
    private ClickableHeaderImageView eLd;
    private TextView eLe;
    private ClickableHeaderImageView eLf;
    private TextView eLg;
    private TextView eLh;
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
        this.eKW = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.eKX = (TbImageView) findViewById(R.id.card_competition_bg);
        this.eKY = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.eKZ = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.eLa = (TextView) findViewById(R.id.card_competition_title);
        this.eLb = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.eLc = (TextView) findViewById(R.id.card_competition_vs);
        this.eLd = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.eLe = (TextView) findViewById(R.id.card_competition_left_name);
        this.eLf = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.eLg = (TextView) findViewById(R.id.card_competition_right_name);
        this.eLh = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKX.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.eKX.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eKW.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.eKW.setLayoutParams(layoutParams2);
        this.eKX.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eKX.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.eKZ.setDrawBorder(true);
        this.eKZ.setDrawerType(1);
        this.eKZ.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.eKZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eKZ.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eKZ.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eLd.setDefaultResource(17170445);
        this.eLd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eLd.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eLd.setIsRound(true);
        this.eLd.setDrawBorder(true);
        this.eLd.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eLd.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eLf.setDefaultResource(17170445);
        this.eLf.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eLf.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eLf.setIsRound(true);
        this.eLf.setDrawBorder(true);
        this.eLf.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eLf.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").O("obj_locate", 7).bS("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.amQ().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.eKZ.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.eKX.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.eLa.setText(featureCardCompetitionSubNode.title);
        this.eLd.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.eLe.setText(featureCardCompetitionSubNode.team1_name);
        this.eLf.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.eLg.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eLa, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.eLc, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.eLe, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.eLg, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.eLh, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

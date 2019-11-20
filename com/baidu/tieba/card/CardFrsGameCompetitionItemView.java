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
    private RelativeLayout eKf;
    private TbImageView eKg;
    private LinearLayout eKh;
    private ClickableHeaderImageView eKi;
    private TextView eKj;
    private RelativeLayout eKk;
    private TextView eKl;
    private ClickableHeaderImageView eKm;
    private TextView eKn;
    private ClickableHeaderImageView eKo;
    private TextView eKp;
    private TextView eKq;
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
        this.eKf = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.eKg = (TbImageView) findViewById(R.id.card_competition_bg);
        this.eKh = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.eKi = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.eKj = (TextView) findViewById(R.id.card_competition_title);
        this.eKk = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.eKl = (TextView) findViewById(R.id.card_competition_vs);
        this.eKm = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.eKn = (TextView) findViewById(R.id.card_competition_left_name);
        this.eKo = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.eKp = (TextView) findViewById(R.id.card_competition_right_name);
        this.eKq = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKg.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.eKg.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eKf.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.eKf.setLayoutParams(layoutParams2);
        this.eKg.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eKg.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.eKi.setDrawBorder(true);
        this.eKi.setDrawerType(1);
        this.eKi.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.eKi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eKi.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eKi.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eKm.setDefaultResource(17170445);
        this.eKm.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eKm.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eKm.setIsRound(true);
        this.eKm.setDrawBorder(true);
        this.eKm.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eKm.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eKo.setDefaultResource(17170445);
        this.eKo.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eKo.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eKo.setIsRound(true);
        this.eKo.setDrawBorder(true);
        this.eKo.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eKo.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").O("obj_locate", 7).bS("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.amO().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.eKi.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.eKg.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.eKj.setText(featureCardCompetitionSubNode.title);
        this.eKm.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.eKn.setText(featureCardCompetitionSubNode.team1_name);
        this.eKo.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.eKp.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eKj, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.eKl, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.eKn, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.eKp, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.eKq, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

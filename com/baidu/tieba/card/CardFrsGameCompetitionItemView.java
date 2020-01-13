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
/* loaded from: classes7.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout fFn;
    private TbImageView fFo;
    private LinearLayout fFp;
    private ClickableHeaderImageView fFq;
    private TextView fFr;
    private RelativeLayout fFs;
    private TextView fFt;
    private ClickableHeaderImageView fFu;
    private TextView fFv;
    private ClickableHeaderImageView fFw;
    private TextView fFx;
    private TextView fFy;
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
        this.fFn = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.fFo = (TbImageView) findViewById(R.id.card_competition_bg);
        this.fFp = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.fFq = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.fFr = (TextView) findViewById(R.id.card_competition_title);
        this.fFs = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.fFt = (TextView) findViewById(R.id.card_competition_vs);
        this.fFu = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.fFv = (TextView) findViewById(R.id.card_competition_left_name);
        this.fFw = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.fFx = (TextView) findViewById(R.id.card_competition_right_name);
        this.fFy = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fFo.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.fFo.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fFn.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.fFn.setLayoutParams(layoutParams2);
        this.fFo.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fFo.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fFq.setDrawBorder(true);
        this.fFq.setDrawerType(1);
        this.fFq.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.fFq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fFq.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fFq.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fFu.setDefaultResource(17170445);
        this.fFu.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fFu.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fFu.setIsRound(true);
        this.fFu.setDrawBorder(true);
        this.fFu.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fFu.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fFw.setDefaultResource(17170445);
        this.fFw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fFw.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fFw.setIsRound(true);
        this.fFw.setDrawBorder(true);
        this.fFw.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fFw.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").Z("obj_locate", 7).cp("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aEt().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.fFq.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.fFo.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.fFr.setText(featureCardCompetitionSubNode.title);
        this.fFu.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.fFv.setText(featureCardCompetitionSubNode.team1_name);
        this.fFw.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.fFx.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fFr, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fFt, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fFv, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fFx, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fFy, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

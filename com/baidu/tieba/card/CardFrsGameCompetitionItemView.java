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
    private ClickableHeaderImageView gnA;
    private TextView gnB;
    private ClickableHeaderImageView gnC;
    private TextView gnD;
    private TextView gnE;
    private RelativeLayout gnt;
    private TbImageView gnu;
    private LinearLayout gnv;
    private ClickableHeaderImageView gnw;
    private TextView gnx;
    private RelativeLayout gny;
    private TextView gnz;
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
        this.gnt = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.gnu = (TbImageView) findViewById(R.id.card_competition_bg);
        this.gnv = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.gnw = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.gnx = (TextView) findViewById(R.id.card_competition_title);
        this.gny = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.gnz = (TextView) findViewById(R.id.card_competition_vs);
        this.gnA = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.gnB = (TextView) findViewById(R.id.card_competition_left_name);
        this.gnC = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.gnD = (TextView) findViewById(R.id.card_competition_right_name);
        this.gnE = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnu.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.gnu.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gnt.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.gnt.setLayoutParams(layoutParams2);
        this.gnu.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gnu.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gnw.setDrawBorder(true);
        this.gnw.setDrawerType(1);
        this.gnw.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.gnw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gnw.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gnw.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gnA.setDefaultResource(17170445);
        this.gnA.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gnA.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gnA.setIsRound(true);
        this.gnA.setDrawBorder(true);
        this.gnA.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gnA.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gnC.setDefaultResource(17170445);
        this.gnC.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gnC.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gnC.setIsRound(true);
        this.gnC.setDrawBorder(true);
        this.gnC.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gnC.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").af("obj_locate", 7).cI("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aOV().a((TbPageContext) com.baidu.adp.base.i.G(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.gnw.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.gnu.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.gnx.setText(featureCardCompetitionSubNode.title);
        this.gnA.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.gnB.setText(featureCardCompetitionSubNode.team1_name);
        this.gnC.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.gnD.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gnx, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gnz, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gnB, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gnD, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gnE, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

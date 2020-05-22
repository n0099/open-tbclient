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
    private RelativeLayout gCn;
    private TbImageView gCo;
    private LinearLayout gCp;
    private ClickableHeaderImageView gCq;
    private TextView gCr;
    private RelativeLayout gCs;
    private TextView gCt;
    private ClickableHeaderImageView gCu;
    private TextView gCv;
    private ClickableHeaderImageView gCw;
    private TextView gCx;
    private TextView gCy;
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
        this.gCn = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.gCo = (TbImageView) findViewById(R.id.card_competition_bg);
        this.gCp = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.gCq = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.gCr = (TextView) findViewById(R.id.card_competition_title);
        this.gCs = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.gCt = (TextView) findViewById(R.id.card_competition_vs);
        this.gCu = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.gCv = (TextView) findViewById(R.id.card_competition_left_name);
        this.gCw = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.gCx = (TextView) findViewById(R.id.card_competition_right_name);
        this.gCy = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gCo.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.gCo.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gCn.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.gCn.setLayoutParams(layoutParams2);
        this.gCo.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gCo.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gCq.setDrawBorder(true);
        this.gCq.setDrawerType(1);
        this.gCq.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.gCq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gCq.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCq.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gCu.setDefaultResource(17170445);
        this.gCu.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gCu.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gCu.setIsRound(true);
        this.gCu.setDrawBorder(true);
        this.gCu.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCu.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gCw.setDefaultResource(17170445);
        this.gCw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gCw.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gCw.setIsRound(true);
        this.gCw.setDrawBorder(true);
        this.gCw.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCw.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").ag("obj_locate", 7).dh("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aUZ().a((TbPageContext) com.baidu.adp.base.i.G(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.gCq.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.gCo.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.gCr.setText(featureCardCompetitionSubNode.title);
        this.gCu.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.gCv.setText(featureCardCompetitionSubNode.team1_name);
        this.gCw.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.gCx.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gCr, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gCt, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gCv, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gCx, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gCy, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

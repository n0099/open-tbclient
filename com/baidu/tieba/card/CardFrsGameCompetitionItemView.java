package com.baidu.tieba.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes2.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout iwV;
    private TbImageView iwW;
    private LinearLayout iwX;
    private ClickableHeaderImageView iwY;
    private TextView iwZ;
    private RelativeLayout ixa;
    private TextView ixb;
    private ClickableHeaderImageView ixc;
    private TextView ixd;
    private ClickableHeaderImageView ixe;
    private TextView ixf;
    private TextView ixg;
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
        this.iwV = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.iwW = (TbImageView) findViewById(R.id.card_competition_bg);
        this.iwX = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.iwY = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.iwZ = (TextView) findViewById(R.id.card_competition_title);
        this.ixa = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.ixb = (TextView) findViewById(R.id.card_competition_vs);
        this.ixc = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.ixd = (TextView) findViewById(R.id.card_competition_left_name);
        this.ixe = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.ixf = (TextView) findViewById(R.id.card_competition_right_name);
        this.ixg = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iwW.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.iwW.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iwV.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.iwV.setLayoutParams(layoutParams2);
        this.iwW.setDefaultBgResource(R.drawable.icon_morenpic);
        this.iwY.setDrawBorder(true);
        this.iwY.setDrawerType(1);
        this.iwY.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.iwY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iwY.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iwY.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ixc.setDefaultResource(17170445);
        this.ixc.setDefaultBgResource(R.color.CAM_X0205);
        this.ixc.setIsRound(true);
        this.ixc.setDrawBorder(true);
        this.ixc.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ixc.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ixe.setDefaultResource(17170445);
        this.ixe.setDefaultBgResource(R.color.CAM_X0205);
        this.ixe.setIsRound(true);
        this.ixe.setDrawBorder(true);
        this.ixe.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ixe.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ar("c13047").aq("obj_locate", 7).dR("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    bf.bsY().a((TbPageContext) com.baidu.adp.base.j.J(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.iwY.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.iwW.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.iwZ.setText(featureCardCompetitionSubNode.title);
        this.ixc.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.ixd.setText(featureCardCompetitionSubNode.team1_name);
        this.ixe.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.ixf.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.iwZ, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ixb, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ixd, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ixf, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ixg, R.color.CAM_X0101, 1);
        }
        this.mSkinType = i;
    }
}

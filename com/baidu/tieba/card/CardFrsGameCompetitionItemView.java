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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes2.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private TextView ipA;
    private ClickableHeaderImageView ipB;
    private TextView ipC;
    private ClickableHeaderImageView ipD;
    private TextView ipE;
    private TextView ipF;
    private RelativeLayout ipu;
    private TbImageView ipv;
    private LinearLayout ipw;
    private ClickableHeaderImageView ipx;
    private TextView ipy;
    private RelativeLayout ipz;
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
        this.ipu = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.ipv = (TbImageView) findViewById(R.id.card_competition_bg);
        this.ipw = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.ipx = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.ipy = (TextView) findViewById(R.id.card_competition_title);
        this.ipz = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.ipA = (TextView) findViewById(R.id.card_competition_vs);
        this.ipB = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.ipC = (TextView) findViewById(R.id.card_competition_left_name);
        this.ipD = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.ipE = (TextView) findViewById(R.id.card_competition_right_name);
        this.ipF = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ipv.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.ipv.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ipu.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.ipu.setLayoutParams(layoutParams2);
        this.ipv.setDefaultBgResource(R.drawable.icon_morenpic);
        this.ipx.setDrawBorder(true);
        this.ipx.setDrawerType(1);
        this.ipx.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.ipx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ipx.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.ipx.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ipB.setDefaultResource(17170445);
        this.ipB.setDefaultBgResource(R.color.CAM_X0205);
        this.ipB.setIsRound(true);
        this.ipB.setDrawBorder(true);
        this.ipB.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.ipB.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ipD.setDefaultResource(17170445);
        this.ipD.setDefaultBgResource(R.color.CAM_X0205);
        this.ipD.setIsRound(true);
        this.ipD.setDrawBorder(true);
        this.ipD.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.ipD.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").an("obj_locate", 7).dW("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    be.bsB().a((TbPageContext) com.baidu.adp.base.j.K(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.ipx.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.ipv.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.ipy.setText(featureCardCompetitionSubNode.title);
        this.ipB.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.ipC.setText(featureCardCompetitionSubNode.team1_name);
        this.ipD.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.ipE.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.ipy, R.color.CAM_X0101, 1);
            ao.setViewTextColor(this.ipA, R.color.CAM_X0101, 1);
            ao.setViewTextColor(this.ipC, R.color.CAM_X0101, 1);
            ao.setViewTextColor(this.ipE, R.color.CAM_X0101, 1);
            ao.setViewTextColor(this.ipF, R.color.CAM_X0101, 1);
        }
        this.mSkinType = i;
    }
}

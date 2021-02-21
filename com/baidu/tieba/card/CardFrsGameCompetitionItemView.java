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
    private RelativeLayout ivm;
    private TbImageView ivn;
    private LinearLayout ivo;
    private ClickableHeaderImageView ivp;
    private TextView ivq;
    private RelativeLayout ivr;
    private TextView ivs;
    private ClickableHeaderImageView ivt;
    private TextView ivu;
    private ClickableHeaderImageView ivv;
    private TextView ivw;
    private TextView ivx;
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
        this.ivm = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.ivn = (TbImageView) findViewById(R.id.card_competition_bg);
        this.ivo = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.ivp = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.ivq = (TextView) findViewById(R.id.card_competition_title);
        this.ivr = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.ivs = (TextView) findViewById(R.id.card_competition_vs);
        this.ivt = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.ivu = (TextView) findViewById(R.id.card_competition_left_name);
        this.ivv = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.ivw = (TextView) findViewById(R.id.card_competition_right_name);
        this.ivx = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivn.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.ivn.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ivm.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.ivm.setLayoutParams(layoutParams2);
        this.ivn.setDefaultBgResource(R.drawable.icon_morenpic);
        this.ivp.setDrawBorder(true);
        this.ivp.setDrawerType(1);
        this.ivp.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.ivp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ivp.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ivp.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ivt.setDefaultResource(17170445);
        this.ivt.setDefaultBgResource(R.color.CAM_X0205);
        this.ivt.setIsRound(true);
        this.ivt.setDrawBorder(true);
        this.ivt.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ivt.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ivv.setDefaultResource(17170445);
        this.ivv.setDefaultBgResource(R.color.CAM_X0205);
        this.ivv.setIsRound(true);
        this.ivv.setDrawBorder(true);
        this.ivv.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ivv.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new ar("c13047").ap("obj_locate", 7).dR("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    bf.bsV().a((TbPageContext) com.baidu.adp.base.j.K(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.ivp.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.ivn.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.ivq.setText(featureCardCompetitionSubNode.title);
        this.ivt.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.ivu.setText(featureCardCompetitionSubNode.team1_name);
        this.ivv.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.ivw.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ivq, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ivs, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ivu, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ivw, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ivx, R.color.CAM_X0101, 1);
        }
        this.mSkinType = i;
    }
}

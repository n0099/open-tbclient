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
    private RelativeLayout iuY;
    private TbImageView iuZ;
    private LinearLayout iva;
    private ClickableHeaderImageView ivb;
    private TextView ivc;
    private RelativeLayout ivd;
    private TextView ive;
    private ClickableHeaderImageView ivf;
    private TextView ivg;
    private ClickableHeaderImageView ivh;
    private TextView ivi;
    private TextView ivj;
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
        this.iuY = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.iuZ = (TbImageView) findViewById(R.id.card_competition_bg);
        this.iva = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.ivb = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.ivc = (TextView) findViewById(R.id.card_competition_title);
        this.ivd = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.ive = (TextView) findViewById(R.id.card_competition_vs);
        this.ivf = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.ivg = (TextView) findViewById(R.id.card_competition_left_name);
        this.ivh = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.ivi = (TextView) findViewById(R.id.card_competition_right_name);
        this.ivj = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iuZ.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.iuZ.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iuY.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.iuY.setLayoutParams(layoutParams2);
        this.iuZ.setDefaultBgResource(R.drawable.icon_morenpic);
        this.ivb.setDrawBorder(true);
        this.ivb.setDrawerType(1);
        this.ivb.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.ivb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ivb.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ivb.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ivf.setDefaultResource(17170445);
        this.ivf.setDefaultBgResource(R.color.CAM_X0205);
        this.ivf.setIsRound(true);
        this.ivf.setDrawBorder(true);
        this.ivf.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ivf.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ivh.setDefaultResource(17170445);
        this.ivh.setDefaultBgResource(R.color.CAM_X0205);
        this.ivh.setIsRound(true);
        this.ivh.setDrawBorder(true);
        this.ivh.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ivh.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
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
        this.ivb.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.iuZ.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.ivc.setText(featureCardCompetitionSubNode.title);
        this.ivf.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.ivg.setText(featureCardCompetitionSubNode.team1_name);
        this.ivh.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.ivi.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ivc, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ive, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ivg, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ivi, R.color.CAM_X0101, 1);
            ap.setViewTextColor(this.ivj, R.color.CAM_X0101, 1);
        }
        this.mSkinType = i;
    }
}

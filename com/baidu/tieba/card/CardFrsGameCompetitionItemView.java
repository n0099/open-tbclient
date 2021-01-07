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
    private RelativeLayout iub;
    private TbImageView iuc;
    private LinearLayout iud;
    private ClickableHeaderImageView iue;
    private TextView iuf;
    private RelativeLayout iug;
    private TextView iuh;
    private ClickableHeaderImageView iui;
    private TextView iuj;
    private ClickableHeaderImageView iuk;
    private TextView iul;
    private TextView ium;
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
        this.iub = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.iuc = (TbImageView) findViewById(R.id.card_competition_bg);
        this.iud = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.iue = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.iuf = (TextView) findViewById(R.id.card_competition_title);
        this.iug = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.iuh = (TextView) findViewById(R.id.card_competition_vs);
        this.iui = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.iuj = (TextView) findViewById(R.id.card_competition_left_name);
        this.iuk = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.iul = (TextView) findViewById(R.id.card_competition_right_name);
        this.ium = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iuc.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.iuc.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iub.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.iub.setLayoutParams(layoutParams2);
        this.iuc.setDefaultBgResource(R.drawable.icon_morenpic);
        this.iue.setDrawBorder(true);
        this.iue.setDrawerType(1);
        this.iue.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.iue.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iue.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.iue.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iui.setDefaultResource(17170445);
        this.iui.setDefaultBgResource(R.color.CAM_X0205);
        this.iui.setIsRound(true);
        this.iui.setDrawBorder(true);
        this.iui.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.iui.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iuk.setDefaultResource(17170445);
        this.iuk.setDefaultBgResource(R.color.CAM_X0205);
        this.iuk.setIsRound(true);
        this.iuk.setDrawBorder(true);
        this.iuk.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.iuk.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new aq("c13047").an("obj_locate", 7).dX("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    be.bwv().a((TbPageContext) com.baidu.adp.base.j.K(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.iue.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.iuc.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.iuf.setText(featureCardCompetitionSubNode.title);
        this.iui.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.iuj.setText(featureCardCompetitionSubNode.team1_name);
        this.iuk.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.iul.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.iuf, R.color.CAM_X0101, 1);
            ao.setViewTextColor(this.iuh, R.color.CAM_X0101, 1);
            ao.setViewTextColor(this.iuj, R.color.CAM_X0101, 1);
            ao.setViewTextColor(this.iul, R.color.CAM_X0101, 1);
            ao.setViewTextColor(this.ium, R.color.CAM_X0101, 1);
        }
        this.mSkinType = i;
    }
}

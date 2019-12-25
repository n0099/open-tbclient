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
/* loaded from: classes6.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout fCc;
    private TbImageView fCd;
    private LinearLayout fCe;
    private ClickableHeaderImageView fCf;
    private TextView fCg;
    private RelativeLayout fCh;
    private TextView fCi;
    private ClickableHeaderImageView fCj;
    private TextView fCk;
    private ClickableHeaderImageView fCl;
    private TextView fCm;
    private TextView fCn;
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
        this.fCc = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.fCd = (TbImageView) findViewById(R.id.card_competition_bg);
        this.fCe = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.fCf = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.fCg = (TextView) findViewById(R.id.card_competition_title);
        this.fCh = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.fCi = (TextView) findViewById(R.id.card_competition_vs);
        this.fCj = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.fCk = (TextView) findViewById(R.id.card_competition_left_name);
        this.fCl = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.fCm = (TextView) findViewById(R.id.card_competition_right_name);
        this.fCn = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fCd.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.fCd.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fCc.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.fCc.setLayoutParams(layoutParams2);
        this.fCd.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fCd.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fCf.setDrawBorder(true);
        this.fCf.setDrawerType(1);
        this.fCf.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.fCf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fCf.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fCf.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fCj.setDefaultResource(17170445);
        this.fCj.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fCj.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fCj.setIsRound(true);
        this.fCj.setDrawBorder(true);
        this.fCj.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fCj.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fCl.setDefaultResource(17170445);
        this.fCl.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fCl.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fCl.setIsRound(true);
        this.fCl.setDrawBorder(true);
        this.fCl.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fCl.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").Z("obj_locate", 7).cp("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aEa().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.fCf.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.fCd.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.fCg.setText(featureCardCompetitionSubNode.title);
        this.fCj.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.fCk.setText(featureCardCompetitionSubNode.team1_name);
        this.fCl.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.fCm.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fCg, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fCi, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fCk, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fCm, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.fCn, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

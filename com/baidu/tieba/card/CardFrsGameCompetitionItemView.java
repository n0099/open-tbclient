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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes3.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout cnG;
    private TbImageView cnH;
    private LinearLayout cnI;
    private ClickableHeaderImageView cnJ;
    private TextView cnK;
    private RelativeLayout cnL;
    private TextView cnM;
    private ClickableHeaderImageView cnN;
    private TextView cnO;
    private ClickableHeaderImageView cnP;
    private TextView cnQ;
    private TextView cnR;
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
        LayoutInflater.from(context).inflate(d.i.card_frs_game_competition_view_item, (ViewGroup) this, true);
        this.cnG = (RelativeLayout) findViewById(d.g.card_competition_layout);
        this.cnH = (TbImageView) findViewById(d.g.card_competition_bg);
        this.cnI = (LinearLayout) findViewById(d.g.card_competition_title_layout);
        this.cnJ = (ClickableHeaderImageView) findViewById(d.g.card_competition_title_header);
        this.cnK = (TextView) findViewById(d.g.card_competition_title);
        this.cnL = (RelativeLayout) findViewById(d.g.card_competition_content_layout);
        this.cnM = (TextView) findViewById(d.g.card_competition_vs);
        this.cnN = (ClickableHeaderImageView) findViewById(d.g.card_competition_left_img);
        this.cnO = (TextView) findViewById(d.g.card_competition_left_name);
        this.cnP = (ClickableHeaderImageView) findViewById(d.g.card_competition_right_img);
        this.cnQ = (TextView) findViewById(d.g.card_competition_right_name);
        this.cnR = (TextView) findViewById(d.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cnH.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cnH.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cnG.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cnG.setLayoutParams(layoutParams2);
        this.cnH.setDefaultBgResource(d.f.icon_morenpic);
        this.cnH.setDefaultErrorResource(d.f.icon_morenpic);
        this.cnJ.setDrawBorder(true);
        this.cnJ.setDrawerType(1);
        this.cnJ.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds5));
        this.cnJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cnJ.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cnJ.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cnN.setDefaultResource(17170445);
        this.cnN.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cnN.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cnN.setIsRound(true);
        this.cnN.setDrawBorder(true);
        this.cnN.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cnN.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cnP.setDefaultResource(17170445);
        this.cnP.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cnP.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cnP.setIsRound(true);
        this.cnP.setDrawBorder(true);
        this.cnP.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cnP.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getTag() instanceof String) {
                    TiebaStatic.log(new al("c13047").r("obj_locate", 7).ac(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ax.wf().a((TbPageContext) com.baidu.adp.base.i.ab(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view2.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cnJ.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cnH.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cnK.setText(featureCardCompetitionSubNode.title);
        this.cnN.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cnO.setText(featureCardCompetitionSubNode.team1_name);
        this.cnP.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cnQ.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.c(this.cnK, d.C0126d.cp_cont_i, 1);
            ak.c(this.cnM, d.C0126d.cp_cont_i, 1);
            ak.c(this.cnO, d.C0126d.cp_cont_i, 1);
            ak.c(this.cnQ, d.C0126d.cp_cont_i, 1);
            ak.c(this.cnR, d.C0126d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

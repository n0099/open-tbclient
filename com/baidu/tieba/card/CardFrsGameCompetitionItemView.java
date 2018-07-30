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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
/* loaded from: classes3.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {
    private RelativeLayout cwT;
    private TbImageView cwU;
    private LinearLayout cwV;
    private ClickableHeaderImageView cwW;
    private TextView cwX;
    private RelativeLayout cwY;
    private TextView cwZ;
    private ClickableHeaderImageView cxa;
    private TextView cxb;
    private ClickableHeaderImageView cxc;
    private TextView cxd;
    private TextView cxe;
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
        LayoutInflater.from(context).inflate(d.h.card_frs_game_competition_view_item, (ViewGroup) this, true);
        this.cwT = (RelativeLayout) findViewById(d.g.card_competition_layout);
        this.cwU = (TbImageView) findViewById(d.g.card_competition_bg);
        this.cwV = (LinearLayout) findViewById(d.g.card_competition_title_layout);
        this.cwW = (ClickableHeaderImageView) findViewById(d.g.card_competition_title_header);
        this.cwX = (TextView) findViewById(d.g.card_competition_title);
        this.cwY = (RelativeLayout) findViewById(d.g.card_competition_content_layout);
        this.cwZ = (TextView) findViewById(d.g.card_competition_vs);
        this.cxa = (ClickableHeaderImageView) findViewById(d.g.card_competition_left_img);
        this.cxb = (TextView) findViewById(d.g.card_competition_left_name);
        this.cxc = (ClickableHeaderImageView) findViewById(d.g.card_competition_right_img);
        this.cxd = (TextView) findViewById(d.g.card_competition_right_name);
        this.cxe = (TextView) findViewById(d.g.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cwU.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.cwU.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cwT.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.cwT.setLayoutParams(layoutParams2);
        this.cwU.setDefaultBgResource(d.f.icon_morenpic);
        this.cwU.setDefaultErrorResource(d.f.icon_morenpic);
        this.cwW.setDrawBorder(true);
        this.cwW.setDrawerType(1);
        this.cwW.setRadius(context.getResources().getDimensionPixelSize(d.e.tbds5));
        this.cwW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cwW.setBorderColor(am.getColor(d.C0140d.common_color_10043));
        this.cwW.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cxa.setDefaultResource(17170445);
        this.cxa.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cxa.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.cxa.setIsRound(true);
        this.cxa.setDrawBorder(true);
        this.cxa.setBorderColor(am.getColor(d.C0140d.common_color_10043));
        this.cxa.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cxc.setDefaultResource(17170445);
        this.cxc.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cxc.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.cxc.setIsRound(true);
        this.cxc.setDrawBorder(true);
        this.cxc.setBorderColor(am.getColor(d.C0140d.common_color_10043));
        this.cxc.setBorderWidth(context.getResources().getDimensionPixelSize(d.e.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").r("obj_locate", 7).af(ImageViewerConfig.FORUM_ID, CardFrsGameCompetitionItemView.this.mForumId));
                    ay.zK().a((TbPageContext) com.baidu.adp.base.i.ad(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.cwW.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.cwU.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.cwX.setText(featureCardCompetitionSubNode.title);
        this.cxa.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.cxb.setText(featureCardCompetitionSubNode.team1_name);
        this.cxc.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.cxd.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.c(this.cwX, d.C0140d.cp_cont_i, 1);
            am.c(this.cwZ, d.C0140d.cp_cont_i, 1);
            am.c(this.cxb, d.C0140d.cp_cont_i, 1);
            am.c(this.cxd, d.C0140d.cp_cont_i, 1);
            am.c(this.cxe, d.C0140d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }
}

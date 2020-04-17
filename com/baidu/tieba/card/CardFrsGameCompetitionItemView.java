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
    private RelativeLayout gnn;
    private TbImageView gno;
    private LinearLayout gnp;
    private ClickableHeaderImageView gnq;
    private TextView gnr;
    private RelativeLayout gns;
    private TextView gnt;
    private ClickableHeaderImageView gnu;
    private TextView gnv;
    private ClickableHeaderImageView gnw;
    private TextView gnx;
    private TextView gny;
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
        this.gnn = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.gno = (TbImageView) findViewById(R.id.card_competition_bg);
        this.gnp = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.gnq = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.gnr = (TextView) findViewById(R.id.card_competition_title);
        this.gns = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.gnt = (TextView) findViewById(R.id.card_competition_vs);
        this.gnu = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.gnv = (TextView) findViewById(R.id.card_competition_left_name);
        this.gnw = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.gnx = (TextView) findViewById(R.id.card_competition_right_name);
        this.gny = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gno.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.gno.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gnn.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.gnn.setLayoutParams(layoutParams2);
        this.gno.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gno.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gnq.setDrawBorder(true);
        this.gnq.setDrawerType(1);
        this.gnq.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.gnq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gnq.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gnq.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gnu.setDefaultResource(17170445);
        this.gnu.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gnu.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gnu.setIsRound(true);
        this.gnu.setDrawBorder(true);
        this.gnu.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gnu.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gnw.setDefaultResource(17170445);
        this.gnw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gnw.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gnw.setIsRound(true);
        this.gnw.setDrawBorder(true);
        this.gnw.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gnw.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.CardFrsGameCompetitionItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof String) {
                    TiebaStatic.log(new an("c13047").af("obj_locate", 7).cI("fid", CardFrsGameCompetitionItemView.this.mForumId));
                    ba.aOY().a((TbPageContext) com.baidu.adp.base.i.T(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
                }
            }
        });
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void a(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.gnq.startLoad(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.gno.startLoad(featureCardCompetitionSubNode.competition_image, 10, false);
        this.gnr.setText(featureCardCompetitionSubNode.title);
        this.gnu.startLoad(featureCardCompetitionSubNode.team1_image, 10, false);
        this.gnv.setText(featureCardCompetitionSubNode.team1_name);
        this.gnw.startLoad(featureCardCompetitionSubNode.team2_image, 10, false);
        this.gnx.setText(featureCardCompetitionSubNode.team2_name);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.gnr, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gnt, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gnv, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gnx, R.color.cp_cont_a, 1);
            am.setViewTextColor(this.gny, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }
}

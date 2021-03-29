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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
import d.b.b.a.j;
/* loaded from: classes4.dex */
public class CardFrsGameCompetitionItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f15228e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15229f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f15230g;

    /* renamed from: h  reason: collision with root package name */
    public ClickableHeaderImageView f15231h;
    public TextView i;
    public RelativeLayout j;
    public TextView k;
    public ClickableHeaderImageView l;
    public TextView m;
    public ClickableHeaderImageView n;
    public TextView o;
    public TextView p;
    public String q;
    public int r;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof String) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 7).param("fid", CardFrsGameCompetitionItemView.this.q));
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(CardFrsGameCompetitionItemView.this.getContext()), new String[]{(String) view.getTag()}, true);
            }
        }
    }

    public CardFrsGameCompetitionItemView(Context context) {
        super(context);
        this.r = 3;
        c(context);
    }

    public void b(FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        this.f15231h.W(featureCardCompetitionSubNode.competition_logo, 10, false);
        this.f15229f.W(featureCardCompetitionSubNode.competition_image, 10, false);
        this.i.setText(featureCardCompetitionSubNode.title);
        this.l.W(featureCardCompetitionSubNode.team1_image, 10, false);
        this.m.setText(featureCardCompetitionSubNode.team1_name);
        this.n.W(featureCardCompetitionSubNode.team2_image, 10, false);
        this.o.setText(featureCardCompetitionSubNode.team2_name);
    }

    public final void c(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_competition_view_item, (ViewGroup) this, true);
        this.f15228e = (RelativeLayout) findViewById(R.id.card_competition_layout);
        this.f15229f = (TbImageView) findViewById(R.id.card_competition_bg);
        this.f15230g = (LinearLayout) findViewById(R.id.card_competition_title_layout);
        this.f15231h = (ClickableHeaderImageView) findViewById(R.id.card_competition_title_header);
        this.i = (TextView) findViewById(R.id.card_competition_title);
        this.j = (RelativeLayout) findViewById(R.id.card_competition_content_layout);
        this.k = (TextView) findViewById(R.id.card_competition_vs);
        this.l = (ClickableHeaderImageView) findViewById(R.id.card_competition_left_img);
        this.m = (TextView) findViewById(R.id.card_competition_left_name);
        this.n = (ClickableHeaderImageView) findViewById(R.id.card_competition_right_img);
        this.o = (TextView) findViewById(R.id.card_competition_right_name);
        this.p = (TextView) findViewById(R.id.card_competition_btn_discuss);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tbds170) * 2;
        int i = (dimensionPixelSize * 21) / 9;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15229f.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = i;
        this.f15229f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f15228e.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = i;
        this.f15228e.setLayoutParams(layoutParams2);
        this.f15229f.setDefaultBgResource(R.drawable.icon_morenpic);
        this.f15231h.setDrawBorder(true);
        this.f15231h.setDrawerType(1);
        this.f15231h.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds5));
        this.f15231h.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f15231h.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.f15231h.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.l.setDefaultResource(17170445);
        this.l.setDefaultBgResource(R.color.CAM_X0205);
        this.l.setIsRound(true);
        this.l.setDrawBorder(true);
        this.l.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.l.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.n.setDefaultResource(17170445);
        this.n.setDefaultBgResource(R.color.CAM_X0205);
        this.n.setIsRound(true);
        this.n.setDrawBorder(true);
        this.n.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.n.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds1));
        setOnClickListener(new a());
    }

    public void d(int i) {
        if (this.r != i) {
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0101, 1);
        }
        this.r = i;
    }

    public void setForumId(String str) {
        this.q = str;
    }

    public CardFrsGameCompetitionItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = 3;
        c(context);
    }

    public CardFrsGameCompetitionItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = 3;
        c(context);
    }
}

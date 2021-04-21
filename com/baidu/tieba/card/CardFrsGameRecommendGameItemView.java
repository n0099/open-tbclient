package com.baidu.tieba.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class CardFrsGameRecommendGameItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f14909e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14910f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14911g;

    /* renamed from: h  reason: collision with root package name */
    public int f14912h;
    public String i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof String) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 10).param("fid", CardFrsGameRecommendGameItemView.this.i));
                d.b.i0.l.a.l(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
            }
        }
    }

    public CardFrsGameRecommendGameItemView(Context context) {
        super(context);
        this.f14912h = 3;
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.f14909e = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.f14909e.setDefaultResource(17170445);
        this.f14909e.setDefaultBgResource(R.color.CAM_X0205);
        this.f14909e.setDrawerType(1);
        this.f14909e.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.f14909e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f14909e.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.f14909e.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.f14910f = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.f14911g = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new a());
    }

    public void c(int i) {
        if (i == this.f14912h) {
            return;
        }
        this.f14912h = i;
        SkinManager.setViewTextColor(this.f14910f, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.f14911g, R.color.CAM_X0109, 1);
    }

    public TextView getGameDscView() {
        return this.f14911g;
    }

    public TextView getGameNameView() {
        return this.f14910f;
    }

    public TbImageView getGamePicView() {
        return this.f14909e;
    }

    public void setForumId(String str) {
        this.i = str;
    }

    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14912h = 3;
        b(context);
    }

    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14912h = 3;
        b(context);
    }
}

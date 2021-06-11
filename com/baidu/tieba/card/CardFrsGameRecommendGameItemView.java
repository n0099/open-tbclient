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
    public TbImageView f14289e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14290f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14291g;

    /* renamed from: h  reason: collision with root package name */
    public int f14292h;

    /* renamed from: i  reason: collision with root package name */
    public String f14293i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof String) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 10).param("fid", CardFrsGameRecommendGameItemView.this.f14293i));
                d.a.m0.l.a.l(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
            }
        }
    }

    public CardFrsGameRecommendGameItemView(Context context) {
        super(context);
        this.f14292h = 3;
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.f14289e = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.f14289e.setDefaultResource(17170445);
        this.f14289e.setDefaultBgResource(R.color.CAM_X0205);
        this.f14289e.setDrawerType(1);
        this.f14289e.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.f14289e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f14289e.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.f14289e.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.f14290f = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.f14291g = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new a());
    }

    public void c(int i2) {
        if (i2 == this.f14292h) {
            return;
        }
        this.f14292h = i2;
        SkinManager.setViewTextColor(this.f14290f, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.f14291g, R.color.CAM_X0109, 1);
    }

    public TextView getGameDscView() {
        return this.f14291g;
    }

    public TextView getGameNameView() {
        return this.f14290f;
    }

    public TbImageView getGamePicView() {
        return this.f14289e;
    }

    public void setForumId(String str) {
        this.f14293i = str;
    }

    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14292h = 3;
        b(context);
    }

    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14292h = 3;
        b(context);
    }
}

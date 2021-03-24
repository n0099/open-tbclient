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
    public TbImageView f15237e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15238f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15239g;

    /* renamed from: h  reason: collision with root package name */
    public int f15240h;
    public String i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof String) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 10).param("fid", CardFrsGameRecommendGameItemView.this.i));
                d.b.h0.l.a.l(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
            }
        }
    }

    public CardFrsGameRecommendGameItemView(Context context) {
        super(context);
        this.f15240h = 3;
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.f15237e = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.f15237e.setDefaultResource(17170445);
        this.f15237e.setDefaultBgResource(R.color.CAM_X0205);
        this.f15237e.setDrawerType(1);
        this.f15237e.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.f15237e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f15237e.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.f15237e.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.f15238f = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.f15239g = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new a());
    }

    public void c(int i) {
        if (i == this.f15240h) {
            return;
        }
        this.f15240h = i;
        SkinManager.setViewTextColor(this.f15238f, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.f15239g, R.color.CAM_X0109, 1);
    }

    public TextView getGameDscView() {
        return this.f15239g;
    }

    public TextView getGameNameView() {
        return this.f15238f;
    }

    public TbImageView getGamePicView() {
        return this.f15237e;
    }

    public void setForumId(String str) {
        this.i = str;
    }

    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15240h = 3;
        b(context);
    }

    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15240h = 3;
        b(context);
    }
}

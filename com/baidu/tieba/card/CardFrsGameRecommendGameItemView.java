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
    public TbImageView f14329e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14330f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14331g;

    /* renamed from: h  reason: collision with root package name */
    public int f14332h;

    /* renamed from: i  reason: collision with root package name */
    public String f14333i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof String) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 10).param("fid", CardFrsGameRecommendGameItemView.this.f14333i));
                d.a.j0.l.a.l(CardFrsGameRecommendGameItemView.this.getContext(), (String) view.getTag());
            }
        }
    }

    public CardFrsGameRecommendGameItemView(Context context) {
        super(context);
        this.f14332h = 3;
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_frs_game_recommend_game_view_item, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.card_frs_game_recommend_game_pic);
        this.f14329e = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.f14329e.setDefaultResource(17170445);
        this.f14329e.setDefaultBgResource(R.color.CAM_X0205);
        this.f14329e.setDrawerType(1);
        this.f14329e.setRadius(context.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.f14329e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f14329e.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.f14329e.setBorderWidth(context.getResources().getDimensionPixelSize(R.dimen.tbds2));
        this.f14330f = (TextView) findViewById(R.id.card_frs_game_recommend_game_name);
        this.f14331g = (TextView) findViewById(R.id.card_frs_game_recommend_game_dec);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new a());
    }

    public void c(int i2) {
        if (i2 == this.f14332h) {
            return;
        }
        this.f14332h = i2;
        SkinManager.setViewTextColor(this.f14330f, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.f14331g, R.color.CAM_X0109, 1);
    }

    public TextView getGameDscView() {
        return this.f14331g;
    }

    public TextView getGameNameView() {
        return this.f14330f;
    }

    public TbImageView getGamePicView() {
        return this.f14329e;
    }

    public void setForumId(String str) {
        this.f14333i = str;
    }

    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14332h = 3;
        b(context);
    }

    public CardFrsGameRecommendGameItemView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14332h = 3;
        b(context);
    }
}

package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CardUserLikeButton;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class UserRecommendItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ClickableHeaderImageView f16793e;

    /* renamed from: f  reason: collision with root package name */
    public CardUserLikeButton f16794f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16795g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16796h;
    public boolean i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserRecommendItemView.this.f16793e.onClick(UserRecommendItemView.this.f16793e);
        }
    }

    public UserRecommendItemView(Context context) {
        super(context);
        this.i = false;
        this.j = -1;
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_user_recommend_item, (ViewGroup) this, true);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.f16793e = clickableHeaderImageView;
        clickableHeaderImageView.setAutoChangeStyle(true);
        this.f16793e.setDefaultResource(17170445);
        this.f16793e.setIsRound(true);
        this.f16793e.setScaleType(ImageView.ScaleType.FIT_XY);
        CardUserLikeButton cardUserLikeButton = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.f16794f = cardUserLikeButton;
        cardUserLikeButton.setGravity(17);
        this.f16795g = (TextView) findViewById(R.id.user_recommend_username);
        this.f16796h = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new a());
    }

    public void c(int i) {
        if (i == this.j) {
            return;
        }
        this.j = i;
        this.f16796h.setTextColor(SkinManager.getColor(i, R.color.CAM_X0109));
        if (this.i) {
            this.f16795g.setTextColor(SkinManager.getColor(i, R.color.cp_cont_r));
        } else {
            this.f16795g.setTextColor(SkinManager.getColor(i, R.color.CAM_X0105));
        }
        setBackgroundColor(SkinManager.getColor(i, R.color.CAM_X0201));
        this.f16794f.g(i);
        this.f16793e.setPlaceHolder(1);
    }

    public TextView getFansNum() {
        return this.f16796h;
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.f16793e;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.f16794f;
    }

    public TextView getUsername() {
        return this.f16795g;
    }

    public void setIsGod(boolean z) {
        if (this.i == z) {
            return;
        }
        this.i = z;
        if (z) {
            this.f16795g.setTextColor(SkinManager.getColor(this.j, R.color.cp_cont_r));
        } else {
            this.f16795g.setTextColor(SkinManager.getColor(this.j, R.color.CAM_X0105));
        }
    }

    public UserRecommendItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = false;
        this.j = -1;
        b(context);
    }
}

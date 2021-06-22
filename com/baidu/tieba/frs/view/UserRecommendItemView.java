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
    public ClickableHeaderImageView f16063e;

    /* renamed from: f  reason: collision with root package name */
    public CardUserLikeButton f16064f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16065g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16066h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16067i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserRecommendItemView.this.f16063e.onClick(UserRecommendItemView.this.f16063e);
        }
    }

    public UserRecommendItemView(Context context) {
        super(context);
        this.f16067i = false;
        this.j = -1;
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_user_recommend_item, (ViewGroup) this, true);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.f16063e = clickableHeaderImageView;
        clickableHeaderImageView.setAutoChangeStyle(true);
        this.f16063e.setDefaultResource(17170445);
        this.f16063e.setIsRound(true);
        this.f16063e.setScaleType(ImageView.ScaleType.FIT_XY);
        CardUserLikeButton cardUserLikeButton = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.f16064f = cardUserLikeButton;
        cardUserLikeButton.setGravity(17);
        this.f16065g = (TextView) findViewById(R.id.user_recommend_username);
        this.f16066h = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new a());
    }

    public void c(int i2) {
        if (i2 == this.j) {
            return;
        }
        this.j = i2;
        this.f16066h.setTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
        if (this.f16067i) {
            this.f16065g.setTextColor(SkinManager.getColor(i2, R.color.cp_cont_r));
        } else {
            this.f16065g.setTextColor(SkinManager.getColor(i2, R.color.CAM_X0105));
        }
        setBackgroundColor(SkinManager.getColor(i2, R.color.CAM_X0201));
        this.f16064f.g(i2);
        this.f16063e.setPlaceHolder(1);
    }

    public TextView getFansNum() {
        return this.f16066h;
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.f16063e;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.f16064f;
    }

    public TextView getUsername() {
        return this.f16065g;
    }

    public void setIsGod(boolean z) {
        if (this.f16067i == z) {
            return;
        }
        this.f16067i = z;
        if (z) {
            this.f16065g.setTextColor(SkinManager.getColor(this.j, R.color.cp_cont_r));
        } else {
            this.f16065g.setTextColor(SkinManager.getColor(this.j, R.color.CAM_X0105));
        }
    }

    public UserRecommendItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16067i = false;
        this.j = -1;
        b(context);
    }
}

package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CardUserLikeButton;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView Zy;
    private TextView fAA;
    private ClickableHeaderImageView fAy;
    private CardUserLikeButton fAz;
    private boolean isGod;
    private int mSkinType;

    public UserRecommendItemView(Context context) {
        super(context);
        this.isGod = false;
        this.mSkinType = -1;
        init(context);
    }

    public UserRecommendItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isGod = false;
        this.mSkinType = -1;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_user_recommend_item, (ViewGroup) this, true);
        this.fAy = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.fAy.setAutoChangeStyle(true);
        this.fAy.setDefaultResource(17170445);
        this.fAy.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fAy.setIsRound(true);
        this.fAy.setScaleType(ImageView.ScaleType.FIT_XY);
        this.fAz = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.fAz.setGravity(17);
        this.Zy = (TextView) findViewById(d.g.user_recommend_username);
        this.fAA = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.fAy.onClick(UserRecommendItemView.this.fAy);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.Zy.setTextColor(al.getColor(this.mSkinType, d.C0277d.cp_cont_r));
            } else {
                this.Zy.setTextColor(al.getColor(this.mSkinType, d.C0277d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.fAA.setTextColor(al.getColor(i, d.C0277d.cp_cont_d));
            if (this.isGod) {
                this.Zy.setTextColor(al.getColor(i, d.C0277d.cp_cont_r));
            } else {
                this.Zy.setTextColor(al.getColor(i, d.C0277d.cp_cont_b));
            }
            setBackgroundColor(al.getColor(i, d.C0277d.cp_bg_line_d));
            this.fAz.onChangeSkinType(i);
            this.fAy.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.fAy;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.fAz;
    }

    public TextView getUsername() {
        return this.Zy;
    }

    public TextView getFansNum() {
        return this.fAA;
    }
}

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
    private TextView Zx;
    private CardUserLikeButton fAA;
    private TextView fAB;
    private ClickableHeaderImageView fAz;
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
        this.fAz = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.fAz.setAutoChangeStyle(true);
        this.fAz.setDefaultResource(17170445);
        this.fAz.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fAz.setIsRound(true);
        this.fAz.setScaleType(ImageView.ScaleType.FIT_XY);
        this.fAA = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.fAA.setGravity(17);
        this.Zx = (TextView) findViewById(d.g.user_recommend_username);
        this.fAB = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.fAz.onClick(UserRecommendItemView.this.fAz);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.Zx.setTextColor(al.getColor(this.mSkinType, d.C0236d.cp_cont_r));
            } else {
                this.Zx.setTextColor(al.getColor(this.mSkinType, d.C0236d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.fAB.setTextColor(al.getColor(i, d.C0236d.cp_cont_d));
            if (this.isGod) {
                this.Zx.setTextColor(al.getColor(i, d.C0236d.cp_cont_r));
            } else {
                this.Zx.setTextColor(al.getColor(i, d.C0236d.cp_cont_b));
            }
            setBackgroundColor(al.getColor(i, d.C0236d.cp_bg_line_d));
            this.fAA.onChangeSkinType(i);
            this.fAz.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.fAz;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.fAA;
    }

    public TextView getUsername() {
        return this.Zx;
    }

    public TextView getFansNum() {
        return this.fAB;
    }
}

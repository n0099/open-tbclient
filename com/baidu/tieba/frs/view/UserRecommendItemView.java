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
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView aBt;
    private TextView dSA;
    private ClickableHeaderImageView dSy;
    private CardUserLikeButton dSz;
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
        LayoutInflater.from(context).inflate(e.h.frs_user_recommend_item, (ViewGroup) this, true);
        this.dSy = (ClickableHeaderImageView) findViewById(e.g.user_recommend_head);
        this.dSy.setAutoChangeStyle(true);
        this.dSy.setDefaultResource(17170445);
        this.dSy.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.dSy.setDefaultBgResource(e.d.cp_bg_line_e);
        this.dSy.setIsRound(true);
        this.dSy.setScaleType(ImageView.ScaleType.FIT_XY);
        this.dSz = (CardUserLikeButton) findViewById(e.g.user_recommend_like_btn);
        this.dSz.setGravity(17);
        this.aBt = (TextView) findViewById(e.g.user_recommend_username);
        this.dSA = (TextView) findViewById(e.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.dSy.onClick(UserRecommendItemView.this.dSy);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.aBt.setTextColor(al.getColor(this.mSkinType, e.d.cp_cont_r));
            } else {
                this.aBt.setTextColor(al.getColor(this.mSkinType, e.d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dSA.setTextColor(al.getColor(i, e.d.cp_cont_d));
            if (this.isGod) {
                this.aBt.setTextColor(al.getColor(i, e.d.cp_cont_r));
            } else {
                this.aBt.setTextColor(al.getColor(i, e.d.cp_cont_b));
            }
            setBackgroundColor(al.getColor(i, e.d.cp_bg_line_d));
            this.dSz.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.dSy;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.dSz;
    }

    public TextView getUsername() {
        return this.aBt;
    }

    public TextView getFansNum() {
        return this.dSA;
    }
}

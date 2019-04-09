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
    private TextView Zz;
    private ClickableHeaderImageView fAm;
    private CardUserLikeButton fAn;
    private TextView fAo;
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
        this.fAm = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.fAm.setAutoChangeStyle(true);
        this.fAm.setDefaultResource(17170445);
        this.fAm.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fAm.setIsRound(true);
        this.fAm.setScaleType(ImageView.ScaleType.FIT_XY);
        this.fAn = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.fAn.setGravity(17);
        this.Zz = (TextView) findViewById(d.g.user_recommend_username);
        this.fAo = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.fAm.onClick(UserRecommendItemView.this.fAm);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.Zz.setTextColor(al.getColor(this.mSkinType, d.C0277d.cp_cont_r));
            } else {
                this.Zz.setTextColor(al.getColor(this.mSkinType, d.C0277d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.fAo.setTextColor(al.getColor(i, d.C0277d.cp_cont_d));
            if (this.isGod) {
                this.Zz.setTextColor(al.getColor(i, d.C0277d.cp_cont_r));
            } else {
                this.Zz.setTextColor(al.getColor(i, d.C0277d.cp_cont_b));
            }
            setBackgroundColor(al.getColor(i, d.C0277d.cp_bg_line_d));
            this.fAn.onChangeSkinType(i);
            this.fAm.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.fAm;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.fAn;
    }

    public TextView getUsername() {
        return this.Zz;
    }

    public TextView getFansNum() {
        return this.fAo;
    }
}

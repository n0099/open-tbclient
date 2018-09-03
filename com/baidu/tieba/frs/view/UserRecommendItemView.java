package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CardUserLikeButton;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView axI;
    private ClickableHeaderImageView dLg;
    private CardUserLikeButton dLh;
    private TextView dLi;
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
        LayoutInflater.from(context).inflate(f.h.frs_user_recommend_item, (ViewGroup) this, true);
        this.dLg = (ClickableHeaderImageView) findViewById(f.g.user_recommend_head);
        this.dLg.setAutoChangeStyle(true);
        this.dLg.setDefaultResource(17170445);
        this.dLg.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.dLg.setDefaultBgResource(f.d.cp_bg_line_e);
        this.dLg.setIsRound(true);
        this.dLg.setScaleType(ImageView.ScaleType.FIT_XY);
        this.dLh = (CardUserLikeButton) findViewById(f.g.user_recommend_like_btn);
        this.dLh.setGravity(17);
        this.axI = (TextView) findViewById(f.g.user_recommend_username);
        this.dLi = (TextView) findViewById(f.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.dLg.onClick(UserRecommendItemView.this.dLg);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.axI.setTextColor(am.getColor(this.mSkinType, f.d.cp_cont_r));
            } else {
                this.axI.setTextColor(am.getColor(this.mSkinType, f.d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dLi.setTextColor(am.getColor(i, f.d.cp_cont_d));
            if (this.isGod) {
                this.axI.setTextColor(am.getColor(i, f.d.cp_cont_r));
            } else {
                this.axI.setTextColor(am.getColor(i, f.d.cp_cont_b));
            }
            setBackgroundColor(am.getColor(i, f.d.cp_bg_line_d));
            this.dLh.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.dLg;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.dLh;
    }

    public TextView getUsername() {
        return this.axI;
    }

    public TextView getFansNum() {
        return this.dLi;
    }
}

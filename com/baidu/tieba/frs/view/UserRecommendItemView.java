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
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView afW;
    private ClickableHeaderImageView hCx;
    private CardUserLikeButton hCy;
    private TextView hCz;
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
        LayoutInflater.from(context).inflate(R.layout.frs_user_recommend_item, (ViewGroup) this, true);
        this.hCx = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.hCx.setAutoChangeStyle(true);
        this.hCx.setDefaultResource(17170445);
        this.hCx.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hCx.setIsRound(true);
        this.hCx.setScaleType(ImageView.ScaleType.FIT_XY);
        this.hCy = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.hCy.setGravity(17);
        this.afW = (TextView) findViewById(R.id.user_recommend_username);
        this.hCz = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.hCx.onClick(UserRecommendItemView.this.hCx);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.afW.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.afW.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.hCz.setTextColor(am.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.afW.setTextColor(am.getColor(i, R.color.cp_cont_r));
            } else {
                this.afW.setTextColor(am.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(am.getColor(i, R.color.cp_bg_line_d));
            this.hCy.onChangeSkinType(i);
            this.hCx.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.hCx;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.hCy;
    }

    public TextView getUsername() {
        return this.afW;
    }

    public TextView getFansNum() {
        return this.hCz;
    }
}

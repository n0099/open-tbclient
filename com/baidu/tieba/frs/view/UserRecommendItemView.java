package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CardUserLikeButton;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView ahA;
    private ClickableHeaderImageView igx;
    private CardUserLikeButton igy;
    private TextView igz;
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
        this.igx = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.igx.setAutoChangeStyle(true);
        this.igx.setDefaultResource(17170445);
        this.igx.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.igx.setIsRound(true);
        this.igx.setScaleType(ImageView.ScaleType.FIT_XY);
        this.igy = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.igy.setGravity(17);
        this.ahA = (TextView) findViewById(R.id.user_recommend_username);
        this.igz = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.igx.onClick(UserRecommendItemView.this.igx);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.ahA.setTextColor(an.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.ahA.setTextColor(an.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.igz.setTextColor(an.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.ahA.setTextColor(an.getColor(i, R.color.cp_cont_r));
            } else {
                this.ahA.setTextColor(an.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(an.getColor(i, R.color.cp_bg_line_d));
            this.igy.onChangeSkinType(i);
            this.igx.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.igx;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.igy;
    }

    public TextView getUsername() {
        return this.ahA;
    }

    public TextView getFansNum() {
        return this.igz;
    }
}

package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CardUserLikeButton;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView ajY;
    private boolean isGod;
    private ClickableHeaderImageView jSx;
    private CardUserLikeButton jSy;
    private TextView jSz;
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
        this.jSx = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.jSx.setAutoChangeStyle(true);
        this.jSx.setDefaultResource(17170445);
        this.jSx.setIsRound(true);
        this.jSx.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jSy = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.jSy.setGravity(17);
        this.ajY = (TextView) findViewById(R.id.user_recommend_username);
        this.jSz = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.jSx.onClick(UserRecommendItemView.this.jSx);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.ajY.setTextColor(ap.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.ajY.setTextColor(ap.getColor(this.mSkinType, R.color.CAM_X0105));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.jSz.setTextColor(ap.getColor(i, R.color.CAM_X0109));
            if (this.isGod) {
                this.ajY.setTextColor(ap.getColor(i, R.color.cp_cont_r));
            } else {
                this.ajY.setTextColor(ap.getColor(i, R.color.CAM_X0105));
            }
            setBackgroundColor(ap.getColor(i, R.color.CAM_X0201));
            this.jSy.onChangeSkinType(i);
            this.jSx.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.jSx;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.jSy;
    }

    public TextView getUsername() {
        return this.ajY;
    }

    public TextView getFansNum() {
        return this.jSz;
    }
}

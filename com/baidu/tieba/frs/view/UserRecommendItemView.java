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
/* loaded from: classes22.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView aju;
    private boolean isGod;
    private ClickableHeaderImageView jpv;
    private CardUserLikeButton jpw;
    private TextView jpx;
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
        this.jpv = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.jpv.setAutoChangeStyle(true);
        this.jpv.setDefaultResource(17170445);
        this.jpv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jpv.setIsRound(true);
        this.jpv.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jpw = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.jpw.setGravity(17);
        this.aju = (TextView) findViewById(R.id.user_recommend_username);
        this.jpx = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.jpv.onClick(UserRecommendItemView.this.jpv);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.aju.setTextColor(ap.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.aju.setTextColor(ap.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.jpx.setTextColor(ap.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.aju.setTextColor(ap.getColor(i, R.color.cp_cont_r));
            } else {
                this.aju.setTextColor(ap.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(ap.getColor(i, R.color.cp_bg_line_d));
            this.jpw.onChangeSkinType(i);
            this.jpv.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.jpv;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.jpw;
    }

    public TextView getUsername() {
        return this.aju;
    }

    public TextView getFansNum() {
        return this.jpx;
    }
}

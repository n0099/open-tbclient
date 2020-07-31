package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CardUserLikeButton;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView ahr;
    private ClickableHeaderImageView imB;
    private CardUserLikeButton imC;
    private TextView imD;
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
        this.imB = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.imB.setAutoChangeStyle(true);
        this.imB.setDefaultResource(17170445);
        this.imB.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.imB.setIsRound(true);
        this.imB.setScaleType(ImageView.ScaleType.FIT_XY);
        this.imC = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.imC.setGravity(17);
        this.ahr = (TextView) findViewById(R.id.user_recommend_username);
        this.imD = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.imB.onClick(UserRecommendItemView.this.imB);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.ahr.setTextColor(ao.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.ahr.setTextColor(ao.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.imD.setTextColor(ao.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.ahr.setTextColor(ao.getColor(i, R.color.cp_cont_r));
            } else {
                this.ahr.setTextColor(ao.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(ao.getColor(i, R.color.cp_bg_line_d));
            this.imC.onChangeSkinType(i);
            this.imB.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.imB;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.imC;
    }

    public TextView getUsername() {
        return this.ahr;
    }

    public TextView getFansNum() {
        return this.imD;
    }
}

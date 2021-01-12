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
/* loaded from: classes2.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView akj;
    private boolean isGod;
    private ClickableHeaderImageView jLA;
    private CardUserLikeButton jLB;
    private TextView jLC;
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
        this.jLA = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.jLA.setAutoChangeStyle(true);
        this.jLA.setDefaultResource(17170445);
        this.jLA.setIsRound(true);
        this.jLA.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jLB = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.jLB.setGravity(17);
        this.akj = (TextView) findViewById(R.id.user_recommend_username);
        this.jLC = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.jLA.onClick(UserRecommendItemView.this.jLA);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.akj.setTextColor(ao.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.akj.setTextColor(ao.getColor(this.mSkinType, R.color.CAM_X0105));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.jLC.setTextColor(ao.getColor(i, R.color.CAM_X0109));
            if (this.isGod) {
                this.akj.setTextColor(ao.getColor(i, R.color.cp_cont_r));
            } else {
                this.akj.setTextColor(ao.getColor(i, R.color.CAM_X0105));
            }
            setBackgroundColor(ao.getColor(i, R.color.CAM_X0201));
            this.jLB.onChangeSkinType(i);
            this.jLA.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.jLA;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.jLB;
    }

    public TextView getUsername() {
        return this.akj;
    }

    public TextView getFansNum() {
        return this.jLC;
    }
}

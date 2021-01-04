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
    private TextView ala;
    private boolean isGod;
    private ClickableHeaderImageView jQg;
    private CardUserLikeButton jQh;
    private TextView jQi;
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
        this.jQg = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.jQg.setAutoChangeStyle(true);
        this.jQg.setDefaultResource(17170445);
        this.jQg.setIsRound(true);
        this.jQg.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jQh = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.jQh.setGravity(17);
        this.ala = (TextView) findViewById(R.id.user_recommend_username);
        this.jQi = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.jQg.onClick(UserRecommendItemView.this.jQg);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.ala.setTextColor(ao.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.ala.setTextColor(ao.getColor(this.mSkinType, R.color.CAM_X0105));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.jQi.setTextColor(ao.getColor(i, R.color.CAM_X0109));
            if (this.isGod) {
                this.ala.setTextColor(ao.getColor(i, R.color.cp_cont_r));
            } else {
                this.ala.setTextColor(ao.getColor(i, R.color.CAM_X0105));
            }
            setBackgroundColor(ao.getColor(i, R.color.CAM_X0201));
            this.jQh.onChangeSkinType(i);
            this.jQg.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.jQg;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.jQh;
    }

    public TextView getUsername() {
        return this.ala;
    }

    public TextView getFansNum() {
        return this.jQi;
    }
}

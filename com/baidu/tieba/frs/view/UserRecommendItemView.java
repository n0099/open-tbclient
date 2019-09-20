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
/* loaded from: classes4.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView XK;
    private ClickableHeaderImageView fYQ;
    private CardUserLikeButton fYR;
    private TextView fYS;
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
        this.fYQ = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.fYQ.setAutoChangeStyle(true);
        this.fYQ.setDefaultResource(17170445);
        this.fYQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fYQ.setIsRound(true);
        this.fYQ.setScaleType(ImageView.ScaleType.FIT_XY);
        this.fYR = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.fYR.setGravity(17);
        this.XK = (TextView) findViewById(R.id.user_recommend_username);
        this.fYS = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.fYQ.onClick(UserRecommendItemView.this.fYQ);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.XK.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.XK.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.fYS.setTextColor(am.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.XK.setTextColor(am.getColor(i, R.color.cp_cont_r));
            } else {
                this.XK.setTextColor(am.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(am.getColor(i, R.color.cp_bg_line_d));
            this.fYR.onChangeSkinType(i);
            this.fYQ.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.fYQ;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.fYR;
    }

    public TextView getUsername() {
        return this.XK;
    }

    public TextView getFansNum() {
        return this.fYS;
    }
}

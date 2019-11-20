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
    private TextView He;
    private ClickableHeaderImageView fXu;
    private CardUserLikeButton fXv;
    private TextView fXw;
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
        this.fXu = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.fXu.setAutoChangeStyle(true);
        this.fXu.setDefaultResource(17170445);
        this.fXu.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fXu.setIsRound(true);
        this.fXu.setScaleType(ImageView.ScaleType.FIT_XY);
        this.fXv = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.fXv.setGravity(17);
        this.He = (TextView) findViewById(R.id.user_recommend_username);
        this.fXw = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.fXu.onClick(UserRecommendItemView.this.fXu);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.He.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.He.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.fXw.setTextColor(am.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.He.setTextColor(am.getColor(i, R.color.cp_cont_r));
            } else {
                this.He.setTextColor(am.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(am.getColor(i, R.color.cp_bg_line_d));
            this.fXv.onChangeSkinType(i);
            this.fXu.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.fXu;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.fXv;
    }

    public TextView getUsername() {
        return this.He;
    }

    public TextView getFansNum() {
        return this.fXw;
    }
}

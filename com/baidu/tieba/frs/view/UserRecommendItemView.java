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
    private TextView XL;
    private ClickableHeaderImageView fWj;
    private CardUserLikeButton fWk;
    private TextView fWl;
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
        this.fWj = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.fWj.setAutoChangeStyle(true);
        this.fWj.setDefaultResource(17170445);
        this.fWj.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fWj.setIsRound(true);
        this.fWj.setScaleType(ImageView.ScaleType.FIT_XY);
        this.fWk = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.fWk.setGravity(17);
        this.XL = (TextView) findViewById(R.id.user_recommend_username);
        this.fWl = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.fWj.onClick(UserRecommendItemView.this.fWj);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.XL.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.XL.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.fWl.setTextColor(am.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.XL.setTextColor(am.getColor(i, R.color.cp_cont_r));
            } else {
                this.XL.setTextColor(am.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(am.getColor(i, R.color.cp_bg_line_d));
            this.fWk.onChangeSkinType(i);
            this.fWj.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.fWj;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.fWk;
    }

    public TextView getUsername() {
        return this.XL;
    }

    public TextView getFansNum() {
        return this.fWl;
    }
}

package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CardUserLikeButton;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView Xq;
    private ClickableHeaderImageView fRm;
    private CardUserLikeButton fRn;
    private TextView fRo;
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
        this.fRm = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.fRm.setAutoChangeStyle(true);
        this.fRm.setDefaultResource(17170445);
        this.fRm.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fRm.setIsRound(true);
        this.fRm.setScaleType(ImageView.ScaleType.FIT_XY);
        this.fRn = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.fRn.setGravity(17);
        this.Xq = (TextView) findViewById(R.id.user_recommend_username);
        this.fRo = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.fRm.onClick(UserRecommendItemView.this.fRm);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.Xq.setTextColor(al.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.Xq.setTextColor(al.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.fRo.setTextColor(al.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.Xq.setTextColor(al.getColor(i, R.color.cp_cont_r));
            } else {
                this.Xq.setTextColor(al.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(al.getColor(i, R.color.cp_bg_line_d));
            this.fRn.onChangeSkinType(i);
            this.fRm.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.fRm;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.fRn;
    }

    public TextView getUsername() {
        return this.Xq;
    }

    public TextView getFansNum() {
        return this.fRo;
    }
}

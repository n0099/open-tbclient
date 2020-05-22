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
/* loaded from: classes9.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView agw;
    private ClickableHeaderImageView hRq;
    private CardUserLikeButton hRr;
    private TextView hRs;
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
        this.hRq = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.hRq.setAutoChangeStyle(true);
        this.hRq.setDefaultResource(17170445);
        this.hRq.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hRq.setIsRound(true);
        this.hRq.setScaleType(ImageView.ScaleType.FIT_XY);
        this.hRr = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.hRr.setGravity(17);
        this.agw = (TextView) findViewById(R.id.user_recommend_username);
        this.hRs = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.hRq.onClick(UserRecommendItemView.this.hRq);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.agw.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.agw.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.hRs.setTextColor(am.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.agw.setTextColor(am.getColor(i, R.color.cp_cont_r));
            } else {
                this.agw.setTextColor(am.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(am.getColor(i, R.color.cp_bg_line_d));
            this.hRr.onChangeSkinType(i);
            this.hRq.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.hRq;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.hRr;
    }

    public TextView getUsername() {
        return this.agw;
    }

    public TextView getFansNum() {
        return this.hRs;
    }
}

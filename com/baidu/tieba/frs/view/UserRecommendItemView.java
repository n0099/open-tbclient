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
/* loaded from: classes16.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView aiH;
    private ClickableHeaderImageView iAN;
    private CardUserLikeButton iAO;
    private TextView iAP;
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
        this.iAN = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.iAN.setAutoChangeStyle(true);
        this.iAN.setDefaultResource(17170445);
        this.iAN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iAN.setIsRound(true);
        this.iAN.setScaleType(ImageView.ScaleType.FIT_XY);
        this.iAO = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.iAO.setGravity(17);
        this.aiH = (TextView) findViewById(R.id.user_recommend_username);
        this.iAP = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.iAN.onClick(UserRecommendItemView.this.iAN);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.aiH.setTextColor(ap.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.aiH.setTextColor(ap.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.iAP.setTextColor(ap.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.aiH.setTextColor(ap.getColor(i, R.color.cp_cont_r));
            } else {
                this.aiH.setTextColor(ap.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(ap.getColor(i, R.color.cp_bg_line_d));
            this.iAO.onChangeSkinType(i);
            this.iAN.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.iAN;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.iAO;
    }

    public TextView getUsername() {
        return this.aiH;
    }

    public TextView getFansNum() {
        return this.iAP;
    }
}

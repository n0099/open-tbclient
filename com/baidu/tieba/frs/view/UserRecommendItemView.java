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
/* loaded from: classes21.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView ajz;
    private boolean isGod;
    private ClickableHeaderImageView jqc;
    private CardUserLikeButton jqd;
    private TextView jqe;
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
        this.jqc = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.jqc.setAutoChangeStyle(true);
        this.jqc.setDefaultResource(17170445);
        this.jqc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jqc.setIsRound(true);
        this.jqc.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jqd = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.jqd.setGravity(17);
        this.ajz = (TextView) findViewById(R.id.user_recommend_username);
        this.jqe = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.jqc.onClick(UserRecommendItemView.this.jqc);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.ajz.setTextColor(ap.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.ajz.setTextColor(ap.getColor(this.mSkinType, R.color.CAM_X0105));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.jqe.setTextColor(ap.getColor(i, R.color.CAM_X0109));
            if (this.isGod) {
                this.ajz.setTextColor(ap.getColor(i, R.color.cp_cont_r));
            } else {
                this.ajz.setTextColor(ap.getColor(i, R.color.CAM_X0105));
            }
            setBackgroundColor(ap.getColor(i, R.color.CAM_X0201));
            this.jqd.onChangeSkinType(i);
            this.jqc.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.jqc;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.jqd;
    }

    public TextView getUsername() {
        return this.ajz;
    }

    public TextView getFansNum() {
        return this.jqe;
    }
}

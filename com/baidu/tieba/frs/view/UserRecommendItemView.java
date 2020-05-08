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
    private TextView afZ;
    private ClickableHeaderImageView hCD;
    private CardUserLikeButton hCE;
    private TextView hCF;
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
        this.hCD = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.hCD.setAutoChangeStyle(true);
        this.hCD.setDefaultResource(17170445);
        this.hCD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hCD.setIsRound(true);
        this.hCD.setScaleType(ImageView.ScaleType.FIT_XY);
        this.hCE = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.hCE.setGravity(17);
        this.afZ = (TextView) findViewById(R.id.user_recommend_username);
        this.hCF = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.hCD.onClick(UserRecommendItemView.this.hCD);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.afZ.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.afZ.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.hCF.setTextColor(am.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.afZ.setTextColor(am.getColor(i, R.color.cp_cont_r));
            } else {
                this.afZ.setTextColor(am.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(am.getColor(i, R.color.cp_bg_line_d));
            this.hCE.onChangeSkinType(i);
            this.hCD.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.hCD;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.hCE;
    }

    public TextView getUsername() {
        return this.afZ;
    }

    public TextView getFansNum() {
        return this.hCF;
    }
}

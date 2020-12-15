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
/* loaded from: classes22.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView aky;
    private boolean isGod;
    private ClickableHeaderImageView jDE;
    private CardUserLikeButton jDF;
    private TextView jDG;
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
        this.jDE = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.jDE.setAutoChangeStyle(true);
        this.jDE.setDefaultResource(17170445);
        this.jDE.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jDE.setIsRound(true);
        this.jDE.setScaleType(ImageView.ScaleType.FIT_XY);
        this.jDF = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.jDF.setGravity(17);
        this.aky = (TextView) findViewById(R.id.user_recommend_username);
        this.jDG = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.jDE.onClick(UserRecommendItemView.this.jDE);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.aky.setTextColor(ap.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.aky.setTextColor(ap.getColor(this.mSkinType, R.color.CAM_X0105));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.jDG.setTextColor(ap.getColor(i, R.color.CAM_X0109));
            if (this.isGod) {
                this.aky.setTextColor(ap.getColor(i, R.color.cp_cont_r));
            } else {
                this.aky.setTextColor(ap.getColor(i, R.color.CAM_X0105));
            }
            setBackgroundColor(ap.getColor(i, R.color.CAM_X0201));
            this.jDF.onChangeSkinType(i);
            this.jDE.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.jDE;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.jDF;
    }

    public TextView getUsername() {
        return this.aky;
    }

    public TextView getFansNum() {
        return this.jDG;
    }
}

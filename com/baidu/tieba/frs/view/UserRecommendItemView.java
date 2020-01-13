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
/* loaded from: classes7.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView MK;
    private ClickableHeaderImageView gPn;
    private CardUserLikeButton gPo;
    private TextView gPp;
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
        this.gPn = (ClickableHeaderImageView) findViewById(R.id.user_recommend_head);
        this.gPn.setAutoChangeStyle(true);
        this.gPn.setDefaultResource(17170445);
        this.gPn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gPn.setIsRound(true);
        this.gPn.setScaleType(ImageView.ScaleType.FIT_XY);
        this.gPo = (CardUserLikeButton) findViewById(R.id.user_recommend_like_btn);
        this.gPo.setGravity(17);
        this.MK = (TextView) findViewById(R.id.user_recommend_username);
        this.gPp = (TextView) findViewById(R.id.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.gPn.onClick(UserRecommendItemView.this.gPn);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.MK.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_r));
            } else {
                this.MK.setTextColor(am.getColor(this.mSkinType, R.color.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.gPp.setTextColor(am.getColor(i, R.color.cp_cont_d));
            if (this.isGod) {
                this.MK.setTextColor(am.getColor(i, R.color.cp_cont_r));
            } else {
                this.MK.setTextColor(am.getColor(i, R.color.cp_cont_b));
            }
            setBackgroundColor(am.getColor(i, R.color.cp_bg_line_d));
            this.gPo.onChangeSkinType(i);
            this.gPn.setPlaceHolder(1);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.gPn;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.gPo;
    }

    public TextView getUsername() {
        return this.MK;
    }

    public TextView getFansNum() {
        return this.gPp;
    }
}

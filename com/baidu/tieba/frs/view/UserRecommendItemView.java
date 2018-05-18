package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CardUserLikeButton;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView apg;
    private ClickableHeaderImageView dvN;
    private CardUserLikeButton dvO;
    private TextView dvP;
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
        LayoutInflater.from(context).inflate(d.i.frs_user_recommend_item, (ViewGroup) this, true);
        this.dvN = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.dvN.setAutoChangeStyle(true);
        this.dvN.setDefaultResource(17170445);
        this.dvN.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dvN.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.dvN.setIsRound(true);
        this.dvN.setScaleType(ImageView.ScaleType.FIT_XY);
        this.dvO = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.dvO.setGravity(17);
        this.apg = (TextView) findViewById(d.g.user_recommend_username);
        this.dvP = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                UserRecommendItemView.this.dvN.onClick(UserRecommendItemView.this.dvN);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.apg.setTextColor(ak.getColor(this.mSkinType, d.C0126d.cp_cont_r));
            } else {
                this.apg.setTextColor(ak.getColor(this.mSkinType, d.C0126d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dvP.setTextColor(ak.getColor(i, d.C0126d.cp_cont_d));
            if (this.isGod) {
                this.apg.setTextColor(ak.getColor(i, d.C0126d.cp_cont_r));
            } else {
                this.apg.setTextColor(ak.getColor(i, d.C0126d.cp_cont_b));
            }
            setBackgroundColor(ak.getColor(i, d.C0126d.cp_bg_line_d));
            this.dvO.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.dvN;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.dvO;
    }

    public TextView getUsername() {
        return this.apg;
    }

    public TextView getFansNum() {
        return this.dvP;
    }
}

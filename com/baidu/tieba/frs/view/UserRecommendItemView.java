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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView axL;
    private ClickableHeaderImageView dLk;
    private CardUserLikeButton dLl;
    private TextView dLm;
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
        LayoutInflater.from(context).inflate(d.h.frs_user_recommend_item, (ViewGroup) this, true);
        this.dLk = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.dLk.setAutoChangeStyle(true);
        this.dLk.setDefaultResource(17170445);
        this.dLk.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dLk.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.dLk.setIsRound(true);
        this.dLk.setScaleType(ImageView.ScaleType.FIT_XY);
        this.dLl = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.dLl.setGravity(17);
        this.axL = (TextView) findViewById(d.g.user_recommend_username);
        this.dLm = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.dLk.onClick(UserRecommendItemView.this.dLk);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.axL.setTextColor(am.getColor(this.mSkinType, d.C0140d.cp_cont_r));
            } else {
                this.axL.setTextColor(am.getColor(this.mSkinType, d.C0140d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dLm.setTextColor(am.getColor(i, d.C0140d.cp_cont_d));
            if (this.isGod) {
                this.axL.setTextColor(am.getColor(i, d.C0140d.cp_cont_r));
            } else {
                this.axL.setTextColor(am.getColor(i, d.C0140d.cp_cont_b));
            }
            setBackgroundColor(am.getColor(i, d.C0140d.cp_bg_line_d));
            this.dLl.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.dLk;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.dLl;
    }

    public TextView getUsername() {
        return this.axL;
    }

    public TextView getFansNum() {
        return this.dLm;
    }
}

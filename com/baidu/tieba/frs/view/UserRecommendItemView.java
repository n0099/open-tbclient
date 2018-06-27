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
    private TextView ayf;
    private ClickableHeaderImageView dIv;
    private CardUserLikeButton dIw;
    private TextView dIx;
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
        this.dIv = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.dIv.setAutoChangeStyle(true);
        this.dIv.setDefaultResource(17170445);
        this.dIv.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dIv.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.dIv.setIsRound(true);
        this.dIv.setScaleType(ImageView.ScaleType.FIT_XY);
        this.dIw = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.dIw.setGravity(17);
        this.ayf = (TextView) findViewById(d.g.user_recommend_username);
        this.dIx = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.dIv.onClick(UserRecommendItemView.this.dIv);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.ayf.setTextColor(am.getColor(this.mSkinType, d.C0142d.cp_cont_r));
            } else {
                this.ayf.setTextColor(am.getColor(this.mSkinType, d.C0142d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dIx.setTextColor(am.getColor(i, d.C0142d.cp_cont_d));
            if (this.isGod) {
                this.ayf.setTextColor(am.getColor(i, d.C0142d.cp_cont_r));
            } else {
                this.ayf.setTextColor(am.getColor(i, d.C0142d.cp_cont_b));
            }
            setBackgroundColor(am.getColor(i, d.C0142d.cp_bg_line_d));
            this.dIw.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.dIv;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.dIw;
    }

    public TextView getUsername() {
        return this.ayf;
    }

    public TextView getFansNum() {
        return this.dIx;
    }
}

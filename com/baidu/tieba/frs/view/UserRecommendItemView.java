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
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView aKr;
    private ClickableHeaderImageView elg;
    private CardUserLikeButton elh;
    private TextView eli;
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
        LayoutInflater.from(context).inflate(e.h.frs_user_recommend_item, (ViewGroup) this, true);
        this.elg = (ClickableHeaderImageView) findViewById(e.g.user_recommend_head);
        this.elg.setAutoChangeStyle(true);
        this.elg.setDefaultResource(17170445);
        this.elg.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.elg.setDefaultBgResource(e.d.cp_bg_line_e);
        this.elg.setIsRound(true);
        this.elg.setScaleType(ImageView.ScaleType.FIT_XY);
        this.elh = (CardUserLikeButton) findViewById(e.g.user_recommend_like_btn);
        this.elh.setGravity(17);
        this.aKr = (TextView) findViewById(e.g.user_recommend_username);
        this.eli = (TextView) findViewById(e.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.elg.onClick(UserRecommendItemView.this.elg);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.aKr.setTextColor(al.getColor(this.mSkinType, e.d.cp_cont_r));
            } else {
                this.aKr.setTextColor(al.getColor(this.mSkinType, e.d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.eli.setTextColor(al.getColor(i, e.d.cp_cont_d));
            if (this.isGod) {
                this.aKr.setTextColor(al.getColor(i, e.d.cp_cont_r));
            } else {
                this.aKr.setTextColor(al.getColor(i, e.d.cp_cont_b));
            }
            setBackgroundColor(al.getColor(i, e.d.cp_bg_line_d));
            this.elh.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.elg;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.elh;
    }

    public TextView getUsername() {
        return this.aKr;
    }

    public TextView getFansNum() {
        return this.eli;
    }
}

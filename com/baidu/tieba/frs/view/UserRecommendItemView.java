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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class UserRecommendItemView extends LinearLayout {
    private TextView axo;
    private ClickableHeaderImageView dFa;
    private CardUserLikeButton dFb;
    private TextView dFc;
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
        this.dFa = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.dFa.setAutoChangeStyle(true);
        this.dFa.setDefaultResource(17170445);
        this.dFa.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dFa.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dFa.setIsRound(true);
        this.dFa.setScaleType(ImageView.ScaleType.FIT_XY);
        this.dFb = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.dFb.setGravity(17);
        this.axo = (TextView) findViewById(d.g.user_recommend_username);
        this.dFc = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.dFa.onClick(UserRecommendItemView.this.dFa);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.axo.setTextColor(al.getColor(this.mSkinType, d.C0141d.cp_cont_r));
            } else {
                this.axo.setTextColor(al.getColor(this.mSkinType, d.C0141d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dFc.setTextColor(al.getColor(i, d.C0141d.cp_cont_d));
            if (this.isGod) {
                this.axo.setTextColor(al.getColor(i, d.C0141d.cp_cont_r));
            } else {
                this.axo.setTextColor(al.getColor(i, d.C0141d.cp_cont_b));
            }
            setBackgroundColor(al.getColor(i, d.C0141d.cp_bg_line_d));
            this.dFb.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.dFa;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.dFb;
    }

    public TextView getUsername() {
        return this.axo;
    }

    public TextView getFansNum() {
        return this.dFc;
    }
}

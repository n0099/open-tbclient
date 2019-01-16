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
    private TextView aKT;
    private ClickableHeaderImageView elM;
    private CardUserLikeButton elN;
    private TextView elO;
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
        this.elM = (ClickableHeaderImageView) findViewById(e.g.user_recommend_head);
        this.elM.setAutoChangeStyle(true);
        this.elM.setDefaultResource(17170445);
        this.elM.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.elM.setDefaultBgResource(e.d.cp_bg_line_e);
        this.elM.setIsRound(true);
        this.elM.setScaleType(ImageView.ScaleType.FIT_XY);
        this.elN = (CardUserLikeButton) findViewById(e.g.user_recommend_like_btn);
        this.elN.setGravity(17);
        this.aKT = (TextView) findViewById(e.g.user_recommend_username);
        this.elO = (TextView) findViewById(e.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.UserRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserRecommendItemView.this.elM.onClick(UserRecommendItemView.this.elM);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.aKT.setTextColor(al.getColor(this.mSkinType, e.d.cp_cont_r));
            } else {
                this.aKT.setTextColor(al.getColor(this.mSkinType, e.d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.elO.setTextColor(al.getColor(i, e.d.cp_cont_d));
            if (this.isGod) {
                this.aKT.setTextColor(al.getColor(i, e.d.cp_cont_r));
            } else {
                this.aKT.setTextColor(al.getColor(i, e.d.cp_cont_b));
            }
            setBackgroundColor(al.getColor(i, e.d.cp_bg_line_d));
            this.elN.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.elM;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.elN;
    }

    public TextView getUsername() {
        return this.aKT;
    }

    public TextView getFansNum() {
        return this.elO;
    }
}

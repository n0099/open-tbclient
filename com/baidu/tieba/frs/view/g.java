package com.baidu.tieba.frs.view;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CardUserLikeButton;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends LinearLayout {
    private TextView anX;
    private ClickableHeaderImageView ddc;
    private CardUserLikeButton ddd;
    private TextView dde;
    private boolean isGod;
    private int mSkinType;

    public g(Context context) {
        super(context);
        this.isGod = false;
        this.mSkinType = -1;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_user_recommend_item, (ViewGroup) this, true);
        this.ddc = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.ddc.setAutoChangeStyle(true);
        this.ddc.setDefaultResource(17170445);
        this.ddc.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ddc.setDefaultBgResource(d.C0082d.cp_bg_line_e);
        this.ddc.setIsRound(true);
        this.ddc.setScaleType(ImageView.ScaleType.FIT_XY);
        this.ddd = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.ddd.setGravity(17);
        this.anX = (TextView) findViewById(d.g.user_recommend_username);
        this.dde = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.ddc.onClick(g.this.ddc);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.anX.setTextColor(aj.getColor(this.mSkinType, d.C0082d.cp_cont_r));
            } else {
                this.anX.setTextColor(aj.getColor(this.mSkinType, d.C0082d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dde.setTextColor(aj.getColor(i, d.C0082d.cp_cont_d));
            if (this.isGod) {
                this.anX.setTextColor(aj.getColor(i, d.C0082d.cp_cont_r));
            } else {
                this.anX.setTextColor(aj.getColor(i, d.C0082d.cp_cont_b));
            }
            setBackgroundColor(aj.getColor(i, d.C0082d.cp_bg_line_d));
            this.ddd.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.ddc;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.ddd;
    }

    public TextView getUsername() {
        return this.anX;
    }

    public TextView getFansNum() {
        return this.dde;
    }
}

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
public class h extends LinearLayout {
    private TextView aoc;
    private ClickableHeaderImageView den;
    private CardUserLikeButton deo;
    private TextView dep;
    private boolean isGod;
    private int mSkinType;

    public h(Context context) {
        super(context);
        this.isGod = false;
        this.mSkinType = -1;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_user_recommend_item, (ViewGroup) this, true);
        this.den = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.den.setAutoChangeStyle(true);
        this.den.setDefaultResource(17170445);
        this.den.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.den.setDefaultBgResource(d.C0095d.cp_bg_line_e);
        this.den.setIsRound(true);
        this.den.setScaleType(ImageView.ScaleType.FIT_XY);
        this.deo = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.deo.setGravity(17);
        this.aoc = (TextView) findViewById(d.g.user_recommend_username);
        this.dep = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.den.onClick(h.this.den);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.aoc.setTextColor(aj.getColor(this.mSkinType, d.C0095d.cp_cont_r));
            } else {
                this.aoc.setTextColor(aj.getColor(this.mSkinType, d.C0095d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dep.setTextColor(aj.getColor(i, d.C0095d.cp_cont_d));
            if (this.isGod) {
                this.aoc.setTextColor(aj.getColor(i, d.C0095d.cp_cont_r));
            } else {
                this.aoc.setTextColor(aj.getColor(i, d.C0095d.cp_cont_b));
            }
            setBackgroundColor(aj.getColor(i, d.C0095d.cp_bg_line_d));
            this.deo.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.den;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.deo;
    }

    public TextView getUsername() {
        return this.aoc;
    }

    public TextView getFansNum() {
        return this.dep;
    }
}

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
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.PbFirstFloorUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends LinearLayout {
    private TextView anF;
    private ClickableHeaderImageView cKB;
    private PbFirstFloorUserLikeButton cKC;
    private TextView cKD;
    private boolean isGod;
    private int mSkinType;

    public g(Context context) {
        super(context);
        this.isGod = false;
        this.mSkinType = -1;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.j.frs_user_recommend_item, (ViewGroup) this, true);
        this.cKB = (ClickableHeaderImageView) findViewById(d.h.user_recommend_head);
        this.cKB.setAutoChangeStyle(true);
        this.cKB.setDefaultResource(17170445);
        this.cKB.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cKB.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cKB.setIsRound(true);
        this.cKB.setScaleType(ImageView.ScaleType.FIT_XY);
        this.cKC = (PbFirstFloorUserLikeButton) findViewById(d.h.user_recommend_like_btn);
        this.cKC.setGravity(17);
        this.anF = (TextView) findViewById(d.h.user_recommend_username);
        this.cKD = (TextView) findViewById(d.h.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.cKB.onClick(g.this.cKB);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.anF.setTextColor(aj.getColor(this.mSkinType, d.e.cp_cont_r));
            } else {
                this.anF.setTextColor(aj.getColor(this.mSkinType, d.e.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.cKD.setTextColor(aj.getColor(i, d.e.cp_cont_d));
            if (this.isGod) {
                this.anF.setTextColor(aj.getColor(i, d.e.cp_cont_r));
            } else {
                this.anF.setTextColor(aj.getColor(i, d.e.cp_cont_b));
            }
            setBackgroundColor(aj.getColor(i, d.e.cp_bg_line_d));
            this.cKC.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.cKB;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.cKC;
    }

    public TextView getUsername() {
        return this.anF;
    }

    public TextView getFansNum() {
        return this.cKD;
    }
}

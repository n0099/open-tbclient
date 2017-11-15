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
    private TextView anN;
    private ClickableHeaderImageView cTU;
    private PbFirstFloorUserLikeButton cTV;
    private TextView cTW;
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
        this.cTU = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.cTU.setAutoChangeStyle(true);
        this.cTU.setDefaultResource(17170445);
        this.cTU.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cTU.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.cTU.setIsRound(true);
        this.cTU.setScaleType(ImageView.ScaleType.FIT_XY);
        this.cTV = (PbFirstFloorUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.cTV.setGravity(17);
        this.anN = (TextView) findViewById(d.g.user_recommend_username);
        this.cTW = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.cTU.onClick(g.this.cTU);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.anN.setTextColor(aj.getColor(this.mSkinType, d.C0080d.cp_cont_r));
            } else {
                this.anN.setTextColor(aj.getColor(this.mSkinType, d.C0080d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.cTW.setTextColor(aj.getColor(i, d.C0080d.cp_cont_d));
            if (this.isGod) {
                this.anN.setTextColor(aj.getColor(i, d.C0080d.cp_cont_r));
            } else {
                this.anN.setTextColor(aj.getColor(i, d.C0080d.cp_cont_b));
            }
            setBackgroundColor(aj.getColor(i, d.C0080d.cp_bg_line_d));
            this.cTV.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.cTU;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.cTV;
    }

    public TextView getUsername() {
        return this.anN;
    }

    public TextView getFansNum() {
        return this.cTW;
    }
}

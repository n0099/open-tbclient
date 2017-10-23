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
    private TextView ant;
    private ClickableHeaderImageView cKp;
    private PbFirstFloorUserLikeButton cKq;
    private TextView cKr;
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
        this.cKp = (ClickableHeaderImageView) findViewById(d.h.user_recommend_head);
        this.cKp.setAutoChangeStyle(true);
        this.cKp.setDefaultResource(17170445);
        this.cKp.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cKp.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cKp.setIsRound(true);
        this.cKp.setScaleType(ImageView.ScaleType.FIT_XY);
        this.cKq = (PbFirstFloorUserLikeButton) findViewById(d.h.user_recommend_like_btn);
        this.cKq.setGravity(17);
        this.ant = (TextView) findViewById(d.h.user_recommend_username);
        this.cKr = (TextView) findViewById(d.h.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.cKp.onClick(g.this.cKp);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.ant.setTextColor(aj.getColor(this.mSkinType, d.e.cp_cont_r));
            } else {
                this.ant.setTextColor(aj.getColor(this.mSkinType, d.e.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.cKr.setTextColor(aj.getColor(i, d.e.cp_cont_d));
            if (this.isGod) {
                this.ant.setTextColor(aj.getColor(i, d.e.cp_cont_r));
            } else {
                this.ant.setTextColor(aj.getColor(i, d.e.cp_cont_b));
            }
            setBackgroundColor(aj.getColor(i, d.e.cp_bg_line_d));
            this.cKq.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.cKp;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.cKq;
    }

    public TextView getUsername() {
        return this.ant;
    }

    public TextView getFansNum() {
        return this.cKr;
    }
}

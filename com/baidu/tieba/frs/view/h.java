package com.baidu.tieba.frs.view;

import android.content.Context;
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
/* loaded from: classes2.dex */
public class h extends LinearLayout {
    private TextView bci;
    private ClickableHeaderImageView dVH;
    private CardUserLikeButton dVI;
    private TextView dVJ;
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
        this.dVH = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.dVH.setAutoChangeStyle(true);
        this.dVH.setDefaultResource(17170445);
        this.dVH.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dVH.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.dVH.setIsRound(true);
        this.dVH.setScaleType(ImageView.ScaleType.FIT_XY);
        this.dVI = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.dVI.setGravity(17);
        this.bci = (TextView) findViewById(d.g.user_recommend_username);
        this.dVJ = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.dVH.onClick(h.this.dVH);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.bci.setTextColor(aj.getColor(this.mSkinType, d.C0108d.cp_cont_r));
            } else {
                this.bci.setTextColor(aj.getColor(this.mSkinType, d.C0108d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dVJ.setTextColor(aj.getColor(i, d.C0108d.cp_cont_d));
            if (this.isGod) {
                this.bci.setTextColor(aj.getColor(i, d.C0108d.cp_cont_r));
            } else {
                this.bci.setTextColor(aj.getColor(i, d.C0108d.cp_cont_b));
            }
            setBackgroundColor(aj.getColor(i, d.C0108d.cp_bg_line_d));
            this.dVI.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.dVH;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.dVI;
    }

    public TextView getUsername() {
        return this.bci;
    }

    public TextView getFansNum() {
        return this.dVJ;
    }
}

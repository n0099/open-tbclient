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
    private TextView bca;
    private TextView dQA;
    private ClickableHeaderImageView dQy;
    private CardUserLikeButton dQz;
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
        this.dQy = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.dQy.setAutoChangeStyle(true);
        this.dQy.setDefaultResource(17170445);
        this.dQy.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dQy.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.dQy.setIsRound(true);
        this.dQy.setScaleType(ImageView.ScaleType.FIT_XY);
        this.dQz = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.dQz.setGravity(17);
        this.bca = (TextView) findViewById(d.g.user_recommend_username);
        this.dQA = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.dQy.onClick(h.this.dQy);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.bca.setTextColor(aj.getColor(this.mSkinType, d.C0108d.cp_cont_r));
            } else {
                this.bca.setTextColor(aj.getColor(this.mSkinType, d.C0108d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dQA.setTextColor(aj.getColor(i, d.C0108d.cp_cont_d));
            if (this.isGod) {
                this.bca.setTextColor(aj.getColor(i, d.C0108d.cp_cont_r));
            } else {
                this.bca.setTextColor(aj.getColor(i, d.C0108d.cp_cont_b));
            }
            setBackgroundColor(aj.getColor(i, d.C0108d.cp_bg_line_d));
            this.dQz.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.dQy;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.dQz;
    }

    public TextView getUsername() {
        return this.bca;
    }

    public TextView getFansNum() {
        return this.dQA;
    }
}

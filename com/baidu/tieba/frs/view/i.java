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
public class i extends LinearLayout {
    private TextView bdM;
    private ClickableHeaderImageView dZI;
    private CardUserLikeButton dZJ;
    private TextView dZK;
    private boolean isGod;
    private int mSkinType;

    public i(Context context) {
        super(context);
        this.isGod = false;
        this.mSkinType = -1;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_user_recommend_item, (ViewGroup) this, true);
        this.dZI = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.dZI.setAutoChangeStyle(true);
        this.dZI.setDefaultResource(17170445);
        this.dZI.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dZI.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dZI.setIsRound(true);
        this.dZI.setScaleType(ImageView.ScaleType.FIT_XY);
        this.dZJ = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.dZJ.setGravity(17);
        this.bdM = (TextView) findViewById(d.g.user_recommend_username);
        this.dZK = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.dZI.onClick(i.this.dZI);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.bdM.setTextColor(aj.getColor(this.mSkinType, d.C0141d.cp_cont_r));
            } else {
                this.bdM.setTextColor(aj.getColor(this.mSkinType, d.C0141d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dZK.setTextColor(aj.getColor(i, d.C0141d.cp_cont_d));
            if (this.isGod) {
                this.bdM.setTextColor(aj.getColor(i, d.C0141d.cp_cont_r));
            } else {
                this.bdM.setTextColor(aj.getColor(i, d.C0141d.cp_cont_b));
            }
            setBackgroundColor(aj.getColor(i, d.C0141d.cp_bg_line_d));
            this.dZJ.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.dZI;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.dZJ;
    }

    public TextView getUsername() {
        return this.bdM;
    }

    public TextView getFansNum() {
        return this.dZK;
    }
}

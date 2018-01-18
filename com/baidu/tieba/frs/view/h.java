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
    private ClickableHeaderImageView dVm;
    private CardUserLikeButton dVn;
    private TextView dVo;
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
        this.dVm = (ClickableHeaderImageView) findViewById(d.g.user_recommend_head);
        this.dVm.setAutoChangeStyle(true);
        this.dVm.setDefaultResource(17170445);
        this.dVm.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dVm.setDefaultBgResource(d.C0107d.cp_bg_line_e);
        this.dVm.setIsRound(true);
        this.dVm.setScaleType(ImageView.ScaleType.FIT_XY);
        this.dVn = (CardUserLikeButton) findViewById(d.g.user_recommend_like_btn);
        this.dVn.setGravity(17);
        this.bca = (TextView) findViewById(d.g.user_recommend_username);
        this.dVo = (TextView) findViewById(d.g.user_recommend_fans_num);
        setOrientation(1);
        setFocusable(true);
        setClickable(true);
        setDescendantFocusability(262144);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.dVm.onClick(h.this.dVm);
            }
        });
    }

    public void setIsGod(boolean z) {
        if (this.isGod != z) {
            this.isGod = z;
            if (z) {
                this.bca.setTextColor(aj.getColor(this.mSkinType, d.C0107d.cp_cont_r));
            } else {
                this.bca.setTextColor(aj.getColor(this.mSkinType, d.C0107d.cp_cont_b));
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.dVo.setTextColor(aj.getColor(i, d.C0107d.cp_cont_d));
            if (this.isGod) {
                this.bca.setTextColor(aj.getColor(i, d.C0107d.cp_cont_r));
            } else {
                this.bca.setTextColor(aj.getColor(i, d.C0107d.cp_cont_b));
            }
            setBackgroundColor(aj.getColor(i, d.C0107d.cp_bg_line_d));
            this.dVn.onChangeSkinType(i);
        }
    }

    public ClickableHeaderImageView getHeaderView() {
        return this.dVm;
    }

    public CommonUserLikeButton getLikeBtn() {
        return this.dVn;
    }

    public TextView getUsername() {
        return this.bca;
    }

    public TextView getFansNum() {
        return this.dVo;
    }
}

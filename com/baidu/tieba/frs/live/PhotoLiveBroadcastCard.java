package com.baidu.tieba.frs.live;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PhotoLiveBroadcastCard extends FrameLayout {
    private GroupImageView baA;
    private ViewGroup baB;
    private TextView baC;
    private TextView baD;
    private TextView baE;
    private TextView baF;
    private TextView baG;
    private Context baz;

    public PhotoLiveBroadcastCard(Context context) {
        super(context);
        init(context, null);
    }

    public PhotoLiveBroadcastCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PhotoLiveBroadcastCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.baz = context;
        View inflate = LayoutInflater.from(context).inflate(i.g.frs_photolive_broadcast_view, this);
        this.baB = (ViewGroup) inflate.findViewById(i.f.photolive_broadcast);
        this.baA = (GroupImageView) inflate.findViewById(i.f.photolive_card_portrait);
        this.baA.setDrawBorder(true);
        this.baA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.baC = (TextView) inflate.findViewById(i.f.card_title);
        this.baD = (TextView) inflate.findViewById(i.f.card_updatetime);
        this.baE = (TextView) inflate.findViewById(i.f.card_forum);
        this.baF = (TextView) inflate.findViewById(i.f.tv_praise_num);
        this.baG = (TextView) inflate.findViewById(i.f.tv_reply_num);
        al.b(this.baC, i.c.cp_cont_b, 1);
        al.b(this.baD, i.c.cp_cont_c, 1);
        al.b(this.baE, i.c.cp_cont_d, 1);
        al.b(this.baF, i.c.cp_cont_d, 1);
        al.b(this.baG, i.c.cp_cont_d, 1);
        this.baF.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_hand_normal), (Drawable) null, (Drawable) null, (Drawable) null);
        this.baG.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setData(LiveCardData liveCardData) {
        String str;
        if (liveCardData != null) {
            if (!TextUtils.isEmpty(liveCardData.getPortrait())) {
                this.baA.d(liveCardData.getPortrait(), 10, false);
            } else if (!TextUtils.isEmpty(liveCardData.getPublisherPortrait())) {
                this.baA.d(liveCardData.getPublisherPortrait(), 12, false);
            } else {
                this.baA.d(null, 10, false);
                this.baA.d(null, 12, false);
            }
            if (!TextUtils.isEmpty(liveCardData.getTitle())) {
                this.baC.setText(liveCardData.getTitle());
            }
            if (liveCardData.getPostNum() > 0 && liveCardData.getLastModifiedTime() > 0) {
                this.baD.setText(this.baz.getResources().getString(i.h.pl_update_info, aq.m(liveCardData.getLastModifiedTime() * 1000), aq.o(liveCardData.getPostNum())));
            }
            if (!(StringUtils.isNull(liveCardData.getForumName()) ? false : true)) {
                str = "";
            } else {
                str = String.valueOf(liveCardData.getForumName()) + this.baz.getString(i.h.bar);
            }
            this.baE.setText(str);
            int zanNum = liveCardData.getZanNum();
            if (zanNum > 0) {
                this.baF.setVisibility(0);
                this.baF.setText(aq.o(zanNum));
            } else {
                this.baF.setVisibility(8);
            }
            int replyNum = liveCardData.getReplyNum();
            if (replyNum > 0) {
                this.baG.setVisibility(0);
                this.baG.setText(aq.o(replyNum));
                return;
            }
            this.baG.setVisibility(8);
        }
    }
}

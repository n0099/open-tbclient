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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PhotoLiveBroadcastCard extends FrameLayout {
    private Context baW;
    private GroupImageView baX;
    private ViewGroup baY;
    private TextView baZ;
    private TextView bba;
    private TextView bbb;
    private TextView bbc;
    private TextView bbd;

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
        this.baW = context;
        View inflate = LayoutInflater.from(context).inflate(i.g.frs_photolive_broadcast_view, this);
        this.baY = (ViewGroup) inflate.findViewById(i.f.photolive_broadcast);
        this.baX = (GroupImageView) inflate.findViewById(i.f.photolive_card_portrait);
        this.baX.setDrawBorder(true);
        this.baX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.baZ = (TextView) inflate.findViewById(i.f.card_title);
        this.bba = (TextView) inflate.findViewById(i.f.card_updatetime);
        this.bbb = (TextView) inflate.findViewById(i.f.card_forum);
        this.bbc = (TextView) inflate.findViewById(i.f.tv_praise_num);
        this.bbd = (TextView) inflate.findViewById(i.f.tv_reply_num);
        an.b(this.baZ, i.c.cp_cont_b, 1);
        an.b(this.bba, i.c.cp_cont_c, 1);
        an.b(this.bbb, i.c.cp_cont_d, 1);
        an.b(this.bbc, i.c.cp_cont_d, 1);
        an.b(this.bbd, i.c.cp_cont_d, 1);
        this.bbc.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_hand_normal), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bbd.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setData(LiveCardData liveCardData) {
        String str;
        if (liveCardData != null) {
            if (!TextUtils.isEmpty(liveCardData.getPortrait())) {
                this.baX.d(liveCardData.getPortrait(), 10, false);
            } else if (!TextUtils.isEmpty(liveCardData.getPublisherPortrait())) {
                this.baX.d(liveCardData.getPublisherPortrait(), 12, false);
            } else {
                this.baX.d(null, 10, false);
                this.baX.d(null, 12, false);
            }
            if (!TextUtils.isEmpty(liveCardData.getTitle())) {
                this.baZ.setText(liveCardData.getTitle());
            }
            if (liveCardData.getPostNum() > 0 && liveCardData.getLastModifiedTime() > 0) {
                this.bba.setText(this.baW.getResources().getString(i.h.pl_update_info, as.m(liveCardData.getLastModifiedTime() * 1000), as.q(liveCardData.getPostNum())));
            }
            if (!(StringUtils.isNull(liveCardData.getForumName()) ? false : true)) {
                str = "";
            } else {
                str = String.valueOf(liveCardData.getForumName()) + this.baW.getString(i.h.bar);
            }
            this.bbb.setText(str);
            int zanNum = liveCardData.getZanNum();
            if (zanNum > 0) {
                this.bbc.setVisibility(0);
                this.bbc.setText(as.q(zanNum));
            } else {
                this.bbc.setVisibility(8);
            }
            int replyNum = liveCardData.getReplyNum();
            if (replyNum > 0) {
                this.bbd.setVisibility(0);
                this.bbd.setText(as.q(replyNum));
                return;
            }
            this.bbd.setVisibility(8);
        }
    }
}

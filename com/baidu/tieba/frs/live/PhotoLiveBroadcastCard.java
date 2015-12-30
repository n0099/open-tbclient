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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PhotoLiveBroadcastCard extends FrameLayout {
    private Context blp;
    private GroupImageView blq;
    private ViewGroup blr;
    private TextView bls;
    private TextView blt;
    private TextView blu;
    private TextView blv;
    private TextView blw;

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
        this.blp = context;
        View inflate = LayoutInflater.from(context).inflate(n.h.frs_photolive_broadcast_view, this);
        this.blr = (ViewGroup) inflate.findViewById(n.g.photolive_broadcast);
        this.blq = (GroupImageView) inflate.findViewById(n.g.photolive_card_portrait);
        this.blq.setDrawBorder(true);
        this.blq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bls = (TextView) inflate.findViewById(n.g.card_title);
        this.blt = (TextView) inflate.findViewById(n.g.card_updatetime);
        this.blu = (TextView) inflate.findViewById(n.g.card_forum);
        this.blv = (TextView) inflate.findViewById(n.g.tv_praise_num);
        this.blw = (TextView) inflate.findViewById(n.g.tv_reply_num);
        as.b(this.bls, n.d.cp_cont_b, 1);
        as.b(this.blt, n.d.cp_cont_c, 1);
        as.b(this.blu, n.d.cp_cont_d, 1);
        as.b(this.blv, n.d.cp_cont_d, 1);
        as.b(this.blw, n.d.cp_cont_d, 1);
        this.blv.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_hand_normal), (Drawable) null, (Drawable) null, (Drawable) null);
        this.blw.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setData(LiveCardData liveCardData) {
        String str;
        if (liveCardData != null) {
            if (!TextUtils.isEmpty(liveCardData.getPortrait())) {
                this.blq.d(liveCardData.getPortrait(), 10, false);
            } else if (!TextUtils.isEmpty(liveCardData.getPublisherPortrait())) {
                this.blq.d(liveCardData.getPublisherPortrait(), 12, false);
            } else {
                this.blq.d(null, 10, false);
                this.blq.d(null, 12, false);
            }
            if (!TextUtils.isEmpty(liveCardData.getTitle())) {
                this.bls.setText(liveCardData.getTitle());
            }
            if (liveCardData.getPostNum() > 0 && liveCardData.getLastModifiedTime() > 0) {
                this.blt.setText(this.blp.getResources().getString(n.j.pl_update_info, ax.s(liveCardData.getLastModifiedTime() * 1000), ax.x(liveCardData.getPostNum())));
            }
            if (!(StringUtils.isNull(liveCardData.getForumName()) ? false : true)) {
                str = "";
            } else {
                str = String.valueOf(liveCardData.getForumName()) + this.blp.getString(n.j.bar);
            }
            this.blu.setText(str);
            int zanNum = liveCardData.getZanNum();
            if (zanNum > 0) {
                this.blv.setVisibility(0);
                this.blv.setText(ax.x(zanNum));
            } else {
                this.blv.setVisibility(8);
            }
            int replyNum = liveCardData.getReplyNum();
            if (replyNum > 0) {
                this.blw.setVisibility(0);
                this.blw.setText(ax.x(replyNum));
                return;
            }
            this.blw.setVisibility(8);
        }
    }
}

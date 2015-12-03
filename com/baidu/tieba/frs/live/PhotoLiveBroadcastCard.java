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
    private ViewGroup bhA;
    private TextView bhB;
    private TextView bhC;
    private TextView bhD;
    private TextView bhE;
    private TextView bhF;
    private Context bhy;
    private GroupImageView bhz;

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
        this.bhy = context;
        View inflate = LayoutInflater.from(context).inflate(n.g.frs_photolive_broadcast_view, this);
        this.bhA = (ViewGroup) inflate.findViewById(n.f.photolive_broadcast);
        this.bhz = (GroupImageView) inflate.findViewById(n.f.photolive_card_portrait);
        this.bhz.setDrawBorder(true);
        this.bhz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bhB = (TextView) inflate.findViewById(n.f.card_title);
        this.bhC = (TextView) inflate.findViewById(n.f.card_updatetime);
        this.bhD = (TextView) inflate.findViewById(n.f.card_forum);
        this.bhE = (TextView) inflate.findViewById(n.f.tv_praise_num);
        this.bhF = (TextView) inflate.findViewById(n.f.tv_reply_num);
        as.b(this.bhB, n.c.cp_cont_b, 1);
        as.b(this.bhC, n.c.cp_cont_c, 1);
        as.b(this.bhD, n.c.cp_cont_d, 1);
        as.b(this.bhE, n.c.cp_cont_d, 1);
        as.b(this.bhF, n.c.cp_cont_d, 1);
        this.bhE.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_hand_normal), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bhF.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setData(LiveCardData liveCardData) {
        String str;
        if (liveCardData != null) {
            if (!TextUtils.isEmpty(liveCardData.getPortrait())) {
                this.bhz.d(liveCardData.getPortrait(), 10, false);
            } else if (!TextUtils.isEmpty(liveCardData.getPublisherPortrait())) {
                this.bhz.d(liveCardData.getPublisherPortrait(), 12, false);
            } else {
                this.bhz.d(null, 10, false);
                this.bhz.d(null, 12, false);
            }
            if (!TextUtils.isEmpty(liveCardData.getTitle())) {
                this.bhB.setText(liveCardData.getTitle());
            }
            if (liveCardData.getPostNum() > 0 && liveCardData.getLastModifiedTime() > 0) {
                this.bhC.setText(this.bhy.getResources().getString(n.i.pl_update_info, ax.s(liveCardData.getLastModifiedTime() * 1000), ax.w(liveCardData.getPostNum())));
            }
            if (!(StringUtils.isNull(liveCardData.getForumName()) ? false : true)) {
                str = "";
            } else {
                str = String.valueOf(liveCardData.getForumName()) + this.bhy.getString(n.i.bar);
            }
            this.bhD.setText(str);
            int zanNum = liveCardData.getZanNum();
            if (zanNum > 0) {
                this.bhE.setVisibility(0);
                this.bhE.setText(ax.w(zanNum));
            } else {
                this.bhE.setVisibility(8);
            }
            int replyNum = liveCardData.getReplyNum();
            if (replyNum > 0) {
                this.bhF.setVisibility(0);
                this.bhF.setText(ax.w(replyNum));
                return;
            }
            this.bhF.setVisibility(8);
        }
    }
}

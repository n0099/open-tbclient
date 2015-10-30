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
    private Context baD;
    private GroupImageView baE;
    private ViewGroup baF;
    private TextView baG;
    private TextView baH;
    private TextView baI;
    private TextView baJ;
    private TextView baK;

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
        this.baD = context;
        View inflate = LayoutInflater.from(context).inflate(i.g.frs_photolive_broadcast_view, this);
        this.baF = (ViewGroup) inflate.findViewById(i.f.photolive_broadcast);
        this.baE = (GroupImageView) inflate.findViewById(i.f.photolive_card_portrait);
        this.baE.setDrawBorder(true);
        this.baE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.baG = (TextView) inflate.findViewById(i.f.card_title);
        this.baH = (TextView) inflate.findViewById(i.f.card_updatetime);
        this.baI = (TextView) inflate.findViewById(i.f.card_forum);
        this.baJ = (TextView) inflate.findViewById(i.f.tv_praise_num);
        this.baK = (TextView) inflate.findViewById(i.f.tv_reply_num);
        an.b(this.baG, i.c.cp_cont_b, 1);
        an.b(this.baH, i.c.cp_cont_c, 1);
        an.b(this.baI, i.c.cp_cont_d, 1);
        an.b(this.baJ, i.c.cp_cont_d, 1);
        an.b(this.baK, i.c.cp_cont_d, 1);
        this.baJ.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_hand_normal), (Drawable) null, (Drawable) null, (Drawable) null);
        this.baK.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setData(LiveCardData liveCardData) {
        String str;
        if (liveCardData != null) {
            if (!TextUtils.isEmpty(liveCardData.getPortrait())) {
                this.baE.d(liveCardData.getPortrait(), 10, false);
            } else if (!TextUtils.isEmpty(liveCardData.getPublisherPortrait())) {
                this.baE.d(liveCardData.getPublisherPortrait(), 12, false);
            } else {
                this.baE.d(null, 10, false);
                this.baE.d(null, 12, false);
            }
            if (!TextUtils.isEmpty(liveCardData.getTitle())) {
                this.baG.setText(liveCardData.getTitle());
            }
            if (liveCardData.getPostNum() > 0 && liveCardData.getLastModifiedTime() > 0) {
                this.baH.setText(this.baD.getResources().getString(i.h.pl_update_info, as.m(liveCardData.getLastModifiedTime() * 1000), as.q(liveCardData.getPostNum())));
            }
            if (!(StringUtils.isNull(liveCardData.getForumName()) ? false : true)) {
                str = "";
            } else {
                str = String.valueOf(liveCardData.getForumName()) + this.baD.getString(i.h.bar);
            }
            this.baI.setText(str);
            int zanNum = liveCardData.getZanNum();
            if (zanNum > 0) {
                this.baJ.setVisibility(0);
                this.baJ.setText(as.q(zanNum));
            } else {
                this.baJ.setVisibility(8);
            }
            int replyNum = liveCardData.getReplyNum();
            if (replyNum > 0) {
                this.baK.setVisibility(0);
                this.baK.setText(as.q(replyNum));
                return;
            }
            this.baK.setVisibility(8);
        }
    }
}

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PhotoLiveBroadcastCard extends FrameLayout {
    private Context bas;
    private GroupImageView bat;
    private ViewGroup bau;
    private TextView bav;
    private TextView baw;
    private TextView bax;
    private TextView bay;
    private TextView baz;

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
        this.bas = context;
        View inflate = LayoutInflater.from(context).inflate(i.g.frs_photolive_broadcast_view, this);
        this.bau = (ViewGroup) inflate.findViewById(i.f.photolive_broadcast);
        this.bat = (GroupImageView) inflate.findViewById(i.f.photolive_card_portrait);
        this.bat.setDrawBorder(true);
        this.bat.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bav = (TextView) inflate.findViewById(i.f.card_title);
        this.baw = (TextView) inflate.findViewById(i.f.card_updatetime);
        this.bax = (TextView) inflate.findViewById(i.f.card_forum);
        this.bay = (TextView) inflate.findViewById(i.f.tv_praise_num);
        this.baz = (TextView) inflate.findViewById(i.f.tv_reply_num);
        am.b(this.bav, i.c.cp_cont_b, 1);
        am.b(this.baw, i.c.cp_cont_c, 1);
        am.b(this.bax, i.c.cp_cont_d, 1);
        am.b(this.bay, i.c.cp_cont_d, 1);
        am.b(this.baz, i.c.cp_cont_d, 1);
        this.bay.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_hand_normal), (Drawable) null, (Drawable) null, (Drawable) null);
        this.baz.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setData(LiveCardData liveCardData) {
        String str;
        if (liveCardData != null) {
            if (!TextUtils.isEmpty(liveCardData.getPortrait())) {
                this.bat.d(liveCardData.getPortrait(), 10, false);
            } else if (!TextUtils.isEmpty(liveCardData.getPublisherPortrait())) {
                this.bat.d(liveCardData.getPublisherPortrait(), 12, false);
            } else {
                this.bat.d(null, 10, false);
                this.bat.d(null, 12, false);
            }
            if (!TextUtils.isEmpty(liveCardData.getTitle())) {
                this.bav.setText(liveCardData.getTitle());
            }
            if (liveCardData.getPostNum() > 0 && liveCardData.getLastModifiedTime() > 0) {
                this.baw.setText(this.bas.getResources().getString(i.h.pl_update_info, ar.o(liveCardData.getLastModifiedTime() * 1000), ar.s(liveCardData.getPostNum())));
            }
            if (!(StringUtils.isNull(liveCardData.getForumName()) ? false : true)) {
                str = "";
            } else {
                str = String.valueOf(liveCardData.getForumName()) + this.bas.getString(i.h.bar);
            }
            this.bax.setText(str);
            int zanNum = liveCardData.getZanNum();
            if (zanNum > 0) {
                this.bay.setVisibility(0);
                this.bay.setText(ar.s(zanNum));
            } else {
                this.bay.setVisibility(8);
            }
            int replyNum = liveCardData.getReplyNum();
            if (replyNum > 0) {
                this.baz.setVisibility(0);
                this.baz.setText(ar.s(replyNum));
                return;
            }
            this.baz.setVisibility(8);
        }
    }
}

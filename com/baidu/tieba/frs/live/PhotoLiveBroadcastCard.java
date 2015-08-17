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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PhotoLiveBroadcastCard extends FrameLayout {
    private Context bae;
    private GroupImageView baf;
    private ViewGroup bag;
    private TextView bah;
    private TextView bai;
    private TextView baj;
    private TextView bak;
    private TextView bal;

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
        this.bae = context;
        View inflate = LayoutInflater.from(context).inflate(i.g.frs_photolive_broadcast_view, this);
        this.bag = (ViewGroup) inflate.findViewById(i.f.photolive_broadcast);
        this.baf = (GroupImageView) inflate.findViewById(i.f.photolive_card_portrait);
        this.baf.setDrawBorder(true);
        this.baf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bah = (TextView) inflate.findViewById(i.f.card_title);
        this.bai = (TextView) inflate.findViewById(i.f.card_updatetime);
        this.baj = (TextView) inflate.findViewById(i.f.card_forum);
        this.bak = (TextView) inflate.findViewById(i.f.tv_praise_num);
        this.bal = (TextView) inflate.findViewById(i.f.tv_reply_num);
        al.b(this.bah, i.c.cp_cont_b, 1);
        al.b(this.bai, i.c.cp_cont_c, 1);
        al.b(this.baj, i.c.cp_cont_d, 1);
        this.bak.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_hand_normal), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bal.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setData(LiveCardData liveCardData) {
        String str;
        if (liveCardData != null) {
            if (!TextUtils.isEmpty(liveCardData.getPortrait())) {
                this.baf.d(liveCardData.getPortrait(), 10, false);
            } else if (!TextUtils.isEmpty(liveCardData.getPublisherPortrait())) {
                this.baf.d(liveCardData.getPublisherPortrait(), 12, false);
            } else {
                this.baf.d(null, 10, false);
                this.baf.d(null, 12, false);
            }
            if (!TextUtils.isEmpty(liveCardData.getTitle())) {
                this.bah.setText(liveCardData.getTitle());
            }
            if (liveCardData.getPostNum() > 0 && liveCardData.getLastModifiedTime() > 0) {
                this.bai.setText(this.bae.getResources().getString(i.C0057i.frs_sign_success, aq.m(liveCardData.getLastModifiedTime() * 1000), Long.valueOf(liveCardData.getPostNum())));
            }
            if (!(StringUtils.isNull(liveCardData.getForumName()) ? false : true)) {
                str = "";
            } else {
                str = UtilHelper.getFixedText(String.valueOf(liveCardData.getForumName()) + this.bae.getString(i.C0057i.bar), 7);
            }
            this.baj.setText(str);
            int zanNum = liveCardData.getZanNum();
            if (zanNum > 0) {
                this.bak.setVisibility(0);
                this.bak.setText(aq.o(zanNum));
            } else {
                this.bak.setVisibility(8);
            }
            int replyNum = liveCardData.getReplyNum();
            if (replyNum > 0) {
                this.bal.setVisibility(0);
                this.bal.setText(aq.o(replyNum));
                return;
            }
            this.bal.setVisibility(8);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this.bag);
    }
}

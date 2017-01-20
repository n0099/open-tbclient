package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView bAy;
    private ChatClipImageItemView cQd;
    private LinearLayout cQe;
    private TextView cQf;

    public ChatImageWithTailView(Context context) {
        super(context);
        aT(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aT(context);
    }

    public void aT(Context context) {
        LayoutInflater.from(context).inflate(r.j.chat_image_with_tail_item, this);
        this.cQd = (ChatClipImageItemView) findViewById(r.h.img_msgitem_image_new);
        this.cQd.setContentDescription(getContext().getString(r.l.talk_pic));
        this.cQd.setDefaultResource(r.g.pic_image_h_not);
        this.cQe = (LinearLayout) findViewById(r.h.small_tail);
        this.bAy = (TbImageView) findViewById(r.h.tail_icon);
        this.bAy.setDefaultResource(r.g.icon);
        this.bAy.setAutoChangeStyle(false);
        this.cQf = (TextView) findViewById(r.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cQd;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cQd = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cQe;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cQe = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bAy;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bAy = tbImageView;
    }

    public TextView getFromSource() {
        return this.cQf;
    }

    public void setFromSource(TextView textView) {
        this.cQf = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bAy.setAutoChangeStyle(z);
    }
}

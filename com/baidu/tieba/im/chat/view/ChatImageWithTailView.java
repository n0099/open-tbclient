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
    private TbImageView bMI;
    private ChatClipImageItemView deb;
    private LinearLayout dec;
    private TextView ded;

    public ChatImageWithTailView(Context context) {
        super(context);
        aO(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aO(context);
    }

    public void aO(Context context) {
        LayoutInflater.from(context).inflate(r.h.chat_image_with_tail_item, this);
        this.deb = (ChatClipImageItemView) findViewById(r.g.img_msgitem_image_new);
        this.deb.setContentDescription(getContext().getString(r.j.talk_pic));
        this.deb.setDefaultResource(r.f.pic_image_h_not);
        this.dec = (LinearLayout) findViewById(r.g.small_tail);
        this.bMI = (TbImageView) findViewById(r.g.tail_icon);
        this.bMI.setDefaultResource(r.f.icon);
        this.bMI.setAutoChangeStyle(false);
        this.ded = (TextView) findViewById(r.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.deb;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.deb = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dec;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dec = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bMI;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bMI = tbImageView;
    }

    public TextView getFromSource() {
        return this.ded;
    }

    public void setFromSource(TextView textView) {
        this.ded = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bMI.setAutoChangeStyle(z);
    }
}

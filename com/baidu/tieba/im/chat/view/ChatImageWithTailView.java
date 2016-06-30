package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView bvY;
    private ChatClipImageItemView cIw;
    private LinearLayout cIx;
    private TextView cIy;

    public ChatImageWithTailView(Context context) {
        super(context);
        ar(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ar(context);
    }

    public void ar(Context context) {
        LayoutInflater.from(context).inflate(u.h.chat_image_with_tail_item, this);
        this.cIw = (ChatClipImageItemView) findViewById(u.g.img_msgitem_image_new);
        this.cIw.setContentDescription(getContext().getString(u.j.talk_pic));
        this.cIw.setDefaultResource(u.f.pic_image_h_not);
        this.cIx = (LinearLayout) findViewById(u.g.small_tail);
        this.bvY = (TbImageView) findViewById(u.g.tail_icon);
        this.bvY.setDefaultResource(u.f.icon);
        this.bvY.setAutoChangeStyle(false);
        this.cIy = (TextView) findViewById(u.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cIw;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cIw = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cIx;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cIx = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bvY;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bvY = tbImageView;
    }

    public TextView getFromSource() {
        return this.cIy;
    }

    public void setFromSource(TextView textView) {
        this.cIy = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bvY.setAutoChangeStyle(z);
    }
}

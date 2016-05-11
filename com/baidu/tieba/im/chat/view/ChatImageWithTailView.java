package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView bab;
    private ChatClipImageItemView cda;
    private LinearLayout cdb;
    private TextView cdc;

    public ChatImageWithTailView(Context context) {
        super(context);
        ar(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ar(context);
    }

    public void ar(Context context) {
        LayoutInflater.from(context).inflate(t.h.chat_image_with_tail_item, this);
        this.cda = (ChatClipImageItemView) findViewById(t.g.img_msgitem_image_new);
        this.cda.setContentDescription(getContext().getString(t.j.talk_pic));
        this.cda.setDefaultResource(t.f.pic_image_h_not);
        this.cdb = (LinearLayout) findViewById(t.g.small_tail);
        this.bab = (TbImageView) findViewById(t.g.tail_icon);
        this.bab.setDefaultResource(t.f.icon);
        this.bab.setAutoChangeStyle(false);
        this.cdc = (TextView) findViewById(t.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cda;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cda = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cdb;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cdb = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bab;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bab = tbImageView;
    }

    public TextView getFromSource() {
        return this.cdc;
    }

    public void setFromSource(TextView textView) {
        this.cdc = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bab.setAutoChangeStyle(z);
    }
}

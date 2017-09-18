package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView cgx;
    private ChatClipImageItemView dtY;
    private LinearLayout dtZ;
    private TextView dua;

    public ChatImageWithTailView(Context context) {
        super(context);
        bt(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bt(context);
    }

    public void bt(Context context) {
        LayoutInflater.from(context).inflate(d.j.chat_image_with_tail_item, this);
        this.dtY = (ChatClipImageItemView) findViewById(d.h.img_msgitem_image_new);
        this.dtY.setContentDescription(getContext().getString(d.l.editor_image));
        this.dtY.setDefaultResource(d.g.pic_image_h_not);
        this.dtZ = (LinearLayout) findViewById(d.h.small_tail);
        this.cgx = (TbImageView) findViewById(d.h.tail_icon);
        this.cgx.setDefaultResource(d.g.icon);
        this.cgx.setAutoChangeStyle(false);
        this.dua = (TextView) findViewById(d.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dtY;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dtY = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dtZ;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dtZ = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cgx;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cgx = tbImageView;
    }

    public TextView getFromSource() {
        return this.dua;
    }

    public void setFromSource(TextView textView) {
        this.dua = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cgx.setAutoChangeStyle(z);
    }
}

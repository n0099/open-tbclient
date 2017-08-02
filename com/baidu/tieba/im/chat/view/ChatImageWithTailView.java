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
    private TbImageView cap;
    private ChatClipImageItemView djl;
    private LinearLayout djm;
    private TextView djn;

    public ChatImageWithTailView(Context context) {
        super(context);
        bk(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bk(context);
    }

    public void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.chat_image_with_tail_item, this);
        this.djl = (ChatClipImageItemView) findViewById(d.h.img_msgitem_image_new);
        this.djl.setContentDescription(getContext().getString(d.l.editor_image));
        this.djl.setDefaultResource(d.g.pic_image_h_not);
        this.djm = (LinearLayout) findViewById(d.h.small_tail);
        this.cap = (TbImageView) findViewById(d.h.tail_icon);
        this.cap.setDefaultResource(d.g.icon);
        this.cap.setAutoChangeStyle(false);
        this.djn = (TextView) findViewById(d.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.djl;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.djl = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.djm;
    }

    public void setTail(LinearLayout linearLayout) {
        this.djm = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cap;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cap = tbImageView;
    }

    public TextView getFromSource() {
        return this.djn;
    }

    public void setFromSource(TextView textView) {
        this.djn = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cap.setAutoChangeStyle(z);
    }
}

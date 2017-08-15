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
    private TbImageView cch;
    private ChatClipImageItemView dmA;
    private LinearLayout dmB;
    private TextView dmC;

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
        this.dmA = (ChatClipImageItemView) findViewById(d.h.img_msgitem_image_new);
        this.dmA.setContentDescription(getContext().getString(d.l.editor_image));
        this.dmA.setDefaultResource(d.g.pic_image_h_not);
        this.dmB = (LinearLayout) findViewById(d.h.small_tail);
        this.cch = (TbImageView) findViewById(d.h.tail_icon);
        this.cch.setDefaultResource(d.g.icon);
        this.cch.setAutoChangeStyle(false);
        this.dmC = (TextView) findViewById(d.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dmA;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dmA = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dmB;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dmB = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cch;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cch = tbImageView;
    }

    public TextView getFromSource() {
        return this.dmC;
    }

    public void setFromSource(TextView textView) {
        this.dmC = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cch.setAutoChangeStyle(z);
    }
}

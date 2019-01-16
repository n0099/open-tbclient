package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView dvh;
    private ChatClipImageItemView eOS;
    private LinearLayout eOT;
    private TextView eOU;

    public ChatImageWithTailView(Context context) {
        super(context);
        cr(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cr(context);
    }

    public void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.chat_image_with_tail_item, this);
        this.eOS = (ChatClipImageItemView) findViewById(e.g.img_msgitem_image_new);
        this.eOS.setContentDescription(getContext().getString(e.j.editor_image));
        this.eOS.setDefaultResource(e.f.pic_image_h_not);
        this.eOT = (LinearLayout) findViewById(e.g.small_tail);
        this.dvh = (TbImageView) findViewById(e.g.tail_icon);
        this.dvh.setDefaultResource(e.f.icon);
        this.dvh.setAutoChangeStyle(false);
        this.eOU = (TextView) findViewById(e.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.eOS;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.eOS = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.eOT;
    }

    public void setTail(LinearLayout linearLayout) {
        this.eOT = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dvh;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dvh = tbImageView;
    }

    public TextView getFromSource() {
        return this.eOU;
    }

    public void setFromSource(TextView textView) {
        this.eOU = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dvh.setAutoChangeStyle(z);
    }
}

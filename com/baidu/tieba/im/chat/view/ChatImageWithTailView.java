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
    private TbImageView cWe;
    private ChatClipImageItemView eoc;
    private LinearLayout eod;
    private TextView eoe;

    public ChatImageWithTailView(Context context) {
        super(context);
        by(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        by(context);
    }

    public void by(Context context) {
        LayoutInflater.from(context).inflate(d.h.chat_image_with_tail_item, this);
        this.eoc = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.eoc.setContentDescription(getContext().getString(d.j.editor_image));
        this.eoc.setDefaultResource(d.f.pic_image_h_not);
        this.eod = (LinearLayout) findViewById(d.g.small_tail);
        this.cWe = (TbImageView) findViewById(d.g.tail_icon);
        this.cWe.setDefaultResource(d.f.icon);
        this.cWe.setAutoChangeStyle(false);
        this.eoe = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.eoc;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.eoc = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.eod;
    }

    public void setTail(LinearLayout linearLayout) {
        this.eod = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cWe;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cWe = tbImageView;
    }

    public TextView getFromSource() {
        return this.eoe;
    }

    public void setFromSource(TextView textView) {
        this.eoe = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cWe.setAutoChangeStyle(z);
    }
}

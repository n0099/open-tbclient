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
    private TbImageView duy;
    private ChatClipImageItemView eOg;
    private LinearLayout eOh;
    private TextView eOi;

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
        this.eOg = (ChatClipImageItemView) findViewById(e.g.img_msgitem_image_new);
        this.eOg.setContentDescription(getContext().getString(e.j.editor_image));
        this.eOg.setDefaultResource(e.f.pic_image_h_not);
        this.eOh = (LinearLayout) findViewById(e.g.small_tail);
        this.duy = (TbImageView) findViewById(e.g.tail_icon);
        this.duy.setDefaultResource(e.f.icon);
        this.duy.setAutoChangeStyle(false);
        this.eOi = (TextView) findViewById(e.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.eOg;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.eOg = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.eOh;
    }

    public void setTail(LinearLayout linearLayout) {
        this.eOh = linearLayout;
    }

    public TbImageView getIcon() {
        return this.duy;
    }

    public void setIcon(TbImageView tbImageView) {
        this.duy = tbImageView;
    }

    public TextView getFromSource() {
        return this.eOi;
    }

    public void setFromSource(TextView textView) {
        this.eOi = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.duy.setAutoChangeStyle(z);
    }
}

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
    private TbImageView dsx;
    private ChatClipImageItemView ezs;
    private LinearLayout ezt;
    private TextView ezu;

    public ChatImageWithTailView(Context context) {
        super(context);
        bA(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bA(context);
    }

    public void bA(Context context) {
        LayoutInflater.from(context).inflate(d.h.chat_image_with_tail_item, this);
        this.ezs = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.ezs.setContentDescription(getContext().getString(d.j.editor_image));
        this.ezs.setDefaultResource(d.f.pic_image_h_not);
        this.ezt = (LinearLayout) findViewById(d.g.small_tail);
        this.dsx = (TbImageView) findViewById(d.g.tail_icon);
        this.dsx.setDefaultResource(d.f.icon);
        this.dsx.setAutoChangeStyle(false);
        this.ezu = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.ezs;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.ezs = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.ezt;
    }

    public void setTail(LinearLayout linearLayout) {
        this.ezt = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dsx;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dsx = tbImageView;
    }

    public TextView getFromSource() {
        return this.ezu;
    }

    public void setFromSource(TextView textView) {
        this.ezu = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dsx.setAutoChangeStyle(z);
    }
}

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
    private TbImageView dso;
    private ChatClipImageItemView ezw;
    private LinearLayout ezx;
    private TextView ezy;

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
        this.ezw = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.ezw.setContentDescription(getContext().getString(d.j.editor_image));
        this.ezw.setDefaultResource(d.f.pic_image_h_not);
        this.ezx = (LinearLayout) findViewById(d.g.small_tail);
        this.dso = (TbImageView) findViewById(d.g.tail_icon);
        this.dso.setDefaultResource(d.f.icon);
        this.dso.setAutoChangeStyle(false);
        this.ezy = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.ezw;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.ezw = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.ezx;
    }

    public void setTail(LinearLayout linearLayout) {
        this.ezx = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dso;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dso = tbImageView;
    }

    public TextView getFromSource() {
        return this.ezy;
    }

    public void setFromSource(TextView textView) {
        this.ezy = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dso.setAutoChangeStyle(z);
    }
}

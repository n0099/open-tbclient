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
    private TbImageView dsl;
    private ChatClipImageItemView ezg;
    private LinearLayout ezh;
    private TextView ezi;

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
        this.ezg = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.ezg.setContentDescription(getContext().getString(d.j.editor_image));
        this.ezg.setDefaultResource(d.f.pic_image_h_not);
        this.ezh = (LinearLayout) findViewById(d.g.small_tail);
        this.dsl = (TbImageView) findViewById(d.g.tail_icon);
        this.dsl.setDefaultResource(d.f.icon);
        this.dsl.setAutoChangeStyle(false);
        this.ezi = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.ezg;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.ezg = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.ezh;
    }

    public void setTail(LinearLayout linearLayout) {
        this.ezh = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dsl;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dsl = tbImageView;
    }

    public TextView getFromSource() {
        return this.ezi;
    }

    public void setFromSource(TextView textView) {
        this.ezi = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dsl.setAutoChangeStyle(z);
    }
}

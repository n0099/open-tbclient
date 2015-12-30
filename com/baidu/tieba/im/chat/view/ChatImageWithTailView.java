package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView aXo;
    private ChatClipImageItemView bNT;
    private LinearLayout bNU;
    private TextView bNV;

    public ChatImageWithTailView(Context context) {
        super(context);
        as(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        as(context);
    }

    public void as(Context context) {
        LayoutInflater.from(context).inflate(n.h.chat_image_with_tail_item, this);
        this.bNT = (ChatClipImageItemView) findViewById(n.g.img_msgitem_image_new);
        this.bNT.setDefaultResource(n.f.pic_image_h_not);
        this.bNU = (LinearLayout) findViewById(n.g.small_tail);
        this.aXo = (TbImageView) findViewById(n.g.tail_icon);
        this.aXo.setDefaultResource(n.f.icon);
        this.aXo.setAutoChangeStyle(false);
        this.bNV = (TextView) findViewById(n.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.bNT;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.bNT = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.bNU;
    }

    public void setTail(LinearLayout linearLayout) {
        this.bNU = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aXo;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aXo = tbImageView;
    }

    public TextView getFromSource() {
        return this.bNV;
    }

    public void setFromSource(TextView textView) {
        this.bNV = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aXo.setAutoChangeStyle(z);
    }
}

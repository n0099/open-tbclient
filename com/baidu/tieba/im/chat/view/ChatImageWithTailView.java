package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView aOj;
    private ChatClipImageItemView bvg;
    private LinearLayout bvh;
    private TextView bvi;

    public ChatImageWithTailView(Context context) {
        super(context);
        as(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        as(context);
    }

    public void as(Context context) {
        LayoutInflater.from(context).inflate(i.g.chat_image_with_tail_item, this);
        this.bvg = (ChatClipImageItemView) findViewById(i.f.img_msgitem_image_new);
        this.bvg.setDefaultResource(i.e.pic_image_h_not);
        this.bvh = (LinearLayout) findViewById(i.f.small_tail);
        this.aOj = (TbImageView) findViewById(i.f.tail_icon);
        this.aOj.setDefaultResource(i.e.icon);
        this.aOj.setAutoChangeStyle(false);
        this.bvi = (TextView) findViewById(i.f.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.bvg;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.bvg = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.bvh;
    }

    public void setTail(LinearLayout linearLayout) {
        this.bvh = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aOj;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aOj = tbImageView;
    }

    public TextView getFromSource() {
        return this.bvi;
    }

    public void setFromSource(TextView textView) {
        this.bvi = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aOj.setAutoChangeStyle(z);
    }
}

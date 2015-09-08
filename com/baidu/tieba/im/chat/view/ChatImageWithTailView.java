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
    private TbImageView aOU;
    private ChatClipImageItemView brt;
    private LinearLayout bru;
    private TextView brv;

    public ChatImageWithTailView(Context context) {
        super(context);
        aA(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aA(context);
    }

    public void aA(Context context) {
        LayoutInflater.from(context).inflate(i.g.chat_image_with_tail_item, this);
        this.brt = (ChatClipImageItemView) findViewById(i.f.img_msgitem_image_new);
        this.brt.setDefaultResource(i.e.pic_image_h_not);
        this.bru = (LinearLayout) findViewById(i.f.small_tail);
        this.aOU = (TbImageView) findViewById(i.f.tail_icon);
        this.aOU.setDefaultResource(i.e.icon);
        this.aOU.setAutoChangeStyle(false);
        this.brv = (TextView) findViewById(i.f.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.brt;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.brt = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.bru;
    }

    public void setTail(LinearLayout linearLayout) {
        this.bru = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aOU;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aOU = tbImageView;
    }

    public TextView getFromSource() {
        return this.brv;
    }

    public void setFromSource(TextView textView) {
        this.brv = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aOU.setAutoChangeStyle(z);
    }
}

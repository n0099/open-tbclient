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
    private TbImageView aNQ;
    private ChatClipImageItemView bux;
    private LinearLayout buy;
    private TextView buz;

    public ChatImageWithTailView(Context context) {
        super(context);
        at(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        at(context);
    }

    public void at(Context context) {
        LayoutInflater.from(context).inflate(i.g.chat_image_with_tail_item, this);
        this.bux = (ChatClipImageItemView) findViewById(i.f.img_msgitem_image_new);
        this.bux.setDefaultResource(i.e.pic_image_h_not);
        this.buy = (LinearLayout) findViewById(i.f.small_tail);
        this.aNQ = (TbImageView) findViewById(i.f.tail_icon);
        this.aNQ.setDefaultResource(i.e.icon);
        this.aNQ.setAutoChangeStyle(false);
        this.buz = (TextView) findViewById(i.f.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.bux;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.bux = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.buy;
    }

    public void setTail(LinearLayout linearLayout) {
        this.buy = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aNQ;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aNQ = tbImageView;
    }

    public TextView getFromSource() {
        return this.buz;
    }

    public void setFromSource(TextView textView) {
        this.buz = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aNQ.setAutoChangeStyle(z);
    }
}

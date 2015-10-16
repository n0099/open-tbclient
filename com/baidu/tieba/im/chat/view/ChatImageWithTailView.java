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
    private TbImageView aOb;
    private ChatClipImageItemView buI;
    private LinearLayout buJ;
    private TextView buK;

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
        this.buI = (ChatClipImageItemView) findViewById(i.f.img_msgitem_image_new);
        this.buI.setDefaultResource(i.e.pic_image_h_not);
        this.buJ = (LinearLayout) findViewById(i.f.small_tail);
        this.aOb = (TbImageView) findViewById(i.f.tail_icon);
        this.aOb.setDefaultResource(i.e.icon);
        this.aOb.setAutoChangeStyle(false);
        this.buK = (TextView) findViewById(i.f.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.buI;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.buI = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.buJ;
    }

    public void setTail(LinearLayout linearLayout) {
        this.buJ = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aOb;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aOb = tbImageView;
    }

    public TextView getFromSource() {
        return this.buK;
    }

    public void setFromSource(TextView textView) {
        this.buK = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aOb.setAutoChangeStyle(z);
    }
}

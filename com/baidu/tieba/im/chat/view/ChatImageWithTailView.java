package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView aZC;
    private ChatClipImageItemView bRS;
    private LinearLayout bRT;
    private TextView bRU;

    public ChatImageWithTailView(Context context) {
        super(context);
        at(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        at(context);
    }

    public void at(Context context) {
        LayoutInflater.from(context).inflate(t.h.chat_image_with_tail_item, this);
        this.bRS = (ChatClipImageItemView) findViewById(t.g.img_msgitem_image_new);
        this.bRS.setDefaultResource(t.f.pic_image_h_not);
        this.bRT = (LinearLayout) findViewById(t.g.small_tail);
        this.aZC = (TbImageView) findViewById(t.g.tail_icon);
        this.aZC.setDefaultResource(t.f.icon);
        this.aZC.setAutoChangeStyle(false);
        this.bRU = (TextView) findViewById(t.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.bRS;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.bRS = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.bRT;
    }

    public void setTail(LinearLayout linearLayout) {
        this.bRT = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aZC;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aZC = tbImageView;
    }

    public TextView getFromSource() {
        return this.bRU;
    }

    public void setFromSource(TextView textView) {
        this.bRU = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aZC.setAutoChangeStyle(z);
    }
}

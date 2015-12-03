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
    private TbImageView aTm;
    private ChatClipImageItemView bKm;
    private LinearLayout bKn;
    private TextView bKo;

    public ChatImageWithTailView(Context context) {
        super(context);
        as(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        as(context);
    }

    public void as(Context context) {
        LayoutInflater.from(context).inflate(n.g.chat_image_with_tail_item, this);
        this.bKm = (ChatClipImageItemView) findViewById(n.f.img_msgitem_image_new);
        this.bKm.setDefaultResource(n.e.pic_image_h_not);
        this.bKn = (LinearLayout) findViewById(n.f.small_tail);
        this.aTm = (TbImageView) findViewById(n.f.tail_icon);
        this.aTm.setDefaultResource(n.e.icon);
        this.aTm.setAutoChangeStyle(false);
        this.bKo = (TextView) findViewById(n.f.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.bKm;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.bKm = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.bKn;
    }

    public void setTail(LinearLayout linearLayout) {
        this.bKn = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aTm;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aTm = tbImageView;
    }

    public TextView getFromSource() {
        return this.bKo;
    }

    public void setFromSource(TextView textView) {
        this.bKo = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aTm.setAutoChangeStyle(z);
    }
}

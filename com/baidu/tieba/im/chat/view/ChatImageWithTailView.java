package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView bsM;
    private ChatClipImageItemView cIW;
    private LinearLayout cIX;
    private TextView cIY;

    public ChatImageWithTailView(Context context) {
        super(context);
        aN(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aN(context);
    }

    public void aN(Context context) {
        LayoutInflater.from(context).inflate(r.h.chat_image_with_tail_item, this);
        this.cIW = (ChatClipImageItemView) findViewById(r.g.img_msgitem_image_new);
        this.cIW.setContentDescription(getContext().getString(r.j.talk_pic));
        this.cIW.setDefaultResource(r.f.pic_image_h_not);
        this.cIX = (LinearLayout) findViewById(r.g.small_tail);
        this.bsM = (TbImageView) findViewById(r.g.tail_icon);
        this.bsM.setDefaultResource(r.f.icon);
        this.bsM.setAutoChangeStyle(false);
        this.cIY = (TextView) findViewById(r.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cIW;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cIW = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cIX;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cIX = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bsM;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bsM = tbImageView;
    }

    public TextView getFromSource() {
        return this.cIY;
    }

    public void setFromSource(TextView textView) {
        this.cIY = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bsM.setAutoChangeStyle(z);
    }
}

package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView bHE;
    private ChatClipImageItemView cSv;
    private LinearLayout cSw;
    private TextView cSx;

    public ChatImageWithTailView(Context context) {
        super(context);
        bs(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bs(context);
    }

    public void bs(Context context) {
        LayoutInflater.from(context).inflate(w.j.chat_image_with_tail_item, this);
        this.cSv = (ChatClipImageItemView) findViewById(w.h.img_msgitem_image_new);
        this.cSv.setContentDescription(getContext().getString(w.l.talk_pic));
        this.cSv.setDefaultResource(w.g.pic_image_h_not);
        this.cSw = (LinearLayout) findViewById(w.h.small_tail);
        this.bHE = (TbImageView) findViewById(w.h.tail_icon);
        this.bHE.setDefaultResource(w.g.icon);
        this.bHE.setAutoChangeStyle(false);
        this.cSx = (TextView) findViewById(w.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cSv;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cSv = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cSw;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cSw = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bHE;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bHE = tbImageView;
    }

    public TextView getFromSource() {
        return this.cSx;
    }

    public void setFromSource(TextView textView) {
        this.cSx = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bHE.setAutoChangeStyle(z);
    }
}

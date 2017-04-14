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
    private TbImageView bHx;
    private ChatClipImageItemView cQS;
    private LinearLayout cQT;
    private TextView cQU;

    public ChatImageWithTailView(Context context) {
        super(context);
        bm(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bm(context);
    }

    public void bm(Context context) {
        LayoutInflater.from(context).inflate(w.j.chat_image_with_tail_item, this);
        this.cQS = (ChatClipImageItemView) findViewById(w.h.img_msgitem_image_new);
        this.cQS.setContentDescription(getContext().getString(w.l.editor_image));
        this.cQS.setDefaultResource(w.g.pic_image_h_not);
        this.cQT = (LinearLayout) findViewById(w.h.small_tail);
        this.bHx = (TbImageView) findViewById(w.h.tail_icon);
        this.bHx.setDefaultResource(w.g.icon);
        this.bHx.setAutoChangeStyle(false);
        this.cQU = (TextView) findViewById(w.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cQS;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cQS = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cQT;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cQT = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bHx;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bHx = tbImageView;
    }

    public TextView getFromSource() {
        return this.cQU;
    }

    public void setFromSource(TextView textView) {
        this.cQU = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bHx.setAutoChangeStyle(z);
    }
}

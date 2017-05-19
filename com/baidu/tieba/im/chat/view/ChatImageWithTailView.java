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
    private TbImageView bIS;
    private ChatClipImageItemView cNl;
    private LinearLayout cNm;
    private TextView cNn;

    public ChatImageWithTailView(Context context) {
        super(context);
        bp(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bp(context);
    }

    public void bp(Context context) {
        LayoutInflater.from(context).inflate(w.j.chat_image_with_tail_item, this);
        this.cNl = (ChatClipImageItemView) findViewById(w.h.img_msgitem_image_new);
        this.cNl.setContentDescription(getContext().getString(w.l.editor_image));
        this.cNl.setDefaultResource(w.g.pic_image_h_not);
        this.cNm = (LinearLayout) findViewById(w.h.small_tail);
        this.bIS = (TbImageView) findViewById(w.h.tail_icon);
        this.bIS.setDefaultResource(w.g.icon);
        this.bIS.setAutoChangeStyle(false);
        this.cNn = (TextView) findViewById(w.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cNl;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cNl = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cNm;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cNm = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bIS;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bIS = tbImageView;
    }

    public TextView getFromSource() {
        return this.cNn;
    }

    public void setFromSource(TextView textView) {
        this.cNn = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bIS.setAutoChangeStyle(z);
    }
}

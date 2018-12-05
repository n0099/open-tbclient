package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView drK;
    private ChatClipImageItemView eLp;
    private LinearLayout eLq;
    private TextView eLr;

    public ChatImageWithTailView(Context context) {
        super(context);
        cr(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cr(context);
    }

    public void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.chat_image_with_tail_item, this);
        this.eLp = (ChatClipImageItemView) findViewById(e.g.img_msgitem_image_new);
        this.eLp.setContentDescription(getContext().getString(e.j.editor_image));
        this.eLp.setDefaultResource(e.f.pic_image_h_not);
        this.eLq = (LinearLayout) findViewById(e.g.small_tail);
        this.drK = (TbImageView) findViewById(e.g.tail_icon);
        this.drK.setDefaultResource(e.f.icon);
        this.drK.setAutoChangeStyle(false);
        this.eLr = (TextView) findViewById(e.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.eLp;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.eLp = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.eLq;
    }

    public void setTail(LinearLayout linearLayout) {
        this.eLq = linearLayout;
    }

    public TbImageView getIcon() {
        return this.drK;
    }

    public void setIcon(TbImageView tbImageView) {
        this.drK = tbImageView;
    }

    public TextView getFromSource() {
        return this.eLr;
    }

    public void setFromSource(TextView textView) {
        this.eLr = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.drK.setAutoChangeStyle(z);
    }
}

package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView cwm;
    private ChatClipImageItemView dHg;
    private LinearLayout dHh;
    private TextView dHi;

    public ChatImageWithTailView(Context context) {
        super(context);
        bt(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bt(context);
    }

    public void bt(Context context) {
        LayoutInflater.from(context).inflate(d.h.chat_image_with_tail_item, this);
        this.dHg = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.dHg.setContentDescription(getContext().getString(d.j.editor_image));
        this.dHg.setDefaultResource(d.f.pic_image_h_not);
        this.dHh = (LinearLayout) findViewById(d.g.small_tail);
        this.cwm = (TbImageView) findViewById(d.g.tail_icon);
        this.cwm.setDefaultResource(d.f.icon);
        this.cwm.setAutoChangeStyle(false);
        this.dHi = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dHg;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dHg = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dHh;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dHh = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cwm;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cwm = tbImageView;
    }

    public TextView getFromSource() {
        return this.dHi;
    }

    public void setFromSource(TextView textView) {
        this.dHi = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cwm.setAutoChangeStyle(z);
    }
}

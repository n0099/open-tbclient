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
    private TbImageView dvi;
    private ChatClipImageItemView eOT;
    private LinearLayout eOU;
    private TextView eOV;

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
        this.eOT = (ChatClipImageItemView) findViewById(e.g.img_msgitem_image_new);
        this.eOT.setContentDescription(getContext().getString(e.j.editor_image));
        this.eOT.setDefaultResource(e.f.pic_image_h_not);
        this.eOU = (LinearLayout) findViewById(e.g.small_tail);
        this.dvi = (TbImageView) findViewById(e.g.tail_icon);
        this.dvi.setDefaultResource(e.f.icon);
        this.dvi.setAutoChangeStyle(false);
        this.eOV = (TextView) findViewById(e.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.eOT;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.eOT = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.eOU;
    }

    public void setTail(LinearLayout linearLayout) {
        this.eOU = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dvi;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dvi = tbImageView;
    }

    public TextView getFromSource() {
        return this.eOV;
    }

    public void setFromSource(TextView textView) {
        this.eOV = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dvi.setAutoChangeStyle(z);
    }
}

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
    private TbImageView dli;
    private ChatClipImageItemView eEA;
    private LinearLayout eEB;
    private TextView eEC;

    public ChatImageWithTailView(Context context) {
        super(context);
        cn(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cn(context);
    }

    public void cn(Context context) {
        LayoutInflater.from(context).inflate(e.h.chat_image_with_tail_item, this);
        this.eEA = (ChatClipImageItemView) findViewById(e.g.img_msgitem_image_new);
        this.eEA.setContentDescription(getContext().getString(e.j.editor_image));
        this.eEA.setDefaultResource(e.f.pic_image_h_not);
        this.eEB = (LinearLayout) findViewById(e.g.small_tail);
        this.dli = (TbImageView) findViewById(e.g.tail_icon);
        this.dli.setDefaultResource(e.f.icon);
        this.dli.setAutoChangeStyle(false);
        this.eEC = (TextView) findViewById(e.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.eEA;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.eEA = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.eEB;
    }

    public void setTail(LinearLayout linearLayout) {
        this.eEB = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dli;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dli = tbImageView;
    }

    public TextView getFromSource() {
        return this.eEC;
    }

    public void setFromSource(TextView textView) {
        this.eEC = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dli.setAutoChangeStyle(z);
    }
}

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
    private TbImageView cfF;
    private ChatClipImageItemView dtd;
    private LinearLayout dte;
    private TextView dtf;

    public ChatImageWithTailView(Context context) {
        super(context);
        bs(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bs(context);
    }

    public void bs(Context context) {
        LayoutInflater.from(context).inflate(d.j.chat_image_with_tail_item, this);
        this.dtd = (ChatClipImageItemView) findViewById(d.h.img_msgitem_image_new);
        this.dtd.setContentDescription(getContext().getString(d.l.editor_image));
        this.dtd.setDefaultResource(d.g.pic_image_h_not);
        this.dte = (LinearLayout) findViewById(d.h.small_tail);
        this.cfF = (TbImageView) findViewById(d.h.tail_icon);
        this.cfF.setDefaultResource(d.g.icon);
        this.cfF.setAutoChangeStyle(false);
        this.dtf = (TextView) findViewById(d.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dtd;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dtd = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dte;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dte = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cfF;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cfF = tbImageView;
    }

    public TextView getFromSource() {
        return this.dtf;
    }

    public void setFromSource(TextView textView) {
        this.dtf = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cfF.setAutoChangeStyle(z);
    }
}

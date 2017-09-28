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
    private TbImageView cfL;
    private ChatClipImageItemView dqo;
    private LinearLayout dqp;
    private TextView dqq;

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
        this.dqo = (ChatClipImageItemView) findViewById(d.h.img_msgitem_image_new);
        this.dqo.setContentDescription(getContext().getString(d.l.editor_image));
        this.dqo.setDefaultResource(d.g.pic_image_h_not);
        this.dqp = (LinearLayout) findViewById(d.h.small_tail);
        this.cfL = (TbImageView) findViewById(d.h.tail_icon);
        this.cfL.setDefaultResource(d.g.icon);
        this.cfL.setAutoChangeStyle(false);
        this.dqq = (TextView) findViewById(d.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dqo;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dqo = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dqp;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dqp = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cfL;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cfL = tbImageView;
    }

    public TextView getFromSource() {
        return this.dqq;
    }

    public void setFromSource(TextView textView) {
        this.dqq = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cfL.setAutoChangeStyle(z);
    }
}

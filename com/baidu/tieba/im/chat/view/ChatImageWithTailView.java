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
    private TbImageView cfz;
    private ChatClipImageItemView dqb;
    private LinearLayout dqc;
    private TextView dqd;

    public ChatImageWithTailView(Context context) {
        super(context);
        br(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        br(context);
    }

    public void br(Context context) {
        LayoutInflater.from(context).inflate(d.j.chat_image_with_tail_item, this);
        this.dqb = (ChatClipImageItemView) findViewById(d.h.img_msgitem_image_new);
        this.dqb.setContentDescription(getContext().getString(d.l.editor_image));
        this.dqb.setDefaultResource(d.g.pic_image_h_not);
        this.dqc = (LinearLayout) findViewById(d.h.small_tail);
        this.cfz = (TbImageView) findViewById(d.h.tail_icon);
        this.cfz.setDefaultResource(d.g.icon);
        this.cfz.setAutoChangeStyle(false);
        this.dqd = (TextView) findViewById(d.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dqb;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dqb = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dqc;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dqc = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cfz;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cfz = tbImageView;
    }

    public TextView getFromSource() {
        return this.dqd;
    }

    public void setFromSource(TextView textView) {
        this.dqd = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cfz.setAutoChangeStyle(z);
    }
}

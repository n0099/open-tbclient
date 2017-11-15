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
    private TbImageView cnm;
    private ChatClipImageItemView dyk;
    private LinearLayout dyl;
    private TextView dym;

    public ChatImageWithTailView(Context context) {
        super(context);
        br(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        br(context);
    }

    public void br(Context context) {
        LayoutInflater.from(context).inflate(d.h.chat_image_with_tail_item, this);
        this.dyk = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.dyk.setContentDescription(getContext().getString(d.j.editor_image));
        this.dyk.setDefaultResource(d.f.pic_image_h_not);
        this.dyl = (LinearLayout) findViewById(d.g.small_tail);
        this.cnm = (TbImageView) findViewById(d.g.tail_icon);
        this.cnm.setDefaultResource(d.f.icon);
        this.cnm.setAutoChangeStyle(false);
        this.dym = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dyk;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dyk = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dyl;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dyl = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cnm;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cnm = tbImageView;
    }

    public TextView getFromSource() {
        return this.dym;
    }

    public void setFromSource(TextView textView) {
        this.dym = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cnm.setAutoChangeStyle(z);
    }
}

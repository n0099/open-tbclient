package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView bym;
    private ChatClipImageItemView cLm;
    private LinearLayout cLn;
    private TextView cLo;

    public ChatImageWithTailView(Context context) {
        super(context);
        ar(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ar(context);
    }

    public void ar(Context context) {
        LayoutInflater.from(context).inflate(u.h.chat_image_with_tail_item, this);
        this.cLm = (ChatClipImageItemView) findViewById(u.g.img_msgitem_image_new);
        this.cLm.setContentDescription(getContext().getString(u.j.talk_pic));
        this.cLm.setDefaultResource(u.f.pic_image_h_not);
        this.cLn = (LinearLayout) findViewById(u.g.small_tail);
        this.bym = (TbImageView) findViewById(u.g.tail_icon);
        this.bym.setDefaultResource(u.f.icon);
        this.bym.setAutoChangeStyle(false);
        this.cLo = (TextView) findViewById(u.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cLm;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cLm = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cLn;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cLn = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bym;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bym = tbImageView;
    }

    public TextView getFromSource() {
        return this.cLo;
    }

    public void setFromSource(TextView textView) {
        this.cLo = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bym.setAutoChangeStyle(z);
    }
}

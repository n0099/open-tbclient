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
    private TbImageView dbT;
    private ChatClipImageItemView evs;
    private LinearLayout evt;
    private TextView evu;

    public ChatImageWithTailView(Context context) {
        super(context);
        cf(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cf(context);
    }

    public void cf(Context context) {
        LayoutInflater.from(context).inflate(e.h.chat_image_with_tail_item, this);
        this.evs = (ChatClipImageItemView) findViewById(e.g.img_msgitem_image_new);
        this.evs.setContentDescription(getContext().getString(e.j.editor_image));
        this.evs.setDefaultResource(e.f.pic_image_h_not);
        this.evt = (LinearLayout) findViewById(e.g.small_tail);
        this.dbT = (TbImageView) findViewById(e.g.tail_icon);
        this.dbT.setDefaultResource(e.f.icon);
        this.dbT.setAutoChangeStyle(false);
        this.evu = (TextView) findViewById(e.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.evs;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.evs = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.evt;
    }

    public void setTail(LinearLayout linearLayout) {
        this.evt = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dbT;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dbT = tbImageView;
    }

    public TextView getFromSource() {
        return this.evu;
    }

    public void setFromSource(TextView textView) {
        this.evu = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dbT.setAutoChangeStyle(z);
    }
}

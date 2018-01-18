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
    private TbImageView dpj;
    private ChatClipImageItemView euK;
    private LinearLayout euL;
    private TextView euM;

    public ChatImageWithTailView(Context context) {
        super(context);
        bE(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bE(context);
    }

    public void bE(Context context) {
        LayoutInflater.from(context).inflate(d.h.chat_image_with_tail_item, this);
        this.euK = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.euK.setContentDescription(getContext().getString(d.j.editor_image));
        this.euK.setDefaultResource(d.f.pic_image_h_not);
        this.euL = (LinearLayout) findViewById(d.g.small_tail);
        this.dpj = (TbImageView) findViewById(d.g.tail_icon);
        this.dpj.setDefaultResource(d.f.icon);
        this.dpj.setAutoChangeStyle(false);
        this.euM = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.euK;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.euK = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.euL;
    }

    public void setTail(LinearLayout linearLayout) {
        this.euL = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dpj;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dpj = tbImageView;
    }

    public TextView getFromSource() {
        return this.euM;
    }

    public void setFromSource(TextView textView) {
        this.euM = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dpj.setAutoChangeStyle(z);
    }
}

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
    private TbImageView eIv;
    private ChatClipImageItemView geW;
    private LinearLayout geX;
    private TextView geY;

    public ChatImageWithTailView(Context context) {
        super(context);
        aX(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aX(context);
    }

    public void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.chat_image_with_tail_item, this);
        this.geW = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.geW.setContentDescription(getContext().getString(d.j.editor_image));
        this.geW.setDefaultResource(d.f.pic_image_h_not);
        this.geX = (LinearLayout) findViewById(d.g.small_tail);
        this.eIv = (TbImageView) findViewById(d.g.tail_icon);
        this.eIv.setDefaultResource(d.f.icon);
        this.eIv.setAutoChangeStyle(false);
        this.geY = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.geW;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.geW = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.geX;
    }

    public void setTail(LinearLayout linearLayout) {
        this.geX = linearLayout;
    }

    public TbImageView getIcon() {
        return this.eIv;
    }

    public void setIcon(TbImageView tbImageView) {
        this.eIv = tbImageView;
    }

    public TextView getFromSource() {
        return this.geY;
    }

    public void setFromSource(TextView textView) {
        this.geY = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.eIv.setAutoChangeStyle(z);
    }
}

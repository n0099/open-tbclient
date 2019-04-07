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
    private TbImageView eIh;
    private ChatClipImageItemView geK;
    private LinearLayout geL;
    private TextView geM;

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
        this.geK = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.geK.setContentDescription(getContext().getString(d.j.editor_image));
        this.geK.setDefaultResource(d.f.pic_image_h_not);
        this.geL = (LinearLayout) findViewById(d.g.small_tail);
        this.eIh = (TbImageView) findViewById(d.g.tail_icon);
        this.eIh.setDefaultResource(d.f.icon);
        this.eIh.setAutoChangeStyle(false);
        this.geM = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.geK;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.geK = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.geL;
    }

    public void setTail(LinearLayout linearLayout) {
        this.geL = linearLayout;
    }

    public TbImageView getIcon() {
        return this.eIh;
    }

    public void setIcon(TbImageView tbImageView) {
        this.eIh = tbImageView;
    }

    public TextView getFromSource() {
        return this.geM;
    }

    public void setFromSource(TextView textView) {
        this.geM = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.eIh.setAutoChangeStyle(z);
    }
}

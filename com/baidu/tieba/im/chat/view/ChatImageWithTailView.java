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
    private TbImageView eIz;
    private ChatClipImageItemView geX;
    private LinearLayout geY;
    private TextView geZ;

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
        this.geX = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.geX.setContentDescription(getContext().getString(d.j.editor_image));
        this.geX.setDefaultResource(d.f.pic_image_h_not);
        this.geY = (LinearLayout) findViewById(d.g.small_tail);
        this.eIz = (TbImageView) findViewById(d.g.tail_icon);
        this.eIz.setDefaultResource(d.f.icon);
        this.eIz.setAutoChangeStyle(false);
        this.geZ = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.geX;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.geX = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.geY;
    }

    public void setTail(LinearLayout linearLayout) {
        this.geY = linearLayout;
    }

    public TbImageView getIcon() {
        return this.eIz;
    }

    public void setIcon(TbImageView tbImageView) {
        this.eIz = tbImageView;
    }

    public TextView getFromSource() {
        return this.geZ;
    }

    public void setFromSource(TextView textView) {
        this.geZ = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.eIz.setAutoChangeStyle(z);
    }
}

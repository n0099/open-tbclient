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
    private TbImageView cvZ;
    private ChatClipImageItemView dFY;
    private LinearLayout dFZ;
    private TextView dGa;

    public ChatImageWithTailView(Context context) {
        super(context);
        bw(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bw(context);
    }

    public void bw(Context context) {
        LayoutInflater.from(context).inflate(d.h.chat_image_with_tail_item, this);
        this.dFY = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.dFY.setContentDescription(getContext().getString(d.j.editor_image));
        this.dFY.setDefaultResource(d.f.pic_image_h_not);
        this.dFZ = (LinearLayout) findViewById(d.g.small_tail);
        this.cvZ = (TbImageView) findViewById(d.g.tail_icon);
        this.cvZ.setDefaultResource(d.f.icon);
        this.cvZ.setAutoChangeStyle(false);
        this.dGa = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dFY;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dFY = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dFZ;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dFZ = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cvZ;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cvZ = tbImageView;
    }

    public TextView getFromSource() {
        return this.dGa;
    }

    public void setFromSource(TextView textView) {
        this.dGa = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cvZ.setAutoChangeStyle(z);
    }
}

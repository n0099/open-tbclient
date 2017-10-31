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
    private TbImageView cmT;
    private ChatClipImageItemView dxQ;
    private LinearLayout dxR;
    private TextView dxS;

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
        this.dxQ = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.dxQ.setContentDescription(getContext().getString(d.j.editor_image));
        this.dxQ.setDefaultResource(d.f.pic_image_h_not);
        this.dxR = (LinearLayout) findViewById(d.g.small_tail);
        this.cmT = (TbImageView) findViewById(d.g.tail_icon);
        this.cmT.setDefaultResource(d.f.icon);
        this.cmT.setAutoChangeStyle(false);
        this.dxS = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dxQ;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dxQ = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dxR;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dxR = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cmT;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cmT = tbImageView;
    }

    public TextView getFromSource() {
        return this.dxS;
    }

    public void setFromSource(TextView textView) {
        this.dxS = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cmT.setAutoChangeStyle(z);
    }
}

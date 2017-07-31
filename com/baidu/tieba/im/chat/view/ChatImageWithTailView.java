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
    private TbImageView cbv;
    private ChatClipImageItemView dkD;
    private LinearLayout dkE;
    private TextView dkF;

    public ChatImageWithTailView(Context context) {
        super(context);
        bk(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bk(context);
    }

    public void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.chat_image_with_tail_item, this);
        this.dkD = (ChatClipImageItemView) findViewById(d.h.img_msgitem_image_new);
        this.dkD.setContentDescription(getContext().getString(d.l.editor_image));
        this.dkD.setDefaultResource(d.g.pic_image_h_not);
        this.dkE = (LinearLayout) findViewById(d.h.small_tail);
        this.cbv = (TbImageView) findViewById(d.h.tail_icon);
        this.cbv.setDefaultResource(d.g.icon);
        this.cbv.setAutoChangeStyle(false);
        this.dkF = (TextView) findViewById(d.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dkD;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dkD = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dkE;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dkE = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cbv;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cbv = tbImageView;
    }

    public TextView getFromSource() {
        return this.dkF;
    }

    public void setFromSource(TextView textView) {
        this.dkF = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cbv.setAutoChangeStyle(z);
    }
}

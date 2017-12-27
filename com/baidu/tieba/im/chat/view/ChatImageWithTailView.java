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
    private TbImageView dkI;
    private ChatClipImageItemView etm;
    private LinearLayout etn;
    private TextView eto;

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
        this.etm = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.etm.setContentDescription(getContext().getString(d.j.editor_image));
        this.etm.setDefaultResource(d.f.pic_image_h_not);
        this.etn = (LinearLayout) findViewById(d.g.small_tail);
        this.dkI = (TbImageView) findViewById(d.g.tail_icon);
        this.dkI.setDefaultResource(d.f.icon);
        this.dkI.setAutoChangeStyle(false);
        this.eto = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.etm;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.etm = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.etn;
    }

    public void setTail(LinearLayout linearLayout) {
        this.etn = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dkI;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dkI = tbImageView;
    }

    public TextView getFromSource() {
        return this.eto;
    }

    public void setFromSource(TextView textView) {
        this.eto = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dkI.setAutoChangeStyle(z);
    }
}

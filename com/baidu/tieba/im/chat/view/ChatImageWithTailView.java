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
    private TbImageView dkd;
    private ChatClipImageItemView eDh;
    private LinearLayout eDi;
    private TextView eDj;

    public ChatImageWithTailView(Context context) {
        super(context);
        cs(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cs(context);
    }

    public void cs(Context context) {
        LayoutInflater.from(context).inflate(e.h.chat_image_with_tail_item, this);
        this.eDh = (ChatClipImageItemView) findViewById(e.g.img_msgitem_image_new);
        this.eDh.setContentDescription(getContext().getString(e.j.editor_image));
        this.eDh.setDefaultResource(e.f.pic_image_h_not);
        this.eDi = (LinearLayout) findViewById(e.g.small_tail);
        this.dkd = (TbImageView) findViewById(e.g.tail_icon);
        this.dkd.setDefaultResource(e.f.icon);
        this.dkd.setAutoChangeStyle(false);
        this.eDj = (TextView) findViewById(e.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.eDh;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.eDh = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.eDi;
    }

    public void setTail(LinearLayout linearLayout) {
        this.eDi = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dkd;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dkd = tbImageView;
    }

    public TextView getFromSource() {
        return this.eDj;
    }

    public void setFromSource(TextView textView) {
        this.eDj = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dkd.setAutoChangeStyle(z);
    }
}

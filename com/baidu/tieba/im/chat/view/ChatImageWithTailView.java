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
    private ChatClipImageItemView eDg;
    private LinearLayout eDh;
    private TextView eDi;

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
        this.eDg = (ChatClipImageItemView) findViewById(e.g.img_msgitem_image_new);
        this.eDg.setContentDescription(getContext().getString(e.j.editor_image));
        this.eDg.setDefaultResource(e.f.pic_image_h_not);
        this.eDh = (LinearLayout) findViewById(e.g.small_tail);
        this.dkd = (TbImageView) findViewById(e.g.tail_icon);
        this.dkd.setDefaultResource(e.f.icon);
        this.dkd.setAutoChangeStyle(false);
        this.eDi = (TextView) findViewById(e.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.eDg;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.eDg = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.eDh;
    }

    public void setTail(LinearLayout linearLayout) {
        this.eDh = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dkd;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dkd = tbImageView;
    }

    public TextView getFromSource() {
        return this.eDi;
    }

    public void setFromSource(TextView textView) {
        this.eDi = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dkd.setAutoChangeStyle(z);
    }
}

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
    private TbImageView dpE;
    private ChatClipImageItemView evf;
    private LinearLayout evg;
    private TextView evh;

    public ChatImageWithTailView(Context context) {
        super(context);
        bB(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bB(context);
    }

    public void bB(Context context) {
        LayoutInflater.from(context).inflate(d.h.chat_image_with_tail_item, this);
        this.evf = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.evf.setContentDescription(getContext().getString(d.j.editor_image));
        this.evf.setDefaultResource(d.f.pic_image_h_not);
        this.evg = (LinearLayout) findViewById(d.g.small_tail);
        this.dpE = (TbImageView) findViewById(d.g.tail_icon);
        this.dpE.setDefaultResource(d.f.icon);
        this.dpE.setAutoChangeStyle(false);
        this.evh = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.evf;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.evf = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.evg;
    }

    public void setTail(LinearLayout linearLayout) {
        this.evg = linearLayout;
    }

    public TbImageView getIcon() {
        return this.dpE;
    }

    public void setIcon(TbImageView tbImageView) {
        this.dpE = tbImageView;
    }

    public TextView getFromSource() {
        return this.evh;
    }

    public void setFromSource(TextView textView) {
        this.evh = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.dpE.setAutoChangeStyle(z);
    }
}

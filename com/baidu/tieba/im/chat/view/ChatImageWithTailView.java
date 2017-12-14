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
    private TbImageView cwi;
    private ChatClipImageItemView dHc;
    private LinearLayout dHd;
    private TextView dHe;

    public ChatImageWithTailView(Context context) {
        super(context);
        bt(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bt(context);
    }

    public void bt(Context context) {
        LayoutInflater.from(context).inflate(d.h.chat_image_with_tail_item, this);
        this.dHc = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.dHc.setContentDescription(getContext().getString(d.j.editor_image));
        this.dHc.setDefaultResource(d.f.pic_image_h_not);
        this.dHd = (LinearLayout) findViewById(d.g.small_tail);
        this.cwi = (TbImageView) findViewById(d.g.tail_icon);
        this.cwi.setDefaultResource(d.f.icon);
        this.cwi.setAutoChangeStyle(false);
        this.dHe = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dHc;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dHc = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dHd;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dHd = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cwi;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cwi = tbImageView;
    }

    public TextView getFromSource() {
        return this.dHe;
    }

    public void setFromSource(TextView textView) {
        this.dHe = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cwi.setAutoChangeStyle(z);
    }
}

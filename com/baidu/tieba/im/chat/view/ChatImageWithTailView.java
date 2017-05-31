package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView bOG;
    private ChatClipImageItemView cSJ;
    private LinearLayout cSK;
    private TextView cSL;

    public ChatImageWithTailView(Context context) {
        super(context);
        bp(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bp(context);
    }

    public void bp(Context context) {
        LayoutInflater.from(context).inflate(w.j.chat_image_with_tail_item, this);
        this.cSJ = (ChatClipImageItemView) findViewById(w.h.img_msgitem_image_new);
        this.cSJ.setContentDescription(getContext().getString(w.l.editor_image));
        this.cSJ.setDefaultResource(w.g.pic_image_h_not);
        this.cSK = (LinearLayout) findViewById(w.h.small_tail);
        this.bOG = (TbImageView) findViewById(w.h.tail_icon);
        this.bOG.setDefaultResource(w.g.icon);
        this.bOG.setAutoChangeStyle(false);
        this.cSL = (TextView) findViewById(w.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cSJ;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cSJ = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cSK;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cSK = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bOG;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bOG = tbImageView;
    }

    public TextView getFromSource() {
        return this.cSL;
    }

    public void setFromSource(TextView textView) {
        this.cSL = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bOG.setAutoChangeStyle(z);
    }
}

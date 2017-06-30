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
    private TbImageView bVD;
    private ChatClipImageItemView daF;
    private LinearLayout daG;
    private TextView daH;

    public ChatImageWithTailView(Context context) {
        super(context);
        bj(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bj(context);
    }

    public void bj(Context context) {
        LayoutInflater.from(context).inflate(w.j.chat_image_with_tail_item, this);
        this.daF = (ChatClipImageItemView) findViewById(w.h.img_msgitem_image_new);
        this.daF.setContentDescription(getContext().getString(w.l.editor_image));
        this.daF.setDefaultResource(w.g.pic_image_h_not);
        this.daG = (LinearLayout) findViewById(w.h.small_tail);
        this.bVD = (TbImageView) findViewById(w.h.tail_icon);
        this.bVD.setDefaultResource(w.g.icon);
        this.bVD.setAutoChangeStyle(false);
        this.daH = (TextView) findViewById(w.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.daF;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.daF = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.daG;
    }

    public void setTail(LinearLayout linearLayout) {
        this.daG = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bVD;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bVD = tbImageView;
    }

    public TextView getFromSource() {
        return this.daH;
    }

    public void setFromSource(TextView textView) {
        this.daH = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bVD.setAutoChangeStyle(z);
    }
}

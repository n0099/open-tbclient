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
    private TbImageView bJO;
    private ChatClipImageItemView cTj;
    private LinearLayout cTk;
    private TextView cTl;

    public ChatImageWithTailView(Context context) {
        super(context);
        bm(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bm(context);
    }

    public void bm(Context context) {
        LayoutInflater.from(context).inflate(w.j.chat_image_with_tail_item, this);
        this.cTj = (ChatClipImageItemView) findViewById(w.h.img_msgitem_image_new);
        this.cTj.setContentDescription(getContext().getString(w.l.editor_image));
        this.cTj.setDefaultResource(w.g.pic_image_h_not);
        this.cTk = (LinearLayout) findViewById(w.h.small_tail);
        this.bJO = (TbImageView) findViewById(w.h.tail_icon);
        this.bJO.setDefaultResource(w.g.icon);
        this.bJO.setAutoChangeStyle(false);
        this.cTl = (TextView) findViewById(w.h.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cTj;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cTj = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cTk;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cTk = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bJO;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bJO = tbImageView;
    }

    public TextView getFromSource() {
        return this.cTl;
    }

    public void setFromSource(TextView textView) {
        this.cTl = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bJO.setAutoChangeStyle(z);
    }
}

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
    private TbImageView cTr;
    private ChatClipImageItemView ekk;
    private LinearLayout ekl;
    private TextView ekm;

    public ChatImageWithTailView(Context context) {
        super(context);
        bx(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bx(context);
    }

    public void bx(Context context) {
        LayoutInflater.from(context).inflate(d.i.chat_image_with_tail_item, this);
        this.ekk = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.ekk.setContentDescription(getContext().getString(d.k.editor_image));
        this.ekk.setDefaultResource(d.f.pic_image_h_not);
        this.ekl = (LinearLayout) findViewById(d.g.small_tail);
        this.cTr = (TbImageView) findViewById(d.g.tail_icon);
        this.cTr.setDefaultResource(d.f.icon);
        this.cTr.setAutoChangeStyle(false);
        this.ekm = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.ekk;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.ekk = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.ekl;
    }

    public void setTail(LinearLayout linearLayout) {
        this.ekl = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cTr;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cTr = tbImageView;
    }

    public TextView getFromSource() {
        return this.ekm;
    }

    public void setFromSource(TextView textView) {
        this.ekm = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cTr.setAutoChangeStyle(z);
    }
}

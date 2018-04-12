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
    private TbImageView cLf;
    private ChatClipImageItemView dUa;
    private LinearLayout dUb;
    private TextView dUc;

    public ChatImageWithTailView(Context context) {
        super(context);
        bo(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bo(context);
    }

    public void bo(Context context) {
        LayoutInflater.from(context).inflate(d.i.chat_image_with_tail_item, this);
        this.dUa = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.dUa.setContentDescription(getContext().getString(d.k.editor_image));
        this.dUa.setDefaultResource(d.f.pic_image_h_not);
        this.dUb = (LinearLayout) findViewById(d.g.small_tail);
        this.cLf = (TbImageView) findViewById(d.g.tail_icon);
        this.cLf.setDefaultResource(d.f.icon);
        this.cLf.setAutoChangeStyle(false);
        this.dUc = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dUa;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dUa = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dUb;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dUb = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cLf;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cLf = tbImageView;
    }

    public TextView getFromSource() {
        return this.dUc;
    }

    public void setFromSource(TextView textView) {
        this.dUc = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cLf.setAutoChangeStyle(z);
    }
}

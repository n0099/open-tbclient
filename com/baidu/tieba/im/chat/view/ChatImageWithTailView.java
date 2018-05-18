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
    private TbImageView cMj;
    private ChatClipImageItemView dVe;
    private LinearLayout dVf;
    private TextView dVg;

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
        this.dVe = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.dVe.setContentDescription(getContext().getString(d.k.editor_image));
        this.dVe.setDefaultResource(d.f.pic_image_h_not);
        this.dVf = (LinearLayout) findViewById(d.g.small_tail);
        this.cMj = (TbImageView) findViewById(d.g.tail_icon);
        this.cMj.setDefaultResource(d.f.icon);
        this.cMj.setAutoChangeStyle(false);
        this.dVg = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dVe;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dVe = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dVf;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dVf = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cMj;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cMj = tbImageView;
    }

    public TextView getFromSource() {
        return this.dVg;
    }

    public void setFromSource(TextView textView) {
        this.dVg = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cMj.setAutoChangeStyle(z);
    }
}

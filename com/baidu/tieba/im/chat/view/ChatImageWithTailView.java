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
    private TbImageView cVp;
    private ChatClipImageItemView egr;
    private LinearLayout egs;
    private TextView egt;

    public ChatImageWithTailView(Context context) {
        super(context);
        by(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        by(context);
    }

    public void by(Context context) {
        LayoutInflater.from(context).inflate(d.i.chat_image_with_tail_item, this);
        this.egr = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.egr.setContentDescription(getContext().getString(d.k.editor_image));
        this.egr.setDefaultResource(d.f.pic_image_h_not);
        this.egs = (LinearLayout) findViewById(d.g.small_tail);
        this.cVp = (TbImageView) findViewById(d.g.tail_icon);
        this.cVp.setDefaultResource(d.f.icon);
        this.cVp.setAutoChangeStyle(false);
        this.egt = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.egr;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.egr = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.egs;
    }

    public void setTail(LinearLayout linearLayout) {
        this.egs = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cVp;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cVp = tbImageView;
    }

    public TextView getFromSource() {
        return this.egt;
    }

    public void setFromSource(TextView textView) {
        this.egt = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cVp.setAutoChangeStyle(z);
    }
}

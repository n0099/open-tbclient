package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView aOH;
    private ChatClipImageItemView bqN;
    private LinearLayout bqO;
    private TextView bqP;

    public ChatImageWithTailView(Context context) {
        super(context);
        aB(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aB(context);
    }

    public void aB(Context context) {
        LayoutInflater.from(context).inflate(i.g.chat_image_with_tail_item, this);
        this.bqN = (ChatClipImageItemView) findViewById(i.f.img_msgitem_image_new);
        this.bqN.setDefaultResource(i.e.pic_image_h_not);
        this.bqO = (LinearLayout) findViewById(i.f.small_tail);
        this.aOH = (TbImageView) findViewById(i.f.tail_icon);
        this.aOH.setDefaultResource(i.e.icon);
        this.aOH.setAutoChangeStyle(false);
        this.bqP = (TextView) findViewById(i.f.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.bqN;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.bqN = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.bqO;
    }

    public void setTail(LinearLayout linearLayout) {
        this.bqO = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aOH;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aOH = tbImageView;
    }

    public TextView getFromSource() {
        return this.bqP;
    }

    public void setFromSource(TextView textView) {
        this.bqP = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aOH.setAutoChangeStyle(z);
    }
}

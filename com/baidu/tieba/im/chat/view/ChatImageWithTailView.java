package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView bJO;
    private ChatClipImageItemView cWR;
    private LinearLayout cWS;
    private TextView cWT;

    public ChatImageWithTailView(Context context) {
        super(context);
        aE(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aE(context);
    }

    public void aE(Context context) {
        LayoutInflater.from(context).inflate(t.h.chat_image_with_tail_item, this);
        this.cWR = (ChatClipImageItemView) findViewById(t.g.img_msgitem_image_new);
        this.cWR.setContentDescription(getContext().getString(t.j.talk_pic));
        this.cWR.setDefaultResource(t.f.pic_image_h_not);
        this.cWS = (LinearLayout) findViewById(t.g.small_tail);
        this.bJO = (TbImageView) findViewById(t.g.tail_icon);
        this.bJO.setDefaultResource(t.f.icon);
        this.bJO.setAutoChangeStyle(false);
        this.cWT = (TextView) findViewById(t.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cWR;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cWR = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cWS;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cWS = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bJO;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bJO = tbImageView;
    }

    public TextView getFromSource() {
        return this.cWT;
    }

    public void setFromSource(TextView textView) {
        this.cWT = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bJO.setAutoChangeStyle(z);
    }
}

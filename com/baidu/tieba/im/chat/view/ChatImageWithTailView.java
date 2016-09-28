package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView bJP;
    private ChatClipImageItemView cYo;
    private LinearLayout cYp;
    private TextView cYq;

    public ChatImageWithTailView(Context context) {
        super(context);
        aC(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aC(context);
    }

    public void aC(Context context) {
        LayoutInflater.from(context).inflate(r.h.chat_image_with_tail_item, this);
        this.cYo = (ChatClipImageItemView) findViewById(r.g.img_msgitem_image_new);
        this.cYo.setContentDescription(getContext().getString(r.j.talk_pic));
        this.cYo.setDefaultResource(r.f.pic_image_h_not);
        this.cYp = (LinearLayout) findViewById(r.g.small_tail);
        this.bJP = (TbImageView) findViewById(r.g.tail_icon);
        this.bJP.setDefaultResource(r.f.icon);
        this.bJP.setAutoChangeStyle(false);
        this.cYq = (TextView) findViewById(r.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.cYo;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.cYo = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.cYp;
    }

    public void setTail(LinearLayout linearLayout) {
        this.cYp = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bJP;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bJP = tbImageView;
    }

    public TextView getFromSource() {
        return this.cYq;
    }

    public void setFromSource(TextView textView) {
        this.cYq = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bJP.setAutoChangeStyle(z);
    }
}

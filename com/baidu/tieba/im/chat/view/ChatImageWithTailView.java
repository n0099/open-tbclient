package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView aHh;
    private ChatClipImageItemView bcW;
    private LinearLayout bcX;
    private TextView bcY;

    public ChatImageWithTailView(Context context) {
        super(context);
        az(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        az(context);
    }

    public void az(Context context) {
        b.hr().inflate(context, r.chat_image_with_tail_item, this);
        this.bcW = (ChatClipImageItemView) findViewById(q.img_msgitem_image_new);
        this.bcW.setDefaultResource(p.pic_image_h_not);
        this.bcX = (LinearLayout) findViewById(q.small_tail);
        this.aHh = (TbImageView) findViewById(q.tail_icon);
        this.aHh.setDefaultResource(p.icon);
        this.aHh.setAutoChangeStyle(false);
        this.bcY = (TextView) findViewById(q.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.bcW;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.bcW = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.bcX;
    }

    public void setTail(LinearLayout linearLayout) {
        this.bcX = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aHh;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aHh = tbImageView;
    }

    public TextView getFromSource() {
        return this.bcY;
    }

    public void setFromSource(TextView textView) {
        this.bcY = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aHh.setAutoChangeStyle(z);
    }
}

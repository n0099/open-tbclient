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
    private TbImageView aHg;
    private ChatClipImageItemView bcV;
    private LinearLayout bcW;
    private TextView bcX;

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
        this.bcV = (ChatClipImageItemView) findViewById(q.img_msgitem_image_new);
        this.bcV.setDefaultResource(p.pic_image_h_not);
        this.bcW = (LinearLayout) findViewById(q.small_tail);
        this.aHg = (TbImageView) findViewById(q.tail_icon);
        this.aHg.setDefaultResource(p.icon);
        this.aHg.setAutoChangeStyle(false);
        this.bcX = (TextView) findViewById(q.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.bcV;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.bcV = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.bcW;
    }

    public void setTail(LinearLayout linearLayout) {
        this.bcW = linearLayout;
    }

    public TbImageView getIcon() {
        return this.aHg;
    }

    public void setIcon(TbImageView tbImageView) {
        this.aHg = tbImageView;
    }

    public TextView getFromSource() {
        return this.bcX;
    }

    public void setFromSource(TextView textView) {
        this.bcX = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.aHg.setAutoChangeStyle(z);
    }
}

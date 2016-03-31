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
    private TbImageView bem;
    private ChatClipImageItemView ccv;
    private LinearLayout ccw;
    private TextView ccx;

    public ChatImageWithTailView(Context context) {
        super(context);
        aq(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aq(context);
    }

    public void aq(Context context) {
        LayoutInflater.from(context).inflate(t.h.chat_image_with_tail_item, this);
        this.ccv = (ChatClipImageItemView) findViewById(t.g.img_msgitem_image_new);
        this.ccv.setContentDescription(getContext().getString(t.j.talk_pic));
        this.ccv.setDefaultResource(t.f.pic_image_h_not);
        this.ccw = (LinearLayout) findViewById(t.g.small_tail);
        this.bem = (TbImageView) findViewById(t.g.tail_icon);
        this.bem.setDefaultResource(t.f.icon);
        this.bem.setAutoChangeStyle(false);
        this.ccx = (TextView) findViewById(t.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.ccv;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.ccv = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.ccw;
    }

    public void setTail(LinearLayout linearLayout) {
        this.ccw = linearLayout;
    }

    public TbImageView getIcon() {
        return this.bem;
    }

    public void setIcon(TbImageView tbImageView) {
        this.bem = tbImageView;
    }

    public TextView getFromSource() {
        return this.ccx;
    }

    public void setFromSource(TextView textView) {
        this.ccx = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.bem.setAutoChangeStyle(z);
    }
}

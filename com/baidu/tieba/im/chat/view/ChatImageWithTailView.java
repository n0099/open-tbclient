package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView cWa;
    private ChatClipImageItemView enY;
    private LinearLayout enZ;
    private TextView eoa;

    public ChatImageWithTailView(Context context) {
        super(context);
        by(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        by(context);
    }

    public void by(Context context) {
        LayoutInflater.from(context).inflate(f.h.chat_image_with_tail_item, this);
        this.enY = (ChatClipImageItemView) findViewById(f.g.img_msgitem_image_new);
        this.enY.setContentDescription(getContext().getString(f.j.editor_image));
        this.enY.setDefaultResource(f.C0146f.pic_image_h_not);
        this.enZ = (LinearLayout) findViewById(f.g.small_tail);
        this.cWa = (TbImageView) findViewById(f.g.tail_icon);
        this.cWa.setDefaultResource(f.C0146f.icon);
        this.cWa.setAutoChangeStyle(false);
        this.eoa = (TextView) findViewById(f.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.enY;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.enY = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.enZ;
    }

    public void setTail(LinearLayout linearLayout) {
        this.enZ = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cWa;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cWa = tbImageView;
    }

    public TextView getFromSource() {
        return this.eoa;
    }

    public void setFromSource(TextView textView) {
        this.eoa = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cWa.setAutoChangeStyle(z);
    }
}

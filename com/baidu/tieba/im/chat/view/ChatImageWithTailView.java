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
    private TbImageView cLc;
    private ChatClipImageItemView dTX;
    private LinearLayout dTY;
    private TextView dTZ;

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
        this.dTX = (ChatClipImageItemView) findViewById(d.g.img_msgitem_image_new);
        this.dTX.setContentDescription(getContext().getString(d.k.editor_image));
        this.dTX.setDefaultResource(d.f.pic_image_h_not);
        this.dTY = (LinearLayout) findViewById(d.g.small_tail);
        this.cLc = (TbImageView) findViewById(d.g.tail_icon);
        this.cLc.setDefaultResource(d.f.icon);
        this.cLc.setAutoChangeStyle(false);
        this.dTZ = (TextView) findViewById(d.g.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.dTX;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.dTX = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.dTY;
    }

    public void setTail(LinearLayout linearLayout) {
        this.dTY = linearLayout;
    }

    public TbImageView getIcon() {
        return this.cLc;
    }

    public void setIcon(TbImageView tbImageView) {
        this.cLc = tbImageView;
    }

    public TextView getFromSource() {
        return this.dTZ;
    }

    public void setFromSource(TextView textView) {
        this.dTZ = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.cLc.setAutoChangeStyle(z);
    }
}

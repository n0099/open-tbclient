package com.baidu.tieba.im.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ChatImageWithTailView extends LinearLayout {
    private TbImageView fdt;
    private ChatClipImageItemView gCk;
    private LinearLayout gCl;
    private TextView gCm;

    public ChatImageWithTailView(Context context) {
        super(context);
        ap(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap(context);
    }

    public void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.chat_image_with_tail_item, this);
        this.gCk = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.gCk.setContentDescription(getContext().getString(R.string.editor_image));
        this.gCk.setDefaultResource(R.drawable.pic_image_h_not);
        this.gCl = (LinearLayout) findViewById(R.id.small_tail);
        this.fdt = (TbImageView) findViewById(R.id.tail_icon);
        this.fdt.setDefaultResource(R.drawable.icon);
        this.fdt.setAutoChangeStyle(false);
        this.gCm = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.gCk;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.gCk = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.gCl;
    }

    public void setTail(LinearLayout linearLayout) {
        this.gCl = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fdt;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fdt = tbImageView;
    }

    public TextView getFromSource() {
        return this.gCm;
    }

    public void setFromSource(TextView textView) {
        this.gCm = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fdt.setAutoChangeStyle(z);
    }
}

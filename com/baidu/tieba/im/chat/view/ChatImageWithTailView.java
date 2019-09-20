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
    private TbImageView ffG;
    private ChatClipImageItemView gET;
    private LinearLayout gEU;
    private TextView gEV;

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
        this.gET = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.gET.setContentDescription(getContext().getString(R.string.editor_image));
        this.gET.setDefaultResource(R.drawable.pic_image_h_not);
        this.gEU = (LinearLayout) findViewById(R.id.small_tail);
        this.ffG = (TbImageView) findViewById(R.id.tail_icon);
        this.ffG.setDefaultResource(R.drawable.icon);
        this.ffG.setAutoChangeStyle(false);
        this.gEV = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.gET;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.gET = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.gEU;
    }

    public void setTail(LinearLayout linearLayout) {
        this.gEU = linearLayout;
    }

    public TbImageView getIcon() {
        return this.ffG;
    }

    public void setIcon(TbImageView tbImageView) {
        this.ffG = tbImageView;
    }

    public TextView getFromSource() {
        return this.gEV;
    }

    public void setFromSource(TextView textView) {
        this.gEV = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.ffG.setAutoChangeStyle(z);
    }
}

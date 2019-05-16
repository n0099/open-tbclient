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
    private TbImageView eYr;
    private ChatClipImageItemView gvW;
    private LinearLayout gvX;
    private TextView gvY;

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
        this.gvW = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.gvW.setContentDescription(getContext().getString(R.string.editor_image));
        this.gvW.setDefaultResource(R.drawable.pic_image_h_not);
        this.gvX = (LinearLayout) findViewById(R.id.small_tail);
        this.eYr = (TbImageView) findViewById(R.id.tail_icon);
        this.eYr.setDefaultResource(R.drawable.icon);
        this.eYr.setAutoChangeStyle(false);
        this.gvY = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.gvW;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.gvW = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.gvX;
    }

    public void setTail(LinearLayout linearLayout) {
        this.gvX = linearLayout;
    }

    public TbImageView getIcon() {
        return this.eYr;
    }

    public void setIcon(TbImageView tbImageView) {
        this.eYr = tbImageView;
    }

    public TextView getFromSource() {
        return this.gvY;
    }

    public void setFromSource(TextView textView) {
        this.gvY = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.eYr.setAutoChangeStyle(z);
    }
}

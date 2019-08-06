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
    private TbImageView fdT;
    private ChatClipImageItemView gDc;
    private LinearLayout gDd;
    private TextView gDe;

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
        this.gDc = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.gDc.setContentDescription(getContext().getString(R.string.editor_image));
        this.gDc.setDefaultResource(R.drawable.pic_image_h_not);
        this.gDd = (LinearLayout) findViewById(R.id.small_tail);
        this.fdT = (TbImageView) findViewById(R.id.tail_icon);
        this.fdT.setDefaultResource(R.drawable.icon);
        this.fdT.setAutoChangeStyle(false);
        this.gDe = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.gDc;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.gDc = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.gDd;
    }

    public void setTail(LinearLayout linearLayout) {
        this.gDd = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fdT;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fdT = tbImageView;
    }

    public TextView getFromSource() {
        return this.gDe;
    }

    public void setFromSource(TextView textView) {
        this.gDe = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fdT.setAutoChangeStyle(z);
    }
}

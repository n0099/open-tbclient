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
    private TbImageView eYs;
    private ChatClipImageItemView gvZ;
    private LinearLayout gwa;
    private TextView gwb;

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
        this.gvZ = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.gvZ.setContentDescription(getContext().getString(R.string.editor_image));
        this.gvZ.setDefaultResource(R.drawable.pic_image_h_not);
        this.gwa = (LinearLayout) findViewById(R.id.small_tail);
        this.eYs = (TbImageView) findViewById(R.id.tail_icon);
        this.eYs.setDefaultResource(R.drawable.icon);
        this.eYs.setAutoChangeStyle(false);
        this.gwb = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.gvZ;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.gvZ = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.gwa;
    }

    public void setTail(LinearLayout linearLayout) {
        this.gwa = linearLayout;
    }

    public TbImageView getIcon() {
        return this.eYs;
    }

    public void setIcon(TbImageView tbImageView) {
        this.eYs = tbImageView;
    }

    public TextView getFromSource() {
        return this.gwb;
    }

    public void setFromSource(TextView textView) {
        this.gwb = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.eYs.setAutoChangeStyle(z);
    }
}

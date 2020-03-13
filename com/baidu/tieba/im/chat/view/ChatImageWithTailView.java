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
    private TbImageView gbB;
    private ChatClipImageItemView hvX;
    private LinearLayout hvY;
    private TextView hvZ;

    public ChatImageWithTailView(Context context) {
        super(context);
        initUI(context);
    }

    public ChatImageWithTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.chat_image_with_tail_item, this);
        this.hvX = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.hvX.setContentDescription(getContext().getString(R.string.editor_image));
        this.hvX.setDefaultResource(R.drawable.pic_image_h_not);
        this.hvY = (LinearLayout) findViewById(R.id.small_tail);
        this.gbB = (TbImageView) findViewById(R.id.tail_icon);
        this.gbB.setDefaultResource(R.drawable.tb_launcher_icon);
        this.gbB.setAutoChangeStyle(false);
        this.hvZ = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.hvX;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.hvX = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.hvY;
    }

    public void setTail(LinearLayout linearLayout) {
        this.hvY = linearLayout;
    }

    public TbImageView getIcon() {
        return this.gbB;
    }

    public void setIcon(TbImageView tbImageView) {
        this.gbB = tbImageView;
    }

    public TextView getFromSource() {
        return this.hvZ;
    }

    public void setFromSource(TextView textView) {
        this.hvZ = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.gbB.setAutoChangeStyle(z);
    }
}

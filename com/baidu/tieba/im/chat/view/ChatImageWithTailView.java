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
    private TbImageView fgY;
    private ChatClipImageItemView kwo;
    private LinearLayout kwp;
    private TextView kwq;

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
        this.kwo = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.kwo.setContentDescription(getContext().getString(R.string.editor_image));
        this.kwo.setDefaultResource(R.drawable.pic_image_h_not);
        this.kwp = (LinearLayout) findViewById(R.id.small_tail);
        this.fgY = (TbImageView) findViewById(R.id.tail_icon);
        this.fgY.setDefaultResource(R.drawable.tb_launcher_icon);
        this.fgY.setAutoChangeStyle(false);
        this.kwq = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.kwo;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.kwo = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.kwp;
    }

    public void setTail(LinearLayout linearLayout) {
        this.kwp = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fgY;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fgY = tbImageView;
    }

    public TextView getFromSource() {
        return this.kwq;
    }

    public void setFromSource(TextView textView) {
        this.kwq = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fgY.setAutoChangeStyle(z);
    }
}

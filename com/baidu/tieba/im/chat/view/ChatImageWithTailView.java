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
    private TbImageView euY;
    private ChatClipImageItemView jsF;
    private LinearLayout jsG;
    private TextView jsH;

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
        this.jsF = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.jsF.setContentDescription(getContext().getString(R.string.editor_image));
        this.jsF.setDefaultResource(R.drawable.pic_image_h_not);
        this.jsG = (LinearLayout) findViewById(R.id.small_tail);
        this.euY = (TbImageView) findViewById(R.id.tail_icon);
        this.euY.setDefaultResource(R.drawable.tb_launcher_icon);
        this.euY.setAutoChangeStyle(false);
        this.jsH = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.jsF;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.jsF = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.jsG;
    }

    public void setTail(LinearLayout linearLayout) {
        this.jsG = linearLayout;
    }

    public TbImageView getIcon() {
        return this.euY;
    }

    public void setIcon(TbImageView tbImageView) {
        this.euY = tbImageView;
    }

    public TextView getFromSource() {
        return this.jsH;
    }

    public void setFromSource(TextView textView) {
        this.jsH = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.euY.setAutoChangeStyle(z);
    }
}

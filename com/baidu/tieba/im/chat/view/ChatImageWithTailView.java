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
    private TbImageView eiW;
    private ChatClipImageItemView iUW;
    private LinearLayout iUX;
    private TextView iUY;

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
        this.iUW = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.iUW.setContentDescription(getContext().getString(R.string.editor_image));
        this.iUW.setDefaultResource(R.drawable.pic_image_h_not);
        this.iUX = (LinearLayout) findViewById(R.id.small_tail);
        this.eiW = (TbImageView) findViewById(R.id.tail_icon);
        this.eiW.setDefaultResource(R.drawable.tb_launcher_icon);
        this.eiW.setAutoChangeStyle(false);
        this.iUY = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.iUW;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.iUW = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.iUX;
    }

    public void setTail(LinearLayout linearLayout) {
        this.iUX = linearLayout;
    }

    public TbImageView getIcon() {
        return this.eiW;
    }

    public void setIcon(TbImageView tbImageView) {
        this.eiW = tbImageView;
    }

    public TextView getFromSource() {
        return this.iUY;
    }

    public void setFromSource(TextView textView) {
        this.iUY = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.eiW.setAutoChangeStyle(z);
    }
}

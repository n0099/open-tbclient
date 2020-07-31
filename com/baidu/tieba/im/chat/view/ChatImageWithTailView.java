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
    private ChatClipImageItemView iUU;
    private LinearLayout iUV;
    private TextView iUW;

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
        this.iUU = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.iUU.setContentDescription(getContext().getString(R.string.editor_image));
        this.iUU.setDefaultResource(R.drawable.pic_image_h_not);
        this.iUV = (LinearLayout) findViewById(R.id.small_tail);
        this.eiW = (TbImageView) findViewById(R.id.tail_icon);
        this.eiW.setDefaultResource(R.drawable.tb_launcher_icon);
        this.eiW.setAutoChangeStyle(false);
        this.iUW = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.iUU;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.iUU = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.iUV;
    }

    public void setTail(LinearLayout linearLayout) {
        this.iUV = linearLayout;
    }

    public TbImageView getIcon() {
        return this.eiW;
    }

    public void setIcon(TbImageView tbImageView) {
        this.eiW = tbImageView;
    }

    public TextView getFromSource() {
        return this.iUW;
    }

    public void setFromSource(TextView textView) {
        this.iUW = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.eiW.setAutoChangeStyle(z);
    }
}

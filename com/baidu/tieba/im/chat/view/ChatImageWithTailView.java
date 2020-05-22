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
    private TbImageView ham;
    private ChatClipImageItemView ivZ;
    private LinearLayout iwa;
    private TextView iwb;

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
        this.ivZ = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.ivZ.setContentDescription(getContext().getString(R.string.editor_image));
        this.ivZ.setDefaultResource(R.drawable.pic_image_h_not);
        this.iwa = (LinearLayout) findViewById(R.id.small_tail);
        this.ham = (TbImageView) findViewById(R.id.tail_icon);
        this.ham.setDefaultResource(R.drawable.tb_launcher_icon);
        this.ham.setAutoChangeStyle(false);
        this.iwb = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.ivZ;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.ivZ = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.iwa;
    }

    public void setTail(LinearLayout linearLayout) {
        this.iwa = linearLayout;
    }

    public TbImageView getIcon() {
        return this.ham;
    }

    public void setIcon(TbImageView tbImageView) {
        this.ham = tbImageView;
    }

    public TextView getFromSource() {
        return this.iwb;
    }

    public void setFromSource(TextView textView) {
        this.iwb = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.ham.setAutoChangeStyle(z);
    }
}

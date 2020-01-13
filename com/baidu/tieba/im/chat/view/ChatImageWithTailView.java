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
    private TbImageView fZm;
    private ChatClipImageItemView htK;
    private LinearLayout htL;
    private TextView htM;

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
        this.htK = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.htK.setContentDescription(getContext().getString(R.string.editor_image));
        this.htK.setDefaultResource(R.drawable.pic_image_h_not);
        this.htL = (LinearLayout) findViewById(R.id.small_tail);
        this.fZm = (TbImageView) findViewById(R.id.tail_icon);
        this.fZm.setDefaultResource(R.drawable.tb_launcher_icon);
        this.fZm.setAutoChangeStyle(false);
        this.htM = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.htK;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.htK = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.htL;
    }

    public void setTail(LinearLayout linearLayout) {
        this.htL = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fZm;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fZm = tbImageView;
    }

    public TextView getFromSource() {
        return this.htM;
    }

    public void setFromSource(TextView textView) {
        this.htM = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fZm.setAutoChangeStyle(z);
    }
}

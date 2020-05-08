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
    private TbImageView gLA;
    private ChatClipImageItemView ihq;
    private LinearLayout ihr;
    private TextView ihs;

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
        this.ihq = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.ihq.setContentDescription(getContext().getString(R.string.editor_image));
        this.ihq.setDefaultResource(R.drawable.pic_image_h_not);
        this.ihr = (LinearLayout) findViewById(R.id.small_tail);
        this.gLA = (TbImageView) findViewById(R.id.tail_icon);
        this.gLA.setDefaultResource(R.drawable.tb_launcher_icon);
        this.gLA.setAutoChangeStyle(false);
        this.ihs = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.ihq;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.ihq = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.ihr;
    }

    public void setTail(LinearLayout linearLayout) {
        this.ihr = linearLayout;
    }

    public TbImageView getIcon() {
        return this.gLA;
    }

    public void setIcon(TbImageView tbImageView) {
        this.gLA = tbImageView;
    }

    public TextView getFromSource() {
        return this.ihs;
    }

    public void setFromSource(TextView textView) {
        this.ihs = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.gLA.setAutoChangeStyle(z);
    }
}

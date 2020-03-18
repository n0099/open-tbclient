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
    private TbImageView gcj;
    private ChatClipImageItemView hxx;
    private LinearLayout hxy;
    private TextView hxz;

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
        this.hxx = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.hxx.setContentDescription(getContext().getString(R.string.editor_image));
        this.hxx.setDefaultResource(R.drawable.pic_image_h_not);
        this.hxy = (LinearLayout) findViewById(R.id.small_tail);
        this.gcj = (TbImageView) findViewById(R.id.tail_icon);
        this.gcj.setDefaultResource(R.drawable.tb_launcher_icon);
        this.gcj.setAutoChangeStyle(false);
        this.hxz = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.hxx;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.hxx = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.hxy;
    }

    public void setTail(LinearLayout linearLayout) {
        this.hxy = linearLayout;
    }

    public TbImageView getIcon() {
        return this.gcj;
    }

    public void setIcon(TbImageView tbImageView) {
        this.gcj = tbImageView;
    }

    public TextView getFromSource() {
        return this.hxz;
    }

    public void setFromSource(TextView textView) {
        this.hxz = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.gcj.setAutoChangeStyle(z);
    }
}

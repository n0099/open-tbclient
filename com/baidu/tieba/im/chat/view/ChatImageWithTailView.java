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
    private TbImageView fWd;
    private ChatClipImageItemView hqh;
    private LinearLayout hqi;
    private TextView hqj;

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
        this.hqh = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.hqh.setContentDescription(getContext().getString(R.string.editor_image));
        this.hqh.setDefaultResource(R.drawable.pic_image_h_not);
        this.hqi = (LinearLayout) findViewById(R.id.small_tail);
        this.fWd = (TbImageView) findViewById(R.id.tail_icon);
        this.fWd.setDefaultResource(R.drawable.tb_launcher_icon);
        this.fWd.setAutoChangeStyle(false);
        this.hqj = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.hqh;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.hqh = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.hqi;
    }

    public void setTail(LinearLayout linearLayout) {
        this.hqi = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fWd;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fWd = tbImageView;
    }

    public TextView getFromSource() {
        return this.hqj;
    }

    public void setFromSource(TextView textView) {
        this.hqj = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fWd.setAutoChangeStyle(z);
    }
}

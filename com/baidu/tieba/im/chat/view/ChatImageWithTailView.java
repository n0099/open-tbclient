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
    private TbImageView gLu;
    private ChatClipImageItemView ihk;
    private LinearLayout ihl;
    private TextView ihm;

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
        this.ihk = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.ihk.setContentDescription(getContext().getString(R.string.editor_image));
        this.ihk.setDefaultResource(R.drawable.pic_image_h_not);
        this.ihl = (LinearLayout) findViewById(R.id.small_tail);
        this.gLu = (TbImageView) findViewById(R.id.tail_icon);
        this.gLu.setDefaultResource(R.drawable.tb_launcher_icon);
        this.gLu.setAutoChangeStyle(false);
        this.ihm = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.ihk;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.ihk = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.ihl;
    }

    public void setTail(LinearLayout linearLayout) {
        this.ihl = linearLayout;
    }

    public TbImageView getIcon() {
        return this.gLu;
    }

    public void setIcon(TbImageView tbImageView) {
        this.gLu = tbImageView;
    }

    public TextView getFromSource() {
        return this.ihm;
    }

    public void setFromSource(TextView textView) {
        this.ihm = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.gLu.setAutoChangeStyle(z);
    }
}

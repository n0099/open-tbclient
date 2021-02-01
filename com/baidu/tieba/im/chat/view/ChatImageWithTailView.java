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
    private TbImageView fjr;
    private ChatClipImageItemView kEu;
    private LinearLayout kEv;
    private TextView kEw;

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
        this.kEu = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.kEu.setContentDescription(getContext().getString(R.string.editor_image));
        this.kEu.setDefaultResource(R.drawable.pic_image_h_not);
        this.kEv = (LinearLayout) findViewById(R.id.small_tail);
        this.fjr = (TbImageView) findViewById(R.id.tail_icon);
        this.fjr.setDefaultResource(R.drawable.tb_launcher_icon);
        this.fjr.setAutoChangeStyle(false);
        this.kEw = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.kEu;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.kEu = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.kEv;
    }

    public void setTail(LinearLayout linearLayout) {
        this.kEv = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fjr;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fjr = tbImageView;
    }

    public TextView getFromSource() {
        return this.kEw;
    }

    public void setFromSource(TextView textView) {
        this.kEw = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fjr.setAutoChangeStyle(z);
    }
}

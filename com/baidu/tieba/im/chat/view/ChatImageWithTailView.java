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
    private ChatClipImageItemView kEI;
    private LinearLayout kEJ;
    private TextView kEK;

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
        this.kEI = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.kEI.setContentDescription(getContext().getString(R.string.editor_image));
        this.kEI.setDefaultResource(R.drawable.pic_image_h_not);
        this.kEJ = (LinearLayout) findViewById(R.id.small_tail);
        this.fjr = (TbImageView) findViewById(R.id.tail_icon);
        this.fjr.setDefaultResource(R.drawable.tb_launcher_icon);
        this.fjr.setAutoChangeStyle(false);
        this.kEK = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.kEI;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.kEI = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.kEJ;
    }

    public void setTail(LinearLayout linearLayout) {
        this.kEJ = linearLayout;
    }

    public TbImageView getIcon() {
        return this.fjr;
    }

    public void setIcon(TbImageView tbImageView) {
        this.fjr = tbImageView;
    }

    public TextView getFromSource() {
        return this.kEK;
    }

    public void setFromSource(TextView textView) {
        this.kEK = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.fjr.setAutoChangeStyle(z);
    }
}

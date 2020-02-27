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
    private TbImageView gbm;
    private ChatClipImageItemView hvJ;
    private LinearLayout hvK;
    private TextView hvL;

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
        this.hvJ = (ChatClipImageItemView) findViewById(R.id.img_msgitem_image_new);
        this.hvJ.setContentDescription(getContext().getString(R.string.editor_image));
        this.hvJ.setDefaultResource(R.drawable.pic_image_h_not);
        this.hvK = (LinearLayout) findViewById(R.id.small_tail);
        this.gbm = (TbImageView) findViewById(R.id.tail_icon);
        this.gbm.setDefaultResource(R.drawable.tb_launcher_icon);
        this.gbm.setAutoChangeStyle(false);
        this.hvL = (TextView) findViewById(R.id.tail_game_from);
    }

    public ChatClipImageItemView getImage() {
        return this.hvJ;
    }

    public void setImage(ChatClipImageItemView chatClipImageItemView) {
        this.hvJ = chatClipImageItemView;
    }

    public LinearLayout getTail() {
        return this.hvK;
    }

    public void setTail(LinearLayout linearLayout) {
        this.hvK = linearLayout;
    }

    public TbImageView getIcon() {
        return this.gbm;
    }

    public void setIcon(TbImageView tbImageView) {
        this.gbm = tbImageView;
    }

    public TextView getFromSource() {
        return this.hvL;
    }

    public void setFromSource(TextView textView) {
        this.hvL = textView;
    }

    public void setIsSupportNight(boolean z) {
        this.gbm.setAutoChangeStyle(z);
    }
}
